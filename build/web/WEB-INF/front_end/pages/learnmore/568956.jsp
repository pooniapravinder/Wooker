<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%><%@page contentType="text/html" pageEncoding="UTF-8"%><%@page session="false"%><!DOCTYPE html>
<html lang="en-US" id="wooker">
    <head>
        <meta name="keywords" content="Learn more about Updating Primary Info on Wooker">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
        <meta name="theme-color" content="#663399">
        <link rel="shortcut icon" href="//www.google.com/favicon.ico"/>
        <meta name="description" content="Learn more about updating primary info on wooker">
        <meta name="google" content="notranslate">
        <title>Update Primary Info - Learn More</title>
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
            input:-webkit-autofill {
                -webkit-box-shadow: 0 0 0 30px #fff inset;
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
                background-color: #fff;
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
                box-sizing: border-box;
                -webkit-box-sizing: border-box;
                -moz-box-sizing: border-box;
                -ms-box-sizing: border-box;
                -o-box-sizing: border-box;
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
                background-repeat: no-repeat;
                margin-left: 80px;
                margin-bottom: 40px;
                transition: 1.5s;
            }
            .wooker-logo:hover {
                width: 150px;
                height: 150px;
                background-size: 150px 150px;
                background-image: url(/rele/img/wooker-logo2.png);
                background-repeat: no-repeat;
                margin-left: 80px;
                margin-bottom: 40px;
                transition: 1.5s;
            }
            .g-button {

                margin: 20px auto 0 auto;
                -webkit-appearance: none;
                -moz-appearance: none;
                -ms-appearance: none;
                -o-appearance: none;
                display: block;
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
                display: block;
                width: 60%;
                margin: 50px auto 0 auto;
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

            .login_layout {
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
            @keyframes fontfix {
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

            .float-item-left > * {
                float:left;
            }
            .float-item-right > * {
                float:right;
            }
            
            .show_pic_avatar {
                margin-top: 50px;
                float: left;
                width: 430px;
                height: 480px;
                background-size: 430px 480px;
                box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
                -webkit-box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
                -moz-box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
                -ms-box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
                -o-box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
            }
            
            .uio_pooa {
                color: #555;
            }

        </style>

    </head>
    <div class="wrapper animate_in" id="wrapper">



        <div class="google-header-bar">
            <div class="header content clearfix">
                <div class="float-item-left">
                    <div class="header_elem_link"><a href="/info/edit/">Edit Primary Info</a></div>
                </div>
                <div class="float-item-right">
                    <div class="header_elem_link">
                        <div class="lang_style" id="lang_style"><a href="">Language</a></div>
                        <div class="custom-select" id="custom-select">
                            <select id="lang_loc" name="lang_loc">
                                <option value="en_us">English (US)</option>
                                <option value="en_uk">English (UK)</option>
                                <option value="hi_in">??????????????????</option>       
                                <option value="pu_in">??????????????????</option>
                                <option value="bn_in">???????????????</option>
                                <option value="te_in">??????????????????</option>
                                <option value="mr_in">???????????????</option>
                                <option value="ta_in">???????????????</option>
                                <option value="gu_in">?????????????????????</option>
                                <option value="kn_in">???????????????</option>
                                <option value="ml_in">??????????????????</option>
                                <option value="en_us">English (US)</option>
                                <option value="en_uk">English (UK)</option>
                                <option value="hi_in">??????????????????</option>       
                                <option value="pu_in">??????????????????</option>
                                <option value="bn_in">???????????????</option>
                                <option value="te_in">??????????????????</option>
                                <option value="mr_in">???????????????</option>
                                <option value="ta_in">???????????????</option>
                                <option value="gu_in">?????????????????????</option>
                                <option value="kn_in">???????????????</option>
                                <option value="ml_in">??????????????????</option>
                            </select>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="signuponepage main content clearfix">
            <div class="sign-up">
                <div class="signup-box">
                    <p class="uio_pooa">If you will update</p>
                </div>
            </div>
            <div class="side-content">
                <img src="/rele/img/32618556.jpg" class="show_pic_avatar">
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
                <div class="copyright">Wooker&nbsp;&copy;&nbsp;<%= new java.text.SimpleDateFormat("yyyy").format(new java.util.Date()) %></div>
            </div>
        </div>
    </div>
</body>
</html>