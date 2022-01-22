package pages.controller.accountpic;

import cookies.set.get.CheckSaveCookies;
import data.encryption.decryption.Cryptography;
import hibernate.mapping.Accountpics;
import hibernate.mapping.Userchatlist;
import hibernate.query.UserAccountPic;
import hibernate.query.chat.UserRelationActions;
import hibernate.query.reactoper.ReactOper;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccPicOptions {

    @RequestMapping(value = "/user/account/pics/options/", method = RequestMethod.GET)
    public String UploadPicPageview(@RequestParam(value = "sqq", required = false) String imgid, HttpServletRequest request, HttpServletResponse response) {
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../../../login/";
        }
        String user_imgid = null;
        long user_two = 0;
        ReactOper getResult = new ReactOper();
        if ((imgid != null)) {
            Cryptography decrypt = new Cryptography();
            user_imgid = decrypt.decrypt(imgid);
        }
        if ((user_imgid != null) && (user_two != 0)) {
            UserAccountPic get_image = new UserAccountPic();
            Accountpics get_imgid = get_image.AccountImg(user_imgid);
            if (get_imgid == null) {
                return "redirect:../../../../home/";
            }
            Userchatlist getChatlist = getResult.getChatlistPrivacy(user, get_imgid.getUserId());
            boolean blocked = getChatlist != null ? getChatlist.isBlocked() : false;
            if (!blocked) {
                return "accpicoptions";
            }
        }
        return "redirect:../../../../home/";
    }

}
