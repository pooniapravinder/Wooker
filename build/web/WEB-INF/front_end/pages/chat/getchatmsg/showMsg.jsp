<div class="bubble <c:choose><c:when test='${read&&(sender==user)}'>me</c:when><c:when test='${(sender==user)}'>me_un</c:when><c:otherwise>you</c:otherwise></c:choose>">
    <a href="/user/send/message/action/info/?sqq=${crypto.encodeURL(msgId)}<c:if test='${pagination_backward!=null}'>&amp;pagination_backward=${crypto.encodeURL(param.pagination_backward)}</c:if><c:if test='${pagination_forward!=null}'>&amp;pagination_forward=${crypto.encodeURL(param.pagination_forward)}</c:if>&amp;refer=${requestURI.contains('starred') ? 'FgWoDj_heM-dNEK' : 'm-Ge_jdRmf-Frfs'}"><c:out value="${datas.userMessage}"/><c:if test="${(requestURI.contains('/user/send/message/'))&&(getSavedMsgs.isStarredMsg(crypto.decrypt(msgId),user))}"><div class="sd_asd">*</div></c:if></a>
    <c:choose>
        <c:when test="${datas.mediaType.contains('image')}">
            <div style="display:block;height:50px;width:50px;">
                <a href="/jghg/urt/nmbn/rut/r/u/tyt/ghjhg/full/?sqq=${crypto.encodeURL(crypto.encrypt(datas.mediaId))}"><img src="/jghg/urt/nmbn/rut/r/u/tyt/ghjhg/a1/?sqq=${crypto.encodeURL(crypto.encrypt(datas.mediaId))}" alt="img"></a>
            </div>
        </c:when>
        <c:when test="${datas.mediaType.contains('video')}">
            <div>
                <video width="180" height="100" controls src="/jgjg/uyt/nmbnt/rutr/r/u/tyt/ghjhg/?sqq=${crypto.encodeURL(crypto.encrypt(datas.mediaId))}">
                    Your browser does not support the video tag.
                </video>
            </div>
        </c:when>
        <c:when test="${datas.mediaType.contains('audio')}">
            <div>
                <audio controls src="/iop/ght/lkl/uyuy/rhj/hu/tghyt/ghghjhg/?sqq=${crypto.encodeURL(crypto.encrypt(datas.mediaId))}">
                    Your browser does not support the audio tag.
                </audio>
            </div>
        </c:when>
    </c:choose>
            <c:if test="${datas.userMessage.isEmpty()}">
                            <div style="display:block;float:right;">
                                <a href="/user/send/message/action/info/?sqq=${crypto.encodeURL(msgId)}<c:if test='${pagination_backward!=null}'>&amp;pagination_backward=${crypto.encodeURL(param.pagination_backward)}</c:if><c:if test='${pagination_forward!=null}'>&amp;pagination_forward=${crypto.encodeURL(param.pagination_forward)}</c:if>&amp;refer=${requestURI.contains('starred') ? 'FgWoDj_heM-dNEK' : 'm-Ge_jdRmf-Frfs'}">Info</a>
                            </div>
                        </c:if>
</div>
