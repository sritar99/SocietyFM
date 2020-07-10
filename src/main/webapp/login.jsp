
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
            <form action= "loginprocess" method="POST" class="appointment-form" id="appointment-form">
                <h2 style="font-family: 'Roboto', sans-serif;">Green Town Society Welcomes You!</h2>
                <div class="form-group-1">
                    <input type="text" style="font-size:18px;" name="flatno" id="flatno" placeholder="Flat No" required />
                    <input type="password" style="font-size:18px;" name="password" id="password" placeholder="Password" required />
                </div>
                
                <div class="form-submit">
                    <input type="submit"  name="submit" id="submit" class="submit" value="Get In!" />
                    <a href="IndexController" style="font-size: 18px; margin-left: 5px;color: #3b5998">Newbie?</a>
                   
                </div>
            </form>
            
        </div>
        
        
    </div>


</body>
</html>