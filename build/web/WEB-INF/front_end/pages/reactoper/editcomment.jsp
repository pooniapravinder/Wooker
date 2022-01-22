<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@taglib uri="http://www.springframework.org/tags" prefix="spring"%><%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%><%@page contentType="text/html" pageEncoding="UTF-8"%><%@page session="false"%><!DOCTYPE html>
<html lang="en-US" id="wooker">
    <head><c:set var="requestURI" value="${requestScope['javax.servlet.forward.request_uri']}"/>
        <meta name="keywords" content="Edit Comment at Wooker">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
        <meta name="theme-color" content="#663399">
        <link rel="shortcut icon" href="//www.google.com/favicon.ico"/>
        <meta name="description" content="Edit Comment at Wooker">
        <meta name="google" content="notranslate">
        <title>Edit Comment</title>
        <link rel="stylesheet" type="text/css" href="/rele/css/styleone.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/styletwo.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/yUiGsjoPsmLspD.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/IoDJnmdJdDE.css">
    </head>
    <body>
            <%@include file="../header.jsp"%>
        <div class="wrapper animate_in" id="wrapper">
            <c:set var="page" value="${param.page.matches('^(?:[0-9]){1,11}$') ? param.page : 0}"/>
            <c:set var="prepage" value="${param.prepage.matches('^(?:[0-9]){1,11}$') ? param.prepage : 0}"/>
            <jsp:useBean id="getURL" class="pages.controller.reactoper.ReactOperValidate"/>
            <jsp:useBean id="ReactData" class="hibernate.query.reactoper.ReactOper"/>
            <div class="info_page main clearfix" id="web_view">
            <div class="content">
                <jsp:useBean id="blockedUser" class="hibernate.query.BlockDisable"/>
                <c:set var="userSqq" value="${ReactData.getCommentByOperId(crypto.decrypt(param.sqq))}"/>
                <c:set var="talkPicSQQ" value="${crypto.encrypt(userSqq.targetId)}"/>

                <div class="gu_edd">
                    <div class="ter__rt">
                        <a href="/${getURL.getURL(0,param.refer, param.prerefer, param.sqq, page, prepage)}" class="jwek__lki"></a><span class="rrytryf">Go back</span>
                    </div>
                </div>

                <div class="ylm__p"></div>

                <%@include file="portions/showdata/editcommenttop.jsp"%>
                <div class="ttt_p"></div>
                <div class="yl__p"></div>

                <c:set var="comments" value="${ReactData.getEditedComment(userSqq.operId,page)}"/>
                <c:if test="${comments.isEmpty()}">
                    <div class="dfsdf_fgfg">
                        No edited yet
                    </div>
                </c:if>

                <%@include file="portions/showdata/editcomment.jsp"%>
                <c:if test="${(((userSqq.userOne==user)&&(!userSqq.selfUser))||((userSqq.userTwo==user)&&(userSqq.selfUser)))&&(!isDisabled)}">
                    <%@include file="portions/form/editcomment.jsp"%>
                </c:if>
                <c:if test="${isDisabled}">
                    <div class="htul tty_da_das">
                    <span class="fght_fgd">You must enable comment first on previous page</span>
                    </div>
                </c:if>

            </div>
            </div>
        </div>
        <script>

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