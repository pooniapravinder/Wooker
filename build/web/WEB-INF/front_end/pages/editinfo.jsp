<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%><%@taglib uri="http://www.springframework.org/tags" prefix="spring"%><%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%><%@page contentType="text/html" pageEncoding="UTF-8"%><%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@page session="false"%><!DOCTYPE html>
<html lang="en-US" id="wooker">
    <head>
        <meta name="keywords" content="Edit your Primary Info">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
        <meta name="theme-color" content="#663399">
        <link rel="shortcut icon" href="//www.google.com/favicon.ico"/>
        <meta name="description" content="Edit your Primary Info">
        <meta name="google" content="notranslate">
        <title>Edit Primary Info</title>
        <link rel="stylesheet" type="text/css" href="/rele/css/styleone.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/styletwo.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/stylethree.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/JuiLOdOpp.css">
    </head>
    <body>
        <div class="slide_layout" id="slide_layout"><div class="loading_text">Updating primary info....</div>
            <div class="loading">
                <div class="bullet"></div>
                <div class="bullet"></div>
                <div class="bullet"></div>
                <div class="bullet"></div>
            </div>
        </div>
            <%@include file="header.jsp"%>
        <div class="wrapper animate_in" id="wrapper">
            <div class="info_page main clearfix" id="web_view">
                <div class="content">
                <h1>Edit Primary Info</h1>
                <jsp:useBean id="getOptions" class="hibernate.query.info.ShowHideInfoOpt"/>
                <c:set var="options" value="${getOptions.getEditInfoOptions(user)}"/>

                <div class="upp_ss_elem">
                    <c:if test="${(options==null)||(options.info)}"><div class="options_position"><a href="/info/">Primary Info</a></div></c:if><c:if test="${(options==null)||(options.moreinfo)}"><div class="options_position"><a href="/more/info/">Secondary Info</a></div></c:if><c:if test="${(options==null)||(options.setting)}"><div class="options_position"><a href="/info/edit/settings/">Settings</a></div></c:if><c:if test="${(options==null)||(options.security)}"><div class="options_position"><a href="/info/edit/security/">Security</a></div></c:if>
                    </div>

                <jsp:useBean id="CalTime" class="timeperiod.duration.calculation.CalculateTime"/>
                <c:set var="getTime" value="${CalTime.saveDateTime(editinfo.timestampVal)}"/>
                <c:if test="${(options==null)||(options.lastsaved)}">
                    <div class="last_change"><strong>Last Changed: </strong><spring:message code="label.day.0${CalTime.day}"/> <c:if test="${CalTime.month<=9}"><spring:message code="label.month.0${CalTime.month}"/></c:if><c:if test="${CalTime.month>9}"><spring:message code="label.month.${CalTime.month}"/></c:if> ${CalTime.date},${CalTime.year} ${CalTime.time}</div>
                </c:if>
                <c:if test="${options==null||options.firstname||options.lastname||options.nickname||options.gender||options.birthday||options.age||options.accounttype}">
                    <form:form method="post" name="editinfo" modelAttribute="editinfo" action="">
                        <c:if test="${(options==null)||(options.firstname)}">
                            <div class="form-element-input">
                                <form:input path="firstName" id="firstName" class="info_input_box" autocorrect="off" autocomplete="off" spellcheck="false" required="true"/>
                                <form:label path="firstName"><spring:message code="label.firstname"/></form:label>
                                <span class="focus-border"></span><c:if test="${(options==null)||(options.showhide)}"><a href="/info/edit/hide/firstname/">Hide</a></c:if>
                                </div>
                            <form:errors path="firstName" class="editinfo-head-errors"/>
                        </c:if>

                        <c:if test="${(options==null)||(options.lastname)}">
                            <div class="form-element-input">
                                <form:input path="lastName" id="lastName" class="info_input_box" autocorrect="off" autocomplete="off" spellcheck="false"/>
                                <form:label path="lastName"><spring:message code="label.lastname"/></form:label>
                                <span class="focus-border"></span><c:if test="${(options==null)||(options.showhide)}"><a href="/info/edit/hide/lastname/">Hide</a></c:if>
                                </div>
                            <form:errors path="lastName" class="editinfo-head-errors"/>
                        </c:if>

                        <c:if test="${(options==null)||(options.nickname)}">
                            <div class="form-element-input nickname_box">
                                <form:input path="nickName" id="nickName" class="info_input_box" autocorrect="off" autocomplete="off" spellcheck="false"/>
                                <form:label path="nickName">Nickname</form:label>
                                    <span class="focus-border"></span>
                                    <div class="custom-select custom-select-combina"><form:select path="combination" id="combination" class="custom-select-box"><form:option value="1">()</form:option><form:option value="2">[]</form:option><form:option value="3">{}</form:option></form:select></div>
                                <div class="custom-select"><form:select path="nickPrivacy" id="nickPrivacy" class="custom-select-box"><c:forEach var="i" begin="1" end="6"><form:option value="${i}"><spring:message code="userprivacy.label.0${i}"/></form:option></c:forEach></form:select></div>
                                <c:if test="${(options==null)||(options.showhide)}"><a href="/info/edit/hide/nickname/">Hide</a></c:if></div>
                                <form:errors path="nickName" class="editinfo-head-errors"/>
                            </c:if>

                        <c:if test="${(options==null)||(options.gender)}">
                            <div class="form-element">
                                <form:label path="gender"><strong><spring:message code="label.gender"/>:</strong></form:label>
                                <div class="custom-select custom-select-gend"><form:select path="gender" id="gender" class="custom-select-box"><form:option value="Male"><spring:message code="label.gender.male"/></form:option><form:option value="Female"><spring:message code="label.gender.female"/></form:option><form:option value="Other"><spring:message code="label.gender.other"/></form:option></form:select></div>
                                <div class="custom-select"><form:select path="genPrivacy" id="genPrivacy" class="custom-select-box"><c:forEach var="i" begin="1" end="6"><form:option value="${i}"><spring:message code="userprivacy.label.0${i}"/></form:option></c:forEach></form:select></div>
                                <c:if test="${(options==null)||(options.showhide)}"><a href="/info/edit/hide/gender/">Hide</a></c:if>
                                </div>
                            <form:errors path="gender" class="editinfo-errors"/>
                        </c:if>

                        <fmt:formatDate var="currentYear" value="${now}" pattern="yyyy" />

                        <c:if test="${(options==null)||(options.birthday)}">
                            <div class="form-element">
                                <form:label path="birthMonth"><strong><spring:message code="label.birthday"/>:</strong></form:label>
                                <div class="custom-select custom-select-birmon"><form:select path="birthMonth" id="birthMonth" class="custom-select-box month"><c:forEach var="i" begin="1" end="9"><form:option value="0${i}"><spring:message code="label.month.0${i}"/></form:option></c:forEach><c:forEach var="i" begin="10" end="12"><form:option value="${i}"><spring:message code="label.month.${i}"/></form:option></c:forEach></form:select></div>
                                <div class="custom-select custom-select-birdate"><form:select path="birthDate" id="birthDate" class="custom-select-box date"><c:forEach var="i" begin="1" end="9"><form:option value="0${i}">0${i}</form:option></c:forEach><c:forEach var="i" begin="10" end="31"><form:option value="${i}">${i}</form:option></c:forEach></form:select></div>
                                <div class="custom-select custom-select-year"><form:select path="birthYear" id="birthYear" class="custom-select-box year"><c:forEach var="i" begin="0" end="115"><form:option value="${currentYear-i}">${currentYear-i}</form:option></c:forEach></form:select></div>
                                <c:if test="${(options==null)||(options.showhide)}"><a href="/info/edit/hide/birthday/">Hide</a></c:if>
                                    <div class="form-privacy">
                                        <div class="custom-select"><form:select path="monthPrivacy" id="monthPrivacy" class="custom-select-box"><c:forEach var="i" begin="1" end="6"><form:option value="${i}"><spring:message code="userprivacy.label.0${i}"/></form:option></c:forEach></form:select></div>
                                    <div class="custom-select"><form:select path="datePrivacy" id="datePrivacy" class="custom-select-box"><c:forEach var="i" begin="1" end="6"><form:option value="${i}"><spring:message code="userprivacy.label.0${i}"/></form:option></c:forEach></form:select></div>
                                    <div class="custom-select"><form:select path="yearPrivacy" id="yearPrivacy" class="custom-select-box"><c:forEach var="i" begin="1" end="6"><form:option value="${i}"><spring:message code="userprivacy.label.0${i}"/></form:option></c:forEach></form:select></div>
                                            </div></div>
                                <form:errors path="birthMonth" class="editinfo-errors"/>
                                <form:errors path="birthDate" class="editinfo-errors"/>
                                <form:errors path="birthYear" class="editinfo-errors"/>
                            </c:if>

                        <c:if test="${(options==null)||(options.age)}">
                            <div class="form-element">
                                <strong>Age:</strong><div class="form-age">${currentYear-editinfo.birthYear}</div>
                                <div class="custom-select"><form:select path="agePrivacy" id="agePrivacy" class="custom-select-box"><c:forEach var="i" begin="1" end="6"><form:option value="${i}"><spring:message code="userprivacy.label.0${i}"/></form:option></c:forEach></form:select></div>
                                <c:if test="${(options==null)||(options.showhide)}"><a href="/info/edit/hide/age/">Hide</a></c:if>
                                </div>
                        </c:if>

                        <c:if test="${(options==null)||(options.accounttype)}">
                            <div class="form-element">
                                <strong>Account:</strong><div class="form-acctype">${editinfo.accountType}</div>
                                <div class="custom-select"><form:select path="accPrivacy" id="accPrivacy" class="custom-select-box"><c:forEach var="i" begin="1" end="6"><form:option value="${i}"><spring:message code="userprivacy.label.0${i}"/></form:option></c:forEach></form:select></div>
                                <c:if test="${(options==null)||(options.showhide)}"><a href="/info/edit/hide/acctype/">Hide</a></c:if>
                                </div>
                        </c:if>
                        <c:if test="${options==null||options.firstname||options.lastname||options.nickname||options.gender||options.birthday}">
                            <p><c:if test="${editinfo.exceedUpdate}"><spring:message code="user.exceedtime.error" arguments="${editinfo.exceedTime}"/></c:if>
                                <c:if test="${!editinfo.exceedUpdate}"><spring:message code="user.exceedupdate.error" arguments="${editinfo.exceedTime}"/></c:if> <a href="/wooker/learn/more/568956/">Learn more</a></p>
                            </c:if>
                            <form:button name="update" id="update" class="form_pic_button" value="submit">Update</form:button>
                    </form:form>
                </c:if>
            </div>
            </div>
        </div>
        <script>
            if (null !== h("editinfo"))
                h("editinfo").addEventListener("submit", function () {
                    as__bnm();
                });

            function as__bnm() {
                h("wrapper").className += " animate_out";
                h("update").innerHTML = "Updating....";
                h("slide_layout").className += " animate_in";
            }
            function h(a) {
                return window.document.getElementById(a);
            }
        </script>
        <script type="text/javascript" src="/rele/js/GYhdUdJiI.js"></script>
    </body>
</html>
