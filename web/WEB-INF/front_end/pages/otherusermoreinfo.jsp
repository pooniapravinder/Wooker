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
            <jsp:useBean id="privacyChecker" class="pages.controller.reactoper.ReactOperValidate"/>
            <div class="info_page main clearfix" id="web_view">
                <div class="content">
                <h1>Secondary Info</h1>
                <jsp:useBean id="getInfo" class="hibernate.query.info.MoreInfoAction"/>
                <c:set var="getData" value="${getInfo.getSecInfo(crypto.decrypt(param.sqq))}"/>

                <div class="upp_ss_elem">
                    <div class="options_position"><a href="/info/?sqq=${crypto.encodeURL(param.sqq)}">Primary Info</a></div>
                    <div class="options_position"><a href="/more/info/?sqq=${crypto.encodeURL(param.sqq)}">Secondary Info</a></div>
                    <div class="options_position"><a href="/user/add/relation/?sqq=${crypto.encodeURL(param.sqq)}">Add Relation</a></div>
                    <div class="options_position"><a href="/user/add/relationship/?sqq=${crypto.encodeURL(param.sqq)}">Add Relationship</a></div>
                </div>


                <c:forEach items="${getData}" var="data"><c:if test="${(data.school!=null)&&(privacyChecker.privacyChecker(crypto.decrypt(param.sqq),user,data.schoolpri))}">
                        <c:set var="id" value="${crypto.encrypt(data.defaultId)}"/>
                        <c:set var="picid" value="${crypto.encrypt(data.picId)}"/>
                        <c:set var="existen" value="false"/><c:set var="existle" value="false"/>
                        <c:set var="entrance" value="${fn:split(data.schoolentr, '/')}" />
                        <c:set var="leave" value="${fn:split(data.schoolleave, '/')}" />
                        <c:if test="${(entrance[0]!=0)||(entrance[2]!=0)}"><c:set var="existen" value="true"/></c:if><c:if test="${(leave[0]!=0)||(leave[2]!=0)}"><c:set var="existle" value="true"/></c:if>
                            <div class="gfg_container">
                            <c:choose><c:when test="${picid!=null}"><img src="/more/info/pic/get/?sqq=${crypto.encodeURL(picid)}" class="defft_ava"></c:when><c:otherwise><div class="school_ava"></div></c:otherwise></c:choose>
                            <div class="rerr_cvv"><c:out value="${data.school}"/></div>
                            <div class="qer_fgder">
                                <c:if test="${existen}"><a href="/school/show/data/?sqq=${crypto.encodeURL(id)}"></c:if><c:if test="${entrance[0]!=0}"><spring:message code="label.month.${entrance[0]}"/><c:if test="${entrance[1]!=0}"> ${entrance[1]}</c:if></c:if><c:if test="${entrance[0]!=0&&entrance[2]!=0}">, ${entrance[2]}</c:if><c:if test="${entrance[0]==0&&entrance[2]!=0}">${entrance[2]}</c:if><c:if test="${existen}"></a></c:if>
                                <c:if test="${existen||existle}"> - </c:if>
                                <c:if test="${existle}"><a href="/school/show/data/?sqq=${crypto.encodeURL(id)}"></c:if><c:if test="${leave[0]!=0}"><spring:message code="label.month.${leave[0]}"/><c:if test="${leave[1]!=0}"> ${leave[1]}</c:if></c:if><c:if test="${leave[0]!=0&&leave[2]!=0}">, ${leave[2]}</c:if><c:if test="${leave[0]==0&&leave[2]!=0}">${leave[2]}</c:if><c:if test="${existle}"></a></c:if>
                                </div>
                                                    <div class="qer_fgder"><c:out value="${data.schooldesc}"/></div>
                        </div>
                    </c:if></c:forEach>

                <c:forEach items="${getData}" var="data"><c:if test="${(data.gradcollege!=null)&&(privacyChecker.privacyChecker(crypto.decrypt(param.sqq),user,data.gradcollpri))}">
                        <c:set var="id" value="${crypto.encrypt(data.defaultId)}"/>
                        <c:set var="picid" value="${crypto.encrypt(data.picId)}"/>
                        <c:set var="existen" value="false"/><c:set var="existle" value="false"/>
                        <c:set var="entrance" value="${fn:split(data.gradcollentr, '/')}" />
                        <c:set var="leave" value="${fn:split(data.gradcollleave, '/')}" />
                        <c:if test="${(entrance[0]!=0)||(entrance[2]!=0)}"><c:set var="existen" value="true"/></c:if><c:if test="${(leave[0]!=0)||(leave[2]!=0)}"><c:set var="existle" value="true"/></c:if>
                            <div class="gfg_container">
                            <c:choose><c:when test="${picid!=null}"><img src="/more/info/pic/get/?sqq=${crypto.encodeURL(picid)}" class="defft_ava"></c:when><c:otherwise><div class="graduate_ava"></div></c:otherwise></c:choose>
                            <div class="rerr_cvv"><c:out value="${data.gradcollege}"/></div>
                            <div class="qer_fgder">
                                <c:if test="${existen}"><a href="/grcollege/show/data/?sqq=${crypto.encodeURL(id)}"></c:if><c:if test="${entrance[0]!=0}"><spring:message code="label.month.${entrance[0]}"/><c:if test="${entrance[1]!=0}"> ${entrance[1]}</c:if></c:if><c:if test="${entrance[0]!=0&&entrance[2]!=0}">, ${entrance[2]}</c:if><c:if test="${entrance[0]==0&&entrance[2]!=0}">${entrance[2]}</c:if><c:if test="${existen}"></a></c:if>
                                <c:if test="${existen||existle}"> - </c:if>
                                <c:if test="${existle}"><a href="/grcollege/show/data/?sqq=${crypto.encodeURL(id)}"></c:if><c:if test="${leave[0]!=0}"><spring:message code="label.month.${leave[0]}"/><c:if test="${leave[1]!=0}"> ${leave[1]}</c:if></c:if><c:if test="${leave[0]!=0&&leave[2]!=0}">, ${leave[2]}</c:if><c:if test="${leave[0]==0&&leave[2]!=0}">${leave[2]}</c:if><c:if test="${existle}"></a></c:if>
                                </div>
                                                    <div class="qer_fgder">${data.gradcolldesc}</div>
                        </div>
                    </c:if></c:forEach>

                <c:forEach items="${getData}" var="data"><c:if test="${(data.graduniver!=null)&&(privacyChecker.privacyChecker(crypto.decrypt(param.sqq),user,data.graduniverpri))}">
                        <c:set var="id" value="${crypto.encrypt(data.defaultId)}"/>
                        <c:set var="picid" value="${crypto.encrypt(data.picId)}"/>
                        <c:set var="existen" value="false"/><c:set var="existle" value="false"/>
                        <c:set var="entrance" value="${fn:split(data.graduniverentr, '/')}" />
                        <c:set var="leave" value="${fn:split(data.graduniverleave, '/')}" />
                        <c:if test="${(entrance[0]!=0)||(entrance[2]!=0)}"><c:set var="existen" value="true"/></c:if><c:if test="${(leave[0]!=0)||(leave[2]!=0)}"><c:set var="existle" value="true"/></c:if>
                            <div class="gfg_container">
                            <c:choose><c:when test="${picid!=null}"><img src="/more/info/pic/get/?sqq=${crypto.encodeURL(picid)}" class="defft_ava"></c:when><c:otherwise><div class="graduate_ava"></div></c:otherwise></c:choose>
                            <div class="rerr_cvv"><c:out value="${data.graduniver}"/></div>
                            <div class="qer_fgder">
                                <c:if test="${existen}"><a href="/gruniver/show/data/?sqq=${crypto.encodeURL(id)}"></c:if><c:if test="${entrance[0]!=0}"><spring:message code="label.month.${entrance[0]}"/><c:if test="${entrance[1]!=0}"> ${entrance[1]}</c:if></c:if><c:if test="${entrance[0]!=0&&entrance[2]!=0}">, ${entrance[2]}</c:if><c:if test="${entrance[0]==0&&entrance[2]!=0}">${entrance[2]}</c:if><c:if test="${existen}"></a></c:if>
                                <c:if test="${existen||existle}"> - </c:if>
                                <c:if test="${existle}"><a href="/gruniver/show/data/?sqq=${crypto.encodeURL(id)}"></c:if><c:if test="${leave[0]!=0}"><spring:message code="label.month.${leave[0]}"/><c:if test="${leave[1]!=0}"> ${leave[1]}</c:if></c:if><c:if test="${leave[0]!=0&&leave[2]!=0}">, ${leave[2]}</c:if><c:if test="${leave[0]==0&&leave[2]!=0}">${leave[2]}</c:if><c:if test="${existle}"></a></c:if>
                                </div>
                                                    <div class="qer_fgder"><c:out value="${data.graduniverdesc}"/></div>
                        </div>
                    </c:if></c:forEach>

                <c:forEach items="${getData}" var="data"><c:if test="${(data.pogradcollege!=null)&&(privacyChecker.privacyChecker(crypto.decrypt(param.sqq),user,data.pogradcollpri))}">
                        <c:set var="id" value="${crypto.encrypt(data.defaultId)}"/>
                        <c:set var="picid" value="${crypto.encrypt(data.picId)}"/>
                        <c:set var="existen" value="false"/><c:set var="existle" value="false"/>
                        <c:set var="entrance" value="${fn:split(data.pogradcollentr, '/')}" />
                        <c:set var="leave" value="${fn:split(data.pogradcollleave, '/')}" />
                        <c:if test="${(entrance[0]!=0)||(entrance[2]!=0)}"><c:set var="existen" value="true"/></c:if><c:if test="${(leave[0]!=0)||(leave[2]!=0)}"><c:set var="existle" value="true"/></c:if>
                            <div class="gfg_container">
                            <c:choose><c:when test="${picid!=null}"><img src="/more/info/pic/get/?sqq=${crypto.encodeURL(picid)}" class="defft_ava"></c:when><c:otherwise><div class="graduate_ava"></div></c:otherwise></c:choose>
                            <div class="rerr_cvv"><c:out value="${data.pogradcollege}"/></div>
                            <div class="qer_fgder">
                                <c:if test="${existen}"><a href="/pogrcoll/show/data/?sqq=${crypto.encodeURL(id)}"></c:if><c:if test="${entrance[0]!=0}"><spring:message code="label.month.${entrance[0]}"/><c:if test="${entrance[1]!=0}"> ${entrance[1]}</c:if></c:if><c:if test="${entrance[0]!=0&&entrance[2]!=0}">, ${entrance[2]}</c:if><c:if test="${entrance[0]==0&&entrance[2]!=0}">${entrance[2]}</c:if><c:if test="${existen}"></a></c:if>
                                <c:if test="${existen||existle}"> - </c:if>
                                <c:if test="${existle}"><a href="/pogrcoll/show/data/?sqq=${crypto.encodeURL(id)}"></c:if><c:if test="${leave[0]!=0}"><spring:message code="label.month.${leave[0]}"/><c:if test="${leave[1]!=0}"> ${leave[1]}</c:if></c:if><c:if test="${leave[0]!=0&&leave[2]!=0}">, ${leave[2]}</c:if><c:if test="${leave[0]==0&&leave[2]!=0}">${leave[2]}</c:if><c:if test="${existle}"></a></c:if>
                                </div>
                                                    <div class="qer_fgder"><c:out value="${data.pogradcolldesc}"/></div>
                        </div>
                    </c:if></c:forEach>

                <c:forEach items="${getData}" var="data"><c:if test="${(data.pograduniver!=null)&&(privacyChecker.privacyChecker(crypto.decrypt(param.sqq),user,data.pograduniverpri))}">
                        <c:set var="id" value="${crypto.encrypt(data.defaultId)}"/>
                        <c:set var="picid" value="${crypto.encrypt(data.picId)}"/>
                        <c:set var="existen" value="false"/><c:set var="existle" value="false"/>
                        <c:set var="entrance" value="${fn:split(data.pograduniverentr, '/')}" />
                        <c:set var="leave" value="${fn:split(data.pograduniverleave, '/')}" />
                        <c:if test="${(entrance[0]!=0)||(entrance[2]!=0)}"><c:set var="existen" value="true"/></c:if><c:if test="${(leave[0]!=0)||(leave[2]!=0)}"><c:set var="existle" value="true"/></c:if>
                            <div class="gfg_container">
                            <c:choose><c:when test="${picid!=null}"><img src="/more/info/pic/get/?sqq=${crypto.encodeURL(picid)}" class="defft_ava"></c:when><c:otherwise><div class="graduate_ava"></div></c:otherwise></c:choose>
                            <div class="rerr_cvv"><c:out value="${data.pograduniver}"/></div>
                            <div class="qer_fgder">
                                <c:if test="${existen}"><a href="/pogruniver/show/data/?sqq=${crypto.encodeURL(id)}"></c:if><c:if test="${entrance[0]!=0}"><spring:message code="label.month.${entrance[0]}"/><c:if test="${entrance[1]!=0}"> ${entrance[1]}</c:if></c:if><c:if test="${entrance[0]!=0&&entrance[2]!=0}">, ${entrance[2]}</c:if><c:if test="${entrance[0]==0&&entrance[2]!=0}">${entrance[2]}</c:if><c:if test="${existen}"></a></c:if>
                                <c:if test="${existen||existle}"> - </c:if>
                                <c:if test="${existle}"><a href="/pogruniver/show/data/?sqq=${crypto.encodeURL(id)}"></c:if><c:if test="${leave[0]!=0}"><spring:message code="label.month.${leave[0]}"/><c:if test="${leave[1]!=0}"> ${leave[1]}</c:if></c:if><c:if test="${leave[0]!=0&&leave[2]!=0}">, ${leave[2]}</c:if><c:if test="${leave[0]==0&&leave[2]!=0}">${leave[2]}</c:if><c:if test="${existle}"></a></c:if>
                                </div>
                                                    <div class="qer_fgder"><c:out value="${data.pograduniverdesc}"/></div>
                        </div>
                    </c:if></c:forEach>

                <c:forEach items="${getData}" var="data"><c:if test="${(data.worktype!=null)&&(data.workplace!=null)&&(privacyChecker.privacyChecker(crypto.decrypt(param.sqq),user,data.workpri))}">
                        <c:set var="id" value="${crypto.encrypt(data.defaultId)}"/>
                        <c:set var="picid" value="${crypto.encrypt(data.picId)}"/>
                        <c:set var="existst" value="false"/><c:set var="existle" value="false"/>
                        <c:set var="start" value="${fn:split(data.workstart, '/')}" />
                        <c:set var="leave" value="${fn:split(data.workleave, '/')}" />
                        <c:if test="${(start[0]!=0)||(start[2]!=0)}"><c:set var="existst" value="true"/></c:if><c:if test="${(leave[0]!=0)||(leave[2]!=0)}"><c:set var="existle" value="true"/></c:if>
                            <div class="gfg_container">
                            <c:choose><c:when test="${picid!=null}"><img src="/more/info/pic/get/?sqq=${crypto.encodeURL(picid)}" class="defft_ava"></c:when><c:otherwise><div class="work_ava"></div></c:otherwise></c:choose>
                            <div class="rerr_cvv"><c:out value="${data.worktype}"/></div>
                            <div class="rerr_cvv"><c:out value="${data.workplace}"/></div>
                            <div class="qer_fgder">
                                <c:if test="${existst}"><a href="/work/show/data/?sqq=${crypto.encodeURL(id)}"></c:if><c:if test="${start[0]!=0}"><spring:message code="label.month.${start[0]}"/><c:if test="${start[1]!=0}"> ${start[1]}</c:if></c:if><c:if test="${start[0]!=0&&start[2]!=0}">, ${start[2]}</c:if><c:if test="${start[0]==0&&start[2]!=0}">${start[2]}</c:if><c:if test="${existst}"></a></c:if>
                                <c:if test="${existst||existle}"> - </c:if>
                                <c:if test="${existle}"><a href="/work/show/data/?sqq=${crypto.encodeURL(id)}"></c:if><c:if test="${leave[0]!=0}"><spring:message code="label.month.${leave[0]}"/><c:if test="${leave[1]!=0}"> ${leave[1]}</c:if></c:if><c:if test="${leave[0]!=0&&leave[2]!=0}">, ${leave[2]}</c:if><c:if test="${leave[0]==0&&leave[2]!=0}">${leave[2]}</c:if><c:if test="${existle}"></a></c:if>
                                </div>
                                                    <div class="qer_fgder"><c:out value="${data.workdesc}"/></div>
                        </div>
                    </c:if></c:forEach>

                <c:forEach items="${getData}" var="data"><c:if test="${(data.currcity!=null)&&(data.hometown!=null)&&(privacyChecker.privacyChecker(crypto.decrypt(param.sqq),user,data.locationpri))}">
                        <c:set var="id" value="${crypto.encrypt(data.defaultId)}"/>
                        <c:set var="picid" value="${crypto.encrypt(data.picId)}"/>
                        <div class="gfg_container">
                            <c:choose><c:when test="${picid!=null}"><img src="/more/info/pic/get/?sqq=${crypto.encodeURL(picid)}" class="defft_ava"></c:when><c:otherwise><div class="location_ava"></div></c:otherwise></c:choose>
                            <div class="rerr_cvv"><c:out value="${data.currcity}"/></div>
                            <div class="rerr_cvv"><c:out value="${data.hometown}"/></div>
                            <div class="qer_fgder"><c:out value="${data.locationdesc}"/></div>
                        </div>
                    </c:if></c:forEach>

                <c:forEach items="${getData}" var="data"><c:if test="${(data.movedfrom!=null)&&(data.movedto!=null)&&(privacyChecker.privacyChecker(crypto.decrypt(param.sqq),user,data.movedpri))}">
                        <c:set var="id" value="${crypto.encrypt(data.defaultId)}"/>
                        <c:set var="picid" value="${crypto.encrypt(data.picId)}"/>
                        <c:set var="exist" value="false"/>
                        <c:set var="moved" value="${fn:split(data.movedtime, '/')}" />
                        <c:if test="${(moved[0]!=0)||(moved[2]!=0)}"><c:set var="exist" value="true"/></c:if>
                            <div class="gfg_container">
                            <c:choose><c:when test="${picid!=null}"><img src="/more/info/pic/get/?sqq=${crypto.encodeURL(picid)}" class="defft_ava"></c:when><c:otherwise><div class="moved_ava"></div></c:otherwise></c:choose>
                            <div class="rerr_cvv"><c:out value="${data.movedfrom}"/></div>
                            <div class="rerr_cvv"><c:out value="${data.movedto}"/></div>
                            <div class="qer_fgder">
                                <c:if test="${exist}"><a href="/moved/show/data/?sqq=${crypto.encodeURL(id)}"></c:if><c:if test="${moved[0]!=0}"><spring:message code="label.month.${moved[0]}"/><c:if test="${moved[1]!=0}"> ${moved[1]}</c:if></c:if><c:if test="${moved[0]!=0&&moved[2]!=0}">, ${moved[2]}</c:if><c:if test="${moved[0]==0&&moved[2]!=0}">${moved[2]}</c:if><c:if test="${exist}"></a></c:if>
                                </div>
                                                    <div class="qer_fgder"><c:out value="${data.moveddesc}"/></div>
                        </div>
                    </c:if></c:forEach>

                <c:forEach items="${getData}" var="data"><c:if test="${(data.mobilenumber!=null)&&(privacyChecker.privacyChecker(crypto.decrypt(param.sqq),user,data.mobilepri))}">
                        <c:set var="id" value="${crypto.encrypt(data.defaultId)}"/>
                        <c:set var="picid" value="${crypto.encrypt(data.picId)}"/>
                        <div class="gfg_container">
                            <c:choose><c:when test="${picid!=null}"><img src="/more/info/pic/get/?sqq=${crypto.encodeURL(picid)}" class="defft_ava"></c:when><c:otherwise><div class="mobile_ava"></div></c:otherwise></c:choose>
                            <div class="rerr_cvv"><spring:message code="mobile.label.0${data.mobiletype}"/></div>
                            <div class="rerr_cvv">${data.mobilenumber}</div>
                            <div class="qer_fgder"><c:out value="${data.mobiledesc}"/></div>
                        </div>
                    </c:if></c:forEach>

                <c:forEach items="${getData}" var="data"><c:if test="${(data.email!=null)&&(privacyChecker.privacyChecker(crypto.decrypt(param.sqq),user,data.emailpri))}">
                        <c:set var="id" value="${crypto.encrypt(data.defaultId)}"/>
                        <c:set var="picid" value="${crypto.encrypt(data.picId)}"/>
                        <div class="gfg_container">
                            <c:choose><c:when test="${picid!=null}"><img src="/more/info/pic/get/?sqq=${crypto.encodeURL(picid)}" class="defft_ava"></c:when><c:otherwise><div class="email_ava"></div></c:otherwise></c:choose>
                            <div class="rerr_cvv"><spring:message code="email.label.0${data.emailtype}"/></div>
                            <div class="rerr_cvv">${data.email}</div>
                            <div class="qer_fgder"><c:out value="${data.emaildesc}"/></div>
                        </div>
                    </c:if></c:forEach>

                <c:forEach items="${getData}" var="data"><c:if test="${(data.website!=null)&&(privacyChecker.privacyChecker(crypto.decrypt(param.sqq),user,data.websitepri))}">
                        <c:set var="id" value="${crypto.encrypt(data.defaultId)}"/>
                        <c:set var="picid" value="${crypto.encrypt(data.picId)}"/>
                        <div class="gfg_container">
                            <c:choose><c:when test="${picid!=null}"><img src="/more/info/pic/get/?sqq=${crypto.encodeURL(picid)}" class="defft_ava"></c:when><c:otherwise><div class="website_ava"></div></c:otherwise></c:choose>
                            <div class="rerr_cvv"><spring:message code="website.label.0${data.websitetype}"/></div>
                            <div class="rerr_cvv"><a href="<spring:url value="/link/url/redirect/?url={var}"><spring:param name="var" value="${data.website}"/></spring:url>" target="_blank"><c:out value="${data.website}"/></a></div>
                            <div class="qer_fgder"><c:out value="${data.websitedesc}"/></div>
                            </div>
                    </c:if></c:forEach>

                <c:forEach items="${getData}" var="data"><c:if test="${(data.hobbies!=null)&&(privacyChecker.privacyChecker(crypto.decrypt(param.sqq),user,data.hobbpri))}">
                        <c:set var="id" value="${crypto.encrypt(data.defaultId)}"/>
                        <c:set var="picid" value="${crypto.encrypt(data.picId)}"/>
                        <div class="gfg_container">
                            <c:choose><c:when test="${picid!=null}"><img src="/more/info/pic/get/?sqq=${crypto.encodeURL(picid)}" class="defft_ava"></c:when><c:otherwise><div class="hobbies_ava"></div></c:otherwise></c:choose>
                            <div class="rerr_cvv"><c:out value="${data.hobbies}"/></div>
                            <div class="qer_fgder"><c:out value="${data.hobbiesdesc}"/></div>
                            </div>
                    </c:if></c:forEach>

                <c:forEach items="${getData}" var="data"><c:if test="${(data.relationship!=null)&&(privacyChecker.privacyChecker(crypto.decrypt(param.sqq),user,data.relatipri))}">
                        <c:set var="id" value="${crypto.encrypt(data.defaultId)}"/>
                        <c:set var="picid" value="${crypto.encrypt(data.picId)}"/>
                        <c:set var="exist" value="false"/>
                        <c:set var="relationship" value="${fn:split(data.relatitime, '/')}" />
                        <c:if test="${(relationship[0]!=0)||(relationship[2]!=0)}"><c:set var="exist" value="true"/></c:if>
                            <div class="gfg_container">
                            <c:choose><c:when test="${picid!=null}"><img src="/more/info/pic/get/?sqq=${crypto.encodeURL(picid)}" class="defft_ava"></c:when><c:otherwise><div class="relationship_ava"></div></c:otherwise></c:choose>
                            <div class="rerr_cvv"><spring:message code="relationship.label.0${data.relationship}"/></div>
                            <div class="qer_fgder"><c:out value="${data.relatiname}"/></div>
                            <div class="qer_fgder">
                                <c:if test="${exist}"><a href="/relationship/show/data/?sqq=${crypto.encodeURL(id)}"></c:if><c:if test="${relationship[0]!=0}"><spring:message code="label.month.${relationship[0]}"/><c:if test="${relationship[1]!=0}"> ${relationship[1]}</c:if></c:if><c:if test="${relationship[0]!=0&&relationship[2]!=0}">, ${relationship[2]}</c:if><c:if test="${relationship[0]==0&&relationship[2]!=0}">${relationship[2]}</c:if><c:if test="${exist}"></a></c:if>
                                </div>
                                                    <div class="qer_fgder"><c:out value="${data.relatidesc}"/></div>
                            </div>
                    </c:if></c:forEach>

                <c:forEach items="${getData}" var="data"><c:if test="${(data.relation!=null)&&(privacyChecker.privacyChecker(crypto.decrypt(param.sqq),user,data.relatpri))}">
                        <c:set var="id" value="${crypto.encrypt(data.defaultId)}"/>
                        <c:set var="picid" value="${crypto.encrypt(data.picId)}"/>
                        <div class="gfg_container">
                            <c:choose><c:when test="${picid!=null}"><img src="/more/info/pic/get/?sqq=${crypto.encodeURL(picid)}" class="defft_ava"></c:when><c:otherwise><div class="relation_ava"></div></c:otherwise></c:choose>
                            <div class="rerr_cvv"><spring:message code="relation.label.0${data.relation}"/></div>
                            <div class="qer_fgder"><c:out value="${data.relatname}"/></div>
                            <div class="qer_fgder"><c:out value="${data.relatdesc}"/></div>
                            </div>
                    </c:if></c:forEach>

                <c:forEach items="${getData}" var="data"><c:if test="${(data.languages!=null)&&(privacyChecker.privacyChecker(crypto.decrypt(param.sqq),user,data.langpri))}">
                        <c:set var="id" value="${crypto.encrypt(data.defaultId)}"/>
                        <c:set var="picid" value="${crypto.encrypt(data.picId)}"/>
                        <div class="gfg_container">
                            <c:choose><c:when test="${picid!=null}"><img src="/more/info/pic/get/?sqq=${crypto.encodeURL(picid)}" class="defft_ava"></c:when><c:otherwise><div class="languages_ava"></div></c:otherwise></c:choose>
                            <div class="rerr_cvv"><c:out value="${data.languages}"/></div>
                            <div class="qer_fgder"><c:out value="${data.langdesc}"/></div>
                            </div>
                    </c:if></c:forEach>

                <c:forEach items="${getData}" var="data"><c:if test="${(data.religion!=null)&&(privacyChecker.privacyChecker(crypto.decrypt(param.sqq),user,data.religpri))}">
                        <c:set var="id" value="${crypto.encrypt(data.defaultId)}"/>
                        <c:set var="picid" value="${crypto.encrypt(data.picId)}"/>
                        <div class="gfg_container">
                            <c:choose><c:when test="${picid!=null}"><img src="/more/info/pic/get/?sqq=${crypto.encodeURL(picid)}" class="defft_ava"></c:when><c:otherwise><div class="religion_ava"></div></c:otherwise></c:choose>
                            <div class="rerr_cvv"><c:out value="${data.religion}"/></div>
                            <div class="qer_fgder"><c:out value="${data.religdesc}"/></div>
                            </div>
                    </c:if></c:forEach>

                <c:forEach items="${getData}" var="data"><c:if test="${(data.behaviour!=null)&&(privacyChecker.privacyChecker(crypto.decrypt(param.sqq),user,data.behavpri))}">
                        <c:set var="id" value="${crypto.encrypt(data.defaultId)}"/>
                        <c:set var="picid" value="${crypto.encrypt(data.picId)}"/>
                        <div class="gfg_container">
                            <c:choose><c:when test="${picid!=null}"><img src="/more/info/pic/get/?sqq=${crypto.encodeURL(picid)}" class="defft_ava"></c:when><c:otherwise><div class="behaviour_ava"></div></c:otherwise></c:choose>
                            <div class="rerr_cvv"><c:out value="${data.behaviour}"/></div>
                            <div class="qer_fgder"><c:out value="${data.behavdesc}"/></div>
                            </div>
                    </c:if></c:forEach>

                <c:forEach items="${getData}" var="data"><c:if test="${(data.myself!=null)&&(privacyChecker.privacyChecker(crypto.decrypt(param.sqq),user,data.myselpri))}">
                        <c:set var="id" value="${crypto.encrypt(data.defaultId)}"/>
                        <c:set var="picid" value="${crypto.encrypt(data.picId)}"/>
                        <div class="gfg_container">
                            <c:choose><c:when test="${picid!=null}"><img src="/more/info/pic/get/?sqq=${crypto.encodeURL(picid)}" class="defft_ava"></c:when><c:otherwise><div class="myself_ava"></div></c:otherwise></c:choose>
                            <div class="rerr_cvv"><c:out value="${data.myself}"/></div>
                            <div class="qer_fgder"><c:out value="${data.myseldesc}"/></div>
                            </div>
                    </c:if></c:forEach>

                <c:forEach items="${getData}" var="data"><c:if test="${(data.categname!=null)&&(privacyChecker.privacyChecker(crypto.decrypt(param.sqq),user,data.categpri))}">
                        <c:set var="id" value="${crypto.encrypt(data.defaultId)}"/>
                        <c:set var="picid" value="${crypto.encrypt(data.picId)}"/>
                        <div class="gfg_container">
                            <c:choose><c:when test="${picid!=null}"><img src="/more/info/pic/get/?sqq=${crypto.encodeURL(picid)}" class="defft_ava"></c:when><c:otherwise><div class="newcatg_ava"></div></c:otherwise></c:choose>
                            <div class="rerr_cvv"><c:out value="${data.categvalue}"/></div>
                            <div class="qer_fgder"><c:out value="${data.categdesc}"/></div>
                            </div>
                    </c:if></c:forEach>
                <div class="xccxv"><a href="/info/user/data/copied/take/action/?sqq=${crypto.encodeURL(param.sqq)}">This person has copied my details</a></div>
            </div>
            </div>
        </div>
        <script type="text/javascript" src="/rele/js/GYhdUdJiI.js"></script>
    </body>
</html>
