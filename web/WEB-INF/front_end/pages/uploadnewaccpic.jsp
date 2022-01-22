<%@page import="java.util.List"%><%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@taglib uri="http://www.springframework.org/tags" prefix="spring"%><%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%><%@page contentType="text/html" pageEncoding="UTF-8"%><%@page session="false"%><!DOCTYPE html>
<html lang="en-US" id="wooker">
    <head>
        <meta name="keywords" content="Upload new Account Pic">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
        <meta name="theme-color" content="#663399">
        <link rel="shortcut icon" href="//www.google.com/favicon.ico"/>
        <meta name="description" content="Upload your new Account Pic with More Options">
        <meta name="google" content="notranslate">
        <title>Upload New Account Pic</title>
        <link rel="stylesheet" type="text/css" href="/rele/css/styleone.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/styletwo.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/stylethree.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/JuiLOdOpp.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/IoDJnmdJdDE.css">
    </head>
    <body>
        <div class="slide_layout" id="slide_layout"><div class="loading_text">Uploading account pic....</div>
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
                <h2>Upload New Account Pic</h2>
                <jsp:useBean id="getOptions" class="hibernate.query.info.ShowHideInfoOpt"/>
                <c:set var="options" value="${getOptions.getPicUplOptions(user)}"/>

                <div class="upp_ss_elem">
                    <c:if test="${(options==null)||(options.info)}"><div class="options_position"><a href="/info/">Primary Info</a></div></c:if><c:if test="${(options==null)||(options.moreinfo)}"><div class="options_position"><a href="/more/info/">Secondary Info</a></div></c:if><c:if test="${(options==null)||(options.setting)}"><div class="options_position"><a href="/account/pic/upload/new/settings/">Settings</a></div></c:if><c:if test="${(options==null)||(options.security)}"><div class="options_position"><a href="/account/pic/upload/new/security/">Security</a></div></c:if>
                    </div>

                <c:if test="${options==null||options.see||options.dodownload||options.lidislike||options.seelidislike||options.dotalking||options.seetalking||options.docomment||options.seecomment||options.doshare||options.seeshare||options.prilike||options.pridislike||options.pritalking||options.pricomment||options.prishare}">
                    <form:form method="post" name="accpicoper" class="table" modelAttribute="accpicoper" action="" enctype="multipart/form-data">
                        <form:errors path="img" class="signup-errors"/>

                        <c:if test="${(options==null)||(options.picpreview)}">
                            <form:label path="img"><img class="pic-preview" id="pic_preview" src="/rele/img/default-user-account-pic.png" alt=""/></form:label>
                        </c:if>

                        <c:if test="${(options==null)||(options.choosepic)}">
                            <div class="pic-upload-button">
                                Choose Account Pic<form:input path="img" id="img" type="file" accept="image/*" class="upload-button" autocorrect="off" autocomplete="off" spellcheck="false"/>
                            </div></c:if>

                        <c:if test="${(options==null)||(options.see)}">
                            <div class="form-element-show">
                                <form:label path="privacy">Who can see your account pic:</form:label><c:if test="${(options==null)||(options.showhide)}"><a href="/account/pic/upload/new/hide/seepic/">Hide</a></c:if>
                                    <div class="col edit_pic_pos">
                                        <div class="custom-select">
                                        <form:select path="privacy" id="privacy" class="custom-select-box"><c:forEach var="i" begin="1" end="6"><form:option value="${i}"><spring:message code="userprivacy.label.0${i}"/></form:option></c:forEach></form:select>
                                                </div>
                                            </div></div>
                            </c:if>

                        <c:if test="${(options==null)||(options.dodownload)}">
                            <div class="form-element-show"><form:label path="download">Who can download your account pic:</form:label><c:if test="${(options==null)||(options.showhide)}"><a href="/account/pic/upload/new/hide/downloadpic/">Hide</a></c:if>
                                    <div class="col edit_pic_pos">
                                        <div class="custom-select">
                                        <form:select path="download" id="download" class="custom-select-box"><c:forEach var="i" begin="1" end="6"><form:option value="${i}"><spring:message code="userprivacy.label.0${i}"/></form:option></c:forEach></form:select>
                                                </div>
                                            </div></div>
                            </c:if>

                        <c:if test="${(options==null)||(options.lidislike)}">
                            <div class="form-element-show"><form:label path="doLiDis">Who can like/dislike your account pic:</form:label><c:if test="${(options==null)||(options.showhide)}"><a href="/account/pic/upload/new/hide/dolidislike/">Hide</a></c:if>
                                    <div class="col edit_pic_pos">
                                        <div class="custom-select">
                                        <form:select path="doLiDis" id="doLiDis" class="custom-select-box"><c:forEach var="i" begin="1" end="6"><form:option value="${i}"><spring:message code="userprivacy.label.0${i}"/></form:option></c:forEach></form:select>
                                                </div>
                                            </div></div>
                            </c:if>

                        <c:if test="${(options==null)||(options.seelidislike)}">
                            <div class="form-element-show"><form:label path="seeLiDis">Who can see who likes/dislikes your account pic:</form:label><c:if test="${(options==null)||(options.showhide)}"><a href="/account/pic/upload/new/hide/seelidislike/">Hide</a></c:if>
                                    <div class="col edit_pic_pos">
                                        <div class="custom-select">
                                        <form:select path="seeLiDis" id="seeLiDis" class="custom-select-box"><c:forEach var="i" begin="1" end="6"><form:option value="${i}"><spring:message code="userprivacy.label.0${i}"/></form:option></c:forEach></form:select>
                                                </div>
                                            </div></div>
                            </c:if>

                        <c:if test="${(options==null)||(options.dotalking)}">
                            <div class="form-element-show"><form:label path="doTalking">Who can talk on your account pic:</form:label><c:if test="${(options==null)||(options.showhide)}"><a href="/account/pic/upload/new/hide/dotalk/">Hide</a></c:if>
                                    <div class="col edit_pic_pos">
                                        <div class="custom-select">
                                        <form:select path="doTalking" id="doTalking" class="custom-select-box"><c:forEach var="i" begin="1" end="6"><form:option value="${i}"><spring:message code="userprivacy.label.0${i}"/></form:option></c:forEach></form:select>
                                                </div>
                                            </div></div>
                            </c:if>

                        <c:if test="${(options==null)||(options.seetalking)}">
                            <div class="form-element-show"><form:label path="seeTalking">Who can see who talked on your account pic:</form:label><c:if test="${(options==null)||(options.showhide)}"><a href="/account/pic/upload/new/hide/seetalk/">Hide</a></c:if>
                                    <div class="col edit_pic_pos">
                                        <div class="custom-select">
                                        <form:select path="seeTalking" id="seeTalking" class="custom-select-box"><c:forEach var="i" begin="1" end="6"><form:option value="${i}"><spring:message code="userprivacy.label.0${i}"/></form:option></c:forEach></form:select>
                                                </div>
                                            </div></div>
                            </c:if>

                        <c:if test="${(options==null)||(options.docomment)}">
                            <div class="form-element-show"><form:label path="doComment">Who can comment on your account pic:</form:label><c:if test="${(options==null)||(options.showhide)}"><a href="/account/pic/upload/new/hide/docomment/">Hide</a></c:if>
                                    <div class="col edit_pic_pos">
                                        <div class="custom-select">
                                        <form:select path="doComment" id="doComment" class="custom-select-box"><c:forEach var="i" begin="1" end="6"><form:option value="${i}"><spring:message code="userprivacy.label.0${i}"/></form:option></c:forEach></form:select>
                                                </div>
                                            </div></div>
                            </c:if>

                        <c:if test="${(options==null)||(options.seecomment)}">
                            <div class="form-element-show"><form:label path="seeComment">Who can see who commented on your account pic:</form:label><c:if test="${(options==null)||(options.showhide)}"><a href="/account/pic/upload/new/hide/seecomment/">Hide</a></c:if>
                                    <div class="col edit_pic_pos">
                                        <div class="custom-select">
                                        <form:select path="seeComment" id="seeComment" class="custom-select-box"><c:forEach var="i" begin="1" end="6"><form:option value="${i}"><spring:message code="userprivacy.label.0${i}"/></form:option></c:forEach></form:select>
                                                </div>
                                            </div></div>
                            </c:if>

                        <c:if test="${(options==null)||(options.doshare)}">
                            <div class="form-element-show"><form:label path="doShare">Who can share your account pic:</form:label><c:if test="${(options==null)||(options.showhide)}"><a href="/account/pic/upload/new/hide/doshare/">Hide</a></c:if>
                                    <div class="col edit_pic_pos">
                                        <div class="custom-select">
                                        <form:select path="doShare" id="doShare" class="custom-select-box"><c:forEach var="i" begin="1" end="6"><form:option value="${i}"><spring:message code="userprivacy.label.0${i}"/></form:option></c:forEach></form:select>
                                                </div>
                                            </div></div>
                            </c:if>

                        <c:if test="${(options==null)||(options.seeshare)}">
                            <div class="form-element-show"><form:label path="seeShare">Who can see who has shared your account pic:</form:label><c:if test="${(options==null)||(options.showhide)}"><a href="/account/pic/upload/new/hide/seeshare/">Hide</a></c:if>
                                    <div class="col edit_pic_pos">
                                        <div class="custom-select">
                                        <form:select path="seeShare" id="seeShare" class="custom-select-box"><c:forEach var="i" begin="1" end="6"><form:option value="${i}"><spring:message code="userprivacy.label.0${i}"/></form:option></c:forEach></form:select>
                                                </div>
                                            </div></div>
                            </c:if>

                        <div class="fdsf_sf_sda">
                            <c:if test="${(options==null)||(options.prilike)}">
                                <form:label path="like" class="contain_checkbox edit_pic_opt"><form:checkbox path="like" id="like" value="true"/><span class="custom_checkbox"></span>Like</form:label>
                            </c:if>
                            <c:if test="${(options==null)||(options.pridislike)}">
                                <form:label path="dislike" class="contain_checkbox edit_pic_opt"><form:checkbox path="dislike" id="dislike" value="true"/><span class="custom_checkbox"></span>Dislike</form:label>
                            </c:if>
                            <c:if test="${(options==null)||(options.pritalking)}">
                                <form:label path="talking" class="contain_checkbox edit_pic_opt"><form:checkbox path="talking" id="talking" value="true"/><span class="custom_checkbox"></span>Talking</form:label>
                            </c:if>
                            <c:if test="${(options==null)||(options.pricomment)}">
                                <form:label path="comment" class="contain_checkbox edit_pic_opt"><form:checkbox path="comment" id="comment" value="true"/><span class="custom_checkbox"></span>Comment</form:label>
                            </c:if>
                            <c:if test="${(options==null)||(options.prishare)}">
                                <form:label path="share" class="contain_checkbox edit_pic_opt"><form:checkbox path="share" id="share" value="true"/><span class="custom_checkbox"></span>Share</form:label>
                            </c:if>
                        </div>
                        <form:button name="upload" id="upload" class="form_pic_button" value="submit">Upload</form:button>
                    </form:form>
                </c:if>
            </div>
            </div>
            <c:set var="page" value="${param.page.matches('^(?:[0-9]){1,11}$') ? param.page : 0}"/>
            <c:set var="allPics" value="${getImage.getAccImage(user, page)}"/>
            <c:if test="${((options==null)||(options.previouspics))&&!allPics.isEmpty()}">
                <c:set var="totalPage" value="${getImage.getAccImgPage(user)}"/>
                <div class="previous_pics acc_pics_container main clearfix" id="web_view">
                <div class="content">
                    <div class="close_bottom"><a href="/account/pic/upload/new/hide/prepics/">Close</a></div>
                    <c:if test="${page>0 && page<=totalPage}"><div class="pagination_less"><c:choose><c:when test="${((page-1)==0)}"><a href="/account/pic/upload/new/">Newer Account Pics</a></c:when><c:otherwise><a href="/account/pic/upload/new/?page=${page-1}">Newer Account Pics</a></c:otherwise></c:choose></div></c:if>
                    <c:forEach items="${allPics}" var="data">
                        <c:set var="id" value="${crypto.encrypt(data.picId)}"/>
                        <jsp:useBean id="CalTime" class="timeperiod.duration.calculation.CalculateTime"/>
                        <c:set var="getTime" value="${CalTime.saveDateTime(data.timeStamp)}"/>
                        <jsp:useBean id="OptVal" class="hibernate.query.reactoper.ReactOper"/>
                        <c:set var="likedDisliked" value="${OptVal.getSingleLikeDislike(user,data.picId).likeDislike}"/>
                        <c:set var="countLike" value="${OptVal.countLikesDislikes(true,data.picId)}"/>
                        <c:set var="countDislike" value="${OptVal.countLikesDislikes(false,data.picId)}"/>
                        <c:set var="countTalking" value="${OptVal.countTalkings(data.picId)}"/>
                        <c:set var="countComment" value="${OptVal.countComments(data.picId)}"/>
                        <div class="pic_contain">
                            <div class="fer-sdm sada">
                                <a href="/account/pic/full/size/?sqq=${crypto.encodeURL(id)}"><div class="sdser">
                                        <img src="/account/pic/show/a3/?sqq=${crypto.encodeURL(id)}"></div></a>
                            </div>
                            <div class="upp_ss_elem">
                                <a href="/account/pic/remove/?sqq=${crypto.encodeURL(id)}" class="top_edit_pic_options fdg__asaf_w">Remove</a><a href="/account/pic/delete/?sqq=${crypto.encodeURL(id)}" class="top_edit_pic_options fdg__asaf_w">Delete</a><a href="/account/pic/full/download/?sqq=${crypto.encodeURL(id)}" class="top_edit_pic_options fdg__asaf_w">Download</a>
                            </div>
                            <div class="upp_ss_elem">
                                <div class="pic_time">
                                    <spring:message code="label.day.0${CalTime.day}"/> <c:if test="${CalTime.month<=9}"><spring:message code="label.month.0${CalTime.month}"/></c:if><c:if test="${CalTime.month>9}"><spring:message code="label.month.${CalTime.month}"/></c:if> ${CalTime.date},${CalTime.year} ${CalTime.time}
                                    </div>
                                </div>
                            <c:if test="${data.likes}">
                                <c:if test="${countLike > 0}"><a href="/accpic/user/oper/liked/?sqq=${crypto.encodeURL(id)}&amp;refer=AodiEj-dL_dejEW" class="bott_edit_pic_options">${countLike}</a></c:if>
                                <a href="/accpic/user/oper/like/?sqq=${crypto.encodeURL(id)}&amp;refer=AodiEj-dL_dejEW" class="bott_edit_pic_options"><c:choose><c:when test="${(countLike>1)&&(!likedDisliked)}">Likes</c:when><c:when test="${(countLike>=1)&&(likedDisliked)}">Liked</c:when><c:otherwise>Like</c:otherwise></c:choose></a>

                            </c:if>
                            <c:if test="${data.dislikes}">
                                <c:if test="${countDislike > 0}"><a href="/accpic/user/oper/disliked/?sqq=${crypto.encodeURL(id)}&amp;refer=AodiEj-dL_dejEW" class="bott_edit_pic_options">${countDislike}</a></c:if>
                                <a href="/accpic/user/oper/dislike/?sqq=${crypto.encodeURL(id)}&amp;refer=AodiEj-dL_dejEW" class="bott_edit_pic_options"><c:choose><c:when test="${(countDislike>1)&&(likedDisliked)}">Dislikes</c:when><c:when test="${(countDislike>=1)&&(!likedDisliked)}">Disliked</c:when><c:otherwise>Dislike</c:otherwise></c:choose></a>
                            </c:if>
                            <c:if test="${data.talkings}">
                                <c:if test="${countTalking > 0}"><a href="/accpic/user/oper/talked/?sqq=${crypto.encodeURL(id)}&amp;refer=AodiEj-dL_dejEW" class="bott_edit_pic_options">${countTalking}</a></c:if>
                                <a href="/accpic/user/oper/talking/?sqq=${crypto.encodeURL(id)}&amp;refer=AodiEj-dL_dejEW" class="bott_edit_pic_options">Talking</a>
                            </c:if>
                            <c:if test="${data.comments}">
                                <c:if test="${countComment > 0}"><a href="/accpic/user/oper/commented/?sqq=${crypto.encodeURL(id)}&amp;refer=AodiEj-dL_dejEW" class="bott_edit_pic_options">${countComment}</a></c:if>
                                <a href="/accpic/user/oper/comment/?sqq=${crypto.encodeURL(id)}&amp;refer=AodiEj-dL_dejEW" class="bott_edit_pic_options"><c:choose><c:when test="${countComment == 1}">Comment</c:when><c:when test="${countComment > 1}">Comments</c:when><c:otherwise>Comment</c:otherwise></c:choose></a>
                            </c:if>
                            <c:if test="${data.shares}">
                                <a href="/accpic/user/oper/share/?sqq=${crypto.encodeURL(id)}&amp;refer=AodiEj-dL_dejEW" class="bott_edit_pic_options">Share</a>
                            </c:if>
                        </div>

                    </c:forEach>
                    <c:if test="${page<totalPage}">
                        <div class="pagination_more"><a href="/account/pic/upload/new/?page=${page+1}">Older Account Pics</a></div>
                    </c:if>
                </div>
                </div>
            </c:if>
        </div>
        <script type="text/javascript" src="/rele/js/GYhdUdJiI.js"></script>
        <script>
            var a = a_b("img");
            a.addEventListener("change", function () {
                if (a.files && a.files[0]) {
                    var b = new FileReader();
                    b.onload = function (e) {
                        a_b("pic_preview").setAttribute("src", e.target.result);
                    };
                    b.readAsDataURL(a.files[0]);
                }
            });

            a_b("accpicoper").addEventListener("submit", function () {
                as__bnm();
            });

            function as__bnm() {
                a_b("wrapper").className += " animate_out";
                a_b("upload").innerHTML = "Uploading....";
                a_b("slide_layout").className += " animate_in";
            }
            function a_b(a) {
                return window.document.getElementById(a);
            }
        </script>
    </body>
</html>