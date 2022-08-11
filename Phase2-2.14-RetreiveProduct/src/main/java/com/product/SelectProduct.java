package com.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class SelectProduct
 */
@WebServlet("/SelectProduct")
public class SelectProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int Id=Integer.parseInt(request.getParameter("id"));
		PrintWriter out=response.getWriter();//getwriter
		try{Connection con=DBConnection.getConnection();
		String str="select * from product where productid=?";//delete
		PreparedStatement  ps=con.prepareStatement(str);//prepare query
		ps.setInt(1,Id );
		//int ans =ps.executeUpdate();
		/*if(rs.next()==false) {
        	out.println("Sorry the given id is not in the database.");
        	
        }*/	
	     int flag=0;
		 try (ResultSet rs = ps.executeQuery();) {
		        while (rs.next()) {
		        	flag=1;
		        	out.println("<table border=2>");
					out.println("<tr><th>ProductID</th><th>Product_name</th><th>Price</th><th>Quantity</th></tr>");
		        	out.println("<tr>");
					out.print("<td>"+rs.getInt("productid")+"</td>");
					out.print("<td>"+rs.getString("product_name")+"</td>");
					out.print("<td>"+rs.getInt("price")+"</td>");
					out.print("<td>"+rs.getInt("quantity")+"</td>");
					out.println("</tr>");
					 out.println("</table>");//table
					
		        }
		        if(flag==0) {
		        	out.println("<h1>Sorry, the entered id does not exist!</h1>");
		        }
		        
		      }		
		
		//close connection
		con.close();//close
		}
		
		catch(Exception e) {
			out.println("Record not searched");
			e.printStackTrace();//printstacktrace
		}
	}

}
