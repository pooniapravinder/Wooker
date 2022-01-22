package pages.controller.chat;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pages.controller.errors.Forbidden;
import pages.controller.errors.ResourceNotFoundException;
import user.attachments.save.GetAudios;
import user.attachments.save.GetImages;
import user.attachments.save.GetVideos;

@Controller
public class ShowMsgAttachments {

    @RequestMapping(value = "/jghg/urt/nmbn/rut/r/u/tyt/ghjhg/{option}/", method = RequestMethod.GET)
    public ResponseEntity<byte[]> ShowAttachmentImage(@PathVariable("option") String option, @RequestParam(value = "sqq", required = true) String imgid, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (!option.matches("^(a1|a2|a3|a4|full)$")) {
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
            case "a2":
                picSize = 100;
                break;
            case "a3":
                picSize = 150;
                break;
            case "a4":
                picSize = 200;
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

    @RequestMapping(value = "/jgjg/uyt/nmbnt/rutr/r/u/tyt/ghjhg/", method = RequestMethod.GET)
    public ResponseEntity<byte[]> ShowAttachmentVideo(@RequestParam(value = "sqq", required = true) String imgid, HttpServletRequest request, HttpServletResponse response) throws IOException {
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
        /*
         * GetImages getImages = new GetImages();
         * Gets images which are stored on the filesytem
         */
        GetVideos getVideos = new GetVideos();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("video/mp4"));
        return new ResponseEntity<>(getVideos.getVideo(userImgid), headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/iop/ght/lkl/uyuy/rhj/hu/tghyt/ghghjhg/", method = RequestMethod.GET)
    public ResponseEntity<byte[]> ShowAttachmentAudio(@RequestParam(value = "sqq", required = true) String imgid, HttpServletRequest request, HttpServletResponse response) throws IOException {
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
        /*
         * GetImages getImages = new GetImages();
         * Gets images which are stored on the filesytem
         */
        GetAudios getVideos = new GetAudios();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("audio/mp3"));
        return new ResponseEntity<>(getVideos.getAudio(userImgid), headers, HttpStatus.OK);
    }
}
