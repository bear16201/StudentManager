<%-- 
    Author     : Phuc
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Iteration Add</title>

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
                                <form action="criteriaadd" method="post" class="form-sample" id="register-form"> 
                                    <div class="d-sm-flex justify-content-between align-items-start">
                                        <div>
                                            <h1 class=" Title">Criteria Add</h1>
                                        </div>                          
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group row">
                                                <label class="col-sm-3 col-form-label">Criteria Name</label>
                                                <div class="col-sm-9">
                                                    <input type="text" class="group1" value="${d.criteria_name}" name="critname" >
                                                </div>
                                            </div>
                                            <div class="col-sm-5">
                                                <div style="color: red; margin: -36px 188px; width: 155%; font-size: 20px">
                                                    ${messN} 
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group row">
                                                    <label class="col-sm-3 col-form-label">Subject Name</label>
                                                    <div class="col-sm-9">
                                                        <select name="sbname" class="group1">

                                                            <c:forEach items="${listS}" var="l">
                                                                <option class="group1" value="${l.subject_name}">${l.subject_name}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group row">
                                                <label class="col-sm-3 col-form-label">Iteration Name</label>
                                                <div class="col-sm-9">
                                                    <select name="iteration_name" class="group1"> 
                                                        <c:forEach items="${l}" var="l">
                                                            <option value="${l.name}">${l.name}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group row">
                                                <label class="col-sm-3 col-form-label">Weight*</label>
                                                <div class="col-sm-9">
                                                    <input type="text" class="group1" value="" name="evaluation_weight" >
                                                </div>
                                            </div>
                                            <div class="col-sm-5">
                                                <div style="color: red; margin: -36px 188px; width: 155%; font-size: 20px">
                                                    ${messW} 
                                                </div>
                                            </div>
                                        </div>                    
                                        <div class="col-md-6">
                                            <div class="form-group row">
                                                <label class="col-sm-3 col-form-label">Criteria Order*</label>
                                                <div class="col-sm-9">
                                                    <input type="text" class="group1" value="" name="criteria_order">            
                                                </div>
                                            </div>
                                            <div class="col-sm-5">
                                                <div style="color: red; margin: 0px 188px; width: 155%; font-size: 20px">
                                                    ${messO} 
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group row">
                                                <label class="col-sm-3 col-form-label">Max Loc*</label>
                                                <div class="col-sm-9">
                                                    <input type="text" class="group1" value="" name="max_loc">            
                                                </div>
                                            </div>
                                            <div class="col-sm-5">
                                                <div style="color: red; margin: 0px 188px; width: 155%; font-size: 20px">
                                                    ${messL} 
                                                </div>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group row">
                                                    <label class="col-sm-3 col-form-label">Team Evaluation</label>
                                                    <div class="col-sm-4">
                                                        <div class="form-check">
                                                            <label class="form-check-label">
                                                                <input type="radio" class="form-check-input" name="team_evaluation" id="membershipRadios1" value="1" checked="">
                                                                Yes
                                                                <i class="input-helper"></i>
                                                            </label>
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-5">
                                                        <div class="form-check">
                                                            <label class="form-check-label">
                                                                <input type="radio" class="form-check-input" name="team_evaluation" id="membershipRadios2" value="0">
                                                                No
                                                                <i class="input-helper"></i></label>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>  
                                            <div class="col-md-6">
                                                <div class="form-group row">
                                                    <label class="col-sm-3 col-form-label">Status</label>
                                                    <div class="col-sm-4">
                                                        <div class="form-check">
                                                            <label class="form-check-label">
                                                                <input type="radio" class="form-check-input" name="status" id="membershipRadios1" value="1" checked="">
                                                                Active
                                                                <i class="input-helper"></i>
                                                            </label>
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-5">
                                                        <div class="form-check">
                                                            <label class="form-check-label">
                                                                <input type="radio" class="form-check-input" name="status" id="membershipRadios2" value="0">
                                                                Inactive
                                                                <i class="input-helper"></i></label>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>  
                                        </div> 
                                        <div class="row">
                                            <div class="form-group row">
                                                <label class="col-sm-3 col-form-label">Description</label>
                                                <div class="col-sm-9">
                                                    <textarea class="group111" name="description"></textarea>                                   
                                                </div>
                                            </div>
                                            <div class="col-sm-5">
                                                <div style="color: red; margin: 0px 188px; width: 155%; font-size: 20px;">
                                                    ${messD} 
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <button type="submit" class="btn btn-primary btn-icon-text" >
                                        <i class="ti-file btn-icon-prepend"></i>
                                        Add
                                    </button>

                                    <span class="ad">
                                        <a href="iterationlist">
                                            <button class="btn btn-danger btn-rounded btn-fw  text-white mb-0 me-0" style = "height: 45px"type="button">
                                                <i>
                                                    Back to Iteration List
                                                </i>
                                            </button>
                                        </a>
                                    </span>
                                </form>
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


