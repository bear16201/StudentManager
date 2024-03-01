<%-- 
    Author     : Phuc
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Team List</title>
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
                                                <h1 class=" Title">Team List</h1>
                                            </div>
                                            <div >
                                                <button style="color: rosybrown ; font-weight: bold; background-color: lightgrey; " class="btn btn-md btn-primary btn-rounded  text-white mb-0 me-0" type="button"  onclick="location.href = './teamadd';" ><i mdi mdi-account-plus ></i> Add Team</button>
                                            </div>
                                        </div>

                                        <div class="d-sm-flex justify-content align-items-start">
                                            <form action="teamlist" method="get" >
                                                <span class="dropdown" name="topic">
                                                    <button class="btn btn-secondary btn-rounded  dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                                        <a style="color: rosybrown ; font-weight: bold; "> ${topic} </a>
                                                    </button>
                                                    <div class="dropdown-menu " aria-labelledby="dropdownMenuButton1" name="status">
                                                        <a class="dropdown-item"   onclick="location.href = './teamlist';">
                                                            <span style="color: rosybrown ; font-weight: bold; ">  All Topic Name </span>
                                                        </a>
                                                        <c:forEach items="${listT}" var="c" >
                                                            <a class="dropdown-item" value="${c.getTopic_name()}" onclick="location.href = './teamlist?action=search&topic=${c.getTopic_name()}';"> <span style="color: rosybrown"> ${c.getTopic_name()} </span></a>
                                                        </c:forEach>
                                                    </div>
                                                </span> 
                                                <span class="dropdown" name="classCode">
                                                    <button class="btn btn-secondary btn-rounded  dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                                        <a style="color: rosybrown ; font-weight: bold; "> ${classCode} </a>
                                                    </button>
                                                    <div class="dropdown-menu " aria-labelledby="dropdownMenuButton1" name="status">
                                                        <a class="dropdown-item"   onclick="location.href = './teamlist';">
                                                            <span style="color: rosybrown ; font-weight: bold; ">  All Class Code </span>
                                                        </a>
                                                        <c:forEach items="${listC}" var="c" >
                                                            <a class="dropdown-item" value="${c.getClassCode()}" onclick="location.href = './teamlist?action=search&classCode=${c.getClassCode()}';"> <span style="color: rosybrown"> ${c.getClassCode()} </span></a>
                                                        </c:forEach>
                                                    </div>
                                                </span>       
                                                <span class="dropdown" name="status">
                                                    <button class="btn btn-secondary btn-rounded  dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                                        <a style="color: rosybrown ; font-weight: bold; "> ${status} </a>
                                                    </button>
                                                    <div class="dropdown-menu " aria-labelledby="dropdownMenuButton1" name="status">
                                                        <a class="dropdown-item"   onclick="location.href = './teamlist';">
                                                            <span style="color: rosybrown ; font-weight: bold; ">  All Status </span>
                                                        </a>            
                                                        <a class="dropdown-item"  value="0"  onclick="location.href = './teamlist?action=search&status=0';"> <span style="color: red ; font-weight: bold; "> Inactive</span></a>
                                                        <a class="dropdown-item"  value="1"  onclick="location.href = './teamlist?action=search&status=1';"> <span style="color: blue ; font-weight: bold; "> Active </span></a>
                                                    </div>
                                                </span>


                                            </form>
                                            <form action="teamsearch" method="get" class="btn-md col-lg-6">
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

                                                        <th>ID 
                                                            <a class="" data-bs-toggle="collapse" onclick="location.href = './teamlist?action=sortIDasc';" aria-expanded="false" aria-controls="ui-basic">
                                                                <i class="menu-icon mdi mdi-arrow-up"></i>
                                                            </a>
                                                            <a class="" data-bs-toggle="collapse" onclick="location.href = './teamlist?action=sortIDdesc';" aria-expanded="false" aria-controls="ui-basic">
                                                                <i class="menu-icon mdi mdi-arrow-down"></i>
                                                            </a>
                                                        </th>
                                                        <th>Name 
                                                            <a class="" data-bs-toggle="collapse" onclick="location.href = './teamlist?action=sortIDasc';" aria-expanded="false" aria-controls="ui-basic">
                                                                <i class="menu-icon mdi mdi-arrow-up"></i>
                                                            </a>
                                                            <a class="" data-bs-toggle="collapse" onclick="location.href = './teamlist?action=sortIDdesc';" aria-expanded="false" aria-controls="ui-basic">
                                                                <i class="menu-icon mdi mdi-arrow-down"></i>
                                                            </a>
                                                        </th>
                                                        <th>Class Code
                                                            <a class="" data-bs-toggle="collapse" onclick="location.href = './teamlist?action=sortClassasc';" aria-expanded="false" aria-controls="ui-basic">
                                                                <i class="menu-icon mdi mdi-arrow-up"></i>
                                                            </a>
                                                            <a class="" data-bs-toggle="collapse" onclick="location.href = './teamlist?action=sortClassdesc';" aria-expanded="false" aria-controls="ui-basic">
                                                                <i class="menu-icon mdi mdi-arrow-down"></i>
                                                            </a>
                                                        </th>
                                                        <th>Topic Code
                                                            <a class="" data-bs-toggle="collapse" onclick="location.href = './teamlist?action=sortTopicCodeasc';" aria-expanded="false" aria-controls="ui-basic">
                                                                <i class="menu-icon mdi mdi-arrow-up"></i>
                                                            </a>
                                                            <a class="" data-bs-toggle="collapse" onclick="location.href = './teamlist?action=sortTopicCodedesc';" aria-expanded="false" aria-controls="ui-basic">
                                                                <i class="menu-icon mdi mdi-arrow-down"></i>
                                                            </a>
                                                        </th>
                                                        <th>Topic Name
                                                            <a class="" data-bs-toggle="collapse" onclick="location.href = './teamlist?action=sortTopicNameasc';" aria-expanded="false" aria-controls="ui-basic">
                                                                <i class="menu-icon mdi mdi-arrow-up"></i>
                                                            </a>
                                                            <a class="" data-bs-toggle="collapse" onclick="location.href = './teamlist?action=sortTopicNamedesc';" aria-expanded="false" aria-controls="ui-basic">
                                                                <i class="menu-icon mdi mdi-arrow-down"></i>
                                                            </a>
                                                        </th>          
                                                        <th>Status
                                                            <a class="" data-bs-toggle="collapse" onclick="location.href = './teamlist?action=sortStatusasc';" aria-expanded="false" aria-controls="ui-basic">
                                                                <i class="menu-icon mdi mdi-arrow-up"></i>
                                                            </a>
                                                            <a class="" data-bs-toggle="collapse" onclick="location.href = './teamlist?action=sortStatusdesc';" aria-expanded="false" aria-controls="ui-basic">
                                                                <i class="menu-icon mdi mdi-arrow-down"></i>
                                                            </a>
                                                        </th>
                                                        <th>Action</th>

                                                    </tr>
                                                </thead>
                                                <c:forEach items="${list}" var="o">
                                                    <tbody>
                                                        <tr>
                                                            <td>${o.team_id}</td>
                                                            <td>${o.name}</td>
                                                            <td>${o.class_code}</td>
                                                            <td>${o.topic_code}</td>
                                                            <td>${o.topic_name}</td>    
                                                            <td>
                                                                <c:if test="${o.status == 1}">
                                                                    <a>Actice</a>
                                                                </c:if>
                                                                <c:if test="${o.status == 0}">
                                                                    <a>Inactice</a>
                                                                </c:if>
                                                            </td>
                                                            <td>                                        
                                                                <span>
                                                                    <button class="btn btn-warning btn-rounded btn-fw text-white mb-0 me-0" style = "height: 45px"type="button" onclick="location.href = './teamdetails?team_id=${o.team_id}';"><i >Edit</i></button>
                                                                </span>                                                  
                                                                <c:choose> 
                                                                    <c:when test="${o.getStatus() == 1}">
                                                                        <button class="btn btn-danger btn-rounded btn-fw  text-white mb-0 me-0" style = "height: 45px"type="button" onclick="doChange(${o.team_id})">
                                                                            <i>
                                                                                Inactive
                                                                            </i>
                                                                        </button>
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        <button class="btn btn-info btn-rounded btn-fw  text-white mb-0 me-0" style = "height: 45px"type="button" onclick="doChange(${o.team_id})">
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
                                            <nav aria-label="Page navigation example" class="d-flex justify-content-center">
                                                <ul class="pagination">
                                                    <li class="page-item"><a class="page-link" href="teamlist?index=${i-1}">Previous</a></li>
                                                        <c:forEach begin="1" end="${endP}" var="i">                                                   

                                                        <li class="page-item"><a class="page-link" href="teamlist?index=${i}">${i}</a></li>

                                                    </c:forEach>
                                                    <li class="page-item"><a class="page-link" href="teamlist?index=${i+1}">Next</a></li>
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
        if (confirm("Are you sure to change status ??")) {
            window.location = "teamlist?action=change&id=" + id;
        }
    }
</script>

