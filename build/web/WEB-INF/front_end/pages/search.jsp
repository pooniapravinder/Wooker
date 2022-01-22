<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%><%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@taglib uri="http://www.springframework.org/tags" prefix="spring"%><%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%><%@page contentType="text/html" pageEncoding="UTF-8"%><%@page session="false"%><!DOCTYPE html>
<html lang="en-US" id="wooker"><c:set var="requestURI" value="${requestScope['javax.servlet.forward.request_uri']}"/>
    <head>
        <meta name="keywords" content="See your Primary Info">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
        <meta name="theme-color" content="#663399">
        <link rel="shortcut icon" href="//www.google.com/favicon.ico"/>
        <meta name="description" content="See or check your Primary Info">
        <meta name="google" content="notranslate">
        <title><c:out value="${param.searchQuery}"/></title>
        <link rel="stylesheet" type="text/css" href="/rele/css/styleone.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/styletwo.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/stylethree.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/yEjdNkrPfkLRRcDDe.css">
    </head>
    <body>
            <%@include file="header.jsp"%>
        <div class="wrapper animate_in" id="wrapper">
            <div class="info_page main clearfix" id="web_view">
            <div class="content">


                <c:set var="page" value="${param.page.matches('^(?:[0-9]){1,11}$') ? param.page : 0}"/>
                <jsp:useBean id="getResult" class="hibernate.query.SearchQuery"/>
                <c:set var="results" value="${getResult.getSearchResult(param.searchQuery, user, page)}"/>
                <c:set var="totalResults" value="${getResult.SearchResultTotal(param.searchQuery, user)}"/>
                <fmt:parseNumber var="totalPage" integerOnly="true" type="number" value="${(totalResults-1)/10}" />
<div class="dgsd_fdgd">
                            <div class="how_may_i_help" id="how_may_i_help"></div>
                        <form:form name="searchuser" modelAttribute="searchuser" method="get" action="/search/">
                            <div class="form-element">
                                <form:input path="searchQuery" id="searchQuery" class="custom_search_box" autocorrect="off" autocomplete="off" spellcheck="false" required="true"/>
                                <form:label path="searchQuery">Search on Wooker</form:label>
                                    <span class="focus-border"></span>
                                
                                    
    <form:button name="search" id="abc" class="button-holder" value="submit">Search</form:button>
</div>
                        </form:form>
                            </div>

                <div class="dsf_jhg__k"><a href="/search/recent/">View Recent Searches</a></div>
                
                <c:if test="${page>totalPage}"><c:redirect url = "${requestURI}?searchQuery=${crypto.encodeURL(param.searchQuery)}"/></c:if>
                <c:if test="${page>0 && page<=totalPage}"><div class="uop_ppa"><a href="${requestURI}?searchQuery=${crypto.encodeURL(param.searchQuery)}<c:if test='${((page-1)!=0)}'>&amp;page=${page-1}</c:if>">Previous Results</a></div></c:if>
                <c:forEach items="${results}" var="data">
                    <c:set var="userDetails" value="${getUserData.getPriInfo(data.userId)}"/>
                    <c:set var="otherUser" value="${crypto.encrypt(data.userId)}"/>
                    <c:set var="userSQQ" value="${crypto.encrypt(getImage.getAccountPic(data.userId).getPicId())}"/>
                    <div class="fdger_ghfdfd">
                        <div class="rtr_fdss">
                            <div class="qwcd nhy">
                                <a href="/info/?sqq=${crypto.encodeURL(otherUser)}">
                                    <c:choose>
                                        <c:when test="${userSQQ!=null}">
                                            <div class="wethj_gf">
                                                <img src="/account/pic/show/a1/?sqq=${crypto.encodeURL(userSQQ)}" alt="img">
                                            </div>
                                        </c:when>
                                        <c:otherwise>
                                            <div class="wethj_gf">
                                                <img src="/account/pic/show/user/default/a1/">
                                            </div>
                                        </c:otherwise>
                                    </c:choose>
                                </a>
                            </div>
                        </div>

                        <div class="_fgfd_bfdg">
                            <div class="uu_pp fffty">
                                <a href="/user/chat/?sqq=${crypto.encodeURL(otherUser)}">${userDetails.firstName} ${userDetails.lastName}</a>
                                <div class="fd_ddss">
                                    <div class="ghj_hg"><a href="/user/wooks/?sqq=${crypto.encodeURL(otherUser)}">Wooks</a></div>
                                </div>
                            </div>
                        </div>

                    </div>
                </c:forEach>



                <c:if test="${page<totalPage}"><div class="uop_ppa"><a href="${requestURI}?searchQuery=${crypto.encodeURL(param.searchQuery)}&amp;page=${page+1}">Next Results</a></div></c:if>


                <c:if test="${results.isEmpty()}">
                    Sorry no result found for: <c:out value="${param.searchQuery}"/>
                </c:if>
            </div>
            </div>
        </div>
                
        <script>
            m("searchQuery").addEventListener("focus", function () {
                as__bnm();
                m("abc").style.color="#663399";
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
