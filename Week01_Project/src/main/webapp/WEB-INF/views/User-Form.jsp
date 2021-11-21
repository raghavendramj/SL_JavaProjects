<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Update User Form</title>
</head>
<body>

	<div class="container">
		<h3>User Directory</h3>
		<form action="/Week01_Project/users/save" method="POST">
			<!-- Add hidden form field to handle update -->
			<input type="hidden" name="id" value="${User.id}" />

			<div class="form-inline">
				<input type="text" name="name" value="${User.name}"
					class="form-control mb-4 col-4" placeholder="Name">
			</div>
			<div class="form-inline">
				<input type="text" name="email" value="${User.email}"
					class="form-control mb-4 col-4" placeholder="Email">
			</div>
			<button type="submit" class="btn btn-info col-2">Update</button>
		</form>
		<hr>
		<a href="/Week01_Project/users/list">Back to Users List</a>
	</div>

</body>
</html>