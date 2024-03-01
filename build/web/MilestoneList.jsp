<%-- 
    Author     : Phuc
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Milestone List</title>  
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
                                                <h1 class=" display1 card-title card-title-dash"> Milestone List</h1>

                                            </div>
                                            <div >

                                                <button class=" btn btn-md  btn-success btn-rounded btn-icon "  onclick="location.href = './milestonedetail';" >
                                                    <i class="ti-plus"></i>
                                                </button>

                                            </div>

                                        </div>
                                        <form action="milestone" method="get" >

                                            <div class="d-sm-flex justify-content align-items-start">
                                                <span class="dropdown" name="byClass">
                                                    <button class="btn btn-secondary btn-rounded  dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                                        <a style="color: rosybrown ; font-weight: bold; "> ${byClass} </a>
                                                    </button>
                                                    <div class="dropdown-menu " aria-labelledby="dropdownMenuButton1" name="status">
                                                        <a class="dropdown-item"   onclick="location.href = './milestone';">
                                                            <span style="color: rosybrown ; font-weight: bold; ">  All Class </span>

                                                        </a>

                                                        <c:forEach items="${listC}" var="c" >
                                                            <a class="dropdown-item"  value="${c.getClassID()}" onclick="location.href = './milestone?action=search&classid=${c.getClassID()}';"> <span style="color: rosybrown"> ${c.getClassCode()} </span></a>
                                                        </c:forEach>
                                                    </div>
                                                </span>
                                                <span class="dropdown" name="byIter">
                                                    <button class="btn btn-secondary btn-rounded  dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                                        <span style="color: rosybrown ; font-weight: bold; ">   ${byIter} </span>
                                                    </button>
                                                    <div class="dropdown-menu " aria-labelledby="dropdownMenuButton1" name="status">
                                                        <a class="dropdown-item"   onclick="location.href = './milestone';">  <span style="color: rosybrown ; font-weight: bold; "> All Iteration </span></a>

                                                        <c:forEach items="${listI}" var="i" >
                                                            <a class="dropdown-item"  value="${i.getId()}" onclick="location.href = './milestone?action=search&iterid=${i.getId()}';"> <span style="color: rosybrown ; font-weight: bold; ">  ${i.getName()} </span></a>
                                                        </c:forEach>
                                                    </div>
                                                </span>
                                                <span class="dropdown" name="status">
                                                    <button class="btn btn-secondary btn-rounded  dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                                        <span style="color: rosybrown ; font-weight: bold; ">    Status </span>
                                                    </button>
                                                    <div class="dropdown-menu " aria-labelledby="dropdownMenuButton1" name="status">
                                                        <a class="dropdown-item"  value="0"  onclick="location.href = './milestone ';"> <span style="color: rosybrown ; font-weight: bold; "> All Roles  </span></a>
                                                        <a class="dropdown-item"  value="0"  onclick="location.href = './milestone?action=search&status=0';"> <span style="color: red ; font-weight: bold; "> Inactive      </span></a>
                                                        <a class="dropdown-item"  value="1"  onclick="location.href = './milestone?action=search&status=1';"> <span style="color: blue ; font-weight: bold; "> Active     </span></a>

                                                    </div>
                                                </span>

                                                <span>
                                                    <span style="color: red ; font-weight: bold; "> 
                                                        <i class=" mdi mdi-magnify"></i>      
                                                        From
                                                        <input class="btn btn-secondary btn-rounded "   type="date" name="from" value="" />
                                                    </span>


                                                </span>
                                                <span>
                                                    <span style="color: red ; font-weight: bold; "> 
                                                        <!--<i class=" mdi mdi-magnify"></i>-->      
                                                        To
                                                        <input class="btn btn-secondary btn-rounded "   type="date" name="to" value="" />
                                                    </span>


                                                </span>
                                                <button type="submit" class="btn btn-danger btn-rounded btn-fw" name="action" value="search"> <i class=" mdi mdi-magnify"></i> </button>

                                            </div>
                                        </form>

                                        <div class="table-responsive">
                                            <table class="table table-striped">
                                                <thead>
                                                    <tr>

                                                        <th>
                                                            ID  
                                                            <span class="align-items-start"> 
                                                                <i class="icon-arrow-up" onclick="location.href = './milestone?action=sort&table=milestone_id&inco=0';"></i>
                                                                <i class="icon-arrow-down" onclick="location.href = './milestone?action=sort&table=milestone_id&inco=1';"></i>
                                                            </span>
                                                        </th>
                                                        <th >
                                                            Class code 
                                                            <span class="align-items-start"> 
                                                                <i class="icon-arrow-up" onclick="location.href = './milestone?action=sort&table=class_code&inco=0';"></i>
                                                                <i class="icon-arrow-down" onclick="location.href = './milestone?action=sort&table=class_code&inco=1';"></i>
                                                            </span>
                                                        </th>
                                                        <th>
                                                            Iteration name 
                                                            <span class="align-items-start"> 
                                                                <i class="icon-arrow-up" onclick="location.href = './milestone?action=sort&table=iteration_name&inco=0';"></i>
                                                                <i class="icon-arrow-down" onclick="location.href = './milestone?action=sort&table=iteration_name&inco=1';"></i>
                                                            </span>
                                                        </th>
                                                        <th>
                                                            From date
                                                            <span class="align-items-start"> 
                                                                <i class="icon-arrow-up" onclick="location.href = './milestone?action=sort&table=from_date&inco=0';"></i>
                                                                <i class="icon-arrow-down" onclick="location.href = './milestone?action=sort&table=from_date&inco=1';"></i>
                                                            </span>
                                                        </th>
                                                        <th>
                                                            To Date 
                                                            <span class="align-items-start"> 
                                                                <i class="icon-arrow-up" onclick="location.href = './milestone?action=sort&table=to_date&inco=0';"></i>
                                                                <i class="icon-arrow-down" onclick="location.href = './milestone?action=sort&table=to_date&inco=1';"></i>
                                                            </span>
                                                        </th>
                                                        <th>
                                                            Status 
                                                            <span class="align-items-start"> 
                                                                <i class="icon-arrow-up" onclick="location.href = './milestone?action=sort&table=status&inco=0';"></i>
                                                                <i class="icon-arrow-down" onclick="location.href = './milestone?action=sort&table=status&inco=1';"></i>
                                                            </span>
                                                        </th>
                                                        <th>Action</th>

                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach items="${list}" var="n" >
                                                        <tr>

                                                            <td>
                                                                ${n.getId()}
                                                            </td>
                                                            <td>
                                                                ${n.getClass_name()}
                                                            </td>
                                                            <td>
                                                                ${n.getIteration_name()}
                                                            </td>
                                                            <td>
                                                                ${n.getFrom_date()}
                                                            </td>

                                                            <td>
                                                                ${n.getTo_date()}
                                                            </td>
                                                            <td>   
                                                                <c:choose> 
                                                                    <c:when test="${n.getStatus()== 1}">
                                                                        <div style="color: blue ; font-weight: bold; "> Active </div>  
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        <div style="color: red ; font-weight: bold; "> InActive </div>   
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </td>


                                                            <td> 
                                                                <span>
                                                                    <button class="btn btn-outline-warning   btn-rounded btn-fw text-dark mb-0 me-0" style = "height: 45px"type="button" onclick="location.href = './milestonedetail?id=${n.getId()}';">

                                                                        <i class=" mdi mdi-grease-pencil"></i>          

                                                                    </button>

                                                                </span>
                                                                <span>
                                                                    <c:choose> 
                                                                        <c:when test="${n.getStatus()== 1}">
                                                                            <button class="btn btn-danger btn-rounded btn-fw  text-white mb-0 me-0" style = "height: 45px"type="button" onclick="doChange(${n.getId()})">
                                                                                <i >
                                                                                    Block
                                                                                </i>
                                                                            </button>
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <button class="btn btn-info btn-rounded btn-fw  text-white mb-0 me-0" style = "height: 45px"type="button" onclick="doChange(${n.getId()})">
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

</html>

<script>
    function doChange(id) {
        if (confirm("Do you want change status  Milestone ID = " + id + "?")) {
            window.location = "./milestone?action=change&id=" + id;
        }
    }
</script>
