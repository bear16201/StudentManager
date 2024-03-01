<%-- 
    Author     : Phuc
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <title>Team Details</title>
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
                                <form action="teamdetails" method="post" class="form-sample" id="register-form"> 
                                    <div class="d-sm-flex justify-content-between align-items-start">
                                        <div>
                                            <h1 class=" Title">Team Details</h1>
                                        </div>                          
                                    </div>
                                    <c:if test="${sessionScope.acc.rollId == 0}" >
                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group row">
                                                    <label class="col-sm-3 col-form-label">Team ID</label>
                                                    <div class="col-sm-9">
                                                        <input type="text" class="group1" value="${d.team_id}" name="team_id" readonly="">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group row">
                                                    <label class="col-sm-3 col-form-label">Name</label>
                                                    <div class="col-sm-9">
                                                        <input type="text" class="group1" value="${d.name}" name="name">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group row">
                                                    <label class="col-sm-3 col-form-label">Class Code</label>
                                                    <div class="col-sm-9">
                                                        <select name="class_code" class="group1">
                                                            <option value="${d.class_code}" style="display: none">${d.class_code}</option>
                                                            <c:forEach items="${l}" var="l">
                                                                <option value="${l.classCode}">${l.classCode}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group row">
                                                    <label class="col-sm-3 col-form-label">Topic Code</label>
                                                    <div class="col-sm-9">
                                                        <input type="text" class="group1" value="${d.topic_code}" name="topic_code" >
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group row">
                                                    <label class="col-sm-3 col-form-label">Topic Name</label>
                                                    <div class="col-sm-9">
                                                        <input type="text" class="group1" value="${d.topic_name}" name="topic_name">            
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
                                                                <input type="radio" class="form-check-input" name="status" id="membershipRadios1" value="1" ${d.getStatus() == 1?"checked":""}>
                                                                Active
                                                                <i class="input-helper"></i>
                                                            </label>
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-5">
                                                        <div class="form-check">
                                                            <label class="form-check-label">
                                                                <input type="radio" class="form-check-input" name="status" id="membershipRadios2" value="0" ${d.getStatus() == 0?"checked":""}>
                                                                Inactive
                                                                <i class="input-helper"></i></label>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>  
                                        </div> 
                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group row">
                                                    <label class="col-sm-3 col-form-label">Gitlab Url</label>
                                                    <div class="col-sm-9">
                                                        <textarea name="gitlab_url" class="group111">${d.gitlab_url}</textarea>       
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-sm-5">
                                            <div style="color: red; padding-bottom:40px; font-size: 30px">
                                                ${mess} 
                                            </div>
                                        </div>
                                    </c:if>
                                    <c:if test="${sessionScope.acc.rollId == 1}" >
                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group row">
                                                    <label class="col-sm-3 col-form-label">Team ID</label>
                                                    <div class="col-sm-9">
                                                        <input type="text" class="group1" value="${d.team_id}" name="team_id" readonly="">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group row">
                                                    <label class="col-sm-3 col-form-label">Name</label>
                                                    <div class="col-sm-9">
                                                        <input type="text" class="group1" value="${d.name}" name="name">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group row">
                                                    <label class="col-sm-3 col-form-label">Class Code</label>
                                                    <div class="col-sm-9">
                                                        <select name="class_code" class="group1">
                                                            <option value="${d.class_code}" style="display: none">${d.class_code}</option>
                                                            <c:forEach items="${l}" var="l">
                                                                <option value="${l.class_code}">${l.class_code}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group row">
                                                    <label class="col-sm-3 col-form-label">Topic Code</label>
                                                    <div class="col-sm-9">
                                                        <input type="text" class="group1" value="${d.topic_code}" name="topic_code" >
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group row">
                                                    <label class="col-sm-3 col-form-label">Topic Name</label>
                                                    <div class="col-sm-9">
                                                        <input type="text" class="group1" value="${d.topic_name}" name="topic_name">            
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
                                                                <input type="radio" class="form-check-input" name="status" id="membershipRadios1" value="1" ${d.getStatus() == 1?"checked":""}>
                                                                Active
                                                                <i class="input-helper"></i>
                                                            </label>
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-5">
                                                        <div class="form-check">
                                                            <label class="form-check-label">
                                                                <input type="radio" class="form-check-input" name="status" id="membershipRadios2" value="0" ${d.getStatus() == 0?"checked":""}>
                                                                Inactive
                                                                <i class="input-helper"></i></label>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>  
                                        </div> 
                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group row">
                                                    <label class="col-sm-3 col-form-label">Gitlab Url</label>
                                                    <div class="col-sm-9">
                                                        <textarea name="gitlab_url" class="group111">${d.gitlab_url}</textarea>       
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-sm-5">
                                            <div style="color: red; padding-bottom:40px; font-size: 30px">
                                                ${mess} 
                                            </div>
                                        </div>
                                    </c:if>
                                    <c:if test="${sessionScope.acc.rollId == 2}" >
                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group row">
                                                    <label class="col-sm-3 col-form-label">Team ID</label>
                                                    <div class="col-sm-9">
                                                        <input type="text" class="group1" value="${d.team_id}" name="team_id" readonly="">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group row">
                                                    <label class="col-sm-3 col-form-label">Name</label>
                                                    <div class="col-sm-9">
                                                        <input type="text" class="group1" value="${d.name}" name="name" readonly="">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group row">
                                                    <label class="col-sm-3 col-form-label">Class Code</label>
                                                    <div class="col-sm-9">
                                                        <input type="text" class="group1" value="${d.class_code}" name="class_code" readonly="">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group row">
                                                    <label class="col-sm-3 col-form-label">Topic Code</label>
                                                    <div class="col-sm-9">
                                                        <input type="text" class="group1" value="${d.topic_code}" name="topic_code" readonly="">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group row">
                                                    <label class="col-sm-3 col-form-label">Topic Name</label>
                                                    <div class="col-sm-9">
                                                        <input type="text" class="group1" value="${d.topic_name}" name="topic_name" readonly="">            
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
                                                                <input type="radio" class="form-check-input" name="status" id="membershipRadios1" value="1" ${d.getStatus() == 1?"checked":""} readonly="">
                                                                Active
                                                                <i class="input-helper"></i>
                                                            </label>
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-5">
                                                        <div class="form-check">
                                                            <label class="form-check-label">
                                                                <input type="radio" class="form-check-input" name="status" id="membershipRadios2" value="0" ${d.getStatus() == 0?"checked":""} readonly="">
                                                                Inactive
                                                                <i class="input-helper"></i></label>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>  
                                        </div> 
                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group row">
                                                    <label class="col-sm-3 col-form-label">Gitlab Url</label>
                                                    <div class="col-sm-9">   
                                                        <input type="text" class="group111" value="${d.gitlab_url}" name="gitlab_url" readonly=""> 
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-sm-5">
                                            <div style="color: red; padding-bottom:40px; font-size: 30px">
                                                ${mess} 
                                            </div>
                                        </div>
                                    </c:if>
                                    <c:if test="${sessionScope.acc.rollId == 1}" >
                                        <button type="submit" class="btn btn-primary btn-icon-text" >
                                            <i class="ti-file btn-icon-prepend"></i>
                                            Save
                                        </button>
                                    </c:if>
                                    <c:if test="${sessionScope.acc.rollId == 0}" >
                                        <button type="submit" class="btn btn-primary btn-icon-text" >
                                            <i class="ti-file btn-icon-prepend"></i>
                                            Save
                                        </button>
                                    </c:if>
                                    <span class="ad">
                                        <a href="teamlist">
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
                </c:if>
            </div>
            <!--main -->
        </div>
        <!--content -->        

        <!--footer -->
        <%@include file="footer.jsp" %>
        <!--footer -->

    </body>
    <script type="text/javascript">

    </script>
</html>


