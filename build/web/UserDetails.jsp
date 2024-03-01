<%-- 
    Author     : Phuc
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>User Details</title>
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
                            <div class="col-12 grid-margin">
                                <div class="card">
                                    <div class="card-body">
                                        <h4 class="Title">User Detail</h4>
                                        <c:set value="${user}" var="u" />
                                        <form class="form-sample" action="userdetail" method="post">

                                            <p class="card-description">
                                                Personal info
                                            </p>
                                            <div class="row">
                                                <div class="col-md-6">
                                                    <div class="form-group row">
                                                        <label class="col-sm-3 col-form-label">Họ tên</label>
                                                        <div class="col-sm-9">
                                                            <input type="text" class="form-control"  name="fullName"  value="${u.getFullName()}" />
                                                        </div>
                                                    </div>
                                                    <div class="form-group row">
                                                        <label class="col-sm-3 col-form-label">Email</label>
                                                        <div class="col-sm-9">
                                                            <input type="text" class="form-control"  name="email"  value="${u.getEmail()}"  />
                                                        </div>
                                                    </div>
                                                    <div class="form-group row">
                                                        <label class="col-sm-3 col-form-label">Mobile</label>
                                                        <div class="col-sm-9">
                                                            <input type="text" class="form-control"  name="mobile"  value="${u.getMobile()}" />
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-6 row">

                                                    <div class="form-group row">
                                                        <label class="col-sm-4 col-form-label"></label>
                                                        <div class="col-sm-8">
                                                            <img class="col-sm-9" src ="https://pdp.edu.vn/wp-content/uploads/2021/06/hinh-anh-suy-tu-1.jpg" style=""/>
                                                        </div>

                                                    </div>
                                                    <div class="form-group row">
                                                        <label class="col-sm-3 col-form-label">UserID</label>
                                                        <div class="col-sm-9">
                                                            <input type="text" class="form-control"  name="userID"  value="${u.getUserID()}" />
                                                        </div>
                                                    </div>
                                                </div>


                                            </div>


                                            <div class="row">
                                                <div class="col-md-6">
                                                    <div class="form-group row">
                                                        <label class="col-sm-3 col-form-label">Giới Tính</label>
                                                        <div class="col-sm-9">
                                                            <select class="form-control"  name="gender"  value="${u.isGender()}"  >
                                                                <option  class="form-control"  name="gender"  value="0"  >Male</option>
                                                                <option  class="form-control"  name="gender"  value="1"  >Female</option>
                                                            </select>
                                                        </div>

                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group row">
                                                        <label class="col-sm-3 col-form-label">Date</label>
                                                        <div class="col-sm-9">
                                                            <input type="text" class="form-control"  name="date"  value="${u.getDate()}" />
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-6">
                                                    <div class="form-group row">
                                                        <label class="col-sm-3 col-form-label">Roll</label>
                                                        <div class="col-sm-9">
                                                            <input type="text" class="form-control"  name="roll"  value="${u.getRoll()}"  />
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group row">
                                                        <label class="col-sm-3 col-form-label">Status</label>
                                                        <div class="col-sm-9">
                                                            <input type="text" class="form-control"  name="status"  value="${u.getStatus()}" />
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-6">
                                                    <div class="form-group row">
                                                        <label class="col-sm-3 col-form-label">Vị trí công việc</label>
                                                        <div class="col-sm-9">
                                                            <input type="text" class="form-control" name="roleid" value="${u.getRollId()}" />
                                                        </div>
                                                    </div>
                                                </div>
                                                <!--                                                <div class="col-md-6">
                                                                                                    <div class="form-group row">
                                                                                                        <label class="col-sm-3 col-form-label">Công ty</label>
                                                                                                        <div class="col-sm-9">
                                                                                                            <input type="text" class="form-control" value="" />
                                                                                                        </div>
                                                                                                    </div>
                                                                                                </div>-->
                                                <div class="col-md-6">
                                                    <div class="form-group row">
                                                        <label class="col-sm-3 col-form-label">Địa chỉ</label>
                                                        <div class="col-sm-9">
                                                            <input type="text" class="form-control" name="address" value="${u.getAddress()}"  />
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <!--                                        <div class="row">
                                                                                        <div class="col-md-6">
                                                                                            <div class="form-group row">
                                                                                                <label class="col-sm-3 col-form-label">Địa chỉ</label>
                                                                                                <div class="col-sm-9">
                                                                                                    <input type="text" class="form-control" name="addreess" value="${u.getAddress()}"  />
                                                                                                </div>
                                                                                            </div>
                                                                                        </div>
                                            
                                                                                    </div>-->
                                            <button type="submit" class="btn btn-primary btn-icon-text" >
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


