<%-- 
    Document   : SubjestList
    Created on : Jun 4, 2022, 4:38:56 AM
    Author     : My PC
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Subject Search </title>
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
                                                <h1 class=" Title">Subject List</h1>
                                            </div>
                                        </div>
                                        <div class="d-sm-flex justify-content align-items-start" style="justify-content: space-between">
                                            <div >
                                                <button class="btn btn-md btn-primary btn-rounded  text-white mb-0 me-0" type="button"  onclick="location.href = './subjectcontroller';" ><i mdi mdi-account-plus ></i> All</button>
                                            </div>
                                            <span class="dropdown">
                                                <button class="btn btn-primary btn-rounded  dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                                    All Status
                                                </button>
                                                <div class="dropdown-menu " aria-labelledby="dropdownMenuButton1">                                              
                                                    <a class="dropdown-item" href="sortsubject?action=sortbystatus1">Active</a>
                                                    <a class="dropdown-item" href="sortsubject?action=sortbystatus0">Inactive</a>

                                                </div>
                                            </span>
                                            <div >
                                                <button class="btn btn-md btn-primary btn-rounded  text-white mb-0 me-0" type="button"  onclick="location.href = './sortsubject?action=sortbyauthor';" ><i mdi mdi-account-plus ></i> Author</button>
                                            </div>                                           
                                            <form action="searchsubject" method="get" class="btn-md col-lg-6">
                                                <div class="se" style="float: left">
                                                    <span class="btn-md col-lg-6" >
                                                        <input type="text" style="width: 400px;" class="btn btn-lg btn-rounded form-control" name="txt" value="${search}" placeholder="Search subject by Name,Code"/>                                                    
                                                    </span>
                                                </div>
                                                <div class="se">
                                                    <button type="submit" class="btn btn-danger btn-rounded btn-fw">Search</button>
                                                </div>
                                            </form>
                                            <div >
                                                <button class="btn btn-md btn-primary btn-rounded  text-white mb-0 me-0" type="button"  onclick="location.href = './SubjectAdd.jsp';" ><i mdi mdi-account-plus ></i> Add New Subject</button>
                                            </div>
                                        </div>
                                        <div class="table-responsive">
                                            <table class="table table-striped" style="justify-content: space-around">
                                                <thead>
                                                    <tr>
                                                        <th><a href="sortsubject?action=sortbyid" style="text-decoration: none; font-size: 18px; color: black">ID <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-sort-up" viewBox="0 0 16 16">
                                                                <path d="M3.5 12.5a.5.5 0 0 1-1 0V3.707L1.354 4.854a.5.5 0 1 1-.708-.708l2-1.999.007-.007a.498.498 0 0 1 .7.006l2 2a.5.5 0 1 1-.707.708L3.5 3.707V12.5zm3.5-9a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7a.5.5 0 0 1-.5-.5zM7.5 6a.5.5 0 0 0 0 1h5a.5.5 0 0 0 0-1h-5zm0 3a.5.5 0 0 0 0 1h3a.5.5 0 0 0 0-1h-3zm0 3a.5.5 0 0 0 0 1h1a.5.5 0 0 0 0-1h-1z"/>
                                                                </svg></a></th>
                                                        <th><a href="sortsubject?action=sortbycode" style="text-decoration: none; font-size: 18px; color: black">Code <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-sort-up" viewBox="0 0 16 16">
                                                                <path d="M3.5 12.5a.5.5 0 0 1-1 0V3.707L1.354 4.854a.5.5 0 1 1-.708-.708l2-1.999.007-.007a.498.498 0 0 1 .7.006l2 2a.5.5 0 1 1-.707.708L3.5 3.707V12.5zm3.5-9a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7a.5.5 0 0 1-.5-.5zM7.5 6a.5.5 0 0 0 0 1h5a.5.5 0 0 0 0-1h-5zm0 3a.5.5 0 0 0 0 1h3a.5.5 0 0 0 0-1h-3zm0 3a.5.5 0 0 0 0 1h1a.5.5 0 0 0 0-1h-1z"/>
                                                                </svg></a></th>
                                                        <th><a href="sortsubject?action=sortbyname" style="text-decoration: none; font-size: 18px; color: black">Subject Name <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-sort-up" viewBox="0 0 16 16">
                                                                <path d="M3.5 12.5a.5.5 0 0 1-1 0V3.707L1.354 4.854a.5.5 0 1 1-.708-.708l2-1.999.007-.007a.498.498 0 0 1 .7.006l2 2a.5.5 0 1 1-.707.708L3.5 3.707V12.5zm3.5-9a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7a.5.5 0 0 1-.5-.5zM7.5 6a.5.5 0 0 0 0 1h5a.5.5 0 0 0 0-1h-5zm0 3a.5.5 0 0 0 0 1h3a.5.5 0 0 0 0-1h-3zm0 3a.5.5 0 0 0 0 1h1a.5.5 0 0 0 0-1h-1z"/>
                                                                </svg></a></th>
                                                        <th style="text-decoration: none; font-size: 18px">Author</th>
                                                        <th style="text-decoration: none; font-size: 18px">Status</th>
                                                        <th style="text-decoration: none; font-size: 18px">Action</th>
                                                    </tr>
                                                </thead>
                                                <c:forEach items="${list}" var="o">
                                                    <tr>
                                                        <td>${o.subject_id}</td>                            
                                                        <td>
                                                            <a href="loadsubject?id=${o.getSubject_id()}" style="text-decoration: none; font-size: 14px">${o.subject_code}</a>
                                                        </td>
                                                        <td style="width: 400px;">${o.subject_name}</td>
                                                        <td style="width: 250px;">${o.subject_author}</td>   
                                                        <td >                                        
                                                            <span>
                                                                <c:choose> 
                                                                    <c:when test="${o.subject_status.equals('1')}">
                                                                        <button id="showMess" class="btn btn-info btn-rounded btn-fw  text-white mb-0 me-0" type="button" style="width: 100px; text-align: center" onclick="location.href = './searchsubject?action=change&id=${o.getSubject_id()}'">
                                                                            Active
                                                                        </button>
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        <button id="showMess" class="btn btn-danger btn-rounded btn-fw  text-white mb-0 me-0"type="button" style="width: 100px; text-align: center" onclick="location.href = './searchsubject?action=change&id=${o.getSubject_id()}';">
                                                                            Inactive
                                                                        </button>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </span>                                                                                                                   
                                                        </td>  
                                                        <td>
                                                            <span>
                                                                <button class="btn btn-warning btn-rounded btn-fw text-white mb-0 me-0"type="button" style="width: 100px; text-align: center" onclick="location.href = 'loadsubjectedit?id=${o.getSubject_id()}'"> Edit</button>
                                                            </span>                                                                
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                                </tbody>
                                            </table>
                                            <nav aria-label="Page navigation example" class="d-flex justify-content-center" style="padding: 30px;">
                                                <ul class="pagination">
                                                    <c:forEach begin="1" end="${endP}" var="i">                                                   
                                                        <li class="page-item"><a class="page-link" href="subjectcontroller?index=${i}">${i}</a></li>
                                                        </c:forEach>
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
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>

