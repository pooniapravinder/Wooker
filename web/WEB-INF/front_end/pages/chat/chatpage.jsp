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
        <title>Chat - ${otherUserInfo.firstName} ${otherUserInfo.lastName}</title>
        <link rel="stylesheet" type="text/css" href="/rele/css/styleone.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/styletwo.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/kuEopDjfRmEKf.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/IoDJnmdJdDE.css">
    </head>
    <body>
        <%@include file="../header.jsp"%>
            <div class="wrapper animate_in" id="wrapper">
            <jsp:useBean id="getMessages" class="hibernate.query.chat.ChatPageMessages"/>
            <jsp:useBean id="getChatPrivacy" class="hibernate.query.chat.ChatPrivacy"/>
            <jsp:useBean id="getSavedMsgs" class="hibernate.query.chat.SaveMessages"/>
            <jsp:useBean id="getOnline" class="hibernate.query.OnlineUser"/>
            <jsp:useBean id="CalTime" class="timeperiod.duration.calculation.CalculateTime"/>
            <c:set var="onlineTime" value="${getOnline.getOnline(otherUserInfo.userId)}"/>
            <c:set var="onlineSec" value="${((now.time)-onlineTime)/1000}"/>
            <fmt:formatDate var="currentDate" value="${now}" pattern="dd"/>
                    <fmt:formatDate var="currentMonth" value="${now}" pattern="MM"/>
                    <fmt:formatDate var="currentYear" value="${now}" pattern="yyyy"/>
            <c:choose>
                <c:when test="${(crypto.decrypt(param.pagination_backward))!=null}">
                    <c:set var="pagination_backward" value="${crypto.decrypt(param.pagination_backward)}"/>
                    <c:set var="messages" value="${getMessages.ChatpageMessage(crypto.decrypt(param.sqq),user,pagination_backward,false)}"/>
                </c:when>
                <c:when test="${(crypto.decrypt(param.pagination_forward))!=null}">
                    <c:set var="pagination_forward" value="${crypto.decrypt(param.pagination_forward)}"/>
                    <c:set var="messages" value="${getMessages.ChatpageMessage(crypto.decrypt(param.sqq),user,pagination_forward,true)}"/>
                </c:when>
                <c:otherwise>
                    <c:set var="messages" value="${getMessages.firstChatpageMessage(crypto.decrypt(param.sqq),user)}"/>
                </c:otherwise>
            </c:choose>
            <c:set var="receiver" value="${otherUserInfo.getUserId()}"/>
            <c:set var="chatPrivacy" value="${getChatPrivacy.getPrivacy(receiver, user)}"/>
            <c:set var="otherUser" value="${crypto.encrypt(otherUserInfo.getUserId())}"/>
            <c:set var="picSQQ" value="${crypto.encrypt(getImage.getAccountPic(otherUserInfo.getUserId()).getPicId())}"/>
            <div class="info_page main clearfix" id="web_view" style="background-image: url('/chat/wallpaper/avc/w/tyul/i/p/tj/full/?sqq=${crypto.encodeURL(crypto.encrypt(8))}');background-size: 100% 100%;">
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
                                <c:if test="${(getUserInfo.friend)}">
                                    <a href="/user/action/remove/?sqq=${crypto.encodeURL(param.sqq)}&amp;refer=hImLkOP-Pj_jkFT" class="sdfdsf_sdf">Remove</a>
                                </c:if>
                                <c:choose>
                                    <c:when test="${(!getUserInfo.blocked)}">
                                        <a href="/user/action/block/?sqq=${crypto.encodeURL(param.sqq)}&amp;refer=hImLkOP-Pj_jkFT" class="sdfdsf_sdf">Block</a>
                                    </c:when>
                                    <c:when test="${(getUserInfo.blocked)&&(getUserInfo.userOne==user)}">
                                        <a href="/user/action/unblock/?sqq=${crypto.encodeURL(param.sqq)}&amp;refer=hImLkOP-Pj_jkFT" class="sdfdsf_sdf">Unblock</a>
                                    </c:when>
                                </c:choose>
                            </div>
                        </div>
                        <div class="dfgfd_gfg">
                            <div class="rtr_ty">
                                ${otherUserInfo.firstName} ${otherUserInfo.lastName}
                                <c:if test="${(getUserInfo.friend)&&(getUserInfo.offchatOne!=user)&&(getUserInfo.offchatTwo!=user)}">
                                <div><c:choose>
                                        <c:when test="${onlineSec<50}">
                                            <div class="online_user">
                                                <span></span><span></span><span></span>
                                            </div>
                                        </c:when>
                                        <c:when test="${onlineSec<3600}">
                                            <c:set var="getTime" value="${CalTime.saveShortTime(onlineTime)}"/>
                                            ${CalTime.time}
                                        </c:when>
                                        <c:otherwise>
                                            <c:set var="getTime" value="${CalTime.saveDateTime(onlineTime)}"/>
                                            <c:choose><c:when test="${(CalTime.month==currentMonth)&&(CalTime.year==currentYear)}"><c:if test="${CalTime.date==currentDate}">Today ${CalTime.shTime}</c:if><c:if test="${(CalTime.date==(currentDate-1))}">Yesterday ${CalTime.shTime}</c:if></c:when><c:otherwise><c:if test="${CalTime.month<=9}"><spring:message code="label.month.0${CalTime.month}"/></c:if><c:if test="${CalTime.month>9}"><spring:message code="label.month.${CalTime.month}"/></c:if> ${CalTime.date},${CalTime.year}</c:otherwise></c:choose>
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                                </c:if>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="ghjjk_fh">
                    <c:choose>
                        <c:when test="${(getUserInfo.request)&&(getUserInfo.userOne!=user)}">
                            <a href="/user/action/accept/?sqq=${crypto.encodeURL(param.sqq)}&amp;refer=hImLkOP-Pj_jkFT">Accept</a><a href="/user/action/reject/?sqq=${crypto.encodeURL(param.sqq)}&amp;refer=hImLkOP-Pj_jkFT">Reject</a>
                        </c:when>
                        <c:when test="${(getUserInfo.request)&&(getUserInfo.userOne==user)}">
                            <a href="/user/action/cancel/?sqq=${crypto.encodeURL(param.sqq)}&amp;refer=hImLkOP-Pj_jkFT">Cancel Request</a>
                        </c:when>
                        <c:when test="${getUserInfo.friend}">
                            <a href="/chat/option/perform/starred/?sqq=${crypto.encodeURL(param.sqq)}">Starred</a>
                            <a href="/chat/option/perform/priority/?sqq=${crypto.encodeURL(param.sqq)}">Priority</a>
                            
                            <c:choose>
                                <c:when test="${(getUserInfo.muteOne==otherUserInfo.userId)||(getUserInfo.muteTwo==otherUserInfo.userId)}">
                                    <a href="/chat/option/perform/mute/?sqq=${crypto.encodeURL(param.sqq)}">Unmute</a>
                                </c:when>
                                <c:otherwise>
                                    <a href="/chat/option/perform/mute/?sqq=${crypto.encodeURL(param.sqq)}">Mute</a>
                                </c:otherwise>
                            </c:choose>
                            
                            <c:choose>
                                <c:when test="${(getUserInfo.offchatOne==otherUserInfo.userId)||(getUserInfo.offchatTwo==otherUserInfo.userId)}">
                                    <a href="/chat/option/perform/offchat/?sqq=${crypto.encodeURL(param.sqq)}">On-Chat</a>
                                </c:when>
                                <c:otherwise>
                                    <a href="/chat/option/perform/offchat/?sqq=${crypto.encodeURL(param.sqq)}">Off-Chat</a>
                                </c:otherwise>
                            </c:choose>
                            <a href="/chat/option/perform/privacy/?sqq=${crypto.encodeURL(param.sqq)}">Privacy</a>
                            <a href="/chat/option/perform/settings/?sqq=${crypto.encodeURL(param.sqq)}">Settings</a>
                        </c:when>
                    </c:choose>
                </div>
                <div class="chat active-chat active">
                    <c:if test="${messages.isEmpty()}">
                        <div class="cvbc_ffd" id="__fss">
                        </c:if>
                        <c:set var="totalData" value="${fn:length(messages)}"/>
                        <c:forEach var="i" begin="${pagination_forward!=null ? (totalData==0 ? 1 : 0) : 1}" end="${pagination_forward!=null ? (totalData>0 ? totalData-1 : totalData) : totalData}" step="1">
                            <c:set var="data" value="${pagination_forward!=null ? messages[i] : messages[totalData-i]}"/>
                            <c:forEach items="${data}" var="datas">
                                <c:choose>
                                    <c:when test="${datas.getClass().name=='hibernate.mapping.Usermessages'}">

                                        <c:if test="${i==(pagination_forward!=null ? 0 : 1)}"><c:set var="firstMsgId" value="${datas.autoId}"/></c:if>
                                        <c:if test="${i==(pagination_forward!=null ? totalData-1 : totalData)}"><c:set var="lastMsgId" value="${datas.autoId}"/></c:if>

                                        <c:set var="msgId" value="${crypto.encrypt(datas.autoId)}"/>
                                        <c:set var="read" value="${datas.chatpageRead}"/>
                                        <c:set var="getTime" value="${CalTime.saveDateTime(datas.msgTimestamp)}"/>
                                        <c:set var="sender" value="${datas.sender}"/>
                                    </c:when>
                                    <c:when test="${datas.getClass().name=='hibernate.mapping.Messages'}">
                                        <c:if test="${i==(pagination_forward!=null ? 0 : 1)}">
                                            <div class="conversation-start">
                                                <span><c:choose><c:when test="${(CalTime.month==currentMonth)&&(CalTime.year==currentYear)}"><c:if test="${CalTime.date==currentDate}">Today</c:if><c:if test="${(CalTime.date==(currentDate-1))}">Yesterday</c:if></c:when><c:otherwise><c:if test="${CalTime.month<=9}"><spring:message code="label.month.0${CalTime.month}"/></c:if><c:if test="${CalTime.month>9}"><spring:message code="label.month.${CalTime.month}"/></c:if> ${CalTime.date},${CalTime.year}</c:otherwise></c:choose></span>
                                                    </div>
                                            <c:if test="${getMessages.isPagination(crypto.decrypt(param.sqq),user,firstMsgId,false)}"><div class="uop_ppa"><a href="${requestURI}?sqq=${crypto.encodeURL(param.sqq)}&amp;pagination_backward=${crypto.encodeURL(crypto.encrypt(firstMsgId))}">Older Chat</a></div></c:if>
                                            <div class="cvbc_ffd" id="<c:if test='${pagination_forward==null}'>__fss</c:if>">
                                            </c:if>
                                            <%@include file="getchatmsg/showMsg.jsp"%>
                                        </c:when>
                                    </c:choose>
                                </c:forEach>
                                <c:if test="${i==totalData}">
                                </div>
                            </c:if>
                        </c:forEach>
                        <c:if test="${getMessages.isPagination(crypto.decrypt(param.sqq),user,lastMsgId,true)}"><div class="uop_ppa"><a href="${requestURI}?sqq=${crypto.encodeURL(param.sqq)}&amp;pagination_forward=${crypto.encodeURL(crypto.encrypt(lastMsgId))}">Newer Chat</a></div></c:if>
                        <c:if test="${messages.isEmpty()}">
                        </div>
                    </c:if>
                </div>
                <div class="fdger_ghfdfd">
                    <div class="rtr_fdss">
                        <div class="qwcd nhy">
                            <a href="/info/">
                                <c:choose>
                                    <c:when test="${sqq!=null}">
                                        <div class="wethj_gf">
                                            <img src="/account/pic/show/a1/?sqq=${crypto.encodeURL(sqq)}" alt="img">
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
                    <c:set var="disabled" value="false"/><c:if test="${(getUserInfo.blocked)||(getUserInfo.getBlockedchatOne()==receiver)||(getUserInfo.getBlockedchatOne()==user)||(getUserInfo.getBlockedchatTwo() == receiver)||(getUserInfo.getBlockedchatTwo()==user)}"><c:set var="disabled" value="true"/></c:if>
                        <div class="tty_da_das">
                        <form:form method="post" name="sendMessage" modelAttribute="sendMessage" action="${requestURI}chat/?sqq=${crypto.encodeURL(param.sqq)}" enctype="multipart/form-data">
                            <div class="dfhf_sd_hg">
                                <form:textarea path="message" id="hfgh_hfhf" class="frrt_zxfsr" placeholder="...." autocorrect="off" autocomplete="off" spellcheck="false" disabled="${disabled}"/>
                                <span class="focus-border"></span>
                            </div>
                            <div class="gtrev_gfg yr_yu">
                                <div class="dfgfd_ghf">
                                    <c:if test="${chatPrivacy.chatImage}"><c:set var="allowImage" value="image/*,"/></c:if>
                                    <c:if test="${chatPrivacy.chatAudio}"><c:set var="allowAudio" value="audio/*,"/></c:if>
                                    <c:if test="${chatPrivacy.chatVideo}"><c:set var="allowVideo" value="video/*,"/></c:if>
                                    <c:if test="${(chatPrivacy==null)||(chatPrivacy.chatImage)||(chatPrivacy.chatAudio)||(chatPrivacy.chatVideo)||(chatPrivacy.chatFile)}">
                                    <div class="hfgty5_gfd yyngtr">
                                        <div class="hh__u gr__yut" id="_dsf_as">
                                            <svg width="100%" height="100%" viewBox="0 0 24 24"><circle cx="12" cy="12" r="3.2"></circle><path d="M9 2L7.17 4H4c-1.1 0-2 .9-2 2v12c0 1.1.9 2 2 2h16c1.1 0 2-.9 2-2V6c0-1.1-.9-2-2-2h-3.17L15 2H9zm3 15c-2.76 0-5-2.24-5-5s2.24-5 5-5 5 2.24 5 5-2.24 5-5 5z"></path></svg>
                                            <form:input path="attachment" id="attachment" type="file" accept="${allowImage}${allowAudio}${allowVideo}" autocorrect="off" autocomplete="off" spellcheck="false" disabled="${disabled}"/>
                                            <span class="dfsf_gd">Upload New</span>
                                        </div>
                                    </div>
                                    <form:hidden path="prePic" id="prePic" autocorrect="off" autocomplete="off" spellcheck="false" disabled="${disabled}"/>
                                    <div class="hfgty5_gfd fhyfgh">
                                        <div class="hh__u gr__yut">
                                            <svg width="100%" height="100%" viewBox="0 0 24 24"><circle cx="12" cy="12" r="3.2"></circle><path d="M9 2L7.17 4H4c-1.1 0-2 .9-2 2v12c0 1.1.9 2 2 2h16c1.1 0 2-.9 2-2V6c0-1.1-.9-2-2-2h-3.17L15 2H9zm3 15c-2.76 0-5-2.24-5-5s2.24-5 5-5 5 2.24 5 5-2.24 5-5 5z"></path></svg>
                                            <span class="dfsf_gd">Pick Previous</span>
                                        </div>
                                    </div>
                                    </c:if>
                                    <div class="hfgty5_gfd fhyfgh">
                                        <div class="_gfh_fd dfg_vx">
                                            <svg viewBox="0 0 20 19"><path d="M9 0a9 9 0 1 1 0 18A9 9 0 0 1 9 0zm0 1C4.589 1 1 4.589 1 9s3.589 8 8 8 8-3.589 8-8-3.589-8-8-8zM5 6.999a1 1 0 1 1 2.002.004A1 1 0 0 1 5 6.999zm5.999 0a1.002 1.002 0 0 1 2.001 0 1 1 0 1 1-2.001 0zM8.959 13.5c-.086 0-.173-.002-.26-.007-2.44-.132-4.024-2.099-4.09-2.182l-.31-.392.781-.62.312.39c.014.017 1.382 1.703 3.37 1.806 1.306.072 2.61-.554 3.882-1.846l.351-.356.712.702-.35.356c-1.407 1.427-2.886 2.15-4.398 2.15z" fill-rule="evenodd"></path></svg>
                                            <span class="dfsf_gd">Choose Emoji</span>
                                        </div>
                                    </div>
                                    <c:if test="${(chatPrivacy==null)||(chatPrivacy.chatGif)}">
                                    <div class="rtee_fgfd fhyfgh">
                                        <div class="fgfd_ggf fgh_fgfd">
                                            <svg viewBox="0 0 29 20"><path d="M9 1a8 8 0 1 0 0 16h11a8 8 0 1 0 0-16H9zm0-1h11a9 9 0 0 1 0 18H9A9 9 0 0 1 9 0z" fill-rule="nonzero"></path><path d="M6.561 9.337c0-2.277 1.683-3.795 3.773-3.795 1.298 0 2.2.572 2.849 1.375l-.726.451c-.462-.594-1.243-1.012-2.123-1.012-1.606 0-2.827 1.232-2.827 2.981 0 1.738 1.221 2.992 2.827 2.992.88 0 1.606-.429 1.969-.792v-1.496H9.784v-.814h3.432v2.651a3.822 3.822 0 0 1-2.882 1.265c-2.09 0-3.773-1.529-3.773-3.806zM14.701 13V5.663h.913V13h-.913zm2.629 0V5.663h4.807v.814h-3.894v2.365h3.817v.814h-3.817V13h-.913z"></path></svg>
                                            <span class="ttt_hfh">Choose GIF</span>
                                        </div>
                                    </div>
                                    </c:if>
                                    <c:if test="${(!getUserInfo.request)&&(!getUserInfo.friend)&&(!getUserInfo.blocked)}">
                                        <div class="form_request_button">
                                            <div class="hfgty5_gfd yyngtr">
                                                <div class="hh__u gr__yut">
                                                    <div class="gfh_ghfg"><form:label path="requestConnect" class="contain_checkbox"><form:checkbox path="requestConnect" id="requestConnect" value="true" checked="true"/><span class="custom_checkbox"></span></form:label></div>
                                                        <span class="yiuy_jytu">Request to connect</span>
                                                    </div></div>
                                            </div>
                                    </c:if>
                                </div>
                                <form:button name="send" id="send" class="form_send_button" value="submit" disabled="${disabled}">Send</form:button>
                                </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
        </div>
        <script>
            window.onload = __down("__fss");

            _g("hfgh_hfhf").addEventListener("focus", function () {
                __down("__fss");
                _g("hfgh_hfhf").removeAttribute("placeholder");
            });
            _g("attachment").style.display = "none";
            _g("_dsf_as").addEventListener("click", function () {
                _g("attachment").click();
            });

            function __down(a) {
                var objDiv = _g(a);
                if (null !== objDiv)
                    objDiv.scrollTop = objDiv.scrollHeight;
            }

            function _g(a) {
                return window.document.getElementById(a);
            }

            function _s(c) {
                return window.document.getElementsByClassName(c);
            }
        </script>
    </body>
</html>