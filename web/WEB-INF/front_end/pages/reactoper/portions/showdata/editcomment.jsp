
<c:set var="totalPage" value="${ReactData.getEditCommTotalPage(userSqq.operId)}"/>
<c:if test="${page>totalPage}"><c:redirect url = "${requestURI}?sqq=${crypto.encodeURL(param.sqq)}&refer=${crypto.encodeURL(param.refer)}&prerefer=${crypto.encodeURL(param.prerefer)}"/></c:if>
<c:if test="${page>0 && page<=totalPage}"><div class="grr_fsf"><a href="${requestURI}?sqq=${crypto.encodeURL(param.sqq)}&amp;refer=${crypto.encodeURL(param.refer)}&amp;prerefer=${crypto.encodeURL(param.prerefer)}<c:if test='${prepage!=0}'>&amp;prepage=${prepage}</c:if><c:if test='${((page-1)!=0)}'>&amp;page=${page-1}</c:if>">Newer Edited</a></div></c:if>
<c:forEach items="${comments}" var="data">
    <c:set var="attachment" value="${crypto.encrypt(data.picId)}"/>
    <c:set var="getTime" value="${CalTime.saveShortTime(data.timestampVal)}"/>
    <div class="fdger_ghfdfd">
        <div class="rtr_fdss">
            <div class="qwcd nhy">
                <a href="/info/<c:if test='${talkerInfo.getUserId()!=user}'>?sqq=${crypto.encodeURL(talkerUser)}</c:if>">

                    <c:choose>
                        <c:when test="${talkerPic!=null}">
                            <div class="wethj_gf">
                                <img src="/account/pic/show/a1/?sqq=${crypto.encodeURL(talkerPic)}" alt="img">
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
                <div class="gr_ds_dssd">${replyUser}</div><div class="ytr__hgfh">${CalTime.time}</div>
            </div>
            <div class="de_gh">
                <c:out value="${data.commentText}"/>
            </div>
            <c:if test="${attachment!=null}">
                <div class="de_gh">
                    <a href="/a/u/ff/rt/xz/cv/bc/full/?sqq=${crypto.encodeURL(attachment)}"><img src="/a/u/ff/rt/xz/cv/bc/a1/?sqq=${crypto.encodeURL(attachment)}" class="dfgf_hgf" alt="img"></a>
                </div>
            </c:if>
            <c:if test="${!data.edited}">
                <div class="de_gh ry_uyy">
                    <div class="fghfg_bv"></div>Original Version
                </div>
            </c:if>
        </div>
    </div>
</c:forEach>
<c:if test="${page<totalPage}"><div class="grr_fsf"><a href="${requestURI}?sqq=${crypto.encodeURL(param.sqq)}&amp;refer=${crypto.encodeURL(param.refer)}&amp;prerefer=${crypto.encodeURL(param.prerefer)}<c:if test='${prepage!=0}'>&amp;prepage=${prepage}</c:if>&amp;page=${page+1}">Older Edited</a></div></c:if>
