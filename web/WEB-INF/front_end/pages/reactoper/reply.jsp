<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@taglib uri="http://www.springframework.org/tags" prefix="spring"%><%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%><%@page contentType="text/html" pageEncoding="UTF-8"%><%@page session="false"%><!DOCTYPE html>
<html lang="en-US" id="wooker">
    <head><c:set var="requestURI" value="${requestScope['javax.servlet.forward.request_uri']}"/>
        <meta name="keywords" content="Reply Panel at Wooker">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
        <meta name="theme-color" content="#663399">
        <link rel="shortcut icon" href="//www.google.com/favicon.ico"/>
        <meta name="description" content="Reply Panel at Wooker">
        <meta name="google" content="notranslate">
        <title>Reply Panel</title>
        <link rel="stylesheet" type="text/css" href="/rele/css/styleone.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/styletwo.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/yUiGsjoPsmLspD.css">
    </head>
    <body>
            <%@include file="../header.jsp"%>
        <div class="wrapper animate_in" id="wrapper">
            <div class="info_page main clearfix" id="web_view">
            <div class="content">
                
                <c:set var="page" value="${param.page.matches('^(?:[0-9]){1,11}$') ? param.page : 0}"/>
                <jsp:useBean id="ReactData" class="hibernate.query.reactoper.ReactOper"/>
                <c:set var="userSqq" value="${ReactData.getTalkingByOperId(crypto.decrypt(param.sqq))}"/>
                <c:set var="talkPicSQQ" value="${crypto.encrypt(userSqq.targetId)}"/>
                <c:choose>
                    <c:when test="${param.prerefer.equals('oUej-Ge7H7_ByLk')}">
                        <c:set var="prePage" value="accpic"/>
                    </c:when>
                    <c:otherwise>
                        <c:set var="prePage" value="post"/>
                    </c:otherwise>
                </c:choose>
                <div class="gu_edd">
                    <div class="ter__rt">
                        <a href="/${prePage}/user/oper/talking/?sqq=${crypto.encodeURL(talkPicSQQ)}&amp;refer=${crypto.encodeURL(param.prerefer)}" class="jwek__lki"></a><span class="rrytryf">Go back to talking</span>
                    </div>
                </div>
                <div class="ylm__p"></div>
                <%@include file="portions/showdata/replytop.jsp"%>
                <div class="ttt_p"></div>
                <div class="yl__p"></div>
                <%@include file="portions/showdata/reply.jsp"%>
                <c:if test="${talkings.isEmpty()}">
                    <div class="dfsdf_fgfg">
                        No replies yet
                    </div>
                </c:if>
                <%@include file="portions/form/reply.jsp"%>
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