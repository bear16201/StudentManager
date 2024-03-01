<%-- 
    Author     : Phuc
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Milestone Details</title>
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
                            <div class="col-12 grid-margin">
                                <div class="card">
                                    <div class="card-body">
                                        <h4 class="card-title">Milestone Detail</h4>
                                        <form class="form-sample" action="milestonedetail" method="post">
                                            <c:set value="${mi}" var="mi" />

                                            <p class="card-description">
                                            </p>
                                            <div class="row">
                                                <div class="col-md-6">
                                                    <div class="form-group row">
                                                        <span class="col-sm-3 ">Milestone Id</span>
                                                        <div class="col-sm-9">
                                                            <input type="text" class="form-control"  name="id"  value="${miid}"  />
                                                        </div>
                                                    </div>

                                                    <div class="form-group row">
                                                        <span class="col-sm-3 ">Iteration Name</span>
                                                        <div class="col-sm-9">
                                                            <select class=" form-control"  name="iterid"    style="color: black ;  "  >
                                                                <c:forEach items="${listI}" var="i" >
                                                                    <option  class=" form-control" name="iterid"  value="${i.getId()}"   >${i.getName()}</option>
                                                                </c:forEach>

                                                            </select>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-6 row">

                                                    <div class="form-group row">
                                                        <span class="col-sm-3 ">Class Code</span>
                                                        <div class="col-sm-9">
                                                            <select class=" form-control"  name="classid"    style="color: black ;  " >
                                                                <c:forEach items="${listC}" var="c" >
                                                                    <option  class=" form-control" name="classid"  value="${c.getClassID()}"  >${c.getClassCode()}</option>
                                                                </c:forEach>

                                                            </select>
                                                        </div>
                                                    </div>
                                                </div>


                                            </div>


                                            <div class="row">
                                                <div class="col-md-6">
                                                    <div class="form-group row">
                                                        <span class="col-sm-3 ">From Date</span>
                                                        <div class="col-sm-9">
                                                            <input type="date" class="form-control"  name="from"  value="${from}" />
                                                        </div>

                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group row">
                                                        <span class="col-sm-3 ">To Date</span>
                                                        <div class="col-sm-9">
                                                            <input type="date" class="form-control"  name="to"  value="${to}"  />
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">


                                                <div class="col-md-6">
                                                    <div class="form-group row">
                                                        <span class="col-sm-3 ">Status</span>
                                                        <div class="col-sm-9">
                                                            <input type="hidden" name="status" value="${mi.getStatus()}"/>
                                                            <c:choose>
                                                                <c:when test="${mi.getStatus()==0}">
                                                                    <c:out  value="InActive"   /> 
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <c:out  value="Active" /> 
                                                                </c:otherwise>
                                                            </c:choose>


                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div style="color: red ; font-weight: bold ;">
                                                    <c:out value="${message}" /> 
                                                </div>
                                                <div style="color: green ; font-weight: bold ;">
                                                    <c:out value="${su}" /> 
                                                </div>
                                            </div>
                                            <button type="submit" class="btn btn-danger btn-icon-text" >
                                                <i class="ti-file btn-icon-prepend"></i>
                                                Submit
                                            </button>

                                        </form>
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


