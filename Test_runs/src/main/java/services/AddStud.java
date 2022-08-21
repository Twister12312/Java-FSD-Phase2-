package services;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import beans.Class;
import beans.Student;
import beans.Subject;
import beans.Teacher;

/**
 * Servlet implementation class AddStud
 */
public class AddStud extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStud() {
        super();
        // TODO Auto-generated constructor stub
    }
    
 void modify(Class cL,Set<Student> s1){
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Class temp= (Class)session.get(Class.class, cL.getClassId());
		temp.setStudents(s1);
		
		session.save(temp);
		
		
		session.getTransaction().commit();
	}
    
    
    
    List<Class> ClassData(){
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		List<Class> list=session.createQuery("FROM Class").list(); 
		
		for(Class xclass:list) {
			for(Teacher teacher: xclass.getTeachers()) {}
			for(Subject subject: xclass.getSubjects()) {}
			for(Student student:xclass.getStudents()) {}
		}
		
		session.getTransaction().commit();
		

		session.close();
		return list;

	}
  /*------------------------------------------------------------------------------------------------*/
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Set<Student> students1= new HashSet<Student>();
		Set<Student> students2= new HashSet<Student>();
		
		Student s1= new Student();
		s1.setSt_name("Vikram");
		Student s2= new Student();
		s2.setSt_name("Anjali");
		Student s3= new Student();
		s3.setSt_name("John");
		Student s4= new Student();
		s4.setSt_name("Ria");
		
		students1.add(s1);
		students1.add(s2);
		students1.add(s3);
		students1.add(s4);
		
		
		Student s5= new Student();
		s5.setSt_name("Vibhor");
		Student s6= new Student();
		s6.setSt_name("Nikhil");
		Student s7= new Student();
		s7.setSt_name("Lakshmi");
		
		students2.add(s5);
		students2.add(s6);
		students2.add(s7);
		
		
		List<Class> list=ClassData();
		
		if(list!=null) {
			for(Class cls:list) {
				
				if(cls.getCla_ss().equals("Science")) {
					cls.setStudents(students1);
					modify(cls,students1);
				}
				
				if(cls.getCla_ss().equals("Commerce")) {
					cls.setStudents(students2);
					modify(cls,students2);
				}
				
			}
			
			
		}
		
		
	}

}
