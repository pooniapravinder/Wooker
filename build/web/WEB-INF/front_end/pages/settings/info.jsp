<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%><%@taglib uri="http://www.springframework.org/tags" prefix="spring"%><%@page contentType="text/html" pageEncoding="UTF-8"%><%@page session="false"%><!DOCTYPE html>
<html lang="en-US" id="wooker">
    <head>
        <meta name="keywords" content="Change Settings of your Primary Info">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
        <meta name="theme-color" content="#663399">
        <link rel="shortcut icon" href="//www.google.com/favicon.ico"/>
        <meta name="description" content="Change Primary Info Settings">
        <meta name="google" content="notranslate">
        <title>Primary Info - Settings</title>
        <link rel="stylesheet" type="text/css" href="/rele/css/styleone.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/styletwo.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/stylethree.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/stylefour.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/IoDJnmdJdDE.css">
    </head>
    <body>
        <div class="slide_layout" id="slide_layout"><div class="loading_text">Updating primary info settings....</div>
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
                <h1>Primary Info Settings</h1>
                <div class="a__option">
                    <div class="a__option__a">
                        <a href="/info/">Primary Info</a>
                    </div>
                    <div class="a__option__b">
                        <a href="/more/info/">Secondary Info</a>
                    </div>
                    <div class="restore_default"><a href="/info/options/restore/">Restore Default</a></div>
                </div>

                    <form:form name="upinfosettings" class="info-setting-form" modelAttribute="upinfosettings" method="post" action="">
                        <div class="co_box">
                            <form:label path="secInfo" class="contain_checkbox"><form:checkbox path="secInfo" id="secInfo" value="true"/><span class="custom_checkbox"></span>Secondary Info</form:label>
                            </div>
                            <div class="co_box">
                            <form:label path="edPrInfo" class="contain_checkbox"><form:checkbox path="edPrInfo" id="edPrInfo" value="true"/><span class="custom_checkbox"></span>Edit Primary Info</form:label>
                            </div>
                            <div class="co_box">
                            <form:label path="settings" class="contain_checkbox"><form:checkbox path="settings" id="settings" value="true"/><span class="custom_checkbox"></span>Settings</form:label>
                            </div>
                            <div class="co_box">
                            <form:label path="security" class="contain_checkbox"><form:checkbox path="security" id="security" value="true"/><span class="custom_checkbox"></span>Security</form:label>
                            </div>
                            <div class="co_box">
                            <form:label path="accPic" class="contain_checkbox"><form:checkbox path="accPic" id="accPic" value="true"/><span class="custom_checkbox"></span>Account Pic</form:label>
                            </div>
                            <div class="co_box">
                            <form:label path="edAccPic" class="contain_checkbox"><form:checkbox path="edAccPic" id="edAccPic" value="true"/><span class="custom_checkbox"></span>Edit Account Pic</form:label>
                            </div>
                            <div class="co_box">
                            <form:label path="upNew" class="contain_checkbox"><form:checkbox path="upNew" id="upNew" value="true"/><span class="custom_checkbox"></span>Upload New</form:label>
                            </div>
                            <div class="co_box">
                            <form:label path="disName" class="contain_checkbox"><form:checkbox path="disName" id="disName" value="true"/><span class="custom_checkbox"></span>Display Name</form:label>
                            </div>
                            <div class="co_box">
                            <form:label path="firName" class="contain_checkbox"><form:checkbox path="firName" id="firName" value="true"/><span class="custom_checkbox"></span>First Name</form:label>
                            </div>
                            <div class="co_box">
                            <form:label path="lasName" class="contain_checkbox"><form:checkbox path="lasName" id="lasName" value="true"/><span class="custom_checkbox"></span>Last Name</form:label>
                            </div>
                            <div class="co_box">
                            <form:label path="nicName" class="contain_checkbox"><form:checkbox path="nicName" id="nicName" value="true"/><span class="custom_checkbox"></span>Nick Name</form:label>
                            </div>
                            <div class="co_box">
                            <form:label path="gender" class="contain_checkbox"><form:checkbox path="gender" id="gender" value="true"/><span class="custom_checkbox"></span>Gender</form:label>
                            </div>
                            <div class="co_box">
                            <form:label path="birthDay" class="contain_checkbox"><form:checkbox path="birthDay" id="birthDay" value="true"/><span class="custom_checkbox"></span>Birthday</form:label>
                            </div>
                            <div class="co_box">
                            <form:label path="age" class="contain_checkbox"><form:checkbox path="age" id="age" value="true"/><span class="custom_checkbox"></span>Age</form:label>
                            </div>
                            <div class="co_box">
                            <form:label path="account" class="contain_checkbox"><form:checkbox path="account" id="account" value="true"/><span class="custom_checkbox"></span>Account</form:label>
                            </div>
                            <div class="co_a_box"><form:label path="showHide" class="contain_checkbox"><form:checkbox path="showHide" id="showHide" value="true"/><span class="custom_checkbox"></span>Show hide options in the page.</form:label>
                            </div>
                            <form:button name="updateStngs" id="updateStngs" class="form_pic_button" value="submit">Update</form:button>
                    </form:form>
            </div>
            </div>
        </div>
        <script>
            if (null !== h("upinfosettings"))
                h("upinfosettings").addEventListener("submit", function () {
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
