<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dashboard Page</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<%
		String usernameSession = (String) session.getAttribute("username");
		if (session.getAttribute("username") == null) {
			response.sendRedirect("invalid.jsp?error=1");
		} else {
			%>
			<script>
				alert("Session attribute :- ", '<%=usernameSession%>');
			</script>
			<%
		}
	%>


	<div class="container">
		<div class="jumbotron">
			<h1>Dashboard Page</h1>
			<p>Welcome to our page.</p>
			<a href="logout.jsp"><span class="glyphicon glyphicon-log-out"></span>
				Logout</a>
		</div>
		<p>One stop for all your learning needs!.</p>
		<p>We promise you to give all services!</p>
	</div>
</body>
</html>