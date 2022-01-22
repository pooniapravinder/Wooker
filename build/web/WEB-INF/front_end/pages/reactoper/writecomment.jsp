<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@taglib uri="http://www.springframework.org/tags" prefix="spring"%><%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%><%@page contentType="text/html" pageEncoding="UTF-8"%><%@page session="false"%><!DOCTYPE html>
<html lang="en-US" id="wooker">
    <head><c:set var="requestURI" value="${requestScope['javax.servlet.forward.request_uri']}"/><c:choose><c:when test="${requestURI.contains('accpic')}"><c:set var="requestPage" value="accpic"/></c:when><c:when test="${requestURI.contains('post')}"><c:set var="requestPage" value="post"/></c:when></c:choose>
                <meta name="keywords" content="Write Comment Panel at Wooker">
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
                <meta name="theme-color" content="#663399">
                <link rel="shortcut icon" href="//www.google.com/favicon.ico"/>
                <meta name="description" content="Write Comment Panel at Wooker">
                <meta name="google" content="notranslate">
                <title>Write Comment Panel</title>
                <link rel="stylesheet" type="text/css" href="/rele/css/styleone.css">
                <link rel="stylesheet" type="text/css" href="/rele/css/styletwo.css">
                <link rel="stylesheet" type="text/css" href="/rele/css/yUiGsjoPsmLspD.css">
            </head>
            <body>
            <%@include file="../header.jsp"%>
                <div class="wrapper animate_in" id="wrapper">
            <jsp:useBean id="CalTime" class="timeperiod.duration.calculation.CalculateTime"/>
            <c:set var="page" value="${param.page.matches('^(?:[0-9]){1,11}$') ? param.page : 0}"/>
            <c:set var="prepage" value="${param.prepage.matches('^(?:[0-9]){1,11}$') ? param.prepage : 0}"/>
            <jsp:useBean id="ReactData" class="hibernate.query.reactoper.ReactOper"/>
            <jsp:useBean id="blockedDisable" class="hibernate.query.BlockDisable"/>
            <jsp:useBean id="privacyChecker" class="pages.controller.reactoper.ReactOperValidate"/>
            <jsp:useBean id="getURL" class="pages.controller.reactoper.ReactOperValidate"/>
            <c:set var="targetId" value="${crypto.decrypt(param.sqq)}"/>
            <c:set var="userOne" value="${crypto.decrypt(param.user)}"/>
            <c:set var="accpicoper" value="${getImage.AccountImg(targetId)}"/>
            <c:set var="talkerInfo" value="${getUserData.getPriInfo(userOne)}"/>
            <c:set var="talkerUser" value="${crypto.encrypt(talkerInfo.getUserId())}"/>
            <c:set var="talkerPicSQQ" value="${crypto.encrypt(getImage.getAccountPic(accpicoper.userId).getPicId())}"/>
            <div class="info_page main clearfix" id="web_view">
                <div class="content">
                <div class="gu_edd">
                    <div class="ter__rt">
                        <a href="/${getURL.getURL(0,param.refer, param.prerefer, param.sqq, page, prepage)}" class="jwek__lki"></a><span class="rrytryf">Go back</span>
                    </div>

                </div>

                <div class="dfs_dd">Write on ${talkerInfo.firstName} ${talkerInfo.lastName}'s comment</div>
                <%@include file="portions/showdata/writecomment.jsp"%>
                <%@include file="portions/form/writecomment.jsp"%>
            </div>
            </div>
        </div>
        <script>
            _g("hfgh_hfhf").addEventListener("focus", function () {
                _g("hfgh_hfhf").removeAttribute("placeholder");
            });

            _g("attachment").style.display = "none";
            _g("_dsf_as").addEventListener("click", function () {
                _g("attachment").click();
            });

            function _g(a) {
                return window.document.getElementById(a);
            }
        </script>
    </body>
</html>