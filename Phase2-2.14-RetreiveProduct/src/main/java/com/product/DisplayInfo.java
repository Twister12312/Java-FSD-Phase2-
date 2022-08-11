package com.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class DisplayInfo
 */
@WebServlet("/DisplayInfo")
public class DisplayInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Connection con= DBConnection.getConnection();
			String qry="select*from product";
			Statement stmt= con.createStatement();
			ResultSet rs=stmt.executeQuery(qry);
			PrintWriter out= response.getWriter();
			out.println("<table border=2>");
			out.println("<tr><th>ProductID</th><th>Product_name</th><th>Price</th><th>Quantity</th></tr>");
			while(rs.next()){
				out.println("<tr>");
				out.print("<td>"+rs.getInt("productid")+"</td>");
				out.print("<td>"+rs.getString("product_name")+"</td>");
				out.print("<td>"+rs.getInt("price")+"</td>");
				out.print("<td>"+rs.getInt("quantity")+"</td>");
				out.println("</tr>");
				//queryprint
			}
			out.println("</table>");
			con.close();
			
			}
			
			catch(Exception e) {
				e.printStackTrace();
			}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
