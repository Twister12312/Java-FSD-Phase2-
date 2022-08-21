<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Class report</h2><br>
<form>
  Enter Class:<input type="text"  name="class"><br>
  <input type="submit" value="submit"><br>
  </form>
  
   <%
  request.getSession(false);
String cls=request.getParameter("class");

Set<String> classes=new HashSet<String>();
classes=(Set<String>)session.getAttribute("PermClass");

Set<String> subjects=new HashSet<String>();
subjects= (Set<String>)session.getAttribute("PermSubj");
if(cls!=null){
  if(classes.contains(cls)){
	  session.setAttribute("Class", cls);
	  response.sendRedirect("ClassReport");
  }
  else{
	  out.println("Please try again");			  
  }
}
%>
</body>
</html>