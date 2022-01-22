package pages.controller.reactoper;

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
import user.attachments.save.GetImages;

@Controller
public class ShowAttachments {
    
    @RequestMapping(value = "/a/u/ff/rt/xz/cv/bc/{option}/", method = RequestMethod.GET)
    public ResponseEntity<byte[]> ShowAttachments(@PathVariable("option") String option, @RequestParam(value = "sqq", required = true) String imgid, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (!option.matches("^(a1|full)$")) {
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
        int picSize = 0;
        switch (option) {
            case "a1":
                picSize = 50;
                break;
        }
        /*
         * GetImages getImages = new GetImages();
         * Gets images which are stored on the filesytem
        */
        GetImages getImages = new GetImages();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("image/jpeg"));
        return option.equals("full") ? new ResponseEntity<>(getImages.getFullSize(userImgid), headers, HttpStatus.OK) : new ResponseEntity<>(getImages.getThumbnail(userImgid, picSize), headers, HttpStatus.OK);
    }
}
