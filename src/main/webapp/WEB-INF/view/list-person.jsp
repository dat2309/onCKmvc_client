<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" http-equiv="Content-Type" content="text/html">
<title>List Person</title>
</head>
<body>
<h1>Person</h1>
<hr>

<c:url var="deleteImg" value="/resources/img/delete.png"></c:url>
<c:url var="editImg" value="/resources/img/edit.png"></c:url>

<table style="width: 100%;" border="1">
	<thead>
		<tr>
			<td>Id</td>
			<td>First Name</td>
			<td>Last Name</td>
			<td>Money</td>
			<td colspan="2"></td>
			<td>CC Type</td>
			<td>First Number</td>
			<td colspan="3"></td>
		</tr>
	</thead>
	
	<tbody>
		<c:forEach var="person" items="${persons }">
		
			<c:url var="deleteUrl" value="/person/delete">
				<c:param name="personId" value="${person.id}"></c:param>
			</c:url>
			<c:url var="updateUrl" value="/person/showFormForUpdate">
				<c:param name="personId" value="${person.id}"></c:param>
			</c:url>
			
			
			
			<c:if test="${!empty person.creditCards}">
				<c:forEach var="credit" items="${person.creditCards}">
					
					<tr>
					<td>${person.id}</td>
					<td>${person.firstName}</td>
					<td>${person.lastName}</td>
					<td>${person.money}</td>
					
					<td><a href="${deleteUrl}" onclick="if(!(confirm('Xoa?'))) return false"><img src="${deleteImg}"></a></td>
					<td><a href="${updateUrl}"><img src="${editImg}"></a></td>
					
					<td>${credit.type}</td>
					<td>${credit.numer}</td>
					
					<c:url var="deleteCcUrl" value="/creditcard/delete">
						<c:param name="creditCardId" value="${credit.id}"></c:param>
					</c:url>
					<c:url var="updateCcUrl" value="/creditcard/showFormForUpdate">
						<c:param name="creditCardId" value="${credit.id}"></c:param>
						<c:param name="personId" value="${person.id}"></c:param>
					</c:url>
					<c:url var="addCcUrl" value="/creditcard/showFormForAdd">
						<c:param name="personId" value="${person.id}"></c:param>
					</c:url>
					
					<td><a href="${addCcUrl}">+</a></td>
					<td><a href="${deleteCcUrl}" onclick="if(!(confirm('Xoa?'))) return false"><img src="${deleteImg}"></a></td>
					<td><a href="${updateCcUrl}"><img src="${editImg}"></a></td>
					</tr>
					
					
				</c:forEach>
			</c:if>
			
			
			<c:if test="${empty person.creditCards}">
				
					
					<tr>
					<td>${person.id}</td>
					<td>${person.firstName}</td>
					<td>${person.lastName}</td>
					<td>${person.money}</td>
					
					<td><a href="${deleteUrl}" onclick="if(!(confirm('Xoa?'))) return false"><img src="${deleteImg}"></a></td>
					<td><a href="${updateUrl}"><img src="${editImg}"></a></td>
					
					<td>N/A</td>
					<td>N/A</td>
					
					<c:url var="addCcUrl" value="/creditcard/showFormForAdd">
						<c:param name="personId" value="${person.id}"></c:param>
					</c:url>
					
					<td><a href="${addCcUrl}">+</a></td>
					<td></td>
					<td></td>
					</tr>
					
			</c:if>
			
		</c:forEach>
		
	
	</tbody>
</table>

<c:url var="addUrl" value="/person/showFormForAdd"></c:url>
<a href="${addUrl}">Add Person</a>

</body>
</html>