package com.product;
import java.sql.*;
public class DBConnection {
	   static Connection con=null;
	   public static Connection getConnection() {
		   //load driver class
		   try{Class.forName("com.mysql.cj.jdbc.Driver");
		   //step2: create connection object
		   String url="jdbc:mysql://localhost:3306/practice";
		   String user = "root";
	       String password = "Admin@123!";
	       con = DriverManager.getConnection(url, user, password);}
		   catch(Exception e) {
			   e.printStackTrace();
		   }
	       
	       return con;
	   }
}
