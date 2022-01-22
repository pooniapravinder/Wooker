<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%><%@taglib uri="http://www.springframework.org/tags" prefix="spring"%><%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Take a Tour at Activities</title>
    </head>
    <body><%@include file="header.jsp"%><br>
        <table>
            <tr><td>Activities are given to provide a better security to your account.</td></tr>
            <tr><td>Click on any activity to check recently performance.</td></tr>
            <tr><td></td></tr><tr><td></td></tr>
            <tr><td><a href="/activities/all/">All</a>&nbsp;<a href="/activities/login/">Login</a>&nbsp;<a href="/activities/inbox/">Inbox</a>&nbsp;<a href="/activities/requestsent/">Friend Request Sent</a>&nbsp;<a href="/activities/requestreceived/">Friend Request Received</a></td></tr>
        </table>
        <p>Something happening wrong with your account from anywhere.</p>
        <p><a href="/block/account/">Block my availability</a></p>
    </center>
    </body>
</html>
