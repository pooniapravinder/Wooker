<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@taglib uri="http://www.springframework.org/tags" prefix="spring"%><%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%><%@page contentType="text/html" pageEncoding="UTF-8"%><%@page session="false"%><!DOCTYPE html>
<html lang="en-US" id="wooker">
    <head><c:set var="requestURI" value="${requestScope['javax.servlet.forward.request_uri']}"/><c:choose><c:when test="${requestURI.contains('accpic')}"><c:set var="requestPage" value="accpic"/></c:when><c:when test="${requestURI.contains('post')}"><c:set var="requestPage" value="post"/></c:when></c:choose>
                <meta name="keywords" content="Reactions being performed by">
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
                <meta name="theme-color" content="#663399">
                <link rel="shortcut icon" href="//www.google.com/favicon.ico"/>
                <meta name="description" content="Reactions being performed by">
                <meta name="google" content="notranslate">
                <title>Reactions being performed by</title>
                <link rel="stylesheet" type="text/css" href="/rele/css/styleone.css">
                <link rel="stylesheet" type="text/css" href="/rele/css/styletwo.css">
                <link rel="stylesheet" type="text/css" href="/rele/css/yUiGsjoPsmLspD.css">
            </head>
            <body>
            <%@include file="../header.jsp"%>
                <div class="wrapper animate_in" id="wrapper">
            <c:set var="page" value="${param.page.matches('^(?:[0-9]){1,11}$') ? param.page : 0}"/>
            <c:set var="prepage" value="${param.prepage.matches('^(?:[0-9]){1,11}$') ? param.prepage : 0}"/>
            <jsp:useBean id="getURL" class="pages.controller.reactoper.ReactOperValidate"/>
            <jsp:useBean id="ReactData" class="hibernate.query.reactoper.ReactOper"/>
            <c:choose>
                <c:when test="${requestURI.contains('disliked')}"><c:set var="countData" value="${ReactData.countLikesDislikes(false,crypto.decrypt(param.sqq))}"/><c:set var="userData" value="${ReactData.getLikesDislikes(false,user,crypto.decrypt(param.sqq),page)}"/><c:set var="totalPage" value="${ReactData.couLiDislikeTotPage(false,user,crypto.decrypt(param.sqq))}"/></c:when>
                <c:when test="${requestURI.contains('liked')}"><c:set var="countData" value="${ReactData.countLikesDislikes(true,crypto.decrypt(param.sqq))}"/><c:set var="userData" value="${ReactData.getLikesDislikes(true,user,crypto.decrypt(param.sqq),page)}"/><c:set var="totalPage" value="${ReactData.couLiDislikeTotPage(true,user,crypto.decrypt(param.sqq))}"/></c:when>
                <c:when test="${requestURI.contains('talked')}"><c:set var="countData" value="${ReactData.countDisTalkings(crypto.decrypt(param.sqq))}"/><c:set var="userData" value="${ReactData.getDisTalkings(user,crypto.decrypt(param.sqq),page)}"/><c:set var="totalPage" value="${ReactData.getDisTalkTotalPage(user,crypto.decrypt(param.sqq))}"/></c:when>
                <c:when test="${requestURI.contains('commented')}"><c:set var="countData" value="${ReactData.countDisComments(crypto.decrypt(param.sqq))}"/><c:set var="userData" value="${ReactData.getDisComments(user,crypto.decrypt(param.sqq),page)}"/><c:set var="totalPage" value="${ReactData.getDisCommTotalPage(user,crypto.decrypt(param.sqq))}"/></c:when>
                <c:when test="${requestURI.contains('shared')}"></c:when>
            </c:choose>

            <div class="info_page main clearfix" id="web_view">
            <div class="content">
                <div class="gu_edd">
                    <div class="ter__rt">
                        <a href="/${getURL.getURL(0,param.refer, param.prerefer, param.sqq, page, prepage)}" class="jwek__lki"></a><span class="rrytryf">Go back</span>
                    </div>
                </div>

                    <div class="gfgr_sfs">
                <div class="uop_ppa">
                    <c:choose>
                        <c:when test="${(requestURI.contains('disliked'))&&(countData==1)}">
                            ${countData} People dislike this
                        </c:when>
                        <c:when test="${(requestURI.contains('liked'))&&(countData>1)}">
                            ${countData} People dislikes this
                        </c:when>
                        <c:when test="${(requestURI.contains('liked'))&&(countData==1)}">
                            ${countData} People like this
                        </c:when>
                        <c:when test="${(requestURI.contains('liked'))&&(countData>1)}">
                            ${countData} People likes this
                        </c:when>
                        <c:when test="${(requestURI.contains('talked'))&&(countData==1)}">
                            ${countData} People talks on this
                        </c:when>
                        <c:when test="${(requestURI.contains('talked'))&&(countData>1)}">
                            ${countData} People talked on this
                        </c:when>
                        <c:when test="${(requestURI.contains('commented'))&&(countData==1)}">
                            ${countData} People comments on this
                        </c:when>
                        <c:when test="${(requestURI.contains('commented'))&&(countData>1)}">
                            ${countData} People commented on this
                        </c:when>
                        <c:when test="${(requestURI.contains('shared'))}">
                            ${countData} People shared this
                        </c:when>
                    </c:choose>
                </div>

                <c:if test="${page>totalPage}"><c:redirect url = "${requestURI}?sqq=${crypto.encodeURL(param.sqq)}&refer=${crypto.encodeURL(param.refer)}&prerefer=${crypto.encodeURL(param.prerefer)}"/></c:if>
                <c:if test="${page>0 && page<=totalPage}"><div class="uop_ppa"><a href="${requestURI}?sqq=${crypto.encodeURL(param.sqq)}&amp;refer=${crypto.encodeURL(param.refer)}<c:if test='${((page-1)!=0)}'>&amp;page=${page-1}</c:if>">Newer Talkings</a></div></c:if>

                <c:forEach items="${userData}" var="data">
                    <c:set var="talkerInfo" value="${getUserData.getPriInfo(data)}"/>
                    <c:set var="talkerUser" value="${crypto.encrypt(talkerInfo.getUserId())}"/>
                    <c:set var="talkerPicSQQ" value="${crypto.encrypt(getImage.getAccountPic(talkerInfo.getUserId()).getPicId())}"/>
                    <div class="fdger_ghfdfd">
                        <div class="rtr_fdss">
                            <div class="qwcd nhy">
                                <a href="/info/<c:if test="${talkerInfo.getUserId()!=user}">?sqq=${crypto.encodeURL(talkerUser)}</c:if>">
                                    <c:choose>
                                        <c:when test="${talkerPicSQQ!=null}">
                                            <div class="wethj_gf">
                                                <img src="/account/pic/show/a1/?sqq=${crypto.encodeURL(talkerPicSQQ)}" alt="img">
                                            </div>
                                        </c:when>
                                        <c:otherwise>
                                            <div class="wethj_gf">
                                                <img src="/account/pic/show/user/default/a1/">
                                            </div>
                                        </c:otherwise>
                                    </c:choose>
                                </a>
                            </div>
                        </div>

                        <div class="_fgfd_bfdg">
                            <div class="uu_pp fffty">
                            <c:choose><c:when test="${data==user}"><div class="gr_ds_dssd">${talkerInfo.firstName} ${talkerInfo.lastName}</div></c:when><c:otherwise><a href="/user/chat/?sqq=${crypto.encodeURL(talkerUser)}">${talkerInfo.firstName} ${talkerInfo.lastName}</a></c:otherwise></c:choose>
                                <a href="/user/wooks/"><div class="gd_dfdss">Wooks</div></a>
                            </div>
                        </div>
                    </div>
                </c:forEach>

                <c:if test="${page<totalPage}"><div class="uop_ppa"><a href="${requestURI}?sqq=${crypto.encodeURL(param.sqq)}&amp;refer=${crypto.encodeURL(param.refer)}&amp;page=${page+1}">Older Talkings</a></div></c:if>
</div>
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