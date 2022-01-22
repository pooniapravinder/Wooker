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
            <div class="info_page main clearfix" id="web_view">
                <div class="content">
                <h1>Primary Info</h1>
                <jsp:useBean id="getOptions" class="hibernate.query.info.ShowHideInfoOpt"/>
                <c:set var="options" value="${getOptions.getInfoOptions(user)}"/>
                <div class="upp_ss_elem">
                    <c:if test="${(options==null)||(options.moreinfo)}"><div class="options_position"><a href="/more/info/">Secondary Info</a></div></c:if><c:if test="${(options==null)||(options.editinfo)}"><div class="options_position"><a href="/info/edit/">Edit Primary Info</a></div></c:if><c:if test="${(options==null)||(options.setting)}"><div class="options_position"><a href="/info/settings/">Settings</a></div></c:if><c:if test="${(options==null)||(options.security)}"><div class="options_position"><a href="/info/security/">Security</a></div></c:if>
                    </div>

                <c:if test="${(options==null)||(options.uploadnew)}"><div class="edit_pic_other_options"><a href="/account/pic/upload/new/">Upload New</a></div></c:if>
                <c:if test="${((options==null)||(options.edaccpic))&&(sqq!=null)}">
                    <div class="edit_pic_other_options"><a href="/account/pic/edit/?sqq=${crypto.encodeURL(sqq)}">Edit Account Pic</a></div>
                </c:if>
                <c:if test="${(options==null)||(options.accpic)}">
                    <c:choose>
                        <c:when test="${sqq!=null}">
                            <div class="ih-item circle">
                                <div class="img" id="info_pic"><img src="/account/pic/show/a3/?sqq=${crypto.encodeURL(sqq)}" id="gdd_h_id"></div>
                            </div>
                        </c:when>
                        <c:otherwise>

                            <div class="ih-item circle">
                                <a href="/account/pic/upload/new/"><div class="img"><img src="/account/pic/show/user/default/a3/"></div></a>
                            </div>
                        </c:otherwise>
                    </c:choose>

                    <c:if test="${(options==null)||(options.showhide)}">
                        <div class="edit_pic_options">
                            <a href="/info/hide/accpic/">Hide</a>
                        </div></c:if></c:if>
                        <div class="table">
                    <c:if test="${(options==null)||(options.displayname)}">
                        <strong>Display Name:</strong><div class="col info_pos">
                            ${userDetails.firstName}<c:if test="${!(userDetails.lastName).isEmpty()}"> ${userDetails.lastName}</c:if>
                            <c:if test="${!(userDetails.nickName).isEmpty()}">
                                <c:if test="${userDetails.nicknameCombination==1}"> (${userDetails.nickName})</c:if>
                                <c:if test="${userDetails.nicknameCombination==2}"> [${userDetails.nickName}]</c:if>
                                <c:if test="${userDetails.nicknameCombination==3}"> {${userDetails.nickName}}</c:if>
                            </c:if> (<spring:message code="userprivacy.label.03"/>)<c:if test="${(options==null)||(options.showhide)}"><a href="/info/hide/displayname/">Hide</a></c:if></div>
                        </c:if>
                        <c:if test="${(options==null)||(options.firstname)}">
                        <strong>First Name:</strong><div class="col info_pos">${userDetails.firstName} (<spring:message code="userprivacy.label.03"/>)<c:if test="${(options==null)||(options.showhide)}"><a href="/info/hide/firstname/">Hide</a></c:if></div>
                    </c:if>
                    <c:if test="${(options==null)||(options.lastname)}">
                        <strong>Last Name:</strong><div class="col info_pos">${userDetails.lastName} (<spring:message code="userprivacy.label.03"/>)<c:if test="${(options==null)||(options.showhide)}"><a href="/info/hide/lastname/">Hide</a></c:if></div>
                    </c:if>
                    <c:if test="${((options==null)||(options.nickname))&&(!(userDetails.nickName).isEmpty())}">
                        <strong>Nick Name:</strong><div class="col info_pos">${userDetails.nickName} (<spring:message code="userprivacy.label.0${userDetails.nicknamePrivacy}"/>)<c:if test="${(options==null)||(options.showhide)}"><a href="/info/hide/nickname/">Hide</a></c:if></div>
                    </c:if>
                    <c:if test="${(options==null)||(options.gender)}">
                        <strong>Gender:</strong><div class="col info_pos">${userDetails.gender} (<spring:message code="userprivacy.label.0${userDetails.genderPrivacy}"/>)<c:if test="${(options==null)||(options.showhide)}"><a href="/info/hide/gender/">Hide</a></c:if></div>
                    </c:if>
                    <c:if test="${(options==null)||(options.birthday)}">
                        <strong>Birthday:</strong><div class="col info_pos">
                            <c:set var="birthDay" value="${fn:split(userDetails.birthDay, '/')}" />
                            <spring:message code="label.month.${birthDay[0]}"/> ${birthDay[1]},${birthDay[2]} (<spring:message code="userprivacy.label.0${userDetails.monthPrivacy}"/>,<spring:message code="userprivacy.label.0${userDetails.datePrivacy}"/>,<spring:message code="userprivacy.label.0${userDetails.yearPrivacy}"/>)<c:if test="${(options==null)||(options.showhide)}"><a href="/info/hide/birthday/">Hide</a></c:if></div>
                        </c:if>
                        <c:if test="${(options==null)||(options.age)}">
                        <strong>Age:</strong><div class="col info_pos">
                            <fmt:formatDate var="currentYear" value="${now}" pattern="yyyy" />
                            ${currentYear-birthDay[2]} <spring:message code="primaryinfo.label.years"/> (<spring:message code="userprivacy.label.0${userDetails.agePrivacy}"/>)<c:if test="${(options==null)||(options.showhide)}"><a href="/info/hide/age/">Hide</a></c:if></div>
                        </c:if>
                        <c:if test="${(options==null)||(options.accounttype)}">
                        <strong>Account:</strong><div class="col info_pos">
                            ${userDetails.emailidPhone} (<spring:message code="userprivacy.label.0${userDetails.accountPrivacy}"/>)<c:if test="${(options==null)||(options.showhide)}"><a href="/info/hide/acctype/">Hide</a></c:if></div>
                        </c:if>
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
                <div class="close_button">Click anywhere on the above screen to close the pic, <a href="/account/pic/full/size/?sqq=${crypto.encodeURL(sqq)}">view full size</a></div>
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
