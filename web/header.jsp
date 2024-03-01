<%-- 
    Document   : header
    Created on : May 26, 2022, 12:44:26 PM
    Author     : NamOK
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
        <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.css">
        <link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css">
    </head>
    <body>
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
        <!-- partial -->
        <div class="container-fluid page-body-wrapper">
            <!-- partial:partials/_settings-panel.html -->
            <div class="theme-setting-wrapper">
                <div id="settings-trigger"><i class="ti-settings"></i></div>
                <div id="theme-settings" class="settings-panel">
                    <i class="settings-close ti-close"></i>
                    <p class="settings-heading">SIDEBAR SKINS</p>
                    <div class="sidebar-bg-options selected" id="sidebar-light-theme"><div class="img-ss rounded-circle bg-light border me-3"></div>Light</div>
                    <div class="sidebar-bg-options" id="sidebar-dark-theme"><div class="img-ss rounded-circle bg-dark border me-3"></div>Dark</div>
                    <p class="settings-heading mt-2">HEADER SKINS</p>
                    <div class="color-tiles mx-0 px-4">
                        <div class="tiles success"></div>
                        <div class="tiles warning"></div>
                        <div class="tiles danger"></div>
                        <div class="tiles info"></div>
                        <div class="tiles dark"></div>
                        <div class="tiles default"></div>
                    </div>
                </div>
            </div>      
            <!-- partial -->
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

                        <li class="nav-item">
                            <a class="nav-link" data-bs-toggle="collapse" href="#ui-basic" aria-expanded="false" aria-controls="ui-basic">
                                <i class="menu-icon mdi mdi-account-circle-outline"></i>
                                <span class="menu-title">User</span>
                                <i class="menu-arrow"></i> 
                            </a>
                            <div class="collapse" id="ui-basic">
                                <ul class="nav flex-column sub-menu">
                                    <li class="nav-item"> <a class="nav-link" href="./userlist">User List</a></li>
                                    <li class="nav-item"> <a class="nav-link" href="./add">Add User</a></li>
                                </ul>
                            </div>
                        </li>


                        <li class="nav-item">
                            <a class="nav-link" data-bs-toggle="collapse" href="#form-elements" aria-expanded="false" aria-controls="form-elements">
                                <i class="menu-icon mdi mdi-card-text-outline"></i>
                                <span class="menu-title">Setting</span>
                                <i class="menu-arrow"></i>
                            </a>
                            <div class="collapse" id="form-elements">
                                <ul class="nav flex-column sub-menu">
                                    <li class="nav-item"><a class="nav-link" href="settinglist">Setting List</a></li>
                                    <li class="nav-item"><a class="nav-link" href="SettingAdd.jsp">Add Setting</a></li>
                                </ul>
                            </div>
                        </li>


                        <li class="nav-item">
                            <a class="nav-link" data-bs-toggle="collapse" href="#icons" aria-expanded="false" aria-controls="icons">
                                <i class="menu-icon mdi mdi-layers-outline"></i>
                                <span class="menu-title">Subject</span>
                                <i class="menu-arrow"></i>
                            </a>
                            <div class="collapse" id="icons">
                                <ul class="nav flex-column sub-menu">
                                    <li class="nav-item"> <a class="nav-link" href="subjectcontroller">Subject List</a></li>
                                    <li class="nav-item"> <a class="nav-link" href="SubjectAdd.jsp">Add Subject</a></li>
                                </ul>
                            </div>
                        </li>
                        <!--         Iteration         -->
                        <li class="nav-item">
                            <a class="nav-link" data-bs-toggle="collapse" href="#auth" aria-expanded="false" aria-controls="auth">
                                <i class="menu-icon mdi mdi-application"></i>
                                <span class="menu-title">Iteration</span>
                                <i class="menu-arrow"></i>
                            </a>
                            <div class="collapse" id="auth">
                                <ul class="nav flex-column sub-menu">
                                    <li class="nav-item"> <a class="nav-link" href="./iterationlist">Iteration List</a></li>
                                    <li class="nav-item"> <a class="nav-link" href="./iterationadd">Add Iteration</a></li>
                                </ul>
                            </div>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" data-bs-toggle="collapse" href="#subl" aria-expanded="false" aria-controls="ui-basic">
                                <i class="menu-icon mdi mdi-apple-finder"></i>
                                <span class="menu-title">Subject Setting</span>
                                <i class="menu-arrow"></i> 
                            </a>
                            <div class="collapse" id="subl">
                                <ul class="nav flex-column sub-menu">
                                    <li class="nav-item"> <a class="nav-link" href="./subjectsettinglist">Subject Setting List</a></li>
                                    <li class="nav-item"> <a class="nav-link" href="#">Add Subject Setting</a></li>
                                </ul>
                            </div>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" data-bs-toggle="collapse" href="#criteria" aria-expanded="false" aria-controls="ui-basic">
                                <i class="menu-icon mdi mdi-arrange-bring-forward"></i>
                                <span class="menu-title">Criteria</span>
                                <i class="menu-arrow"></i> 
                            </a>
                            <div class="collapse" id="criteria">
                                <ul class="nav flex-column sub-menu">
                                    <li class="nav-item"> <a class="nav-link" href="./criterialist">Criteria List</a></li>
                                    <li class="nav-item"> <a class="nav-link" href="./criteriaadd">Add Criteria</a></li>
                                </ul>
                            </div>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" data-bs-toggle="collapse" href="#miston" aria-expanded="false" aria-controls="ui-basic">
                                <i class="menu-icon mdi mdi-calendar-check"></i>
                                <span class="menu-title">Milestone</span>
                                <i class="menu-arrow"></i> 
                            </a>
                            <div class="collapse" id="miston">
                                <ul class="nav flex-column sub-menu">
                                    <li class="nav-item"> <a class="nav-link" href="./milestone">Milestone List</a></li>
                                    <li class="nav-item"> <a class="nav-link" href="./milestonedetail">Add Milestone</a></li>
                                </ul>
                            </div>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" data-bs-toggle="collapse" href="#team" aria-expanded="false" aria-controls="ui-basic">
                                <i class="menu-icon mdi mdi-account-multiple"></i>
                                <span class="menu-title">Team</span>
                                <i class="menu-arrow"></i> 
                            </a>
                            <div class="collapse" id="team">
                                <ul class="nav flex-column sub-menu">
                                    <li class="nav-item"> <a class="nav-link" href="./teamlist">Team List</a></li>
                                    <li class="nav-item"> <a class="nav-link" href="./teamadd">Add Team</a></li>
                                </ul>
                            </div>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" data-bs-toggle="collapse" href="#clas" aria-expanded="false" aria-controls="ui-basic">
                                <i class="menu-icon mdi mdi-format-line-weight"></i>
                                <span class="menu-title">Class</span>
                                <i class="menu-arrow"></i> 
                            </a>
                            <div class="collapse" id="clas">
                                <ul class="nav flex-column sub-menu">
                                    <li class="nav-item"> <a class="nav-link" href="./classList">Class List</a></li>
                                    <li class="nav-item"> <a class="nav-link" href="./classAdd">Add Class</a></li>
                                </ul>
                            </div>
                        </li>       
                        <li class="nav-item">
                            <a class="nav-link" data-bs-toggle="collapse" href="#classuser" aria-expanded="false" aria-controls="ui-basic">
                                <i class="menu-icon mdi mdi-group"></i>
                                <span class="menu-title">Class Users</span>
                                <i class="menu-arrow"></i> 
                            </a>
                            <div class="collapse" id="classuser">
                                <ul class="nav flex-column sub-menu">
                                    <li class="nav-item"> <a class="nav-link" href="./classuserlist">Class Users List</a></li>
                                    <li class="nav-item"> <a class="nav-link" href="ClassUserAdd.jsp">Add Class Users</a></li>
                                </ul>
                            </div>
                        </li>         
                        <li class="nav-item">
                            <a class="nav-link" data-bs-toggle="collapse" href="#fea" aria-expanded="false" aria-controls="ui-basic">
                                <i class="menu-icon mdi mdi-image-filter-tilt-shift"></i>
                                <span class="menu-title">Feature</span>
                                <i class="menu-arrow"></i> 
                            </a>
                            <div class="collapse" id="fea">
                                <ul class="nav flex-column sub-menu">
                                    <li class="nav-item"> <a class="nav-link" href="./featurelist">Feature List</a></li>
                                    <li class="nav-item"> <a class="nav-link" href="AddFeature.jsp">Add Feature</a></li>
                                </ul>
                            </div>
                        </li>    
                        <li class="nav-item">
                            <a class="nav-link" data-bs-toggle="collapse" href="#fun" aria-expanded="false" aria-controls="ui-basic">
                                <i class="menu-icon mdi mdi-dropbox"></i>
                                <span class="menu-title">Function</span>
                                <i class="menu-arrow"></i> 
                            </a>
                            <div class="collapse" id="fun">
                                <ul class="nav flex-column sub-menu">
                                    <li class="nav-item"> <a class="nav-link" href="./functionlist">Function List</a></li>
                                    <li class="nav-item"> <a class="nav-link" href="./functionadd">Add Function</a></li>
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
            <!-- partial -->
    </body>
    <script src="js/table2excel.js" type="text/javascript"></script>
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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script> 