<%@page contentType="text/html" pageEncoding="UTF-8"%><%@page session="false"%><!DOCTYPE html>
<html>
    <head>
        <title>Loading....</title>
        <meta name="keywords" content="Verify Wooker Account">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="theme-color" content="#663399">
        <link rel="shortcut icon" href="//www.google.com/favicon.ico"/>
        <meta name="description" content="Verify your Account and get Started to use Wooker">
        <meta name="google" content="notranslate">
    </head>
    <body>
        <script type="text/javascript">
            document.body.onload = function() {
                document.forms["redirectpost"].submit();
            };
        </script>
        <div class="loading_text">Loading....</div>
        <div class="loading">
            <div class="bullet"></div>
            <div class="bullet"></div>
            <div class="bullet"></div>
            <div class="bullet"></div>
        </div>
        <style>
            html, body {
                background-color: #f1f1f1;
            }
            .loading_text {
                font-family: arial, helvetica, sans-serif; 
                font-size:2em;
                color: #663399;
                position: absolute;
                top: 40%;
                left: 40%;
                opacity: 0.8;
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
        </style>
    </head>
    <title>Welcome at Wooker</title>
<body>
    <br>
    <form name="redirectpost" id="redirectpost" method="post" action="/verify/account/">
        <input type="hidden" name="rnlm" id="rnlm" autocorrect="off" autocomplete="off" value="<%out.print(request.getAttribute("token_value"));%>" spellcheck="false"/>
        <noscript><button name="jsdisable" id="jsdisable" value="submit">JavaScript is not enabled or not supported.</button></noscript>
    </form>
</body>    
</html>
