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
<form>
  Enter Subject:<input type="text"  name="sub"><br>
  <input type="submit" value="submit"><br>
  </form>
 <%
request.getSession(false);
String subj=request.getParameter("sub");
Set<String> subjects=new HashSet<String>();
subjects=(Set<String>)session.getAttribute("PermSubj");
if(subj!=null){
if(subjects.contains(subj)){
	out.println("Already inserted!, Please try again");
}
else{
	subjects.add(subj);
	out.println("Inserted!");
	session.setAttribute("PermSubj", subjects);
}
}
%>  
  <a href="MainInterface.jsp"> Go back</a> 
</body>
</html>