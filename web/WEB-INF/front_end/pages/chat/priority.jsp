<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%><%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%><%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@taglib uri="http://www.springframework.org/tags" prefix="spring"%><%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%><%@page contentType="text/html" pageEncoding="UTF-8"%><%@page session="false"%><!DOCTYPE html>
<html lang="en-US" id="wooker"><c:set var="requestURI" value="${requestScope['javax.servlet.forward.request_uri']}"/>
    <head>
        <meta name="keywords" content="Priority for chat user at Wooker">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
        <meta name="theme-color" content="#663399">
        <link rel="shortcut icon" href="http://www.google.com/favicon.ico">
        <meta name="description" content="Priority for chat user at Wooker">
        <meta name="google" content="notranslate">
        <title>Priority</title>
        <link rel="stylesheet" type="text/css" href="/rele/css/styleone.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/styletwo.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/kuEopDjfRmEKf.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/UwoirFRJrjdkrRkf.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/IoDJnmdJdDE.css">
    </head>
    <body>
        <%@include file="../header.jsp"%>
            <div class="wrapper animate_in" id="wrapper">
            <jsp:useBean id="getPriority" class="hibernate.query.chat.UserRelationActions"/>

            <c:set var="priority" value="${getPriority.getUserlistById(crypto.decrypt(param.sqq))}"/>

            <c:set var="otherUserInfo" value="${getUserData.getPriInfo(priority.userOne==user ? priority.userTwo : priority.userOne)}"/>
            <c:set var="otherUser" value="${crypto.encrypt(otherUserInfo.getUserId())}"/>
            <c:set var="picSQQ" value="${crypto.encrypt(getImage.getAccountPic(otherUserInfo.getUserId()).getPicId())}"/>
            <div class="info_page main clearfix" id="web_view">
                <div class="content">
                <div class="gu_edd">
                    <div class="ter__rt">
                        <a href="/user/send/message/?sqq=${crypto.encodeURL(param.sqq)}" class="jwek__lki"></a><span class="rrytryf">Go back</span>
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
                </div>
                    <div class="bvbn__jh"></div>
                    <div class="dsf_ds">
                        <form:form method="post" name="priority" modelAttribute="priority" action="${requestURI}?sqq=${crypto.encodeURL(param.sqq)}">
                           
                            <div class="gfh_ghfg"><form:label path="openChatpage" class="contain_checkbox"><form:checkbox path="openChatpage" id="openChatpage" value="true"/><span class="custom_checkbox"></span>Open chat window when send message</form:label></div>
                            <div class="gfh_ghfg"><form:label path="position" class="contain_checkbox"><form:checkbox path="position" id="position" value="true"/><span class="custom_checkbox"></span>Add to priority position</form:label></div>
                            <div class="gfh_ghfg"><form:label path="notification" class="contain_checkbox"><form:checkbox path="notification" id="notification" value="true"/><span class="custom_checkbox"></span>Show notification when becomes online</form:label></div>
                            <p class="notify_position">You can add priority only upto two users</p>
                            <form:button name="update" id="update" class="form_update_button" value="submit">Update</form:button>

                        </form:form>
                    </div>
            </div>
        </div>
        </div>
    </body>
</html>