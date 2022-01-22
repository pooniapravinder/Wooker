<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%><%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%><%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title><spring:message code="error.label.title"/></title>
    </head>
    <body>
    <center>
        <h1><spring:message code="error.label.h1"/></h1>
        <h2><spring:message code="error.label.h2"/></h2>
        <p><a href="/login/"><spring:message code="error.label.login"/></a></p>
        <p><a href="/signup/"><spring:message code="error.label.signup"/></a></p>
    </center>
</body>
</html>
