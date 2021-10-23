<%@page import="com.simplilearn.Employee"%>
<br>
<h1>From Previous JSP</h1>

<jsp:useBean id="employeeObject" class="com.simplilearn.Employee"
	scope="session"></jsp:useBean>

<br>
	<p>ID: <jsp:getProperty name="employeeObject" property="id" /> </p>
	<p>Name: <jsp:getProperty name="employeeObject" property="name" /></p>
	<p>Country: <jsp:getProperty name="employeeObject" property="country" /></p>
	<p>Email: <jsp:getProperty name="employeeObject" property="email" /></p>
	<p>Age: <jsp:getProperty name="employeeObject" property="age" /></p>


