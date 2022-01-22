package pages.controller.logout;

import cookies.set.get.CheckSaveCookies;
import hibernate.query.VerifyCookies;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Logout{

    @RequestMapping(value="/logout/", method = RequestMethod.GET)
    public String LogoutUser(@RequestParam(value="logout_id",required=true) String logoutId,HttpServletRequest request,HttpServletResponse response){
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        if((checkCookie.getCookie(request,response)!=0)||(checkCookie.getVerifyCookie(request,response)!=0)){
            String deviceId = checkCookie.getDevice(request.getCookies());
            VerifyCookies Logout = new VerifyCookies();
            Logout.LogoutUser(logoutId,deviceId);
        }
        return "redirect:../login/";
    }
}
