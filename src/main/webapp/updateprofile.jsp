
    <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>GreenTownSociety</title>

    <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">

    <link rel="stylesheet" href="css/style.css"> 
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@1,500&display=swap" rel="stylesheet">  
</head>
<body>

    <div class="main">

        <div class="container">
        
            <form action= "FlatUserProfile" method="POST" class="appointment-form" id="appointment-form">
            
                <h2 style="font-family: 'Roboto', sans-serif;">Manage Profile Information!</h2>
                <div class="form-group-1">
                    <input type="text" style="font-size:18px;" name="name" id="name" placeholder="Full Name" required />
                    <input type="email" style="font-size:18px;" name="email" id="email" placeholder="Email" required />
                   <input type="text" style="font-size:18px;" name="phone_number" id="phone_number" maxlength="10" size="10"placeholder="Mobile Number" required />
                </div>
                
                <div class="form-submit">
                    <input type="submit"  name="submit" id="submit" class="submit" value="Update!" />
                    
                </div>
            </form>
            
        </div>
        
        
    </div>


</body>
</html>