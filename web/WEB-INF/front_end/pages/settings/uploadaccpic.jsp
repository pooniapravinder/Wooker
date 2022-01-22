<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%><%@taglib uri="http://www.springframework.org/tags" prefix="spring"%><%@page contentType="text/html" pageEncoding="UTF-8"%><%@page session="false"%><!DOCTYPE html>
<html lang="en-US" id="wooker">
    <head>
        <meta name="keywords" content="Change Settings of your Upload Account Pic">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
        <meta name="theme-color" content="#663399">
        <link rel="shortcut icon" href="//www.google.com/favicon.ico"/>
        <meta name="description" content="Change Upload Account Pic Settings">
        <meta name="google" content="notranslate">
        <title>Upload Account Pic - Settings</title>
        <link rel="stylesheet" type="text/css" href="/rele/css/styleone.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/styletwo.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/stylethree.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/stylefour.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/JuiLOdOpp.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/IoDJnmdJdDE.css">
    </head>
    <body>
        <div class="slide_layout" id="slide_layout"><div class="loading_text">Updating upload account pic settings....</div>
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
                <h2>Upload Account Pic Settings</h2>
                <div class="a__option">
                    <div class="a__option__a">
                        <a href="/info/">Primary Info</a>
                    </div>
                    <div class="a__option__b">
                        <a href="/more/info/">Secondary Info</a>
                    </div>
                    <div class="restore_default"><a href="/account/pic/upload/new/options/restore/">Restore Default</a></div>
                </div>
                    <form:form name="accpicupsettings" class="info-setting-form" modelAttribute="accpicupsettings" method="post" action="">
                        <div class="co_box">
                            <form:label path="prInfo" class="contain_checkbox"><form:checkbox path="prInfo" id="prInfo" value="true"/><span class="custom_checkbox"></span>Primary Info</form:label>
                            </div>
                            <div class="co_box">
                            <form:label path="secInfo" class="contain_checkbox"><form:checkbox path="secInfo" id="secInfo" value="true"/><span class="custom_checkbox"></span>Secondary Info</form:label>
                            </div>
                            <div class="co_box">
                            <form:label path="settings" class="contain_checkbox"><form:checkbox path="settings" id="settings" value="true"/><span class="custom_checkbox"></span>Settings</form:label>
                            </div>
                            <div class="co_box">
                            <form:label path="security" class="contain_checkbox"><form:checkbox path="security" id="security" value="true"/><span class="custom_checkbox"></span>Security</form:label>
                            </div>
                             <div class="co_box">
                            <form:label path="picPreview" class="contain_checkbox"><form:checkbox path="picPreview" id="picPreview" value="true"/><span class="custom_checkbox"></span>Pic Preview</form:label>
                            </div>
                             <div class="co_box">
                            <form:label path="chPic" class="contain_checkbox"><form:checkbox path="chPic" id="chPic" value="true"/><span class="custom_checkbox"></span>Choose Pic</form:label>
                            </div>
                            <div class="co__privacy__aa">
                                <strong>Privacy:</strong>
                            </div>
                            
                            <div class="form-element-show">
                            <div class="co_abx_box">
                            <form:label path="seePic" class="contain_checkbox"><form:checkbox path="seePic" id="seePic" value="true"/><span class="custom_checkbox"></span>Who can see your account pic</form:label>
                            </div><div class="col edit_pic_pos">
                                <div class="custom-select">
                                <form:select path="defseePic" id="defseePic" class="custom-select-box"><c:forEach var="i" begin="1" end="6"><form:option value="${i}"><spring:message code="userprivacy.label.0${i}"/></form:option></c:forEach></form:select>
                                        </div>
                                    </div>
                                        </div> 
                                        
                                        <div class="form-element-show">
                            <div class="co_abx_box">
                            <form:label path="downloadPic" class="contain_checkbox"><form:checkbox path="downloadPic" id="downloadPic" value="true"/><span class="custom_checkbox"></span>Who can download your account pic</form:label>
                            </div><div class="col edit_pic_pos">
                                <div class="custom-select">
                                <form:select path="defdownloadPic" id="defdownloadPic" class="custom-select-box"><c:forEach var="i" begin="1" end="6"><form:option value="${i}"><spring:message code="userprivacy.label.0${i}"/></form:option></c:forEach></form:select>
                                        </div>
                                    </div>
                                        </div> 
                            
                            <div class="form-element-show">
                            <div class="co_abx_box">
                            <form:label path="liDislikeDo" class="contain_checkbox"><form:checkbox path="liDislikeDo" id="liDislikeDo" value="true"/><span class="custom_checkbox"></span>Who can like/dislike your account pic</form:label>
                            </div><div class="col edit_pic_pos">
                                <div class="custom-select">
                                <form:select path="defliDislikeDo" id="defliDislikeDo" class="custom-select-box"><c:forEach var="i" begin="1" end="6"><form:option value="${i}"><spring:message code="userprivacy.label.0${i}"/></form:option></c:forEach></form:select>
                                        </div>
                                    </div>
                                        </div> 
                            
                            <div class="form-element-show">
                            <div class="co_abx_box">
                            <form:label path="liDislikeSee" class="contain_checkbox"><form:checkbox path="liDislikeSee" id="liDislikeSee" value="true"/><span class="custom_checkbox"></span>Who can see who likes/dislikes your account pic</form:label>
                            </div><div class="col edit_pic_pos">
                                <div class="custom-select">
                                <form:select path="defliDislikeSee" id="defliDislikeSee" class="custom-select-box"><c:forEach var="i" begin="1" end="6"><form:option value="${i}"><spring:message code="userprivacy.label.0${i}"/></form:option></c:forEach></form:select>
                                        </div>
                                    </div>
                                        </div> 
                            
                            <div class="form-element-show">
                            <div class="co_abx_box">
                            <form:label path="talkingDo" class="contain_checkbox"><form:checkbox path="talkingDo" id="talkingDo" value="true"/><span class="custom_checkbox"></span>Who can talk on your account pic</form:label>
                            </div><div class="col edit_pic_pos">
                                <div class="custom-select">
                                <form:select path="deftalkingDo" id="deftalkingDo" class="custom-select-box"><c:forEach var="i" begin="1" end="6"><form:option value="${i}"><spring:message code="userprivacy.label.0${i}"/></form:option></c:forEach></form:select>
                                        </div>
                                    </div>
                                        </div> 
                            
                            <div class="form-element-show">
                            <div class="co_abx_box">
                            <form:label path="talkingSee" class="contain_checkbox"><form:checkbox path="talkingSee" id="talkingSee" value="true"/><span class="custom_checkbox"></span>Who can see who talked on your account pic</form:label>
                            </div><div class="col edit_pic_pos">
                                <div class="custom-select">
                                <form:select path="deftalkingSee" id="deftalkingSee" class="custom-select-box"><c:forEach var="i" begin="1" end="6"><form:option value="${i}"><spring:message code="userprivacy.label.0${i}"/></form:option></c:forEach></form:select>
                                        </div>
                                    </div>
                                        </div> 
                                        <div class="form-element-show">
                            <div class="co_abx_box">
                            <form:label path="commentDo" class="contain_checkbox"><form:checkbox path="commentDo" id="commentDo" value="true"/><span class="custom_checkbox"></span>Who can comment on your account pic</form:label>
                            </div><div class="col edit_pic_pos">
                                <div class="custom-select">
                                <form:select path="defcommentDo" id="defcommentDo" class="custom-select-box"><c:forEach var="i" begin="1" end="6"><form:option value="${i}"><spring:message code="userprivacy.label.0${i}"/></form:option></c:forEach></form:select>
                                        </div>
                                    </div>
                                        </div> 
                            
                            <div class="form-element-show">
                            <div class="co_abx_box">
                            <form:label path="commentSee" class="contain_checkbox"><form:checkbox path="commentSee" id="commentSee" value="true"/><span class="custom_checkbox"></span>Who can see who commented on your account pic</form:label>
                            </div><div class="col edit_pic_pos">
                                <div class="custom-select">
                                <form:select path="defcommentSee" id="defcommentSee" class="custom-select-box"><c:forEach var="i" begin="1" end="6"><form:option value="${i}"><spring:message code="userprivacy.label.0${i}"/></form:option></c:forEach></form:select>
                                        </div>
                                    </div>
                                        </div> 
                            
                            <div class="form-element-show">
                            <div class="co_abx_box">
                            <form:label path="shareDo" class="contain_checkbox"><form:checkbox path="shareDo" id="shareDo" value="true"/><span class="custom_checkbox"></span>Who can share your account pic</form:label>
                            </div><div class="col edit_pic_pos">
                                <div class="custom-select">
                                <form:select path="defshareDo" id="defshareDo" class="custom-select-box"><c:forEach var="i" begin="1" end="6"><form:option value="${i}"><spring:message code="userprivacy.label.0${i}"/></form:option></c:forEach></form:select>
                                        </div>
                                    </div>
                                        </div> 
                            
                            <div class="form-element-show">
                            <div class="co_abx_box">
                            <form:label path="shareSee" class="contain_checkbox"><form:checkbox path="shareSee" id="shareSee" value="true"/><span class="custom_checkbox"></span>Who can see who has shared your account pic</form:label>
                            </div><div class="col edit_pic_pos">
                                <div class="custom-select">
                                <form:select path="defshareSee" id="defshareSee" class="custom-select-box"><c:forEach var="i" begin="1" end="6"><form:option value="${i}"><spring:message code="userprivacy.label.0${i}"/></form:option></c:forEach></form:select>
                                        </div>
                                    </div>
                                        </div> 
                            
                            <div class="co_box">
                            <form:label path="likePri" class="contain_checkbox"><form:checkbox path="likePri" id="likePri" value="true"/><span class="custom_checkbox"></span>Like</form:label><form:label path="deflikePri" class="contain_checkbox"><form:checkbox path="deflikePri" id="deflikePri" value="true"/><span class="custom_checkbox"></span></form:label>
                            </div>
                            <div class="co_box">
                            <form:label path="dislikePri" class="contain_checkbox"><form:checkbox path="dislikePri" id="dislikePri" value="true"/><span class="custom_checkbox"></span>Dislike</form:label><form:label path="defdislikePri" class="contain_checkbox"><form:checkbox path="defdislikePri" id="defdislikePri" value="true"/><span class="custom_checkbox"></span></form:label>
                            </div>
                            <div class="co_box">
                            <form:label path="talkingPri" class="contain_checkbox"><form:checkbox path="talkingPri" id="talkingPri" value="true"/><span class="custom_checkbox"></span>Talking</form:label><form:label path="deftalkingPri" class="contain_checkbox"><form:checkbox path="deftalkingPri" id="deftalkingPri" value="true"/><span class="custom_checkbox"></span></form:label>
                            </div>
                            <div class="co_box">
                            <form:label path="commentPri" class="contain_checkbox"><form:checkbox path="commentPri" id="commentPri" value="true"/><span class="custom_checkbox"></span>Comment</form:label><form:label path="defcommentPri" class="contain_checkbox"><form:checkbox path="defcommentPri" id="defcommentPri" value="true"/><span class="custom_checkbox"></span></form:label>
                            </div>
                            <div class="co_box">
                            <form:label path="sharePri" class="contain_checkbox"><form:checkbox path="sharePri" id="sharePri" value="true"/><span class="custom_checkbox"></span>Share</form:label><form:label path="defsharePri" class="contain_checkbox"><form:checkbox path="defsharePri" id="defsharePri" value="true"/><span class="custom_checkbox"></span></form:label>
                            </div>
                            <div class="co_box">
                            <form:label path="prePics" class="contain_checkbox"><form:checkbox path="prePics" id="prePics" value="true"/><span class="custom_checkbox"></span>Previous Pics</form:label>
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
            if (null !== h("accpicupsettings"))
                h("accpicupsettings").addEventListener("submit", function () {
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
