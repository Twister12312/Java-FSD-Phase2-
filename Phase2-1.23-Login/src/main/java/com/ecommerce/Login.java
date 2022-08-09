package com.ecommerce;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String email= request.getParameter("userId");
		String passw= request.getParameter("pass");
		RequestDispatcher rd;
		out.println("<html><body>");
		if(email.equals("abcd@gmail.com") && passw.equals("123")) {
			//successful login
			HttpSession session=request.getSession();  
		    session.setAttribute("userid",  email);
		    out.println("Successful Login!<br>");
		    out.println("<a href='dashboard'>Dashboard</a><br>");
			//response.sendRedirect("dashboard"); 
		}
		//out.println("</body></html>");
		//added else
		else {
		    out.println("Login failed! Please try again.<br>");
			rd=request.getRequestDispatcher("index.html");
			rd.include(request, response);
			//out.println("<a href='index.html'>Go back to login</a><br>");//go back to login
			//out.println("</body></html>");}
		}
			out.println("</body></html>");
	

}
}
