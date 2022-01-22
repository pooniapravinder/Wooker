<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%><%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%><%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@taglib uri="http://www.springframework.org/tags" prefix="spring"%><%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%><%@page contentType="text/html" pageEncoding="UTF-8"%><%@page session="false"%><!DOCTYPE html>
<html lang="en-US" id="wooker"><c:set var="requestURI" value="${requestScope['javax.servlet.forward.request_uri']}"/>
    <head>
        <meta name="keywords" content="Chatlist at Wooker">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
        <meta name="theme-color" content="#663399">
        <link rel="shortcut icon" href="http://www.google.com/favicon.ico">
        <meta name="description" content="Chatlist at Wooker">
        <meta name="google" content="notranslate">
        <title><c:choose><c:when test="${requestURI.contains('blocked')}">Blocked</c:when><c:when test="${requestURI.contains('removed')}">Removed</c:when></c:choose></title>
                <link rel="stylesheet" type="text/css" href="/rele/css/styleone.css">
                <link rel="stylesheet" type="text/css" href="/rele/css/styletwo.css">
                <link rel="stylesheet" type="text/css" href="/rele/css/stylethree.css">
                <link rel="stylesheet" type="text/css" href="/rele/css/kPdlNdmRovNRj.css">
            </head>
            <body>
            <%@include file="header.jsp"%>
                <div class="wrapper animate_in" id="wrapper">
            <jsp:useBean id="getUserList" class="hibernate.query.chat.UserRelationActions"/>
            <c:choose>
                <c:when test="${(crypto.decrypt(param.pagination_backward))!=null}">
                    <c:set var="pagination_backward" value="${crypto.decrypt(param.pagination_backward)}"/>
                    <c:set var="getList" value="${getUserList.getUserlist(false, requestURI.contains('removed'), user, pagination_backward,false)}"/>                    
                </c:when>
                <c:when test="${(crypto.decrypt(param.pagination_forward))!=null}">
                    <c:set var="pagination_forward" value="${crypto.decrypt(param.pagination_forward)}"/>
                    <c:set var="getList" value="${getUserList.getUserlist(false, requestURI.contains('removed'), user, pagination_forward,true)}"/>
                </c:when>
                <c:otherwise>
                    <c:set var="getList" value="${getUserList.getfirstUserlist(false, requestURI.contains('removed'), user)}"/>
                </c:otherwise>
            </c:choose>
            <c:set var="countUsers" value="${getUserList.countUserlist(false, requestURI.contains('removed'), user)}"/>
            <div class="info_page main clearfix" id="web_view">
                <div class="content">
                <c:choose><c:when test="${requestURI.contains('removed')}"><c:set var="pageOpt" value="Removed List"/></c:when><c:when test="${requestURI.contains('blocked')}"><c:set var="pageOpt" value="Blocked List"/></c:when></c:choose>
                <h2>Manage your ${pageOpt}</h2>
                <form:form name="searchuserlist" modelAttribute="searchuserlist" method="post" action="/search/user/list/">
                    <div class="form-element-search">
                        <form:input path="searchQuery" id="searchQuery" class="custom_search_box" title="Search for User" autocorrect="off" autocomplete="off" spellcheck="false" required="true"/>
                        <form:label path="searchQuery">Search for User</form:label>
                            <span class="focus-border"></span>
                        <form:button name="search" class="button-holder" value="submit">Search</form:button>
                        </div>
                </form:form>
                <div class="upp_ss_elem gg_ss">
                    <div class="options_position"><a href="/user/list/chat/">Chatlist</a></div><div class="options_position"><a href="/user/list/removed/">Removed</a></div><div class="options_position"><a href="/user/list/blocked/">Blocked</a></div>
                </div>

                <div class="gg_ss ggj_fd">
                    <c:choose>
                        <c:when test="${countUsers==1}">1 user is in your ${pageOpt}</c:when>
                        <c:when test="${countUsers>1}">${countUsers} users are in your ${pageOpt}</c:when>
                    </c:choose>
                </div>
                <div class="gty_yt"></div>
                <div class="dgfdg_dfs" id="<c:if test='${pagination_forward!=null}'>__sda</c:if>">
                    <c:set var="totalData" value="${fn:length(getList)}"/>
                    <c:forEach var="i" begin="${pagination_forward!=null ? 1 : (totalData==0 ? 1 : 0)}" end="${pagination_forward!=null ? totalData : (totalData>0 ? totalData-1 : totalData)}" step="1">
                        <c:set var="data" value="${pagination_forward!=null ? getList[totalData-i] : getList[i]}"/>
                        <c:set var="otherUserData" value="${getUserData.getPriInfo(data.userOne==user ? data.userTwo : data.userOne)}"/>
                        <c:set var="otherUser" value="${crypto.encrypt(otherUserData.getUserId())}"/>
                        <c:set var="picSQQ" value="${crypto.encrypt(getImage.getAccountPic(otherUserData.getUserId()).getPicId())}"/>
                        <c:if test="${i==(pagination_forward!=null ? 1 : 0)}"><c:set var="firstMsgId" value="${data.autoId}"/></c:if>
                        <c:if test="${i==(pagination_forward!=null ? totalData : totalData-1)}"><c:set var="lastMsgId" value="${data.autoId}"/></c:if>
                        <c:if test="${i==(pagination_forward!=null ? 1 : 0)}">
                            <c:if test="${getUserList.isPagination(false, requestURI.contains('removed'),user,firstMsgId,true)}"><div class="def__o"><a href="${requestURI}?pagination_forward=${crypto.encodeURL(crypto.encrypt(firstMsgId))}">Newer</a></div></c:if>
                        </c:if>
                        <c:set var="chatId" value="${crypto.encrypt(datas.autoId)}"/>
                        <div class="weff__v">
                            <div class="sgj_s">
                                <div class="img__fgd cvb_fd">
                                    <c:choose>
                                        <c:when test="${picSQQ!=null}">
                                            <a href="/info/?sqq=${crypto.encodeURL(otherUser)}">
                                                <div class="fgh">
                                                    <img src="/account/pic/show/a1/?sqq=${crypto.encodeURL(picSQQ)}">
                                                </div>
                                            </a>
                                        </c:when>
                                        <c:otherwise>
                                            <a href="/info/?sqq=${crypto.encodeURL(otherUser)}">
                                                <div class="fgh">
                                                    <img src="/account/pic/show/user/default/a1/">
                                                </div>
                                            </a>
                                        </c:otherwise>
                                    </c:choose>
                                </div></div>
                            <div class="bfc_gf">
                                <div class="cbnv fdg_fgfd">
                                    <a href="/user/send/message/?sqq=${crypto.encodeURL(chatId)}">${otherUserData.firstName} ${otherUserData.lastName}</a>
                                    <div class="fd_ddss">
                                        <c:choose>
                                            <c:when test="${requestURI.contains('removed')}">
                                                <div class="ghj_hg"><a href="/user/action/block/?sqq=${crypto.encodeURL(chatId)}<c:if test='${pagination_backward!=null}'>&amp;pagination_backward=${crypto.encodeURL(param.pagination_backward)}</c:if><c:if test='${pagination_forward!=null}'>&amp;pagination_forward=${crypto.encodeURL(param.pagination_forward)}</c:if>&amp;refer=mmGeOlkf-Fnrf_t">Block</a></div>
                                                <div class="ghj_hg"><a href="/user/wooks/?sqq=${crypto.encodeURL(otherUser)}">Wooks</a></div>
                                            </c:when>
                                            <c:when test="${requestURI.contains('blocked')}">
                                                <div class="ghj_hg"><a href="/user/action/unblock/?sqq=${crypto.encodeURL(chatId)}<c:if test='${pagination_backward!=null}'>&amp;pagination_backward=${crypto.encodeURL(param.pagination_backward)}</c:if><c:if test='${pagination_forward!=null}'>&amp;pagination_forward=${crypto.encodeURL(param.pagination_forward)}</c:if>&amp;refer=oyNdkT-Nr_kqpFk">Unblock</a></div>
                                            </c:when>
                                        </c:choose>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                    <c:if test="${getUserList.isPagination(false, requestURI.contains('removed'),user,lastMsgId,false)}"><div class="def__o"><a href="${requestURI}?pagination_backward=${crypto.encodeURL(crypto.encrypt(lastMsgId))}">Older</a></div></c:if>
                </div>
            </div>
            </div>
        </div>
        <script>
            if (null !== window.document.getElementById("__sda"))
                window.scrollTo(0, document.body.scrollHeight);
        </script>
    </body>
</html>