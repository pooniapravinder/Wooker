package pages.controller.wooks;

import cookies.set.get.CheckSaveCookies;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WooksHandler {

    @RequestMapping(value = "/wooks/", method = RequestMethod.GET)
    public String WooksHandlerview(Searchwook search, HttpServletRequest request,HttpServletResponse response){
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request,response);
        if(user==0) return "redirect:../login/";
        return "wooks/wooks";
    }

}
