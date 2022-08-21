<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="beans.Product" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%request.getSession(false);
Product p2=new Product();
p2= (Product)session.getAttribute("product");
out.println("Product name:"+p2.getName()+"<br>"+"Price: "+p2.getPrice()+"<br>");
session.invalidate();
out.println("<a href='index.jsp'>Logout to go back</a><br>");
%>
</body>
</html>