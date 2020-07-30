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
/* body{
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
} */
img{
height:500px;
  width: 100%;
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
      <a class="nav-link disabled" href="#" style="color:white">GreenTownCitySFM</a>
    </li>
     <li class="nav-item">
     <a class="nav-link" href="HomeController?flatno=<%=(String)session.getAttribute("flatsession")%>" style="color:white">Home</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="DefaultersController?flatno=<%=(String)session.getAttribute("flatsession")%>" style="color:white">Defaulter's</a>
    </li>
  </ul>
    <ul class="navbar-nav ml-auto">
    <li class="nav-item">
      <a class="nav-link" href="${pageContext.request.contextPath}/logout.jsp" style="color:white">Logout</a>
    </li>
    </ul>
</nav>
<img alt="FrontImage" src="./images/city.jpeg" style="width:400;height:400;">
<div class="container">
	<div class="row">
		<div class="column" style="width: 40%;">
			
		</div>
		<div class="column" style="width: 30%;">
			<h2>Green Town City</h2>
			<i>By Green Town City Housing </i>
		</div>
		<div class="column" style="width: 40%;">
			
		</div>
	</div>
	
	<div class="row">
		<h3>Overview</h3>
		<h6>Developed with an inspiration from Venetian architecture, 
		Green Town City, Mangalagiri, Guntur is an elegantly designed residential project by GTC Housing. 
		This project is planned to offer 1648 residential units spread across 8
		towers. Green Town City, Mangalagiri, Guntur offers a wide range of 3 BHK Flats and Duplex villas placed on
		the top floors.</h6>
	</div>
	<div class="row">
		<h5>Technical Support</h5>
	</div>
	<div class="row">
		<h6>Contact No: XXXXXXXXXX</h6>
	</div>
	<div class="row">
		<h6>Email: gtcsfm@gmail.com</h6>
	</div>
</div>

</body>
</html>

