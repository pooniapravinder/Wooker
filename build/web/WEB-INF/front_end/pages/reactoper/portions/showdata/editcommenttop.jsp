<c:set var="isDisabled" value="${blockedUser.isDisabled(crypto.decrypt(param.sqq))}"/>
<c:set var="attachmentCurr" value="${crypto.encrypt(userSqq.picId)}"/>
<c:set var="accpicoper" value="${getImage.AccountImg(userSqq.targetId)}"/>
<c:set var="talkerPic" value="${crypto.encrypt(getImage.getAccountPic(userSqq.userOne).getPicId())}"/>
<c:set var="talkerInfo" value="${getUserData.getPriInfo(userSqq.selfUser ? userSqq.userTwo : userSqq.userOne)}"/>
<c:set var="talkerUser" value="${crypto.encrypt(talkerInfo.userId)}"/>
<c:set var="replyUser" value="${talkerInfo.firstName} ${talkerInfo.lastName}"/>
<div class="fdger_ghfdfd">
                    <div class="rtr_fdss">
                        <div class="gty ry__w">
                            <a href="/info/<c:if test='${talkerInfo.getUserId()!=user}'>?sqq=${crypto.encodeURL(talkerUser)}</c:if>">

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
                            <div class="gr_ds_dssd">${replyUser}</div>
                        </div>
                        <div class="de_gh">
                            <c:out value="${userSqq.commentText}"/>
                        </div>
                        <c:if test="${attachmentCurr!=null}">
                            <div class="de_gh">
                                <a href="/a/u/ff/rt/xz/cv/bc/full/?sqq=${crypto.encodeURL(attachment)}"><img src="/a/u/ff/rt/xz/cv/bc/a1/?sqq=${crypto.encodeURL(attachmentCurr)}" class="dfgf_hgf" alt="img"></a>
                            </div>
                        </c:if>
                        <div class="de_gh">
                            <jsp:useBean id="CalTime" class="timeperiod.duration.calculation.CalculateTime"/>
                            <c:set var="getTime" value="${CalTime.saveDateTime(userSqq.timestampComment)}"/>
                            <spring:message code="label.day.0${CalTime.day}"/> <c:if test="${CalTime.month<=9}"><spring:message code="label.month.0${CalTime.month}"/></c:if><c:if test="${CalTime.month>9}"><spring:message code="label.month.${CalTime.month}"/></c:if> ${CalTime.date},${CalTime.year} ${CalTime.time}
                            </div>
                            <div class="de_gh ry_uyy">
                                <div class="fghfg_bv"></div>Current Version
                            </div>
                        </div>
                    </div>