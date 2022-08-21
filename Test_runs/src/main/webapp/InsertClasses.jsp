<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<h2>Insert class to list</h2><br>
<body>
<form>
  Enter Class:<input type="text"  name="class"><br>
  <input type="submit" value="submit"><br>
  </form>
<%
request.getSession(false);
String cls=request.getParameter("class");
Set<String> classes=new HashSet<String>();
classes=(Set<String>)session.getAttribute("PermClass");
if(cls!=null){
if(classes.contains(cls)){
	out.println("Already inserted!, Please try again");
}
else{
	classes.add(cls);
	out.println("Inserted!");
	session.setAttribute("PermClass", classes);
}
}
%>  
 <a href="MainInterface.jsp"> Go back</a>
</body>
</html>