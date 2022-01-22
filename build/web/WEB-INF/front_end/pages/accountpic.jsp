<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%><%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@taglib uri="http://www.springframework.org/tags" prefix="spring"%><%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%><%@page contentType="text/html" pageEncoding="UTF-8"%><%@page session="false"%><!DOCTYPE html>
<html lang="en-US" id="wooker">
    <head>
        <meta name="keywords" content="Upload Account Pic for Wooker">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
        <meta name="theme-color" content="#663399">
        <link rel="shortcut icon" href="http://www.google.com/favicon.ico">
        <meta name="description" content="Now You have to Upload Account Pic for Wooker Account">
        <meta name="google" content="notranslate">
        <title><spring:message code="uploadpic.label.title"/></title>
        <link rel="stylesheet" type="text/css" href="/rele/css/JuiLOdOpp.css">
        <style type="text/css">
            html, body, div, h1, p, img, ol, ul, li, table, tr, td, form,fieldset,
            footer, header {
                margin: 0;
                padding: 0;
                border: 0;
            }
            footer, header, section {
                display: block;
            }
            html {
                font: 81.25% arial, helvetica, sans-serif;
                background: #fff;
                color: #333;
                line-height: 1;
                direction: ltr;
            }
            a {
                color: #15c;
                text-decoration: none;
            }
            a:active {
                color: #d14836;
            }
            a:hover {
                text-decoration: none;
            }
            h1 {
                color: #222;
                font-size: 1.54em;
                font-weight: normal;
                margin: 0 0 1.46em;
            }
            p {
                line-height: 17px;
                margin: 0 0 1em;
                color: #999;
            }
            ol, ul {
                list-style: none;
                line-height: 17px;
                margin: 0 0 1em;
            }
            li {
                margin: 0 0 .5em;
            }
            table {
                border-collapse: collapse;
                border-spacing: 0;
            }
            strong {
                color: #222;
            }
            input:-webkit-autofill {
                -webkit-box-shadow: 0 0 0 30px white inset;
            }
        </style>

        <style type="text/css">
            html, body {
                background-color: #f1f1f1;
                position: absolute;
                height: 100%;
                min-width: 100%;
            }
            .wrapper {
                position: relative;
                min-height: 100%;
            }
            .wrapper + style + iframe {
                display: none;
            }
            .content {
                padding: 0 44px;
            }

            .google-header-bar {
                top: 0;
                width: 100%;
                height: 71px;
                background-color: #663399;
                overflow: hidden;
            }
            .header {
                color: #ccc;
                font-size: 13px;
                white-space: nowrap;
                line-height: 75px;
            }

            .header a {
                color: #ccc;
            }

            .header a:hover {
                color: #fff;
            }

            .header .header_elem_link {
                margin-left: 10px;
                overflow: hidden;
            }

            .main {
                margin: 0 auto;
                width: 650px;
                padding-top: 0px;
                padding-bottom: 0;
            }
            .google-footer-bar {
                height: 30px;
                position: absolute;
                bottom: 0;
                width: 100%;
                overflow: hidden;
                background-color: #663399;
            }
            .footer {
                color: #ccc;
                font-size: 11px;
                white-space: nowrap;
                line-height: 32px;
            }

            .footer a {
                color: #ccc;
            }

            .footer a:hover {
                color: #fff;
            }

            .footer .footer_elem_link {
                margin-left: 10px;
                overflow: hidden;
            }

            .footer .copyright {
                display: block;
                list-style: none;
                text-align: center;
            }
            .clearfix:after {
                visibility: hidden;
                display: block;
                font-size: 0;
                content: ".";
                clear: both;
                height: 0;
            }
            * html .clearfix {
                zoom: 1;
            }
            *:first-child+html .clearfix {
                zoom: 1;
            }
        </style>

        <style type="text/css">

            .signuponepage .sign-up {
                background-color: #fff;
                width: 450px;
            }
            .signuponepage .signup-box {
                margin-top: 20px;
                margin-bottom: 50px;
                padding: 20px;
                box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
                -webkit-box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
                -moz-box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
                -ms-box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
                -o-box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
            }

            .signuponepage .form-element{
                margin-bottom: 10px;
                position: relative;
            }


            .col {
                margin-bottom: 2em;
                font-size: 13px;
            }
            .opt_pos {
                margin-left: 19em;
            }

            .g-button {
                margin: 10px auto 0 auto;
                display: block;
                -webkit-appearance: none;
                min-width: 46px;
                text-align: center;
                width: 30%;
                height: 35px;
                line-height: 27px;
                outline: 0;
                border: 0;
                background-color: #663399;
                border-radius: 5px;
                font-size: 14px;
                color: white;
                font-weight: 300;
            }
            .signup-errors {
                margin: 10px;
                font-size: 12px;
                display : block;
                color: #cc0000;
            }

            .signuponepage .login-help {
                width: 100%;
                margin: 20px 0px 0;
            }
            .login-help a {
                color: #663399;
                outline-color: #663399;
            }

            .main {
                width: 400px;
            }
            .main h1 {
                text-align: center;
                font-family: "Open Sans", arial;
                color: #555;
                font-size: 35px;
                margin-top: 20px;
            }
        </style>

        <style type="text/css">
            @media (max-width: 800px) {
                html,body {
                    background: #fff;
                    min-width: 100%;
                    -webkit-tap-highlight-color: rgba(0,0,0,0);
                }
                h1, h2, h3, h4, h5, h6 {
                    font-size: 1.4em;
                }
                .main {
                    width: auto;
                    max-width: 276px;
                    padding-bottom: 85px;
                    padding-top: 15px;
                    overflow-x: hidden;
                }
                .content {
                    padding-left: 22px;
                    padding-right: 22px;
                }
                .side-content {
                    display: none;
                }
                .footer .copyright {
                    display: none;
                }

                .signup-steps ol {
                    display: none;
                }
                .signuponepage .sign-up {
                    width: 100%;
                }
                .signuponepage .signup-box {
                    margin: 0;
                    padding: 0;
                    background: #fff;
                    border: none;
                    -moz-box-shadow: none;
                    -webkit-box-shadow: none;
                    box-shadow: none;

                }
                .opt_pos {
                    margin-left: 15em;
                }
            }





            h1, h2, p {
                -webkit-animation-duration: 0.1s;
                -webkit-animation-name: fontfix;
                -webkit-animation-iteration-count: 1;
                -webkit-animation-timing-function: linear;
                -webkit-animation-delay: 0;
            }
            @-webkit-keyframes fontfix {
                from {
                    opacity: 1;
                }
                to {
                    opacity: 1;
                }
            }


            @media (max-width: 800px) {
                .main h1 {
                    text-align: center;
                    font-family: arial, sans-serif;
                    font-size: 25px;
                    font-weight: normal;
                    margin: 0 0 .92em;
                }
            }

            .pic-preview {
                margin: 0 auto 20px auto;
                display: block;
                width: 150px;
                height: 170px;
                background-size: 150px 170px;
                padding: 3px;
                border: solid 1px #CCC;
                -moz-box-shadow: 1px 1px 5px #999;
                -webkit-box-shadow: 1px 1px 5px #999;
                box-shadow: 1px 1px 5px #999;
            }

            .pic-upload-button {
                margin: 0 auto 20px auto;
                position: relative;
                display: block;
                -webkit-appearance: none;
                min-width: 46px;
                text-align: center;
                width: 60%;
                height: 30px;
                line-height: 27px;
                background-color: #663399;
                border-radius: 5px;
                font-size: 14px;
                color: white;
                font-weight: 300;
            }
            .upload-button {
                position: absolute;
                height: 30px;
                top: 0px;
                left: 0px;
                width: 100%;
                opacity: 0;
                filter:alpha(opacity=0);
            }

            .upload_layout {
                display: none;
                position: fixed;
                z-index: 1;
                left: 0;
                top: 0;
                right: 0;
                bottom: 0;
                overflow: auto;
            }
            .loading_text {
                font-family: arial, helvetica, sans-serif; 
                font-size:2em;
                color: #663399;
                position: absolute;
                top: 40%;
                left: 40%;
            }
            .loading {
                position: absolute;
                top: 50%;
                left: 50%;
            }
            .loading .bullet {
                padding: 10px;
                border-radius: 50%;
                background: #663399;
                -webkit-animation: animIn 1s ease-in-out 0s infinite;
                animation: animIn 1s ease-in-out 0s infinite;
            }
            .loading .bullet:nth-child(1) {
                -webkit-animation-delay: 0s;
                animation-delay: 0s;
            }
            .loading .bullet:nth-child(2) {
                -webkit-animation-delay: 0.15s;
                animation-delay: 0.15s;
            }
            .loading .bullet:nth-child(3) {
                -webkit-animation-delay: 0.3s;
                animation-delay: 0.3s;
            }
            .loading .bullet:nth-child(4) {
                -webkit-animation-delay: 0.45s;
                animation-delay: 0.45s;
            }
            .loading .bullet:nth-child(5) {
                -webkit-animation-delay: 0.60s;
                animation-delay: 0.60s;
            }
            @keyframes animIn {
                0% {
                    -webkit-transform: translateX(-100px);
                    transform: translateX(-100px);
                    opacity: 0;
                }
                50% {
                    opacity: 1;
                }
                100% {
                    -webkit-transform: translateX(100px);
                    transform: translateX(100px);
                    opacity: 0;
                }
            }

            .animate_in {
                display: block;
                animation: fadeIn 3s;
                -webkit-animation:fadeIn 3s;
                -moz-animation:fadeIn 3s;
                -webkit-animation:fadeIn 3s;
                -webkit-animation-fill-mode: both;
                animation-fill-mode: both;
            }

            @-webkit-keyframes fadeIn {
                0% {
                    opacity: 0;
                }
                100% {
                    opacity: 1;
                }
            }

            .animate_out {
                animation: fadeOut 2s;
                -webkit-animation:fadeOut 2s;
                -moz-animation:fadeOut 2s;
                -webkit-animation:fadeOut 2s;
                -webkit-animation-fill-mode: both;
                animation-fill-mode: both;
            }

            @-webkit-keyframes fadeOut {
                0% {
                    opacity: 1;
                }
                100% {
                    opacity: 0;
                }
            }

            .float-item-left > * {
                float:left;
            }
            .float-item-right > * {
                float:right;
            }

        </style>
    </head>
    <body>
        <div class="upload_layout" id="upload_layout"><div class="loading_text">Uploading....</div>
            <div class="loading">
                <div class="bullet"></div>
                <div class="bullet"></div>
                <div class="bullet"></div>
                <div class="bullet"></div>
            </div>
        </div>
        <div class="wrapper" id="wrapper">
            <div class="google-header-bar">
                <div class="header content clearfix">
                    <div class="float-item-left">
                        <div class="header_elem_link"><a href="/home/">Home</a></div>
                    </div>
                    <div class="float-item-right">
                        <div class="header_elem_link"><a href="">Wooks</a></div>
                        <div class="header_elem_link"><a href="">World</a></div>
                    </div>
                </div>
            </div>

            <div class="signuponepage main content clearfix">
                <div class="sign-up">
                    <div class="signup-box">
                        <h1><spring:message code="uploadpic.label.h1"/></h1>
                        <form:form method="post" name="accpicoper" modelAttribute="accpicoper" action="" enctype="multipart/form-data">
                            <fieldset>
                                <form:errors path="img" class="signup-errors"/>

                                <form:label path="img"><img class="pic-preview" id="pic_preview" src="/rele/img/default-user-account-pic.png" alt=""/></form:label>
                                    <div class="pic-upload-button">
                                        Choose Account Pic<form:input path="img" id="img" type="file" accept="image/*" class="upload-button" autocorrect="off" autocomplete="off" spellcheck="false"/>
                                </div>

                                <div class="form-element">
                                    <form:label path="privacy"><strong>Who can see your account pic:</strong></form:label>

                                        <div class="col opt_pos">
                                            <div class="custom-select">
                                            <form:select path="privacy" id="privacy" class="custom-select-box"><c:forEach var="i" begin="1" end="6"><form:option value="0${i}"><spring:message code="userprivacy.label.0${i}"/></form:option></c:forEach></form:select>
                                                    </div>
                                                </div>
                                            </div>


                                            <div class="form-element">
                                    <form:label path="download"><strong>Who can download your account pic:</strong></form:label>
                                        <div class="col opt_pos">
                                            <div class="custom-select">
                                            <form:select path="download" id="download" class="custom-select-box"><c:forEach var="i" begin="1" end="6"><form:option value="0${i}"><spring:message code="userprivacy.label.0${i}"/></form:option></c:forEach></form:select>
                                                    </div>
                                                </div>
                                            </div>
                                <form:button name="upload" id="upload" class="g-button" value="upload"><spring:message code="editmoreinfo.label.save"/></form:button>
                                </fieldset>
                        </form:form>
                        <p class="login-help">If you want to upload your account pic with a lot of security constraint and with a lot of designing then, <a href="/account/pic/upload/new/">click here</a></p>

                    </div>
                </div>
            </div>

            <div class="google-footer-bar">
                <div class="footer content clearfix">
                    <div class="float-item-left">
                        <div class="footer_elem_link"><a href="">Terms</a></div>
                        <div class="footer_elem_link"><a href="">Privacy Policy</a></div>
                        <div class="footer_elem_link"><a href="">Feedback</a></div>
                    </div>
                    <div class="float-item-right">
                        <div class="footer_elem_link"><a href="">About</a></div>
                        <div class="footer_elem_link"><a href="">Cookies</a></div>
                    </div>

                    <jsp:useBean id="now" class="java.util.Date" />
                    <fmt:formatDate var="currentYear" value="${now}" pattern="yyyy" />
                    <div class="copyright">Wooker&nbsp;&copy;&nbsp;${currentYear}</div>
                </div>
            </div>
        </div>
        <script type="text/javascript" src="/rele/js/GYhdUdJiI.js"></script>
        <script>
            var a = a_b("img");
            a.addEventListener("change", function () {
                if (a.files && a.files[0]) {
                    var b = new FileReader();
                    b.onload = function (e) {
                        a_b("pic_preview").setAttribute("src", e.target.result);
                    };
                    b.readAsDataURL(a.files[0]);
                }
            });

            a_b("uploadaccpic").addEventListener("submit", function () {
                as__bnm();
            });

            function as__bnm() {
                a_b("wrapper").className += " animate_out";
                a_b("upload").innerHTML = "Uploading....";
                a_b("upload_layout").className += " animate_in";
            }
            function a_b(a) {
                return window.document.getElementById(a);
            }
        </script>
    </body>
</html>
