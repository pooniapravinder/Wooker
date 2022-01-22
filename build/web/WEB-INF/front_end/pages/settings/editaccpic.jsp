<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%><%@taglib uri="http://www.springframework.org/tags" prefix="spring"%><%@page contentType="text/html" pageEncoding="UTF-8"%><%@page session="false"%><!DOCTYPE html>
<html lang="en-US" id="wooker">
    <head>
        <meta name="keywords" content="Change Settings of your Edit Account Pic">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
        <meta name="theme-color" content="#663399">
        <link rel="shortcut icon" href="//www.google.com/favicon.ico"/>
        <meta name="description" content="Change Edit Account Pic Settings">
        <meta name="google" content="notranslate">
        <title>Edit Account Pic - Settings</title>
        <link rel="stylesheet" type="text/css" href="/rele/css/styleone.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/styletwo.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/stylethree.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/stylefour.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/IoDJnmdJdDE.css">
    </head>
    <body>
        <div class="slide_layout" id="slide_layout"><div class="loading_text">Updating edit account pic settings....</div>
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
                <h2>Edit Account Pic Settings</h2>
                <div class="a__option">
                    <div class="a__option__a">
                        <a href="/info/">Primary Info</a>
                    </div>
                    <div class="a__option__b">
                        <a href="/more/info/">Secondary Info</a>
                    </div>
                    <div class="restore_default"><a href="/account/pic/edit/options/restore/?sqq=${crypto.encodeURL(param.sqq)}">Restore Default</a></div>
                </div>
                    <form:form name="accpicedsettings" class="info-setting-form" modelAttribute="accpicedsettings" method="post" action="">
                        <div class="co_box">
                            <form:label path="prInfo" class="contain_checkbox"><form:checkbox path="prInfo" id="prInfo" value="true"/><span class="custom_checkbox"></span>Primary Info</form:label>
                            </div><div class="co_box">
                            <form:label path="secInfo" class="contain_checkbox"><form:checkbox path="secInfo" id="secInfo" value="true"/><span class="custom_checkbox"></span>Secondary Info</form:label>
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
                            <form:label path="upNew" class="contain_checkbox"><form:checkbox path="upNew" id="upNew" value="true"/><span class="custom_checkbox"></span>Upload New</form:label>
                            </div>
                            <div class="co_box">
                            <form:label path="remove" class="contain_checkbox"><form:checkbox path="remove" id="remove" value="true"/><span class="custom_checkbox"></span>Remove</form:label>
                            </div>
                            <div class="co_box">
                            <form:label path="delete" class="contain_checkbox"><form:checkbox path="delete" id="delete" value="true"/><span class="custom_checkbox"></span>Delete</form:label>
                            </div>
                            <div class="co_box">
                            <form:label path="download" class="contain_checkbox"><form:checkbox path="download" id="download" value="true"/><span class="custom_checkbox"></span>Download</form:label>
                            </div>
                            <div class="co_box">
                            <form:label path="picTime" class="contain_checkbox"><form:checkbox path="picTime" id="picTime" value="true"/><span class="custom_checkbox"></span>Account Pic Time</form:label>
                            </div>
                            <div class="co_box">
                            <form:label path="like" class="contain_checkbox"><form:checkbox path="like" id="like" value="true"/><span class="custom_checkbox"></span>Like</form:label>
                            </div>
                            <div class="co_box">
                            <form:label path="dislike" class="contain_checkbox"><form:checkbox path="dislike" id="dislike" value="true"/><span class="custom_checkbox"></span>Dislike</form:label>
                            </div>
                            <div class="co_box">
                            <form:label path="talking" class="contain_checkbox"><form:checkbox path="talking" id="talking" value="true"/><span class="custom_checkbox"></span>Talking</form:label>
                            </div>
                            <div class="co_box">
                            <form:label path="comment" class="contain_checkbox"><form:checkbox path="comment" id="comment" value="true"/><span class="custom_checkbox"></span>Comment</form:label>
                            </div>
                            <div class="co_box">
                            <form:label path="share" class="contain_checkbox"><form:checkbox path="share" id="share" value="true"/><span class="custom_checkbox"></span>Share</form:label>
                            </div>
                            <div class="co__privacy__aa">
                                <strong>Privacy:</strong>
                            </div>
                            <div class="co_abx_box co_adada_kk">
                            <form:label path="seePic" class="contain_checkbox"><form:checkbox path="seePic" id="seePic" value="true"/><span class="custom_checkbox"></span>Who can see your account pic</form:label>
                            </div>
                            <div class="co_abx_box co_adada_kk">
                            <form:label path="downloadPic" class="contain_checkbox"><form:checkbox path="downloadPic" id="downloadPic" value="true"/><span class="custom_checkbox"></span>Who can download your account pic</form:label>
                            </div>
                            <div class="co_abx_box co_adada_kk">
                            <form:label path="liDislikeDo" class="contain_checkbox"><form:checkbox path="liDislikeDo" id="liDislikeDo" value="true"/><span class="custom_checkbox"></span>Who can like/dislike your account pic</form:label>
                            </div>
                            <div class="co_abx_box co_adada_kk">
                            <form:label path="liDislikeSee" class="contain_checkbox"><form:checkbox path="liDislikeSee" id="liDislikeSee" value="true"/><span class="custom_checkbox"></span>Who can see who likes/dislikes your account pic</form:label>
                            </div>
                            <div class="co_abx_box co_adada_kk">
                            <form:label path="talkingDo" class="contain_checkbox"><form:checkbox path="talkingDo" id="talkingDo" value="true"/><span class="custom_checkbox"></span>Who can talk on your account pic</form:label>
                            </div>
                            <div class="co_abx_box co_adada_kk">
                            <form:label path="talkingSee" class="contain_checkbox"><form:checkbox path="talkingSee" id="talkingSee" value="true"/><span class="custom_checkbox"></span>Who can see who talked on your account pic</form:label>
                            </div>
                            <div class="co_abx_box co_adada_kk">
                            <form:label path="commentDo" class="contain_checkbox"><form:checkbox path="commentDo" id="commentDo" value="true"/><span class="custom_checkbox"></span>Who can comment on your account pic</form:label>
                            </div>
                            <div class="co_abx_box co_adada_kk">
                            <form:label path="commentSee" class="contain_checkbox"><form:checkbox path="commentSee" id="commentSee" value="true"/><span class="custom_checkbox"></span>Who can see who commented on your account pic</form:label>
                            </div>
                            <div class="co_abx_box co_adada_kk">
                            <form:label path="shareDo" class="contain_checkbox"><form:checkbox path="shareDo" id="shareDo" value="true"/><span class="custom_checkbox"></span>Who can share your account pic</form:label>
                            </div>
                            <div class="co_abx_box co_adada_kk">
                            <form:label path="shareSee" class="contain_checkbox"><form:checkbox path="shareSee" id="shareSee" value="true"/><span class="custom_checkbox"></span>Who can see who has shared your account pic</form:label>
                            </div>
                            <div class="co_box">
                            <form:label path="likePri" class="contain_checkbox"><form:checkbox path="likePri" id="likePri" value="true"/><span class="custom_checkbox"></span>Like</form:label>
                            </div>
                            <div class="co_box">
                            <form:label path="dislikePri" class="contain_checkbox"><form:checkbox path="dislikePri" id="dislikePri" value="true"/><span class="custom_checkbox"></span>Dislike</form:label>
                            </div>
                            <div class="co_box">
                            <form:label path="talkingPri" class="contain_checkbox"><form:checkbox path="talkingPri" id="talkingPri" value="true"/><span class="custom_checkbox"></span>Talking</form:label>
                            </div>
                            <div class="co_box">
                            <form:label path="commentPri" class="contain_checkbox"><form:checkbox path="commentPri" id="commentPri" value="true"/><span class="custom_checkbox"></span>Comment</form:label>
                            </div>
                            <div class="co_box">
                            <form:label path="sharePri" class="contain_checkbox"><form:checkbox path="sharePri" id="sharePri" value="true"/><span class="custom_checkbox"></span>Share</form:label>
                            </div>
                            <div class="co_a_box">
                            <form:label path="showHide" class="contain_checkbox"><form:checkbox path="showHide" id="showHide" value="true"/><span class="custom_checkbox"></span>Show hide options in the page.</form:label>
                            </div>
                        <form:button name="updateStngs" id="updateStngs" class="form_pic_button" value="submit">Update</form:button>
                    </form:form>
            </div>
            </div>
        </div>
        <script>
            if (null !== h("accpicedsettings"))
                h("accpicedsettings").addEventListener("submit", function () {
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
