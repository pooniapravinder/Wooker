<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@taglib uri="http://www.springframework.org/tags" prefix="spring"%><%@page contentType="text/html" pageEncoding="UTF-8"%><%@page session="false"%><!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Error ${error}</title>
    </head>
    <body>
    <center><br>
        <h1>Error ${error}</h1>
        <c:if test="${error==404}">
        <%if(request.getAttribute("javax.servlet.forward.query_string")!=null){%>
        <h2>The requested URL <%out.print(request.getAttribute("javax.servlet.forward.request_uri")+"?"+request.getAttribute("javax.servlet.forward.query_string"));%> was not found on this server.</h2>
        <%}else{%>
        <h2>The requested URL <%out.print(request.getAttribute("javax.servlet.forward.request_uri"));%> was not found on this server.</h2>
        <%}%>
        </c:if>
        <c:if test="${error==500}">
        <h2>Service is currently unavailable</h2>
        <p>We are working on it.</p>
        </c:if>
        <p>That's all we know.</p><br/>
        <p><a href="/login/"><spring:message code="error.label.login"/></a></p>
        <p><a href="/signup/"><spring:message code="error.label.signup"/></a></p>
        <p>All rights reserved</p>
    </center>
</body>
</html>
