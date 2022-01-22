package pages.controller.moreinfo;

import cookies.set.get.CheckSaveCookies;
import data.encryption.decryption.Cryptography;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pages.controller.errors.Forbidden;
import pages.controller.errors.ResourceNotFoundException;
import user.attachments.save.GetImages;

@Controller
public class ShowMoreInfoPic {

    @RequestMapping(value = "/more/info/pic/get/", method = RequestMethod.GET)
    public ResponseEntity<byte[]> ShowMoreInfoPicView(@RequestParam(value = "sqq", required = true) String imgid, HttpServletRequest request, HttpServletResponse response) throws IOException {
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            throw new Forbidden();
        }
        Cryptography decrypt = new Cryptography();
        String user_imgid = decrypt.decrypt(imgid);
        if (user_imgid == null) {
            throw new ResourceNotFoundException();
        }
        /*
         * GetImages getImages = new GetImages();
         * Gets images which are stored on the filesytem
        */
        GetImages getImages = new GetImages();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("image/jpeg"));
        return new ResponseEntity<>(getImages.getThumbnail(user_imgid, 100), headers, HttpStatus.OK);
    }
}
