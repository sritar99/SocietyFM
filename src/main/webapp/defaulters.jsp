<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Defaulter's</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs4/dt-1.10.21/datatables.min.css"/>
 

<link href="https://fonts.googleapis.com/css2?family=Lora&display=swap" rel="stylesheet">
<style>
th,td{
   font-family: 'Lora', serif;
   color:white;
   
}
body{
  -moz-background-size: cover;
  -webkit-background-size: cover;
  -o-background-size: cover;
  -ms-background-size: cover;
  background-position: center center;
      background: linear-gradient(rgba(0,0,0,.8), rgba(0,0,0,.8)), url("./images/houses.jpeg");
/*     background-repeat: no-repeat; */
    background-size: cover;
    background-position: center center;
    color: #fff;
}
</style>
</head>
<body>
<%
	String flatsession=(String)session.getAttribute("flatsession");
	if(flatsession==null){
		response.sendRedirect("index.jsp");
	}
%>
<nav class="navbar navbar-expand-sm bg-dark rounded-bottom">
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="HomeController?flatno=${flatno}" style="color:white">GreenTownCitySFM</a>
    </li>
  </ul>
    <ul class="navbar-nav ml-auto">
    <li class="nav-item">
      <a class="nav-link" href="${pageContext.request.contextPath}/contact.jsp" style="color:white">Contact Us</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="${pageContext.request.contextPath}/logout.jsp" style="color:white">Logout</a>
    </li>
    </ul>
</nav>
<br>

<div class="container">
	<h4 style="font-family: 'Lora', serif;">${message}</h4><br>
	<h4 style="font-family: 'Lora', serif;">Defaulter's</h4>
	<table class="table" id="datatable">
	<thead class="thead-dark">
		<tr>
			<th style="text-align:center;">Flat No</th>
			<th>Activity</th> 
			<th>Issue Date</th>
			<th>Due Date</th>
			<th>Amount</th>
			<th>Amount Paid</th>
			<th>Date Paid</th>
			
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${inwardlist}" var="inward">
		<tr>
			<td>${inward.flatno}</td>
			<td>${inward.name}</td>
			<td>${inward.monthyear}</td>
			<td>${inward.lastdate}</td>
			<td>${inward.amount}₹</td>
			<td>${inward.amountpaid}₹</td>
			<td>${inward.datepaid}</td>
		</tr>
	</c:forEach> 
	</tbody>
	</table>
</div>
<script src="https://unpkg.com/jquery@3.3.1/dist/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/v/bs4/dt-1.10.21/datatables.min.js"></script>
<script>
	$(document).ready(function(){
		$("#datatable").DataTable();
		});
</script>
</body>

</html>