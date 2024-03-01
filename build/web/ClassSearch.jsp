<%-- 
    Author     : Phuc
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Class Search</title>   
        <style type="text/css">
            .Title{
                font-size: 30px;
                color: red;
                font-weight: bold;
                padding-bottom: 60px;
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
                                                <h1 class=" Title">Class List</h1>
                                            </div>
                                        </div>
                                        <div class="d-sm-flex justify-content align-items-start" >
                                            <span class="dropdown " style="padding: 10px;">
                                                <button class="btn btn-primary btn-rounded  dropdown-toggle " type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                                    All Subject
                                                </button>
                                                <div class="dropdown-menu " aria-labelledby="dropdownMenuButton1">     
                                                    <c:forEach items="${listSub}" var="listSub">
                                                        <a class="dropdown-item" href="sortClass?action=sortbySubID&SubID=${listSub.subject_id}">${listSub.subject_id}</a>
                                                    </c:forEach>


                                                </div>
                                            </span>
                                            <span class="dropdown" style="padding: 10px;">
                                                <button class="btn btn-primary btn-rounded  dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                                    All Block 5
                                                </button>
                                                <div class="dropdown-menu " aria-labelledby="dropdownMenuButton1">                                              
                                                    <a class="dropdown-item" href="sortClass?action=sortbyBlock1">Yes</a>
                                                    <a class="dropdown-item" href="sortClass?action=sortbyBlock0">No</a>

                                                </div>
                                            </span>
                                            <span class="dropdown" style="padding: 10px;">
                                                <button class="btn btn-primary btn-rounded  dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                                    All Status
                                                </button>
                                                <div class="dropdown-menu " aria-labelledby="dropdownMenuButton1">                                              
                                                    <a class="dropdown-item" href="sortClass?action=sortbystatus1">Active</a>
                                                    <a class="dropdown-item" href="sortClass?action=sortbystatus0">Inactive</a>

                                                </div>
                                            </span>
                                            <!--                                            <form action="searchClass" method="get" class="btn-md col-lg-4" style="padding: 10px;">
                                                                                            <div class="se" style="float: right">
                                                                                                <span class="btn-md col-lg-4" >
                                                                                                    <input type="text" class="btn btn-lg btn-rounded form-control" name="txt" style="width: 250px" placeholder="Search Class"/>                                                    
                                                                                                </span>
                                                                                            </div>
                                                                                            <div class="se" style="float: left">
                                                                                                <button type="submit" class="btn btn-danger btn-rounded btn-fw">Search</button>
                                                                                            </div>
                                                                                        </form>-->
                                            <div style="padding: 10px;     padding-left: 527px;">
                                                <button class="btn btn-md btn-primary btn-rounded  text-white mb-0 me-0" type="button"  onclick="location.href = './ClassAdd.jsp';" ><i mdi mdi-account-plus ></i> Add Subject</button>
                                            </div>
                                        </div>
                                        <div class="table-responsive">
                                            <table class="table table-striped" style="justify-content: space-around">
                                                <thead>
                                                    <tr>
                                                        <th>Class ID</th>
                                                        <th>Class Code</th>
                                                        <th>Trainer ID</th>
                                                        <th>Subject ID</th>
                                                        <th>Year</th>
                                                        <th>Class Term</th>
                                                        <th>Block 5</th>
                                                        <th>Status</th>

                                                    </tr>
                                                </thead>
                                                <c:forEach items="${list}" var="o">
                                                    <tr>
                                                        <td style="width: 200px;">${o.classID}</td>
                                                        <td style="width: 200px;">${o.classCode}</td>
                                                        <td style="width: 200px;">${o.trainerID}</td>
                                                        <td style="width: 200px;">${o.subjectID}</td>                                                    
                                                        <td style="width: 200px;">${o.classYear}</td>
                                                        <td style="width: 200px;">${o.classTerm}</td>
                                                        <td style="width: 200px;">${o.block5Class}</td>
                                                        <td style="width: 200px;">
                                                            <c:if test="${o.status == 1}">
                                                                <a>Actice</a>
                                                            </c:if>
                                                            <c:if test="${o.status == 0}">
                                                                <a>Inactice</a>
                                                            </c:if>
                                                        </td>
                                                        <td >                                        
                                                            <span>
                                                                <c:choose> 
                                                                    <c:when test="${o.status.equals('1')}">
                                                                        <button class="btn btn-danger btn-rounded btn-fw  text-white mb-0 me-0" type="button" style="width: 90px; text-align: center" onclick="location.href = './searchClass?action=change&id=${o.classID}&txt=${txtSearch}';">
                                                                            Inactive
                                                                        </button>
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        <button class="btn btn-info btn-rounded btn-fw  text-white mb-0 me-0"type="button" style="width: 90px; text-align: center" onclick="location.href = './searchClass?action=change&id=${o.classID}&txt=${txtSearch}';">
                                                                            Active
                                                                        </button>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </span>   
                                                            <c:if test="${sessionScope.acc.rollId == 0}" >
                                                                <span>
                                                                    <button class="btn btn-warning btn-rounded btn-fw text-white mb-0 me-0"type="button" style="width: 90px; text-align: center" onclick="location.href = '#';"> Edit</button>
                                                                </span> 
                                                            </c:if>
                                                            <c:if test="${sessionScope.acc.rollId == 1}" >
                                                                <span>
                                                                    <button class="btn btn-warning btn-rounded btn-fw text-white mb-0 me-0"type="button" style="width: 90px; text-align: center" onclick="location.href = '#';"> View</button>
                                                                </span> 
                                                            </c:if>


                                                        </td>  
                                                    </tr>
                                                </c:forEach>
                                                </tbody>
                                            </table>
                                            <!-- pagination -->
                                            <nav aria-label="Page navigation example" class="d-flex justify-content-center">
                                                <ul class="pagination">
                                                    <c:forEach begin="1" end="${endP}" var="i">                                                   
                                                        <li class="page-item"><a class="page-link" href="classList?index=${i}">${i}</a></li>
                                                        </c:forEach>
                                                </ul>
                                            </nav>

                                            <!-- pagination -->
                                        </div>
                                    </div>
                                    <span class="ad">
                                        <a href="classList"><button class="btn btn-danger btn-rounded btn-fw  text-white mb-0 me-0" style = "height: 45px;padding-right: 10px; float: right;"type="button">
                                                <i>
                                                    Back to Class List
                                                </i>
                                            </button>
                                        </a>
                                    </span>
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


