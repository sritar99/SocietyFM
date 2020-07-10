<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<table>
		<tr>
			<th>Activity Id</th>
			<th>Title</th>
			<th>Month</th>
			<th>Last Date</th>
			<th>Amount</th>
		</tr>
	<c:forEach items="${activitylist}" var="activity">
		<tr>
			<td>${activity.id}</td>
			<td>${activity.activityname}</td>
			<td>${activity.month}</td>
			<td>${activity.lastdate}</td>
			<td>${activity.amount}</td>
		</tr>
	</c:forEach> 
	</table>
	   
</body>
</html>