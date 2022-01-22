package pages.controller.home;

import cookies.set.get.CheckSaveCookies;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pages.controller.search.Searchuser;

@Controller
public class HomeHandler {

    @RequestMapping(value = "/home/", method = RequestMethod.GET)
    public String HomePage(Searchuser searchuser, HttpServletRequest request, HttpServletResponse response) {
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../login/";
        }
        return "home";
    }

}
