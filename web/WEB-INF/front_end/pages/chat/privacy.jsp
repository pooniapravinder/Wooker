<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%><%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%><%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@taglib uri="http://www.springframework.org/tags" prefix="spring"%><%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%><%@page contentType="text/html" pageEncoding="UTF-8"%><%@page session="false"%><!DOCTYPE html>
<html lang="en-US" id="wooker"><c:set var="requestURI" value="${requestScope['javax.servlet.forward.request_uri']}"/>
    <head>
        <meta name="keywords" content="Privacy for chat user at Wooker">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
        <meta name="theme-color" content="#663399">
        <link rel="shortcut icon" href="http://www.google.com/favicon.ico">
        <meta name="description" content="Privacy for chat user at Wooker">
        <meta name="google" content="notranslate">
        <title>Privacy</title>
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
                        <form:form method="post" name="chatuserprivacy" modelAttribute="chatuserprivacy" action="${requestURI}?sqq=${crypto.encodeURL(param.sqq)}">
                            <strong style="display:block;margin:10px 0 20px;">Post:</strong>
                            <div class="fgf_fgdd"><form:label path="likeDislike" class="contain_checkbox"><form:checkbox path="likeDislike" id="likeDislike" value="true"/><span class="custom_checkbox"></span>Likes &amp; Dislikes</form:label></div>
                            <div class="fgf_fgdd"><form:label path="talking" class="contain_checkbox"><form:checkbox path="talking" id="talking" value="true"/><span class="custom_checkbox"></span>Talking</form:label></div>
                            <div class="fgf_fgdd"><form:label path="comment" class="contain_checkbox"><form:checkbox path="comment" id="comment" value="true"/><span class="custom_checkbox"></span>Comment</form:label></div>
                            <div class="fgf_fgdd"><form:label path="share" class="contain_checkbox"><form:checkbox path="share" id="share" value="true"/><span class="custom_checkbox"></span>Share</form:label></div>
                            <strong style="display:block;margin:10px 0 20px;">Chat:</strong>
                            <div class="fgf_fgdd"><form:label path="chat" class="contain_checkbox"><form:checkbox path="chat" id="chat" value="true"/><span class="custom_checkbox"></span>Chat</form:label></div>
                            <div class="fgf_fgdd"><form:label path="image" class="contain_checkbox"><form:checkbox path="image" id="image" value="true"/><span class="custom_checkbox"></span>Image</form:label></div>
                            <div class="fgf_fgdd"><form:label path="audio" class="contain_checkbox"><form:checkbox path="audio" id="audio" value="true"/><span class="custom_checkbox"></span>Audio</form:label></div>
                            <div class="fgf_fgdd"><form:label path="video" class="contain_checkbox"><form:checkbox path="video" id="video" value="true"/><span class="custom_checkbox"></span>Video</form:label></div>
                            <div class="fgf_fgdd"><form:label path="file" class="contain_checkbox"><form:checkbox path="file" id="file" value="true"/><span class="custom_checkbox"></span>File</form:label></div>
                            <div class="fgf_fgdd"><form:label path="gif" class="contain_checkbox"><form:checkbox path="gif" id="gif" value="true"/><span class="custom_checkbox"></span>GIF</form:label></div>
                            
                            <form:button name="update" id="update" class="form_update_button" value="submit">Update</form:button>

                        </form:form>
                    </div>
            </div>
            </div>
        </div>
    </body>
</html>