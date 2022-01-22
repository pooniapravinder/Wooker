<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%><%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%><%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@taglib uri="http://www.springframework.org/tags" prefix="spring"%><%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%><%@page contentType="text/html" pageEncoding="UTF-8"%><%@page session="false"%><!DOCTYPE html>
<html lang="en-US" id="wooker"><c:set var="requestURI" value="${requestScope['javax.servlet.forward.request_uri']}"/>
    <head>
        <meta name="keywords" content="Search Messages at Wooker">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
        <meta name="theme-color" content="#663399">
        <link rel="shortcut icon" href="http://www.google.com/favicon.ico">
        <meta name="description" content="Search Messages at Wooker">
        <meta name="google" content="notranslate">
        <title><c:out value="${query}"/></title>
        <link rel="stylesheet" type="text/css" href="/rele/css/styleone.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/styletwo.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/kuEopDjfRmEKf.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/YwoPFkdMRofF.css">
    </head>
    <body>
            <%@include file="../header.jsp"%>
        <div class="wrapper animate_in" id="wrapper">
            <jsp:useBean id="getMessages" class="hibernate.query.chat.SearchMessage"/>
            <jsp:useBean id="CalTime" class="timeperiod.duration.calculation.CalculateTime"/>
            <c:set var="messages" value="${getMessages.getSearchMessage(user,query)}"/>
            <div class="info_page main clearfix" id="web_view">
                <div class="content">
                <div class="search_msg_top">
                    <form:form name="searchmsg" modelAttribute="searchmsg" method="post" action="/search/message/">
                        <div class="form-element-search">
                            <form:input path="searchQuery" id="searchQuery" class="custom_search_box" title="Search for Messages" autocorrect="off" autocomplete="off" spellcheck="false" required="true"/>
                            <form:label path="searchQuery">Search for Messages</form:label>
                                <span class="focus-border"></span>
                            <form:button name="search" class="button-holder" value="submit">Search</form:button>
                            </div>
                    </form:form>
                </div>
                <div class="chat active-chat active">
                    <c:forEach items="${messages}" var="msgobj">
                        <c:forEach items="${msgobj}" var="datas">
                            <c:choose>
                                <c:when test="${datas.getClass().name=='hibernate.mapping.Online'}">
                                    <c:set var="onlineSec" value="${((now.time)-datas.timestampVal)/1000}"/>
                                </c:when>
                                <c:when test="${datas.getClass().name=='hibernate.mapping.Primaryinfo'}">
                                    <c:set var="actionPerformer" value="${datas.userId}"/>
                                    <c:set var="otherUserName" value="${datas.firstName} ${datas.lastName}"/>
                                    <c:set var="otherUser" value="${crypto.encrypt(actionPerformer)}"/>
                                    <c:set var="picSQQ" value="${crypto.encrypt(getImage.getAccountPic(actionPerformer).getPicId())}"/>
                                </c:when>
                                <c:when test="${datas.getClass().name=='hibernate.mapping.Userchatlist'}">
                                    <c:choose>
                                        <c:when test="${(datas.request)&&(datas.userOne==user)}">
                                            <c:set var="msgPosition" value="Sent Alerts"/>
                                        </c:when>
                                        <c:when test="${datas.request}">
                                            <c:set var="msgPosition" value="Alerts"/>
                                        </c:when>
                                        <c:when test="${datas.friend}">
                                            <c:set var="isFriend" value="true"/>
                                            <c:set var="msgPosition" value="Chat"/>
                                        </c:when>
                                        <c:when test="${datas.removed}">
                                            <c:set var="msgPosition" value="Removed"/>
                                        </c:when>
                                        <c:when test="${datas.blocked}">
                                            <c:set var="msgPosition" value="Blocked"/>
                                        </c:when>
                                    </c:choose>

                                </c:when>
                                <c:when test="${datas.getClass().name=='hibernate.mapping.Usermessages'}">
                                    <c:set var="operId" value="${crypto.encrypt(datas.operId)}"/>
                                    <c:set var="msgId" value="${crypto.encrypt(datas.autoId)}"/>
                                    <c:set var="getTime" value="${CalTime.saveShortTime(datas.msgTimestamp)}"/>
                                    <c:set var="sender" value="${datas.sender}"/>
                                    <c:set var="countChatMsg" value="${getCountNotify.countMessage(datas.operId,user)}"/>
                                </c:when>
                                <c:when test="${datas.getClass().name=='hibernate.mapping.Messages'}">

                                    <div class="qwri_dsa">

                                        <div class="sdfwe">
                                            <div class="__yttr">
                                                <a href="/info/?sqq=${crypto.encodeURL(otherUser)}">
                                                    <c:choose>
                                                        <c:when test="${picSQQ!=null}">
                                                            <div class="fertes ty_ull">
                                                                <div class="gdd_gg">
                                                                    <img src="/account/pic/show/a1/?sqq=${crypto.encodeURL(picSQQ)}" alt="img">
                                                                </div>
                                                            </div>
                                                        </c:when>
                                                        <c:otherwise><div class="fertes ty_ull">
                                                                <div class="gdd_gg">
                                                                    <img src="/account/pic/show/user/default/a1/">
                                                                </div>
                                                            </div>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </a>
                                            </div></div>

                                        <div class="hrier">
                                            <a href="/user/send/message/?sqq=${crypto.encodeURL(operId)}">${otherUserName}<c:if test="${countChatMsg>0}"> (${countChatMsg})</c:if></a>
                                            <c:if test="${(onlineSec<50)&&(isFriend)}">
                                                <div class="online_user" style="display: inline-block; margin-left: 2px;">
                                                    <span></span><span></span><span></span>
                                                </div>
                                            </c:if>
                                            <div class="ghj_hg">
                                                <c:if test="${sender==user}"><div style="display:inline-block;color:rgba(0,0,0,0.5);margin-right:5px;">You:</div></c:if>${datas.userMessage}
                                                </div>
                                            <c:choose>
                                                <c:when test="${datas.mediaType.contains('image')}">
                                                    <div>
                                                        Image
                                                    </div>
                                                </c:when>
                                                <c:when test="${datas.mediaType.contains('video')}">
                                                    <div>
                                                        Video
                                                    </div>
                                                </c:when>
                                                <c:when test="${datas.mediaType.contains('audio')}">
                                                    <div>
                                                        Audio
                                                    </div>
                                                </c:when>
                                            </c:choose>
                                            <div class="show_msg_position">
                                                <div style="display:inline-block;background-color:#663399;margin-right:4px;height:5px;width:5px;border-radius:50%;"></div>${msgPosition}
                                            </div>
                                        </div>
                                        <div class="sdfs">
                                            ${CalTime.time}
                                        </div>
                                    </div>
                                </c:when>
                            </c:choose>
                        </c:forEach>
                    </c:forEach>
                </div>
                <c:if test="${messages.isEmpty()}">
                    <div style="display:block;text-align:center;padding-bottom:10px;">No messages found for '<c:out value="${query}"/>'</div>
                </c:if>
            </div>
            </div>
        </div>
    </body>
</html>