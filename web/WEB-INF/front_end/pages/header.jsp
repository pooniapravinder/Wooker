<jsp:useBean id="CurrentUser" class="pages.controller.home.CurrentUser"/>
<c:set var="user" value="${CurrentUser.getUserId()}"/>
<jsp:useBean id="getImage" class="hibernate.query.UserAccountPic"/>
<jsp:useBean id="crypto" class="data.encryption.decryption.Cryptography"/>
<jsp:useBean id="getUserData" class="hibernate.query.info.InfoAction"/>
<jsp:useBean id="getCountNotify" class="hibernate.query.chat.CountNotify"/>
<jsp:useBean id="now" class="java.util.Date" />
<c:set var="userDetails" value="${getUserData.getPriInfo(user)}"/>
<c:set var="alertNotify" value="${getCountNotify.countAlertMessage(user)}"/>
<c:set var="chatNotify" value="${getCountNotify.countChatMessage(user)}"/>
<c:set var="spamNotify" value="${getCountNotify.countSpamMessage(user)}"/>
<c:set var="sqq" value="${crypto.encrypt(getImage.getAccountPic(user).getPicId())}"/>
<div class="wooker-header content clearfix">
    <div class="float-header-left">
        <div class="ak__pic">
            <div class="header-item ll_img">
                <c:choose>
                    <c:when test="${sqq!=null}">
                        <a href="/account/pic/edit/?sqq=${crypto.encodeURL(sqq)}">
                            <div class="image">
                                <img src="/account/pic/show/a1/?sqq=${crypto.encodeURL(sqq)}">
                            </div>
                        </a>
                    </c:when>
                    <c:otherwise>
                        <div class="image">
                            <img src="/account/pic/show/user/default/a1/">
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
        <a href="/home/">Home</a>
        <a href="/notifications/">Notifications</a>
        <a href="/wooks/">Wooks</a>
        <a href="/alerts/">Alerts<c:if test="${alertNotify>0}"> (${alertNotify})</c:if></a>
        <a href="/user/list/chat/">Chatlist</a>
        <a href="/online/">Online</a>
        <a href="/celebrities/">Celebrities</a>
        <a href="/info/">Info</a>
        <a href="/activities/">Activities</a>
        <a href="/settings/">Settings</a>         
    </div>
    <div class="float-header-right">
        <a href="/logout/?logout_id=${CurrentUser.getLogoutValue()}">LogOut</a>
        <a href="/store/">Store</a>
        <a href="/security/">Security</a>
        <a href="/adworld/">AdWorld</a>
        <a href="/shopping/">Shopping</a>
        <a href="/shopping/">Payments</a>
    </div>
</div>

<div class="sidebar sidebar-animate-left" id="sidebar">
    <a href="/create/group/">Create Group</a>
    <a href="/chat/">Chat<c:if test="${chatNotify>0}"><div style="display: inline-block;margin-left: 5px;color: #663399;">(${chatNotify})</div></c:if></a>
    <a href="/groups/">Groups</a>
    <a href="/starred/">Starred</a>
    <a href="/spam/">Spam<c:if test="${spamNotify>0}"><div style="display: inline-block;margin-left: 5px;color: #663399;">(${spamNotify})</div></c:if></a>
    <a href="/removed/">Removed</a>
    <a href="/blocked/">Blocked</a>
    <div class="sidebar_end"></div>
    <fmt:formatDate var="currentYear" value="${now}" pattern="yyyy" />
    <div class="wooker-copyright" id="sidebar_close">Wooker &copy;${currentYear}</div>
</div>
<div class="sidebar-overlay sidebar-animate-opacity" id="sidebarOverlay"></div>