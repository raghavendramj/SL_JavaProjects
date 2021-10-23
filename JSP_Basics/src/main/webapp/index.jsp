<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My First JSP</title>
</head>
<body>

	<%--JSP Scriptlet - Java code goes! --%>
	<h1>JSP Scriptlet - Java code goes!</h1>
	<%
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		out.println("<br>User-name passed is :-" + username + "<br>Password is :-" + password);
	%>
	<h1>JSP Demo - 01</h1>
	<br>
	<%=Calendar.getInstance().getTime()%>

	<br>
	<%--JSP Declaration --%>
	<%!int data = 100;%>

	<h1>JSP Expression</h1>
	<%--JSP Expression --%>
	<%="Value is :- " + data%>
</body>
</html>