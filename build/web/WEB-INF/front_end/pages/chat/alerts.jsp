<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%><%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%><%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@taglib uri="http://www.springframework.org/tags" prefix="spring"%><%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%><%@page contentType="text/html" pageEncoding="UTF-8"%><%@page session="false"%><!DOCTYPE html>
<html lang="en-US" id="wooker"><c:set var="requestURI" value="${requestScope['javax.servlet.forward.request_uri']}"/>
    <head>
        <meta name="keywords" content="Chatpage at Wooker">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
        <meta name="theme-color" content="#663399">
        <link rel="shortcut icon" href="http://www.google.com/favicon.ico">
        <meta name="description" content="Chatpage at Wooker">
        <meta name="google" content="notranslate">
        <title>Alerts</title>
        <link rel="stylesheet" type="text/css" href="/rele/css/styleone.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/styletwo.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/kuEopDjfRmEKf.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/YwoPFkdMRofF.css">
    </head>
    <body>
            <%@include file="../header.jsp"%>
        <div class="wrapper animate_in" id="wrapper">
            <jsp:useBean id="getMessages" class="hibernate.query.chat.AlertsMessages"/>
            <jsp:useBean id="CalTime" class="timeperiod.duration.calculation.CalculateTime"/>
            <c:choose>
                <c:when test="${(crypto.decrypt(param.pagination_backward))!=null}">
                    <c:set var="pagination_backward" value="${crypto.decrypt(param.pagination_backward)}"/>
                    <c:set var="messages" value="${getMessages.AlertMessage(user,pagination_backward,false)}"/>
                </c:when>
                <c:when test="${(crypto.decrypt(param.pagination_forward))!=null}">
                    <c:set var="pagination_forward" value="${crypto.decrypt(param.pagination_forward)}"/>
                    <c:set var="messages" value="${getMessages.AlertMessage(user,pagination_forward,true)}"/>
                </c:when>
                <c:otherwise>
                    <c:set var="messages" value="${getMessages.firstAlertPageMessage(user)}"/>
                </c:otherwise>
            </c:choose>
            <c:set var="totalData" value="${fn:length(messages)}"/>
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
                <div class="dsooa">
                    <a href="/alerts/sent/">Sent Alerts<c:if test="${alertNotify>0}"> (${alertNotify})</c:if></a>
                    </div>

                <c:if test="${(!messages.isEmpty())&&(totalData>1)}">
                    <div class="ghjjk_fh">
                        <a href="/user/action/accept/all/">Accept All</a><a href="/user/action/reject/all/">Reject All</a>
                    </div>
                </c:if>
                <div class="chat active-chat active" id="<c:if test='${pagination_forward!=null}'>__sda</c:if>">

                    <c:forEach var="i" begin="${pagination_forward!=null ? 1 : (totalData==0 ? 1 : 0)}" end="${pagination_forward!=null ? totalData : (totalData>0 ? totalData-1 : totalData)}" step="1">
                        <c:set var="data" value="${pagination_forward!=null ? messages[totalData-i] : messages[i]}"/>
                        <c:forEach items="${data}" var="datas">
                            <c:choose>
                                <c:when test="${datas.getClass().name=='hibernate.mapping.Usermessages'}">

                                    <c:if test="${i==(pagination_forward!=null ? 1 : 0)}"><c:set var="firstMsgId" value="${datas.autoId}"/></c:if>
                                    <c:if test="${i==(pagination_forward!=null ? totalData : totalData-1)}"><c:set var="lastMsgId" value="${datas.autoId}"/></c:if>

                                    <c:set var="operId" value="${crypto.encrypt(datas.operId)}"/>
                                    <c:set var="msgId" value="${crypto.encrypt(datas.autoId)}"/>
                                    <c:set var="getTime" value="${CalTime.saveShortTime(datas.msgTimestamp)}"/>
                                    <c:set var="actionPerformer" value="${datas.receiver==user ? datas.sender : datas.receiver}"/>
                                    <c:set var="sender" value="${datas.sender}"/>
                                    <c:set var="countChatMsg" value="${getCountNotify.countMessage(datas.operId,user)}"/>
                                </c:when>
                                <c:when test="${datas.getClass().name=='hibernate.mapping.Messages'}">
                                    <c:if test="${i==(pagination_forward!=null ? 1 : 0)}">
                                        <c:if test="${getMessages.isPagination(user,firstMsgId,true)}"><div class="uop_ppa"><a href="${requestURI}?pagination_forward=${crypto.encodeURL(crypto.encrypt(firstMsgId))}">Newer</a></div></c:if>
                                    </c:if>
                                    <c:set var="otherUserInfo" value="${getUserData.getPriInfo(actionPerformer)}"/>
                                    <c:set var="otherUser" value="${crypto.encrypt(actionPerformer)}"/>
                                    <c:set var="picSQQ" value="${crypto.encrypt(getImage.getAccountPic(actionPerformer).getPicId())}"/>

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

                                        <div class="sdfs">
                                            ${CalTime.time}
                                        </div>
                                        <div class="hrier">

                                            <a href="/user/send/message/?sqq=${crypto.encodeURL(operId)}">${otherUserInfo.firstName} ${otherUserInfo.lastName}<c:if test="${countChatMsg>0}"> (${countChatMsg})</c:if></a>
                                                <div class="ghj_hg">
                                                <c:if test="${sender==user}"><div style="display: inline-block;color: rgba(0,0,0,0.5);margin-right: 5px;">You:</div></c:if>${datas.userMessage}
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
                                                <div class="ghj_hg">
                                                    <a href="/user/action/accept/?sqq=${crypto.encodeURL(operId)}<c:if test='${pagination_backward!=null}'>&amp;pagination_backward=${crypto.encodeURL(param.pagination_backward)}</c:if><c:if test='${pagination_forward!=null}'>&amp;pagination_forward=${crypto.encodeURL(param.pagination_forward)}</c:if>&amp;refer=Oid_pehRT-dEtNG">Accept</a><a href="/user/action/reject/?sqq=${crypto.encodeURL(operId)}<c:if test='${pagination_backward!=null}'>&amp;pagination_backward=${crypto.encodeURL(param.pagination_backward)}</c:if><c:if test='${pagination_forward!=null}'>&amp;pagination_forward=${crypto.encodeURL(param.pagination_forward)}</c:if>&amp;refer=Oid_pehRT-dEtNG">Reject</a>
                                                </div>
                                            </div>

                                        </div>
                                </c:when>
                            </c:choose>
                        </c:forEach>
                    </c:forEach>
                    <c:if test="${getMessages.isPagination(user,lastMsgId,false)}"><div class="uop_ppa"><a href="${requestURI}?pagination_backward=${crypto.encodeURL(crypto.encrypt(lastMsgId))}">Older</a></div></c:if>
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