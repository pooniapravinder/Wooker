<jsp:useBean id="ReactData" class="hibernate.query.reactoper.ReactOper"/>
<jsp:useBean id="blockedDisable" class="hibernate.query.BlockDisable"/>
<c:set var="likedDisliked" value="${ReactData.getSingleLikeDislike(user,crypto.decrypt(param.sqq)).likeDislike}"/>
<c:set var="countLike" value="${ReactData.countLikesDislikes(true,crypto.decrypt(param.sqq))}"/>
<c:set var="countDislike" value="${ReactData.countLikesDislikes(false,crypto.decrypt(param.sqq))}"/>
<c:set var="countTalking" value="${ReactData.countTalkings(crypto.decrypt(param.sqq))}"/>
<c:set var="countComment" value="${ReactData.countComments(crypto.decrypt(param.sqq))}"/>
<c:choose>
    <c:when test="${requestURI.contains('talking')}">
        <c:set var="pageRefer" value="mrPdk_dm-dnn_dk"/>
    </c:when>
    <c:otherwise>
        <c:set var="pageRefer" value="HjDOplM-JEkr_fs"/>
    </c:otherwise>
</c:choose>
<div class="uop_ppa">
    <c:set var="getTime" value="${CalTime.saveDateTime(accpicoper.timeStamp)}"/>
    <spring:message code="label.day.0${CalTime.day}"/> <c:if test="${CalTime.month<=9}"><spring:message code="label.month.0${CalTime.month}"/></c:if><c:if test="${CalTime.month>9}"><spring:message code="label.month.${CalTime.month}"/></c:if> ${CalTime.date},${CalTime.year} ${CalTime.time}
</div>
<div class="uop_ppa">

    <c:if test="${accpicoper.likes}">
        <c:choose>
            <c:when test="${privacyChecker.privacyChecker(accpicoper.userId,user,accpicoper.seeLidislike)}">
                <c:if test="${countLike > 0}"><a href="/${requestPage}/user/oper/liked/?sqq=${crypto.encodeURL(param.sqq)}&amp;refer=${pageRefer}&amp;prerefer=${crypto.encodeURL(param.refer)}<c:if test='${page!=0}'>&amp;prepage=${page}</c:if>" class="_hjww__nnsa">${countLike}</a></c:if>
            </c:when>
            <c:otherwise>
                <div class="gr_ds_dssd"><c:if test="${countLike > 0}">${countLike}</c:if></div>
            </c:otherwise>
        </c:choose>
        <c:choose>
            <c:when test="${privacyChecker.privacyChecker(accpicoper.userId,user,accpicoper.doLidislike)}">
                <a href="/${requestPage}/user/oper/like/?sqq=${crypto.encodeURL(param.sqq)}&amp;refer=${pageRefer}&amp;prerefer=${crypto.encodeURL(param.refer)}<c:if test='${page!=0}'>&amp;page=${page}</c:if>" class="_hjww__nnsa"><c:choose><c:when test="${(countLike>1)&&(!likedDisliked)}">Likes</c:when><c:when test="${(countLike>=1)&&(likedDisliked)}">Liked</c:when><c:otherwise>Like</c:otherwise></c:choose></a>
            </c:when>
            <c:otherwise>
                <div class="gr_ds_dssd"><c:choose><c:when test="${(countLike>1)&&(!likedDisliked)}">Likes</c:when><c:when test="${(countLike>=1)&&(likedDisliked)}">Liked</c:when><c:otherwise>Like</c:otherwise></c:choose></div>
            </c:otherwise>
        </c:choose>
    </c:if>


    <c:if test="${accpicoper.dislikes}">
        <c:choose>
            <c:when test="${privacyChecker.privacyChecker(accpicoper.userId,user,accpicoper.seeLidislike)}">
                <c:if test="${countDislike > 0}"><a href="/${requestPage}/user/oper/disliked/?sqq=${crypto.encodeURL(param.sqq)}&amp;refer=${pageRefer}&amp;prerefer=${crypto.encodeURL(param.refer)}<c:if test='${page!=0}'>&amp;prepage=${page}</c:if>" class="_hjww__nnsa">${countDislike}</a></c:if>
            </c:when>
            <c:otherwise>
                <div class="gr_ds_dssd"><c:if test="${countDislike > 0}">${countDislike}</c:if></div>
            </c:otherwise>
        </c:choose>
        <c:choose>
            <c:when test="${privacyChecker.privacyChecker(accpicoper.userId,user,accpicoper.doLidislike)}">
                <a href="/${requestPage}/user/oper/dislike/?sqq=${crypto.encodeURL(param.sqq)}&amp;refer=${pageRefer}&amp;prerefer=${crypto.encodeURL(param.refer)}<c:if test='${page!=0}'>&amp;page=${page}</c:if>" class="_hjww__nnsa"><c:choose><c:when test="${(countDislike>1)&&(likedDisliked)}">Dislikes</c:when><c:when test="${(countDislike>=1)&&(likedDisliked==false)}">Disliked</c:when><c:otherwise>Dislike</c:otherwise></c:choose></a>
            </c:when>
            <c:otherwise>
                <div class="gr_ds_dssd"><c:choose><c:when test="${(countDislike>1)&&(likedDisliked)}">Dislikes</c:when><c:when test="${(countDislike>=1)&&(likedDisliked==false)}">Disliked</c:when><c:otherwise>Dislike</c:otherwise></c:choose></div>
            </c:otherwise>
        </c:choose>
    </c:if>


    <c:if test="${accpicoper.talkings}">
        <c:choose>
            <c:when test="${privacyChecker.privacyChecker(accpicoper.userId,user,accpicoper.seeTalking)}">
                <c:if test="${countTalking > 0}"><a href="/${requestPage}/user/oper/talked/?sqq=${crypto.encodeURL(param.sqq)}&amp;refer=${pageRefer}&amp;prerefer=${crypto.encodeURL(param.refer)}<c:if test='${page!=0}'>&amp;prepage=${page}</c:if>" class="_hjww__nnsa">${countTalking}</a></c:if>
            </c:when>
            <c:otherwise>
                <div class="gr_ds_dssd"><c:if test="${countTalking > 0}">${countTalking}</c:if></div>
            </c:otherwise>
        </c:choose>
        <a href="/${requestPage}/user/oper/talking/?sqq=${crypto.encodeURL(param.sqq)}&amp;refer=${crypto.encodeURL(param.refer)}" class="_hjww__nnsa">Talking</a>
    </c:if>


    <c:if test="${accpicoper.comments}">
        <c:choose>
            <c:when test="${privacyChecker.privacyChecker(accpicoper.userId,user,accpicoper.seeComment)}">
                <c:if test="${countComment > 0}"><a href="/${requestPage}/user/oper/commented/?sqq=${crypto.encodeURL(param.sqq)}&amp;refer=${pageRefer}&amp;prerefer=${crypto.encodeURL(param.refer)}<c:if test='${page!=0}'>&amp;prepage=${page}</c:if>" class="_hjww__nnsa">${countComment}</a></c:if>
            </c:when>
            <c:otherwise>
                <div class="gr_ds_dssd"><c:if test="${countComment > 0}">${countComment}</c:if></div>
            </c:otherwise>
        </c:choose>
        <c:choose>
            <c:when test="${privacyChecker.privacyChecker(accpicoper.userId,user,accpicoper.doComment)}">
                <a href="/${requestPage}/user/oper/comment/?sqq=${crypto.encodeURL(param.sqq)}&amp;refer=${crypto.encodeURL(param.refer)}" class="_hjww__nnsa"><c:choose><c:when test="${countComment == 1}">Comment</c:when><c:when test="${countComment > 1}">Comments</c:when><c:otherwise>Comment</c:otherwise></c:choose></a>
            </c:when>
            <c:otherwise>
                <div class="gr_ds_dssd"><c:choose><c:when test="${countComment == 1}">Comment</c:when><c:when test="${countComment > 1}">Comments</c:when><c:otherwise>Comment</c:otherwise></c:choose></div>
            </c:otherwise>
        </c:choose>
    </c:if>


    <c:if test="${accpicoper.shares}">
        <c:choose>
            <c:when test="${privacyChecker.privacyChecker(accpicoper.userId,user,accpicoper.seeShare)}">
                <c:if test="${countComment > 0}"><a href="/${requestPage}/user/oper/shared/?sqq=${crypto.encodeURL(param.sqq)}&amp;refer=${pageRefer}&amp;prerefer=${crypto.encodeURL(param.refer)}<c:if test='${page!=0}'>&amp;prepage=${page}</c:if>" class="_hjww__nnsa">${countComment}</a></c:if>
            </c:when>
            <c:otherwise>
                <div class="gr_ds_dssd"><c:if test="${countComment > 0}">${countComment}</c:if></div>
            </c:otherwise>
        </c:choose>
        <c:choose>
            <c:when test="${privacyChecker.privacyChecker(accpicoper.userId,user,accpicoper.doShare)}">
                <a href="/${requestPage}/user/oper/share/?sqq=${crypto.encodeURL(param.sqq)}&amp;refer=${crypto.encodeURL(param.refer)}" class="_hjww__nnsa">Share</a>
            </c:when>
            <c:otherwise>
                <div class="gr_ds_dssd">Share</div>
            </c:otherwise>
        </c:choose>

    </c:if>


    <c:if test="${(accpicoper.shares)&&(privacyChecker.privacyChecker(accpicoper.userId,user,accpicoper.download))}">
        <a href="/account/pic/full/download/?sqq=${crypto.encodeURL(param.sqq)}" class="_hjww__nnsa">Download</a>
    </c:if>
</div>