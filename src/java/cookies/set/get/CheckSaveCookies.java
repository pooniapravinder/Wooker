package cookies.set.get;

import Random.String.Generator.RandomString;
import hibernate.mapping.Accounts;
import hibernate.mapping.Validlogin;
import hibernate.query.GetUser;
import hibernate.query.LoginToUser;
import hibernate.query.OnlineUser;
import hibernate.query.VerifyCookies;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pages.controller.home.CurrentUser;

public class CheckSaveCookies {

    public long getCookie(HttpServletRequest request, HttpServletResponse response) {
        return checkCookie(false, request, response);
    }

    public long getVerifyCookie(HttpServletRequest request, HttpServletResponse response) {
        return checkCookie(true, request, response);
    }

    public long checkCookie(boolean forVerify, HttpServletRequest request, HttpServletResponse response) {
        long user_id = 0;
        CurrentUser.setUserId(0);
        CurrentUser.setLogoutValue(null);
        String cookie_match = "^([a-zA-Z0-9+/=]+)$";
        String qwed = null;
        String xcut = null;
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return user_id;
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("qwed")) {
                qwed = cookie.getValue();
            }
            if (cookie.getName().equals("xcut")) {
                xcut = cookie.getValue();
            }
        }
        if ((qwed == null) || (xcut == null) || (!qwed.matches(cookie_match)) || (!xcut.matches(cookie_match))) {
            return user_id;
        }
        long current_timestamp = System.currentTimeMillis();
        VerifyCookies getCookies = new VerifyCookies();
        Validlogin getDetails = getCookies.findCookies(current_timestamp - (1000L * 60L * 60L * 24L * 61L), qwed, xcut);
        if (getDetails == null) {
            return user_id;
        }
        GetUser GetData = new GetUser();
        Accounts UserDetails = GetData.getUserbyId(getDetails.getUserId());
        if (getDetails.isIsLogout()) {
            return user_id;
        }
        CurrentUser.setUserId(getDetails.getUserId());
        CurrentUser.setLogoutValue(getDetails.getLogoutKey());
        String browserAgent = request.getHeader("User-Agent");
        String ip_addr = request.getRemoteAddr();
        CookieEncryptorDecryptor.setKey(getDetails.getLoginPassword());
        CookieEncryptorDecryptor.encrypt((browserAgent + getDetails.getUserId() + UserDetails.getEmailidPhone()).trim());
        String login_qwed = CookieEncryptorDecryptor.getEncryptedString();
        CookieEncryptorDecryptor.encrypt((getDetails.getLoginTimestamp() + ip_addr).trim());
        String login_xcut = CookieEncryptorDecryptor.getEncryptedString();
        if ((login_qwed == null) || (login_xcut == null) || (!login_qwed.equals(qwed)) || (!login_xcut.equals(xcut))) {
            for (Cookie cookie : request.getCookies()) {
                cookie.setValue("");
                cookie.setMaxAge(0);
                cookie.setPath("/");
                response.addCookie(cookie);
            }
            return user_id;
        }
        user_id = !forVerify ? UserDetails.isVerifiedAccount() ? getDetails.getUserId() : 0 : !UserDetails.isVerifiedAccount() ? getDetails.getUserId() : 0;
        if(UserDetails.isVerifiedAccount()){
            OnlineUser updateOnline = new OnlineUser();
            updateOnline.UpdateOnline(user_id);
        }
        return user_id;
    }

    public void setCookie(HttpServletResponse response, HttpServletRequest request, long id, String emailPhone, String device_id, String ClientIp) {
        long current_timestamp = System.currentTimeMillis();
        RandomString get_random = new RandomString();
        String loginPass = get_random.generateRandomAlphaNumeric(190);
        String logoutKey = get_random.generateRandomAlphaNumeric(450);
        CookieEncryptorDecryptor.setKey(loginPass);
        CookieEncryptorDecryptor.encrypt((request.getHeader("User-Agent") + id + emailPhone).trim());
        String qwed = CookieEncryptorDecryptor.getEncryptedString();
        CookieEncryptorDecryptor.encrypt((current_timestamp + ClientIp).trim());
        String xcut = CookieEncryptorDecryptor.getEncryptedString();
        if ((qwed.length() < 1020) && (xcut.length() < 255)) {
            if (device_id != null) {
                LoginToUser addloginuser = new LoginToUser();
                Validlogin set_data = new Validlogin(device_id, id, current_timestamp, false, logoutKey, loginPass, qwed, xcut);
                addloginuser.addLoginAccount(set_data);
            }
            Cookie set_login_cookie_qwed = new Cookie("qwed", qwed);
            set_login_cookie_qwed.setPath("/");
            set_login_cookie_qwed.setMaxAge(60 * 60 * 24 * 61);
            response.addCookie(set_login_cookie_qwed);
            Cookie set_login_cookie_xcut = new Cookie("xcut", xcut);
            set_login_cookie_xcut.setPath("/");
            set_login_cookie_xcut.setMaxAge(60 * 60 * 24 * 61);
            response.addCookie(set_login_cookie_xcut);
        }
    }

    public String getDevice(Cookie cookieVal[]) {
        String qwed = null;
        String xcut = null;
        for (Cookie cookie : cookieVal) {
            if (cookie.getName().equals("qwed")) {
                qwed = cookie.getValue();
            }
            if (cookie.getName().equals("xcut")) {
                xcut = cookie.getValue();
            }
        }
        VerifyCookies getCookies = new VerifyCookies();
        return getCookies.findCookies(0, qwed, xcut).getDeviceId();
    }

    public String getLocale(String postLocale, Cookie cookieVal[]) {
        if (postLocale != null) {
            return postLocale;
        }
        if (cookieVal == null) {
            return "en_us";
        }
        String locale = null;
        for (Cookie cookie : cookieVal) {
            if (cookie.getName().equals("locale")) {
                locale = cookie.getValue().toLowerCase();
            }
        }
        return locale;
    }

}
