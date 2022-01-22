package pages.controller.wooks;

import cookies.set.get.CheckSaveCookies;
import data.encryption.decryption.Cryptography;
import hibernate.query.wooks.WookQuery;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pages.controller.errors.ResourceNotFoundException;

@Controller
public class ExploreWooks {

    @RequestMapping(value = "/wooks/explore/post/account/pics/", method = RequestMethod.GET)
    public String ExplAccountPicWooksview(HttpServletRequest request, HttpServletResponse response) {
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../../../../login/";
        }
        return "wooks/accountpics";
    }

    @RequestMapping(value = "/wooks/explore/data/m/u/ab/sh/asgr/", method = RequestMethod.GET)
    public String ExploreWooksview(@RequestParam(value = "sqq", required = true) String getId, MakePost makePost, HttpServletRequest request, HttpServletResponse response) {
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../../../../../../../login/";
        }
        Cryptography crypto = new Cryptography();
        String id = crypto.decrypt(getId);
        Pattern pattern = Pattern.compile("^([0-9]){1,}$");
        if ((id == null) || (!pattern.matcher(id).matches())) {
            return "redirect:../../../../../../../../home/";
        }
        WookQuery getQuery = new WookQuery();
        if (getQuery.getWook(Long.valueOf(id)) == null) {
            throw new ResourceNotFoundException();
        }
        return "wooks/explorewook";
    }

}
