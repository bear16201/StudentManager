<%-- 
    Author     : Phuc
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Criteria List</title>
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
                                                <h1 class=" Title">Criteria List</h1>
                                            </div>
                                            <div >
                                                <button style="color: rosybrown ; font-weight: bold; background-color: lightgrey; " class="btn btn-md btn-primary btn-rounded  text-white mb-0 me-0" type="button"  onclick="location.href = './criteriaadd';" ><i mdi mdi-account-plus ></i> Add Criteria</button>
                                            </div>
                                        </div>

                                        <div class="d-sm-flex justify-content align-items-start">
                                            <form action="criterialist" method="get" >
                                                <span class="dropdown" name="itername">
                                                    <button class="btn btn-secondary btn-rounded  dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                                        <a style="color: rosybrown ; font-weight: bold; "> ${itername} </a>
                                                    </button>
                                                    <div class="dropdown-menu " aria-labelledby="dropdownMenuButton1" name="status">
                                                        <a class="dropdown-item"   onclick="location.href = './criterialist';">
                                                            <span style="color: rosybrown ; font-weight: bold; ">  All Iteration Name </span>
                                                        </a>
                                                        <c:forEach items="${listI}" var="c" >
                                                            <a class="dropdown-item" name ="All Iteration Name"  value="${c.getName()}" onclick="location.href = './criterialist?action=search&itername=${c.getName()}';"> <span style="color: rosybrown"> ${c.getName()} </span></a>
                                                        </c:forEach>
                                                    </div>
                                                </span>
                                                <span class="dropdown" name="sbname">
                                                    <button class="btn btn-secondary btn-rounded  dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                                        <a style="color: rosybrown ; font-weight: bold; "> ${sbname} </a>
                                                    </button>
                                                    <div class="dropdown-menu " aria-labelledby="dropdownMenuButton1" name="status">
                                                        <a class="dropdown-item"   onclick="location.href = './criterialist';">
                                                            <span style="color: rosybrown ; font-weight: bold; ">  All Subject Name </span>
                                                        </a>
                                                        <c:forEach items="${listS}" var="c" >
                                                            <a class="dropdown-item"  value="${c.getSubject_name()}" onclick="location.href = './criterialist?action=search&sbname=${c.getSubject_name()}';"> <span style="color: rosybrown"> ${c.getSubject_name()} </span></a>
                                                        </c:forEach>
                                                    </div>
                                                </span>
                                                <span class="dropdown" name="status">
                                                    <button class="btn btn-secondary btn-rounded  dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                                        <a style="color: rosybrown ; font-weight: bold; "> ${status} </a>
                                                    </button>
                                                    <div class="dropdown-menu " aria-labelledby="dropdownMenuButton1" name="status">
                                                        <a class="dropdown-item"   onclick="location.href = './criterialist';">
                                                            <span style="color: rosybrown ; font-weight: bold; ">  All Status </span>
                                                        </a>            
                                                        <a class="dropdown-item"  value="0"  onclick="location.href = './criterialist?action=search&status=0';"> <span style="color: red ; font-weight: bold; "> Inactive</span></a>
                                                        <a class="dropdown-item"  value="1"  onclick="location.href = './criterialist?action=search&status=1';"> <span style="color: blue ; font-weight: bold; "> Active </span></a>
                                                    </div>
                                                </span>


                                            </form>
                                            <form action="criteriasearch" method="get" class="btn-md col-lg-6">
                                                <div class="se">
                                                    <span class="btn-md col-lg-6" >
                                                        <input type="text" class="btn btn-lg btn-rounded form-control" name="txt" value="${text}" placeholder="Input what you want to search"/>
                                                    </span>
                                                    <button style="color: rosybrown ; font-weight: bold; background-color: lightgrey; " type="submit" class="btn btn-danger btn-rounded btn-fw">Search</button>
                                                </div>
                                            </form>
                                        </div>
                                        <div class="table-responsive">
                                            <table class="table table-striped">
                                                <thead>
                                                    <tr>

                                                        <th>ID<br>
                                                            <a class="" data-bs-toggle="collapse" onclick="location.href = './criterialist?action=sortIDasc';" aria-expanded="false" aria-controls="ui-basic">
                                                                <i class="menu-icon mdi mdi-arrow-up"></i>
                                                            </a>
                                                            <a class="" data-bs-toggle="collapse" onclick="location.href = './criterialist?action=sortIDdesc';" aria-expanded="false" aria-controls="ui-basic">
                                                                <i class="menu-icon mdi mdi-arrow-down"></i>
                                                            </a>
                                                        </th>
                                                        <th>Name<br>
                                                            <a class="" data-bs-toggle="collapse" onclick="location.href = './criterialist?action=sortIterNameasc';" aria-expanded="false" aria-controls="ui-basic">
                                                                <i class="menu-icon mdi mdi-arrow-up"></i>
                                                            </a>
                                                            <a class="" data-bs-toggle="collapse" onclick="location.href = './criterialist?action=sortIterNamedesc';" aria-expanded="false" aria-controls="ui-basic">
                                                                <i class="menu-icon mdi mdi-arrow-down"></i>
                                                            </a>
                                                        </th>
                                                        <th>Iter<br>
                                                            <a class="" data-bs-toggle="collapse" onclick="location.href = './criterialist?action=sortIterNameasc';" aria-expanded="false" aria-controls="ui-basic">
                                                                <i class="menu-icon mdi mdi-arrow-up"></i>
                                                            </a>
                                                            <a class="" data-bs-toggle="collapse" onclick="location.href = './criterialist?action=sortIterNamedesc';" aria-expanded="false" aria-controls="ui-basic">
                                                                <i class="menu-icon mdi mdi-arrow-down"></i>
                                                            </a>
                                                        </th>
                                                        <th>Subject<br>
                                                            <a class="" data-bs-toggle="collapse" onclick="location.href = './criterialist?action=sortIterNameasc';" aria-expanded="false" aria-controls="ui-basic">
                                                                <i class="menu-icon mdi mdi-arrow-up"></i>
                                                            </a>
                                                            <a class="" data-bs-toggle="collapse" onclick="location.href = './criterialist?action=sortIterNamedesc';" aria-expanded="false" aria-controls="ui-basic">
                                                                <i class="menu-icon mdi mdi-arrow-down"></i>
                                                            </a>
                                                        </th>
                                                        <th>Weight<br>
                                                            <a class="" data-bs-toggle="collapse" onclick="location.href = './criterialist?action=sortWeightasc';" aria-expanded="false" aria-controls="ui-basic">
                                                                <i class="menu-icon mdi mdi-arrow-up"></i>
                                                            </a>
                                                            <a class="" data-bs-toggle="collapse" onclick="location.href = './criterialist?action=sortWeightdesc';" aria-expanded="false" aria-controls="ui-basic">
                                                                <i class="menu-icon mdi mdi-arrow-down"></i>
                                                            </a>
                                                        </th>
                                                        <th>Team<br>
                                                            <a class="" data-bs-toggle="collapse" onclick="location.href = './criterialist?action=sortTeamasc';" aria-expanded="false" aria-controls="ui-basic">
                                                                <i class="menu-icon mdi mdi-arrow-up"></i>
                                                            </a>
                                                            <a class="" data-bs-toggle="collapse" onclick="location.href = './criterialist?action=sortTeamdesc';" aria-expanded="false" aria-controls="ui-basic">
                                                                <i class="menu-icon mdi mdi-arrow-down"></i>
                                                            </a>
                                                        </th>
                                                        <th>Loc<br>
                                                            <a class="" data-bs-toggle="collapse" onclick="location.href = './criterialist?action=sortLocasc';" aria-expanded="false" aria-controls="ui-basic">
                                                                <i class="menu-icon mdi mdi-arrow-up"></i>
                                                            </a>
                                                            <a class="" data-bs-toggle="collapse" onclick="location.href = './criterialist?action=sortLocdesc';" aria-expanded="false" aria-controls="ui-basic">
                                                                <i class="menu-icon mdi mdi-arrow-down"></i>
                                                            </a>
                                                        </th>
                                                        <th>Status<br>
                                                            <a class="" data-bs-toggle="collapse" onclick="location.href = './criterialist?action=sortStatusasc';" aria-expanded="false" aria-controls="ui-basic">
                                                                <i class="menu-icon mdi mdi-arrow-up"></i>
                                                            </a>
                                                            <a class="" data-bs-toggle="collapse" onclick="location.href = './criterialist?action=sortStatusdesc';" aria-expanded="false" aria-controls="ui-basic">
                                                                <i class="menu-icon mdi mdi-arrow-down"></i>
                                                            </a>
                                                        </th>
                                                        <th>Action</th>

                                                    </tr>
                                                </thead>
                                                <c:forEach items="${list}" var="o">
                                                    <tbody>
                                                        <tr>
                                                            <td>${o.criteria_id}</td>
                                                            <td>${o.criteria_name}</td>
                                                            <td>${o.iteration_name}</td>
                                                            <td>${o.subject_name}</td>
                                                            <td>${o.evaluation_weight}</td>
                                                            <td>
                                                                <c:if test="${o.team_evaluation == 1}">
                                                                    <a>Yes</a>
                                                                </c:if>
                                                                <c:if test="${o.team_evaluation == 0}">
                                                                    <a>No</a>
                                                                </c:if>
                                                            </td>    
                                                            <td>${o.max_loc}</td>
                                                            <td>
                                                                <c:if test="${sessionScope.acc.rollId == 0}" >
                                                                    <c:choose> 
                                                                        <c:when test="${o.getStatus() == 0}">
                                                                            <button id="showMess" class="btn btn-info btn-rounded btn-fw  text-white mb-0 me-0" type="button" style="width: 100px; text-align: center" data-bs-toggle="modal" data-bs-target="#myModal">
                                                                                Active
                                                                            </button>
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <button id="showMess" class="btn btn-danger btn-rounded btn-fw  text-white mb-0 me-0"type="button" style="width: 100px; text-align: center" data-bs-toggle="modal" data-bs-target="#myModal">
                                                                                Inactive
                                                                            </button>
                                                                        </c:otherwise>
                                                                    </c:choose>
                                                                </c:if>
                                                                <c:if test="${sessionScope.acc.rollId == 1}" >

                                                                    <c:choose> 
                                                                        <c:when test="${o.getStatus() == 0}">
                                                                            <button id="showMess" class="btn btn-info btn-rounded btn-fw  text-white mb-0 me-0" type="button" style="width: 100px; text-align: center" data-bs-toggle="modal" data-bs-target="#myModal">
                                                                                Active
                                                                            </button>
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <button id="showMess" class="btn btn-danger btn-rounded btn-fw  text-white mb-0 me-0"type="button" style="width: 100px; text-align: center" data-bs-toggle="modal" data-bs-target="#myModal">
                                                                                Inactive
                                                                            </button>
                                                                        </c:otherwise>
                                                                    </c:choose>
                                                                </c:if>
                                                                <c:if test="${sessionScope.acc.rollId == 2}" >
                                                                    <c:if test="${o.status == 1}">
                                                                        <a class="btn btn-info btn-rounded btn-fw  text-white mb-0 me-0" style = "height: 45px">Actice</a>
                                                                    </c:if>
                                                                    <c:if test="${o.status == 0}">
                                                                        <a class="btn btn-danger btn-rounded btn-fw  text-white mb-0 me-0" style = "height: 45px">Inactice</a>
                                                                    </c:if>
                                                                </c:if>
                                                            </td>
                                                            <td>        
                                                                <c:if test="${sessionScope.acc.rollId == 0}" >
                                                                    <span>
                                                                        <button class="btn btn-warning btn-rounded btn-fw text-white mb-0 me-0" style = "height: 45px"type="button" onclick="location.href = './criteriadetails?critID=${o.criteria_id}';"><i >Edit</i></button>
                                                                    </span>   
                                                                </c:if>
                                                                <c:if test="${sessionScope.acc.rollId == 1}" >
                                                                    <span>
                                                                        <button class="btn btn-warning btn-rounded btn-fw text-white mb-0 me-0" style = "height: 45px"type="button" onclick="location.href = './criteriadetails?critID=${o.criteria_id}';"><i >Edit</i></button>
                                                                    </span>   
                                                                </c:if>
                                                                <c:if test="${sessionScope.acc.rollId == 2}" >
                                                                    <span>
                                                                        <button class="btn btn-warning btn-rounded btn-fw text-white mb-0 me-0" style = "height: 45px"type="button" onclick="location.href = './criteriadetails?critID=${o.criteria_id}';"><i >View</i></button>
                                                                    </span>   
                                                                </c:if>

                                                            </td>
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                            <c:forEach items="${list}" var="o">
                                                <!-- The Modal -->
                                                <div class="modal" id="myModal">
                                                    <div class="modal-dialog">
                                                        <div class="modal-content">
                                                            <form action="criterialist?action=change&id=${o.criteria_id}" method="post">
                                                                <div class="modal-header">
                                                                    <h4 class="modal-title">Confirm change status</h4>
                                                                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                                                                </div>
                                                                <div class="modal-body">
                                                                    Are you sure want to change status Criteria ID = ${o.criteria_id}?
                                                                </div>
                                                                <div class="modal-footer">
                                                                    <button type="submit" class="btn btn-danger">Confirm</button>
                                                                    <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
                                                                </div>
                                                            </form>
                                                        </div>
                                                    </div>
                                                </div>
                                            </c:forEach>
                                            <nav aria-label="Page navigation example" class="d-flex justify-content-center">
                                                <ul class="pagination">
                                                    <li class="page-item"><a class="page-link" href="criterialist?index=${i-1}">Previous</a></li>
                                                        <c:forEach begin="1" end="${endP}" var="i">                                                   

                                                        <li class="page-item"><a class="page-link" href="criterialist?index=${i}">${i}</a></li>

                                                    </c:forEach>
                                                    <li class="page-item"><a class="page-link" href="criterialist?index=${i+1}">Next</a></li>
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

</html>
<script>
    function doChange(id) {
        if (confirm("Are you sure to change status Criteria ID = " + id + " ??")) {
            window.location = "criterialist?action=change&id=" + id;
        }
    }
</script>

