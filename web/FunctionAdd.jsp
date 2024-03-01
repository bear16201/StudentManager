<%-- 
    Author     : Phuc
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Function Details</title>   
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
                                <form action="functionadd" method="post" class="form-sample" id="register-form"> 
                                    <div class="d-sm-flex justify-content-between align-items-start">
                                        <div>
                                            <h1 class=" Title">Function Details</h1>
                                        </div>                          
                                    </div>
                                    <c:if test="${sessionScope.acc.rollId == 0}" >
                                        <div class="row">
        
                                            <div class="col-md-6">
                                                <div class="form-group row">
                                                    <label class="col-sm-3 col-form-label">Name</label>
                                                    <div class="col-sm-9">
                                                        <input type="text" class="group1" value="" name="function_name">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group row">
                                                    <label class="col-sm-3 col-form-label">Team</label>
                                                    <div class="col-sm-9">
                                                        <select name="team_name" class="group1">                 
                                                            <c:forEach items="${t}" var="l">
                                                                <option value="${l.name}">${l.name}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group row">
                                                    <label class="col-sm-3 col-form-label">Feature</label>
                                                    <div class="col-sm-9">
                                                        <select name="feature_name" class="group1">
                                                           
                                                            <c:forEach items="${f}" var="l">
                                                                <option value="${l.feature_name}">${l.feature_name}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group row">
                                                    <label class="col-sm-3 col-form-label">Role</label>
                                                    <div class="col-sm-9">
                                                        <select name="access_role" class="group1">
                                                            
                                                            <option value="0">Admin (0)</option>
                                                            <option value="1">Trainer (1)</option>
                                                            <option value="2">Student (2)</option>
                                                            <option value="3">User (3)</option>
                                                            <option value="4">Admin, Author (4)</option>
                                                            <option value="5">Admin, Author, Trainer (5)</option>
                                                            <option value="6">Student, Trainer (6)</option>
                                                            <option value="7">< Blank > (7)</option>
                                                        </select>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group row">
                                                    <label class="col-sm-3 col-form-label">Owner</label>
                                                    <div class="col-sm-9">
                                                        <select name="owner_name" class="group1">
                                                            
                                                            <c:forEach items="${u}" var="l">
                                                                <option value="${l.fullName}">${l.fullName}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group row">
                                                    <label class="col-sm-3 col-form-label">Priority</label>
                                                    <div class="col-sm-9">
                                                        <input type="text" class="group1" value="" name="priority">
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group row">
                                                    <label class="col-sm-3 col-form-label">Status</label>
                                                    <div class="col-sm-3">
                                                        <div class="form-check">
                                                            <label class="form-check-label">
                                                                <input type="radio" class="form-check-input" name="status" id="membershipRadios1" value="0" ${d.getStatus() == 0?"checked":""}>
                                                                Done
                                                                <i class="input-helper"></i>
                                                            </label>
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-3">
                                                        <div class="form-check">
                                                            <label class="form-check-label">
                                                                <input type="radio" class="form-check-input" name="status" id="membershipRadios2" value="1" ${d.getStatus() == 1?"checked":""}>
                                                                Doing
                                                                <i class="input-helper"></i></label>
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-3">
                                                        <div class="form-check">
                                                            <label class="form-check-label">
                                                                <input type="radio" class="form-check-input" name="status" id="membershipRadios2" value="2" ${d.getStatus() == 2?"checked":""}>
                                                                To Do
                                                                <i class="input-helper"></i></label>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>  
                                        </div> 
                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group row">
                                                    <label class="col-sm-3 col-form-label">Complexity</label>
                                                    <div class="col-sm-3">
                                                        <div class="form-check">
                                                            <label class="form-check-label">
                                                                <input type="radio" class="form-check-input" name="complex" id="membershipRadios1" value="0" ${d.getComplexity_id() == 0?"checked":""}>
                                                                Simple
                                                                <i class="input-helper"></i>
                                                            </label>
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-3">
                                                        <div class="form-check">
                                                            <label class="form-check-label">
                                                                <input type="radio" class="form-check-input" name="complex" id="membershipRadios2" value="1" ${d.getComplexity_id() == 1?"checked":""}>
                                                                Medium
                                                                <i class="input-helper"></i></label>
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-3">
                                                        <div class="form-check">
                                                            <label class="form-check-label">
                                                                <input type="radio" class="form-check-input" name="complex" id="membershipRadios2" value="2" ${d.getComplexity_id() == 2?"checked":""}>
                                                                Complex
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
                                                    <textarea class="group111" name="description">${d.description}</textarea>                                   
                                                </div>
                                            </div>
                                            <div class="col-sm-5">
                                                <div style="color: red; margin: 0px 188px; width: 155%; font-size: 20px;">
                                                    ${messD} 
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-sm-5">
                                            <div style="color: red; padding-bottom:40px; font-size: 30px">
                                                ${mess} 
                                            </div>
                                        </div>
                                    </c:if>

                                    <c:if test="${sessionScope.acc.rollId == 1 || sessionScope.acc.rollId == 0}" >
                                        <button type="submit" class="btn btn-primary btn-icon-text" >
                                            <i class="ti-file btn-icon-prepend"></i>
                                            Save
                                        </button>
                                    </c:if>
                                    <span class="ad">
                                        <a href="functionlist">
                                            <button class="btn btn-danger btn-rounded btn-fw  text-white mb-0 me-0" style = "height: 45px"type="button">
                                                <i>
                                                    Back to Team List
                                                </i>
                                            </button>
                                        </a>
                                    </span>
                                </form>
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


