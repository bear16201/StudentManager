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
        <title>Subject Details </title>
    </head>
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
                                                <h1 class=" Title">Subject Details</h1>
                                            </div>
                                        </div>   
                                        <form action="editsubject">
                                            <div class="table-responsive">
                                                <table class="table table-striped" >
                                                    <thead>
                                                        <tr>
                                                            <th><h4>Subject ID:</h4></th>
                                                            <th><span class="btn-md col-lg-9" >
                                                                    ${details.subject_id}                                         
                                                                </span>
                                                            </th>       
                                                        </tr>
                                                        <tr>
                                                            <th><h4>Subject Code:</h4></th>
                                                            <th><span class="btn-md col-lg-9" >
                                                                    ${details.subject_code}                           
                                                                </span>
                                                            </th>       
                                                        </tr>
                                                        <tr>
                                                            <th><h4>Subject Name:</h4></th>
                                                            <th><span class="btn-md col-lg-9" >
                                                                    ${details.subject_name}                     
                                                                </span>
                                                            </th>       
                                                        </tr>
                                                        <tr>
                                                            <th><h4>Subject Author:</h4></th>
                                                            <th><span class="btn-md col-lg-9" >
                                                                    ${details.subject_author}                                                   
                                                                </span>
                                                            </th>       
                                                        </tr>
                                                        <c:if test="${details.subject_status.equals('1')}">
                                                            <tr>
                                                                <th><h4>Subject Status:</h4></th>
                                                                <th><span class="btn-md col-lg-9" >
                                                                        Active
                                                                    </span>
                                                                </th>       
                                                            </tr>
                                                        </c:if>
                                                        <c:if test="${details.subject_status.equals('0')}">
                                                            <tr>
                                                                <th><h4>Subject Status:</h4></th>
                                                                <th><span class="btn-md col-lg-9" >                                                               
                                                                        Inactive
                                                                    </span>
                                                                </th>       
                                                            </tr>
                                                        </c:if>
                                                        </tbody>
                                                </table>
                                                <div style="text-align: center; padding: 20px;">       
                                                    <span>
                                                        <a href="loadsubjectedit?id=${details.getSubject_id()}"><button class="btn btn-danger btn-rounded btn-fw  text-white mb-0 me-0" style = "height: 45px"type="button">
                                                                Edit
                                                            </button>
                                                        </a>
                                                    </span>
                                                    <span class="ad">
                                                        <a href="subjectcontroller"><button class="btn btn-danger btn-rounded btn-fw  text-white mb-0 me-0" style = "height: 45px"type="button">
                                                                Back to Setting List
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

