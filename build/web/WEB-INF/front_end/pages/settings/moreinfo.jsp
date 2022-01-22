<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%><%@taglib uri="http://www.springframework.org/tags" prefix="spring"%><%@page contentType="text/html" pageEncoding="UTF-8"%><%@page session="false"%><!DOCTYPE html>
<html lang="en-US" id="wooker">
    <head><c:set var="requestURI" value="${requestScope['javax.servlet.forward.request_uri']}"/>
        <meta name="keywords" content="Change Settings of your Secondary Info">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
        <meta name="theme-color" content="#663399">
        <link rel="shortcut icon" href="//www.google.com/favicon.ico"/>
        <meta name="description" content="Change Secondary Info Settings">
        <meta name="google" content="notranslate">
        <title><c:if test="${requestURI.contains('add')}">Add </c:if>Secondary Info - Settings</title>
            <link rel="stylesheet" type="text/css" href="/rele/css/styleone.css">
            <link rel="stylesheet" type="text/css" href="/rele/css/styletwo.css">
            <link rel="stylesheet" type="text/css" href="/rele/css/stylethree.css">
            <link rel="stylesheet" type="text/css" href="/rele/css/stylefour.css">
            <link rel="stylesheet" type="text/css" href="/rele/css/IoDJnmdJdDE.css">
        </head>
        <body>
            <div class="slide_layout" id="slide_layout"><div class="loading_text">Updating <c:if test="${requestURI.contains('add')}">add </c:if>secondary info settings....</div>
                <div class="loading">
                    <div class="bullet"></div>
                    <div class="bullet"></div>
                    <div class="bullet"></div>
                    <div class="bullet"></div>
                </div>
            </div>
            <%@include file="../header.jsp"%>
            <div class="wrapper animate_in" id="wrapper">
            <div class="info_page main clearfix" id="web_view">
            <div class="content">
                <c:choose><c:when test="${requestURI.contains('add')}"><h2>Add Secondary Info Settings</h2></c:when><c:otherwise><h1>Secondary Info Settings</h1></c:otherwise></c:choose>
                        <div class="a__option">
                            <div class="a__option__a">
                                <a href="/info/">Primary Info</a>
                            </div>
                            <div class="a__option__b">
                                <a href="/more/info/">Secondary Info</a>
                            </div>
                            <div class="restore_default"><c:choose><c:when test="${requestURI.contains('add')}"><a href="/more/info/add/options/restore/">Restore Default</a></c:when><c:otherwise><a href="/more/info/options/restore/">Restore Default</a></c:otherwise></c:choose></div>
                        </div>

                <form:form name="upmoinsettings" class="info-setting-form" modelAttribute="upmoinsettings" method="post" action="">
                    <div class="co_box">
                        <form:label path="info" class="contain_checkbox"><form:checkbox path="info" id="info" value="true"/><span class="custom_checkbox"></span>Primary Info</form:label>
                        </div>
                    <c:choose><c:when test="${requestURI.contains('add')}">
                            <div class="co_box">
                                <form:label path="moreInfo" class="contain_checkbox"><form:checkbox path="moreInfo" id="moreInfo" value="true"/><span class="custom_checkbox"></span>Secondary Info</form:label>
                                </div>
                        </c:when>
                        <c:otherwise>
                            <div class="co_box">
                                <form:label path="addmoInfo" class="contain_checkbox"><form:checkbox path="addmoInfo" id="addmoInfo" value="true"/><span class="custom_checkbox"></span>Add Secondary Info</form:label>
                                </div>
                        </c:otherwise></c:choose>

                        <div class="co_box">
                        <form:label path="settings" class="contain_checkbox"><form:checkbox path="settings" id="settings" value="true"/><span class="custom_checkbox"></span>Settings</form:label>
                        </div>
                        <div class="co_box">
                        <form:label path="security" class="contain_checkbox"><form:checkbox path="security" id="security" value="true"/><span class="custom_checkbox"></span>Security</form:label>
                        </div>
                        <div class="co_box">
                        <form:label path="school" class="contain_checkbox"><form:checkbox path="school" id="school" value="true"/><span class="custom_checkbox"></span>School</form:label>
                        </div>
                        <div class="co_box">
                        <form:label path="grcollege" class="contain_checkbox"><form:checkbox path="grcollege" id="grcollege" value="true"/><span class="custom_checkbox"></span>Graduate College</form:label>
                        </div>
                        <div class="co_box">
                        <form:label path="gruniver" class="contain_checkbox"><form:checkbox path="gruniver" id="gruniver" value="true"/><span class="custom_checkbox"></span>Graduate University</form:label>
                        </div>
                        <div class="co_box">
                        <form:label path="pogrcoll" class="contain_checkbox"><form:checkbox path="pogrcoll" id="pogrcoll" value="true"/><span class="custom_checkbox"></span>Post Graduate College</form:label>
                        </div>
                        <div class="co_box">
                        <form:label path="pogruniver" class="contain_checkbox"><form:checkbox path="pogruniver" id="pogruniver" value="true"/><span class="custom_checkbox"></span>Post Graduate University</form:label>
                        </div>
                        <div class="co_box">
                        <form:label path="work" class="contain_checkbox"><form:checkbox path="work" id="work" value="true"/><span class="custom_checkbox"></span>Work</form:label>
                        </div>
                        <div class="co_box">
                        <form:label path="location" class="contain_checkbox"><form:checkbox path="location" id="location" value="true"/><span class="custom_checkbox"></span>Location</form:label>
                        </div>
                        <div class="co_box">
                        <form:label path="moved" class="contain_checkbox"><form:checkbox path="moved" id="moved" value="true"/><span class="custom_checkbox"></span>Moved</form:label>
                        </div>
                        <div class="co_box">
                        <form:label path="mobile" class="contain_checkbox"><form:checkbox path="mobile" id="mobile" value="true"/><span class="custom_checkbox"></span>Mobile</form:label>
                        </div>
                        <div class="co_box">
                        <form:label path="email" class="contain_checkbox"><form:checkbox path="email" id="email" value="true"/><span class="custom_checkbox"></span>Email</form:label>
                        </div>
                        <div class="co_box">
                        <form:label path="website" class="contain_checkbox"><form:checkbox path="website" id="website" value="true"/><span class="custom_checkbox"></span>Website</form:label>
                        </div>
                        <div class="co_box">
                        <form:label path="hobbies" class="contain_checkbox"><form:checkbox path="hobbies" id="hobbies" value="true"/><span class="custom_checkbox"></span>Hobbies</form:label>
                        </div>
                        <div class="co_box">
                        <form:label path="relationship" class="contain_checkbox"><form:checkbox path="relationship" id="relationship" value="true"/><span class="custom_checkbox"></span>Relationship</form:label>
                        </div>
                        <div class="co_box">
                        <form:label path="relation" class="contain_checkbox"><form:checkbox path="relation" id="relation" value="true"/><span class="custom_checkbox"></span>Relation</form:label>
                        </div>
                        <div class="co_box">
                        <form:label path="languages" class="contain_checkbox"><form:checkbox path="languages" id="languages" value="true"/><span class="custom_checkbox"></span>Languages</form:label>
                        </div>
                        <div class="co_box">
                        <form:label path="religion" class="contain_checkbox"><form:checkbox path="religion" id="religion" value="true"/><span class="custom_checkbox"></span>Religion</form:label>
                        </div>
                        <div class="co_box">
                        <form:label path="behaviour" class="contain_checkbox"><form:checkbox path="behaviour" id="behaviour" value="true"/><span class="custom_checkbox"></span>Behaviour</form:label>
                        </div>
                        <div class="co_box">
                        <form:label path="myself" class="contain_checkbox"><form:checkbox path="myself" id="myself" value="true"/><span class="custom_checkbox"></span>Myself</form:label>
                        </div>
                        <div class="co_box">
                        <form:label path="newcateg" class="contain_checkbox"><form:checkbox path="newcateg" id="newcateg" value="true"/><span class="custom_checkbox"></span>New Category</form:label>
                        </div>
                    <c:if test="${requestURI.contains('add')}">
                        <div class="co_a_box"><form:label path="showHide" class="contain_checkbox"><form:checkbox path="showHide" id="showHide" value="true"/><span class="custom_checkbox"></span>Show hide options in the page.</form:label>
                            </div>
                    </c:if>
                    <form:button name="updateStngs" id="updateStngs" class="form_pic_button" value="submit">Update</form:button>
                </form:form>
        </div>
            </div>
        </div>
        <script>
            if (null !== h("upmoinsettings"))
                h("upmoinsettings").addEventListener("submit", function () {
                    as__bnm();
                });

            function as__bnm() {
                h("wrapper").className += " animate_out";
                h("updateStngs").innerHTML = "Updating....";
                h("slide_layout").className += " animate_in";
            }
            function h(a) {
                return window.document.getElementById(a);
            }
        </script>
        <script type="text/javascript" src="/rele/js/GYhdUdJiI.js"></script>
    </body>
</html>
