<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%><%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%><%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@taglib uri="http://www.springframework.org/tags" prefix="spring"%><%@page contentType="text/html" pageEncoding="UTF-8"%><%@page session="false"%><!DOCTYPE html>
<html lang="en-US" id="wooker"><c:set var="requestURI" value="${requestScope['javax.servlet.forward.request_uri']}"/>
    <head>
        <jsp:useBean id="getCrypto" class="data.encryption.decryption.Cryptography"/>

        <meta name="keywords" content="Wooks at Wooker">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
        <meta name="theme-color" content="#663399">
        <link rel="shortcut icon" href="//www.google.com/favicon.ico"/>
        <meta name="description" content="Explore the Account Pics Wook">
        <meta name="google" content="notranslate">
        <jsp:useBean id="getWooks" class="hibernate.query.wooks.WookQuery"/>
        <c:set var="wook" value="${getWooks.getWook(getCrypto.decrypt(param.sqq))}"/>
        <title>${wook.title}</title>
        <link rel="stylesheet" type="text/css" href="/rele/css/styleone.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/styletwo.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/fTeIngRrjRkrn.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/kuEopDjfRmEKf.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/IoDJnmdJdDE.css">
        <link rel="stylesheet" type="text/css" href="/rele/css/gfdgKdKEmEMcDD.css">
    </head>
    <body>
        <%@include file="../header.jsp"%>
        <div class="wrapper animate_in" id="wrapper">
            <div class="info_page main clearfix">
                <div style="background-image: url('/wooks/ndefault/icons/er/vxvx/bgd/g/eret/a6/?sqq=${crypto.encodeURL(crypto.encrypt(wook.coverPhoto))}');background-size: 100% 100%; height:200px;position: relative;">
                    <div class="_as_a">
                        <img src="/wooks/ndefault/icons/er/vxvx/bgd/g/eret/a4/?sqq=${crypto.encodeURL(crypto.encrypt(wook.photo))}" class="_img__syt">
                    </div>
                </div>
                    <div class="content">
                <div class="upper_options">
                    <a href="">Overview</a><div style="float: right;"><a href="" class="upper_options_a">Edit</a><a href="">Delete</a></div>
                </div>
                <h2 style="margin-top:-20px;">${wook.title}</h2>


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
                        <c:set var="disabled" value="false"/><c:if test="${!wook.text}"><c:set var="disabled" value="true"/></c:if>
                        <form:form method="post" name="makePost" modelAttribute="makePost" action="${requestURI}post/?sqq=${crypto.encodeURL(param.sqq)}" enctype="multipart/form-data">
                            <div class="dfhf_sd_hg">
                                <form:textarea path="textData" id="hfgh_hfhf" class="frrt_zxfsr" placeholder="...." autocorrect="off" autocomplete="off" spellcheck="false" disabled="${disabled}"/>
                                <span class="focus-border"></span>
                            </div>
                            <div class="gtrev_gfg yr_yu">
                                <div class="dfgfd_ghf">
                                    <c:if test="${wook.image}"><c:set var="allowImage" value="image/*,"/></c:if>
                                    <c:if test="${wook.audio}"><c:set var="allowAudio" value="audio/*,"/></c:if>
                                    <c:if test="${wook.video}"><c:set var="allowVideo" value="video/*,"/></c:if>
                                    <c:if test="${(wook.image)||(wook.audio)||(wook.video)||(wook.file)}">
                                        <div class="hfgty5_gfd yyngtr">
                                            <div class="hh__u gr__yut" id="_dsf_as">
                                                <svg width="100%" height="100%" viewBox="0 0 24 24"><circle cx="12" cy="12" r="3.2"></circle><path d="M9 2L7.17 4H4c-1.1 0-2 .9-2 2v12c0 1.1.9 2 2 2h16c1.1 0 2-.9 2-2V6c0-1.1-.9-2-2-2h-3.17L15 2H9zm3 15c-2.76 0-5-2.24-5-5s2.24-5 5-5 5 2.24 5 5-2.24 5-5 5z"></path></svg>
                                                <form:input path="attachment" id="attachment" type="file" accept="${allowImage}${allowAudio}${allowVideo}" autocorrect="off" autocomplete="off" spellcheck="false"/>
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
                                    </c:if>
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
                                </div>
                                <form:button name="post" id="post" class="form_send_button" value="submit">Post</form:button>
                                </div>
                        </form:form>
                    </div>
                </div>
            </div></div>
                        
                        
                        <jsp:useBean id="getPosts" class="hibernate.query.post.PostQuery"/>
            <jsp:useBean id="CalTime" class="timeperiod.duration.calculation.CalculateTime"/>
            <c:choose>
                <c:when test="${(crypto.decrypt(param.pagination_backward))!=null}">
                    <c:set var="pagination_backward" value="${crypto.decrypt(param.pagination_backward)}"/>
                    <c:set var="posts" value="${getPosts.Posts(getCrypto.decrypt(param.sqq),pagination_backward,false)}"/>
                </c:when>
                <c:when test="${(crypto.decrypt(param.pagination_forward))!=null}">
                    <c:set var="pagination_forward" value="${crypto.decrypt(param.pagination_forward)}"/>
                    <c:set var="posts" value="${getPosts.Posts(getCrypto.decrypt(param.sqq),pagination_forward,true)}"/>
                </c:when>
                <c:otherwise>
                    <c:set var="posts" value="${getPosts.firstPagePosts(getCrypto.decrypt(param.sqq))}"/>
                </c:otherwise>
            </c:choose>
            <c:set var="totalData" value="${fn:length(posts)}"/>
            <c:forEach var="i" begin="${pagination_forward!=null ? 1 : (totalData==0 ? 1 : 0)}" end="${pagination_forward!=null ? totalData : (totalData>0 ? totalData-1 : totalData)}" step="1">
                <c:set var="data" value="${pagination_forward!=null ? posts[totalData-i] : posts[i]}"/>
                <c:if test="${i==(pagination_forward!=null ? 1 : 0)}"><c:set var="firstPostId" value="${data.autoId}"/></c:if>
                <c:if test="${i==(pagination_forward!=null ? totalData : totalData-1)}"><c:set var="lastPostId" value="${data.autoId}"/></c:if>
                <c:if test="${i==(pagination_forward!=null ? 1 : 0)}">
                    <c:if test="${getPosts.isPagination(getCrypto.decrypt(param.sqq),firstPostId,true)}"><div class="do_pagination"><a href="${requestURI}?sqq=${param.sqq}&amp;pagination_forward=${crypto.encodeURL(crypto.encrypt(firstPostId))}">Newer</a></div></c:if>
                </c:if>
                    <div class="nj_k_gap"></div>
                    <div class="main fddd_f fopi_o">
                    
                    
                <div style="background-image: url('/wooks/ndefault/icons/er/vxvx/bgd/g/eret/a6/?sqq=${crypto.encodeURL(crypto.encrypt(wook.coverPhoto))}');background-size: 100% 100%; height:200px;position: relative;margin-top:0;">
                </div>

                <div class="content">
                    <div class="post_text"><c:out value="${data.text}"/></div>
                    <div class="react_container">
                        <a href="">Like</a><a href="">Dislike</a><a href="">Talking</a><a href="">Comment</a><a href="">Share</a>
                    </div>
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
                </div>
                    
                    </div>
            </c:forEach>
                    <div class="do_pagination">
            <c:if test="${getPosts.isPagination(getCrypto.decrypt(param.sqq),lastPostId,false)}"><div class="def__o"><a href="${requestURI}?sqq=${param.sqq}&amp;pagination_backward=${crypto.encodeURL(crypto.encrypt(lastPostId))}">Older</a></div></c:if>
                    </div>
            
            
            
        </div>
                    <script>
            _g("hfgh_hfhf").addEventListener("focus", function () {
                _g("hfgh_hfhf").removeAttribute("placeholder");
            });
            _g("attachment").style.display = "none";
            _g("_dsf_as").addEventListener("click", function () {
                _g("attachment").click();
            });



            window.onload = function () {
                var _p = _s("post_text");
                if (_p.length > 0) {
                    for (var i = 0; i < _p.length; i++) {
                        if (_p[i].scrollHeight>parseInt((window.getComputedStyle(_p[0]).getPropertyValue('max-height')).replace('px', '')))
                            _add_more(_p[i]);
                    }
                }
            };

            function _add_more(x) {
                var a = document.createElement("span");
                a.setAttribute("class", "more_texts");
                x.appendChild(a);
                var b = document.createElement("span");
                b.setAttribute("class", "more_text");
                a.appendChild(b);
                a.onclick = function () {
                    var _e = a.parentNode;
                    if (_e.hasAttribute("style")) {
                        _e.removeAttribute("style");
                    } else {
                        _e.style.maxHeight = _e.scrollHeight + "px";
                    }
                };
            }

            function _g(a) {
                return window.document.getElementById(a);
            }

            function _s(c) {
                return window.document.getElementsByClassName(c);
            }


        </script>
    </body>
</html>
