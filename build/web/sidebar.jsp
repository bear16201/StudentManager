<%-- 
    Document   : sidebar
    Created on : May 31, 2022, 7:14:31 PM
    Author     : My PC
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Student Management </title>
    <!-- plugins:css -->
    <link rel="stylesheet" href="vendors/feather/feather.css">
    <link rel="stylesheet" href="vendors/mdi/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="vendors/ti-icons/css/themify-icons.css">
    <link rel="stylesheet" href="vendors/typicons/typicons.css">
    <link rel="stylesheet" href="vendors/simple-line-icons/css/simple-line-icons.css">
    <link rel="stylesheet" href="vendors/css/vendor.bundle.base.css">
    <!-- endinject -->
    <!-- Plugin css for this page -->
    <link rel="stylesheet" href="vendors/datatables.net-bs4/dataTables.bootstrap4.css">
    <link rel="stylesheet" href="js/select.dataTables.min.css">
    <!-- End plugin css for this page -->
    <!-- inject:css -->
    <link rel="stylesheet" href="css/vertical-layout-light/style.css">
    <!-- endinject -->
    <link rel="shortcut icon" href="images/favicon.png" />
</head>
<body>
    <div class="container-fluid page-body-wrapper"> 
        <!-- partial:partials/_sidebar.html -->    
        <c:if test="${sessionScope.acc != null}">
            <nav class="sidebar sidebar-offcanvas" id="sidebar">
                    <ul class="nav">
                        <li class="nav-item">
                            <a class="nav-link" href="dashboard">
                                <i class="mdi mdi-grid-large menu-icon"></i>
                                <span class="menu-title">Dashboard</span>
                            </a>
                        </li>
                        <li class="nav-item nav-category">User List</li>
                        <li class="nav-item">
                            <a class="nav-link" data-bs-toggle="collapse" href="#ui-basic" aria-expanded="false" aria-controls="ui-basic">
                                <i class="menu-icon mdi mdi-floor-plan"></i>
                                <span class="menu-title">User List</span>
                                <i class="menu-arrow"></i> 
                            </a>
                            <div class="collapse" id="ui-basic">
                                <ul class="nav flex-column sub-menu">
                                    <li class="nav-item"> <a class="nav-link" href="userlist">User List</a></li>
                                </ul>
                            </div>
                        </li>
                        <li class="nav-item nav-category">Setting</li>
                        <li class="nav-item">
                            <a class="nav-link" data-bs-toggle="collapse" href="#icons" aria-expanded="false" aria-controls="icons">
                                <i class="menu-icon mdi mdi-layers-outline"></i>
                                <span class="menu-title">Setting List</span>
                                <i class="menu-arrow"></i>
                            </a>
                            <div class="collapse" id="icons">
                                <ul class="nav flex-column sub-menu">
                                    <li class="nav-item"><a class="nav-link" href="settinglist">Setting List</a></li>
                                </ul>
                            </div>
                        </li>
                        <li class="nav-item nav-category">Subject</li>
                        <li class="nav-item">
                            <a class="nav-link" data-bs-toggle="collapse" href="#icons" aria-expanded="false" aria-controls="icons">
                                <i class="menu-icon mdi mdi-layers-outline"></i>
                                <span class="menu-title">Subject</span>
                                <i class="menu-arrow"></i>
                            </a>
                            <div class="collapse" id="icons">
                                <ul class="nav flex-column sub-menu">
                                    <li class="nav-item"><a class="nav-link" href="subjectcontroller">Subject List</a></li>
                                </ul>
                            </div>
                            <div class="collapse" id="icons">
                                <ul class="nav flex-column sub-menu">
                                    <li class="nav-item"><a class="nav-link" href="SubjectDetails.jsp">Subject Details</a></li>
                                </ul>
                            </div>
                        </li>   
                        <li class="nav-item nav-category">Subject Setting</li>
                        <li class="nav-item">
                            <a class="nav-link" data-bs-toggle="collapse" href="#icons" aria-expanded="false" aria-controls="icons">
                                <i class="menu-icon mdi mdi-layers-outline"></i>
                                <span class="menu-title">Subject Setting</span>
                                <i class="menu-arrow"></i>
                            </a>
                            <div class="collapse" id="icons">
                                <ul class="nav flex-column sub-menu">
                                    <li class="nav-item"><a class="nav-link" href="subjectcontroller">Subject Setting List</a></li>
                                </ul>
                            </div>
                            <div class="collapse" id="icons">
                                <ul class="nav flex-column sub-menu">
                                    <li class="nav-item"><a class="nav-link" href="SubjectDetails.jsp">Subject Setting Details</a></li>
                                </ul>
                            </div>
                        </li>   
                        <li class="nav-item nav-category">User</li>
                        <li class="nav-item">
                            <a class="nav-link" data-bs-toggle="collapse" href="#auth" aria-expanded="false" aria-controls="auth">
                                <i class="menu-icon mdi mdi-account-circle-outline"></i>
                                <span class="menu-title">User profile</span>
                                <i class="menu-arrow"></i>
                            </a>
                            <div class="collapse" id="auth">
                                <ul class="nav flex-column sub-menu">
                                    <li class="nav-item"> <a class="nav-link" href="logOut.jsp"> LogOut </a></li>
                                </ul>
                            </div>
                        </li>
                        <li class="nav-item nav-category">help</li>
                        <li class="nav-item">
                            <a class="nav-link" href="http://bootstrapdash.com/demo/star-admin2-free/docs/documentation.html">
                                <i class="menu-icon mdi mdi-file-document"></i>
                                <span class="menu-title">Documentation</span>
                            </a>
                        </li>
                    </ul>
                </nav>
            </c:if>
        </div>
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
