<%-- 
    Document   : SubjectAdd
    Created on : Jun 5, 2022, 2:14:20 AM
    Author     : My PC
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Subject Add </title>

    <body>
        <div class="container-scroller">
            <%@include file="header.jsp" %>         
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
                                                <h1 class=" Title">Subject Add</h1>
                                            </div>
                                        </div>   
                                        <form action="subjectadd">
                                            <div class="table-responsive">
                                                <table class="table table-striped" >
                                                    <thead>
                                                        <tr>
                                                            <th><h4>Subject Code: <i style="color: red">*</i></h4></th>
                                                            <th><span class="btn-md col-lg-9" >
                                                                    <input type="text" class="btn btn-lg btn-rounded form-control" style="height: 60px; text-align: start;" 
                                                                           name="subject_code" 
                                                                           value="${code}"
                                                                           placeholder="input subject code" 
                                                                           required 
                                                                           pattern="[A-Za-z0-9]{3,8}"
                                                                           title="ID nhập vào cần trong khoảng từ 3 đến 8 ký tự chỉ sử dụng chữ và chữ số!"/>                                                   
                                                                </span>
                                                            </th>       
                                                        </tr>
                                                        <tr>
                                                            <th><h4>Subject Name:<i style="color: red">*</i></h4></th>
                                                            <th><span class="btn-md col-lg-9" >
                                                                    <input type="text" class="btn btn-lg btn-rounded form-control" style="height: 60px; text-align: start;" 
                                                                           name="subject_name"
                                                                           value="${name}"
                                                                           placeholder="input subject name"
                                                                           required 
                                                                           pattern="[a-zA-Z0-9\s]{3,100}"
                                                                           title="ID nhập vào cần trong khoảng từ 3 đến 100 ký tự chỉ sử dụng chữ và chữ số!"/>                                                  
                                                                </span>
                                                            </th>       
                                                        </tr>
                                                        <tr>
                                                            <th><h4>Subject Author:<i style="color: red">*</i></h4></th>
                                                            <th><span class="btn-md col-lg-9" >
                                                                    <input type="text" class="btn btn-lg btn-rounded form-control" style="height: 60px; text-align: start" 
                                                                           name="subject_author" value="${acc.userID}"required 
                                                                           pattern="[A-Za-z0-9]{3,8}"
                                                                           title="ID nhập vào cần trong khoảng từ 8 đến 10 ký tự chỉ sử dụng chữ và chữ số!"/>                                                     
                                                                </span>
                                                            </th>       
                                                        </tr>
                                                        <tr>
                                                            <th><h4>Subject Status:</h4></th>
                                                            <th><span class="btn-md col-lg-9" >
                                                                    <input type="radio" style="height: 60px;"  name="subject_status" value="1" checked="" /> Active    
                                                                    <input type="radio" style="height: 60px;" name="subject_status" value="0" /> Inactive     
                                                                </span>
                                                            </th>       
                                                        </tr>                                                    
                                                        </tbody>
                                                </table>
                                                <h4 style="color: green; text-align: center"> ${mess}</h4>                             
                                                <div style="text-align: center; padding: 20px;">       
                                                    <span>
                                                        <button type="submit" class="btn btn-warning btn-rounded btn-fw text-white mb-0 me-0" style = "height: 45px"type="button">
                                                            Add
                                                        </button>
                                                    </span>
                                                    <span class="ad">
                                                        <a href="subjectcontroller"><button class="btn btn-danger btn-rounded btn-fw  text-white mb-0 me-0" style = "height: 45px"type="button">
                                                                Back to Subject List
                                                            </button>
                                                        </a>
                                                    </span>
                                                </div>
                                            </div>
                                        </form>        
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:if>
            </div>
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>

