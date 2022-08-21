<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<h2>Assign teachers to a class and subject</h2><br>
<form>
  Enter Class:<input type="text"  name="class"><br>
  Enter Subject:<input type="text"  name="sub"><br>
  Enter Teacher:<input type="text"  name="teach"><br>
  <input type="submit" value="submit"><br>
  </form>
  <%
  request.getSession(false);
String cls=request.getParameter("class");
String sub=request.getParameter("sub");
String tch=request.getParameter("teach");
Set<String> classes=new HashSet<String>();
classes=(Set<String>)session.getAttribute("PermClass");

Set<String> subjects=new HashSet<String>();
subjects= (Set<String>)session.getAttribute("PermSubj");

Set<String> teachers=new HashSet<String>();
teachers= (Set<String>)session.getAttribute("PermTeach");
if(cls!=null&&sub!=null&&tch!=null){
  if(classes.contains(cls)&&subjects.contains(sub)&&teachers.contains(tch)){
	  session.setAttribute("Class", cls);
	  session.setAttribute("Subject", sub);
	  session.setAttribute("Teacher", tch);
	  response.sendRedirect("AssTeachers");
  }
  else{
	  out.println("Please try again");			  
  }
}

%>
<a href="MainInterface.jsp"> Try again </a>

<body>

</body>
</html>