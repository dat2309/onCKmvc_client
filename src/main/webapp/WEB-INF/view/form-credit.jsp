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
<h1>Form Credit Card</h1>
<hr>

<c:url value="/creditcard/save" var="saveUrl">
	<c:param name="personId" value="${personId }"></c:param>
</c:url>

<c:if test="${isUpdate}">
	<c:url value="/creditcard/update" var="saveUrl">
		<c:param name="personId" value="${personId }"></c:param>
	</c:url>
</c:if>

<form:form action="${saveUrl}" method="POST" modelAttribute="creditCard">
<table>
	<form:hidden path="id"/>
	<tr>
		<td>Type:</td>
		<td>
			<form:input path="type"/>
		</td>
	</tr>
	<tr>
		<td>Number:</td>
		<td>
			<form:input path="numer"/>
		</td>
	</tr>
</table>
<input type="submit" value="submit">
</form:form>

</body>
</html>