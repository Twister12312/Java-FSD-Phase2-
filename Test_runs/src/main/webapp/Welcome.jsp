<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Welcome</h2>
	<%
	
	Set<String> classes=new HashSet<String>();
	
	Set<String> subjects=new HashSet<String>();
	
	Set<String> teachers=new HashSet<String>();
	
	Set<String> students= new HashSet<String>();
	students.add("Vikram");
	students.add("Anjali");
	students.add("John");
	students.add("Ria");
	students.add("Vibhor");
	students.add("Nikhil");
	students.add("Lakshmi");
	
	session.setAttribute("PermClass",classes);
	session.setAttribute("PermSubj",subjects);
	session.setAttribute("PermTeach", teachers);
	session.setAttribute("PermStud",students);
	%>
	<a href="MainInterface.jsp">Jump to main interface</a> <br>
</body>
</html>