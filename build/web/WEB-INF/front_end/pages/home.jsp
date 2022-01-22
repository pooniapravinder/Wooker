<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%><%@taglib uri="http://www.springframework.org/tags" prefix="spring"%><%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%><%@page contentType="text/html" pageEncoding="UTF-8"%><%@page session="false"%><!DOCTYPE html>
<html lang="en-US" id="wooker">
    <head>
        <meta name="keywords" content="Welcome to Wooker">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
        <meta name="theme-color" content="#663399">
        <link rel="shortcut icon" href="http://www.google.com/favicon.ico">
        <meta name="description" content="You are now at Wooker home, Now you can do everything at Wooker">
        <meta name="google" content="notranslate">
        <title>Wooker</title>
        <link rel="stylesheet" type="text/css" href="/rele/css/styleone.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/styletwo.css">
    </head>
    <body>
            <%@include file="header.jsp"%>
        <div class="wrapper animate_in" id="wrapper">
            <div class="info_page main clearfix">
                <div class="content">
                <div class="sidebar_collapser" id="sidebar_show">&#9776;</div>
                <div class="sidebar_logout" id="sidebar_show"><a href="/logout/?logout_id=${CurrentUser.getLogoutValue()}">LogOut</a></div>
                <div class="dgsd_fdgd">
                    <div class="wooker-logo" id="wooker-logo"></div>
                    <div class="how_may_i_help" id="how_may_i_help"></div>
                    <form:form name="searchuser" modelAttribute="searchuser" method="get" action="/search/">
                        <div class="home_search-element">
                            <form:input path="searchQuery" id="searchQuery" class="custom_search_box" autocorrect="off" autocomplete="off" spellcheck="false" required="true"/>
                            <form:label path="searchQuery">Search on Wooker</form:label>
                                <span class="focus-border"></span>
                            <form:button name="search" class="button-holder" value="submit">Search</form:button>
                            </div>
                    </form:form>
                </div>
            </div>
            </div>
        </div>
        <script>
            m("sidebar_show").onclick=function(){m_p("block");};m("sidebarOverlay").onclick=function(){m_p("none");};
            function m_p(x){a("sidebar");a("sidebarOverlay");function a(c){m(c).style.display = x;}}

            m("searchQuery").addEventListener("focus", function () {
                as__bnm();
            });
            m("searchQuery").addEventListener("keyup", function () {
                as__bnmaaa_in();
            });
            m("searchQuery").addEventListener("blur", function () {
                m("how_may_i_help").className = "show_how_may_i_help fade_out";
                m("wooker-logo").className = "wooker-logo";
            });

            function inht(a) {
                m("how_may_i_help").innerHTML = a;
            }

            function as__bnm() {
                (m("searchQuery").value === "") ? as__bnmaa_in() : as__bnmaaa_in();
                m("wooker-logo").className = "hover-the-wooker";
            }
            function as__bnmaa_in() {
                inht("How may i help you?");
                m("how_may_i_help").className = "show_how_may_i_help fade_in";
            }
            function as__bnmaaa_in() {
                m("how_may_i_help").className = "show_how_may_i_help fade_in";
                inht("Need help say 'Hey Wooker'");
            }

            function m(a) {
                return window.document.getElementById(a);
            }
        </script>
    </body>
</html>
