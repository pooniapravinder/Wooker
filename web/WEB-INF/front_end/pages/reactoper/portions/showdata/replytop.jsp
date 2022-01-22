<jsp:useBean id="blockedDisable" class="hibernate.query.BlockDisable"/>
<jsp:useBean id="privacyChecker" class="pages.controller.reactoper.ReactOperValidate"/>
<c:set var="isBlocked" value="${blockedDisable.isBlocked(userSqq.userOne,userSqq.targetId)}"/>
<c:set var="isDisable" value="${blockedDisable.isDisabled(crypto.decrypt(param.sqq))}"/>
<c:set var="accpicoper" value="${getImage.AccountImg(userSqq.targetId)}"/>
<c:set var="talkerPic" value="${crypto.encrypt(getImage.getAccountPic(userSqq.userOne).getPicId())}"/>
<c:set var="talkerInfo" value="${getUserData.getPriInfo(userSqq.userOne)}"/>
<c:set var="attachment" value="${crypto.encrypt(userSqq.picId)}"/>
<c:set var="talkerUser" value="${crypto.encrypt(talkerInfo.userId)}"/>
<c:set var="replyUser" value="${talkerInfo.firstName} ${talkerInfo.lastName}"/>
<c:set var="likedDisliked" value="${ReactData.getSingleLikeDislike(user,userSqq.operId).likeDislike}"/>
<c:set var="countLike" value="${ReactData.countLikesDislikes(true,userSqq.operId)}"/>
<c:set var="countDislike" value="${ReactData.countLikesDislikes(false,userSqq.operId)}"/>
<c:set var="countReply" value="${ReactData.countTalkings(userSqq.operId)}"/>

<div class="fdger_ghfdfd">
    <div class="rtr_fdss">
        <div class="gty ry__w">
            <a href="/info/<c:if test="${talkerInfo.getUserId()!=user}">?sqq=${crypto.encodeURL(talkerUser)}</c:if>">

                <c:choose>
                    <c:when test="${talkerPic!=null}">
                        <div class="f_sds__u">
                            <img src="/account/pic/show/a1/?sqq=${crypto.encodeURL(talkerPic)}" alt="img">
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="f_sds__u">
                            <img src="/account/pic/show/user/default/a1/">
                        </div>
                    </c:otherwise>
                </c:choose>
            </a>
        </div>
    </div>
    <div class="_fgfd_bfdg">
        <div class="uu_pp">
            <c:choose>
                <c:when test="${user!=talkerInfo.getUserId()}">
                    <a href="/user/chat/?sqq=${crypto.encodeURL(talkerUser)}">${replyUser}</a>
                </c:when><c:otherwise>
                    <div class="gr_ds_dssd">
                        ${replyUser}
                    </div></c:otherwise>
            </c:choose>

        </div>
        <div class="de_gh">
            <c:out value="${userSqq.talkingText}"/>
        </div>

        <c:if test="${attachment!=null}">
            <div class="de_gh">
                <a href="/a/u/ff/rt/xz/cv/bc/full/?sqq=${crypto.encodeURL(attachment)}"><img src="/a/u/ff/rt/xz/cv/bc/a1/?sqq=${crypto.encodeURL(attachment)}" class="dfgf_hgf" alt="img"></a>
            </div>
        </c:if>
        <div class="de_gh">
            <jsp:useBean id="CalTime" class="timeperiod.duration.calculation.CalculateTime"/>
            <c:set var="getTime" value="${CalTime.saveDateTime(userSqq.timestampTalk)}"/>
            <spring:message code="label.day.0${CalTime.day}"/> <c:if test="${CalTime.month<=9}"><spring:message code="label.month.0${CalTime.month}"/></c:if><c:if test="${CalTime.month>9}"><spring:message code="label.month.${CalTime.month}"/></c:if> ${CalTime.date},${CalTime.year} ${CalTime.time}
        </div>
        <div class="yk__p">
            <c:if test="${accpicoper.likes}">
                <c:choose>
                    <c:when test="${privacyChecker.privacyChecker(accpicoper.userId,user,accpicoper.seeLidislike)}">
                        <c:if test="${countLike > 0}"><a href="/talking/user/oper/liked/?sqq=${crypto.encodeURL(param.sqq)}&amp;refer=weU_sJ-HQkjUsMl&amp;prerefer=${crypto.encodeURL(param.prerefer)}<c:if test='${page!=0}'>&amp;page=${page}</c:if>" class="_hjww__nnsa">${countLike}</a></c:if>
                    </c:when>
                    <c:otherwise>
                        <div class="gr_ds_dssd"><c:if test="${countLike > 0}">${countLike}</c:if></div>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${(privacyChecker.privacyChecker(accpicoper.userId,user,accpicoper.doLidislike))&&(!isDisable)}">
                        <a href="/talking/user/oper/like/?sqq=${crypto.encodeURL(param.sqq)}&amp;refer=weU_sJ-HQkjUsMl&amp;prerefer=${crypto.encodeURL(param.prerefer)}<c:if test='${page!=0}'>&amp;page=${page}</c:if>"><c:choose><c:when test="${(countLike>1)&&(!likedDisliked)}">Likes</c:when><c:when test="${(countLike>=1)&&(likedDisliked)}">Liked</c:when><c:otherwise>Like</c:otherwise></c:choose></a>
                    </c:when>
                    <c:otherwise>
                        <div class="gr_ds_dssd"><c:choose><c:when test="${(countLike>1)&&(!likedDisliked)}">Likes</c:when><c:when test="${(countLike>=1)&&(likedDisliked)}">Liked</c:when><c:otherwise>Like</c:otherwise></c:choose></div>
                    </c:otherwise>
                </c:choose>
            </c:if>

            <c:if test="${accpicoper.dislikes}">
                <c:choose>
                    <c:when test="${privacyChecker.privacyChecker(accpicoper.userId,user,accpicoper.seeLidislike)}">
                        <c:if test="${countDislike > 0}"><a href="/talking/user/oper/disliked/?sqq=${crypto.encodeURL(param.sqq)}&amp;refer=weU_sJ-HQkjUsMl&amp;prerefer=${crypto.encodeURL(param.prerefer)}<c:if test='${page!=0}'>&amp;page=${page}</c:if>" class="_hjww__nnsa">${countDislike}</a></c:if>
                    </c:when>
                    <c:otherwise>
                        <div class="gr_ds_dssd"><c:if test="${countDislike > 0}">${countDislike}</c:if></div>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${(privacyChecker.privacyChecker(accpicoper.userId,user,accpicoper.doLidislike))&&(!isDisable)}">
                        <a href="/talking/user/oper/dislike/?sqq=${crypto.encodeURL(param.sqq)}&amp;refer=weU_sJ-HQkjUsMl&amp;prerefer=${crypto.encodeURL(param.prerefer)}<c:if test='${page!=0}'>&amp;page=${page}</c:if>"><c:choose><c:when test="${(countDislike>1)&&(likedDisliked)}">Dislikes</c:when><c:when test="${(countDislike>=1)&&(likedDisliked==false)}">Disliked</c:when><c:otherwise>Dislike</c:otherwise></c:choose></a>
                    </c:when>
                    <c:otherwise>
                        <div class="gr_ds_dssd"><c:choose><c:when test="${(countDislike>1)&&(likedDisliked)}">Dislikes</c:when><c:when test="${(countDislike>=1)&&(likedDisliked==false)}">Disliked</c:when><c:otherwise>Dislike</c:otherwise></c:choose></div>
                    </c:otherwise>
                </c:choose>

            </c:if>
            <a href="/talking/user/oper/reply/?sqq=${crypto.encodeURL(param.sqq)}&amp;refer=kp_w8AAy-OaK_5P&amp;prerefer=${crypto.encodeURL(param.prerefer)}"><c:choose><c:when test="${(countReply>0)}">${countReply} Replies</c:when><c:otherwise>Reply</c:otherwise></c:choose></a>
            <c:if test="${(user==userSqq.userOne)&&(!userSqq.edited)}">
                <a href="/talking/user/oper/edit/?sqq=${crypto.encodeURL(param.sqq)}&amp;refer=NdwJfLnr_dj-dND&amp;prerefer=${crypto.encodeURL(param.prerefer)}<c:if test='${page!=0}'>&amp;prepage=${page}</c:if>">Edit</a>
            </c:if>
            <c:if test="${userSqq.edited}">
                <a href="/talking/user/oper/edit/?sqq=${crypto.encodeURL(param.sqq)}&amp;refer=NdwJfLnr_dj-dND&amp;prerefer=${crypto.encodeURL(param.prerefer)}<c:if test='${page!=0}'>&amp;prepage=${page}</c:if>">Edited</a>
            </c:if>
            <c:if test="${(user==userSqq.userOne) || (user==userSqq.userTwo)}">
                <a href="/talking/user/oper/delete/?sqq=${crypto.encodeURL(param.sqq)}&amp;refer=weU_sJ-HQkjUsMl&amp;prerefer=${crypto.encodeURL(param.prerefer)}<c:if test='${page!=0}'>&amp;page=${page}</c:if>">Delete</a>
            </c:if>
            <c:if test="${(user==userSqq.userTwo)&&(!isDisable)}">
                <a href="/talking/user/oper/disable/?sqq=${crypto.encodeURL(param.sqq)}&amp;refer=weU_sJ-HQkjUsMl&amp;prerefer=${crypto.encodeURL(param.prerefer)}<c:if test='${page!=0}'>&amp;page=${page}</c:if>">Disable</a>
            </c:if>
            <c:if test="${(user==userSqq.userTwo)&&(isDisable)}">
                <a href="/talking/user/oper/enable/?sqq=${crypto.encodeURL(param.sqq)}&amp;refer=weU_sJ-HQkjUsMl&amp;prerefer=${crypto.encodeURL(param.prerefer)}<c:if test='${page!=0}'>&amp;page=${page}</c:if>">Enable</a>
            </c:if>
            <c:if test="${(user!=userSqq.userOne)&&(user==userSqq.userTwo)&&(!isBlocked)}">
                <a href="/talking/user/oper/block/?sqq=${crypto.encodeURL(param.sqq)}&amp;refer=weU_sJ-HQkjUsMl&amp;prerefer=${crypto.encodeURL(param.prerefer)}<c:if test='${page!=0}'>&amp;page=${page}</c:if>">Block</a>
            </c:if>
            <c:if test="${(user!=userSqq.userOne)&&(user==userSqq.userTwo)&&(isBlocked)}">
                <a href="/talking/user/oper/unblock/?sqq=${crypto.encodeURL(param.sqq)}&amp;refer=weU_sJ-HQkjUsMl&amp;prerefer=${crypto.encodeURL(param.prerefer)}<c:if test='${page!=0}'>&amp;page=${page}</c:if>">Unblock</a>
            </c:if>
        </div>
    </div>
</div>