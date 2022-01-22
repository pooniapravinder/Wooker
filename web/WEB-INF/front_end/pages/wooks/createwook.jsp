<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%><%@taglib uri="http://www.springframework.org/tags" prefix="spring"%><%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%><%@page contentType="text/html" pageEncoding="UTF-8"%><%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@page session="false"%><!DOCTYPE html>
<html lang="en-US" id="wooker">
    <head>
        <meta name="keywords" content="Wooks at Wooker">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
        <meta name="theme-color" content="#663399">
        <link rel="shortcut icon" href="//www.google.com/favicon.ico"/>
        <meta name="description" content="Explore the Wooks">
        <meta name="google" content="notranslate">
        <title>Create Wook</title>
        <link rel="stylesheet" type="text/css" href="/rele/css/styleone.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/styletwo.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/stylethree.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/JuiLOdOpp.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/IoDJnmdJdDE.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/dsTdDGtVttedgRYR.css">
    </head>
    <body>
            <%@include file="../header.jsp"%>
        <div class="wrapper animate_in" id="wrapper">
            <div class="info_page main clearfix">
            <div class="content">
                <h1>Create Wook</h1>
                <div class="center_element">
                    <div class="ter__rt">
                        <a href="/wooks/" class="jwek__lki"></a><span class="rrytryf">Go to Wooks</span>
                    </div>
                    <p class="fade_it p__gyi">You can also modify your wook later</p>
                </div>

                <form:form method="post" name="newWook" modelAttribute="newWook" action="" enctype="multipart/form-data">
                    <div class="form-element-input sft">
                        <form:input path="title" id="title" class="wook_input_box" autocorrect="off" autocomplete="off" spellcheck="false" required="true"/>
                        <form:label path="title">Title</form:label>
                            <span class="focus-border"></span>
                        </div>
                    <form:errors path="title" class="editinfo-head-errors"/>


                    <div class="form-element-input sft">
                        <form:input path="type" id="type" class="wook_input_box" autocorrect="off" autocomplete="off" spellcheck="false" required="true"/>
                        <form:label path="type">Type</form:label>
                            <span class="focus-border"></span>
                        </div>
                    <form:errors path="type" class="editinfo-head-errors"/>

                    <div class="form-element">
                        <form:label path="photo"><strong>Photo:</strong></form:label>
                        <div class="wallpaper_preview_container"><form:input path="photo" id="photo" type="file" accept="image/*" class="choose_upload_wallpaper" title="Select photo for Wook" autocorrect="off" autocomplete="off" spellcheck="false"/><img src="/rele/img/upload.svg" id=":uwMK" class="wallpaper_default_preview"></div>
                    </div>
                    <form:errors path="photo" class="editinfo-errors"/>

                    <div class="form-element">
                        <form:label path="coverPhoto"><strong>Cover Photo:</strong></form:label>
                        <div class="wallpaper_preview_container"><form:input path="coverPhoto" id="coverPhoto" type="file" accept="image/*" class="choose_upload_wallpaper" title="Select cover photo for Wook" autocorrect="off" autocomplete="off" spellcheck="false"/><img src="/rele/img/upload.svg" id=":uwLZ" class="wallpaper_default_preview"></div>
                    </div>
                    <form:errors path="coverPhoto" class="editinfo-errors"/>

                    <div class="form-element">
                        <form:label path="privacy"><strong>Privacy:</strong></form:label>
                            <div class="centralise">
                                <div class="custom-select"><form:select path="privacy" id="privacy" class="custom-select-box"><c:forEach var="i" begin="1" end="6"><form:option value="${i}"><spring:message code="userprivacy.label.0${i}"/></form:option></c:forEach></form:select></div>
                                    </div>
                                </div>

                                <div class="form-element">
                        <form:label path="writePublish"><strong>Write/Publish:</strong></form:label>
                            <div class="centralise">
                                <div class="custom-select"><form:select path="writePublish" id="writePublish" class="custom-select-box"><c:forEach var="i" begin="1" end="6"><form:option value="${i}"><spring:message code="userprivacy.label.0${i}"/></form:option></c:forEach></form:select></div>
                                    </div></div>


                                <div class="form-element">
                        <form:label path="text"><strong>Allowed:</strong></form:label>
                            <div class="centralise vf">
                            <form:label path="text" class="contain_checkbox"><form:checkbox path="text" id="text" value="accept"/><span class="custom_checkbox"></span>Text</form:label><form:label path="image" class="contain_checkbox"><form:checkbox path="image" id="image" value="accept"/><span class="custom_checkbox"></span>Image</form:label><form:label path="audio" class="contain_checkbox"><form:checkbox path="audio" id="audio" value="accept"/><span class="custom_checkbox"></span>Audio</form:label><form:label path="video" class="contain_checkbox"><form:checkbox path="video" id="video" value="accept"/><span class="custom_checkbox"></span>Video</form:label><form:label path="file" class="contain_checkbox"><form:checkbox path="file" id="file" value="accept"/><span class="custom_checkbox"></span>File</form:label>
                            </div>
                        </div>
                    <form:errors path="text" class="editinfo-errors"/>

                    <div class="terms_conditions">
                        <form:label path="TermsAndService" class="contain_checkbox"><form:checkbox path="TermsAndService" id="TermsAndService" value="accept"/><span class="custom_checkbox"></span>I accept the <a href="">license</a> and <a href="">agreement</a> for wooks on Wooker. I hereby, understand that Wooker has rights to block wooks due to fraud wooks.</form:label>
                        </div>
                    <form:errors path="TermsAndService" class="editinfo-errors"/>

                    <form:button name="create" id="create" class="form_pic_button" value="submit">Create</form:button>
                </form:form>
            </div>
            </div>
        </div>

        <script type="text/javascript" src="/rele/js/GYhdUdJiI.js"></script>
        <script>
            var x = a_b("photo");
            var y = a_b("coverPhoto");
            x.onchange = function () {
                rf(this, ":uwMK");
            };
            y.onchange = function () {
                rf(this, ":uwLZ");
            };
            function rf(xc, xv) {
                if (xc.files && xc.files[0]) {
                    var b = new FileReader();
                    b.onload = function (e) {
                        a_b(xv).setAttribute("src", e.target.result);
                    };
                    b.readAsDataURL(xc.files[0]);
                }
            }
            ;
            function a_b(a) {
                return window.document.getElementById(a);
            }
        </script>
    </body>
</html>
