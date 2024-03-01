<%-- 
    Document   : login
    Created on : Feb 25, 2022, 7:29:17 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <link rel="stylesheet" href="css/styleLogin.css">
        <!--<link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <!--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">-->
        <title>Sign in</title>
        <style>
            body {
                background-image: url(images/BGRound.jpg);
            }

        </style>
    </head>

    <body>
        <%
            Integer warning = (Integer) request.getAttribute("warning");
        %>

        <div class="main" style=" width: 426px; height: 460px;">
            <p class="sign" align="center">User Login</p>
            <form class="form1" action="ControllerLogin" method="post" style="padding: -1px" >
                <input type="hidden" name="do" value="checkLogin">
                <input class="un " type="text" align="center" placeholder="Email"  name="username">
                <input class="pass" type="password" align="center" placeholder="Password" name="password">
                <% if (warning == 1) {%>
                <div class="alert alert-dark d-flex align-items-center" role="alert">
                    <svg xmlns="http://www.w3.org/2000/svg" width="12" height="12" fill="currentColor" class="bi bi-exclamation-triangle-fill flex-shrink-0 me-2" viewBox="0 0 16 16" role="img" aria-label="Warning:">
                    <path d="M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
                    </svg>
                    <div>
                        you have the wrong password or account
                    </div>
                </div>
                <%}%>

                <button class="submit" align="center" type="submit" >Sign in</button>
                <p class="forgot" align="center"><a href="ControllerSignUp">Register</a></p> 
                <p class="forgot" align="center"><a href="RessPass">Forgot Password?</a></p> 
            </form>
        </div>
    </body>
</html>
