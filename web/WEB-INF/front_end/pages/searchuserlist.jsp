<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%><%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%><%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@taglib uri="http://www.springframework.org/tags" prefix="spring"%><%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%><%@page contentType="text/html" pageEncoding="UTF-8"%><%@page session="false"%><!DOCTYPE html>
<html lang="en-US" id="wooker"><c:set var="requestURI" value="${requestScope['javax.servlet.forward.request_uri']}"/>
    <head>
        <meta name="keywords" content="Search Chatlist, Block list, Removed list at Wooker">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
        <meta name="theme-color" content="#663399">
        <link rel="shortcut icon" href="http://www.google.com/favicon.ico">
        <meta name="description" content="Search Chatlist, Block list, Removed list at Wooker">
        <meta name="google" content="notranslate">
        <title><c:out value="${query}"/></title>
        <link rel="stylesheet" type="text/css" href="/rele/css/styleone.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/styletwo.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/stylethree.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/kPdlNdmRovNRj.css">
    </head>
    <body>
            <%@include file="header.jsp"%>
        <div class="wrapper animate_in" id="wrapper">
            <jsp:useBean id="getUserList" class="hibernate.query.chat.SearchUserList"/>
            <c:set var="getList" value="${getUserList.getSearchList(user,query)}"/>
            <div class="info_page main clearfix" id="web_view">
            <div class="content">
                <div style="display:block;padding-top:20px;">
                    <form:form name="searchuserlist" modelAttribute="searchuserlist" method="post" action="/search/user/list/">
                        <div class="form-element-search">
                            <form:input path="searchQuery" id="searchQuery" class="custom_search_box" title="Search for User" autocorrect="off" autocomplete="off" spellcheck="false" required="true"/>
                            <form:label path="searchQuery">Search for User</form:label>
                                <span class="focus-border"></span>
                            <form:button name="search" class="button-holder" value="submit">Search</form:button>
                            </div>
                    </form:form>
                </div>
                <div class="upp_ss_elem gg_ss">
                    <div class="options_position"><a href="/user/list/chat/">Chatlist</a></div><div class="options_position"><a href="/user/list/removed/">Removed</a></div><div class="options_position"><a href="/user/list/blocked/">Blocked</a></div>
                </div>
                <div class="gty_yt"></div>
                <div class="dgfdg_dfs">
                    <c:forEach items="${getList}" var="data">
                        <c:forEach items="${data}" var="datas">
                            <c:choose>
                                <c:when test="${datas.getClass().name=='hibernate.mapping.Online'}">
                                    <c:set var="onlineSec" value="${((now.time)-(datas.timestampVal))/1000}"/>
                                </c:when>
                                <c:when test="${datas.getClass().name=='hibernate.mapping.Primaryinfo'}">
                                    <c:set var="otherUserName" value="${datas.firstName} ${datas.lastName}"/>
                                    <c:set var="otherUser" value="${crypto.encrypt(datas.userId)}"/>
                                    <c:set var="picSQQ" value="${crypto.encrypt(getImage.getAccountPic(datas.userId).getPicId())}"/>
                                </c:when>
                                <c:when test="${datas.getClass().name=='hibernate.mapping.Userchatlist'}">
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
                                                <div class="gthy">
                                                    <a href="/user/send/message/?sqq=${crypto.encodeURL(chatId)}">${otherUserName}</a>
                                                    <c:if test="${(datas.friend)&&(onlineSec<50)}">
                                                        <div class="online_user">
                                                            <span></span><span></span><span></span>
                                                        </div>
                                                    </c:if>
                                                    <div style="display:block;font-size:11px;color:rgba(0,0,0,0.6);padding-top:3px;">
                                                        <div style="display:inline-block;background-color:#663399;margin-right:4px;height:5px;width:5px;border-radius:50%;"></div>
                                                        <c:choose>
                                                            <c:when test="${datas.friend}">Chatlist</c:when>
                                                            <c:when test="${datas.removed}">Removed</c:when>
                                                            <c:when test="${datas.blocked}">Blocked</c:when>
                                                        </c:choose>
                                                    </div>
                                                </div>
                                                <c:choose>
                                                    <c:when test="${datas.friend}">
                                                        <div class="fd_ddss">
                                                            <div class="ghj_hg"><a href="/user/action/remove/?sqq=${crypto.encodeURL(chatId)}&amp;refer=mmGeOlkf-Fnrf_t">Remove</a></div>
                                                            <div class="ghj_hg"><a href="/user/action/block/?sqq=${crypto.encodeURL(chatId)}&amp;refer=oyNdkT-Nr_kqpFk">Block</a></div>
                                                            <div class="ghj_hg"><a href="/user/wooks/?sqq=${crypto.encodeURL(otherUser)}">Wooks</a></div>
                                                        </div>
                                                    </c:when>
                                                    <c:when test="${datas.removed}">
                                                        <div class="fd_ddss">
                                                            <div class="ghj_hg"><a href="/user/action/block/?sqq=${crypto.encodeURL(chatId)}&amp;refer=oyNdkT-Nr_kqpFk">Block</a></div>
                                                            <div class="ghj_hg"><a href="/user/wooks/?sqq=${crypto.encodeURL(otherUser)}">Wooks</a></div>
                                                        </div>
                                                    </c:when>
                                                    <c:when test="${datas.blocked}">
                                                        <div class="fd_ddss">
                                                            <div class="ghj_hg"><a href="/user/action/unblock/?sqq=${crypto.encodeURL(chatId)}&amp;refer=oyNdkT-Nr_kqpFk">Unblock</a></div>
                                                        </div>
                                                    </c:when>
                                                </c:choose>
                                            </div>
                                        </div>
                                    </div>
                                </c:when>
                            </c:choose>
                        </c:forEach>
                    </c:forEach>
                    <c:if test="${getList.isEmpty()}">
                        <div style="display:block;text-align:center;padding-bottom:10px;">No user found for '<c:out value="${query}"/>'</div>
                    </c:if>
                </div>
            </div>
            </div>
        </div>
    </body>
</html>