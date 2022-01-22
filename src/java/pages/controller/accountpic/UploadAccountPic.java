package pages.controller.accountpic;

import cookies.set.get.CheckSaveCookies;
import hibernate.mapping.Accountpics;
import hibernate.query.UserAccountPic;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import user.attachments.save.SaveImages;

@Controller
public class UploadAccountPic {

    @Autowired
    AccPicValidation validation;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.setValidator(validation);
    }

    @RequestMapping(value = "/account/pic/upload/", method = RequestMethod.GET)
    public String UploadPicPageView(Accpicoper setModel, HttpServletRequest request, HttpServletResponse response) {
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        if (checkCookie.getCookie(request, response) == 0) return "redirect:../../../login/";
        setModel.setPrivacy("03");
        setModel.setDownload("02");
        return "accountpic";
    }

    @RequestMapping(value = "/account/pic/upload/", method = RequestMethod.POST)
    public String UploadPicPageSubmit(@Valid Accpicoper userInput, BindingResult results, HttpServletRequest request, HttpServletResponse response) throws IOException {
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) return "redirect:../../../login/";
        if (results.hasErrors()) return "accountpic";
        byte val2 = 2;
        byte privacy = (userInput.getPrivacy() != null) && (userInput.getPrivacy().matches("^(0[1-6])$")) ? Byte.parseByte(userInput.getPrivacy()) : 3;
        byte download = (userInput.getDownload() != null) && (userInput.getDownload().matches("^(0[1-6])$")) ? Byte.parseByte(userInput.getDownload()) : 2;
        UserAccountPic savePic = new UserAccountPic();
        long current_timestamp = System.currentTimeMillis();
        String deviceId = checkCookie.getDevice(request.getCookies());
        SaveImages saveImage = new SaveImages();
        Accountpics insertPic = new Accountpics(user, current_timestamp + "_" + user, deviceId, userInput.getImg().getOriginalFilename(), current_timestamp, current_timestamp, true, false, userInput.getImg().getContentType().replace("image/", ""), userInput.getImg().getSize(), privacy, download, val2, val2, val2, val2, val2, val2, val2, val2, true, true, false, false, false, true, true, true, true, true, true, true, true, true, true);
        saveImage.SaveImage(userInput.getImg(), current_timestamp + "_" + user);
        savePic.SavePic(insertPic);
        return "redirect:../../../home/";
    }

}
