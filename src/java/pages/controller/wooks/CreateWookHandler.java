package pages.controller.wooks;

import cookies.set.get.CheckSaveCookies;
import hibernate.mapping.Wooks;
import hibernate.query.wooks.WookQuery;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import user.attachments.save.SaveImages;

@Controller
public class CreateWookHandler {

    @Autowired
    WookValidation validation;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.setValidator(validation);
    }

    @RequestMapping(value = "/create/wook/", method = RequestMethod.GET)
    public String CreateWookview(NewWook wook, HttpServletRequest request, HttpServletResponse response) {
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../login/";
        }
        return "wooks/createwook";
    }

    @RequestMapping(value = "/create/wook/", method = RequestMethod.POST)
    public String CreateWooksubmit(@Valid NewWook Input, BindingResult results, Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../login/";
        } else if (results.hasErrors()) {
            model.addAttribute("newWook", Input);
            return "wooks/createwook";
        }
        long current_timestamp = System.currentTimeMillis();
        String photo = null;
        String coverPhoto = null;
        SaveImages saveImage = new SaveImages();
        if ((Input.getPhoto() != null) && (!Input.getPhoto().isEmpty())) {
            photo = current_timestamp + "_" + user + "_" + "p";
            saveImage.SaveImage(Input.getPhoto(), photo);
        }
        if ((Input.getCoverPhoto() != null) && (!Input.getCoverPhoto().isEmpty())) {
            coverPhoto = current_timestamp + "_" + user + "_" + "c";
            saveImage.SaveImage(Input.getCoverPhoto(), coverPhoto);
        }
        byte privacy = (Input.getPrivacy() != null) && (Input.getPrivacy().matches("^([1-6])$")) ? Byte.parseByte(Input.getPrivacy()) : 3;
        byte publish = (Input.getWritePublish() != null) && (Input.getWritePublish().matches("^([1-6])$")) ? Byte.parseByte(Input.getWritePublish()) : 1;
        WookQuery query = new WookQuery();
        Wooks saveWook = new Wooks(user, checkCookie.getDevice(request.getCookies()), Input.getTitle(), Input.getType(), photo, coverPhoto, privacy, publish, Input.getText() != null, Input.getImage() != null, Input.getAudio() != null, Input.getVideo() != null, Input.getFile() != null, current_timestamp);
        query.insertWook(saveWook);
        return "redirect:../../wooks/";
    }
}
