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
<%
request.getSession(false);

Set<String> classes=new HashSet<String>();
classes=(Set<String>)session.getAttribute("PermClass");
if(classes!=null){
	out.println("Classes are: <br>");
	for(String cl:classes){
		out.println(cl+" <br>");
	}
}
else{
	out.println("Empty set");
}

%>
<a href="MainInterface.jsp"> Go back</a>
</body>
</html>