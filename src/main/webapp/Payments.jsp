<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page isELIgnored="false" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.text.SimpleDateFormat,java.util.Date" %>
<%
    pageContext.setAttribute("lDate", LocalDate.now());
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Portal</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Lora&display=swap" rel="stylesheet">

<style>
th,td{
   font-family: 'Lora', serif;
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
      <a class="nav-link" href="${pageContext.request.contextPath}/logout.jsp" style="color:white">Logout</a>
    </li>
    </ul>
</nav>
<br>
<div class="container">
<h2 style="text-align:center;font-family: 'Lora', serif;">Payment Details</h2>
	<div class="row">
		<div class="column"style="width: 70%;">
			<h3 style="font-family: 'Lora', serif;">Green Town City</h3>
			<h5 style="font-family: 'Lora', serif;">#100/150, 4th Cross, J.P Nagar 4th Phase</h5>
			<h5 style="font-family: 'Lora', serif;">Opp. Clarence Public School</h5>
			<h5 style="font-family: 'Lora', serif;">Bengaluru - 560078</h5>
		</div>
		<div class="column">
			<h5 style="font-family: 'Lora', serif;">Date:${lDate}</h5>
         	<h4 style="font-family: 'Lora', serif;">Reference ID:${inwardpayment.issueid}</h4>
		</div>
	</div>
<c:set var="due" value="${inwardpayment.lastdate}"/>
<% 		Date date = new Date();
	    String modifiedDate= new SimpleDateFormat("yyyy-MM-dd").format(date);
		String[] words = modifiedDate.split("\\W+");
	    int issueddate=Integer.parseInt(String.join("",words).substring(5));
	    String dued=(String)pageContext.getAttribute("due");
	    String[] words1 = dued.split("\\W+");
	    int duedate=Integer.parseInt(String.join("",words1).substring(5));
	   
	    pageContext.setAttribute("curdate",issueddate);
	    pageContext.setAttribute("duedate",duedate);
	   
	   
		
	%>
	
	<div class="row">
		<div class="column" style="width: 40%;">

		</div>
		<div class="column" style="width: 20%;">
			<h1 style="font-family: 'Lora', serif;text-align:center;">Receipt</h1>
		</div>
		<div class="column" style="width: 40%;">

		</div>
	</div>
	<br>
	<div class="row">
		<div class="column" style="width: 35%;">

		</div>
		<div class="column" style="width: 25%;">
			<h6 style="font-family: 'Lora', serif;">Flat No </h6><br>
			<h6 style="font-family: 'Lora', serif;">Flat Owner</h6><br>
			<h6 style="font-family: 'Lora', serif;">Activity</h6><br>
			<h6 style="font-family: 'Lora', serif;">Date Issued</h6><br>
			<h6 style="font-family: 'Lora', serif;">Last Date</h6><br>
			<h6 style="font-family: 'Lora', serif;">Amount</h6><br>
			<h6 style="font-family: 'Lora', serif;">Penalty</h6><br>
			<h6 style="font-family: 'Lora', serif;">Total</h6>
		</div>
		<div class="column" style="width: 30%;">
			<h6 style="font-family: 'Lora', serif;">${flatuser.flatno}</h6><br>
			<h6 style="font-family: 'Lora', serif;">${flatuser.name}</h6><br>
			<h6 style="font-family: 'Lora', serif;">${inwardpayment.name}</h6><br>
			<h6 style="font-family: 'Lora', serif;">${inwardpayment.monthyear}</h6><br>
			<h6 style="font-family: 'Lora', serif;">${inwardpayment.lastdate}</h6><br>
			<h6 style="font-family: 'Lora', serif;">${inwardpayment.amount}</h6><br>
 			<h6 style="font-family: 'Lora', serif;">${curdate lt duedate? 0 :100}</h6><br>
			<h6 style="font-family: 'Lora', serif;"><c:out value="${curdate lt duedate eq true?inwardpayment.amount:inwardpayment.amount+100}"/></h6>
			<input type="hidden" name="id" value="<c:out value="${curdate lt duedate eq true?inwardpayment.amount:inwardpayment.amount+100}"/>">
		</div>
		<div class="column" style="width: 10%;">

		</div>
	</div>
	<div class="row">
		<div class="column" style="width: 45%;">

		</div>
		<div class="column" style="width: 20%;">
			<form action="${pageContext.request.contextPath}/PaymentController"  method="POST" class="appointment-form" id="appointment-form">
				<div class="form-group-1">
				<input type="hidden" name="flatno" value="${flatuser.flatno}">
					<input type="hidden" name="issueid" value="${inwardpayment.issueid}">
					<input type="hidden" name="delayed" value="${curdate lt duedate eq true?false:true}">
					
					<input type="hidden" name="money" value="<c:out value="${curdate lt duedate eq true?inwardpayment.amount:inwardpayment.amount+100}"/>">
				</div>
				<div class="form-submit">
               		<input type="submit" class="btn btn-primary"<c:if test="${inwardpayment.ispaid == true}"><c:out value="disabled='disabled'"/></c:if> <c:if test="${activity.isplaced == true}"><c:out value="value=Paid Successfully"/></c:if> name="submit" id="submit" class="submit" value="Pay Now" />
        		</div>
    		</form>
		</div>
		<div class="column" style="width: 40%;">

		</div>
	</div>
	
	



</div>

</body>
</html>