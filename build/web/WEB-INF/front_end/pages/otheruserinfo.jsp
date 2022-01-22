<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%><%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%><%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@taglib uri="http://www.springframework.org/tags" prefix="spring"%><%@page contentType="text/html" pageEncoding="UTF-8"%><%@page session="false"%><!DOCTYPE html>
<html lang="en-US" id="wooker">
    <head>
        <meta name="keywords" content="See your Primary Info">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
        <meta name="theme-color" content="#663399">
        <link rel="shortcut icon" href="//www.google.com/favicon.ico"/>
        <meta name="description" content="See or check your Primary Info">
        <meta name="google" content="notranslate">
        <title>Primary Info</title>
        <link rel="stylesheet" type="text/css" href="/rele/css/styleone.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/styletwo.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/stylethree.css">
    </head>
    <body>
            <%@include file="header.jsp"%>
        <div class="wrapper animate_in" id="wrapper">

            <jsp:useBean id="getChatlist" class="hibernate.query.chat.UserRelationActions"/>
            <jsp:useBean id="CalTime" class="timeperiod.duration.calculation.CalculateTime"/>
            <c:set var="chatlist" value="${getChatlist.getUserslist(user, crypto.decrypt(param.sqq))}"/>
            <c:set var="chatId" value="${crypto.encrypt(chatlist.autoId)}"/>
            <c:set var="getTime" value="${CalTime.saveDateTime(chatlist.accepted)}"/>
            <jsp:useBean id="privacyChecker" class="pages.controller.reactoper.ReactOperValidate"/>
            <c:set var="userDetails" value="${getUserData.getPriInfo(crypto.decrypt(param.sqq))}"/>
            <c:set var="userSQQ" value="${crypto.encrypt(getImage.getAccountPic(crypto.decrypt(param.sqq)).getPicId())}"/>
            <div class="info_page main clearfix" id="web_view">
                <div class="content">
                <h1>Primary Info</h1>
                <div class="upp_ss_elem">
                    <div class="options_position"><a href="/info/?sqq=${crypto.encodeURL(param.sqq)}">Primary Info</a></div>
                    <div class="options_position"><a href="/more/info/?sqq=${crypto.encodeURL(param.sqq)}">Secondary Info</a></div>
                    <div class="options_position"><a href="/user/chat/?sqq=${crypto.encodeURL(param.sqq)}">Chat</a></div>
                    <c:if test="${chatlist.friend}">
                        <div class="options_position"><a href="/user/action/remove/?sqq=${crypto.encodeURL(chatId)}&amp;refer=mUosKD-BwP_dOVX">Remove</a></div>
                    </c:if>
                    <c:if test="${!chatlist.blocked}">
                        <div class="options_position"><a href="/user/action/block/?sqq=${crypto.encodeURL(chatlist!=null ? chatId : param.sqq)}&amp;refer=mUosKD-BwP_dOVX">Block</a></div>
                    </c:if>
                    <c:if test="${(chatlist.blocked)&&(chatlist.userOne==user)}">
                        <div class="options_position"><a href="/user/action/unblock/?sqq=${crypto.encodeURL(chatId)}&amp;refer=mUosKD-BwP_dOVX">Unblock</a></div>
                    </c:if>
                    <div class="options_position"><a href="/user/wooks/?sqq=${crypto.encodeURL(param.sqq)}">Wooks</a></div>
                </div>
                <div class="gty_yt"></div>

                <div class="dfs_sf">

                    <div class="ds_dfd">
                        <c:choose>
                            <c:when test="${(chatlist.friend)&&(chatlist.userOne==user)}">
                                You connected with ${userDetails.firstName} ${userDetails.lastName} on <c:if test="${CalTime.month<=9}"><spring:message code="label.month.0${CalTime.month}"/></c:if><c:if test="${CalTime.month>9}"><spring:message code="label.month.${CalTime.month}"/></c:if> ${CalTime.date},${CalTime.year}
                            </c:when>
                            <c:when test="${(chatlist.friend)}">
                                ${userDetails.firstName} ${userDetails.lastName} connected with you on <c:if test="${CalTime.month<=9}"><spring:message code="label.month.0${CalTime.month}"/></c:if><c:if test="${CalTime.month>9}"><spring:message code="label.month.${CalTime.month}"/></c:if> ${CalTime.date},${CalTime.year}
                            </c:when>
                        </c:choose>
                    </div>
                    <div class="bfif_f">
                        <c:choose>
                            <c:when test="${userSQQ!=null}">
                                <div class="ih-item circle">
                                    <div class="img" id="info_pic"><img src="/account/pic/show/a3/?sqq=${crypto.encodeURL(userSQQ)}" id="gdd_h_id"></div>
                                </div>
                            </c:when>
                            <c:otherwise>
                                <div class="ih-item circle">
                                    <div class="img"><img src="/account/pic/show/user/default/a3/"></div>
                                </div>
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <c:if test="${chatlist.friend}">
                        <div class="bfif_f">
                            <div class="gtt_p vbvc_hgf">
                                <div class="ih-item circle">
                                    <div class="img">
                                        <c:choose>
                                            <c:when test="${userSQQ!=null}">
                                                <img src="/account/pic/show/a3/?sqq=${crypto.encodeURL(userSQQ)}">
                                            </c:when>
                                            <c:otherwise>
                                                <img src="/account/pic/show/user/default/a3/">
                                            </c:otherwise>
                                        </c:choose>
                                    </div>
                                </div>
                            </div>
                            <div class="gtt_p">
                                <div class="ih-item circle">
                                    <div class="img">
                                        <c:choose>
                                            <c:when test="${sqq!=null}">
                                                <img src="/account/pic/show/a3/?sqq=${crypto.encodeURL(sqq)}">
                                            </c:when>
                                            <c:otherwise>
                                                <img src="/account/pic/show/user/default/a3/">
                                            </c:otherwise>
                                        </c:choose>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:if>

                    <div class="table">
                        <strong>User:</strong><div class="col info_pos">
                            ${userDetails.firstName}<c:if test="${!(userDetails.lastName).isEmpty()}"> ${userDetails.lastName}</c:if>
                            <c:if test="${!(userDetails.nickName).isEmpty()}">
                                <c:if test="${userDetails.nicknameCombination==1}"> (${userDetails.nickName})</c:if>
                                <c:if test="${userDetails.nicknameCombination==2}"> [${userDetails.nickName}]</c:if>
                                <c:if test="${userDetails.nicknameCombination==3}"> {${userDetails.nickName}}</c:if>
                            </c:if></div>
                        <strong>First Name:</strong><div class="col info_pos">${userDetails.firstName}</div>
                        <strong>Last Name:</strong><div class="col info_pos">${userDetails.lastName}</div>
                        <c:if test="${(!(userDetails.nickName).isEmpty())&&(privacyChecker.privacyChecker(crypto.decrypt(param.sqq),user,userDetails.nicknamePrivacy))}">
                            <strong>Nick Name:</strong><div class="col info_pos">${userDetails.nickName}</div>
                        </c:if>
                        <c:if test="${(privacyChecker.privacyChecker(crypto.decrypt(param.sqq),user,userDetails.genderPrivacy))}">
                            <strong>Gender:</strong><div class="col info_pos">${userDetails.gender}</div>
                        </c:if>
                        <c:set var="showBirthMonth" value="${(privacyChecker.privacyChecker(crypto.decrypt(param.sqq),user,userDetails.monthPrivacy))}"/>
                        <c:set var="showBirthDate" value="${(privacyChecker.privacyChecker(crypto.decrypt(param.sqq),user,userDetails.datePrivacy))}"/>
                        <c:set var="showBirthYear" value="${(privacyChecker.privacyChecker(crypto.decrypt(param.sqq),user,userDetails.yearPrivacy))}"/>
                        <c:if test="${showBirthMonth||showBirthDate||showBirthYear}">
                            <strong>Birthday:</strong><div class="col info_pos">
                                <c:set var="birthDay" value="${fn:split(userDetails.birthDay, '/')}" />
                                <c:if test="${showBirthMonth}"><spring:message code="label.month.${birthDay[0]}"/></c:if><c:if test="${showBirthDate}"><div class="fgr_hgf">${birthDay[1]}</div></c:if><c:choose><c:when test="${showBirthDate&&showBirthYear}">,${birthDay[2]}</c:when><c:when test="${showBirthYear}"><div class="fgr_hgf">${birthDay[2]}</div></c:when></c:choose>
                                </div>
                        </c:if>
                        <c:if test="${(privacyChecker.privacyChecker(crypto.decrypt(param.sqq),user,userDetails.agePrivacy))}">
                            <strong>Age:</strong><div class="col info_pos">
                                <fmt:formatDate var="currentYear" value="${now}" pattern="yyyy" />
                                ${currentYear-birthDay[2]} <spring:message code="primaryinfo.label.years"/></div>
                            </c:if>
                            <c:if test="${(privacyChecker.privacyChecker(crypto.decrypt(param.sqq),user,userDetails.accountPrivacy))}">
                            <strong>Account:</strong><div class="col info_pos">
                                ${userDetails.emailidPhone}</div>
                            </c:if>
                    </div>
                    <div class="xccxv"><a href="/info/user/data/copied/take/action/?sqq=${crypto.encodeURL(param.sqq)}">This person has copied my details</a></div>
                </div>
            </div>
            </div>
        </div>
        <div class="slide_layout info_pic_frty" id="slide_layout"><div class="loading_text" id="loading_text">Loading full size account pic....</div>
            <div class="loading" id="loading">
                <div class="bullet"></div>
                <div class="bullet"></div>
                <div class="bullet"></div>
                <div class="bullet"></div>
            </div>
            <div id="full_pic_container" class="full_pic_container">
                <div class="close_button">Click anywhere on the above screen to close the pic, <a href="/account/pic/full/size/?sqq=${crypto.encodeURL(userSQQ)}">view full size</a></div>
            </div>
        </div>
        <script>
            var URLParser = function (url) {
                this.url = url || window.location.href;
                this.urlObject = this.parse();
            };

            URLParser.prototype = {
                constructor: URLParser,
                parse: function (url) {
                    var tempArr,
                            item,
                            i,
                            returnObj = {};
                    this.url = url || this.url;
                    tempArr = this.url.split("?");
                    returnObj.baseURL = tempArr[0];
                    returnObj.params = {};
                    if (tempArr.length > 1) {
                        returnObj.queryString = tempArr[1];
                        tempArr = tempArr[1].split("&");
                        for (i = 0; i < tempArr.length; i++) {
                            item = tempArr[i].split("=");
                            returnObj.params[item[0]] = item[1];
                        }
                    } else {
                        returnObj.queryString = "";
                    }

                    return returnObj;
                }
            };

            var up = new URLParser();
            var urlObj, am__ad = agt("gdd_h_id");

            if ((null !== am__ad))
                urlObj = up.parse(am__ad.src);


            if (null !== agt("info_pic"))
                agt("info_pic").addEventListener("mouseover", function () {
                    gt();
                });

            function gt() {
                window.document.body.style.overflow = "hidden";
                if (agt("info_full_pic") === null) {
                    var oImg = window.document.createElement("img");
                    oImg.setAttribute("src", "/account/pic/full/size/?sqq=" + urlObj.params["sqq"]);
                    oImg.setAttribute("class", "info_full_pic");
                    oImg.setAttribute("id", "info_full_pic");
                    agt("full_pic_container").appendChild(oImg);
                }
                agt("wrapper").classList.remove("animate_in");
                agt("slide_layout").className += " animate_in";
                agt("wrapper").className += " animate_out";

                if (agt("info_full_pic") !== null) {

                    agt("info_full_pic").addEventListener("load", function () {
                        agt("loading").className += " animate_out";
                        agt("loading_text").className += " animate_out";


                    });


                }
            }


            agt("full_pic_container").addEventListener("click", function () {
                window.document.body.style.overflow = "auto";
                agt("slide_layout").classList.remove("animate_in");
                agt("wrapper").classList.remove("animate_out");
                agt("wrapper").className += " animate_in";
            });


            function agt(a) {
                return window.document.getElementById(a);
            }
        </script>
        <script type="text/javascript" src="/rele/js/GYhdUdJiI.js"></script>
    </body>
</html>
