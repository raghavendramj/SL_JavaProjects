<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Sample JSP</title>
</head>
<body>
<%
	String username = request.getParameter("email");
	String password = request.getParameter("pwd");
	out.println("Username :- "+ username +"  <br> Password:- "+ password);
	
	if(username == null | "".equals(username)){
		response.sendRedirect("invalid.jsp?error=1");
	} else if(password == null | "".equals(password)){
		response.sendRedirect("invalid.jsp?error=2");
	} else {
		session.setAttribute("username", username);
		session.setAttribute("session","TRUE");  
		response.sendRedirect("dashboard.jsp");
	}
%>

</body>
</html>