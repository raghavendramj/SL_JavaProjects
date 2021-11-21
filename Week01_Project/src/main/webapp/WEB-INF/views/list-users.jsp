<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
<title>Listing all the Users</title>
</head>
<body>
	<div class="container">
		<h3>Users Directory</h3>
		<form action="/users/findUser" class=form-inline">
			<input type="search" name="id" placeholder="Id"
				class="form-control-sm ml-5 mr-2 mb-3" />
			<button type="submit" class="btn btn-success btn-sm mb-3">Search</button>
		</form>

		<table class="table table-bordered table-striped">
			<thead class="thead-dark">
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Email</th>
					<th>Operations</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${Users}" var="user">
					<tr>
						<td><c:out value="${user.id}" /></td>
						<td><c:out value="${user.name}" /></td>
						<td><c:out value="${user.email}" /></td>
						<td>
							<!-- Add "update" button/link --> <a
							href="/Week01_Project/users/showFormForUpdate?userId=${user.id}"
							class="btn btn-info btn-sm"> Update </a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>


</body>
</html>