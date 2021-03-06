<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP Sessions Example!</title>

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
		if (request.getParameter("error") != null) {
			out.println("<br> Your session has expired or it is invalid!");
		}
	%>
	<div class="container">
	<h1> Simplilearn Login Form! </h1>
		<form action="login.jsp" method="post">
			<div class="form-group">
				<label for="email">Email address:</label> 
				<input type="text" class="form-control" id="email" name="email">
			</div>
			<div class="form-group">
				<label for="pwd">Password:</label> 
				<input type="password" class="form-control" id="pwd" name="pwd">
			</div>
			<div class="checkbox">
				<label><input type="checkbox"> Remember me</label>
			</div>
			<button type="submit" class="btn btn-primary">Login</button>
		</form>
	</div>
</body>
</html>