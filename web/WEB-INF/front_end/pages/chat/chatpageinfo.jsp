<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%><%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@taglib uri="http://www.springframework.org/tags" prefix="spring"%><%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%><%@page contentType="text/html" pageEncoding="UTF-8"%><%@page session="false"%><!DOCTYPE html>
<html lang="en-US" id="wooker"><c:set var="requestURI" value="${requestScope['javax.servlet.forward.request_uri']}"/>
    <head>
        <meta name="keywords" content="Message Info at Wooker">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
        <meta name="theme-color" content="#663399">
        <link rel="shortcut icon" href="http://www.google.com/favicon.ico">
        <meta name="description" content="Message Info at Wooker">
        <meta name="google" content="notranslate">
        <title>Chat - Message Info</title>
        <link rel="stylesheet" type="text/css" href="/rele/css/styleone.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/styletwo.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/kuEopDjfRmEKf.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/UwoirFRJrjdkrRkf.css">
    </head>
    <body>
        <%@include file="../header.jsp"%>
        <div class="wrapper animate_in" id="wrapper">
            <c:set var="page" value="${param.page.matches('^(?:[0-9]){1,11}$') ? param.page : 0}"/>
            <jsp:useBean id="getMessages" class="hibernate.query.chat.ChatPageMessages"/>
            <jsp:useBean id="getSavedMsgs" class="hibernate.query.chat.SaveMessages"/>
            <c:set var="messages" value="${getMessages.getMessageById(crypto.decrypt(param.sqq))}"/>
            <c:forEach items="${messages}" var="dataId">
                <c:choose>
                    <c:when test="${dataId.getClass().name=='hibernate.mapping.Usermessages'}">
                        <c:set var="chatId" value="${crypto.encrypt(dataId.operId)}"/>
                        <c:set var="otherUserInfo" value="${getUserData.getPriInfo(dataId.sender)}"/>
                    </c:when>
                </c:choose>
            </c:forEach>
            <c:set var="otherUser" value="${crypto.encrypt(otherUserInfo.getUserId())}"/>
            <c:set var="picSQQ" value="${crypto.encrypt(getImage.getAccountPic(otherUserInfo.getUserId()).getPicId())}"/>

            <div class="info_page main clearfix" id="web_view">
                <div class="content">
                <div class="gu_edd">
                    <div class="ter__rt">
                        <a href="/user/send/message/?sqq=${crypto.encodeURL(chatId)}<c:if test='${param.pagination_backward!=null}'>&amp;pagination_backward=${crypto.encodeURL(param.pagination_backward)}</c:if><c:if test='${param.pagination_forward!=null}'>&amp;pagination_backward=${crypto.encodeURL(param.pagination_forward)}</c:if>" class="jwek__lki"></a><span class="rrytryf">Go back</span>
                        </div>
                    </div>
                    <div class="dsfds_sf">
                        <div class="fsdf_dsf">
                            <div class="__yttr">
                                    <a href="/info/<c:if test='${user!=otherUserInfo.getUserId()}'>?sqq=${crypto.encodeURL(otherUser)}</c:if>">
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
                    </div>
                    <div class="fdgfd_wer">
                        <c:choose>
                            <c:when test="${user!=otherUserInfo.getUserId()}">
                                <a href="/user/chat/?sqq=${crypto.encodeURL(otherUser)}">${otherUserInfo.firstName} ${otherUserInfo.lastName}</a>
                            </c:when><c:otherwise>
                                ${otherUserInfo.firstName} ${otherUserInfo.lastName}
                            </c:otherwise>
                        </c:choose>
                    </div>
                                <div class="bvbn__jh"></div>
                                
                                
                                <div class="hfghf_ghgff">
                                
                    <fmt:formatDate var="currentDate" value="${now}" pattern="dd"/>
                    <fmt:formatDate var="currentMonth" value="${now}" pattern="MM"/>
                    <fmt:formatDate var="currentYear" value="${now}" pattern="yyyy"/>
                    <c:forEach items="${messages}" var="data">
                        <c:choose>
                            <c:when test="${data.getClass().name=='hibernate.mapping.Messages'}">
                                <div class="gfhgf_fgffg">
                                    ${data.userMessage}
                                    
            <c:choose>
                <c:when test="${data.mediaType.contains('image')}">
                    <div class="asf_fgf">
                        <a href="/jghg/urt/nmbn/rut/r/u/tyt/ghjhg/full/?sqq=${crypto.encodeURL(crypto.encrypt(data.mediaId))}"><img src="/jghg/urt/nmbn/rut/r/u/tyt/ghjhg/a1/?sqq=${crypto.encodeURL(crypto.encrypt(data.mediaId))}" alt="img"></a>
                    </div>
                </c:when>
                <c:when test="${data.mediaType.contains('video')}">
                    <div>
                        <video width="180" height="100" controls src="/jgjg/uyt/nmbnt/rutr/r/u/tyt/ghjhg/?sqq=${crypto.encodeURL(crypto.encrypt(data.mediaId))}">
                            Your browser does not support the video tag.
                        </video>
                    </div>
                </c:when>
                <c:when test="${data.mediaType.contains('audio')}">
                    <div>
                        <audio controls src="/iop/ght/lkl/uyuy/rhj/hu/tghyt/ghghjhg/?sqq=${crypto.encodeURL(crypto.encrypt(data.mediaId))}">
                            Your browser does not support the audio tag.
                        </audio>
                    </div>
                </c:when>
            </c:choose>
                                </div>
                            </c:when>
                            <c:when test="${data.getClass().name=='hibernate.mapping.Usermessages'}">
                                <jsp:useBean id="CalTime" class="timeperiod.duration.calculation.CalculateTime"/>
                                <c:set var="deviceId" value="${data.deviceId}"/>

                                <c:if test="${!data.chatpageRead}">
                                    <a href="/user/send/message/action/getback/?sqq=${crypto.encodeURL(param.sqq)}<c:if test='${param.pagination_backward!=null}'>&amp;pagination_backward=${crypto.encodeURL(param.pagination_backward)}</c:if><c:if test='${param.pagination_forward!=null}'>&amp;pagination_forward=${crypto.encodeURL(param.pagination_forward)}</c:if>&amp;refer=${param.refer}"><div class="link_style">Get back</div></a>
                                </c:if>
                                <c:if test="${(data.sender!=user)&&((crypto.decrypt(param.sqq))>getSavedMsgs.getLastMsgId(crypto.decrypt(chatId), user))}">
                                    <a href="/user/send/message/action/unread/?sqq=${crypto.encodeURL(param.sqq)}<c:if test='${param.pagination_backward!=null}'>&amp;pagination_backward=${crypto.encodeURL(param.pagination_backward)}</c:if><c:if test='${param.pagination_forward!=null}'>&amp;pagination_forward=${crypto.encodeURL(param.pagination_forward)}</c:if>&amp;refer=${param.refer}"><div class="link_style">Unread</div></a>
                                </c:if>
                                <a href="/user/send/message/action/delete/?sqq=${crypto.encodeURL(param.sqq)}<c:if test='${param.pagination_backward!=null}'>&amp;pagination_backward=${crypto.encodeURL(param.pagination_backward)}</c:if><c:if test='${param.pagination_forward!=null}'>&amp;pagination_forward=${crypto.encodeURL(param.pagination_forward)}</c:if>&amp;refer=${param.refer}"><div class="link_style">Delete</div></a>
                                <a href="/user/send/message/action/forward/?sqq=${crypto.encodeURL(param.sqq)}<c:if test='${param.pagination_backward!=null}'>&amp;pagination_backward=${crypto.encodeURL(param.pagination_backward)}</c:if><c:if test='${param.pagination_forward!=null}'>&amp;pagination_forward=${crypto.encodeURL(param.pagination_forward)}</c:if>&amp;refer=${param.refer}"><div class="link_style">Forward</div></a>
                                <a href="/user/send/message/action/star/?sqq=${crypto.encodeURL(param.sqq)}<c:if test='${param.pagination_backward!=null}'>&amp;pagination_backward=${crypto.encodeURL(param.pagination_backward)}</c:if><c:if test='${param.pagination_forward!=null}'>&amp;pagination_forward=${crypto.encodeURL(param.pagination_forward)}</c:if>&amp;refer=${param.refer}"><div class="link_style"><c:choose><c:when test="${getSavedMsgs.isStarredMsg(crypto.decrypt(param.sqq),user)}">Starred</c:when><c:otherwise>Star</c:otherwise></c:choose></div></a>

                                        
                                <div class="fdgfd_wer">
                                <c:set var="getTime" value="${CalTime.saveDateTime(data.msgTimestamp)}"/>
                                <div class="ghfh_ghf">
                                    <div class="fdgfd_fd">
                                Sent
                                </div>
                                    <div class="hg__hghj">
                                        <c:choose><c:when test="${(CalTime.month==currentMonth)&&(CalTime.year==currentYear)}"><c:if test="${CalTime.date==currentDate}">Today</c:if><c:if test="${(CalTime.date==(currentDate-1))}">Yesterday</c:if></c:when><c:otherwise><c:if test="${CalTime.month<=9}"><spring:message code="label.month.0${CalTime.month}"/></c:if><c:if test="${CalTime.month>9}"><spring:message code="label.month.${CalTime.month}"/></c:if> ${CalTime.date},${CalTime.year}</c:otherwise></c:choose> ${CalTime.time}
                                </div>
                                </div>
                                <div class="ghfh_ghf">
                                <c:set var="getTime" value="${CalTime.saveDateTime(data.seenTimestamp)}"/>
                                <div class="fdgfd_fd">
                                Seen
                                </div>
                                <div class="hg__hghj">
                                <c:choose><c:when test="${data.seenTimestamp!=0}"><c:choose><c:when test="${(CalTime.month==currentMonth)&&(CalTime.year==currentYear)}"><c:if test="${CalTime.date==currentDate}">Today</c:if><c:if test="${(CalTime.date==(currentDate-1))}">Yesterday</c:if></c:when><c:otherwise><c:if test="${CalTime.month<=9}"><spring:message code="label.month.0${CalTime.month}"/></c:if><c:if test="${CalTime.month>9}"><spring:message code="label.month.${CalTime.month}"/></c:if> ${CalTime.date},${CalTime.year}</c:otherwise></c:choose> ${CalTime.time}</c:when><c:otherwise>Not yet</c:otherwise></c:choose>
                            </div>
                                </div>
                                </c:when>
                        </c:choose>
                    </c:forEach>

                    <jsp:useBean id="getDevice" class="hibernate.query.DeviceInfo"/>
                    <c:set var="getDeviceData" value="${getDevice.getDeviceDetail(deviceId)}"/>
                    <div class="ghfh_ghf">
                        <div class="fdgfd_fd">
                    Device Type
                    </div>
                        <div class="hg__hghj">
                    ${getDeviceData.deviceType}
                    </div>
                    </div>
                    <div class="ghfh_ghf">
                        <div class="fdgfd_fd">
                    Device OS
                    </div>
                        <div class="hg__hghj">
                    ${getDeviceData.deviceOs}
                    </div>
                    </div>
                    <div class="ghfh_ghf">
                        <div class="fdgfd_fd">
                    Browser Name
                    </div>
                        <div class="hg__hghj">
                    ${getDeviceData.browserName}
                    </div>
                    </div>
                    <div class="ghfh_ghf">
                        <div class="fdgfd_fd">
                    IP Address
                    </div>
                        <div class="hg__hghj">
                    ${getDeviceData.clientIp}
                    </div>
                    </div>
                    <div class="ghfh_ghf">
                        <div class="fdgfd_fd">
                    Location by IP
                    </div>
                        <div class="hg__hghj">
                    ${getDeviceData.location}
                    </div>
                    </div>
                </div>
                                </div>
                </div>
            </div>
            </div>
        </div>
    </body>
</html>