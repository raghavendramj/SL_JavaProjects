<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%-- JSP Implicit Object! --%>
	<%
		String requestObject = request.getParameter("kindOfObject");

		if (requestObject != null) {
			response.setHeader("Location", "response.redirect.jsp?kindOfObject" + requestObject);
			out.println("<br>Current Info requestObject is :- " + requestObject);
			request.getRequestDispatcher("response.redirect.jsp").forward(request, response);
		}
	%>
	<br>
	<a href="ImplicitObjects.jsp?kindOfObject=student"> Show Usage</a>
</body>
</html>