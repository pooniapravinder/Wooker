
package pages.controller.forgotpassword;

import cookies.set.get.CheckSaveCookies;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ForgotPassword{

    @RequestMapping(value = "/forgot/password/", method = RequestMethod.GET)
    public String ForgotPasswordView() {
        return "forgotpassword";
    }

    @RequestMapping(value = "/forgot/password/", method = RequestMethod.POST)
    public String ForgotPasswordSubmit(HttpServletRequest request,HttpServletResponse response) {
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        if((checkCookie.getCookie(request,response))!=0) return "redirect:../home/";
        return "login";
    }

}
