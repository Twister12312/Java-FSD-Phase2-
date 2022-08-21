<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<h2>Main Interface</h2><br>
<body>
<%
request.getSession(false);
%>
<a href="AssignSubjects.jsp"> Assign subjects to existing class</a> <br>
<a href="AssignTeachers.jsp">Assign Teachers </a><br><br>

	<a href="InsertClasses.jsp">Set up new class</a> <br><br>
	<a href="InsertSubjects.jsp">Set up a new subject </a><br><br>
	<a href="InsertTeachers.jsp">Set up a new teacher </a><br><br>
	
	
	<a href="ClassesList.jsp">List of classes </a><br><br>
	<a href="SubjectsList.jsp">List of subjects </a><br><br>
	<a href="TeachersList.jsp">List of teachers </a><br><br>
	<a href="StudentsList.jsp">List of students </a><br><br>
	<br>
	<a href="ClassReport.jsp">Generate Class report</a><br><br><br>
	<a href="AddStud">Add students</a>
</body>
</html>