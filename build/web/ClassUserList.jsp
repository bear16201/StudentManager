<%-- 
    Author     : Phuc
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Class User List</title>
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
                                                <h1 class=" Title">Class User List</h1>
                                            </div>
                                            <div >
                                                <button class="btn btn-md btn-primary btn-rounded  text-white mb-0 me-0" type="button"  onclick="location.href = './ClassUserAdd.jsp';" ><i mdi mdi-account-plus ></i> Add Class User</button>
                                            </div>
                                        </div>

                                        <div class="d-sm-flex justify-content align-items-start">
                                            <!--                                            <span class="dropdown ">
                                                                                            <button class="btn btn-primary btn-rounded  dropdown-toggle " type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                                                                                All Setting Types
                                                                                            </button>
                                                                                            <div class="dropdown-menu " aria-labelledby="dropdownMenuButton1">            
                                            <%--<c:forEach items="${list}" var="t">--%>                                          
                                                <a class="dropdown-item">${t.status}</a>
                                            <%--</c:forEach>--%>                                   
                                        </div>
                                    </span>-->
                                            <!--                                            <span class="dropdown ">
                                                                                            <button class="btn btn-primary btn-rounded  dropdown-toggle " type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                                                                                Type Setting Name To Search
                                                                                            </button>
                                                                                            <div class="dropdown-menu " aria-labelledby="dropdownMenuButton1">
                                            <%--<c:forEach items="${list}" var="n">--%>
                                                <a class="dropdown-item">${n.title}</a>
                                            <%--</c:forEach>--%>
                                        </div>
                                    </span>-->
                                            <span class="dropdown">
                                                <button class="btn btn-primary btn-rounded  dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                                    All Status
                                                </button>
                                                <div class="dropdown-menu" aria-labelledby="dropdownMenuButton1" data-popper-placement="bottom-start" style="position: absolute; inset: 0px auto auto 0px; margin: 0px; transform: translate(472px, 237px);">                                              
                                                    <a class="dropdown-item" href="classuserlist?action=status1">Active</a>
                                                    <a class="dropdown-item" href="classuserlist?action=status0">Inactive</a>
                                                </div>
                                            </span>

                                            <form action="classuserlist" method="post" class="btn-md col-lg-6">
                                                <div class="se">
                                                    <span class="btn-md col-lg-6" >
                                                        <input type="text" class="btn btn-lg btn-rounded form-control" name="search" value="${txtSearch}" placeholder="Setting Type, Name, Order, Value to search"/>
                                                    </span>
                                                    <button type="submit" class="btn btn-danger btn-rounded btn-fw">Search</button>
                                                </div>
                                            </form>
                                            <div class="d-sm-flex justify-content-between align-items-start">

                                                <div >
                                                    <button class="btn btn-danger btn-rounded btn-fw" type="button"  onclick="exportTableToExcel1('tblData', 'ClassUserList')" > Export To Excel</button>
                                                </div>
                                            </div>
                                            <div class="d-sm-flex justify-content-between align-items-start">

                                                <div >
                                                    <button class="btn btn-danger btn-rounded btn-fw" type="button"  onclick="location.href = './ClassUserAdd.jsp';" ><i mdi mdi-account-plus ></i> Import From Excel</button>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="table-responsive">
                                            <table  id="tblData" class="table table-striped">
                                                <thead>
                                                    <tr>
                                                        <!--                                                        <th>
                                                                                                                    <div onclick="sortTable(0)">STT</div>
                                                                                                                </th>-->
                                                        <th>
                                                            <div onclick="sortTable(0)">Class ID</div>
                                                        </th>
                                                        <th>
                                                            <div onclick="sortTable(1)">Team ID</div>
                                                        </th>
                                                        <th>
                                                            <div onclick="sortTable(2)">User ID</div>
                                                        </th>
                                                        <th>
                                                            <div onclick="sortTable(3)">Dropout Date</div>
                                                        </th>
                                                        <th>
                                                            <div onclick="sortTable(4)">User Note</div>
                                                        </th>
                                                        <th>
                                                            <div onclick="sortTable(5)">Ongoing Eval</div>
                                                        </th>
                                                        <th>
                                                            <div onclick="sortTable(6)">Final Pres</div>
                                                        </th>
                                                        <th>
                                                            <div onclick="sortTable(7)">Final Topic</div>
                                                        </th>
                                                    </tr>
                                                </thead>

                                                <tbody>
                                                    <c:forEach items="${listT}" var="o"> 

                                                        <tr>
                                                            <!--<td>${o.class_user_id}</td>-->
                                                            <td>${o.class_id}</td>
                                                            <td>${o.team_id}</td>
                                                            <td>${o.user_id}</td>
                                                            <td>${o.dropout_date}</td>

                                                            <td><c:if test="${o.user_notes==''}">
                                                                    <span>N/A</span>
                                                                </c:if>

                                                                ${o.user_notes}</td>
                                                            <td>
                                                                <c:if test="${o.onGoing==''}">
                                                                    <span>N/A</span>
                                                                </c:if>

                                                                ${o.onGoing}
                                                            </td>
                                                            <td>
                                                                <c:if test="${o.final_pres==''}">
                                                                    <span>N/A</span>
                                                                </c:if>
                                                                ${o.final_pres}</td>
                                                            <td>
                                                                <c:if test="${o.final_topic==''}">
                                                                    <span>N/A</span>
                                                                </c:if>
                                                                ${o.final_topic}
                                                            </td>

                                                            <td>
                                                                <c:if test="${o.status == 0}">
                                                                    <a>Inactice</a>
                                                                </c:if>
                                                                <c:if test="${o.status == 1 }">
                                                                    <a>Actice</a>
                                                                </c:if>
                                                            </td>
                                                            <td>
                                                                <span>
                                                                    <a class="btn btn-warning btn-rounded btn-fw text-white mb-0 me-0" style = "height: 45px"type="button"  href = 'classuserdetails?cuid=${o.class_user_id}' >Edit</a>
                                                                </span>
<!--?cuid=${o.getClass_user_id()}';-->
                                                                <c:choose>
                                                                    <c:when test="${o.status == 1}">
                                                                        <a class="btn btn-danger btn-rounded btn-fw  text-white mb-0 me-0" style="height: 45px" type="button" onclick="return confirm_delete()" href = './classuserlist?action=change&id=${o.class_user_id}'>

                                                                            Inactive

                                                                        </a>
                                                                    </c:when>
                                                                    <c:when test="${o.status == 0}">
                                                                        <a class="btn btn-info btn-rounded btn-fw  text-white mb-0 me-0" style="height: 45px" type="button" onclick="return confirm_delete()" href = './classuserlist?action=change&id=${o.class_user_id}'>
                                                                            <!--<i>-->
                                                                            Active
                                                                            <!--</i>-->
                                                                        </a>
                                                                    </c:when>
                                                                </c:choose>
                                                            </td>
                                                        </c:forEach>
                                                    </tr>
                                                </tbody>
                                            </table>
                                            <!-- pagination 

                                            <!-- pagination -->
                                            <nav aria-label="Page navigation example" class="d-flex justify-content-center">


                                                <ul class="pagination">
                                                    <!--<li class="page-item"><a class="page-link" href="./iterationlist">Previous</a></li>-->
                                                    <c:forEach var="o" begin = "1" end="${size}"  >
                                                        <li class="page-item"><a class="page-link" href="./classuserlist?page=${o}">${o}</a></li>
                                                        </c:forEach>                                                        
                                                    <!--<li class="page-item"><a class="page-link" href="./iterationlist">Next</a></li>-->
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
        <script >


            function confirm_delete() {
                return confirm('are you sure to change it?');
            }


            function sortTable(n) {
                var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
                table = document.getElementById("tblData");
                switching = true;
                dir = "asc";
                while (switching) {
                    switching = false;
                    rows = table.rows;
                    for (i = 1; i < (rows.length - 1); i++) {
                        shouldSwitch = false;
                        x = rows[i].getElementsByTagName("TD")[n];
                        y = rows[i + 1].getElementsByTagName("TD")[n];
                        if (dir == "asc") {
                            if (x.innerHTML.toUpperCase() > y.innerHTML.toUpperCase()) {
                                shouldSwitch = true;
                                break;
                            }
                        } else if (dir == "desc") {
                            if (x.innerHTML.toUpperCase() < y.innerHTML.toUpperCase()) {
                                shouldSwitch = true;
                                break;
                            }
                        }
                    }
                    if (shouldSwitch) {
                        rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
                        switching = true;
                        switchcount++;
                    } else {
                        if (switchcount == 0 && dir == "asc") {
                            dir = "desc";
                            switching = true;
                        }
                    }
                }
            }
            //export to excel
            function exportTableToExcel1(tableID, filename = '') {
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
        </script>
        <!--content -->        

        <!--footer -->
        <%@include file="footer.jsp" %>
        <!--footer -->
    </body>

</html>


