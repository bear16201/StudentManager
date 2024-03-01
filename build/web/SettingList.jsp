<%-- 
    Author     : Phuc
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Setting List</title>
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
                                                <h1 class=" Title">Setting List</h1>
                                            </div>
                                            <div >
                                                <button class="btn btn-md btn-primary btn-rounded  text-white mb-0 me-0" type="button"  onclick="location.href = './SettingAdd.jsp';" ><i mdi mdi-account-plus ></i> Add Setting</button>
                                            </div>
                                        </div>

                                        <div class="d-sm-flex justify-content align-items-start">
                                            <!--                                            <form action="settinglist" method="get" >
                                                                                            <span class="dropdown" name="sbname">
                                                                                                <button class="btn btn-secondary btn-rounded  dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                                                                                    <a style="color: rosybrown ; font-weight: bold; "> ${sbname} </a>
                                                                                                </button>
                                                                                                <div class="dropdown-menu " aria-labelledby="dropdownMenuButton1" name="status">
                                                                                                    <a class="dropdown-item"   onclick="location.href = './settinglist';">
                                                                                                        <span style="color: rosybrown ; font-weight: bold; ">  All Subject Name </span>
                                                                                                    </a>
                                            <c:forEach items="${listS}" var="c" >
                                                <a class="dropdown-item" name ="All Subject Name"  value="${c.name}" onclick="location.href = './settinglist?action=search&itername=${c.name}';"> <span style="color: rosybrown"> ${c.name} </span></a>
                                            </c:forEach>
                                        </div>
                                    </span>
                                    <span class="dropdown" name="weight">
                                        <button class="btn btn-secondary btn-rounded  dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                            <a style="color: rosybrown ; font-weight: bold; "> ${weight} </a>
                                        </button>
                                        <div class="dropdown-menu " aria-labelledby="dropdownMenuButton1" name="status">
                                            <a class="dropdown-item"   onclick="location.href = './criterialist';">
                                                <span style="color: rosybrown ; font-weight: bold; ">  All Order </span>
                                            </a>
                                            <c:forEach items="${listW}" var="c" >
                                                <a class="dropdown-item"  value="${c.getEvaluation_weight()}" onclick="location.href = './criterialist?action=search&weight=${c.getEvaluation_weight()}';"> <span style="color: rosybrown"> ${c.getEvaluation_weight()} </span></a>
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
                                </form>-->
                                            <form action="search" method="get" class="btn-md col-lg-6">
                                                <div class="se">
                                                    <span class="btn-md col-lg-6" >
                                                        <input type="text" class="btn btn-lg btn-rounded form-control" name="txt" value="${text}" placeholder="Setting Type, Name, Order, Value to search"/>
                                                    </span>
                                                    <button type="submit" class="btn btn-danger btn-rounded btn-fw">Search</button>
                                                </div>
                                            </form>
                                        </div>
                                        <div class="table-responsive">
                                            <table class="table table-striped">
                                                <thead>
                                                    <tr>

                                                        <th>ID
                                                            <a class="" data-bs-toggle="collapse" onclick="location.href = './criterialist?action=sortWeightasc';" aria-expanded="false" aria-controls="ui-basic">
                                                                <i class="menu-icon mdi mdi-arrow-up"></i>
                                                            </a>
                                                            <a class="" data-bs-toggle="collapse" onclick="location.href = './criterialist?action=sortWeightdesc';" aria-expanded="false" aria-controls="ui-basic">
                                                                <i class="menu-icon mdi mdi-arrow-down"></i>
                                                            </a>
                                                        </th>
                                                        <th>Title
                                                            <a class="" data-bs-toggle="collapse" onclick="location.href = './criterialist?action=sortWeightasc';" aria-expanded="false" aria-controls="ui-basic">
                                                                <i class="menu-icon mdi mdi-arrow-up"></i>
                                                            </a>
                                                            <a class="" data-bs-toggle="collapse" onclick="location.href = './criterialist?action=sortWeightdesc';" aria-expanded="false" aria-controls="ui-basic">
                                                                <i class="menu-icon mdi mdi-arrow-down"></i>
                                                            </a>
                                                        </th>
                                                        <th>Subject
                                                            <a class="" data-bs-toggle="collapse" onclick="location.href = './criterialist?action=sortWeightasc';" aria-expanded="false" aria-controls="ui-basic">
                                                                <i class="menu-icon mdi mdi-arrow-up"></i>
                                                            </a>
                                                            <a class="" data-bs-toggle="collapse" onclick="location.href = './criterialist?action=sortWeightdesc';" aria-expanded="false" aria-controls="ui-basic">
                                                                <i class="menu-icon mdi mdi-arrow-down"></i>
                                                            </a>
                                                        </th>
                                                        <th>Type
                                                            <a class="" data-bs-toggle="collapse" onclick="location.href = './criterialist?action=sortWeightasc';" aria-expanded="false" aria-controls="ui-basic">
                                                                <i class="menu-icon mdi mdi-arrow-up"></i>
                                                            </a>
                                                            <a class="" data-bs-toggle="collapse" onclick="location.href = './criterialist?action=sortWeightdesc';" aria-expanded="false" aria-controls="ui-basic">
                                                                <i class="menu-icon mdi mdi-arrow-down"></i>
                                                            </a>
                                                        </th>
                                                        <th>Order
                                                            <a class="" data-bs-toggle="collapse" onclick="location.href = './criterialist?action=sortWeightasc';" aria-expanded="false" aria-controls="ui-basic">
                                                                <i class="menu-icon mdi mdi-arrow-up"></i>
                                                            </a>
                                                            <a class="" data-bs-toggle="collapse" onclick="location.href = './criterialist?action=sortWeightdesc';" aria-expanded="false" aria-controls="ui-basic">
                                                                <i class="menu-icon mdi mdi-arrow-down"></i>
                                                            </a>
                                                        </th>
                                                        <th>Value
                                                            <a class="" data-bs-toggle="collapse" onclick="location.href = './criterialist?action=sortWeightasc';" aria-expanded="false" aria-controls="ui-basic">
                                                                <i class="menu-icon mdi mdi-arrow-up"></i>
                                                            </a>
                                                            <a class="" data-bs-toggle="collapse" onclick="location.href = './criterialist?action=sortWeightdesc';" aria-expanded="false" aria-controls="ui-basic">
                                                                <i class="menu-icon mdi mdi-arrow-down"></i>
                                                            </a>
                                                        </th>
                                                        <th>Status
                                                            <a class="" data-bs-toggle="collapse" onclick="location.href = './criterialist?action=sortWeightasc';" aria-expanded="false" aria-controls="ui-basic">
                                                                <i class="menu-icon mdi mdi-arrow-up"></i>
                                                            </a>
                                                            <a class="" data-bs-toggle="collapse" onclick="location.href = './criterialist?action=sortWeightdesc';" aria-expanded="false" aria-controls="ui-basic">
                                                                <i class="menu-icon mdi mdi-arrow-down"></i>
                                                            </a>
                                                        </th>
                                                        <th>Action</th>

                                                    </tr>
                                                </thead>
                                                <c:forEach items="${list}" var="o">
                                                    <tbody>
                                                        <tr>
                                                            <td>${o.id}</td>
                                                            <td>${o.title}</td>
                                                            <td>${o.subject_name}</td>
                                                            <td>${o.type}</td>
                                                            <td>${o.order}</td>
                                                            <td>${o.value}</td>

                                                            <td>
                                                                <c:choose> 
                                                                    <c:when test="${o.status.equals('1')}">
                                                                        <button class="btn btn-danger btn-rounded btn-fw  text-white mb-0 me-0" style = "height: 45px"type="button" onclick="doChange(${o.getType_id()})">
                                                                            <i>
                                                                                Inactive
                                                                            </i>
                                                                        </button>
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        <button class="btn btn-info btn-rounded btn-fw  text-white mb-0 me-0" style = "height: 45px"type="button" onclick="doChange(${o.getType_id()})">
                                                                            <i>
                                                                                Active
                                                                            </i>
                                                                        </button>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </td>
                                                            <td>                                        
                                                                <span>
                                                                    <button class="btn btn-warning btn-rounded btn-fw text-white mb-0 me-0" style = "height: 45px"type="button" onclick="location.href = './settingdetails?sid=${o.type_id}';"><i >Edit</i></button>
                                                                </span>                                                  

                                                            </td>
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                            <nav aria-label="Page navigation example" class="d-flex justify-content-center">
                                                <ul class="pagination">
                                                    <li class="page-item"><a class="page-link" href="settinglist?index=${i-1}">Previous</a></li>
                                                        <c:forEach begin="1" end="${endP}" var="i">                                                   

                                                        <li class="page-item"><a class="page-link" href="settinglist?index=${i}">${i}</a></li>

                                                    </c:forEach>
                                                    <li class="page-item"><a class="page-link" href="settinglist?index=${i+1}">Next</a></li>
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
            window.location = "settinglist?action=change&id=" + id;
        }
    }
</script>

