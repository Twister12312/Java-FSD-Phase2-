package services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Product;
/**
 * Servlet implementation class TestServ
 */
@WebServlet("/TestServ")
public class TestServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("name");
		String pri_ce=request.getParameter("price");
		int price= Integer.parseInt(pri_ce);
		PrintWriter out= response.getWriter();
		HttpSession session=request.getSession(); 
		Product p1= new Product();
		p1.setName(name);
		p1.setPrice(price);
		session.setAttribute("product", p1);
		out.println("<html><body>");
		out.println("<a href='details.jsp'> Go to second JSP </a>");
		out.println("</body></html>");
	}

}
