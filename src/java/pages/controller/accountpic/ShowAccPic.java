package pages.controller.accountpic;

import cookies.set.get.CheckSaveCookies;
import data.encryption.decryption.Cryptography;
import hibernate.mapping.Accountpics;
import hibernate.query.UserAccountPic;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pages.controller.errors.Forbidden;
import pages.controller.errors.ResourceNotFoundException;
import pages.controller.reactoper.ReactOperValidate;
import user.attachments.save.DefaultImages;
import user.attachments.save.GetImages;

@Controller
public class ShowAccPic {

    @RequestMapping(value = "/account/pic/show/{option}/", method = RequestMethod.GET)
    public ResponseEntity<byte[]> AccountPicView(@PathVariable("option") String option, @RequestParam(value = "sqq", required = true) String imgid, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (!option.matches("^(a1|a2|a3|a4|download)$")) {
            throw new ResourceNotFoundException();
        }
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            throw new Forbidden();
        }
        Cryptography decrypt = new Cryptography();
        String userImgid = decrypt.decrypt(imgid);
        if (userImgid == null) {
            throw new ResourceNotFoundException();
        }
        UserAccountPic get_image = new UserAccountPic();
        Accountpics get_imgid = get_image.AccountImg(userImgid);
        if (get_imgid == null) {
            throw new ResourceNotFoundException();
        }
        ReactOperValidate getAllowShowPic = new ReactOperValidate();
        boolean showPic = getAllowShowPic.privacyChecker(get_imgid.getUserId(), user, get_imgid.getPrivacy());
        int picSize = 0;
        switch (option) {
            case "a1":
                picSize = 50;
                break;
            case "a2":
                picSize = 75;
                break;
            case "a3":
                picSize = 100;
                break;
            case "a4":
                picSize = 200;
                break;
        }
        if (option.equals("download")) {
            if(!getAllowShowPic.privacyChecker(get_imgid.getUserId(), user, get_imgid.getPrivacy())){
                throw new Forbidden();
            }
            
        }
        
        if (!showPic) {
        /*
         * DefaultImages getImages = new DefaultImages();
         * Gets default account pic if privacy is set not to show original acc pic
         */
            DefaultImages getImages = new DefaultImages();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType("image/jpeg"));
            return new ResponseEntity<>(getImages.getThumbnail("user_avatar", picSize), headers, HttpStatus.OK);
        }
        /*
         * GetImages getImages = new GetImages();
         * Gets images which are stored on the filesytem
         */
        GetImages getImages = new GetImages();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("image/" + get_imgid.getPictype().replace("jpg","jpeg")));
        return new ResponseEntity<>(getImages.getThumbnail(userImgid, picSize), headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/account/pic/show/user/default/{option}/", method = RequestMethod.GET)
    public ResponseEntity<byte[]> AccountPicDefault(@PathVariable("option") String option, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (!option.matches("^(a1|a2|a3|a4)$")) {
            throw new ResourceNotFoundException();
        }
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            throw new Forbidden();
        }
        int picSize = 0;
        switch (option) {
            case "a1":
                picSize = 50;
                break;
            case "a2":
                picSize = 75;
                break;
            case "a3":
                picSize = 100;
                break;
            case "a4":
                picSize = 200;
                break;
        }
        /*
         * DefaultImages getImages = new DefaultImages();
         * Gets default account pic if privacy is set not to show original acc pic
         */
        DefaultImages getImages = new DefaultImages();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("image/jpeg"));
        return new ResponseEntity<>(getImages.getThumbnail("user_icon/user_avatar", picSize), headers, HttpStatus.OK);
    }
}
