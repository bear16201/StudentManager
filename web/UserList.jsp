<%-- 
    Author     : Phuc
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>User List</title>
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
                                                <h1 class=" display1 card-title card-title-dash">User List</h1>

                                            </div>
                                            <div >

                                                <button class="btn btn-md btn-primary btn-rounded  text-white mb-0 me-0" type="button"  onclick="location.href = './add';" ><i mdi mdi-account-plus ></i> Add User</button>
                                            </div>

                                        </div>
                                        <form action="userlist" method="get" >

                                            <div class="d-sm-flex justify-content align-items-start">
                                                <span class="dropdown" name="status">
                                                    <button class="btn btn-primary btn-rounded  dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                                        ${byroles}
                                                    </button>
                                                    <div class="dropdown-menu " aria-labelledby="dropdownMenuButton1" name="status">
                                                        <a class="dropdown-item"  value="0"  onclick="location.href = './userlist';">All Roles</a>
                                                        <a class="dropdown-item"  value="0"  onclick="location.href = './userlist';">Block</a>
                                                        <a class="dropdown-item"  value="1"  onclick="location.href = './userlist';">Active</a>

                                                    </div>
                                                </span>
                                                <span class="dropdown" name="status">
                                                    <button class="btn btn-primary btn-rounded  dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                                        ${bystatus}
                                                    </button>
                                                    <div class="dropdown-menu " aria-labelledby="dropdownMenuButton1" name="status">
                                                        <a class="dropdown-item"  value="0"  onclick="location.href = './userlist';">All Status</a>

                                                        <a class="dropdown-item"  value="0"  onclick="location.href = './userlist';">Block</a>
                                                        <a class="dropdown-item"  value="1"  onclick="location.href = './userlist';">Active</a>

                                                    </div>
                                                </span>

                                                <span class="btn-md col-lg-6" >
                                                    <input type="text" name="str" class="btn btn-lg btn-rounded form-control" placeholder="Type name, email , mobile to search"/>
                                                </span>

                                                <button type="submit" class="btn btn-danger btn-rounded btn-fw" name="action" value="search">Search</button>

                                            </div>
                                        </form>

                                        <div class="table-responsive">
                                            <table class="table table-striped">
                                                <thead>
                                                    <tr>

                                                        <th>ID</th>
                                                        <th>Name</th>
                                                        <th>Email</th>
                                                        <th>Mobile</th>
                                                        <th>Role</th>
                                                        <th>Last login</th>
                                                        <th>Status</th>
                                                        <th>Action</th>

                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach items="${list}" var="n" >
                                                        <tr>

                                                            <td>
                                                                ${n.getUserID()}
                                                            </td>
                                                            <td>
                                                                ${n.getFullName()}
                                                            </td>
                                                            <td>
                                                                ${n.getEmail()}
                                                            </td>
                                                            <td>${n.getMobile()}</td>

                                                            <td>${n.getRollId()}</td>
                                                            <td>

                                                            </td>

                                                            <td>
                                                                <c:choose> 
                                                                    <c:when test="${n.getStatus().equals('1')}">
                                                                        Active
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        Block
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </td>
                                                            <td> 
                                                                <span>
                                                                    <button class="btn btn-warning btn-rounded btn-fw text-white mb-0 me-0" style = "height: 45px"type="button" onclick="location.href = './userdetail?userID=${n.getUserID()}';"><i >Edit</i></button>

                                                                </span>
                                                                <span>
                                                                    <c:choose> 
                                                                        <c:when test="${n.getStatus().equals('1')}">
                                                                            <button class="btn btn-danger btn-rounded btn-fw  text-white mb-0 me-0" style = "height: 45px"type="button" onclick="location.href = './userlist?action=change&id=${n.getUserID()}';">
                                                                                <i >
                                                                                    Block
                                                                                </i>
                                                                            </button>
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <button class="btn btn-info btn-rounded btn-fw  text-white mb-0 me-0" style = "height: 45px"type="button" onclick="location.href = './userlist?action=change&id=${n.getUserID()}';">
                                                                                <i>
                                                                                    Active
                                                                                </i>
                                                                            </button>
                                                                        </c:otherwise>
                                                                    </c:choose>

                                                                </span>
                                                            </td>
                                                        </tr>
                                                    </c:forEach>




                                                </tbody>
                                            </table>
                                            <nav aria-label="Page navigation example" class="d-flex justify-content-center">


                                                <ul class="pagination">
                                                    <li class="page-item"><a class="page-link" href="./userlist">Previous</a></li>
                                                        <c:forEach var="o" begin = "1" end="${size}"  >
                                                        <li class="page-item"><a class="page-link" href="./userlist?page=${o}">${o}</a></li>
                                                        </c:forEach>                                                        
                                                    <li class="page-item"><a class="page-link" href="./userlist">Next</a></li>
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
                window.location = "userlist?action=change&id=" + id;
            }
        }
    </script>
    <script>
        function doSearch(role, status, str) {

            window.location = "userlist?action=search&role=" + role + "&status=" + status + "&str=" + str;

        }
    </script>
</html>


