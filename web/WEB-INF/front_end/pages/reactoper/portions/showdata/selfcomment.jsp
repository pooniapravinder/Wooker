<div class="yl__p"></div>
<c:set var="comments" value="${ReactData.getComments(true,user,crypto.decrypt(param.sqq),page)}"/>
<c:set var="totalPage" value="${ReactData.getCommentTotalPage(true,user,crypto.decrypt(param.sqq))}"/>
<c:if test="${page>totalPage}"><c:redirect url = "${requestURI}?sqq=${crypto.encodeURL(param.sqq)}&refer=${crypto.encodeURL(param.refer)}"/></c:if>
<c:if test="${page>0 && page<=totalPage}"><div class="uop_ppa"><a href="${requestURI}?sqq=${crypto.encodeURL(param.sqq)}&amp;refer=${crypto.encodeURL(param.refer)}<c:if test='${((page-1)!=0)}'>&amp;page=${page-1}</c:if>">Newer Comments</a></div></c:if>
<c:forEach items="${comments}" var="data">
    <c:set var="isBlocked" value="${blockedDisable.isBlocked(data.userOne,data.targetId)}"/>
    <c:set var="isDisabled" value="${blockedDisable.isDisabled(data.operId)}"/>
    <c:set var="targetSQQ" value="${crypto.encrypt(data.targetId)}"/>
    <c:set var="talkSQQ" value="${crypto.encrypt(data.operId)}"/>
    <c:set var="talkerPicSQQ" value="${crypto.encrypt(getImage.getAccountPic(data.userOne).getPicId())}"/>
    <c:set var="attachment" value="${crypto.encrypt(data.picId)}"/>
    <c:set var="talkerInfo" value="${getUserData.getPriInfo(data.userOne)}"/>
    <c:set var="talkerUser" value="${crypto.encrypt(talkerInfo.getUserId())}"/>
    <c:set var="talklikedDisliked" value="${ReactData.getSingleLikeDislike(user,data.operId).likeDislike}"/>
    <c:set var="countTalkLike" value="${ReactData.countLikesDislikes(true,data.operId)}"/>
    <c:set var="countTalkDislike" value="${ReactData.countLikesDislikes(false,data.operId)}"/>
    <c:set var="countReply" value="${ReactData.countTalkings(data.operId)}"/>
    <c:set var="getTime" value="${CalTime.saveShortTime(data.timestampComment)}"/>
    <div class="fdger_ghfdfd">
        <div class="rtr_fdss">
            <div class="qwcd nhy">
                <a href="/info/<c:if test='${talkerInfo.getUserId()!=user}'>?sqq=${crypto.encodeURL(talkerUser)}</c:if>">
                    <c:choose>
                        <c:when test="${talkerPicSQQ!=null}">
                            <div class="wethj_gf">
                                <img src="/account/pic/show/a1/?sqq=${crypto.encodeURL(talkerPicSQQ)}" alt="img">
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
            <div class="uu_pp">
                <c:choose>
                    <c:when test="${user!=talkerInfo.getUserId()}">
                        <a href="/user/chat/?sqq=${crypto.encodeURL(talkerUser)}">${talkerInfo.firstName} ${talkerInfo.lastName}</a>
                    </c:when><c:otherwise>
                        <div class="gr_ds_dssd">
                            ${talkerInfo.firstName} ${talkerInfo.lastName}
                        </div></c:otherwise>
                </c:choose>

                <div class="ytr__hgfh">${CalTime.time}</div>
            </div>
            <div class="de_gh">
                <c:if test="${(user==data.userTwo)&&(data.selfUser)}"><div class="gr_ds_dssd">You:</div></c:if>
                <c:out value="${data.commentText}"/>
            </div>
            <c:if test="${attachment!=null}">
                <div class="de_gh">
                    <a href="/a/u/ff/rt/xz/cv/bc/full/?sqq=${crypto.encodeURL(attachment)}"><img src="/a/u/ff/rt/xz/cv/bc/a1/?sqq=${crypto.encodeURL(attachment)}" class="dfgf_hgf" alt="img"></a>
                </div>
            </c:if>

            <div class="yk__p">
                <c:if test="${accpicoper.likes}">
                    <c:choose>
                        <c:when test="${privacyChecker.privacyChecker(accpicoper.userId,user,accpicoper.seeLidislike)}">
                            <c:if test="${countTalkLike > 0}"><a href="/comment/user/oper/liked/?sqq=${crypto.encodeURL(talkSQQ)}&amp;refer=kHy_d-sdKhdIIDj&amp;prerefer=${crypto.encodeURL(param.refer)}<c:if test='${page!=0}'>&amp;prepage=${page}</c:if>" class="_hjww__nnsa">${countTalkLike}</a></c:if>
                        </c:when>
                        <c:otherwise>
                            <div class="gr_ds_dssd"><c:if test="${countTalkLike > 0}">${countTalkLike}</c:if></div>
                        </c:otherwise>
                    </c:choose>
                    <c:choose>
                        <c:when test="${(privacyChecker.privacyChecker(accpicoper.userId,user,accpicoper.doLidislike))&&(!isDisabled)}">
                            <a href="/comment/user/oper/like/?sqq=${crypto.encodeURL(talkSQQ)}&amp;refer=kHy_d-sdKhdIIDj&amp;prerefer=${crypto.encodeURL(param.refer)}<c:if test='${page!=0}'>&amp;page=${page}</c:if>"><c:choose><c:when test="${(countTalkLike>1)&&(!talklikedDisliked)}">Likes</c:when><c:when test="${(countTalkLike>=1)&&(talklikedDisliked)}">Liked</c:when><c:otherwise>Like</c:otherwise></c:choose></a>
                        </c:when>
                        <c:otherwise>
                            <div class="gr_ds_dssd"><c:choose><c:when test="${(countTalkLike>1)&&(!talklikedDisliked)}">Likes</c:when><c:when test="${(countTalkLike>=1)&&(talklikedDisliked)}">Liked</c:when><c:otherwise>Like</c:otherwise></c:choose></div>
                        </c:otherwise>
                    </c:choose>
                </c:if>

                <c:if test="${accpicoper.dislikes}">
                    <c:choose>
                        <c:when test="${privacyChecker.privacyChecker(accpicoper.userId,user,accpicoper.seeLidislike)}">
                            <c:if test="${countTalkDislike > 0}"><a href="/comment/user/oper/disliked/?sqq=${crypto.encodeURL(talkSQQ)}&amp;refer=kHy_d-sdKhdIIDj&amp;prerefer=${crypto.encodeURL(param.refer)}<c:if test='${page!=0}'>&amp;prepage=${page}</c:if>" class="_hjww__nnsa">${countTalkDislike}</a></c:if>
                        </c:when>
                        <c:otherwise>
                            <div class="gr_ds_dssd"><c:if test="${countTalkDislike > 0}">${countTalkDislike}</c:if></div>
                        </c:otherwise>
                    </c:choose>
                    <c:choose>
                        <c:when test="${(privacyChecker.privacyChecker(accpicoper.userId,user,accpicoper.doLidislike))&&(!isDisabled)}">
                            <a href="/comment/user/oper/dislike/?sqq=${crypto.encodeURL(talkSQQ)}&amp;refer=kHy_d-sdKhdIIDj&amp;prerefer=${crypto.encodeURL(param.refer)}<c:if test='${page!=0}'>&amp;page=${page}</c:if>"><c:choose><c:when test="${(countTalkDislike>1)&&(talklikedDisliked)}">Dislikes</c:when><c:when test="${(countTalkDislike>=1)&&(talklikedDisliked==false)}">Disliked</c:when><c:otherwise>Dislike</c:otherwise></c:choose></a>
                        </c:when>
                        <c:otherwise>
                            <div class="gr_ds_dssd"><c:choose><c:when test="${(countTalkDislike>1)&&(talklikedDisliked)}">Dislikes</c:when><c:when test="${(countTalkDislike>=1)&&(talklikedDisliked==false)}">Disliked</c:when><c:otherwise>Dislike</c:otherwise></c:choose></div>
                        </c:otherwise>
                    </c:choose>
                </c:if>


                <a href="/comment/user/oper/write/?sqq=${crypto.encodeURL(targetSQQ)}&amp;user=${crypto.encodeURL(talkerUser)}&amp;refer=vbYUn-MnIOA_sEL&amp;prerefer=${crypto.encodeURL(param.refer)}<c:if test='${page!=0}'>&amp;prepage=${page}</c:if>">Write</a>
                <c:if test="${(user==data.userTwo)&&(data.selfUser)&&(!data.edited)}">
                    <a href="/comment/user/oper/edit/?sqq=${crypto.encodeURL(talkSQQ)}&amp;refer=kHy_d-sdKhdIIDj&amp;prerefer=${crypto.encodeURL(param.refer)}<c:if test='${page!=0}'>&amp;prepage=${page}</c:if>">Edit</a>
                </c:if>
                <c:if test="${data.edited}">
                    <a href="/comment/user/oper/edit/?sqq=${crypto.encodeURL(talkSQQ)}&amp;refer=kHy_d-sdKhdIIDj&amp;prerefer=${crypto.encodeURL(param.refer)}<c:if test='${page!=0}'>&amp;prepage=${page}</c:if>">Edited</a>
                </c:if>
                    <a href="/comment/user/oper/delete/?sqq=${crypto.encodeURL(talkSQQ)}&amp;refer=kHy_d-sdKhdIIDj&amp;prerefer=${crypto.encodeURL(param.refer)}<c:if test='${page!=0}'>&amp;page=${page}</c:if>">Delete</a>
                <c:if test="${(user==data.userTwo)&&(!isDisabled)}">
                    <a href="/comment/user/oper/disable/?sqq=${crypto.encodeURL(talkSQQ)}&amp;refer=kHy_d-sdKhdIIDj&amp;prerefer=${crypto.encodeURL(param.refer)}<c:if test='${page!=0}'>&amp;page=${page}</c:if>">Disable</a>
                </c:if>
                <c:if test="${(user==data.userTwo)&&(isDisabled)}">
                    <a href="/comment/user/oper/enable/?sqq=${crypto.encodeURL(talkSQQ)}&amp;refer=kHy_d-sdKhdIIDj&amp;prerefer=${crypto.encodeURL(param.refer)}<c:if test='${page!=0}'>&amp;page=${page}</c:if>">Enable</a>
                </c:if>
                <c:if test="${(user==data.userTwo)&&(!data.selfUser)&&(!isBlocked)}">
                    <a href="/comment/user/oper/block/?sqq=${crypto.encodeURL(talkSQQ)}&amp;refer=kHy_d-sdKhdIIDj&amp;prerefer=${crypto.encodeURL(param.refer)}<c:if test='${page!=0}'>&amp;page=${page}</c:if>">Block</a>
                </c:if>
                <c:if test="${(user==data.userTwo)&&(!data.selfUser)&&(isBlocked)}">
                    <a href="/comment/user/oper/unblock/?sqq=${crypto.encodeURL(talkSQQ)}&amp;refer=kHy_d-sdKhdIIDj&amp;prerefer=${crypto.encodeURL(param.refer)}<c:if test='${page!=0}'>&amp;page=${page}</c:if>">Unblock</a>
                </c:if>
            </div>
            <div class="ylm__p"></div>
        </div>
    </div>
</c:forEach>
<c:if test="${page<totalPage}"><div class="uop_ppa"><a href="${requestURI}?sqq=${crypto.encodeURL(param.sqq)}&amp;refer=${crypto.encodeURL(param.refer)}&amp;page=${page+1}">Older Comments</a></div></c:if>
<c:if test="${comments.isEmpty()}">
    <div class="uop_ppa">No one left comment on your post yet</div>
</c:if>