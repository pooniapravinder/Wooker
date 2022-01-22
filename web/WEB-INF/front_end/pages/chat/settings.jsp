<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%><%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%><%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@taglib uri="http://www.springframework.org/tags" prefix="spring"%><%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%><%@page contentType="text/html" pageEncoding="UTF-8"%><%@page session="false"%><!DOCTYPE html>
<html lang="en-US" id="wooker"><c:set var="requestURI" value="${requestScope['javax.servlet.forward.request_uri']}"/>
    <head>
        <meta name="keywords" content="Privacy for chat user at Wooker">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
        <meta name="theme-color" content="#663399">
        <link rel="shortcut icon" href="http://www.google.com/favicon.ico">
        <meta name="description" content="Privacy for chat user at Wooker">
        <meta name="google" content="notranslate">
        <title>Chat Settings</title>
        <link rel="stylesheet" type="text/css" href="/rele/css/styleone.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/styletwo.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/kuEopDjfRmEKf.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/UwoirFRJrjdkrRkf.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/IoDJnmdJdDE.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/dfrtSdeDrFrs.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/WtRrfdoTrRtTGrR.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/JuiLOdOpp.css">
    </head>
    <body>
            <%@include file="../header.jsp"%>
        <div class="wrapper animate_in" id="wrapper">
            <div class="info_page main clearfix" id="web_view">
                <div class="content">
                <h1>Chat Settings</h1>

                <div class="dsf_ds">
                    <form:form method="post" name="chatsettings" modelAttribute="chatsettings" action="${requestURI}?sqq=${crypto.encodeURL(param.sqq)}">
                        <div class="fgf_fgdd"><form:label path="wooks" class="contain_checkbox"><form:checkbox path="wooks" id="wooks" value="true"/><span class="custom_checkbox"></span>Wooks</form:label></div>
                        <div class="fgf_fgdd"><form:label path="remove" class="contain_checkbox"><form:checkbox path="remove" id="remove" value="true"/><span class="custom_checkbox"></span>Remove</form:label></div>
                        <div class="fgf_fgdd"><form:label path="block" class="contain_checkbox"><form:checkbox path="block" id="block" value="true"/><span class="custom_checkbox"></span>Block</form:label></div>
                        <div class="fgf_fgdd"><form:label path="starred" class="contain_checkbox"><form:checkbox path="starred" id="starred" value="true"/><span class="custom_checkbox"></span>Starred</form:label></div>
                        <div class="fgf_fgdd"><form:label path="priority" class="contain_checkbox"><form:checkbox path="priority" id="priority" value="true"/><span class="custom_checkbox"></span>Priority</form:label></div>
                        <div class="fgf_fgdd"><form:label path="mute" class="contain_checkbox"><form:checkbox path="mute" id="mute" value="true"/><span class="custom_checkbox"></span>Mute/Unmute</form:label></div>
                        <div class="fgf_fgdd"><form:label path="offchat" class="contain_checkbox"><form:checkbox path="offchat" id="offchat" value="true"/><span class="custom_checkbox"></span>Off-Chat/On-Chat</form:label></div>
                        <div class="fgf_fgdd"><form:label path="privacy" class="contain_checkbox"><form:checkbox path="privacy" id="privacy" value="true"/><span class="custom_checkbox"></span>Privacy</form:label></div>
                        <div class="fgf_fgdd"><form:label path="settings" class="contain_checkbox"><form:checkbox path="settings" id="settings" value="true"/><span class="custom_checkbox"></span>Settings</form:label></div>
                        <div class="fgf_fgdd"><form:label path="msgTime" class="contain_checkbox"><form:checkbox path="msgTime" id="msgTime" value="true"/><span class="custom_checkbox"></span>Message Time</form:label></div>
                        <div style="margin-bottom: 20px;"><form:label path="msgLength">Messages Length:</form:label><div class="custom-select custom-select-birdate"><form:select path="msgLength" id="msgLength" class="custom-select-box"><form:option value="5">5</form:option><form:option value="10">10</form:option><form:option value="15">15</form:option><form:option value="20">20</form:option></form:select></div></div>
                            <div class="chat_wallpaper" id="chat_wallpaper">Chat Wallpaper</div>

                            <div class="wallpaper-mask"></div>
                            <div class="modal_view a_modal_view">
                                <div class="wallpaper-contents">
                                    <div class="header_wallpaper" id="default_wallpaper">Default</div><div class="header_wallpaper" id="upload_wallpaper">Upload</div>
                                    <span class="close-button" id="close-modal-dialog">&times;</span>
                                    <div class="modal_separartor"></div>








                                </div>
                            </div>
                        <form:button name="update" id="update" class="form_update_button" value="submit">Update</form:button>
                    </form:form>
                </div>

            </div>
            </div>
        </div>
        <script type="text/javascript" src="/rele/js/GYhdUdJiI.js"></script>
        <script>
            var agt = function (a) {
                return document.getElementById(a);
            };
            var agl = function (a) {
                return document.querySelector(a);
            };
            var am = function (a) {
                a.parentNode.removeChild(a);
            };
            var URLParser = function (url) {
                this.url = url || window.location.href;
            };
            URLParser.prototype.parse = function (url) {
                var tempArr, returnObj = {};
                this.url = url || this.url;
                tempArr = this.url.split("?");
                returnObj.baseURL = tempArr[0];
                returnObj.params = {};
                if (tempArr.length > 1) {
                    returnObj.queryString = tempArr[1];
                    tempArr = tempArr[1].split("&");
                    for (var i = 0; i < tempArr.length; i++) {
                        var item = tempArr[i].split("=");
                        returnObj.params[item[0]] = item[1];
                    }
                } else {
                    returnObj.queryString = "";
                }
                return returnObj;
            };
            var modal = agl(".modal_view");
            var mask = agl(".wallpaper-mask");
            function toggleModal() {
                var a = function (a) {
                    a.classList.toggle("show-modal");
                };
                a(modal);
                a(mask);
            }


            agt("chat_wallpaper").onclick = function () {
                toggleModal();
                _al();
                al();
            };

            function _al() {
                ajm(null, "modal_content", agl(".wallpaper-contents"));
            }

            function al() {
                var x = ["y458yUCKqy+ywRjhQ+/ONQ", "n1jw237jA6IOlATR63C8OQ", "Y4qA317fMER0KSf0deVFHw", "4tM67Otk5AxWw42sSd5XCw", "UQ98DK0Yqf793A0MlV/9Gg", "qFCq6wFc6+2w/f3jTeoF8w", "ygrbhPUkiKZeEKnYu+l0Ow", "ARyf9/q2Mw7N6Yp/phOpLg", "LZHVm/bRH83xbp3bKJQ7mA", "oRkfofYVCiIbZJeiWyIFRg", "t0BTh9iAIY99q8s+mJLs2g", "07AFtOHX2JrgEWdWYlb5xg", "WZlXnIcLU9SZhxJ7S8D3kA", "EoadkXh2ceIUjzAUFEvR8A", "fNA92ipEZh78g2OHeykLpA", "N32esdXB6A9r856rS5AkFA", "IIzC5knnq2yHoeUZuEnhAA", "oDeey9u2DjGQ/TDXg4Kg8g", "F2xjqjwQMl6ealG2h9uwRA", "XZIPe5GSUu9H6Vdq8J3PCQ", "iO5ttjpogW43KE9A3nD8VQ"];
                ajm(":fG", "uio_ad", agl(".modal_content"));
                for (i = 0; i < x.length; i++) {
                    var a = document.createElement("img");
                    a.setAttribute("src", "/chat/wallpaper/avc/w/tyul/i/p/tj/a3/?sqq=" + encodeURIComponent(x[i]));
                    a.setAttribute("class", "chat_wallpaper_sides");
                    agt(":fG").appendChild(a);
                    a.addEventListener("click", function (a) {
                        if (!a.target)
                            return;
                        var up = new URLParser(), x = agt("defWallpaper"), y = up.parse(a.target.src).params["sqq"], z = agt("chatsettings");
                        if (x)
                            x.value = y;
                        else
                            _o(y, z, "defWallpaper");
                        toggleModal();
                        a__m();
                    });
                }
            }


            agt("close-modal-dialog").onclick = function () {
                toggleModal();
                a__m();
            };
            document.onkeydown = function (e) {
                e = e || window.event;
                if ((e.keyCode === 27) && (agl(".modal_content"))) {
                    toggleModal();
                    a__m();
                }
            };
            mask.onclick = function () {
                if (modal) {
                    toggleModal();
                    a__m();
                }
            };
            agt("default_wallpaper").onclick = function () {
                if (!agt(":fG")) {
                    var x = agt(":fU");
                    if (x)
                        am(x);
                    al();
                }
            };
            agt("upload_wallpaper").onclick = function () {
                if (!agt(":fU")) {
                    var x = agt(":fG");
                    if (x)
                        am(x);
                    ah();
                }
                function ah() {
                    ajm(":fU", null, agl(".modal_content"));
                    var ab = document.createElement("form");
                    ab.setAttribute("action", '/chat/option/perform/settings/wallpaper/upload/');
                    ab.setAttribute("id", "myForm");
                    ab.setAttribute("onsubmit", "return _sFD(this);");
                    agt(":fU").appendChild(ab);
                    var xy = document.createElement("div");
                    xy.setAttribute("id", ":wp");
                    xy.setAttribute("class", "wallpaper_preview_container");
                    ab.appendChild(xy);

                    var x = document.createElement("input");
                    x.type = "file";
                    x.className = "choose_upload_wallpaper";
                    x.name = "img";
                    x.id = "img";
                    x.setAttribute("title", "Select Wallpaper");
                    agt(":wp").appendChild(x);
                    
                    
                    
                    x.onchange = function () {
                        if (x.files && x.files[0]) {
                            var b = new FileReader();
                            b.onload = function (e) {
                                agt(":uwP").setAttribute("src", e.target.result);
                            };
                            b.readAsDataURL(x.files[0]);
                        }
                    };
                    var a = document.createElement("img");
                    a.setAttribute("src", "/rele/img/upload.svg");
                    a.setAttribute("id", ":uwP");
                    a.setAttribute("class", "wallpaper_default_preview");
                    agt(":wp").appendChild(a);
                    var b = document.createElement("button");
                    b.setAttribute("type", "submit");
                    b.setAttribute("class", "set_wallpaper");
                    b.innerHTML = "Set Wallpaper";
                    ab.appendChild(b);
                }
            };

            function _sFD() {
                var data = "?bx=abc";
                alert(data);
                __w('POST', '/chat/option/perform/settings/wallpaper/upload/', data, _d, _e);
                return false;
            }
            ;
            function _o(a, b, c) {
                var x = document.createElement("input");
                x.type = "hidden";
                x.value = a;
                x.name = c;
                b.insertBefore(x, b.childNodes[0]);
            }
            function a__m() {
                setTimeout(function () {
                    am(agl(".modal_content"));
                }, 400);
            }
            function ajm(x, y, z, p) {
                var a = document.createElement("div");
                if (x)
                    a.setAttribute("id", x);
                if (y)
                    a.setAttribute("class", y);
                if (p)
                    a.innerHTML = p;
                z.appendChild(a);
            }

            function __w(a, b, c, d, e) {
                function agh() {
                    try {
                        try {
                            return new XMLHttpRequest();
                        } catch (a) {
                            return new ActiveXObject("Msxml2.XMLHTTP");
                        }
                    } catch (a) {
                        return new ActiveXObject("Microsoft.XMLHTTP");
                    }
                }
                var x = {makeRequest: agh}, y = x.makeRequest();
                y.open(a, b, !0);
                y.onreadystatechange = function () {
                    if (y.readyState === 4) {
                        if (y.status < 200 || y.status >= 300) {
                            d(y.responseText);
                            return;
                        }
                        e(y.responseText);
                    }
                };
                a === "POST" ? (y.setRequestHeader("Content-Type", "application/x-www-form-urlencoded"), y.send(c)) : y.send();
            }
            var jP = function (a) {
                return JSON.parse(a);
            };

            function _d(y) {
                x_c(y);
            }

            function _e(p) {
                var x = jP(p);
                x_c(x.status);
                setTimeout(function () {
                    am(agl(".res_result"));
                    if (x.type) {
                        toggleModal();
                        a__m();
                    }
                }, 3000);
            }
            
            function x_c(st) {
                var a = document.createElement("div"), b = agt(":fU");
                a.setAttribute("class", "res_result");
                a.innerHTML = st;
                b.insertBefore(a, b.childNodes[0]);
            }


        </script>
    </body>
</html>