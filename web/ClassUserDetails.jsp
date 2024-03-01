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
        <title>Class User Details</title>
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
                <h1 class="text-black fw-bold  " style="text-align: center; margin-bottom: 30px"> Class User Details</h1>

                <div class="row gutters-sm">
                    <!--                    <div class="col-md-4 mb-3">
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
                    
                                        </div>-->
                    <div class="col-md-12">
                        <div class="card mb-3">
                            <div class="card-body" >
                                <form action="editclassuser">
                                    <div class="row">
                                        <div class="col-md-3">                                       

                                            <div class="text-secondary" >

                                                <h6>STT</h6> <input type="text" name="cuid" value=" ${cu.class_user_id}" readonly="" style="background-color: lightgray; width: 50px" >
                                            </div>
                                        </div>
                                        <div class="col-md-3">                                       

                                            <div class="text-secondary" >
                                                <!--<label for="cars">Class ID</label>-->
                                                <h6>Class ID</h6>

                                                <select id="select-state"  placeholder="Pick to choose..." name="class_id" >

                                                    <option value="${cu.class_id}">${cu.class_id}...</option>


                                                    <c:forEach items="${listC}" var="o">
                                                        <option value="${o.class_id}">${o.class_id}</option>
                                                    </c:forEach>
                                                </select>


                                            </div>
                                        </div>
                                        <div class="col-md-3">                                       

                                            <div class="text-secondary" style="display: inline">

                                                <h6>Team ID</h6> 
                                                <select id="select-state"  placeholder="Pick to choose..."  name="team_id">

                                                    <option value="${cu.team_id}">${cu.team_id}...</option>


                                                    <c:forEach items="${listT}" var="o">
                                                        <option value="${o.team_id}">${o.team_id}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="col-md-3">                                       

                                            <div class="text-secondary" style="display: inline">

                                                <h6>User ID</h6> 
                                                <select id="select-state" placeholder="Pick to choose..." name="user_id">
                                                    <option value="${cu.user_id}">${cu.user_id}...</option>


                                                    <c:forEach items="${listUserId}" var="o">
                                                        <option value="${o.userID}">${o.userID}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">Drop Out Date</h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary" >
                                            <input type="text" name="dropout_date" value=" ${cu.dropout_date}">
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">Ongoing  Eval</h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary" >
                                            <input type="text" name="onGoing" value=" ${cu.onGoing}" pattern=".{0,50}" title="no more than 50 characters">
                                        </div>
                                    </div>


                                    <hr>
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">Final Press Eval</h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            <input type="text" name="final_pres" value=" ${cu.final_pres}" pattern=".{0,50}" title="no more than 50 characters"> 
>                                        </div>
                                    </div>
                                    <hr>

                                    <div class="row">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">Final Topic Eval</h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            <input type="text" name="final_topic" value=" ${cu.final_topic}" pattern=".{0,50}" title="no more than 50 characters">
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="form-group row">
                                                <label class="col-sm-3 col-form-label">Status</label>
                                                <div class="col-sm-4">
                                                    <div class="form-check">
                                                        <label class="form-check-label">
                                                            <input type="radio" class="form-check-input" name="status" id="membershipRadios1" value="1" ${cu.status == 1?"checked":""}>
                                                            Active
                                                            <i class="input-helper"></i>
                                                        </label>
                                                    </div>
                                                </div>
                                                <div class="col-sm-5">
                                                    <div class="form-check">
                                                        <label class="form-check-label">
                                                            <input type="radio" class="form-check-input" name="status" id="membershipRadios2" value="0" ${cu.status == 0?"checked":""}>
                                                            Inactive
                                                            <i class="input-helper"></i></label>
                                                    </div>
                                                </div>
                                    <hr>
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">User Notes</h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            <input type="text" name="user_notes" value=" ${cu.user_notes}" style="width: 100%">
                                        </div>
                                    </div>

                                    <hr>

                                    <div class="row">
                                        <div class="col-md-2">
                                            <input type="Submit" value="Save"class="btn btn-info "  href="classuserdetails">
                                        </div>
                                        <div class="col-md-10">
                                        <span class="ad" >
                                            <a href="classuserlist">
                                                <button class="btn btn-danger btn-rounded btn-fw  text-white mb-0 me-0" style = "height: 45px;float: right"type="button" >
                                                    <i>
                                                        Back to Setting List
                                                    </i>
                                                </button>
                                            </a>
                                        </span>
                                            </div>
                                    </div>
                                </form>

                            </div>
                        </div>
                    </div>

                </div>
            </div>


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
        <script>
            $(document).ready(function () {
                $('select').selectize({
                    sortField: 'text'
                });
            });</script>


        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/selectize.js/0.12.6/js/standalone/selectize.min.js" integrity="sha256-+C0A5Ilqmu4QcSPxrlGpaZxJ04VjsRjKu+G82kl5UJk=" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/selectize.js/0.12.6/css/selectize.bootstrap3.min.css" integrity="sha256-ze/OEYGcFbPRmvCnrSeKbRTtjG4vGLHXgOqsyLFTRjg=" crossorigin="anonymous" />



        <script type="text/javascript"></script>
        <!--<script src="vendors/js/vendor.bundle.base.js"></script>-->
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
