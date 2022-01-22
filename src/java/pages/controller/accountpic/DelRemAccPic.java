package pages.controller.accountpic;

import cookies.set.get.CheckSaveCookies;
import data.encryption.decryption.Cryptography;
import hibernate.query.UserAccountPic;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pages.controller.errors.ResourceNotFoundException;

@Controller
public class DelRemAccPic {

    @RequestMapping(value = "/account/pic/{option}/", method = RequestMethod.GET)
    public String DelRemAccPicAction(@PathVariable("option") String option, @RequestParam(value = "sqq", required = false) String imgid, @RequestParam(value = "page", required = false) String pageid, HttpServletRequest request, HttpServletResponse response) {
        if (!option.matches("^(remove|delete)$")) {
            throw new ResourceNotFoundException();
        }
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../../login/";
        }
        int page = (pageid != null) && (pageid.matches("^(?:[0-9]){1,11}$")) ? Integer.parseInt(pageid) : 0;
        Cryptography decrypt = new Cryptography();
        String Imgid = null;
        if (imgid != null) {
            Imgid = decrypt.decrypt(imgid);
        }
        if (Imgid == null) {
            return "redirect:../../../home/";
        }
        UserAccountPic get_image = new UserAccountPic();
        boolean get_imgid = get_image.AccountImg(Imgid) != null;
        if ((get_imgid) && ("remove".equals(option))) {
            get_image.Remove(Imgid, user);
        }
        if ((get_imgid) && ("delete".equals(option))) {
            get_image.Delete(Imgid, user);
        }
        return "redirect:../../../account/pic/upload/new/?page=" + page;
    }

}
