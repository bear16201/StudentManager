<%-- 
    Author     : Phuc
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Class Details</title>   
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
                    <div class="col-12 grid-margin">
                        <div class="card">
                            <div class="card-body">
                                <div class="d-sm-flex justify-content-between align-items-start">
                                    <div>
                                        <h1 class=" Title">Class Detail</h1>
                                    </div>                                       
                                </div>
                                <form action="classDetails" method="post" class="form-sample" id="register-form">  
                                    <input name="class_id" value="${listClass.classID}" hidden="">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group row">
                                                <label class="col-sm-3 col-form-label">Class Code</label>
                                                <div class="col-sm-9">
                                                    <input type="text" class="group1" value="${listClass.classCode}" name="class_code">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="col-md-6">
                                                <div class="form-group row">
                                                    <label class="col-sm-3 col-form-label" >TrainerID</label>
                                                    <div class="col-sm-9">
                                                        <select name="trainer_id" class="group1">
                                                            <c:forEach items="${listUser}" var="listUser">
                                                                <option value="${listUser.userID}" ${listUser.userID == listClass.trainerID ? "selected" : ""}>${listUser.userID}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group row">
                                                <label class="col-sm-3 col-form-label">Subject ID</label>
                                                <div class="col-sm-9">
                                                    <select name="subject_id" class="group1">
                                                        <c:forEach items="${listSub}" var="listSub">
                                                            <option value="${listSub.subject_id}" ${listSub.subject_id == listClass.subjectID ? "selected" : ""}>${listSub.subject_id}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group row">
                                                <label class="col-sm-3 col-form-label">Class Year</label>
                                                <div class="col-sm-9">
                                                    <input type="text" class="group11" value="${listClass.classYear}" name="class_year">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group row">
                                                <label class="col-sm-3 col-form-label">Class Term</label>
                                                <div class="col-sm-9">
                                                    <input type="text" class="group11" value="${listClass.classTerm}" name="class_term">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group row">
                                                <label class="col-sm-3 col-form-label">Block 5</label>
                                                <div class="col-sm-4">
                                                    <div class="form-check">
                                                        <label class="form-check-label">
                                                            <input type="radio" class="form-check-input" name="block5_class" id="membershipRadios1" value="1" ${listClass.block5Class == 1?"checked":""}>
                                                            YES
                                                            <i class="input-helper"></i>
                                                        </label>
                                                    </div>
                                                </div>
                                                <div class="col-sm-5">
                                                    <div class="form-check">
                                                        <label class="form-check-label">
                                                            <input type="radio" class="form-check-input" name="block5_class" id="membershipRadios2" value="0" ${listClass.block5Class == 0?"checked":""}>
                                                            NO
                                                            <i class="input-helper"></i></label>
                                                    </div>
                                                </div>

                                            </div>
                                        </div>  

                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group row">
                                                    <label class="col-sm-3 col-form-label">Status</label>
                                                    <div class="col-sm-4">
                                                        <div class="form-check">
                                                            <label class="form-check-label">
                                                                <input type="radio" class="form-check-input" name="status" id="membershipRadios1" value="1" ${listClass.status == 1?"checked":""}>
                                                                Active
                                                                <i class="input-helper"></i>
                                                            </label>
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-5">
                                                        <div class="form-check">
                                                            <label class="form-check-label">
                                                                <input type="radio" class="form-check-input" name="status" id="membershipRadios2" value="0" ${listClass.status == 0?"checked":""}>
                                                                Inactive
                                                                <i class="input-helper"></i></label>
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-5">
                                                        <div style="color: red; width: 453px;">
                                                            ${messWarring} 
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>  
                                        </div> 
                                    </div>
                                    <c:if test="${sessionScope.acc.rollId == 0}" >
                                        <span>
                                            <div class="form-submit">
                                                <input type="submit" value="Save" class="btn btn-primary btn-icon-text" id="submit" />                      
                                            </div>
                                        </span>
                                    </c:if>

                                </form>
                                <span class="ad">
                                    <a href="classList"><button class="btn btn-danger btn-rounded btn-fw  text-white mb-0 me-0" style = "height: 45px"type="button">
                                            <i>
                                                Back to Class List
                                            </i>
                                        </button>
                                    </a>
                                </span>
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


