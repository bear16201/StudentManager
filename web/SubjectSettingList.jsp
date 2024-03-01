<%-- 
    Author     : Phuc
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Subject Setting List</title>
        <style type="text/css">
            .group{
                padding: 10px;
                border-radius: 25px;
                display: inline-block;
                text-decoration: none;
            }
            .group1{
                padding: 10px;
                border-radius: 25px;
            }
            .Title{
                font-size: 30px;
                color: red;
                font-weight: bold;
            }
            .active{
                background-color: greenyellow;
            }
            ul a{
                text-decoration: none;
            }
            .se{
                display: flex;              
            }
        </style>
    </head>
    <body>
        <!--content -->
        <div class="container-scroller">
            <!--header -->
            <%@include file="header.jsp" %>
            <!--header -->

            <!--main -->
            <div class="main-panel">   
                <c:if test="${sessionScope.acc == null}">
                    <div class="d-sm-flex justify-content-between align-items-start">
                        <div>
                            <h1 class="text-danger">You need login</h1>
                        </div>                          
                    </div>
                </c:if>
                <c:if test="${sessionScope.acc != null}">
                    <div class="content-wrapper">
                        <div class="row">
                            <div class="col-lg-12 grid-margin stretch-card">
                                <div class="card">
                                    <div class="card-body">
                                        <div class="d-sm-flex justify-content-between align-items-start">
                                            <div>
                                                <h1 class=" Title">Subject Setting List</h1>
                                            </div>
                                            <div >
                                                <button class="btn btn-md btn-primary btn-rounded  text-white mb-0 me-0" type="button"  onclick="location.href = './SettingAdd.jsp';" ><i mdi mdi-account-plus ></i> Add Setting</button>
                                            </div>
                                        </div>
                                        <div class="d-sm-flex justify-content align-items-start">
                                            <span class="dropdown ">
                                                <button class="btn btn-primary btn-rounded  dropdown-toggle " type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                                    All Setting Types
                                                </button>
                                                <div class="dropdown-menu " aria-labelledby="dropdownMenuButton1">            
                                                    <c:forEach items="${list}" var="t">                                          
                                                        <a class="dropdown-item">${t.status}</a>
                                                    </c:forEach>                                   
                                                </div>
                                            </span>
                                            <!--                                            <span class="dropdown ">
                                                                                            <button class="btn btn-primary btn-rounded  dropdown-toggle " type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                                                                                Type Setting Name To Search
                                                                                            </button>
                                                                                            <div class="dropdown-menu " aria-labelledby="dropdownMenuButton1">
                                            <c:forEach items="${list}" var="n">
                                                <a class="dropdown-item">${n.title}</a>
                                            </c:forEach>
                                        </div>
                                    </span>-->
                                            <span class="dropdown">
                                                <button class="btn btn-primary btn-rounded  dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                                    All Status
                                                </button>
                                                <div class="dropdown-menu " aria-labelledby="dropdownMenuButton1">                                              
                                                    <a class="dropdown-item" href="#">Active</a>
                                                    <a class="dropdown-item" href="#">Inactive</a>
                                                </div>
                                            </span>
                                            <form action="search" method="get" class="btn-md col-lg-6">
                                                <div class="se">
                                                    <span class="btn-md col-lg-6" >
                                                        <input type="text" class="btn btn-lg btn-rounded form-control" name="txt" placeholder="Setting Type, Name, Order, Value to search"/>
                                                    </span>
                                                    <button type="submit" class="btn btn-danger btn-rounded btn-fw">Search</button>
                                                </div>
                                            </form>
                                        </div>
                                        <div class="table-responsive">
                                            <table class="table table-striped">
                                                <thead>
                                                    <tr>
                                                        <th>Subject ID</th>
                                                        <th>Type ID</th>
                                                        <th>Setting Title</th>
                                                        <th>Setting Value</th>
                                                        <th>Order</th>
                                                        <th>Status</th>
                                                        <th>Action</th>
                                                    </tr>
                                                </thead>
                                                <c:forEach items="${list}" var="o">
                                                    <tbody>
                                                        <tr>
                                                            <td>${o.subject_id}</td>
                                                            <td>${o.type_id}</td>
                                                            <td>${o.title}</td>
                                                            <td>${o.order}</td>
                                                            <td>${o.value}</td>                                                      
                                                            <td>
                                                                <c:if test="${o.status == 1}">
                                                                    <a>Actice</a>
                                                                </c:if>
                                                                <c:if test="${o.status == 0}">
                                                                    <a>Inactice</a>
                                                                </c:if>
                                                            </td>
                                                            <td>       
                                                                <c:if test="${sessionScope.acc.rollId == 2}" >
                                                                    <span>
                                                                        <button class="btn btn-warning btn-rounded btn-fw text-white mb-0 me-0" style = "height: 45px"type="button" onclick="location.href = './subjectsettingdetail?sid=${o.id}';"><i >Edit</i></button>
                                                                    </span>   
                                                                </c:if>
                                                                <c:if test="${sessionScope.acc.rollId == 0}" >
                                                                    <span>
                                                                        <button class="btn btn-warning btn-rounded btn-fw text-white mb-0 me-0" style = "height: 45px"type="button" onclick="location.href = './subjectsettingdetail?sid=${o.id}';"><i >Edit</i></button>
                                                                    </span>   
                                                                </c:if>
                                                                <c:if test="${sessionScope.acc.rollId == 1}" >
                                                                    <span>
                                                                        <button class="btn btn-warning btn-rounded btn-fw text-white mb-0 me-0" style = "height: 45px"type="button" onclick="location.href = './subjectsettingdetail?sid=${o.id}';"><i >View</i></button>
                                                                    </span>   
                                                                </c:if>

                                                                <c:choose> 
                                                                    <c:when test="${o.status.equals('1')}">
                                                                        <button class="btn btn-danger btn-rounded btn-fw  text-white mb-0 me-0" style = "height: 45px"type="button" onclick="location.href = './subjectsettinglist?action=change&id=${o.getType_id()}';">
                                                                            <i>
                                                                                Inactive
                                                                            </i>
                                                                        </button>
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        <button class="btn btn-info btn-rounded btn-fw  text-white mb-0 me-0" style = "height: 45px"type="button" onclick="location.href = './subjectsettinglist?action=change&id=${o.getType_id()}';">
                                                                            <i>
                                                                                Active
                                                                            </i>
                                                                        </button>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </td>
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                            <!-- pagination -->
                                            <nav aria-label="Page navigation example" class="d-flex justify-content-center">
                                                <ul class="pagination">
                                                    <c:forEach begin="1" end="${endP}" var="i">                                                   
                                                        <li class="page-item"><a class="page-link" href="subjectsettinglist?index=${i}">${i}</a></li>
                                                        </c:forEach>
                                                </ul>
                                            </nav>
                                            <!-- pagination -->
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:if>
            </div>        
            <!--main -->
        </div>
        <!--content -->        

        <!--footer -->
        <%@include file="footer.jsp" %>
        <!--footer -->
    </body>

</html>


