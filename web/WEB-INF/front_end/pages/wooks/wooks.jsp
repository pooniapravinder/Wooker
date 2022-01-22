<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%><%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%><%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@taglib uri="http://www.springframework.org/tags" prefix="spring"%><%@page contentType="text/html" pageEncoding="UTF-8"%><%@page session="false"%><!DOCTYPE html>
<html lang="en-US" id="wooker">
    <head>
        <meta name="keywords" content="Wooks at Wooker">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
        <meta name="theme-color" content="#663399">
        <link rel="shortcut icon" href="//www.google.com/favicon.ico"/>
        <meta name="description" content="Explore the Wooks">
        <meta name="google" content="notranslate">
        <title>Wooks</title>
        <link rel="stylesheet" type="text/css" href="/rele/css/styleone.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/styletwo.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/stylethree.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/dsTdDGtVttedgRYR.css">
    </head>
    <body>
            <%@include file="../header.jsp"%>
        <div class="wrapper animate_in" id="wrapper">
            <jsp:useBean id="listWooks" class="hibernate.query.wooks.WookQuery"/>
            <jsp:useBean id="CalTime" class="timeperiod.duration.calculation.CalculateTime"/>
            <c:choose>
                <c:when test="${(crypto.decrypt(param.pagination_backward))!=null}">
                    <c:set var="pagination_backward" value="${crypto.decrypt(param.pagination_backward)}"/>
                    <c:set var="wooks" value="${listWooks.Wooks(user,pagination_backward,false)}"/>
                </c:when>
                <c:when test="${(crypto.decrypt(param.pagination_forward))!=null}">
                    <c:set var="pagination_forward" value="${crypto.decrypt(param.pagination_forward)}"/>
                    <c:set var="wooks" value="${listWooks.Wooks(user,pagination_forward,true)}"/>
                </c:when>
                <c:otherwise>
                    <c:set var="wooks" value="${listWooks.firstPageWooks(user)}"/>
                </c:otherwise>
            </c:choose>
            <c:set var="totalData" value="${fn:length(wooks)}"/>
            <div class="info_page main clearfix" id="web_view">
            <div class="content">
                <h1>Wooks</h1>
                <p class="fade_it">Make your daily life more shareable with Wooker's wooks</p>
                <div class="gr_space">
                    <form:form name="searchwook" modelAttribute="searchwook" method="post" action="/search/wook/">
                        <div class="form-element-search">
                            <form:input path="searchWook" id="searchWook" class="custom_search_box" title="Search for Wooks" autocorrect="off" autocomplete="off" spellcheck="false" required="true"/>
                            <form:label path="searchWook">Search for Wooks</form:label>
                                <span class="focus-border"></span>
                            <form:button name="search" class="button-holder" value="submit">Search</form:button>
                            </div>
                    </form:form>
                </div>
                <div class="center_element">
                    <a href="/create/wook/">Create Wook</a>

                    <div class="pre_wooks_container">
                        <div class="wook__inf_blo">
                            <img class="wooks_icon" src="/wooks/default/icons/er/vxvx/bgd/g/eret/a3/?sqq=${crypto.encodeURL('y458yUCKqy+ywRjhQ+/ONQ')}">
                            <div class="wook__inf">
                                <a href="/wooks/explore/post/account/pics/">Account Pics</a>
                            </div>
                        </div>
                        <c:forEach var="i" begin="${pagination_forward!=null ? 1 : (totalData==0 ? 1 : 0)}" end="${pagination_forward!=null ? totalData : (totalData>0 ? totalData-1 : totalData)}" step="1">
                            <c:set var="data" value="${pagination_forward!=null ? wooks[totalData-i] : wooks[i]}"/>
                             <c:if test="${i==(pagination_forward!=null ? 1 : 0)}"><c:set var="firstId" value="${data.autoId}"/></c:if>
                                    <c:if test="${i==(pagination_forward!=null ? totalData : totalData-1)}"><c:set var="lastId" value="${data.autoId}"/></c:if>
                                    <c:if test="${i==(pagination_forward!=null ? 1 : 0)}">
                                        <c:if test="${listWooks.isPagination(user,firstId,true)}"><div class="def__o"><a href="${requestURI}?pagination_forward=${crypto.encodeURL(crypto.encrypt(firstId))}">Newer</a></div></c:if>
                                    </c:if>
                                     
                                        
                            <div class="wook__inf_blo">
                                <img class="wooks_icon" src="/wooks/ndefault/icons/er/vxvx/bgd/g/eret/a2/?sqq=${crypto.encodeURL(crypto.encrypt(data.photo))}">
                            <div class="wook__inf">
                                <a href="/wooks/explore/data/m/u/ab/sh/asgr/?sqq=${crypto.encodeURL(crypto.encrypt(data.autoId))}"><c:out value="${data.title}"/></a>
                            </div>
                        </div>
                            
                            
                            
                        </c:forEach>
                                        <c:if test="${listWooks.isPagination(user,lastId,false)}"><div class="def__o"><a href="${requestURI}?pagination_backward=${crypto.encodeURL(crypto.encrypt(lastId))}">Older</a></div></c:if>
                    </div>
                            
                </div>
            </div>
            </div>
        </div>
    </body>
</html>
