<%-- 
    Document   : logOut
    Created on : Jun 2, 2022, 1:57:44 PM
    Author     : My PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    session.invalidate();
    response.sendRedirect("home");
%>

