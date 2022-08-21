package services;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
 * Servlet implementation class ClassReport
 */
public class ClassReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassReport() {
        super();
        // TODO Auto-generated constructor stub
    }
    List<Object> subData(String cl){
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		List<Object> list=session.createSQLQuery("select distinct(subname) "
				                               + "from class_subjects "
				                               + "join class on class_subjects.classId=class.classId "
				                               + "join subject on class_subjects.SubId=subject.SubId "
				                               + "where Cla_ss="+"\""+cl+"\"").list(); 
		
		for(Object obj:list) {
			obj.toString();
		}
		
		session.getTransaction().commit();
		

		session.close();
		return list;

	}
 /*-------------------------------------------------------------------------------------------*/   
    List<Object> teachData(String cl){
 		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
 		Session session = sessionFactory.openSession();
 		session.beginTransaction();
 		
 		List<Object> list=session.createSQLQuery("select distinct(t_name) "
 				                               + "from class_teachers "
 				                               + "join class on class_teachers.classId=class.classId "
 				                               + "join teacher on class_teachers.teachId=teacher.teachId "
 				                               + "where Cla_ss="+"\""+cl+"\"").list(); 
 		
 		for(Object obj:list) {
 			obj.toString();
 		}
 		
 		session.getTransaction().commit();
 		

 		session.close();
 		return list;

 	}
    
    List<Object> studData(String cl){
  		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
  		Session session = sessionFactory.openSession();
  		session.beginTransaction();
  		
  		List<Object> list=session.createSQLQuery("select st_name "
  				                               + "from class_students "
  				                               + "join class on class_students.classId=class.classId "
  				                               + "join student on class_students.studId=student.studId "
  				                               + "where Cla_ss="+"\""+cl+"\"").list(); 
  		
  		for(Object obj:list) {
  			obj.toString();
  		}
  		
  		session.getTransaction().commit();
  		

  		session.close();
  		return list;

  	}
/*-------------------------------------------------------------------------------------------------*/
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession(false); 
		PrintWriter out=response.getWriter();
		 String cs= (String) session.getAttribute("Class");
		 
		 List<Object> sublist= subData(cs);
		 out.println("Subjects are: ");
		 for(Object obj:sublist) {
			 out.println(obj.toString());
		 }
		 
		 out.println("");
		 out.println("");
		 List<Object> tlist= teachData(cs);
		 out.println("Teachers are: ");
		 for(Object obj:tlist) {
			 out.println(obj.toString());
		 }
		 out.println("");
		 out.println("");
		 List<Object> slist= studData(cs);
		 out.println("Students are:");
		 for(Object obj:slist) {
			 out.println(obj.toString());
		 }
		 
		 
	}

}
