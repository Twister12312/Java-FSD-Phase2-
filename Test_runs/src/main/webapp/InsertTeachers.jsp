<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<h2>Insert teacher to list</h2>
<body>
<form>
  Enter Teacher:<input type="text"  name="class"><br>
  <input type="submit" value="submit"><br>
  </form>
  
  <%
request.getSession(false);
String cls=request.getParameter("class");
Set<String> teachers=new HashSet<String>();
teachers=(Set<String>)session.getAttribute("PermTeach");
if(cls!=null){
if(teachers.contains(cls)){
	out.println("Already inserted!, Please try again");
}
else{
	teachers.add(cls);
	out.println("Inserted!");
	session.setAttribute("PermTeach", teachers);
}
}
%>  
<a href="MainInterface.jsp"> Go back</a>
</body>
</html>