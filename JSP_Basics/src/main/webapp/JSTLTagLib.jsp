<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSTL Tag Lib Examples...</title>
</head>
<body>
	<c:out value="${'Welcome to the JSP Simplilearn Class'}" />
	<c:import var="data" url="https://www.simplilearn.com" />
	<br>
	<p>
		<c:set var="income" scope="session" value="${4000*4}" />
		Before Remove the Income is
		<c:out value="${income}" />
	</p>

	<p>
		<c:remove var="income" />
		After Removal of Income is
		<c:out value="${income}" />
	</p>
	<p>
		<c:forEach var="number" begin="1" end="5">
			<p>
				Item :
				<c:out value="${number}" />
			</p>
		</c:forEach>
	</p>
</body>
</html>