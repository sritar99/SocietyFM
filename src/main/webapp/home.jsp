<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Portal</title>
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
    background-repeat: no-repeat;
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
     <a class="nav-link" href="HomeController?flatno=${flatuser.flatno}" style="color:white">GreenTownCitySFM</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="DefaultersController?flatno=${flatuser.flatno}" style="color:white">Defaulter's</a>
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
	<div class="row">
		<div class="column" style="width: 35%;">
		
		</div>
		<div class="column" style="width: 30%;">
		<h3 style="font-family: 'Lora', serif;text-align:center;">Hello ${flatuser.name}</h3>
		</div>
		<div class="column" style="width: 35%;">
		
		</div>
	</div>
		<br><br>

	<div class="row">
	<div class="column" style="width: 5%;">
		
	</div>
		<div class="column" style="width: 15%;">
		<h5 style="font-family: 'Lora', serif;">Flat No </h5>
		<h5 style="font-family: 'Lora', serif;">Email</h5>
		<h5 style="font-family: 'Lora', serif;">Mobile</h5>
		</div>
		<div class="column" style="width: 30%;">
		<h5 style="font-family: 'Lora', serif;">${flatuser.flatno}</h5>
		<h5 style="font-family: 'Lora', serif;">${flatuser.email}</h5>
		<h5 style="font-family: 'Lora', serif;">${flatuser.phone_no}</h5>
		</div>
		<div class="column" style="width: 20%;">
		<h5 style="font-family: 'Lora', serif;">Onboarding Date</h5>
		<h5 style="font-family: 'Lora', serif;">Payments &nbsp;&nbsp;&nbsp;&nbsp;Done</h5>
		<h5 style="font-family: 'Lora', serif;">Payments &nbsp;&nbsp;&nbsp;&nbsp;Due </h5>
		</div>
		<div class="column" style="width: 15%;">
		<h5 style="font-family: 'Lora', serif;">${flatuser.datejoin}</h5>
		<h5 style="font-family: 'Lora', serif;">${donecount}</h5>
		<h5 style="font-family: 'Lora', serif;">${duecount}</h5>
		</div>
		<div class="column" style="width: 15%;">
		<br><br>
		<button class="btn btn-primary" onclick="window.location.href='updateprofile.jsp'">Update Profile</button>
		</div>
	</div>
	<hr style="border:1px solid green;">
	<br><br>
	<h3 style="font-family: 'Lora', serif;">Total Amount Paid:&nbsp;&nbsp;${paidamount}₹</h3><hr>
	<h4 style="font-family: 'Lora', serif;">${message}</h4><br>
	<hr style="border:1px solid green;">
	<h4 style="font-family: 'Lora', serif;">Pending Monthly Activities</h4>
	<table class="table" id="datatable">
	<thead class="thead-dark">
		<tr>
			<th>Activity</th>
			<th>Month</th>
			<th>Last Date</th>
			<th>Issued Amount</th>
			<th>Actions</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${duelist}" var="activity">
		<tr>
			<td>${activity.name}</td>
			<td>${activity.monthyear}</td>
			<td>${activity.lastdate}</td>
			<td>${activity.amount}₹</td>
			<td><a href="${pageContext.request.contextPath}/PaymentController?action=Payment&id=${activity.issueid}&flatno=${flatuser.flatno}">Pay Now</a></td>
		</tr>
	</c:forEach> 
	</tbody>
	
	</table>
	<br><hr><br>
	<h4 style="font-family: 'Lora', serif;">Completed Monthly Activities</h4>
	<table class="table" id="datatable2">
	<thead class="thead-dark">
		<tr>
			<th>Activity</th>
			<th>Month</th>
			<th>Last Date</th>
			<th>Issued Amount</th>
			<th>Amount Paid</th>
			<th>Date Paid</th>

		</tr>
	</thead>
	<tbody>
		<c:forEach items="${paidlist}" var="activity">
			<tr>
			<td>${activity.name}</td>
			<td>${activity.monthyear}</td>
			<td>${activity.lastdate}</td>
			<td>${activity.amount}</td>
			<td>${activity.amountpaid}</td>
			<td>${activity.datepaid}</td> 
			</tr>
		</c:forEach>
	</tbody>
		 
	</table>
	<br><hr><br>
</div>

<script src="https://unpkg.com/jquery@3.3.1/dist/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/v/bs4/dt-1.10.21/datatables.min.js"></script>
<script>
	$(document).ready(function(){
		$("#datatable").DataTable();
		$("#datatable2").DataTable();
		});
	
</script>
</body>
</html>

