<%-- 
    Document   : profile
    Created on : May 29, 2022, 8:55:22 PM
    Author     : 84337
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <!--  This file has been downloaded from bootdey.com @bootdey on twitter -->
        <!--  All snippets are MIT license http://bootdey.com/license -->
        <title>Profile</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        <div class="container">
            <div class="main-body">

                <!--header -->
                <nav class="navbar default-layout col-lg-12 col-12 p-0 fixed-top d-flex align-items-top flex-row">
                    <div class="text-center navbar-brand-wrapper d-flex align-items-center justify-content-start">
                        <c:if test="${sessionScope.acc != null}">
                            <div class="me-3">
                                <button class="navbar-toggler navbar-toggler align-self-center" type="button" data-bs-toggle="minimize">
                                    <span class="icon-menu"></span>
                                </button>
                            </div>
                        </c:if>
                        <c:if test="${sessionScope.acc != null}">
                            <div>
                                <a class="navbar-brand brand-logo" href="dashboard">
                                    <img src="images/logo.png" alt="logo"  style="height: 150% ; width: 150%"/>
                                </a>
                                <a class="navbar-brand brand-logo-mini" href="dashboard">
                                    <img src="images/logo-mini.svg" alt="logo" />
                                </a>
                            </div>
                        </c:if>
                        <c:if test="${sessionScope.acc == null}">
                            <div>
                                <a class="navbar-brand brand-logo" href="home">
                                    <img src="images/logo.png" alt="logo"  style="height: 150% ; width: 150%"/>
                                </a>
                                <a class="navbar-brand brand-logo-mini" href="home">
                                    <img src="images/logo-mini.svg" alt="logo" />
                                </a>
                            </div>
                        </c:if>
                    </div>
                    <div class="navbar-menu-wrapper d-flex align-items-top"> 
                        <ul class="navbar-nav">
                            <li class="nav-item font-weight-semibold d-none d-lg-block ms-0">
                                <h1 class="welcome-text"><span class="text-black fw-bold  ">Student Management System</span></h1>
                                <h3 class="welcome-sub-text">Team 4</h3>
                            </li>
                        </ul>
                        <ul class="navbar-nav ms-auto">
                            <c:if test="${sessionScope.acc != null}">
                                <li class="nav-item">
                                    <form class="search-form" action="#">
                                        <i class="icon-search"></i>
                                        <input type="search" class="form-control" placeholder="Search Here" title="Search here">
                                    </form>
                                </li>
                                <li class="nav-item dropdown">                  
                                    <a class="nav-link count-indicator" id="notificationDropdown" href="#" data-bs-toggle="dropdown">
                                        <i class="icon-mail icon-lg"></i>
                                    </a>
                                    <div class="dropdown-menu dropdown-menu-right navbar-dropdown preview-list pb-0" aria-labelledby="notificationDropdown">
                                        <a class="dropdown-item py-3 border-bottom">
                                            <p class="mb-0 font-weight-medium float-left">You have 4 new notifications </p>
                                            <span class="badge badge-pill badge-primary float-right">View all</span>
                                        </a>
                                        <a class="dropdown-item preview-item py-3">
                                            <div class="preview-thumbnail">
                                                <i class="mdi mdi-alert m-auto text-primary"></i>
                                            </div>
                                            <div class="preview-item-content">
                                                <h6 class="preview-subject fw-normal text-dark mb-1">Application Error</h6>
                                                <p class="fw-light small-text mb-0"> Just now </p>
                                            </div>
                                        </a>
                                        <a class="dropdown-item preview-item py-3">
                                            <div class="preview-thumbnail">
                                                <i class="mdi mdi-settings m-auto text-primary"></i>
                                            </div>
                                            <div class="preview-item-content">
                                                <h6 class="preview-subject fw-normal text-dark mb-1">Settings</h6>
                                                <p class="fw-light small-text mb-0"> Private message </p>
                                            </div>
                                        </a>
                                        <a class="dropdown-item preview-item py-3">
                                            <div class="preview-thumbnail">
                                                <i class="mdi mdi-airballoon m-auto text-primary"></i>
                                            </div>
                                            <div class="preview-item-content">
                                                <h6 class="preview-subject fw-normal text-dark mb-1">New user registration</h6>
                                                <p class="fw-light small-text mb-0"> 2 days ago </p>
                                            </div>
                                        </a>
                                    </div>
                                </li>
                                <li class="nav-item dropdown"> 
                                    <a class="nav-link count-indicator" id="countDropdown" href="#" data-bs-toggle="dropdown" aria-expanded="false">
                                        <i class="icon-bell"></i>
                                        <span class="count"></span>
                                    </a>
                                    <div class="dropdown-menu dropdown-menu-right navbar-dropdown preview-list pb-0" aria-labelledby="countDropdown">
                                        <a class="dropdown-item py-3">
                                            <p class="mb-0 font-weight-medium float-left">You have 7 unread mails </p>
                                            <span class="badge badge-pill badge-primary float-right">View all</span>
                                        </a>
                                        <div class="dropdown-divider"></div>
                                        <a class="dropdown-item preview-item">
                                            <div class="preview-thumbnail">
                                                <img src="images/logo.png" alt="image" class="img-sm profile-pic">
                                            </div>
                                            <div class="preview-item-content flex-grow py-2">
                                                <p class="preview-subject ellipsis font-weight-medium text-dark">Marian Garner </p>
                                                <p class="fw-light small-text mb-0"> The meeting is cancelled </p>
                                            </div>
                                        </a>
                                    </div>
                                </li>
                                <li class="nav-item dropdown d-none d-lg-block user-dropdown">
                                    <a class="nav-link" id="UserDropdown" href="#" data-bs-toggle="dropdown" aria-expanded="false" >
                                        <img class="img-xs rounded-circle" src="images/user_ogor.png" alt="Profile image"> </a>
                                    <div class="dropdown-menu dropdown-menu-right navbar-dropdown" aria-labelledby="UserDropdown">
                                        <div class="dropdown-header text-center">                               
                                            <p class="mb-1 mt-3 font-weight-semibold">${sessionScope.acc.fullName}</p>
                                            <p class="fw-light text-muted mb-0">${sessionScope.acc.email}</p>
                                        </div>
                                        <a class="dropdown-item" href="profile"><i class="dropdown-item-icon mdi mdi-account-outline text-primary me-2"></i> My Profile <span class="badge badge-pill badge-danger">1</span></a>
                                        <a class="dropdown-item"><i class="dropdown-item-icon mdi mdi-message-text-outline text-primary me-2"></i> Messages</a>
                                        <a class="dropdown-item"><i class="dropdown-item-icon mdi mdi-calendar-check-outline text-primary me-2"></i> Activity</a>
                                        <a class="dropdown-item"><i class="dropdown-item-icon mdi mdi-help-circle-outline text-primary me-2"></i> FAQ</a>
                                        <a class="dropdown-item" href="logOut.jsp"><i class="dropdown-item-icon mdi mdi-power text-primary me-2" ></i>Sign Out</a>
                                    </div>
                                </li>
                            </ul>
                            <button class="navbar-toggler navbar-toggler-right d-lg-none align-self-center" type="button" data-bs-toggle="offcanvas">
                                <span class="mdi mdi-menu"></span>
                            </button>
                        </c:if>
                        <c:if test="${sessionScope.acc == null}">  
                            <h5>YOU ARE NOT LOGGED IN <a href="ControllerLogin" style="color: red; text-decoration: none">LOG IN</a> OR <a href="SignUp" style="color: red; text-decoration: none">REGISTER</a> </h5>
                        </c:if>
                    </div>
                </nav>
                <!--header -->
                <h1 class="text-black fw-bold  " style="text-align: center; margin-bottom: 30px"> Profile</h1>

                <div class="row gutters-sm">
                    <div class="col-md-4 mb-3">
                        <div class="card">
                            <div class="card-body" >
                                <div class="d-flex flex-column align-items-center text-center" >
                                    <img src="avatar/${details.avatar}"  alt="Admin" class="rounded-circle" width="150" style="width: 76%" >
                                    <div class="mt-3">
                                        <h4>${details.fullName}</h4>

                                        <button class="btn btn-outline-primary"> <a href="${acc.linkFB}" style="color: black; text-decoration: none">	Facebook </a></button >

                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                    <div class="col-md-8">
                        <div class="card mb-3">
                            <div class="card-body" >
                                <div class="row">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0">Full Name</h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary" name="FullName">
                                        ${details.fullName}
                                    </div>
                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0">Date of birth</h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        ${details.date}
                                    </div>
                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0">Email</h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary" name="email">
                                        ${details.email}
                                    </div>
                                </div>


                                <hr>
                                <div class="row">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0">Mobile</h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        0${details.mobile}
                                    </div>
                                </div>
                                <hr>

                                <div class="row">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0">Address</h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        ${details.address}
                                    </div>
                                </div>

                                <hr>
                                <div class="row">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0">Sex</h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        <c:choose>
                                            <c:when test="${details.gender==true}">
                                                Male 

                                            </c:when>    
                                            <c:otherwise>
                                                Female

                                            </c:otherwise>
                                        </c:choose>
                                    </div>
                                </div>

                                <hr>
                                <div class="row">
                                    <div class="col-md-2">
                                        <a class="btn btn-info " target="__blank" href="loadprofileedit">Edit</a>
                                    </div>

                                    <div class="col-sm-10" >
                                        <button class="btn btn-info" onclick="changePass()" > Change Password </button>
                                    </div>

                                </div>
                                <div class="col-md-6 grid-margin stretch-card" id ="changePass" style="display: none">
                                    <div class="card">
                                        <div class="card-body">
                                            <h4 class="card-title">Change Password</h4>
                                            <p class="card-description">

                                            </p>
                                            <form class="forms-sample" action="changepassword" method="post">
                                                <div class="form-group">
                                                    <label >Password</label>
                                                    <input type="password" class="form-control" name="oldpsw" placeholder="Password">
                                                </div>
                                                <div class="form-group">
                                                    <label for="psw">New Password</label>
                                                    <input type="password" class="form-control" name="psw1" placeholder="Password" 
                                                           id="psw" name="psw" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" 
                                                           title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required>
                                                </div>
                                                <div id="message">
                                                    <h4>Password must following:</h4>
                                                    <p id="letter" class="invalid">A <b>lowercase</b> letter</p>
                                                    <p id="capital" class="invalid">A <b>capital (uppercase)</b> letter</p>
                                                    <p id="number" class="invalid">A <b>number</b></p>
                                                    <p id="length" class="invalid">Minimum <b>8 characters</b></p>
                                                </div>
                                                <div class="form-group">
                                                    <label for="psw2">Confirm New Password</label>
                                                    <input type="password" class="form-control" id="psw2" name="psw2"  placeholder="Password"
                                                           title="re-password must match password" required>
                                                </div>
                                                <div id="message2">

                                                    <p id="match" class="invalid">Password  <b>Match</b> </p>

                                                </div>

                                                <button type="submit" class="btn btn-primary me-2">Submit</button>
                                                <button class="btn btn-light">Cancel</button>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
            <script>
                function changePass() {
                    var x = document.getElementById("changePass");

                    if (x.style.display === "none") {
                        x.style.display = "block";
                    } else {
                        x.style.display = "none";
                    }
                }
                var myInput = document.getElementById("psw");
                var myInput2 = document.getElementById("psw2");
                var letter = document.getElementById("letter");
                var capital = document.getElementById("capital");
                var number = document.getElementById("number");
                var length = document.getElementById("length");
                var match = document.getElementById("match");

// When the user clicks on the password field, show the message box
                myInput.onfocus = function () {
                    document.getElementById("message").style.display = "block";
                };

// When the user clicks outside of the password field, hide the message box
                myInput.onblur = function () {
                    document.getElementById("message").style.display = "none";
                };
                myInput2.onfocus = function () {
                    document.getElementById("message2").style.display = "block";
                };

// When the user clicks outside of the password field, hide the message box
                myInput2.onblur = function () {
                    document.getElementById("message2").style.display = "none";
                };

// When the user starts to type something inside the password field
                myInput.onkeyup = function () {

                    // Validate lowercase letters
                    var lowerCaseLetters = /[a-z]/g;
                    if (myInput.value.match(lowerCaseLetters)) {
                        letter.classList.remove("invalid");
                        letter.classList.add("valid");
                    } else {
                        letter.classList.remove("valid");
                        letter.classList.add("invalid");
                    }

                    // Validate capital letters
                    var upperCaseLetters = /[A-Z]/g;
                    if (myInput.value.match(upperCaseLetters)) {
                        capital.classList.remove("invalid");
                        capital.classList.add("valid");
                    } else {
                        capital.classList.remove("valid");
                        capital.classList.add("invalid");
                    }

                    // Validate numbers
                    var numbers = /[0-9]/g;
                    if (myInput.value.match(numbers)) {
                        number.classList.remove("invalid");
                        number.classList.add("valid");
                    } else {
                        number.classList.remove("valid");
                        number.classList.add("invalid");
                    }

                    // Validate length
                    if (myInput.value.length >= 8) {
                        length.classList.remove("invalid");
                        length.classList.add("valid");
                    } else {
                        length.classList.remove("valid");
                        length.classList.add("invalid");
                    }


                };
                myInput2.onkeyup = function () {
                    // Validate match
                    if (myInput.value === myInput2.value) {
                        match.classList.remove("invalid");
                        match.classList.add("valid");

                    } else {
                        match.classList.remove("valid");
                        match.classList.add("invalid");

                    }
                };


            </script>

        </div>
        <jsp:include page="footer.jsp" ></jsp:include>


        <style type="text/css">
            #message {
                display:none;
                background: #f1f1f1;
                color: #000;
                position: relative;
                padding: 10px;
                margin-top: 10px;
            }

            #message p {
                padding: 10px 35px;
                font-size: 13px;
            }
            #message2 {
                display:none;
                background: #f1f1f1;
                color: #000;
                position: relative;
                padding: 10px;
                margin-top: 10px;
            }

            #message2 p {
                padding: 10px 35px;
                font-size: 13px;
            }
            /* Add a green text color and a checkmark when the requirements are right */
            .valid {
                color: green;
            }

            .valid:before {
                position: relative;
                left: -35px;
                content: "✔";
            }

            /* Add a red text color and an "x" when the requirements are wrong */
            .invalid {
                color: red;
            }

            .invalid:before {
                position: relative;
                left: -35px;
                content: "✖";
            }
            .container{
                margin-bottom:  150px;
            }
            body{

                margin-top:150px;
                color: #1a202c;
                text-align: left;
                background-color: #e2e8f0;    

            }
            .main-body {
                padding: 15x;
            }
            .card {
                box-shadow: 0 1px 3px 0 rgba(0,0,0,.1), 0 1px 2px 0 rgba(0,0,0,.06);
            }

            .card {
                position: relative;
                display: flex;
                flex-direction: column;
                /*min-width: 10;*/
                word-wrap: break-word;
                background-color: #fff;
                background-clip: border-box;
                border: 0 solid rgba(0,0,0,.125);
                border-radius: .25rem;
            }

            .card-body {
                flex: 1 1 auto;
                min-height: 1px;
                padding: 10rem;
            }

            .gutters-sm {
                margin-right: -8px;
                margin-left: -8px;
            }

            .gutters-sm>.col, .gutters-sm>[class*=col-] {
                padding-right: 8px;
                padding-left: 8px;
            }
            .mb-3, .my-3 {
                margin-bottom: 10rem!important;
            }

            .bg-gray-300 {
                background-color: #e2e8f0;
            }
            .h-100 {
                height: 100%!important;
            }
            .shadow-none {
                box-shadow: none!important;
            }

        </style>

        <script type="text/javascript"></script>
        <script src="vendors/js/vendor.bundle.base.js"></script>
        <script src="vendors/chart.js/Chart.min.js"></script>
        <script src="vendors/bootstrap-datepicker/bootstrap-datepicker.min.js"></script>
        <script src="vendors/progressbar.js/progressbar.min.js"></script>
        <script src="js/off-canvas.js"></script>
        <script src="js/hoverable-collapse.js"></script>
        <script src="js/template.js"></script>
        <script src="js/settings.js"></script>
        <script src="js/todolist.js"></script>
        <script src="js/jquery.cookie.js" type="text/javascript"></script>
        <script src="js/dashboard.js"></script>
        <script src="js/Chart.roundedBarCharts.js"></script>
    </body>
</html>
