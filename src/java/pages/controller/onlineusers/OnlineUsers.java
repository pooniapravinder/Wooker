package pages.controller.onlineusers;

import cookies.set.get.CheckSaveCookies;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OnlineUsers {

    @RequestMapping(value = "/online/", method = RequestMethod.GET)
    public String OnlineUsersView(HttpServletRequest request, HttpServletResponse response) {
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../login/";
        }
        return "online";
    }

}
