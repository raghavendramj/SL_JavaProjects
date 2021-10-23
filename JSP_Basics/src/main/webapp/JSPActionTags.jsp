<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP Action Tags!</title>
</head>
<body>
	<h2>BEGIN :: This is my JSP Action Tags JSP</h2>
	<jsp:include page="currentDate.jsp" />
	<h2>End :: This is my JSP Action Tags JSP</h2>

	<jsp:useBean id="employeeObject" class="com.simplilearn.Employee"
		scope="session" />
	<jsp:setProperty property="id" name="employeeObject" value="123" />
	<jsp:setProperty property="name" name="employeeObject" value="Raghav" />
	<jsp:setProperty property="country" name="employeeObject" value="India" />
	<jsp:setProperty property="age" name="employeeObject" value="30" />
	<jsp:setProperty property="email" name="employeeObject"
		value="raghav@gmail.com" />

	<%
		String emailAddress = employeeObject.getEmail();
		out.println("<br> Id :- " + employeeObject.getId());
		out.println("<br> Name  :- " + employeeObject.getName());
		out.println("<br> Email Address :- " + emailAddress);
		out.println("<br> Country :- " + employeeObject.getCountry());
		out.println("<br> Age :- " + employeeObject.getAge());
	%>

	<jsp:forward page="printEmployee.jsp" />

</body>
</html>