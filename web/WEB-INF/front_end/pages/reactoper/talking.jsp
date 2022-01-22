<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@taglib uri="http://www.springframework.org/tags" prefix="spring"%><%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%><%@page contentType="text/html" pageEncoding="UTF-8"%><%@page session="false"%><!DOCTYPE html>
<html lang="en-US" id="wooker">
    <head><c:set var="requestURI" value="${requestScope['javax.servlet.forward.request_uri']}"/><c:choose><c:when test="${requestURI.contains('accpic')}"><c:set var="requestPage" value="accpic"/></c:when><c:when test="${requestURI.contains('post')}"><c:set var="requestPage" value="post"/></c:when></c:choose>
                <meta name="keywords" content="Talking Panel at Wooker">
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
                <meta name="theme-color" content="#663399">
                <link rel="shortcut icon" href="//www.google.com/favicon.ico"/>
                <meta name="description" content="Talking Panel at Wooker">
                <meta name="google" content="notranslate">
                <title>Talking Panel</title>
                <link rel="stylesheet" type="text/css" href="/rele/css/styleone.css">
                <link rel="stylesheet" type="text/css" href="/rele/css/styletwo.css">
                <link rel="stylesheet" type="text/css" href="/rele/css/yUiGsjoPsmLspD.css">
            </head>
            <body>
            <%@include file="../header.jsp"%>
                <div class="wrapper animate_in" id="wrapper">
            <jsp:useBean id="CalTime" class="timeperiod.duration.calculation.CalculateTime"/>
            <c:set var="page" value="${param.page.matches('^(?:[0-9]){1,11}$') ? param.page : 0}"/>
            <c:if test="${requestURI.contains('accpic')}">
                <c:set var="accpicoper" value="${getImage.AccountImg(crypto.decrypt(param.sqq))}"/>
                <c:set var="editUrl" value="/account/pic/edit/"/>
            </c:if>
            <jsp:useBean id="privacyChecker" class="pages.controller.reactoper.ReactOperValidate"/>
            <c:set var="talkerInfo" value="${getUserData.getPriInfo(accpicoper.userId)}"/>
            <c:set var="talkerUser" value="${crypto.encrypt(talkerInfo.getUserId())}"/>
            <c:set var="talkerPicSQQ" value="${crypto.encrypt(getImage.getAccountPic(accpicoper.userId).getPicId())}"/>
            <div class="info_page main clearfix" id="web_view">
                <div class="content">
                <div class="ghjjk_fh">
                    <div class="vbngf">
                        <div class="fghrtt _frgd">
                            <a href="/info/<c:if test="${talkerInfo.getUserId()!=user}">?sqq=${crypto.encodeURL(talkerUser)}</c:if>">
                                <c:choose>
                                    <c:when test="${talkerPicSQQ!=null}">
                                        <div class="fhytt">
                                            <img src="/account/pic/show/a1/?sqq=${crypto.encodeURL(talkerPicSQQ)}" alt="img">
                                        </div>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="fhytt">
                                            <img src="/account/pic/show/user/default/a1/">
                                        </div>
                                    </c:otherwise>
                                </c:choose>
                            </a>
                        </div>
                    </div>
                    <div class="ghgff_gg">
                        <c:choose>
                            <c:when test="${user!=talkerInfo.getUserId()}">
                                <a href="/user/chat/?sqq=${crypto.encodeURL(talkerUser)}">${talkerInfo.firstName} ${talkerInfo.lastName}</a>
                            </c:when><c:otherwise>
                                <div class="gr_ds_dssd">
                                    ${talkerInfo.firstName} ${talkerInfo.lastName}
                                </div></c:otherwise>
                        </c:choose>
                        <div class="yul_sad">
                            <c:if test="${talkerInfo.getUserId().equals(user)}">
                                <a href="${editUrl}?sqq=${(crypto.encodeURL(param.sqq))}&amp;refer=${param.refer}">Edit</a>
                            </c:if>

                            <a href="/talking/setings/">Settings</a></div></div>
                </div>

                <c:if test="${accpicoper!=null}">
                    <div class="__yttr"><div class="fertes ty_ull">
                            <a href="/account/pic/full/size/?sqq=${crypto.encodeURL(param.sqq)}">
                                <div class="gdd_gg">
                                    <img src="/account/pic/show/a4/?sqq=${crypto.encodeURL(param.sqq)}" alt="img">
                                </div>
                            </a>
                        </div>
                    </div>
                </c:if>

                <%@include file="portions/showdata/common.jsp"%>
                <%@include file="portions/showdata/talking.jsp"%>
                <%@include file="portions/form/talking.jsp"%>
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