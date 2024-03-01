<%-- 
    Document   : dashboard
    Created on : May 31, 2022, 3:48:05 PM
    Author     : My PC
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Dashboard</title>
    </head>
    <body>
        <div class="container-scroller">
            <%@include file="header.jsp" %>
            <!--footer -->
            <c:if test="${sessionScope.acc == null}">
                <div class="d-sm-flex justify-content-between align-items-start">
                    <div>
                        <h1 class="text-danger">You need login</h1>
                    </div>                          
                </div>
            </c:if>
            <!-- footer -->
        </div>
        <%@include file="footer.jsp" %>
    </body>

</html>


