<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%><%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%><%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@taglib uri="http://www.springframework.org/tags" prefix="spring"%><%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%><%@page contentType="text/html" pageEncoding="UTF-8"%><%@page session="false"%><!DOCTYPE html>
<html lang="en-US" id="wooker">
    <head><c:set var="requestURI" value="${requestScope['javax.servlet.forward.request_uri']}"/>
        <meta name="keywords" content="Add your Post Graduate College">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
        <meta name="theme-color" content="#663399">
        <link rel="shortcut icon" href="//www.google.com/favicon.ico"/>
        <meta name="description" content="Add your Post Graduate College">
        <meta name="google" content="notranslate">
        <title><c:choose><c:when test="${requestURI.contains('edit')}">Edit</c:when><c:otherwise>Add</c:otherwise></c:choose> Post Graduate College</title>
        <link rel="stylesheet" type="text/css" href="/rele/css/styleone.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/styletwo.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/dsEtFcDWRfdd.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/JuiLOdOpp.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/IoDJnmdJdDE.css">
    </head>
    <body>
        <div class="slide_layout" id="slide_layout"><div class="loading_text"><c:choose><c:when test="${requestURI.contains('edit')}">Updating</c:when><c:otherwise>Saving</c:otherwise></c:choose> post graduate college....</div>
            <div class="loading">
                <div class="bullet"></div>
                <div class="bullet"></div>
                <div class="bullet"></div>
                <div class="bullet"></div>
            </div>
        </div>
            <%@include file="../../header.jsp"%>
        <div class="wrapper animate_in" id="wrapper">
            <div class="info_page main clearfix" id="web_view">
            <div class="content">
                <h2><c:choose><c:when test="${requestURI.contains('edit')}">Edit</c:when><c:otherwise>Add</c:otherwise></c:choose> Post Graduate College</h2>
                <div class="upp_ss_elem">
                    <div class="options_position"><a href="/info/">Primary Info</a></div>
                    <div class="options_position"><a href="/more/info/">Secondary Info</a></div>
                </div>
                <form:form method="post" name="addpogrcoll" class="cfd__ds" modelAttribute="addpogrcoll" action="" enctype="multipart/form-data">
                    <fmt:formatDate var="currentYear" value="${now}" pattern="yyyy" />
                    <form:errors path="PogrCoenYear" class="add-errors"/>
                    <div class="form-element-fgrc">
                        <form:input path="pogrColl" id="pogrColl" class="info_input_box" autocorrect="off" autocomplete="off" spellcheck="false" required="true"/>
                        <form:label path="pogrColl"><spring:message code="editmoreinfo.label.addpogradcoll"/></form:label>
                            <span class="focus-border"></span>
                        </div>
                    <form:errors path="pogrColl" class="add-errors"/>
                            
                        <div class="form-element-ghtrr">
                        <form:label path="pogrCollPri">Privacy:</form:label>
                        </div>
                        <div class="form-element-erta">
                            <div class="custom-select"><form:select path="pogrCollPri" id="pogrCollPri" class="custom-select-box"><c:forEach var="i" begin="1" end="6"><form:option value="${i}"><spring:message code="userprivacy.label.0${i}"/></form:option></c:forEach></form:select></div>
                        </div>

                        <div class="form-element-ghtrr">
                        <form:label path="PogrCoenMonth">Entrance:</form:label>
                        </div>

                        <div class="form-element-erta">
                            <div class="custom-select custom-select-birmon"><form:select path="PogrCoenMonth" id="PogrCoenMonth" class="custom-select-box month"><form:option value=""><spring:message code="label.month.select"/></form:option><c:forEach var="i" begin="1" end="9"><form:option value="0${i}"><spring:message code="label.month.0${i}"/></form:option></c:forEach><c:forEach var="i" begin="10" end="12"><form:option value="${i}"><spring:message code="label.month.${i}"/></form:option></c:forEach></form:select></div>
                        <div class="custom-select custom-select-birdate"><form:select path="PogrCoenDate" id="PogrCoenDate" class="custom-select-box date"><form:option value=""><spring:message code="label.date.select"/></form:option><c:forEach var="i" begin="1" end="9"><form:option value="0${i}">0${i}</form:option></c:forEach><c:forEach var="i" begin="10" end="31"><form:option value="${i}">${i}</form:option></c:forEach></form:select></div>
                        <div class="custom-select custom-select-year"><form:select path="PogrCoenYear" id="PogrCoenYear" class="custom-select-box year"><form:option value=""><spring:message code="label.year.select"/></form:option><c:forEach var="i" begin="0" end="115"><form:option value="${currentYear+10-i}">${currentYear+10-i}</form:option></c:forEach></form:select></div>
                            </div>

                            <div class="form-element-ghtrr">
                        <form:label path="PogrColeMonth">Leave:</form:label>
                        </div>

                        <div class="form-element-erta">
                            <div class="custom-select custom-select-birmon"><form:select path="PogrColeMonth" id="PogrColeMonth" class="custom-select-box month"><form:option value=""><spring:message code="label.month.select"/></form:option><c:forEach var="i" begin="1" end="9"><form:option value="0${i}"><spring:message code="label.month.0${i}"/></form:option></c:forEach><c:forEach var="i" begin="10" end="12"><form:option value="${i}"><spring:message code="label.month.${i}"/></form:option></c:forEach></form:select></div>
                        <div class="custom-select custom-select-birdate"><form:select path="PogrColeDate" id="PogrColeDate" class="custom-select-box date"><form:option value=""><spring:message code="label.date.select"/></form:option><c:forEach var="i" begin="1" end="9"><form:option value="0${i}">0${i}</form:option></c:forEach><c:forEach var="i" begin="10" end="31"><form:option value="${i}">${i}</form:option></c:forEach></form:select></div>
                        <div class="custom-select custom-select-year"><form:select path="PogrColeYear" id="PogrColeYear" class="custom-select-box year"><form:option value=""><spring:message code="label.year.select"/></form:option><c:forEach var="i" begin="0" end="115"><form:option value="${currentYear+10-i}">${currentYear+10-i}</form:option></c:forEach></form:select></div>
                            </div>

                            <div class="form-element-ghtrr">
                        <form:label path="pogrCoPic"><spring:message code="editmoreinfo.label.pogradcollpic"/>:</form:label>
                        </div>
                        <div class="fght_fdg_ss">
                            Choose<form:input path="pogrCoPic" id="pogrCoPic" type="file" accept="image/*" class="erf_a" autocorrect="off" autocomplete="off" spellcheck="false"/>
                    </div>
                    <form:errors path="pogrCoPic" class="add-errors"/>

                    <div class="form-element-fgrc">
                        <form:input path="pogrCoDesc" id="pogrCoDesc" class="info_input_box" autocorrect="off" autocomplete="off" spellcheck="false"/>
                        <form:label path="pogrCoDesc"><spring:message code="editmoreinfo.label.pogradcolldesc"/></form:label>
                            <span class="focus-border"></span>
                        </div>
                    <form:errors path="pogrCoDesc" class="add-errors"/>

                    <div class="form-element-vbh">
                    <form:label path="pogrCoPri" class="contain_checkbox edit_pic_opt"><form:checkbox path="pogrCoPri" id="pogrCoPri" value="true"/><span class="custom_checkbox"></span>Also set this for privacy</form:label>
                    </div>
                    <c:choose><c:when test="${requestURI.contains('edit')}"><form:button name="update" id="update" class="form_pic_button" value="submit"><spring:message code="editmoreinfo.label.update"/></form:button></c:when><c:otherwise><form:button name="add" id="add" class="form_pic_button" value="submit"><spring:message code="editmoreinfo.label.save"/></form:button></c:otherwise></c:choose>
                </form:form>
            </div>
            </div>
        </div>
        <script>
            if (null !== h("addpogrcoll"))
                h("addpogrcoll").addEventListener("submit", function () {
                    as__bnm();
                });

            function as__bnm() {
                h("wrapper").className += " animate_out";
                if (null !== h("add")) h("add").innerHTML = "Saving....";
                if (null !== h("update")) h("update").innerHTML = "Updating....";
                h("slide_layout").className += " animate_in";
            }
            function h(a) {
                return window.document.getElementById(a);
            }
        </script>
        <script type="text/javascript" src="/rele/js/GYhdUdJiI.js"></script>
    </body>
</html>
