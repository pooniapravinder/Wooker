<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%><%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%><%@page contentType="text/html" pageEncoding="UTF-8"%><%@page session="false"%><!DOCTYPE html>
<html lang="en-US" id="wooker">
    <head>
        <title>Forgot Password</title>
        <meta name="keywords" content="Forgot Password for Wooker">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="theme-color" content="#663399">
        <link rel="shortcut icon" href="//www.google.com/favicon.ico"/>
        <meta name="description" content="Recover your Forgotten Wooker Password">
        <meta name="google" content="notranslate">
    </head>
    <body>
        <center>
            <a href="?lang=hi">हिन्दी</a>&nbsp;<a href="?lang=en">English(United States)</a>
            <p><a href="/signup/"><spring:message code="login.label.createaccount"/></a></p>
            <h1><spring:message code="login.label.h1"/></h1>
            <form:form name="forgotpass" modelAttribute="forgotpass" method="post" action="">
                <form:label path="emailphone"><spring:message code="login.label.emailphone"/>:</form:label><br/>
                <form:input path="emailphone" id="emailphone" autocorrect="off" autocomplete="off" spellcheck="false"/><br/><br/>
                <form:button name="submit" id="submit" value="submit">Send Code</form:button>
            </form:form><br>
            <p><a href="/login/"><spring:message code="error.label.login"/></a></p>
            <p><a href="/signup/"><spring:message code="error.label.signup"/></a></p>
            <br/><br/><br/>
            <footer>Wooker &copy;${loginuser.year}</footer>
        </center>
    </body>
</html>
