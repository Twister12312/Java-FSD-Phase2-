package services;
import beans.ProductDetails;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//import



/**
 * Servlet implementation class TestServlet
 */
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    int register(ProductDetails user){
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		 int i=(Integer)session.save(user);
		session.getTransaction().commit();

		session.close();
		return i;

	}
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProductDetails p1=new ProductDetails();
		String name = request.getParameter("name");
		String price= request.getParameter("price");
		PrintWriter out = response.getWriter();
		RequestDispatcher rd;
		int flag=0;
		try{int pri_ce=Integer.parseInt(price);
		p1.setProduct_name(name);    
		 p1.setPrice(pri_ce);
		 flag=1;}
		catch(Exception e) {
			out.println("<html><body>");
			out.println("Wrong input for price, please enter a number!");
			rd=request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
			out.println("</body></html>");
		}
		
		 int i = 0;
		 //
		 if(flag==1)i=register(p1);
		 
					if(i>0)
						out.println("Record Inserted");
					else
						out.println("Record not Inserted");
		 
		 
	}

}
