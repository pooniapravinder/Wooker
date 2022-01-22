<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@taglib uri="http://www.springframework.org/tags" prefix="spring"%><%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%><%@page contentType="text/html" pageEncoding="UTF-8"%><%@page session="false"%><!DOCTYPE html>
<html lang="en-US" id="wooker">
    <head>
        <meta name="keywords" content="Edit your Account Pic">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
        <meta name="theme-color" content="#663399">
        <link rel="shortcut icon" href="//www.google.com/favicon.ico"/>
        <meta name="description" content="Change your Account Pic Settings or Edit your Account Pic">
        <meta name="google" content="notranslate">
        <title>Edit Account Pic</title>
        <link rel="stylesheet" type="text/css" href="/rele/css/styleone.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/styletwo.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/stylethree.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/JuiLOdOpp.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/IoDJnmdJdDE.css">
    </head>
    <body>
        <div class="slide_layout" id="slide_layout"><div class="loading_text">Updating account pic....</div>
            <div class="loading">
                <div class="bullet"></div>
                <div class="bullet"></div>
                <div class="bullet"></div>
                <div class="bullet"></div>
            </div>
        </div>
            <%@include file="header.jsp"%>
        <div class="wrapper animate_in" id="wrapper">
            <div class="info_page main clearfix" id="web_view">
                <div class="content">
                <h1>Edit Account Pic</h1>
                <jsp:useBean id="getOptions" class="hibernate.query.info.ShowHideInfoOpt"/>
                <c:set var="options" value="${getOptions.getPicOptions(user)}"/>

                <div class="upp_ss_elem">
                    <c:if test="${(options==null)||(options.info)}"><div class="options_position"><a href="/info/">Primary Info</a></div></c:if><c:if test="${(options==null)||(options.moreinfo)}"><div class="options_position"><a href="/more/info/">Secondary Info</a></div></c:if><c:if test="${(options==null)||(options.setting)}"><div class="options_position"><a href="/account/pic/edit/settings/?sqq=${crypto.encodeURL(param.sqq)}">Settings</a></div></c:if><c:if test="${(options==null)||(options.security)}"><div class="options_position"><a href="/account/pic/edit/security/?sqq=${crypto.encodeURL(param.sqq)}">Security</a></div></c:if>
                    </div>

                <jsp:useBean id="OptVal" class="hibernate.query.reactoper.ReactOper"/>
                <c:set var="likedDisliked" value="${OptVal.getSingleLikeDislike(user,crypto.decrypt(param.sqq)).likeDislike}"/>
                <c:set var="countLike" value="${OptVal.countLikesDislikes(true,crypto.decrypt(param.sqq))}"/>
                <c:set var="countDislike" value="${OptVal.countLikesDislikes(false,crypto.decrypt(param.sqq))}"/>
                <c:set var="countTalking" value="${OptVal.countTalkings(crypto.decrypt(param.sqq))}"/>
                <c:set var="countComment" value="${OptVal.countComments(crypto.decrypt(param.sqq))}"/>

                <c:if test="${(options==null)||(options.accpic)}">
                    <div class="fer-sdm sada">
                        <a href="/account/pic/full/size/?sqq=${crypto.encodeURL(param.sqq)}"><div class="sdser">
                                <img src="/account/pic/show/a3/?sqq=${crypto.encodeURL(param.sqq)}" alt="img">
                            </div></a>
                    </div>
                </c:if>
                <div class="upp_ss_elem">
                    <c:if test="${(options==null)||(options.uploadnew)}"><a href="/account/pic/upload/new/" class="top_edit_pic_options fdg__asaf_w">Upload New</a></c:if>
                    <c:if test="${(options==null)||(options.remove)}"><a href="/account/pic/remove/?sqq=${crypto.encodeURL(param.sqq)}" class="top_edit_pic_options fdg__asaf_w">Remove</a></c:if>
                    <c:if test="${(options==null)||(options.deletes)}"><a href="/account/pic/delete/?sqq=${crypto.encodeURL(param.sqq)}" class="top_edit_pic_options fdg__asaf_w">Delete</a></c:if>
                    <c:if test="${(options==null)||(options.download)}"><a href="/account/pic/full/download/?sqq=${crypto.encodeURL(param.sqq)}" class="top_edit_pic_options fdg__asaf_w">Download</a></c:if>
                    </div>
                    <div class="upp_ss_elem">
                    <c:if test="${(options==null)||(options.pictime)}">
                        <jsp:useBean id="CalTime" class="timeperiod.duration.calculation.CalculateTime"/>
                        <c:set var="getTime" value="${CalTime.saveDateTime(accpicoper.timestampVal)}"/>
                        <div class="pic_time">
                            <spring:message code="label.day.0${CalTime.day}"/> <c:if test="${CalTime.month<=9}"><spring:message code="label.month.0${CalTime.month}"/></c:if><c:if test="${CalTime.month>9}"><spring:message code="label.month.${CalTime.month}"/></c:if> ${CalTime.date},${CalTime.year} ${CalTime.time}
                            </div>
                    </c:if>
                </div>

                <div class="upp_ss_elem">
                    <c:if test="${((options==null)||(options.likes))&&accpicoper.like}">
                        <c:if test="${countLike > 0}"><a href="/accpic/user/oper/liked/?sqq=${crypto.encodeURL(param.sqq)}&amp;refer=oUej-Ge7H7_ByLk" class="bott_edit_pic_options">${countLike}</a></c:if>
                        <a href="/accpic/user/oper/like/?sqq=${crypto.encodeURL(param.sqq)}&amp;refer=oUej-Ge7H7_ByLk" class="bott_edit_pic_options"><c:choose><c:when test="${(countLike>1)&&(!likedDisliked)}">Likes</c:when><c:when test="${(countLike>=1)&&(likedDisliked)}">Liked</c:when><c:otherwise>Like</c:otherwise></c:choose></a>
                    </c:if>

                    <c:if test="${((options==null)||(options.dislike))&&accpicoper.dislike}">
                        <c:if test="${countDislike > 0}"><a href="/accpic/user/oper/disliked/?sqq=${crypto.encodeURL(param.sqq)}&amp;refer=oUej-Ge7H7_ByLk" class="bott_edit_pic_options">${countDislike}</a></c:if>
                        <a href="/accpic/user/oper/dislike/?sqq=${crypto.encodeURL(param.sqq)}&amp;refer=oUej-Ge7H7_ByLk" class="bott_edit_pic_options"><c:choose><c:when test="${(countDislike>1)&&(likedDisliked)}">Dislikes</c:when><c:when test="${(countDislike>=1)&&(!likedDisliked)}">Disliked</c:when><c:otherwise>Dislike</c:otherwise></c:choose></a>
                    </c:if>

                    <c:if test="${((options==null)||(options.talking))&&accpicoper.talking}">
                        <c:if test="${countTalking > 0}"><a href="/accpic/user/oper/talked/?sqq=${crypto.encodeURL(param.sqq)}&amp;refer=oUej-Ge7H7_ByLk" class="bott_edit_pic_options">${countTalking}</a></c:if>
                        <a href="/accpic/user/oper/talking/?sqq=${crypto.encodeURL(param.sqq)}&amp;refer=oUej-Ge7H7_ByLk" class="bott_edit_pic_options">Talking</a>
                    </c:if>

                    <c:if test="${((options==null)||(options.comment))&&accpicoper.comment}">
                        <c:if test="${countComment > 0}"><a href="/accpic/user/oper/commented/?sqq=${crypto.encodeURL(param.sqq)}&amp;refer=oUej-Ge7H7_ByLk" class="bott_edit_pic_options">${countComment}</a></c:if>
                        <a href="/accpic/user/oper/comment/?sqq=${crypto.encodeURL(param.sqq)}&amp;refer=oUej-Ge7H7_ByLk" class="bott_edit_pic_options"><c:choose><c:when test="${countComment == 1}">Comment</c:when><c:when test="${countComment > 1}">Comments</c:when><c:otherwise>Comment</c:otherwise></c:choose></a>
                    </c:if>

                    <c:if test="${((options==null)||(options.share))&&accpicoper.share}">
                        <a href="/accpic/user/oper/share/?sqq=${crypto.encodeURL(param.sqq)}&amp;refer=oUej-Ge7H7_ByLk" class="bott_edit_pic_options">Share</a>
                    </c:if>
                </div>

                            <c:if test="${(param.refer!=null)&&(param.refer.equals('oUej-Ge7H7_ByLk'))}"><c:set var="refer" value="&refer=${param.refer}"/></c:if>
                <c:if test="${options==null||options.see||options.dodownload||options.lidislike||options.seelidislike||options.dotalking||options.seetalking||options.docomment||options.seecomment||options.doshare||options.seeshare||options.prilike||options.pridislike||options.pritalking||options.pricomment||options.prishare}">
                    <form:form name="accpicoper" class="table sd_sd" modelAttribute="accpicoper" method="post" action="${requestScope['javax.servlet.forward.request_uri']}?sqq=${crypto.encodeURL(param.sqq)}${refer}">
                        <c:if test="${(options==null)||(options.see)}">
                            <div class="form-element-show">
                                <form:label path="privacy">Who can see your account pic:</form:label><c:if test="${(options==null)||(options.showhide)}"><a href="/account/pic/edit/hide/seepic/?sqq=${crypto.encodeURL(param.sqq)}">Hide</a></c:if>
                                    <div class="col edit_pic_pos">
                                        <div class="custom-select">
                                        <form:select path="privacy" id="privacy" class="custom-select-box"><c:forEach var="i" begin="1" end="6"><form:option value="${i}"><spring:message code="userprivacy.label.0${i}"/></form:option></c:forEach></form:select>
                                                </div>
                                            </div></div>
                            </c:if>

                        <c:if test="${(options==null)||(options.dodownload)}">
                            <div class="form-element-show"><form:label path="download">Who can download your account pic:</form:label><c:if test="${(options==null)||(options.showhide)}"><a href="/account/pic/edit/hide/downloadpic/?sqq=${crypto.encodeURL(param.sqq)}">Hide</a></c:if>
                                    <div class="col edit_pic_pos">
                                        <div class="custom-select">
                                        <form:select path="download" id="download" class="custom-select-box"><c:forEach var="i" begin="1" end="6"><form:option value="${i}"><spring:message code="userprivacy.label.0${i}"/></form:option></c:forEach></form:select>
                                                </div>
                                            </div></div>
                            </c:if>

                        <c:if test="${(options==null)||(options.lidislike)}">
                            <div class="form-element-show"><form:label path="doLiDis">Who can like/dislike your account pic:</form:label><c:if test="${(options==null)||(options.showhide)}"><a href="/account/pic/edit/hide/dolidislike/?sqq=${crypto.encodeURL(param.sqq)}">Hide</a></c:if>
                                    <div class="col edit_pic_pos">
                                        <div class="custom-select">
                                        <form:select path="doLiDis" id="doLiDis" class="custom-select-box"><c:forEach var="i" begin="1" end="6"><form:option value="${i}"><spring:message code="userprivacy.label.0${i}"/></form:option></c:forEach></form:select>
                                                </div>
                                            </div></div>
                            </c:if>

                        <c:if test="${(options==null)||(options.seelidislike)}">
                            <div class="form-element-show"><form:label path="seeLiDis">Who can see who likes/dislikes your account pic:</form:label><c:if test="${(options==null)||(options.showhide)}"><a href="/account/pic/edit/hide/seelidislike/?sqq=${crypto.encodeURL(param.sqq)}">Hide</a></c:if>
                                    <div class="col edit_pic_pos">
                                        <div class="custom-select">
                                        <form:select path="seeLiDis" id="seeLiDis" class="custom-select-box"><c:forEach var="i" begin="1" end="6"><form:option value="${i}"><spring:message code="userprivacy.label.0${i}"/></form:option></c:forEach></form:select>
                                                </div>
                                            </div></div>
                            </c:if>

                        <c:if test="${(options==null)||(options.dotalking)}">
                            <div class="form-element-show"><form:label path="doTalking">Who can talk on your account pic:</form:label><c:if test="${(options==null)||(options.showhide)}"><a href="/account/pic/edit/hide/dotalk/?sqq=${crypto.encodeURL(param.sqq)}">Hide</a></c:if>
                                    <div class="col edit_pic_pos">
                                        <div class="custom-select">
                                        <form:select path="doTalking" id="doTalking" class="custom-select-box"><c:forEach var="i" begin="1" end="6"><form:option value="${i}"><spring:message code="userprivacy.label.0${i}"/></form:option></c:forEach></form:select>
                                                </div>
                                            </div></div>
                            </c:if>

                        <c:if test="${(options==null)||(options.seetalking)}">
                            <div class="form-element-show"><form:label path="seeTalking">Who can see who talked on your account pic:</form:label><c:if test="${(options==null)||(options.showhide)}"><a href="/account/pic/edit/hide/seetalk/?sqq=${crypto.encodeURL(param.sqq)}">Hide</a></c:if>
                                    <div class="col edit_pic_pos">
                                        <div class="custom-select">
                                        <form:select path="seeTalking" id="seeTalking" class="custom-select-box"><c:forEach var="i" begin="1" end="6"><form:option value="${i}"><spring:message code="userprivacy.label.0${i}"/></form:option></c:forEach></form:select>
                                                </div>
                                            </div></div>
                            </c:if>

                        <c:if test="${(options==null)||(options.docomment)}">
                            <div class="form-element-show"><form:label path="doComment">Who can comment on your account pic:</form:label><c:if test="${(options==null)||(options.showhide)}"><a href="/account/pic/edit/hide/docomment/?sqq=${crypto.encodeURL(param.sqq)}">Hide</a></c:if>
                                    <div class="col edit_pic_pos">
                                        <div class="custom-select">
                                        <form:select path="doComment" id="doComment" class="custom-select-box"><c:forEach var="i" begin="1" end="6"><form:option value="${i}"><spring:message code="userprivacy.label.0${i}"/></form:option></c:forEach></form:select>
                                                </div>
                                            </div></div>
                            </c:if>

                        <c:if test="${(options==null)||(options.seecomment)}">
                            <div class="form-element-show"><form:label path="seeComment">Who can see who commented on your account pic:</form:label><c:if test="${(options==null)||(options.showhide)}"><a href="/account/pic/edit/hide/seecomment/?sqq=${crypto.encodeURL(param.sqq)}">Hide</a></c:if>
                                    <div class="col edit_pic_pos">
                                        <div class="custom-select">
                                        <form:select path="seeComment" id="seeComment" class="custom-select-box"><c:forEach var="i" begin="1" end="6"><form:option value="${i}"><spring:message code="userprivacy.label.0${i}"/></form:option></c:forEach></form:select>
                                                </div>
                                            </div></div>
                            </c:if>

                        <c:if test="${(options==null)||(options.doshare)}">
                            <div class="form-element-show"><form:label path="doShare">Who can share your account pic:</form:label><c:if test="${(options==null)||(options.showhide)}"><a href="/account/pic/edit/hide/doshare/?sqq=${crypto.encodeURL(param.sqq)}">Hide</a></c:if>
                                    <div class="col edit_pic_pos">
                                        <div class="custom-select">
                                        <form:select path="doShare" id="doShare" class="custom-select-box"><c:forEach var="i" begin="1" end="6"><form:option value="${i}"><spring:message code="userprivacy.label.0${i}"/></form:option></c:forEach></form:select>
                                                </div>
                                            </div></div>
                            </c:if>

                        <c:if test="${(options==null)||(options.seeshare)}">
                            <div class="form-element-show"><form:label path="seeShare">Who can see who has shared your account pic:</form:label><c:if test="${(options==null)||(options.showhide)}"><a href="/account/pic/edit/hide/seeshare/?sqq=${crypto.encodeURL(param.sqq)}">Hide</a></c:if>
                                    <div class="col edit_pic_pos">
                                        <div class="custom-select">
                                        <form:select path="seeShare" id="seeShare" class="custom-select-box"><c:forEach var="i" begin="1" end="6"><form:option value="${i}"><spring:message code="userprivacy.label.0${i}"/></form:option></c:forEach></form:select>
                                                </div>
                                            </div></div>
                            </c:if>

                        <div class="fdsf_sf_sda">
                            <c:if test="${(options==null)||(options.prilike)}">
                                <form:hidden path="hlike" id="hlike" value="true"/><form:label path="like" class="contain_checkbox edit_pic_opt"><form:checkbox path="like" id="like" value="true"/><span class="custom_checkbox"></span>Like</form:label>
                            </c:if>
                            <c:if test="${(options==null)||(options.pridislike)}">
                                <form:hidden path="hdislike" id="hdislike" value="true"/><form:label path="dislike" class="contain_checkbox edit_pic_opt"><form:checkbox path="dislike" id="dislike" value="true"/><span class="custom_checkbox"></span>Dislike</form:label>
                            </c:if>
                            <c:if test="${(options==null)||(options.pritalking)}">
                                <form:hidden path="htalking" id="htalking" value="true"/><form:label path="talking" class="contain_checkbox edit_pic_opt"><form:checkbox path="talking" id="talking" value="true"/><span class="custom_checkbox"></span>Talking</form:label>
                            </c:if>
                            <c:if test="${(options==null)||(options.pricomment)}">
                                <form:hidden path="hcomment" id="hcomment" value="true"/><form:label path="comment" class="contain_checkbox edit_pic_opt"><form:checkbox path="comment" id="comment" value="true"/><span class="custom_checkbox"></span>Comment</form:label>
                            </c:if>
                            <c:if test="${(options==null)||(options.prishare)}">
                                <form:hidden path="hshare" id="hshare" value="true"/><form:label path="share" class="contain_checkbox edit_pic_opt"><form:checkbox path="share" id="share" value="true"/><span class="custom_checkbox"></span>Share</form:label>
                            </c:if>
                        </div>
                        <form:button name="update" id="update" class="form_pic_button" value="submit">Update</form:button>
                    </form:form>
                </c:if>
            </div>
            </div>
        </div>
        <script>
            h("accpicoper").addEventListener("submit", function () {
                as__bnm();
            });

            function as__bnm() {
                h("wrapper").className += " animate_out";
                h("update").innerHTML = "Updating....";
                h("slide_layout").className += " animate_in";
            }
            function h(a) {
                return window.document.getElementById(a);
            }
        </script>
        <script type="text/javascript" src="/rele/js/GYhdUdJiI.js"></script>
    </body>
</html>
