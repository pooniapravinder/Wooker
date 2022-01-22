package pages.controller.moreinfo;

import cookies.set.get.CheckSaveCookies;
import data.encryption.decryption.Cryptography;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MoreInfo {

    @RequestMapping(value = "/more/info/", method = RequestMethod.GET)
    public String MoreInfoPageview(@RequestParam(value = "sqq", required = false) String getId, HttpServletRequest request, HttpServletResponse response) {
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../login/";
        }
        Cryptography crypto = new Cryptography();
        String id = crypto.decrypt(getId);
        Pattern pattern = Pattern.compile("^([0-9]){1,}$");
        return ((id!=null)&&(pattern.matcher(id).matches())&&(Long.valueOf(id)!=user)) ? "otherusermoreinfo" : "moreinfo";
    }
}