<div class="fdger_ghfdfd">
    <div class="rtr_fdss">
        <div class="qwcd nhy">
            <a href="/info/">
                <c:choose>
                    <c:when test="${sqq!=null}">
                        <div class="wethj_gf">
                            <img src="/account/pic/show/a1/?sqq=${crypto.encodeURL(sqq)}" alt="img">
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
    <div class="tty_da_das">
        <c:if test="${prepage!=0}"><c:set var="prePageVal" value="&prepage=${prepage}"/></c:if>
        <form:form method="post" name="edit" modelAttribute="edit" action="${requestURI}?sqq=${crypto.encodeURL(param.sqq)}&refer=${crypto.encodeURL(param.refer)}&prerefer=${crypto.encodeURL(param.prerefer)}${prePageVal}" enctype="multipart/form-data">
            <div class="dfhf_sd_hg">
                <textarea id="hfgh_hfhf" name="talking" autocorrect="off" autocomplete="off" spellcheck="false" class="frrt_zxfsr"><c:out value="${userSqq.talkingText}"/></textarea>
                <span class="focus-border"></span>
            </div>
            <c:if test="${attachmentCurr!=null}">
                <form:label path="remAttachment" class="contain_checkbox"><form:checkbox path="remAttachment" id="remAttachment" value="true"/><span class="custom_checkbox"></span>Remove previous attachment</form:label>
            </c:if>
            <div class="gtrev_gfg yr_yu">
                <div class="hfgty5_gfd yyngtr">
                    <div class="hh__u gr__yut" id="_dsf_as">
                        <svg width="100%" height="100%" viewBox="0 0 24 24"><circle cx="12" cy="12" r="3.2"></circle><path d="M9 2L7.17 4H4c-1.1 0-2 .9-2 2v12c0 1.1.9 2 2 2h16c1.1 0 2-.9 2-2V6c0-1.1-.9-2-2-2h-3.17L15 2H9zm3 15c-2.76 0-5-2.24-5-5s2.24-5 5-5 5 2.24 5 5-2.24 5-5 5z"></path></svg>
                        <form:input path="attachment" id="attachment" type="file" accept="image/*" autocorrect="off" autocomplete="off" spellcheck="false"/>
                        <span class="dfsf_gd">Upload New</span>
                    </div>
                </div>
                <form:hidden path="prePic" id="prePic" autocorrect="off" autocomplete="off" spellcheck="false"/>
                <div class="hfgty5_gfd fhyfgh">
                    <div class="hh__u gr__yut">
                        <svg width="100%" height="100%" viewBox="0 0 24 24"><circle cx="12" cy="12" r="3.2"></circle><path d="M9 2L7.17 4H4c-1.1 0-2 .9-2 2v12c0 1.1.9 2 2 2h16c1.1 0 2-.9 2-2V6c0-1.1-.9-2-2-2h-3.17L15 2H9zm3 15c-2.76 0-5-2.24-5-5s2.24-5 5-5 5 2.24 5 5-2.24 5-5 5z"></path></svg>
                        <span class="dfsf_gd">Pick Previous</span>
                    </div>
                </div>
                <div class="hfgty5_gfd fhyfgh">
                    <div class="_gfh_fd dfg_vx">
                        <svg viewBox="0 0 20 19"><path d="M9 0a9 9 0 1 1 0 18A9 9 0 0 1 9 0zm0 1C4.589 1 1 4.589 1 9s3.589 8 8 8 8-3.589 8-8-3.589-8-8-8zM5 6.999a1 1 0 1 1 2.002.004A1 1 0 0 1 5 6.999zm5.999 0a1.002 1.002 0 0 1 2.001 0 1 1 0 1 1-2.001 0zM8.959 13.5c-.086 0-.173-.002-.26-.007-2.44-.132-4.024-2.099-4.09-2.182l-.31-.392.781-.62.312.39c.014.017 1.382 1.703 3.37 1.806 1.306.072 2.61-.554 3.882-1.846l.351-.356.712.702-.35.356c-1.407 1.427-2.886 2.15-4.398 2.15z" fill-rule="evenodd"></path></svg>
                        <span class="dfsf_gd">Choose Emoji</span>
                    </div>
                </div>
                <div class="rtee_fgfd fhyfgh">
                    <div class="fgfd_ggf fgh_fgfd">
                        <svg viewBox="0 0 29 20"><path d="M9 1a8 8 0 1 0 0 16h11a8 8 0 1 0 0-16H9zm0-1h11a9 9 0 0 1 0 18H9A9 9 0 0 1 9 0z" fill-rule="nonzero"></path><path d="M6.561 9.337c0-2.277 1.683-3.795 3.773-3.795 1.298 0 2.2.572 2.849 1.375l-.726.451c-.462-.594-1.243-1.012-2.123-1.012-1.606 0-2.827 1.232-2.827 2.981 0 1.738 1.221 2.992 2.827 2.992.88 0 1.606-.429 1.969-.792v-1.496H9.784v-.814h3.432v2.651a3.822 3.822 0 0 1-2.882 1.265c-2.09 0-3.773-1.529-3.773-3.806zM14.701 13V5.663h.913V13h-.913zm2.629 0V5.663h4.807v.814h-3.894v2.365h3.817v.814h-3.817V13h-.913z"></path></svg>
                        <span class="ttt_hfh">Choose GIF</span>
                    </div>
                </div>
                <form:button name="update" id="update" class="form_talk_button" value="submit">Update</form:button>
            </div>
        </form:form>
    </div>
</div>