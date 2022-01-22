<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%><%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%><%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@taglib uri="http://www.springframework.org/tags" prefix="spring"%><%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%><%@page contentType="text/html" pageEncoding="UTF-8"%><%@page session="false"%><!DOCTYPE html>
<html lang="en-US" id="wooker"><c:set var="requestURI" value="${requestScope['javax.servlet.forward.request_uri']}"/>
    <head><jsp:useBean id="getCurrentUser" class="pages.controller.home.CurrentUser"/>
        <c:set var="getUser" value="${getCurrentUser.getUserId()}"/>
        <jsp:useBean id="getUserDetail" class="hibernate.query.info.InfoAction"/>
        <jsp:useBean id="getCrypto" class="data.encryption.decryption.Cryptography"/>
        <jsp:useBean id="getUserList" class="hibernate.query.chat.UserRelationActions"/>
        <c:set var="getUserInfo" value="${getUserList.getUserlistById(getCrypto.decrypt(param.sqq))}"/>
        <c:set var="otherUserInfo" value="${getUserDetail.getPriInfo(getUserInfo.userOne==getUser ? getUserInfo.userTwo : getUserInfo.userOne)}"/>
        <meta name="keywords" content="Chatpage at Wooker">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
        <meta name="theme-color" content="#663399">
        <link rel="shortcut icon" href="http://www.google.com/favicon.ico">
        <meta name="description" content="Chatpage at Wooker">
        <meta name="google" content="notranslate">
        <title>Starred Chat - ${otherUserInfo.firstName} ${otherUserInfo.lastName}</title>
        <link rel="stylesheet" type="text/css" href="/rele/css/styleone.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/styletwo.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/kuEopDjfRmEKf.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/IoDJnmdJdDE.css">
    </head>
    <body>
        <%@include file="../header.jsp"%>
            <div class="wrapper animate_in" id="wrapper">
            <jsp:useBean id="getMessages" class="hibernate.query.chat.StarredChatMessages"/>
            <jsp:useBean id="CalTime" class="timeperiod.duration.calculation.CalculateTime"/>
            <c:choose>
                <c:when test="${(crypto.decrypt(param.pagination_backward))!=null}">
                    <c:set var="pagination_backward" value="${crypto.decrypt(param.pagination_backward)}"/>
                    <c:set var="messages" value="${getMessages.StarredpageMessage(crypto.decrypt(param.sqq),user,pagination_backward,false)}"/>
                </c:when>
                <c:when test="${(crypto.decrypt(param.pagination_forward))!=null}">
                    <c:set var="pagination_forward" value="${crypto.decrypt(param.pagination_forward)}"/>
                    <c:set var="messages" value="${getMessages.StarredpageMessage(crypto.decrypt(param.sqq),user,pagination_forward,true)}"/>
                </c:when>
                <c:otherwise>
                    <c:set var="messages" value="${getMessages.firstStarredpageMessage(crypto.decrypt(param.sqq),user)}"/>
                </c:otherwise>
            </c:choose>
            <c:set var="otherUser" value="${crypto.encrypt(otherUserInfo.getUserId())}"/>
            <c:set var="picSQQ" value="${crypto.encrypt(getImage.getAccountPic(otherUserInfo.getUserId()).getPicId())}"/>
            <div class="info_page main clearfix" id="web_view">
                <div class="content">
                <div class="top">
                    <div class="fsdf_dsf">
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
                        </div>
                        <div class="fghgf_gfdd">
                            <div class="rtr_ty fgh_ghfgh">
                                <a href="" class="sdfdsf_sdf">Wooks</a>
                            </div>
                        </div>
                        <div class="dfgfd_gfg">
                            <div class="rtr_ty">
                                <a href="/user/chat/?sqq=${crypto.encodeURL(otherUser)}">${otherUserInfo.firstName} ${otherUserInfo.lastName}</a>
                            </div>
                        </div>
                    </div>
                </div>
                <fmt:formatDate var="currentDate" value="${now}" pattern="dd"/>
                <div class="chat active-chat active" id="<c:if test='${pagination_forward==null}'>__sda</c:if>">
                    <c:set var="totalData" value="${fn:length(messages)}"/>
                    <c:forEach var="i" begin="${pagination_forward!=null ? (totalData==0 ? 1 : 0) : 1}" end="${pagination_forward!=null ? (totalData>0 ? totalData-1 : totalData) : totalData}" step="1">
                        <c:set var="data" value="${pagination_forward!=null ? messages[i] : messages[totalData-i]}"/>
                        <c:forEach items="${data}" var="datas">
                            <c:choose>
                                <c:when test="${datas.getClass().name=='hibernate.mapping.Starredmessages'}">
                                    <c:if test="${i==(pagination_forward!=null ? 0 : 1)}"><c:set var="firstMsgId" value="${datas.starmsgId}"/></c:if>
                                    <c:if test="${i==(pagination_forward!=null ? totalData-1 : totalData)}"><c:set var="lastMsgId" value="${datas.starmsgId}"/></c:if>
                                </c:when>
                                <c:when test="${datas.getClass().name=='hibernate.mapping.Usermessages'}">
                                    <c:set var="msgId" value="${crypto.encrypt(datas.autoId)}"/>
                                    <c:set var="read" value="${datas.chatpageRead}"/>
                                    <c:set var="getTime" value="${CalTime.saveDateTime(datas.msgTimestamp)}"/>
                                    <c:set var="sender" value="${datas.sender}"/>
                                </c:when>
                                <c:when test="${datas.getClass().name=='hibernate.mapping.Messages'}">
                                    <c:if test="${i==(pagination_forward!=null ? 0 : 1)}">
                                        <c:if test="${getMessages.isPagination(crypto.decrypt(param.sqq),user,firstMsgId,false)}"><div class="uop_ppa"><a href="${requestURI}?sqq=${crypto.encodeURL(param.sqq)}&amp;pagination_backward=${crypto.encodeURL(crypto.encrypt(firstMsgId))}">Older Chat</a></div></c:if>
                                    </c:if>
                                    <%@include file="getchatmsg/showMsg.jsp"%>
                                </c:when>
                            </c:choose>
                        </c:forEach>
                    </c:forEach>
                    <c:if test="${getMessages.isPagination(crypto.decrypt(param.sqq),user,lastMsgId,true)}"><div class="uop_ppa"><a href="${requestURI}?sqq=${crypto.encodeURL(param.sqq)}&amp;pagination_forward=${crypto.encodeURL(crypto.encrypt(lastMsgId))}">Newer Chat</a></div></c:if>

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