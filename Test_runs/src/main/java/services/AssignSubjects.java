package services;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import beans.Class;
import beans.Subject;
import beans.Teacher;

/**
 * Servlet implementation class AssignSubjects
 */
public class AssignSubjects extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignSubjects() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	void register(Class cL){
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(cL);
		
		
		session.getTransaction().commit();
	}
    
	   
   void modify(Class cL,Subject s1){
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Class temp= (Class)session.get(Class.class, cL.getClassId());
		temp.addSubject(s1);
		
		session.save(temp);
		
		
		session.getTransaction().commit();
	}


   /*-----------------------------------------------------------------------------------------*/ 
    List<Class> ClassData(){
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		List<Class> list=session.createQuery("FROM Class").list(); 
		
		for(Class xclass:list) {
			for(Teacher teacher: xclass.getTeachers()) {}
			for(Subject subject: xclass.getSubjects()) {}
		}
		
		session.getTransaction().commit();
		

		session.close();
		return list;

	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
   /*-----------------------------------------------------------------------------------------------*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 HttpSession session=request.getSession(false); 
		 
		 
		 PrintWriter out=response.getWriter();
		 String cs= (String) session.getAttribute("Class");
		 String sb= (String) session.getAttribute("Subject");
		
		 
		 Class c1=new Class();
		 c1.setCla_ss(cs);
	
		 Subject s1=new Subject();
		 s1.setSubname(sb);
		 
		 List<Class> list=ClassData();
		
		 int flag=0;
		
		  if(list!=null) {  
			
		repeat:	for(Class cls : list) {
				if (c1.getCla_ss().equals(cls.getCla_ss())) {
					flag=1;
			        
					if(cls.getSubjects()!=null) {
						Set<Subject> temp=new HashSet<Subject>();
						 temp=cls.getSubjects();
						for(Subject s:temp) {
							if(s.getSubname()!=null) {
								if(s.getSubname().equals(s1.getSubname())) {
									out.println("Sorry already exists");
									break repeat;
								}
							}
					}
						
					}//for loop end
					cls.addSubject(s1);
					s1.addClass(cls);
					
					modify(cls,s1);
				}//end of if
				
			}// end of outer for
		  }
			if(flag==0) {
				c1.addSubject(s1);
				s1.addClass(c1);
				out.println("Record inserted");
				register(c1);
			}
	/*---------------------------------------------------------------------------------------------*/		
			
			
		 }
	}


