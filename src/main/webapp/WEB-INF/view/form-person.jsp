<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" http-equiv="Content-Type" content="text/html">
<title>Form</title>
</head>
<body>
<h1>Form Person</h1>
<hr>

<form:form action="save" method="POST" modelAttribute="person">
<table>
	<form:hidden path="id"/>
	<tr>
		<td>First Name:</td>
		<td>
			<form:input path="firstName"/>
		</td>
	</tr>
	<tr>
		<td>Last Name:</td>
		<td>
			<form:input path="lastName"/>
		</td>
	</tr>
	<tr>
		<td>Money:</td>
		<td>
			<form:input path="money"/>
		</td>
	</tr>
</table>
<input type="submit" value="submit">
</form:form>

</body>
</html>