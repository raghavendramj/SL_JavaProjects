<%@page import="java.util.Objects"%>
<%@page import="java.util.List"%>
<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dashboard Page</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<%
		String usernameSession = (String) session.getAttribute("username");
		if (session.getAttribute("username") == null) {
			response.sendRedirect("invalid.jsp?error=1");
		}
	%>
	<div class="container mt-3">
		<h2>Welcome to Learners Academy</h2>
		  <a href="logout.jsp"><span class="glyphicon glyphicon-log-out"></span> Logout</a>
		  <a href="students"> <button class="btn btn-primary">View Students</button></a>
		  <a href="teachers"> <button class="btn btn-primary">View Teachers</button></a>
		  <a href="subjects"> <button class="btn btn-primary">View Subjects</button></a>
		  <a href="classes"> <button class="btn btn-primary">View Classses</button></a>
		<%
			String students = request.getParameter("students");
			if (Objects.nonNull(students)) {

				%>
				<p>List of Students</p>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Id</th>
							<th>Name</th>
						</tr>
					</thead>
					<tbody>
						<%
							List<HashMap<Object, Object>> studentsList = new ObjectMapper().readValue(students, List.class);
		
								for (HashMap<Object, Object> eachMap : studentsList) {
									int studentId = (Integer) eachMap.get("studentId");
									String studentName = (String) eachMap.get("studentName");
									%>
									<tr>
										<td><%=studentId%></td>
										<td><%=studentName%></td>
									</tr>
									<%
								}
						%>
					</tbody>
				</table>
				<%
				
			}
		%>
	</div>

</body>
</html>
