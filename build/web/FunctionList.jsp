<%-- 
    Author     : Phuc
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Function List</title>   
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
                                                <h1 onclick="location.href = './functionlist';" class=" Title">Function List</h1>
                                            </div>

                                            <div class="d-sm-flex justify-content-between align-items-start">
                                                <div >
                                                    <button class="btn btn-danger btn-rounded btn-fw" type="button"  onclick="exportTableToExcel('tblData', 'FunctionList')" > Export</button>
                                                </div>
                                                <!--                                                <form action="functionlist?action=import" method="post" enctype="multipart/form-data">
                                                                                                    <div class="btn btn-danger btn-rounded btn-fw" id="yourBtn" style="cursor:pointer;" onclick="getFile()">Import Excel</div>
                                                                                                     this is your file input tag, so i hide it!
                                                                                                    <div style='height: 0px;width:0px; overflow:hidden;'><input id="upfile" name="file"type="file" value="upload"/></div>
                                                                                                     here you can have file submit button or you can write a simple script to upload the file automatically
                                                                                                    <input type="submit" value='Submit' id="myDIV" style="display: none; margin-left: 25px; color:white; background-color: #1F3BB3; height: 40px; margin-top: 5px; border-radius: 50px; font-size: 0.875rem; width: 80px ">
                                                                                                </form>-->
                                                <div >
                                                    <button class="btn btn-danger btn-rounded btn-fw" type="button"  onclick="location.href = './FunctionImport.jsp';" > Import</button>
                                                </div>
                                            </div>

                                            <div >
                                                <button style="color: rosybrown ; font-weight: bold; font-size: 40px; border: none;" class="menu-icon mdi mdi-comment-plus-outline" type="button"  onclick="location.href = './functionadd';"></button>
                                            </div>
                                        </div>

                                        <div class="d-sm-flex justify-content align-items-start">
                                            <form action="functionlist" method="get" style="width: 100%;">
                                                <span class="dropdown" name="teamName">
                                                    <button class="btn btn-secondary btn-rounded  dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                                        <a style="color: rosybrown ; font-weight: bold; "> ${teamName} </a>
                                                    </button>
                                                    <div class="dropdown-menu " aria-labelledby="dropdownMenuButton1" name="status">
<!--                                                        <a class="dropdown-item"   onclick="location.href = './functionlist';">
                                                            <span style="color: rosybrown ; font-weight: bold; ">  All Team </span>
                                                        </a>-->
                                                        <c:forEach items="${listT}" var="t" >
                                                            <a class="dropdown-item" value="${t.getName()}" onclick="location.href = './functionlist?action=search&teamName=${t.getName()}';"> <span style="color: rosybrown"> ${t.getName()} </span></a>
                                                        </c:forEach>
                                                    </div>
                                                </span> 

                                                <span class="dropdown" name="featureName">
                                                    <button class="btn btn-secondary btn-rounded  dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                                        <a style="color: rosybrown ; font-weight: bold; "> ${featureName} </a>
                                                    </button>
                                                    <div class="dropdown-menu " aria-labelledby="dropdownMenuButton1" name="status">
<!--                                                        <a class="dropdown-item"   onclick="location.href = './functionlist';">
                                                            <span style="color: rosybrown ; font-weight: bold; "> All Feature</span>
                                                        </a>-->
                                                        <c:forEach items="${listF}" var="c" >
                                                            <a class="dropdown-item" value="${c.feature_name}" onclick="location.href = './functionlist?action=search&featureName=${c.feature_name}';"> <span style="color: rosybrown"> ${c.feature_name} </span></a>
                                                        </c:forEach>
                                                    </div>
                                                </span>    

                                                <span class="dropdown" name="role">
                                                    <button class="btn btn-secondary btn-rounded  dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                                        <a style="color: rosybrown ; font-weight: bold; "> ${role} </a>
                                                    </button>
                                                    <div class="dropdown-menu " aria-labelledby="dropdownMenuButton1" name="status">
<!--                                                        <a class="dropdown-item"   onclick="location.href = './functionlist';">
                                                            <span style="color: rosybrown ; font-weight: bold; ">  All Role </span>
                                                        </a>            -->
                                                        <a class="dropdown-item"  value="0"  onclick="location.href = './functionlist?action=search&role=0';"> <span style="color: red ; font-weight: bold; "> Admin</span></a>
                                                        <a class="dropdown-item"  value="1"  onclick="location.href = './functionlist?action=search&role=1';"> <span style="color: blue ; font-weight: bold; "> Trainer </span></a>
                                                        <a class="dropdown-item"  value="2"  onclick="location.href = './functionlist?action=search&role=2';"> <span style="color: greenyellow ; font-weight: bold; "> Student </span></a>
                                                        <a class="dropdown-item"  value="3"  onclick="location.href = './functionlist?action=search&role=3';"> <span style="color: yellow ; font-weight: bold; "> User </span></a>
                                                        <a class="dropdown-item"  value="4"  onclick="location.href = './functionlist?action=search&role=4';"> <span style="color: pink ; font-weight: bold; "> Admin, Author </span></a>
                                                        <a class="dropdown-item"  value="5"  onclick="location.href = './functionlist?action=search&role=5';"> <span style="color: indigo ; font-weight: bold; "> Admin, Author, Trainer </span></a>
                                                        <a class="dropdown-item"  value="6"  onclick="location.href = './functionlist?action=search&role=6';"> <span style="color: wheat ; font-weight: bold; "> Student, Trainer </span></a>
                                                        <a class="dropdown-item"  value="7"  onclick="location.href = './functionlist?action=search&role=7';"> <span style="color: sienna ; font-weight: bold; "> < Blank > </span></a>
                                                    </div>
                                                </span>

                                                <span class="dropdown" name="complex">
                                                    <button class="btn btn-secondary btn-rounded  dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                                        <a style="color: rosybrown ; font-weight: bold; "> ${complex} </a>
                                                    </button>
                                                    <div class="dropdown-menu " aria-labelledby="dropdownMenuButton1" name="status">
<!--                                                        <a class="dropdown-item"   onclick="location.href = './functionlist';">
                                                            <span style="color: rosybrown ; font-weight: bold; ">  All Complex </span>
                                                        </a>            -->
                                                        <a class="dropdown-item"  value="0"  onclick="location.href = './functionlist?action=search&complex=0';"> <span style="color: red ; font-weight: bold; "> Simple</span></a>
                                                        <a class="dropdown-item"  value="1"  onclick="location.href = './functionlist?action=search&complex=1';"> <span style="color: blue ; font-weight: bold; "> Medium </span></a>
                                                        <a class="dropdown-item"  value="2"  onclick="location.href = './functionlist?action=search&complex=2';"> <span style="color: yellow ; font-weight: bold; "> Complex </span></a>
                                                    </div>
                                                </span>

                                                <span class="dropdown" name="status">
                                                    <button class="btn btn-secondary btn-rounded  dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                                        <a style="color: rosybrown ; font-weight: bold; "> ${status} </a>
                                                    </button>
                                                    <div class="dropdown-menu " aria-labelledby="dropdownMenuButton1" name="status">
<!--                                                        <a class="dropdown-item"   onclick="location.href = './functionlist';">
                                                            <span style="color: rosybrown ; font-weight: bold; ">  All Status </span>
                                                        </a>            -->
                                                        <a class="dropdown-item"  value="0"  onclick="location.href = './functionlist?action=search&status=0';"> <span style="color: green ; font-weight: bold; "> Done</span></a>
                                                        <a class="dropdown-item"  value="1"  onclick="location.href = './functionlist?action=search&status=1';"> <span style="color: red ; font-weight: bold; "> Doing </span></a>
                                                        <a class="dropdown-item"  value="2"  onclick="location.href = './functionlist?action=search&status=2';"> <span style="color: blue ; font-weight: bold; "> To Do </span></a>
                                                    </div>
                                                </span>
                                            </form>
                                            <form action="functionsearch" method="get" class="btn-md col-lg-6" style="margin: 0px -109px;">
                                                <div class="se">
                                                    <span class="btn-md col-lg-6" >
                                                        <input type="text" class="btn btn-lg btn-rounded form-control" name="txt" value="${text}" placeholder="Input what you want to search"/>
                                                    </span>
                                                    <button style="color: rosybrown ; font-weight: bold; background-color: lightgrey; " type="submit" class="btn btn-danger btn-rounded btn-fw">Search</button>
                                                </div>
                                            </form>
                                        </div>
                                        <div class="table-responsive">
                                            <table class="table table-striped" id="tblData">
                                                <thead>
                                                    <tr style="text-align: center;">
                                                        <th>ID <br>
                                                            <a class="" data-bs-toggle="collapse" onclick="location.href = './functionlist?action=sortIDasc';" aria-expanded="false" aria-controls="ui-basic">
                                                                <i class="menu-icon mdi mdi-arrow-up"></i>
                                                            </a>
                                                            <a class="" data-bs-toggle="collapse" onclick="location.href = './functionlist?action=sortIDdesc';" aria-expanded="false" aria-controls="ui-basic">
                                                                <i class="menu-icon mdi mdi-arrow-down"></i>
                                                            </a>
                                                        </th>
                                                        <th>Name <br>
                                                            <a class="" data-bs-toggle="collapse" onclick="location.href = './functionlist?action=sortNameasc';" aria-expanded="false" aria-controls="ui-basic">
                                                                <i class="menu-icon mdi mdi-arrow-up"></i>
                                                            </a>
                                                            <a class="" data-bs-toggle="collapse" onclick="location.href = './functionlist?action=sortNamedesc';" aria-expanded="false" aria-controls="ui-basic">
                                                                <i class="menu-icon mdi mdi-arrow-down"></i>
                                                            </a>
                                                        </th>
                                                        <th>Team Name<br>
                                                            <a class="" data-bs-toggle="collapse" onclick="location.href = './functionlist?action=sortTeamasc';" aria-expanded="false" aria-controls="ui-basic">
                                                                <i class="menu-icon mdi mdi-arrow-up"></i>
                                                            </a>
                                                            <a class="" data-bs-toggle="collapse" onclick="location.href = './functionlist?action=sortTeamdesc';" aria-expanded="false" aria-controls="ui-basic">
                                                                <i class="menu-icon mdi mdi-arrow-down"></i>
                                                            </a>
                                                        </th>
                                                        <th>Feature Name<br>
                                                            <a class="" data-bs-toggle="collapse" onclick="location.href = './functionlist?action=sortFeaasc';" aria-expanded="false" aria-controls="ui-basic">
                                                                <i class="menu-icon mdi mdi-arrow-up"></i>
                                                            </a>
                                                            <a class="" data-bs-toggle="collapse" onclick="location.href = './functionlist?action=sortFeadesc';" aria-expanded="false" aria-controls="ui-basic">
                                                                <i class="menu-icon mdi mdi-arrow-down"></i>
                                                            </a>
                                                        </th>
                                                        <th>Role<br>
                                                            <a class="" data-bs-toggle="collapse" onclick="location.href = './functionlist?action=sortRoleasc';" aria-expanded="false" aria-controls="ui-basic">
                                                                <i class="menu-icon mdi mdi-arrow-up"></i>
                                                            </a>
                                                            <a class="" data-bs-toggle="collapse" onclick="location.href = './functionlist?action=sortRoledesc';" aria-expanded="false" aria-controls="ui-basic">
                                                                <i class="menu-icon mdi mdi-arrow-down"></i>
                                                            </a>
                                                        </th>       
                                                        <th>Complexity<br>
                                                            <a class="" data-bs-toggle="collapse" onclick="location.href = './functionlist?action=sortComplexasc';" aria-expanded="false" aria-controls="ui-basic">
                                                                <i class="menu-icon mdi mdi-arrow-up"></i>
                                                            </a>
                                                            <a class="" data-bs-toggle="collapse" onclick="location.href = './functionlist?action=sortComplexdesc';" aria-expanded="false" aria-controls="ui-basic">
                                                                <i class="menu-icon mdi mdi-arrow-down"></i>
                                                            </a>
                                                        </th>   
                                                        <th>Owner<br>
                                                            <a class="" data-bs-toggle="collapse" onclick="location.href = './functionlist?action=sortOwnerasc';" aria-expanded="false" aria-controls="ui-basic">
                                                                <i class="menu-icon mdi mdi-arrow-up"></i>
                                                            </a>
                                                            <a class="" data-bs-toggle="collapse" onclick="location.href = './functionlist?action=sortOwnerdesc';" aria-expanded="false" aria-controls="ui-basic">
                                                                <i class="menu-icon mdi mdi-arrow-down"></i>
                                                            </a>
                                                        </th>   
                                                        <th>Priority<br>
                                                            <a class="" data-bs-toggle="collapse" onclick="location.href = './functionlist?action=sortPriorityasc';" aria-expanded="false" aria-controls="ui-basic">
                                                                <i class="menu-icon mdi mdi-arrow-up"></i>
                                                            </a>
                                                            <a class="" data-bs-toggle="collapse" onclick="location.href = './functionlist?action=sortPrioritydesc';" aria-expanded="false" aria-controls="ui-basic">
                                                                <i class="menu-icon mdi mdi-arrow-down"></i>
                                                            </a>
                                                        </th>   
                                                        <th>Status<br>
                                                            <a class="" data-bs-toggle="collapse" onclick="location.href = './functionlist?action=sortStatusasc';" aria-expanded="false" aria-controls="ui-basic">
                                                                <i class="menu-icon mdi mdi-arrow-up"></i>
                                                            </a>
                                                            <a class="" data-bs-toggle="collapse" onclick="location.href = './functionlist?action=sortStatusdesc';" aria-expanded="false" aria-controls="ui-basic">
                                                                <i class="menu-icon mdi mdi-arrow-down"></i>
                                                            </a>
                                                        </th>
                                                        <th>Action</th>

                                                    </tr>
                                                </thead>
                                                <c:forEach items="${list}" var="o">
                                                    <tbody>
                                                        <tr style="text-align: center;">
                                                            <td>${o.id}</td>
                                                            <td>${o.function_name}</td>
                                                            <td>${o.team_name}</td>
                                                            <td>${o.feature_name}</td>
                                                            <td>                                       
                                                                <c:if test="${o.getAccess_role() == 0}">
                                                                    <a>Admin</a>
                                                                </c:if>
                                                                <c:if test="${o.getAccess_role() == 1}">
                                                                    <a>Trainer</a>
                                                                </c:if>
                                                                <c:if test="${o.getAccess_role() == 2}">
                                                                    <a>Student</a>
                                                                </c:if>
                                                                <c:if test="${o.getAccess_role() == 3}">
                                                                    <a>User</a>
                                                                </c:if>
                                                                <c:if test="${o.getAccess_role() == 4}">
                                                                    <a>Admin, Author</a>
                                                                </c:if>
                                                                <c:if test="${o.getAccess_role() == 5}">
                                                                    <a>Admin, Author, Trainer</a>
                                                                </c:if>
                                                                <c:if test="${o.getAccess_role() == 6}">
                                                                    <a>Student, Trainer</a>
                                                                </c:if>
                                                                <c:if test="${o.getAccess_role() == 7}">
                                                                    <a></a>
                                                                </c:if>
                                                            </td>
                                                            <td>                                       
                                                                <c:if test="${o.getComplexity_id() == 0}">
                                                                    <a>Simple</a>
                                                                </c:if>
                                                                <c:if test="${o.getComplexity_id() == 1}">
                                                                    <a>Medium</a>
                                                                </c:if>
                                                                <c:if test="${o.getComplexity_id() == 2}">
                                                                    <a>Complex</a>
                                                                </c:if>                    
                                                            </td>
                                                            <td>${o.owner_name}</td>
                                                            <td>${o.priority}</td>
                                                            <td>
                                                                <c:if test="${o.status == 0}">
                                                                    <a style="color: green;">Done</a>
                                                                </c:if>
                                                                <c:if test="${o.status == 1}">
                                                                    <a style="color: red;">Doing</a>
                                                                </c:if>
                                                                <c:if test="${o.status == 2}">
                                                                    <a style="color: blue;">To Do</a>
                                                                </c:if>
                                                            </td>
                                                            <td>                                        
                                                                <span>
                                                                    <button class="menu-icon mdi mdi-border-color" style="" type="button" onclick="location.href = './functiondetails?FuncID=${o.id}';"></button>
                                                                </span>                                                     
                                                            </td>
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>           
                                            <nav aria-label="Page navigation example" class="d-flex justify-content-center">
                                                <ul class="pagination">
                                                    <li class="page-item"><a class="page-link" href="functionlist?index=${i-1}">Previous</a></li>
                                                        <c:forEach begin="1" end="${endP}" var="i">                                                   

                                                        <li class="page-item"><a class="page-link" href="functionlist?index=${i}">${i}</a></li>

                                                    </c:forEach>
                                                    <li class="page-item"><a class="page-link" href="functionlist?index=${i+1}">Next</a></li>
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
        <script>
            function exportTableToExcel(tableID, filename = '') {
                var downloadLink;
                var dataType = 'application/vnd.ms-excel';
                var tableSelect = document.getElementById(tableID);
                var tableHTML = tableSelect.outerHTML.replace(/ /g, '%20');

                // Specify file name
                filename = filename ? filename + '.xls' : 'excel_data.xls';

                // Create download link element
                downloadLink = document.createElement("a");

                document.body.appendChild(downloadLink);

                if (navigator.msSaveOrOpenBlob) {
                    var blob = new Blob(['\ufeff', tableHTML], {
                        type: dataType
                    });
                    navigator.msSaveOrOpenBlob(blob, filename);
                } else {
                    // Create a link to the file
                    downloadLink.href = 'data:' + dataType + ', ' + tableHTML;

                    // Setting the file name
                    downloadLink.download = filename;

                    //triggering the function
                    downloadLink.click();
            }
            }
            function getFile() {
                document.getElementById("upfile").click();
                var x = document.getElementById("myDIV");
                if (x.style.display === "none") {
                    x.style.display = "block";
                } else {
                    x.style.display = "none";
                }
            }
        </script>
        <!--content -->        

        <!--footer -->
        <%@include file="footer.jsp" %>
        <!--footer -->
    </body>

</html>


