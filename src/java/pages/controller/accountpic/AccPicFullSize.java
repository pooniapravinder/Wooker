package pages.controller.accountpic;

import cookies.set.get.CheckSaveCookies;
import data.encryption.decryption.Cryptography;
import hibernate.mapping.Accountpics;
import hibernate.mapping.Userchatlist;
import hibernate.query.UserAccountPic;
import hibernate.query.chat.UserRelationActions;
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
import user.attachments.save.GetImages;

@Controller
public class AccPicFullSize {

    @RequestMapping(value = "/account/pic/full/{option}/", method = RequestMethod.GET)
    public ResponseEntity<byte[]> AccPicFullSizeView(@PathVariable("option") String option, @RequestParam(value = "sqq", required = true) String imgid, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (!option.matches("^(size|download)$")) {
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
        boolean allowAction = getAllowShowPic.privacyChecker(get_imgid.getUserId(), user, get_imgid.getDownload());
        if (!allowAction) {
            throw new Forbidden();
        }
        
        /*
         * GetImages getImages = new GetImages();
         * Gets images which are stored on the filesytem
        */
        GetImages getImages = new GetImages();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("image/" + get_imgid.getPictype()));
        if (option.equals("download")) {
            String filename = get_imgid.getOrigName();
            headers.setContentDispositionFormData(filename, filename);
        }
        return new ResponseEntity<>(getImages.getFullSize(userImgid), headers, HttpStatus.OK);
    }

}
