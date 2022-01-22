<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%><%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@taglib uri="http://www.springframework.org/tags" prefix="spring"%><%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%><%@page contentType="text/html" pageEncoding="UTF-8"%><%@page session="false"%><!DOCTYPE html>
<html lang="en-US" id="wooker">
    <head>
        <meta name="keywords" content="Welcome to Wooker">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
        <meta name="theme-color" content="#663399">
        <link rel="shortcut icon" href="http://www.google.com/favicon.ico">
        <meta name="description" content="You are now at Wooker home, Now you can do everything at Wooker">
        <meta name="google" content="notranslate">
        <title>Online</title>
        <link rel="stylesheet" type="text/css" href="/rele/css/styleone.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/styletwo.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/kuEopDjfRmEKf.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/YwoPFkdMRofF.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/vbtcHJenEjEnE.css">
    </head>
    <body>
            <%@include file="header.jsp"%>
        <div class="wrapper animate_in" id="wrapper">
            <jsp:useBean id="getOnline" class="hibernate.query.OnlineUser"/>
            <c:choose>
                <c:when test="${(crypto.decrypt(param.pagination_backward))!=null}">
                    <c:set var="pagination_backward" value="${crypto.decrypt(param.pagination_backward)}"/>
                    <c:set var="getList" value="${getOnline.OnlineList(user,pagination_backward,false)}"/>
                </c:when>
                <c:when test="${(crypto.decrypt(param.pagination_forward))!=null}">
                    <c:set var="pagination_forward" value="${crypto.decrypt(param.pagination_forward)}"/>
                    <c:set var="getList" value="${getOnline.OnlineList(user,pagination_forward,true)}"/>
                </c:when>
                <c:otherwise>
                    <c:set var="getList" value="${getOnline.getOnlineList(user)}"/>
                </c:otherwise>
            </c:choose>
                    <c:set var="totalOnline" value="${getOnline.countOnline(user)}"/>
            <c:set var="totalData" value="${fn:length(getList)}"/>
            <div class="info_page main clearfix" id="web_view">
                <div class="content">
                <div class="chat active-chat active" id="<c:if test='${pagination_forward!=null}'>__sda</c:if>">
                    
                    <c:choose>
                        <c:when test="${totalOnline==1}"><div class="gg_ss ggj_fd">1 user is online</div></c:when>
                        <c:when test="${totalOnline>1}"><div class="gg_ss ggj_fd">${totalOnline} users are online</div></c:when>
                    </c:choose>
                    
                    <c:forEach var="i" begin="${pagination_forward!=null ? 1 : (totalData==0 ? 1 : 0)}" end="${pagination_forward!=null ? totalData : (totalData>0 ? totalData-1 : totalData)}" step="1">
                        <c:set var="data" value="${pagination_forward!=null ? getList[totalData-i] : getList[i]}"/>
                        

                                        <c:if test="${i==(pagination_forward!=null ? 1 : 0)}"><c:set var="firstId" value="${data.autoId}"/></c:if>
                                        <c:if test="${i==(pagination_forward!=null ? totalData : totalData-1)}"><c:set var="lastId" value="${data.autoId}"/></c:if>
                                        <c:set var="operId" value="${crypto.encrypt(data.autoId)}"/>
                                
                                    <c:if test="${i==(pagination_forward!=null ? 1 : 0)}">
                                        <c:if test="${getOnline.isPagination(user,firstId,true)}"><div class="uop_ppa"><a href="${requestURI}?pagination_forward=${crypto.encodeURL(crypto.encrypt(firstId))}">Newer</a></div></c:if>
                                    </c:if>
                                    <c:set var="otherUserData" value="${getUserData.getPriInfo(data.userOne==user ? data.userTwo : data.userOne)}"/>
                                    <c:set var="otherUser" value="${crypto.encrypt(otherUserData.getUserId())}"/>
                                    <c:set var="picSQQ" value="${crypto.encrypt(getImage.getAccountPic(otherUserData.getUserId()).getPicId())}"/>

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
                                           <div class="online_user">
                                                            <span></span><span></span><span></span>
                                                        </div>
                                        </div>
                                        <div class="hrier">
                                            <a href="/user/send/message/?sqq=${crypto.encodeURL(operId)}">${otherUserData.firstName} ${otherUserData.lastName}</a>
                                            </div>
                                        </div>
                    </c:forEach>
                    <c:if test="${getOnline.isPagination(user,lastId,false)}"><div class="uop_ppa"><a href="${requestURI}?pagination_backward=${crypto.encodeURL(crypto.encrypt(lastId))}">Older</a></div></c:if>
                
                    
                    
            </div>
                </div>
            </div>
            </div>
    </body>
</html>