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
 * Servlet implementation class AssTeachers
 */
public class AssTeachers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssTeachers() {
        super();
        // TODO Auto-generated constructor stub
    }
   
void register(Class cL){
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(cL);
		
		
		session.getTransaction().commit();
		session.close();
	}
    
void register2(Teacher t){
	
	SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
	Session session=sessionFactory.openSession();
	session.beginTransaction();
	
	session.save(t);
	
	
	session.getTransaction().commit();
	session.close();
}

   void modify(Class cL,Teacher t1){
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Class temp= (Class)session.get(Class.class, cL.getClassId());
		temp.addTeacher(t1);
		
		session.save(temp);
		
		
		session.getTransaction().commit();
		session.close();
	}
   
   void modify2(Teacher t,Subject s1){
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Teacher temp= (Teacher)session.get(Teacher.class, t.getTeachId());
		temp.addSubject(s1);
		
		session.save(temp);
		
		
		session.getTransaction().commit();
		session.close();
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
    
    List<Teacher> TeachData(){
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		List<Teacher> list=session.createQuery("FROM Teacher").list(); 
		
		for(Teacher xteach:list) {
			for(Subject subject: xteach.getSubjects()) {}
		}
		
		session.getTransaction().commit();
		

		session.close();
		return list;

	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession(false); 
		 
		 
		 PrintWriter out=response.getWriter();
		 String cs= (String) session.getAttribute("Class");
		 String sb= (String) session.getAttribute("Subject");
		 String tch= (String) session.getAttribute("Teacher");
		 
		 Class c1=new Class();
		 c1.setCla_ss(cs);
	
		 Subject s1=new Subject();
		 s1.setSubname(sb);
		 
		 Teacher t1=new Teacher();
		 t1.setT_name(tch);
		 
		 List<Class> list=ClassData();
		 List <Teacher> list2= TeachData();
		 int flag=0;
		 int flag2=0;
		  if(list!=null) {  
			
		repeat:	for(Class cls : list) {
				if (c1.getCla_ss().equals(cls.getCla_ss())) {
					flag=1;
			        
					if(cls.getTeachers()!=null) {
						
						for(Teacher t:list2) {
							if(t.getT_name()!=null) {
								if(t.getT_name().equals(t1.getT_name())) {
									flag2=1;
									Set<Subject> temp1=new HashSet<Subject>();
									 temp1=t.getSubjects();
									 for(Subject s:temp1) {
										 if(s.getSubname().equals(s1.getSubname())) {
											 out.println("Sorry already exists");
												break repeat;
										 }
									 }//innermost for loop end
									t.addSubject(s1);
									s1.addTeacher(t);
									modify2(t,s1);
								}
							}
	
							
					}
						
					}
					if(flag2==0) {
						t1.addSubject(s1);
						s1.addTeacher(t1);
						register2(t1);
					}
					
					cls.addTeacher(t1);
					t1.addClass(cls);
					modify(cls,t1);
					out.println("Record inserted");
				}//end of if
				
			}
		
		 
		 
	}
			if(flag==0) {
				c1.addTeacher(t1);
				t1.addClass(c1);
				out.println("Record inserted");
				register(c1);
			}

}
}
