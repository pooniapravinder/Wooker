<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%><%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@taglib uri="http://www.springframework.org/tags" prefix="spring"%><%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%><%@page contentType="text/html" pageEncoding="UTF-8"%><%@page session="false"%><!DOCTYPE html>
<html lang="en-US" id="wooker">
    <head>
        <meta name="keywords" content="Signup for Wooker">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
        <meta name="theme-color" content="#663399">
        <link rel="shortcut icon" href="http://www.google.com/favicon.ico">
        <meta name="description" content="Signup for Wooker and get access to Everything in Wooker">
        <meta name="google" content="notranslate">
        <title><spring:message code="label.title"/></title>
        <link rel="stylesheet" type="text/css" href="/rele/css/OpaUJSnsSjj.css">
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

            .lang_style {
                display: inline-block;
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
                content: '.';
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
                margin-bottom: 50px;
                width: 362px;
                float: right;
            }
            .signuponepage .signup-box {
                margin: 0;
                padding: 50px;
                box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
                -webkit-box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
                -moz-box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
                -ms-box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
                -o-box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
            }
            .signuponepage .form-element {
                position: relative;
                margin: 0 0 1.5em;
            }

            .signuponepage .form-element label {
                display: inline-block;
                width: 100%;
                position: relative;
            }
            .signuponepage .form-element strong {
                margin: 0 0 1em;
                display: inline-block;
                width: 100%;
                -webkit-user-select: none;
                -moz-user-select: none;
            }

            .signuponepage .custom-select-box{
                -webkit-appearance: none;
                height: 35px;
                -webkit-border-radius: 2px;
                -moz-border-radius: 2px;
                border-radius: 20px;
                background-color: #f5f5f5;
                border: 2px solid #dcdcdc;
                color: black;
                font-size: 13px;
                line-height: 27px;
                list-style: none;
                padding: 0 0 0 20px;
                margin: 0 2px;
                min-width: 46px;
                outline-color: #663399;
                display: inline-block;
            }

            .gender {
                width: 100%;
            }

            .month {
                width: 40%;
            }

            .date {
                width: 22%;
            }

            .year {
                width: 30%;
            }

            .country {
                width: 100%;
            }

            input[type=text],input[type=password] {
                -webkit-appearance: none;
                width: 100%;
                display: inline-block;
                height: 29px;
                margin: 0;
                padding: 0 8px;
                background: #fff;
                color: #555;
                border: 1px solid #d9d9d9;
                border-top: 1px solid #c0c0c0;
                -webkit-box-sizing: border-box;
                -moz-box-sizing: border-box;
                box-sizing: border-box;
                -webkit-border-radius: 1px;
                -moz-border-radius: 1px;
                border-radius: 1px;
            }

            input[type=text]:hover,input[type=password]:hover {
                border: 1px solid #b9b9b9;
                border-top: 1px solid #a0a0a0;
                -webkit-box-shadow: inset 0 1px 2px rgba(0,0,0,0.1);
                -moz-box-shadow: inset 0 1px 2px rgba(0,0,0,0.1);
                box-shadow: inset 0 1px 2px rgba(0,0,0,0.1);
            }

            input[type=text]:focus,input[type=password]:focus {
                outline-color: #663399;
                border: 1px solid #4d90fe;
                -webkit-box-shadow: inset 0 1px 2px rgba(0,0,0,0.3);
                -moz-box-shadow: inset 0 1px 2px rgba(0,0,0,0.3);
                box-shadow: inset 0 1px 2px rgba(0,0,0,0.3);
            }

            .g-button {
                margin-left: 70px;
                -webkit-appearance: none;
                display: inline-block;
                min-width: 46px;
                text-align: center;
                width: 50%;
                height: 37px;
                line-height: 27px;
                outline: 0;
                border: 0;
                background-color: #663399;
                border-radius: 5px;
                font-size: 14px;
                color: white;
                font-weight: 300;
            }

            .signuponepage .side-content {
                margin: 0 420px 0 0;
            }
            .signuponepage .signup-errors {
                margin: 10px;
                font-size: 12px;
                display : block;
                color: #cc0000;
            }
            .signuponepage .signup-help {
                margin: 0 60px 2em;
            }
            .signup-help a {
                color: #663399;
                outline-color: #663399;
            }
            .signuponepage .form-element .style_terms_and_service {
                font-size: 12px;
                display : block;
                line-height: 20px;
            }
            .signuponepage .form-element .style_terms_and_service a {
                font-weight: 600;
                color: #663399;
                outline-color: #663399;
            }

            .regular-checkbox {
                -webkit-appearance: none;
                background-color: #fafafa;
                border: 1px solid #cacece;
                box-shadow: 0 1px 2px rgba(0,0,0,0.05), inset 0px -15px 10px -12px rgba(0,0,0,0.05);
                padding: 9px;
                top: 8px;
                border-radius: 3px;
                display: inline-block;
                position: relative;
                outline-color: #663399;
            }

            .regular-checkbox:active, .regular-checkbox:checked:active {
                box-shadow: 0 1px 2px rgba(0,0,0,0.05), inset 0px 1px 3px rgba(0,0,0,0.1);
            }

            .regular-checkbox:checked {
                background-color: #e9ecee;
                border: 1px solid #adb8c0;
                box-shadow: 0 1px 2px rgba(0,0,0,0.05), inset 0px -15px 10px -12px rgba(0,0,0,0.05), inset 15px 10px -12px rgba(255,255,255,0.1);
                color: #99a1a7;
            }

            .regular-checkbox:checked:after {
                content: '\2713';
                font-size: 14px;
                position: absolute;
                top: 0px; bottom: 0;
                left: 3px;
                color: #663399;
            }

            .main {
                width: 950px;
            }
            .main h1 {
                text-align: center;
                font-family: 'Open Sans', arial;
                color: #555;
                font-size: 35px;
                margin: 30px 0 60px;
            }

            .signup_layout {
                display: none;
                position: fixed;
                z-index: 1;
                left: 0;
                top: 0;
                right: 0;
                bottom: 0;
                overflow: auto;
            }

            .animate_in {
                z-index: 1;
                display: block;
                animation: fadeIn 3s;
                -webkit-animation:fadeIn 3s;
                -moz-animation:fadeIn 3s;
                -ms-animation:fadeIn 3s;
                -o-animation:fadeIn 3s;
                animation-fill-mode: both;
                -webkit-animation-fill-mode: both;
                -moz-animation-fill-mode: both;
                -ms-animation-fill-mode: both;
                -o-animation-fill-mode: both;
            }

            @keyframes fadeIn {
                0% {
                    opacity: 0;
                }
                100% {
                    opacity: 1;
                }
            }

            .animate_out {
                z-index: 0;
                overflow:auto;
                pointer-events: none;
                cursor: default;
                animation: fadeOut 2s;
                -webkit-animation:fadeOut 2s;
                -moz-animation:fadeOut 2s;
                -ms-animation:fadeOut 2s;
                -o-animation:fadeOut 2s;
                animation-fill-mode: both;
                -webkit-animation-fill-mode: both;
                -moz-animation-fill-mode: both;
                -ms-animation-fill-mode: both;
                -o-animation-fill-mode: both;
            }

            @keyframes fadeOut {
                0% {
                    opacity: 1;
                }
                100% {
                    opacity: 0;
                }
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
                animation: animIn 1s ease-in-out 0s infinite;
                -webkit-animation: animIn 1s ease-in-out 0s infinite;
                -moz-animation: animIn 1s ease-in-out 0s infinite;
                -ms-animation: animIn 1s ease-in-out 0s infinite;
                -o-animation: animIn 1s ease-in-out 0s infinite;
                animation-fill-mode: both;
                -webkit-animation-fill-mode: both;
                -moz-animation-fill-mode: both;
                -ms-animation-fill-mode: both;
                -o-animation-fill-mode: both;
            }

            .loading .bullet:nth-child(1) {
                animation-delay: 0s;
                -webkit-animation-delay: 0s;
                -moz-animation-delay: 0s;
                -ms-animation-delay: 0s;
                -o-animation-delay: 0s;
            }
            .loading .bullet:nth-child(2) {
                animation-delay: 0.15s;
                -webkit-animation-delay: 0.15s;
                -moz-animation-delay: 0.15s;
                -ms-animation-delay: 0.15s;
                -o-animation-delay: 0.15s;
            }
            .loading .bullet:nth-child(3) {
                animation-delay: 0.3s;
                -webkit-animation-delay: 0.3s;
                -moz-animation-delay: 0.3s;
                -ms-animation-delay: 0.3s;
                -o-animation-delay: 0.3s;
            }
            .loading .bullet:nth-child(4) {
                animation-delay: 0.45s;
                -webkit-animation-delay: 0.45s;
                -moz-animation-delay: 0.45s;
                -ms-animation-delay: 0.45s;
                -o-animation-delay: 0.45s;
            }
            .loading .bullet:nth-child(5) {
                animation-delay: 0.6s;
                -webkit-animation-delay: 0.6s;
                -moz-animation-delay: 0.6s;
                -ms-animation-delay: 0.6s;
                -o-animation-delay: 0.6s;
            }
            @keyframes animIn {
                0% {
                    transform: translateX(-100px);
                    -webkit-transform: translateX(-100px);
                    -moz-transform: translateX(-100px);
                    -ms-transform: translateX(-100px);
                    -o-transform: translateX(-100px);
                    opacity: 0;
                }
                50% {
                    opacity: 1;
                }
                100% {
                    transform: translateX(100px);
                    -webkit-transform: translateX(100px);
                    -moz-transform: translateX(100px);
                    -ms-transform: translateX(100px);
                    -o-transform: translateX(100px);
                    opacity: 0;
                }
            }

        </style>


        <style type="text/css">
            @media (max-width: 800px) {
                html {
                    background: #f1f1f1;
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
                    margin: 0;
                }
                .signuponepage .signup-box {
                    margin: 0;
                    padding: 0;
                    background: #f1f1f1;
                    border: none;
                    box-shadow: none;
                    -webkit-box-shadow: none;
                    -moz-box-shadow: none;
                    -ms-box-shadow: none;
                    -o-box-shadow: none;
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
            .side-content h2 {
                text-align: center;
                font-family: 'Open Sans', arial;
                color: #737373;
                font-size: 18px;
                font-weight: 300;
            }
            .side-content p {
                text-align: center;
                font-family: 'Open Sans', arial;
                color: #737373;
                font-size: 14px;
            }

            .side-content .slide-caption {
                text-align: center;
                font-family: 'Open Sans', arial;
                color: #737373;
                font-size: 13px;
                position: absolute;
                bottom: 0;
                margin : 30px 150px;
            }

            .side-content .slideshow {
                position:relative;
                overflow: hidden;
                margin: 0 auto 10px;
                display: block;
            }

            .slide-wrapper {
                width: 4240px;
                -webkit-animation: slide 50s ease infinite;
            }

            .slide-one, .slide-two {
                float: left;
                width: 530px;
                height: 410px;
                background-size: 530px 410px;
            }

            .slide-one:nth-child(1) {
                background-image: url(/rele/img/signup_slide1/1.jpg);
            }

            .slide-one:nth-child(2) {
                background-image: url(/rele/img/signup_slide1/2.jpg);
            }

            .slide-one:nth-child(3) {
                background-image: url(/rele/img/signup_slide1/3.jpg);
            }

            .slide-one:nth-child(4) {
                background-image: url(/rele/img/signup_slide1/4.png);
            }

            .slide-one:nth-child(5) {
                background-image: url(/rele/img/signup_slide1/5.jpg);
            }

            .slide-one:nth-child(6) {
                background-image: url(/rele/img/signup_slide1/6.jpg);
            }

            .slide-one:nth-child(7) {
                background-image: url(/rele/img/signup_slide1/7.jpg);
            }

            .slide-one:nth-child(8) {
                background-image: url(/rele/img/signup_slide1/8.jpg);
            }

            .slide-two:nth-child(1) {
                background-image: url(/rele/img/signup_slide2/1.jpg);
            }

            .slide-two:nth-child(2) {
                background-image: url(/rele/img/signup_slide2/2.jpg);
            }

            .slide-two:nth-child(3) {
                background-image: url(/rele/img/signup_slide2/3.jpg);
            }

            .slide-two:nth-child(4) {
                background-image: url(/rele/img/signup_slide2/4.jpg);
            }

            .slide-two:nth-child(5) {
                background-image: url(/rele/img/signup_slide2/5.jpg);
            }

            .slide-two:nth-child(6) {
                background-image: url(/rele/img/signup_slide2/6.jpg);
            }

            .slide-two:nth-child(7) {
                background-image: url(/rele/img/signup_slide2/7.jpg);
            }

            .slide-two:nth-child(8) {
                background-image: url(/rele/img/signup_slide2/8.jpg);
            }

            @-webkit-keyframes slide {
                5% {margin-left: 0px;}
                20% {margin-left: -530px;}
                30% {margin-left: -1060px;}
                40% {margin-left: -1590px;}
                50% {margin-left: -2120px;}
                60% {margin-left: -2650px;}
                70% {margin-left: -3180px;}
                80% {margin-left: -3710px;}
                90% {margin-left: -3710px;}
            }


            @media (max-width: 800px) {
                .main h1 {
                    font-family: arial, sans-serif;
                    font-size: 25px;
                    font-weight: normal;
                    margin: 0 0 .92em;
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

        <div class="signup_layout" id="signup_layout"><div class="loading_text">Creating your account....</div>
            <div class="loading">
                <div class="bullet"></div>
                <div class="bullet"></div>
                <div class="bullet"></div>
                <div class="bullet"></div>
            </div>
        </div>

        <div class="wrapper animate_in" id="wrapper">


            <div class="google-header-bar">
                <div class="header content clearfix">
                    <div class="float-item-left">
                        <div class="header_elem_link"><a href="/login/">Log In</a></div>
                    </div>
                    <div class="float-item-right">
                        <div class="header_elem_link">
                            <div class="lang_style" id="lang_style"><a href="">Language</a></div>
                            <div class="custom-select" id="custom-select">
                                <select id="lang_loc" name="lang_loc">
                                    <option value="en_us">English (US)</option>
                                    <option value="en_uk">English (UK)</option>
                                    <option value="hi_in">हिन्दी</option>       
                                    <option value="pu_in">ਪੰਜਾਬੀ</option>
                                    <option value="bn_in">বাংলা</option>
                                    <option value="te_in">తెలుగు</option>
                                    <option value="mr_in">मराठी</option>
                                    <option value="ta_in">தமிழ்</option>
                                    <option value="gu_in">ગુજરાતી</option>
                                    <option value="kn_in">ಕನ್ನಡ</option>
                                    <option value="ml_in">മലയാളം</option>
                                    <option value="en_us">English (US)</option>
                                    <option value="en_uk">English (UK)</option>
                                    <option value="hi_in">हिन्दी</option>       
                                    <option value="pu_in">ਪੰਜਾਬੀ</option>
                                    <option value="bn_in">বাংলা</option>
                                    <option value="te_in">తెలుగు</option>
                                    <option value="mr_in">मराठी</option>
                                    <option value="ta_in">தமிழ்</option>
                                    <option value="gu_in">ગુજરાતી</option>
                                    <option value="kn_in">ಕನ್ನಡ</option>
                                    <option value="ml_in">മലയാളം</option>
                                </select>
                            </div>
                        </div>
                        <div class="header_elem_link"><a href="">Wooks</a></div>
                        <div class="header_elem_link"><a href="">World</a></div>
                    </div>
                </div>
            </div>

            <div class="signuponepage main content clearfix">

                <h1><spring:message code="label.h1"/></h1>

                <div class="sign-up">
                    <div class="signup-box">
                        <form:form method="post" name="addaccount" modelAttribute="addaccount" action="">
                            <jsp:useBean id="now" class="java.util.Date" />
                            <fmt:formatDate var="currentYear" value="${now}" pattern="yyyy" />
                            <fieldset>
                                <div class="form-element">
                                    <form:label path="firstName"><strong><spring:message code="label.firstname"/>:</strong></form:label>
                                    <form:input path="firstName" id="firstName" autocorrect="off" autocomplete="off" spellcheck="false"/>
                                    <form:errors path="firstName" class="signup-errors"/>
                                </div>
                                <div class="form-element">
                                    <form:label path="lastName"><strong><spring:message code="label.lastname"/>:</strong></form:label>
                                    <form:input path="lastName" id="lastName" autocorrect="off" autocomplete="off" spellcheck="false"/>
                                    <form:errors path="lastName" class="signup-errors"/>
                                </div>
                                <div class="form-element">
                                    <form:label path="gender"><strong><spring:message code="label.gender"/>:</strong></form:label>
                                    <form:select path="gender" id="gender" class="custom-select-box gender"><form:option value=""><spring:message code="label.gender.select"/></form:option><form:option value="Male"><spring:message code="label.gender.male"/></form:option><form:option value="Female"><spring:message code="label.gender.female"/></form:option><form:option value="Other"><spring:message code="label.gender.other"/></form:option></form:select>
                                    <form:errors path="gender" class="signup-errors"/>
                                </div>
                                <div class="form-element">
                                    <legend><form:label path="month"><strong><spring:message code="label.birthday"/>:</strong></form:label></legend>
                                    <form:select path="month" id="month" class="custom-select-box month"><form:option value=""><spring:message code="label.month.select"/></form:option><c:forEach var="i" begin="1" end="9"><form:option value="0${i}"><spring:message code="label.month.0${i}"/></form:option></c:forEach><c:forEach var="i" begin="10" end="12"><form:option value="${i}"><spring:message code="label.month.${i}"/></form:option></c:forEach></form:select>
                                    <form:errors path="month" class="signup-errors"/>
                                    <form:select path="date" id="date" class="custom-select-box date"><form:option value=""><spring:message code="label.date.select"/></form:option><c:forEach var="i" begin="1" end="9"><form:option value="0${i}">0${i}</form:option></c:forEach><c:forEach var="i" begin="10" end="31"><form:option value="${i}">${i}</form:option></c:forEach></form:select>
                                    <form:errors path="date" class="signup-errors"/>
                                    <form:select path="year" id="year" class="custom-select-box year"><form:option value=""><spring:message code="label.year.select"/></form:option><c:forEach var="i" begin="0" end="115"><form:option value="${currentYear-i}">${currentYear-i}</form:option></c:forEach></form:select>
                                    <form:errors path="year" class="signup-errors"/>
                                </div>
                                <div class="form-element">
                                    <form:label path="country"><strong><spring:message code="label.country"/>:</strong></form:label>
                                    <form:select path="country" id="country" class="custom-select-box country"><form:option value="AO"><spring:message code="label.country.ao"/></form:option><form:option value="AQ"><spring:message code="label.country.aq"/></form:option><form:option value="AZ"><spring:message code="label.country.az"/></form:option><form:option value="AF"><spring:message code="label.country.af"/></form:option><form:option value="AS"><spring:message code="label.country.as"/></form:option><form:option value="AW"><spring:message code="label.country.aw"/></form:option><form:option value="AR"><spring:message code="label.country.ar"/></form:option><form:option value="SV"><spring:message code="label.country.sv"/></form:option><form:option value="DZ"><spring:message code="label.country.dz"/></form:option><form:option value="AL"><spring:message code="label.country.al"/></form:option><form:option value="BN"><spring:message code="label.country.bn"/></form:option><form:option value="IN"><spring:message code="label.country.in"/></form:option><form:option value="BT"><spring:message code="label.country.bt"/></form:option><form:option value="MN"><spring:message code="label.country.mn"/></form:option><form:option value="MO"><spring:message code="label.country.mo"/></form:option></form:select>
                                    <form:errors path="country" class="signup-errors"/>
                                </div>
                                <div class="form-element">
                                    <form:label path="emailidPhone"><strong><spring:message code="label.emailIdphone"/>:</strong></form:label>
                                    <form:input path="emailidPhone" id="emailidPhone" autocorrect="off" autocomplete="off" spellcheck="false"/>
                                    <form:errors path="emailidPhone" class="signup-errors"/>
                                </div>
                                <form:hidden path="lang" id="lang" class="custom_input_box" autocorrect="off" autocomplete="off" spellcheck="false" required="true"/>
                                <div class="form-element">
                                    <form:label path="password"><strong><spring:message code="label.password"/>:</strong></form:label>
                                    <form:password path="password" id="password" autocorrect="off" autocomplete="off" spellcheck="false"/>
                                    <form:errors path="password" class="signup-errors"/>
                                </div>
                                <div class="form-element">
                                    <form:label path="confPassword"><strong><spring:message code="label.confirm_pass"/>:</strong></form:label>
                                    <form:password path="confPassword" id="confPassword" autocorrect="off" autocomplete="off" spellcheck="false"/>
                                </div>
                                <!--
                                <div class="form-element">
                                    <img src="/captcha_image.jpg" alt="Security Check" id="captcha_security">
                                    <form:label path="captchaCode"><strong><spring:message code="label.captcha"/>:</strong></form:label>
                                    <form:input path="captchaCode" id="captchaCode" autocorrect="off" autocomplete="off" spellcheck="false" value="a"/>
                                    <form:errors path="captchaCode" class="signup-errors"/>
                                </div>
                                -->
                                <div class="form-element">
                                    <p class="style_terms_and_service"><form:label path="TermsAndService"><form:checkbox path="TermsAndService" id="TermsAndService" class="regular-checkbox" value="accept"/><spring:message code="label.licenseandagreement"/>&nbsp;<a href="/wooker/terms/service/"><spring:message code="label.terms"/></a>&nbsp;<spring:message code="label.makesure"/>&nbsp;<a href="/wooker/privacy/policy/"><spring:message code="label.privacypolicy"/></a></form:label></p>
                                        <form:errors path="TermsAndService" class="signup-errors"/>
                                </div>

                                <form:button name="signup" id="signup" class="g-button" value="submit"><spring:message code="label.signup"/></form:button>
                                </fieldset>
                        </form:form>


                    </div>

                </div>

                <div class="side-content">
                    <h2>
                        One more Step Towards Social Network Technology
                    </h2>
                    <p>
                        A Social Network That Can Change the Way Of Your Life
                    </p>

                    <div class="slideshow">
                        <div class="slide-wrapper">
                            <div class="slide-one"><p class="slide-caption">Let's!!! Connect Everyone With Each Other</p></div>
                            <div class="slide-one"><p class="slide-caption">Join Now To Connect With Your Friends</p></div>
                            <div class="slide-one"><p class="slide-caption">You Can Chat With Your Friends And Can Share Everything</p></div>
                            <div class="slide-one"><p class="slide-caption">People From All Over The World Are Connecting Day By Day</p></div>
                            <div class="slide-one"><p class="slide-caption">More Privacy Options To Restrict The Users</p></div>
                            <div class="slide-one"><p class="slide-caption">Join And Start Your Business</p></div>
                            <div class="slide-one"><p class="slide-caption">Make More Secure Your Account At Any Instant Of Time</p></div>
                            <div class="slide-one"><p class="slide-caption">Let's!!! Meet With Your New Friends</p></div>
                        </div>
                    </div>


                    <p>
                        Send Messages Without Any Internet Connection
                    </p>
                    <p>
                        High Privacy and High Security
                    </p>

                    <div class="slideshow">
                        <div class="slide-wrapper">
                            <div class="slide-two"><p class="slide-caption">Let's!!! Come Together</p></div>
                            <div class="slide-two"><p class="slide-caption">Enjoy Life With Friends</p></div>
                            <div class="slide-two"><p class="slide-caption">Move Towards Next World</p></div>
                            <div class="slide-two"><p class="slide-caption">Let's Create Groups To Get All Together</p></div>
                            <div class="slide-two"><p class="slide-caption">New Ways To Create Groups</p></div>
                            <div class="slide-two"><p class="slide-caption">Standard Privacy Options For Groups</p></div>
                            <div class="slide-two"><p class="slide-caption">Share Everything With Whom You Want To Share</p></div>
                            <div class="slide-two"><p class="slide-caption">Let's!!! Grow Up And Start</p></div>
                        </div>
                    </div>
                    <p>
                        One Account that's All You Need To Do
                    </p>

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
                    <div class="copyright">Wooker&nbsp;&copy;&nbsp;${currentYear}</div>
                </div>
            </div>

        </div>
        <script>
            m("addaccount").addEventListener("submit", function () {
                as__bnm();
            });

            function as__bnm() {
                window.document.body.style.overflow = "hidden";
                var x = m("wrapper");
                x.className = x.className.replace(/\banimate_in\b/g, "animate_out");
                m("signup").innerHTML = "Signing up....";
                m("signup_layout").className += " animate_in";
            }
            function m(a) {
                return window.document.getElementById(a);
            }
        </script>
        <script type="text/javascript" src="/rele/js/uiDJjSKEmmd.js"></script>
    </body>
</html>