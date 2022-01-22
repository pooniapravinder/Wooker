package pages.controller.wooks;

import cookies.set.get.CheckSaveCookies;
import data.encryption.decryption.Cryptography;
import java.io.IOException;
import java.util.regex.Pattern;
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
import user.attachments.save.DefaultImages;
import user.attachments.save.GetImages;

@Controller
public class WooksIcons {

    @RequestMapping(value = "/wooks/default/icons/er/vxvx/bgd/g/eret/{option}/", method = RequestMethod.GET)
    public ResponseEntity<byte[]> WooksIconsDefault(@PathVariable("option") String option, HttpServletRequest request, @RequestParam(value = "sqq", required = true) String getId, HttpServletResponse response) throws IOException {
        if (!option.matches("^(a1|a2|a3|a4)$")) {
            throw new ResourceNotFoundException();
        }
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            throw new Forbidden();
        }
        Cryptography crypto = new Cryptography();
        String id = crypto.decrypt(getId);
        Pattern idPattern = Pattern.compile("^(([0-9]){1,2})$");
        if ((id == null) || (!idPattern.matcher(id).matches())) {
            throw new ResourceNotFoundException();
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
        DefaultImages getImages = new DefaultImages();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("image/jpeg"));
        return new ResponseEntity<>(getImages.getThumbnail("wooks_icons/" + id, picSize), headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/wooks/ndefault/icons/er/vxvx/bgd/g/eret/{option}/", method = RequestMethod.GET)
    public ResponseEntity<byte[]> WooksIcons(@PathVariable("option") String option, HttpServletRequest request, @RequestParam(value = "sqq", required = true) String getId, HttpServletResponse response) throws IOException {
        if (!option.matches("^(a1|a2|a3|a4|a5|a6)$")) {
            throw new ResourceNotFoundException();
        }
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            throw new Forbidden();
        }
        Cryptography crypto = new Cryptography();
        String id = crypto.decrypt(getId);
        Pattern idPattern = Pattern.compile("^(([cp0-9_]){1,})$");
        if ((id == null) || (!idPattern.matcher(id).matches())) {
            throw new ResourceNotFoundException();
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
            case "a5":
                picSize = 300;
                break;
            case "a6":
                picSize = 400;
                break;
        }
        GetImages getImages = new GetImages();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("image/jpeg"));
        return new ResponseEntity<>(getImages.getThumbnail(id, picSize), headers, HttpStatus.OK);
    }
    
}
