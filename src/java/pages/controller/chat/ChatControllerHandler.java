package pages.controller.chat;

import cookies.set.get.CheckSaveCookies;
import data.encryption.decryption.Cryptography;
import hibernate.query.chat.ReadMessages;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChatControllerHandler {

    @RequestMapping(value = "/alerts/", method = RequestMethod.GET)
    public String AlertsHandler(Searchmsg search, @RequestParam(value = "pagination_forward", required = false) String forward, @RequestParam(value = "pagination_backward", required = false) String backward, HttpServletRequest request, HttpServletResponse response) {
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../login/";
        }
        Cryptography crypto = new Cryptography();
        if ((crypto.decrypt(forward) == null) && (crypto.decrypt(backward) == null)) {
        ReadMessages read = new ReadMessages();
        read.ReadAlertMsg(user);
        }
        return "chat/alerts";
    }

    @RequestMapping(value = "/alerts/sent/", method = RequestMethod.GET)
    public String AlertsSentHandler(Searchmsg search, @RequestParam(value = "pagination_forward", required = false) String forward, @RequestParam(value = "pagination_backward", required = false) String backward, HttpServletRequest request, HttpServletResponse response) {
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../login/";
        }
        Cryptography crypto = new Cryptography();
        if ((crypto.decrypt(forward) == null) && (crypto.decrypt(backward) == null)) {
        ReadMessages read = new ReadMessages();
        read.ReadAlertSentMsg(user);
        }
        return "chat/alertssent";
    }

    @RequestMapping(value = "/chat/", method = RequestMethod.GET)
    public String ChatHandler(Searchmsg search, @RequestParam(value = "pagination_forward", required = false) String forward, @RequestParam(value = "pagination_backward", required = false) String backward, HttpServletRequest request, HttpServletResponse response) {
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../login/";
        }
        Cryptography crypto = new Cryptography();
        if ((crypto.decrypt(forward) == null) && (crypto.decrypt(backward) == null)) {
        ReadMessages read = new ReadMessages();
        read.ReadChatMsg(user);
        }
        return "chat/chat";
    }

    @RequestMapping(value = "/starred/", method = RequestMethod.GET)
    public String StarredHandler(Searchmsg search, @RequestParam(value = "sqq", required = false) String getId, HttpServletRequest request, HttpServletResponse response) {
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../login/";
        }
        return "chat/starred";
    }

    @RequestMapping(value = "/spam/", method = RequestMethod.GET)
    public String SpamHandler(Searchmsg search, @RequestParam(value = "pagination_forward", required = false) String forward, @RequestParam(value = "pagination_backward", required = false) String backward, HttpServletRequest request, HttpServletResponse response) {
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../login/";
        }
        Cryptography crypto = new Cryptography();
        if ((crypto.decrypt(forward) == null) && (crypto.decrypt(backward) == null)) {
        ReadMessages read = new ReadMessages();
        read.ReadSpamMsg(user);
        }
        return "chat/spam";
    }

    @RequestMapping(value = "/removed/", method = RequestMethod.GET)
    public String RemovedHandler(Searchmsg search, HttpServletRequest request, HttpServletResponse response) {
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../login/";
        }
        return "chat/removed";
    }

    @RequestMapping(value = "/blocked/", method = RequestMethod.GET)
    public String BlockedHandler(Searchmsg search, HttpServletRequest request, HttpServletResponse response) {
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../login/";
        }
        return "chat/blocked";
    }

}
