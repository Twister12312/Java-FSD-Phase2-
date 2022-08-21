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
<h2>Assign subjects to a class</h2><br>
<form>
  Enter Class:<input type="text"  name="class"><br>
  Enter Subject<input type="text"  name="sub"><br>
  <input type="submit" value="submit"><br>
  </form>
  <%
  request.getSession(false);
String cls=request.getParameter("class");
String sub=request.getParameter("sub");
Set<String> classes=new HashSet<String>();
classes=(Set<String>)session.getAttribute("PermClass");

Set<String> subjects=new HashSet<String>();
subjects= (Set<String>)session.getAttribute("PermSubj");
if(cls!=null&&sub!=null){
  if(classes.contains(cls)&&subjects.contains(sub)){
	  session.setAttribute("Class", cls);
	  session.setAttribute("Subject", sub);
	  response.sendRedirect("AssignSubjects");
  }
  else{
	  out.println("Please try again");			  
  }
}

%>
<a href="MainInterface.jsp"> Try again </a>

</body>
</html>