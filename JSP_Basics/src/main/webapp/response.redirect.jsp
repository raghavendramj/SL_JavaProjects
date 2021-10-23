<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		String kindOfObject = request.getParameter("kindOfObject");
		if (kindOfObject != null) {

			int serverPort = request.getServerPort();
			String servletName = config.getServletName();
			String serverInfo = application.getServerInfo();
			String pageInfo = page.toString();
			pageContext.setAttribute("userId", "raghavendra");
			String storedUserid = (String) pageContext.getAttribute("userId");

			out.println("<br> serverPort:- " + serverPort);
			out.println("<br> servletName:- " + servletName);
			out.println("<br> serverInfo:- " + serverInfo);
			out.println("<br> pageInfo:- " + pageInfo);
			out.println("<br> storedUserid:- " + storedUserid);

			out.println("<br>Value of kindOfObject is :- " + kindOfObject);
		} else {
			out.println("<br>No value passed for kindOfObject");
			response.sendRedirect("www.simplilearn.com");
		}
	%>

</body>
</html>