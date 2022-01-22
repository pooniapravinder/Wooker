<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%><%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@taglib uri="http://www.springframework.org/tags" prefix="spring"%><%@page contentType="text/html" pageEncoding="UTF-8"%><%@page session="false"%><!DOCTYPE html>
<html lang="en-US" id="wooker">
    <head>
        <meta name="keywords" content="See your Secondary Info">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
        <meta name="theme-color" content="#663399">
        <link rel="shortcut icon" href="//www.google.com/favicon.ico"/>
        <meta name="description" content="See or check your Secondary Info">
        <meta name="google" content="notranslate">
        <title>Secondary Info</title>
        <link rel="stylesheet" type="text/css" href="/rele/css/styleone.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/styletwo.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/stylethree.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/YTderHjdOEImd.css">
    </head>
    <body>
            <%@include file="header.jsp"%>
        <div class="wrapper animate_in" id="wrapper">
            <div class="info_page main clearfix" id="web_view">
                <div class="content">
                <h1>Secondary Info</h1>
                <jsp:useBean id="getOptions" class="hibernate.query.info.ShowHideInfoOpt"/>
                <c:set var="options" value="${getOptions.getMoreInfoOptions(user)}"/>
                <jsp:useBean id="getInfo" class="hibernate.query.info.MoreInfoAction"/>
                <c:set var="getData" value="${getInfo.getSecInfo(user)}"/>
                <div class="upp_ss_elem">
                    <c:if test="${(options==null)||(options.info)}"><div class="options_position"><a href="/info/">Primary Info</a></div></c:if><c:if test="${(options==null)||(options.addmoin)}"><div class="options_position"><a href="/more/info/add/">Add Secondary Info</a></div></c:if><c:if test="${(options==null)||(options.setting)}"><div class="options_position"><a href="/more/info/settings/">Settings</a></div></c:if><c:if test="${(options==null)||(options.security)}"><div class="options_position"><a href="/more/info/security/">Security</a></div></c:if>
                </div>
                <c:if test="${empty getData}">
                    <%@include file="includes/secinfo/EmptySecInfo.jsp"%>
                </c:if>
                
                
                <c:forEach items="${getData}" var="data"><c:if test="${(data.school!=null)&&((options==null)||(options.school))}">
                        <c:set var="id" value="${crypto.encrypt(data.defaultId)}"/>
                        <c:set var="picid" value="${crypto.encrypt(data.picId)}"/>
                        <c:set var="existen" value="false"/><c:set var="existle" value="false"/>
                        <c:set var="entrance" value="${fn:split(data.schoolentr, '/')}" />
                        <c:set var="leave" value="${fn:split(data.schoolleave, '/')}" />
                        <c:if test="${(entrance[0]!=0)||(entrance[2]!=0)}"><c:set var="existen" value="true"/></c:if><c:if test="${(leave[0]!=0)||(leave[2]!=0)}"><c:set var="existle" value="true"/></c:if>
                            <div class="gfg_container">
                            <c:choose><c:when test="${picid!=null}"><img src="/more/info/pic/get/?sqq=${crypto.encodeURL(picid)}" class="defft_ava"></c:when><c:otherwise><div class="school_ava"></div></c:otherwise></c:choose>
                                    <div class="rerr_cvv"><c:out value="${data.school}"/> (<spring:message code="userprivacy.label.0${data.schoolpri}"/>)</div>
                            <div class="qer_fgder">
                                <c:if test="${existen}"><a href="/school/show/data/?sqq=${crypto.encodeURL(id)}"></c:if><c:if test="${entrance[0]!=0}"><spring:message code="label.month.${entrance[0]}"/><c:if test="${entrance[1]!=0}"> ${entrance[1]}</c:if></c:if><c:if test="${entrance[0]!=0&&entrance[2]!=0}">, ${entrance[2]}</c:if><c:if test="${entrance[0]==0&&entrance[2]!=0}">${entrance[2]}</c:if><c:if test="${existen}"></a></c:if>
                                <c:if test="${existen||existle}"> - </c:if>
                                <c:if test="${existle}"><a href="/school/show/data/?sqq=${crypto.encodeURL(id)}"></c:if><c:if test="${leave[0]!=0}"><spring:message code="label.month.${leave[0]}"/><c:if test="${leave[1]!=0}"> ${leave[1]}</c:if></c:if><c:if test="${leave[0]!=0&&leave[2]!=0}">, ${leave[2]}</c:if><c:if test="${leave[0]==0&&leave[2]!=0}">${leave[2]}</c:if><c:if test="${existle}"></a></c:if>
                                </div>
                                                    <div class="qer_fgder"><c:out value="${data.schooldesc}"/></div>
                            <div class="tyll_link"><a href="/more/info/edit/school/?sqq=${crypto.encodeURL(id)}">Edit</a><c:if test="${!data.schoolPrivacy}"><a href="/more/info/set/privacy/school/?sqq=${crypto.encodeURL(id)}">Set Privacy</a></c:if><c:if test="${data.schoolPrivacy}"><a href="/more/info/remove/privacy/school/?sqq=${crypto.encodeURL(id)}">Remove Privacy</a></c:if><a href="/more/info/remove/detail/?sqq=${crypto.encodeURL(id)}">Remove</a></div>
                            </div>
                    </c:if></c:forEach>

                <c:forEach items="${getData}" var="data"><c:if test="${(data.gradcollege!=null)&&((options==null)||(options.grcollege))}">
                        <c:set var="id" value="${crypto.encrypt(data.defaultId)}"/>
                        <c:set var="picid" value="${crypto.encrypt(data.picId)}"/>
                        <c:set var="existen" value="false"/><c:set var="existle" value="false"/>
                        <c:set var="entrance" value="${fn:split(data.gradcollentr, '/')}" />
                        <c:set var="leave" value="${fn:split(data.gradcollleave, '/')}" />
                        <c:if test="${(entrance[0]!=0)||(entrance[2]!=0)}"><c:set var="existen" value="true"/></c:if><c:if test="${(leave[0]!=0)||(leave[2]!=0)}"><c:set var="existle" value="true"/></c:if>
                            <div class="gfg_container">
                                <c:choose><c:when test="${picid!=null}"><img src="/more/info/pic/get/?sqq=${crypto.encodeURL(picid)}" class="defft_ava"></c:when><c:otherwise><div class="graduate_ava"></div></c:otherwise></c:choose>
                                    <div class="rerr_cvv"><c:out value="${data.gradcollege}"/> (<spring:message code="userprivacy.label.0${data.gradcollpri}"/>)</div>
                            <div class="qer_fgder">
                                <c:if test="${existen}"><a href="/grcollege/show/data/?sqq=${crypto.encodeURL(id)}"></c:if><c:if test="${entrance[0]!=0}"><spring:message code="label.month.${entrance[0]}"/><c:if test="${entrance[1]!=0}"> ${entrance[1]}</c:if></c:if><c:if test="${entrance[0]!=0&&entrance[2]!=0}">, ${entrance[2]}</c:if><c:if test="${entrance[0]==0&&entrance[2]!=0}">${entrance[2]}</c:if><c:if test="${existen}"></a></c:if>
                                <c:if test="${existen||existle}"> - </c:if>
                                <c:if test="${existle}"><a href="/grcollege/show/data/?sqq=${crypto.encodeURL(id)}"></c:if><c:if test="${leave[0]!=0}"><spring:message code="label.month.${leave[0]}"/><c:if test="${leave[1]!=0}"> ${leave[1]}</c:if></c:if><c:if test="${leave[0]!=0&&leave[2]!=0}">, ${leave[2]}</c:if><c:if test="${leave[0]==0&&leave[2]!=0}">${leave[2]}</c:if><c:if test="${existle}"></a></c:if>
                                </div>
                                                    <div class="qer_fgder">${data.gradcolldesc}</div>
                            <div class="tyll_link"><a href="/more/info/edit/grcollege/?sqq=${crypto.encodeURL(id)}">Edit</a><c:if test="${!data.gradcollPrivacy}"><a href="/more/info/set/privacy/grcollege/?sqq=${crypto.encodeURL(id)}">Set Privacy</a></c:if><c:if test="${data.gradcollPrivacy}"><a href="/more/info/remove/privacy/grcollege/?sqq=${crypto.encodeURL(id)}">Remove Privacy</a></c:if><a href="/more/info/remove/detail/?sqq=${crypto.encodeURL(id)}">Remove</a></div>
                            </div>
                    </c:if></c:forEach>

                <c:forEach items="${getData}" var="data"><c:if test="${(data.graduniver!=null)&&((options==null)||(options.gruniver))}">
                        <c:set var="id" value="${crypto.encrypt(data.defaultId)}"/>
                        <c:set var="picid" value="${crypto.encrypt(data.picId)}"/>
                        <c:set var="existen" value="false"/><c:set var="existle" value="false"/>
                        <c:set var="entrance" value="${fn:split(data.graduniverentr, '/')}" />
                        <c:set var="leave" value="${fn:split(data.graduniverleave, '/')}" />
                        <c:if test="${(entrance[0]!=0)||(entrance[2]!=0)}"><c:set var="existen" value="true"/></c:if><c:if test="${(leave[0]!=0)||(leave[2]!=0)}"><c:set var="existle" value="true"/></c:if>
                            <div class="gfg_container">
                                <c:choose><c:when test="${picid!=null}"><img src="/more/info/pic/get/?sqq=${crypto.encodeURL(picid)}" class="defft_ava"></c:when><c:otherwise><div class="graduate_ava"></div></c:otherwise></c:choose>
                                    <div class="rerr_cvv"><c:out value="${data.graduniver}"/> (<spring:message code="userprivacy.label.0${data.graduniverpri}"/>)</div>
                            <div class="qer_fgder">
                                <c:if test="${existen}"><a href="/gruniver/show/data/?sqq=${crypto.encodeURL(id)}"></c:if><c:if test="${entrance[0]!=0}"><spring:message code="label.month.${entrance[0]}"/><c:if test="${entrance[1]!=0}"> ${entrance[1]}</c:if></c:if><c:if test="${entrance[0]!=0&&entrance[2]!=0}">, ${entrance[2]}</c:if><c:if test="${entrance[0]==0&&entrance[2]!=0}">${entrance[2]}</c:if><c:if test="${existen}"></a></c:if>
                                <c:if test="${existen||existle}"> - </c:if>
                                <c:if test="${existle}"><a href="/gruniver/show/data/?sqq=${crypto.encodeURL(id)}"></c:if><c:if test="${leave[0]!=0}"><spring:message code="label.month.${leave[0]}"/><c:if test="${leave[1]!=0}"> ${leave[1]}</c:if></c:if><c:if test="${leave[0]!=0&&leave[2]!=0}">, ${leave[2]}</c:if><c:if test="${leave[0]==0&&leave[2]!=0}">${leave[2]}</c:if><c:if test="${existle}"></a></c:if>
                                </div>
                                                    <div class="qer_fgder"><c:out value="${data.graduniverdesc}"/></div>
                            <div class="tyll_link"><a href="/more/info/edit/gruniver/?sqq=${crypto.encodeURL(id)}">Edit</a><c:if test="${!data.graduniverPrivacy}"><a href="/more/info/set/privacy/gruniver/?sqq=${crypto.encodeURL(id)}">Set Privacy</a></c:if><c:if test="${data.graduniverPrivacy}"><a href="/more/info/remove/privacy/gruniver/?sqq=${crypto.encodeURL(id)}">Remove Privacy</a></c:if><a href="/more/info/remove/detail/?sqq=${crypto.encodeURL(id)}">Remove</a></div>
                            </div>
                    </c:if></c:forEach>

                <c:forEach items="${getData}" var="data"><c:if test="${(data.pogradcollege!=null)&&((options==null)||(options.pogrcoll))}">
                        <c:set var="id" value="${crypto.encrypt(data.defaultId)}"/>
                        <c:set var="picid" value="${crypto.encrypt(data.picId)}"/>
                        <c:set var="existen" value="false"/><c:set var="existle" value="false"/>
                        <c:set var="entrance" value="${fn:split(data.pogradcollentr, '/')}" />
                        <c:set var="leave" value="${fn:split(data.pogradcollleave, '/')}" />
                        <c:if test="${(entrance[0]!=0)||(entrance[2]!=0)}"><c:set var="existen" value="true"/></c:if><c:if test="${(leave[0]!=0)||(leave[2]!=0)}"><c:set var="existle" value="true"/></c:if>
                            <div class="gfg_container">
                                <c:choose><c:when test="${picid!=null}"><img src="/more/info/pic/get/?sqq=${crypto.encodeURL(picid)}" class="defft_ava"></c:when><c:otherwise><div class="graduate_ava"></div></c:otherwise></c:choose>
                                    <div class="rerr_cvv"><c:out value="${data.pogradcollege}"/> (<spring:message code="userprivacy.label.0${data.pogradcollpri}"/>)</div>
                            <div class="qer_fgder">
                                <c:if test="${existen}"><a href="/pogrcoll/show/data/?sqq=${crypto.encodeURL(id)}"></c:if><c:if test="${entrance[0]!=0}"><spring:message code="label.month.${entrance[0]}"/><c:if test="${entrance[1]!=0}"> ${entrance[1]}</c:if></c:if><c:if test="${entrance[0]!=0&&entrance[2]!=0}">, ${entrance[2]}</c:if><c:if test="${entrance[0]==0&&entrance[2]!=0}">${entrance[2]}</c:if><c:if test="${existen}"></a></c:if>
                                <c:if test="${existen||existle}"> - </c:if>
                                <c:if test="${existle}"><a href="/pogrcoll/show/data/?sqq=${crypto.encodeURL(id)}"></c:if><c:if test="${leave[0]!=0}"><spring:message code="label.month.${leave[0]}"/><c:if test="${leave[1]!=0}"> ${leave[1]}</c:if></c:if><c:if test="${leave[0]!=0&&leave[2]!=0}">, ${leave[2]}</c:if><c:if test="${leave[0]==0&&leave[2]!=0}">${leave[2]}</c:if><c:if test="${existle}"></a></c:if>
                                </div>
                                                    <div class="qer_fgder"><c:out value="${data.pogradcolldesc}"/></div>
                            <div class="tyll_link"><a href="/more/info/edit/pogrcoll/?sqq=${crypto.encodeURL(id)}">Edit</a><c:if test="${!data.pogradcollPrivacy}"><a href="/more/info/set/privacy/pogrcoll/?sqq=${crypto.encodeURL(id)}">Set Privacy</a></c:if><c:if test="${data.pogradcollPrivacy}"><a href="/more/info/remove/privacy/pogrcoll/?sqq=${crypto.encodeURL(id)}">Remove Privacy</a></c:if><a href="/more/info/remove/detail/?sqq=${crypto.encodeURL(id)}">Remove</a></div>
                            </div>
                    </c:if></c:forEach>

                <c:forEach items="${getData}" var="data"><c:if test="${(data.pograduniver!=null)&&((options==null)||(options.pogruniv))}">
                        <c:set var="id" value="${crypto.encrypt(data.defaultId)}"/>
                        <c:set var="picid" value="${crypto.encrypt(data.picId)}"/>
                        <c:set var="existen" value="false"/><c:set var="existle" value="false"/>
                        <c:set var="entrance" value="${fn:split(data.pograduniverentr, '/')}" />
                        <c:set var="leave" value="${fn:split(data.pograduniverleave, '/')}" />
                        <c:if test="${(entrance[0]!=0)||(entrance[2]!=0)}"><c:set var="existen" value="true"/></c:if><c:if test="${(leave[0]!=0)||(leave[2]!=0)}"><c:set var="existle" value="true"/></c:if>
                            <div class="gfg_container">
                                <c:choose><c:when test="${picid!=null}"><img src="/more/info/pic/get/?sqq=${crypto.encodeURL(picid)}" class="defft_ava"></c:when><c:otherwise><div class="graduate_ava"></div></c:otherwise></c:choose>
                                    <div class="rerr_cvv"><c:out value="${data.pograduniver}"/> (<spring:message code="userprivacy.label.0${data.pograduniverpri}"/>)</div>
                            <div class="qer_fgder">
                                <c:if test="${existen}"><a href="/pogruniver/show/data/?sqq=${crypto.encodeURL(id)}"></c:if><c:if test="${entrance[0]!=0}"><spring:message code="label.month.${entrance[0]}"/><c:if test="${entrance[1]!=0}"> ${entrance[1]}</c:if></c:if><c:if test="${entrance[0]!=0&&entrance[2]!=0}">, ${entrance[2]}</c:if><c:if test="${entrance[0]==0&&entrance[2]!=0}">${entrance[2]}</c:if><c:if test="${existen}"></a></c:if>
                                <c:if test="${existen||existle}"> - </c:if>
                                <c:if test="${existle}"><a href="/pogruniver/show/data/?sqq=${crypto.encodeURL(id)}"></c:if><c:if test="${leave[0]!=0}"><spring:message code="label.month.${leave[0]}"/><c:if test="${leave[1]!=0}"> ${leave[1]}</c:if></c:if><c:if test="${leave[0]!=0&&leave[2]!=0}">, ${leave[2]}</c:if><c:if test="${leave[0]==0&&leave[2]!=0}">${leave[2]}</c:if><c:if test="${existle}"></a></c:if>
                                </div>
                                                    <div class="qer_fgder"><c:out value="${data.pograduniverdesc}"/></div>
                            <div class="tyll_link"><a href="/more/info/edit/pogruniver/?sqq=${crypto.encodeURL(id)}">Edit</a><c:if test="${!data.pograduniverPrivacy}"><a href="/more/info/set/privacy/pogruniver/?sqq=${crypto.encodeURL(id)}">Set Privacy</a></c:if><c:if test="${data.pograduniverPrivacy}"><a href="/more/info/remove/privacy/pogruniver/?sqq=${crypto.encodeURL(id)}">Remove Privacy</a></c:if><a href="/more/info/remove/detail/?sqq=${crypto.encodeURL(id)}">Remove</a></div>
                            </div>
                    </c:if></c:forEach>

                <c:forEach items="${getData}" var="data"><c:if test="${(data.worktype!=null)&&(data.workplace!=null)&&((options==null)||(options.works))}">
                        <c:set var="id" value="${crypto.encrypt(data.defaultId)}"/>
                        <c:set var="picid" value="${crypto.encrypt(data.picId)}"/>
                        <c:set var="existst" value="false"/><c:set var="existle" value="false"/>
                        <c:set var="start" value="${fn:split(data.workstart, '/')}" />
                        <c:set var="leave" value="${fn:split(data.workleave, '/')}" />
                        <c:if test="${(start[0]!=0)||(start[2]!=0)}"><c:set var="existst" value="true"/></c:if><c:if test="${(leave[0]!=0)||(leave[2]!=0)}"><c:set var="existle" value="true"/></c:if>
                            <div class="gfg_container">
                                <c:choose><c:when test="${picid!=null}"><img src="/more/info/pic/get/?sqq=${crypto.encodeURL(picid)}" class="defft_ava"></c:when><c:otherwise><div class="work_ava"></div></c:otherwise></c:choose>
                                    <div class="rerr_cvv"><c:out value="${data.worktype}"/> (<spring:message code="userprivacy.label.0${data.workpri}"/>)</div>
                            <div class="rerr_cvv"><c:out value="${data.workplace}"/></div>
                            <div class="qer_fgder">
                                <c:if test="${existst}"><a href="/work/show/data/?sqq=${crypto.encodeURL(id)}"></c:if><c:if test="${start[0]!=0}"><spring:message code="label.month.${start[0]}"/><c:if test="${start[1]!=0}"> ${start[1]}</c:if></c:if><c:if test="${start[0]!=0&&start[2]!=0}">, ${start[2]}</c:if><c:if test="${start[0]==0&&start[2]!=0}">${start[2]}</c:if><c:if test="${existst}"></a></c:if>
                                <c:if test="${existst||existle}"> - </c:if>
                                <c:if test="${existle}"><a href="/work/show/data/?sqq=${crypto.encodeURL(id)}"></c:if><c:if test="${leave[0]!=0}"><spring:message code="label.month.${leave[0]}"/><c:if test="${leave[1]!=0}"> ${leave[1]}</c:if></c:if><c:if test="${leave[0]!=0&&leave[2]!=0}">, ${leave[2]}</c:if><c:if test="${leave[0]==0&&leave[2]!=0}">${leave[2]}</c:if><c:if test="${existle}"></a></c:if>
                                </div>
                                                    <div class="qer_fgder"><c:out value="${data.workdesc}"/></div>
                            <div class="tyll_link"><a href="/more/info/edit/work/?sqq=${crypto.encodeURL(id)}">Edit</a><a href="/more/info/remove/detail/?sqq=${crypto.encodeURL(id)}">Remove</a></div>
                        </div>
                    </c:if></c:forEach>

                <c:forEach items="${getData}" var="data"><c:if test="${(data.currcity!=null)&&(data.hometown!=null)&&((options==null)||(options.location))}">
                        <c:set var="id" value="${crypto.encrypt(data.defaultId)}"/>
                        <c:set var="picid" value="${crypto.encrypt(data.picId)}"/>
                        <div class="gfg_container">
                            <c:choose><c:when test="${picid!=null}"><img src="/more/info/pic/get/?sqq=${crypto.encodeURL(picid)}" class="defft_ava"></c:when><c:otherwise><div class="location_ava"></div></c:otherwise></c:choose>
                            <div class="rerr_cvv"><c:out value="${data.currcity}"/> (<spring:message code="userprivacy.label.0${data.locationpri}"/>)</div>
                            <div class="rerr_cvv"><c:out value="${data.hometown}"/></div>
                            <div class="qer_fgder"><c:out value="${data.locationdesc}"/></div>
                            <div class="tyll_link"><a href="/more/info/edit/location/?sqq=${crypto.encodeURL(id)}">Edit</a><a href="/more/info/remove/detail/?sqq=${crypto.encodeURL(id)}">Remove</a></div>
                        </div>
                    </c:if></c:forEach>

                <c:forEach items="${getData}" var="data"><c:if test="${(data.movedfrom!=null)&&(data.movedto!=null)&&((options==null)||(options.moved))}">
                        <c:set var="id" value="${crypto.encrypt(data.defaultId)}"/>
                        <c:set var="picid" value="${crypto.encrypt(data.picId)}"/>
                        <c:set var="exist" value="false"/>
                        <c:set var="moved" value="${fn:split(data.movedtime, '/')}" />
                        <c:if test="${(moved[0]!=0)||(moved[2]!=0)}"><c:set var="exist" value="true"/></c:if>
                            <div class="gfg_container">
                            <c:choose><c:when test="${picid!=null}"><img src="/more/info/pic/get/?sqq=${crypto.encodeURL(picid)}" class="defft_ava"></c:when><c:otherwise><div class="moved_ava"></div></c:otherwise></c:choose>
                            <div class="rerr_cvv"><c:out value="${data.movedfrom}"/> (<spring:message code="userprivacy.label.0${data.movedpri}"/>)</div>
                            <div class="rerr_cvv"><c:out value="${data.movedto}"/></div>
                            <div class="qer_fgder">
                                <c:if test="${exist}"><a href="/moved/show/data/?sqq=${crypto.encodeURL(id)}"></c:if><c:if test="${moved[0]!=0}"><spring:message code="label.month.${moved[0]}"/><c:if test="${moved[1]!=0}"> ${moved[1]}</c:if></c:if><c:if test="${moved[0]!=0&&moved[2]!=0}">, ${moved[2]}</c:if><c:if test="${moved[0]==0&&moved[2]!=0}">${moved[2]}</c:if><c:if test="${exist}"></a></c:if>
                                </div>
                                                    <div class="qer_fgder"><c:out value="${data.moveddesc}"/></div>
                            <div class="tyll_link"><a href="/more/info/edit/moved/?sqq=${crypto.encodeURL(id)}">Edit</a><a href="/more/info/remove/detail/?sqq=${crypto.encodeURL(id)}">Remove</a></div>
                        </div>
                    </c:if></c:forEach>

                <c:forEach items="${getData}" var="data"><c:if test="${(data.mobilenumber!=null)&&((options==null)||(options.mobile))}">
                        <c:set var="id" value="${crypto.encrypt(data.defaultId)}"/>
                        <c:set var="picid" value="${crypto.encrypt(data.picId)}"/>
                        <div class="gfg_container">
                            <c:choose><c:when test="${picid!=null}"><img src="/more/info/pic/get/?sqq=${crypto.encodeURL(picid)}" class="defft_ava"></c:when><c:otherwise><div class="mobile_ava"></div></c:otherwise></c:choose>
                            <div class="rerr_cvv"><spring:message code="mobile.label.0${data.mobiletype}"/> (<spring:message code="userprivacy.label.0${data.mobilepri}"/>)</div>
                            <div class="rerr_cvv">${data.mobilenumber}</div>
                            <div class="qer_fgder"><c:out value="${data.mobiledesc}"/></div>
                            <div class="tyll_link"><a href="/more/info/edit/mobile/?sqq=${crypto.encodeURL(id)}">Edit</a><a href="/more/info/remove/detail/?sqq=${crypto.encodeURL(id)}">Remove</a></div>
                        </div>
                    </c:if></c:forEach>

                <c:forEach items="${getData}" var="data"><c:if test="${(data.email!=null)&&((options==null)||(options.email))}">
                        <c:set var="id" value="${crypto.encrypt(data.defaultId)}"/>
                        <c:set var="picid" value="${crypto.encrypt(data.picId)}"/>
                        <div class="gfg_container">
                            <c:choose><c:when test="${picid!=null}"><img src="/more/info/pic/get/?sqq=${crypto.encodeURL(picid)}" class="defft_ava"></c:when><c:otherwise><div class="email_ava"></div></c:otherwise></c:choose>
                            <div class="rerr_cvv"><spring:message code="email.label.0${data.emailtype}"/> (<spring:message code="userprivacy.label.0${data.emailpri}"/>)</div>
                            <div class="rerr_cvv">${data.email}</div>
                            <div class="qer_fgder"><c:out value="${data.emaildesc}"/></div>
                            <div class="tyll_link"><a href="/more/info/edit/email/?sqq=${crypto.encodeURL(id)}">Edit</a><a href="/more/info/remove/detail/?sqq=${crypto.encodeURL(id)}">Remove</a></div>
                        </div>
                    </c:if></c:forEach>

                <c:forEach items="${getData}" var="data"><c:if test="${(data.website!=null)&&((options==null)||(options.website))}">
                        <c:set var="id" value="${crypto.encrypt(data.defaultId)}"/>
                        <c:set var="picid" value="${crypto.encrypt(data.picId)}"/>
                        <div class="gfg_container">
                            <c:choose><c:when test="${picid!=null}"><img src="/more/info/pic/get/?sqq=${crypto.encodeURL(picid)}" class="defft_ava"></c:when><c:otherwise><div class="website_ava"></div></c:otherwise></c:choose>
                            <div class="rerr_cvv"><spring:message code="website.label.0${data.websitetype}"/> (<spring:message code="userprivacy.label.0${data.websitepri}"/>)</div>
                            <div class="rerr_cvv"><a href="<spring:url value="/link/url/redirect/?url={var}"><spring:param name="var" value="${data.website}"/></spring:url>" target="_blank"><c:out value="${data.website}"/></a></div>
                            <div class="qer_fgder"><c:out value="${data.websitedesc}"/></div>
                            <div class="tyll_link"><a href="/more/info/edit/website/?sqq=${crypto.encodeURL(id)}">Edit</a><a href="/more/info/remove/detail/?sqq=${crypto.encodeURL(id)}">Remove</a></div>
                        </div>
                    </c:if></c:forEach>

                <c:forEach items="${getData}" var="data"><c:if test="${(data.hobbies!=null)&&((options==null)||(options.hobbies))}">
                        <c:set var="id" value="${crypto.encrypt(data.defaultId)}"/>
                        <c:set var="picid" value="${crypto.encrypt(data.picId)}"/>
                        <div class="gfg_container">
                            <c:choose><c:when test="${picid!=null}"><img src="/more/info/pic/get/?sqq=${crypto.encodeURL(picid)}" class="defft_ava"></c:when><c:otherwise><div class="hobbies_ava"></div></c:otherwise></c:choose>
                            <div class="rerr_cvv"><c:out value="${data.hobbies}"/> (<spring:message code="userprivacy.label.0${data.hobbpri}"/>)</div>
                            <div class="qer_fgder"><c:out value="${data.hobbiesdesc}"/></div>
                            <div class="tyll_link"><a href="/more/info/edit/hobbies/?sqq=${crypto.encodeURL(id)}">Edit</a><a href="/more/info/remove/detail/?sqq=${crypto.encodeURL(id)}">Remove</a></div>
                        </div>
                    </c:if></c:forEach>

                <c:forEach items="${getData}" var="data"><c:if test="${(data.relationship!=null)&&((options==null)||(options.relationship))}">
                        <c:set var="id" value="${crypto.encrypt(data.defaultId)}"/>
                        <c:set var="picid" value="${crypto.encrypt(data.picId)}"/>
                        <c:set var="exist" value="false"/>
                        <c:set var="relationship" value="${fn:split(data.relatitime, '/')}" />
                        <c:if test="${(relationship[0]!=0)||(relationship[2]!=0)}"><c:set var="exist" value="true"/></c:if>
                            <div class="gfg_container">
                            <c:choose><c:when test="${picid!=null}"><img src="/more/info/pic/get/?sqq=${crypto.encodeURL(picid)}" class="defft_ava"></c:when><c:otherwise><div class="relationship_ava"></div></c:otherwise></c:choose>
                            <div class="rerr_cvv"><spring:message code="relationship.label.0${data.relationship}"/> (<spring:message code="userprivacy.label.0${data.relatipri}"/>)</div>
                            <div class="qer_fgder"><c:out value="${data.relatiname}"/></div>
                            <div class="qer_fgder">
                                <c:if test="${exist}"><a href="/relationship/show/data/?sqq=${crypto.encodeURL(id)}"></c:if><c:if test="${relationship[0]!=0}"><spring:message code="label.month.${relationship[0]}"/><c:if test="${relationship[1]!=0}"> ${relationship[1]}</c:if></c:if><c:if test="${relationship[0]!=0&&relationship[2]!=0}">, ${relationship[2]}</c:if><c:if test="${relationship[0]==0&&relationship[2]!=0}">${relationship[2]}</c:if><c:if test="${exist}"></a></c:if>
                                </div>
                                                    <div class="qer_fgder"><c:out value="${data.relatidesc}"/></div>
                            <div class="tyll_link"><a href="/more/info/edit/relationship/?sqq=${crypto.encodeURL(id)}">Edit</a><a href="/more/info/remove/detail/?sqq=${crypto.encodeURL(id)}">Remove</a></div>
                        </div>
                    </c:if></c:forEach>

                <c:forEach items="${getData}" var="data"><c:if test="${(data.relation!=null)&&((options==null)||(options.relation))}">
                        <c:set var="id" value="${crypto.encrypt(data.defaultId)}"/>
                        <c:set var="picid" value="${crypto.encrypt(data.picId)}"/>
                        <div class="gfg_container">
                            <c:choose><c:when test="${picid!=null}"><img src="/more/info/pic/get/?sqq=${crypto.encodeURL(picid)}" class="defft_ava"></c:when><c:otherwise><div class="relation_ava"></div></c:otherwise></c:choose>
                            <div class="rerr_cvv"><spring:message code="relation.label.0${data.relation}"/> (<spring:message code="userprivacy.label.0${data.relatpri}"/>)</div>
                            <div class="qer_fgder"><c:out value="${data.relatname}"/></div>
                            <div class="qer_fgder"><c:out value="${data.relatdesc}"/></div>
                            <div class="tyll_link"><a href="/more/info/edit/relation/?sqq=${crypto.encodeURL(id)}">Edit</a><a href="/more/info/remove/detail/?sqq=${crypto.encodeURL(id)}">Remove</a></div>
                        </div>
                    </c:if></c:forEach>

                <c:forEach items="${getData}" var="data"><c:if test="${(data.languages!=null)&&((options==null)||(options.languages))}">
                        <c:set var="id" value="${crypto.encrypt(data.defaultId)}"/>
                        <c:set var="picid" value="${crypto.encrypt(data.picId)}"/>
                        <div class="gfg_container">
                            <c:choose><c:when test="${picid!=null}"><img src="/more/info/pic/get/?sqq=${crypto.encodeURL(picid)}" class="defft_ava"></c:when><c:otherwise><div class="languages_ava"></div></c:otherwise></c:choose>
                            <div class="rerr_cvv"><c:out value="${data.languages}"/> (<spring:message code="userprivacy.label.0${data.langpri}"/>)</div>
                            <div class="qer_fgder"><c:out value="${data.langdesc}"/></div>
                            <div class="tyll_link"><a href="/more/info/edit/languages/?sqq=${crypto.encodeURL(id)}">Edit</a><a href="/more/info/remove/detail/?sqq=${crypto.encodeURL(id)}">Remove</a></div>
                        </div>
                    </c:if></c:forEach>

                <c:forEach items="${getData}" var="data"><c:if test="${(data.religion!=null)&&((options==null)||(options.religion))}">
                        <c:set var="id" value="${crypto.encrypt(data.defaultId)}"/>
                        <c:set var="picid" value="${crypto.encrypt(data.picId)}"/>
                        <div class="gfg_container">
                            <c:choose><c:when test="${picid!=null}"><img src="/more/info/pic/get/?sqq=${crypto.encodeURL(picid)}" class="defft_ava"></c:when><c:otherwise><div class="religion_ava"></div></c:otherwise></c:choose>
                            <div class="rerr_cvv"><c:out value="${data.religion}"/> (<spring:message code="userprivacy.label.0${data.religpri}"/>)</div>
                            <div class="qer_fgder"><c:out value="${data.religdesc}"/></div>
                            <div class="tyll_link"><a href="/more/info/edit/religion/?sqq=${crypto.encodeURL(id)}">Edit</a><a href="/more/info/remove/detail/?sqq=${crypto.encodeURL(id)}">Remove</a></div>
                        </div>
                    </c:if></c:forEach>

                <c:forEach items="${getData}" var="data"><c:if test="${(data.behaviour!=null)&&((options==null)||(options.behaviour))}">
                        <c:set var="id" value="${crypto.encrypt(data.defaultId)}"/>
                        <c:set var="picid" value="${crypto.encrypt(data.picId)}"/>
                        <div class="gfg_container">
                            <c:choose><c:when test="${picid!=null}"><img src="/more/info/pic/get/?sqq=${crypto.encodeURL(picid)}" class="defft_ava"></c:when><c:otherwise><div class="behaviour_ava"></div></c:otherwise></c:choose>
                            <div class="rerr_cvv"><c:out value="${data.behaviour}"/> (<spring:message code="userprivacy.label.0${data.behavpri}"/>)</div>
                            <div class="qer_fgder"><c:out value="${data.behavdesc}"/></div>
                            <div class="tyll_link"><a href="/more/info/edit/behaviour/?sqq=${crypto.encodeURL(id)}">Edit</a><a href="/more/info/remove/detail/?sqq=${crypto.encodeURL(id)}">Remove</a></div>
                        </div>
                    </c:if></c:forEach>

                <c:forEach items="${getData}" var="data"><c:if test="${(data.myself!=null)&&((options==null)||(options.myself))}">
                        <c:set var="id" value="${crypto.encrypt(data.defaultId)}"/>
                        <c:set var="picid" value="${crypto.encrypt(data.picId)}"/>
                        <div class="gfg_container">
                            <c:choose><c:when test="${picid!=null}"><img src="/more/info/pic/get/?sqq=${crypto.encodeURL(picid)}" class="defft_ava"></c:when><c:otherwise><div class="myself_ava"></div></c:otherwise></c:choose>
                            <div class="rerr_cvv"><c:out value="${data.myself}"/> (<spring:message code="userprivacy.label.0${data.myselpri}"/>)</div>
                            <div class="qer_fgder"><c:out value="${data.myseldesc}"/></div>
                            <div class="tyll_link"><a href="/more/info/edit/myself/?sqq=${crypto.encodeURL(id)}">Edit</a><a href="/more/info/remove/detail/?sqq=${crypto.encodeURL(id)}">Remove</a></div>
                        </div>
                    </c:if></c:forEach>

                <c:forEach items="${getData}" var="data"><c:if test="${(data.categname!=null)&&(data.categvalue!=null)&&((options==null)||(options.newcateg))}">
                        <c:set var="id" value="${crypto.encrypt(data.defaultId)}"/>
                        <c:set var="picid" value="${crypto.encrypt(data.picId)}"/>
                        <div class="gfg_container">
                             <c:choose><c:when test="${picid!=null}"><img src="/more/info/pic/get/?sqq=${crypto.encodeURL(picid)}" class="defft_ava"></c:when><c:otherwise><div class="newcatg_ava"></div></c:otherwise></c:choose>
                            <div class="rerr_cvv"><c:out value="${data.categvalue}"/> (<spring:message code="userprivacy.label.0${data.categpri}"/>)</div>
                            <div class="qer_fgder"><c:out value="${data.categdesc}"/></div>
                            <div class="tyll_link"><a href="/more/info/edit/newcatg/?sqq=${crypto.encodeURL(id)}">Edit</a><a href="/more/info/remove/detail/?sqq=${crypto.encodeURL(id)}">Remove</a></div>
                        </div>
                    </c:if></c:forEach>

            </div>
            </div>
        </div>
        <script type="text/javascript" src="/rele/js/GYhdUdJiI.js"></script>
    </body>
</html>
