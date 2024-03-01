<%-- 
    Author     : Phuc
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>      
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css">
        <title>Iteration List</title>
        <style type="text/css">
            .group{
                padding: 10px;
                border-radius: 25px;
                display: inline-block;
                text-decoration: none;
            }
            .group1{
                padding: 10px 100px;
                border-radius: 25px;
            }
            .group11{
                padding: 10px 300px;
                border-radius: 25px;
            }
            .Title{
                font-size: 30px;
                color: red;
                font-weight: bold;
                padding-bottom: 60px;
            }
            .name1{
                padding: 10px 87px;
                border-radius: 10px;
            }
            .area{
                padding-top: 15px;
            }
            .ad{
                float: right;
            }
            .group111{
                padding: 35px 190px;
                border-radius: 20px;
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
                                                <h1 class=" display1 card-title card-title-dash">Iterationlist List</h1>

                                            </div>
                                            <div >

                                                <button class="btn btn-md btn-primary btn-rounded  text-white mb-0 me-0" type="button"  onclick="location.href = 'iterationadd';" ><i mdi mdi-account-plus ></i> Add Iteration </button>
                                            </div>

                                        </div>
                                        <form action="iterationlist" method="get" >
                                            <div class="d-sm-flex justify-content align-items-start">
                                                <span class="dropdown" name="status">
                                                    <button class="btn btn-primary btn-rounded  dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                                        ${fromsb} 
                                                    </button>
                                                    <div class="dropdown-menu " aria-labelledby="dropdownMenuButton1" name="status">
                                                        <a class="dropdown-item"   onclick="location.href = './iterationlist';">All Subject ID</a>

                                                        <c:forEach items="${listS}" var="s" >
                                                            <a class="dropdown-item"  value="${s.getSubject_id()}" onclick="location.href = './iterationlist?action=search&sbid=${s.getSubject_name()}';">${s.getSubject_name()} ( ${s.getSubject_id()})</a>
                                                        </c:forEach>
                                                    </div>
                                                </span>

                                                <span class="btn-md col-lg-6" >
                                                    <input type="text" class="btn btn-lg btn-rounded form-control" placeholder="Type Iteration Name " name="searchby"/>
                                                </span>

                                                <button type="submit" class="btn btn-danger btn-rounded btn-fw" name="action" value ="search" >Search</button>

                                            </div>
                                        </form>
                                        <div class="table-responsive">
                                            <table class="table table-striped">
                                                <thead>
                                                    <tr>

                                                        <th>Iteration ID</th>
                                                        <th>Iteration Name</th>
                                                        <th>Subject ID</th>
                                                        <th>Duration</th>
                                                        <th>Status</th>
                                                        <th>Action</th>


                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach items="${list}" var="i" >
                                                        <tr>

                                                            <td>
                                                                ${i.getId()}
                                                            </td>
                                                            <td>
                                                                ${i.getName()}
                                                            </td>
                                                            <td>
                                                                ${i.getSubjectid()}
                                                            </td>
                                                            <td>
                                                                <fmt:formatDate value="${i.getDuration()}" pattern="dd-MM-yyyy" />
                                                            </td>
                                                            <td>
                                                                <c:choose> 
                                                                    <c:when test="${i.getStatus() == 1}">

                                                                        Active

                                                                    </c:when>
                                                                    <c:otherwise>

                                                                        InActive

                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </td>
                                                            <td> 
                                                                <c:if test="${sessionScope.acc.rollId == 0}" >
                                                                    <span>
                                                                        <button class="btn btn-warning btn-rounded btn-fw text-white mb-0 me-0" style = "height: 45px"type="button" onclick="location.href = './iterationdetails?iterID=${i.getId()}';"><i >Edit</i></button>

                                                                    </span>
                                                                </c:if>
                                                                <c:if test="${sessionScope.acc.rollId == 1}" >
                                                                    <span>
                                                                        <button class="btn btn-warning btn-rounded btn-fw text-white mb-0 me-0" style = "height: 45px"type="button" onclick="location.href = './iterationdetails?iterID=${i.getId()}';"><i >Edit</i></button>

                                                                    </span>
                                                                </c:if>
                                                                <c:if test="${sessionScope.acc.rollId == 2}" >
                                                                    <span>
                                                                        <button class="btn btn-warning btn-rounded btn-fw text-white mb-0 me-0" style = "height: 45px"type="button" onclick="location.href = './iterationdetails?iterID=${i.getId()}';"><i >View</i></button>

                                                                    </span>
                                                                </c:if>
                                                                <c:if test="${sessionScope.acc.rollId == 0}" >
                                                                <span>
                                                                    <c:choose> 
                                                                        <c:when test="${i.getStatus() == 0}">
                                                                            <button class="btn btn-primary btn-rounded btn-fw  text-white mb-0 me-0" style = "height: 45px"type="button" onclick="location.href = './iterationlist?action=change&id=${i.getId()}';">
                                                                                <i >
                                                                                    Active
                                                                                </i>
                                                                            </button>
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <button class="btn btn-info btn-rounded btn-fw  text-white mb-0 me-0" style = "height: 45px"type="button" onclick="location.href = './iterationlist?action=change&id=${i.getId()}';">
                                                                                <i>
                                                                                    InActive
                                                                                </i>
                                                                            </button>
                                                                        </c:otherwise>
                                                                    </c:choose>
                                                                </span>
                                                                </c:if>
                                                                <c:if test="${sessionScope.acc.rollId == 1}" >
                                                                <span>
                                                                    <c:choose> 
                                                                        <c:when test="${i.getStatus() == 0}">
                                                                            <button class="btn btn-primary btn-rounded btn-fw  text-white mb-0 me-0" style = "height: 45px"type="button" onclick="location.href = './iterationlist?action=change&id=${i.getId()}';">
                                                                                <i >
                                                                                    Active
                                                                                </i>
                                                                            </button>
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <button class="btn btn-info btn-rounded btn-fw  text-white mb-0 me-0" style = "height: 45px"type="button" onclick="location.href = './iterationlist?action=change&id=${i.getId()}';">
                                                                                <i>
                                                                                    InActive
                                                                                </i>
                                                                            </button>
                                                                        </c:otherwise>
                                                                    </c:choose>
                                                                </span>
                                                                </c:if>
                                                            </td>
                                                        </tr>
                                                    </c:forEach>




                                                </tbody>
                                            </table>
                                            <nav aria-label="Page navigation example" class="d-flex justify-content-center">


                                                <ul class="pagination">
                                                    <li class="page-item"><a class="page-link" href="./iterationlist">Previous</a></li>
                                                        <c:forEach var="o" begin = "1" end="${size}"  >
                                                        <li class="page-item"><a class="page-link" href="./iterationlist?page=${o}">${o}</a></li>
                                                        </c:forEach>                                                        
                                                    <li class="page-item"><a class="page-link" href="./iterationlist">Next</a></li>
                                                </ul>

                                            </nav>
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
    <script>
        function doChange(id) {
            if (confirm("are U sure to Block User ID = " + id + "?")) {
                window.location = "iterationlist?action=change&id=" + id;
            }
        }
    </script>
    <script type="text/javascript">
        toastr.options.closeButton = true;
        toastr.options.progressBar = true;
        toastr.options.positionClass = 'toast-top-right';
        function interationadd() {
            toastr.success('Successful', 'Add');
        }
    </script>

</html>


