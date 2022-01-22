package pages.controller.activities;

import cookies.set.get.CheckSaveCookies;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserActivities {

    @RequestMapping(value = "/activities/", method = RequestMethod.GET)
    public String ActivitiesPageview(HttpServletRequest request,HttpServletResponse response){
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request,response);
        if(user==0) return "redirect:../../login/";
        return "loginactivities";
    }

    @RequestMapping(value = "/activities/login/", method = RequestMethod.GET)
    public String LoginActivitiesPage(HttpServletRequest request,HttpServletResponse response){
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request,response);
        if(user==0) return "redirect:../../login/";
        return "loginactivities";
    }

}
