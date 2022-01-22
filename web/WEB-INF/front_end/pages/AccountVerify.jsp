<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%><%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@taglib uri="http://www.springframework.org/tags" prefix="spring"%><%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%><%@page contentType="text/html" pageEncoding="UTF-8"%><%@page session="false"%><!DOCTYPE html>
<html lang="en-US" id="wooker">
    <head>
        <meta name="keywords" content="Verify Wooker Account">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
        <meta name="theme-color" content="#663399">
        <link rel="shortcut icon" href="//www.google.com/favicon.ico">
        <meta name="description" content="Signup for Wooker and get access to Everything in Wooker">
        <meta name="google" content="notranslate">
        <title><spring:message code="accountverify.label.title"/></title>
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

            .main {
                margin: 0 auto;
                width: 650px;
                padding-top: 10px;
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

            .signuponepage .update_success {
                color: #008000;
            }
            .signuponepage .sign-up {
                background-color: #fff;
                width: 450px;
            }
            .signuponepage .signup-box {
                margin-bottom: 50px;
                padding: 20px;
    -moz-box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
    -webkit-box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
    box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
            }


            .signuponepage .form-element{
                margin-bottom: 10px;
                position: relative;
            }

            .signuponepage .new_email_phone {
                margin-top: 40px;
            }

            input[type=text] {
                font-size:16px;
                color: #333;
                box-sizing: border-box;
                width: 100%;
                display: inline-block;
                -webkit-box-sizing: border-box;
                -moz-box-sizing: border-box;
                box-sizing: border-box;
            }
            input[type=text]:focus {
                outline: none;
            }

            .custom_input_box{border: 0; padding: 4px 0; border-bottom: 1px solid #ccc; background-color: transparent;}
            .custom_input_box ~ .focus-border{position: absolute; bottom: 0; left: 0; width: 100%; height: 2px; z-index: 99;}
            .custom_input_box ~ .focus-border:before, 
            .custom_input_box ~ .focus-border:after{content: ""; position: absolute; bottom: 0; left: 0; width: 0; height: 100%; background-color: #663399; transition: 0.4s;}
            .custom_input_box ~ .focus-border:after{left: auto; right: 0;}
            .custom_input_box:focus ~ .focus-border:before, 
            .custom_input_box:focus ~ .focus-border:after,
            .has-content.custom_input_box ~ .focus-border:before,
            .has-content.custom_input_box ~ .focus-border:after{width: 50%; transition: 0.5s;}
            .custom_input_box ~ label{font-size: 12px; position: absolute; left: 0; width: 100%; color: #aaa; top: 3px; transition: 0.5s; z-index: 1;}
            .custom_input_box:focus ~ label, .custom_input_box:valid ~ label, .has-content.custom_input_box ~ label{top: -20px; font-size: 12px; color: #663399; transition: 0.5s;}
            .custom_input_box:hover ~ label{color: #663399;}

            .g-button {
                display: block;
                padding: 12px 14px;
                color: #663399;
                border: none;
                text-decoration: none;
                font-size: 13px;
                cursor: pointer;
                background-color: rgba(255,255,255, 0);
            }
            .g-button:focus {
                outline: none;
            }
            .signup-errors {
                margin: 10px;
                font-size: 12px;
                display : block;
                color: #cc0000;
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

            .otp_sms_image {
                width: 200px;
                height: 200px;
                background-size: 200px 200px;
                background-image: url(/rele/img/otp-image.png);
            }

            .send_otp_sms_image {
                width: 200px;
                height: 200px;
                background-size: 200px 200px;
                background-image: url(/rele/img/send-otp-image.png);
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

            .float-item-left > * {
                float:left;
            }
            .float-item-right > * {
                float:right;
            }

        </style>
    </head>
    <body>

        <div class="wrapper" id="wrapper">

            <div class="google-header-bar">
                <div class="header content clearfix">
                    <div class="float-item-left">
                        <div class="header_elem_link"><a href="/signup/"><spring:message code="login.label.createaccount"/></a></div>
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
                        <h1><spring:message code="accountverify.label.h1"/></h1>
                        <c:if test="${verifyaccount.verify==null}">
                            <div class="send_otp_sms_image"></div>
                            <p>We will send an OTP on ${verifyaccount.emailphone}</p>
                            <p>If you want to proceed, then click on 'Send OTP'</p>
                        </c:if>
                        <form:form name="verifyaccount" modelAttribute="verifyaccount" method="post" action="">

                            <c:if test="${verifyaccount.success!=null}">
                                <p class="update_success"><spring:message code="${verifyaccount.success}"/></p>
                            </c:if>
                            <c:if test="${verifyaccount.verify!=null}">
                                <form:hidden path="emailphone" id="emailphone" autocorrect="off" autocomplete="off" spellcheck="false"/>

                                <div class="otp_sms_image"></div>
                                <div class="form-element">
                                    <form:input path="verifycode" id="verifycode" class="custom_input_box" autocorrect="off" autocomplete="off" spellcheck="false" maxlength="6"/>
                                    <form:label path="verifycode"><spring:message code="accountverify.label.verifycode"/></form:label>
                                        <span class="focus-border"></span>
                                    </div>
                                <c:if test="${verifyaccount.errors!=null}">
                                    <div class="signup-errors"><spring:message code="${verifyaccount.errors}"/></div>
                                </c:if>
                                <form:hidden path="rnlm" id="rnlm" autocorrect="off" autocomplete="off" spellcheck="false"/>
                                <form:button name="verify" id="verify" class="g-button" value="submit"><spring:message code="accountverify.label.verify"/></form:button>
                                <form:button name="SendCodeAgain" id="SendCodeAgain" class="g-button" value="submit"><spring:message code="accountverify.label.sendpaaswdagain"/></form:button>
                            </c:if>
                            <c:if test="${verifyaccount.change!=null}">
                                <div class="form-element new_email_phone">
                                    <form:input path="emailphone" id="emailphone" class="custom_input_box" autocorrect="off" autocomplete="off" spellcheck="false"/>
                                    <form:label path="emailphone">New email or phone</form:label>
                                        <span class="focus-border"></span>
                                    </div>
                                <c:if test="${verifyaccount.errors!=null}">
                                    <div class="signup-errors"><spring:message code="${verifyaccount.errors}"/></div>
                                </c:if>

                                <form:hidden path="rnlm" id="rnlm" autocorrect="off" autocomplete="off" spellcheck="false"/>
                                <form:button name="change" id="change" class="g-button" value="submit">Change</form:button>
                                <form:button name="SendCode" id="SendCode" class="g-button" value="submit">Send OTP</form:button>
                            </c:if>
                            <c:if test="${(verifyaccount.verify==null)&&(verifyaccount.change==null)}">
                                <form:hidden path="emailphone" id="emailphone" autocorrect="off" autocomplete="off" spellcheck="false"/>
                                <form:hidden path="rnlm" id="rnlm" autocorrect="off" autocomplete="off" spellcheck="false"/>
                                <c:if test="${verifyaccount.phone==null}"><form:button name="SendCode" id="SendCode" class="g-button" value="submit">Send OTP</form:button></c:if>
                                <c:if test="${verifyaccount.phone!=null}"><form:button name="SendCode" id="SendCode" class="g-button" value="submit">Send Text OTP</form:button><form:button name="CallCode" id="CallCode" class="g-button" value="submit"><spring:message code="accountverify.label.requestcallcode"/></form:button></c:if>

                            </c:if>
                            <c:if test="${(verifyaccount.email!=null)&&(verifyaccount.change==null)}">
                                <form:button name="change" id="change" class="g-button" value="submit"><spring:message code="accountverify.label.changeemail"/></form:button>
                                <form:button name="change" id="change" class="g-button" value="submit"><spring:message code="accountverify.label.usephone"/></form:button>
                            </c:if>
                            <c:if test="${(verifyaccount.phone!=null)&&(verifyaccount.change==null)}">
                                <form:button name="change" id="change" class="g-button" value="submit"><spring:message code="accountverify.label.changephone"/></form:button>
                                <form:button name="change" id="change" class="g-button" value="submit"><spring:message code="accountverify.label.useemail"/></form:button>
                            </c:if>
                        </form:form>
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
        <script type="text/javascript" src="/rele/js/uiDJjSKEmmd.js"></script>
    </body>
</html>
