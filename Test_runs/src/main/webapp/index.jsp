<html>
<body>
<h2>Learner's Academy</h2>
<form>
		Id:<input type="text" name="txtUser" required> 
		Password:<input type="password" name="txtPword" required> 
			<input type="submit">
		</form>
		<%
		String user = request.getParameter("txtUser");
		String password = request.getParameter("txtPword");
		if(user!=null && password!=null){
		boolean result = validate(user, password);
		if (result == true){
			getServletContext().getRequestDispatcher("/Welcome.jsp").forward(request,response);
		}
		else{
			out.println("Invalid user name and password");
		}
		}
		%>

		<%!boolean validate(String user, String password) {
		if (user.equalsIgnoreCase("admin") && password.equals("admin@123"))
			return true;
		else
			return false;
	}%>
	

</body>
</html>
