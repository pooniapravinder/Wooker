<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@taglib uri="http://www.springframework.org/tags" prefix="spring"%><%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%><%@page contentType="text/html" pageEncoding="UTF-8"%><%@page session="false"%><!DOCTYPE html>
<html lang="en-US" id="wooker">
    <head>
        <meta name="keywords" content="Wooker Invalid Page Access">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
        <meta name="theme-color" content="#663399">
        <link rel="shortcut icon" href="//www.google.com/favicon.ico"/>
        <meta name="description" content="Login to Wooker and get Connected with World">
        <meta name="google" content="notranslate">
        <title>Invalid Access to Page</title>
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
                margin: 0 0 .46em;
            }
            p {
                line-height: 17px;
                margin: 0 0 0em;
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
                height: 71px;
                background-color: #663399;
                overflow: hidden;
            }
            .header {
                color: white;
                padding-top: 22px;
                font-size: 14px;
                white-space: nowrap;
            }
            .header ul {
                line-height: 30px;
                max-width: 100%;
            }
            .header ul li {
                display: inline;
                padding: 0 1.1em 0 0;
            }
            .header a {
                color: white;
            }
            .header .left-ul {
                float: left;
            }
            
            .header .left-ul-margin {
                margin-left: 120px;
            }
            
            .header .right-ul {
                float: right;
            }

            .main {
                margin: 0 auto;
                width: 650px;
                padding-top: 0px;
                padding-bottom: 0;
            }
            .google-footer-bar {
                position: absolute;
                bottom: 0;
                height: 35px;
                width: 100%;
                overflow: hidden;
                background-color: #663399;
            }
            .footer {
                color: white;
                padding-top: 12px;
                font-size: 11px;
                white-space: nowrap;
                line-height: 0;
            }
            .footer ul {
                max-width: 100%;
            }
            .footer ul li {
                display: inline;
                padding: 0 1.5em 0 0;
            }
            .footer a {
                color: white;
            }
            .footer .left-ul {
                float: left;
            }
            .footer .right-ul {
                float: right;
            }

            .footer .copyright {
                list-style: none;
                line-height: 17px;
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
                background-color: #fff;
                width: 362px;
                float: right;
            }
            .signuponepage .signup-box {
                margin: 0;
                padding: 50px;
                -moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
                -webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
                box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
            }


            .signuponepage .form-element{
                margin-bottom: 50px;
                position: relative;
            }

            input[type=text], input[type=password] {
                font-size:16px;
                color: #333;
                box-sizing: border-box;
                width: 100%;
                display: inline-block;
                -webkit-box-sizing: border-box;
                -moz-box-sizing: border-box;
                box-sizing: border-box;
            }
            input[type=text]:focus, input[type=password]:focus {
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
            .wooker-logo {
                width: 100px;
                height: 100px;
                background-size: 100px 100px;
                background-image: url(/rele/img/wooker-logo.png);
                margin-left: 80px;
                margin-bottom: 40px;
                transition: 1.5s;
            }
            .wooker-logo:hover {
                width: 150px;
                height: 150px;
                background-size: 150px 150px;
                background-image: url(/rele/img/wooker-logo2.png);
                margin-left: 80px;
                margin-bottom: 40px;
                transition: 1.5s;
            }
            .g-button {
                margin: 20px 0 0 70px;
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
            .signuponepage .login-errors {
                margin-left: 10px;
                margin-bottom: 35px;
                font-size: 12px;
                display : block;
                color: #cc0000;
            }
            .signuponepage .login-help {
                width: 100%;
                margin: 50px 60px 0;
            }
            .login-help a {
                color: #663399;
                outline-color: #663399;
            }
            .signuponepage .login_learn_more {
                width: 100%;
                margin: 1em 0px 0;
            }
            .login_learn_more a {
                color: #663399;
                outline-color: #663399;
            }
            .main {
                width: 850px;
            }
            .main h1 {
                text-align: center;
                font-family: 'Open Sans', arial;
                color: #555;
                font-size: 45px;
                margin: 0 0 1.92em;
            }
            .main .show_email_phone {
                word-wrap: break-word;
                text-align: center;
                font-family: 'Open Sans', arial;
                color: #663399;
                font-size: 15px;
                font-weight: 300;
                margin: .92em;
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
                .copyright {
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
            .side-content h2 {
                text-align: center;
                font-family: 'Open Sans', arial;
                color: #737373;
                font-size: 20px;
                font-weight: 300;
                margin: .92em;
            }
            .side-content p {
                text-align: center;
                font-family: 'Open Sans', arial;
                color: #737373;
                font-size: 13px;
            }
            .device {
                overflow: hidden;
                width: 32em;
                height:36em;
                padding:0;
                background: url(/rele/img/mobile.svg) no-repeat 100% 0%;
                background-size: 100%;
                -webkit-user-select: none;
                -moz-user-select: none;
                -ms-user-select: none;
                -webkit-touch-callout: none;
                -khtml-user-select: none;
            }

            .device__screen {
                overflow: hidden;
                height: 80%;
                margin: 115px 13.9% 0;
                box-shadow: inset 0 5.2em 0 rgba(0, 0, 0, 0.3);
                background: #663399;
            }

            .list {
                padding-top: 6em;
            }

            .list__item {
                color: white;
                text-align: center;
                margin: 1em 1.25em;
                padding: 1em 1em;
                pointer-events: none;
                border-radius: 4px;
                background: rgba(0, 0, 0, 0.1);
            }


        </style>
    </head>
    <body>
            
            <div class="wrapper" id="wrapper">

            <div class="google-header-bar">
                <div class="header content clearfix">
                    <div class="left-ul">
                        <ul>
                            <li><a href="/login/">Log In</a></li>
                            <li class="left-ul-margin"><a href="/signup/">Create Account</a></li>
                        </ul>
                    </div>

                    <div class="right-ul">
                        <ul>
                            <li><a href="">Language</a></li>
                            <li><a href="">Wooks</a></li>
                            <li><a href="">World</a></li>
                        </ul>
                    </div>
                </div>
            </div>
                        
            <h1>Invalid Page Access</h1>
            <h2>Sorry, you can't access this page right now</h2>
            
            
                        <div class="google-footer-bar">
                <div class="footer content clearfix">
                    <div class="left-ul">
                        <ul>
                            <li><a href="">Terms</a></li>
                            <li><a href="">Privacy Policy</a></li>
                            <li><a href="">Feedback</a></li>
                        </ul>
                    </div>
                    <div class="right-ul">
                        <ul>
                            <li><a href="">About</a></li>
                            <li><a href="">Cookies</a></li>
                        </ul>
                    </div>
                </div>
            </div>
                        
            </div>
    </body>
</html>