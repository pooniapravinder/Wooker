package pages.controller.accountpic;

import cookies.set.get.CheckSaveCookies;
import hibernate.mapping.Accountpics;
import hibernate.mapping.Showhideuplaccpic;
import hibernate.query.UserAccountPic;
import hibernate.query.info.ShowHideInfoOpt;
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
public class UploadNewAccountPic {

    @Autowired
    AccPicValidation validation;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.setValidator(validation);
    }

    @RequestMapping(value = "/account/pic/upload/new/", method = RequestMethod.GET)
    public String UploadPicPageView(Model model, HttpServletRequest request, HttpServletResponse response) {
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../../../login/";
        }
        ShowHideInfoOpt getData = new ShowHideInfoOpt();
        Showhideuplaccpic getOption = getData.getPicUplOptions(user);
        Accpicoper setModel = new Accpicoper(getOption);
        model.addAttribute("accpicoper", setModel);
        return "uploadnewaccpic";
    }

    @RequestMapping(value = "/account/pic/upload/new/", method = RequestMethod.POST)
    public String UploadPicPageSubmit(@Valid Accpicoper userInput, BindingResult results, HttpServletRequest request, HttpServletResponse response) throws IOException {
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../../../login/";
        }
        if (results.hasErrors()) {
            return "uploadnewaccpic";
        }
        String match = "^([1-6])$";
        byte privacy = (userInput.getPrivacy() != null) && (userInput.getPrivacy().matches(match)) ? Byte.parseByte(userInput.getPrivacy()) : 3;
        byte download = (userInput.getDownload() != null) && (userInput.getDownload().matches(match)) ? Byte.parseByte(userInput.getDownload()) : 2;
        byte doLiDis = (userInput.getDoLiDis() != null) && (userInput.getDoLiDis().matches(match)) ? Byte.parseByte(userInput.getDoLiDis()) : 2;
        byte seeLiDis = (userInput.getSeeLiDis() != null) && (userInput.getSeeLiDis().matches(match)) ? Byte.parseByte(userInput.getSeeLiDis()) : 2;
        byte doTalking = (userInput.getDoTalking() != null) && (userInput.getDoTalking().matches(match)) ? Byte.parseByte(userInput.getDoTalking()) : 2;
        byte seeTalking = (userInput.getSeeTalking() != null) && (userInput.getSeeTalking().matches(match)) ? Byte.parseByte(userInput.getSeeTalking()) : 2;
        byte doComment = (userInput.getDoComment() != null) && (userInput.getDoComment().matches(match)) ? Byte.parseByte(userInput.getDoComment()) : 2;
        byte seeComment = (userInput.getSeeComment() != null) && (userInput.getSeeComment().matches(match)) ? Byte.parseByte(userInput.getSeeComment()) : 2;
        byte doShare = (userInput.getDoShare() != null) && (userInput.getDoShare().matches(match)) ? Byte.parseByte(userInput.getDoShare()) : 2;
        byte seeShare = (userInput.getSeeShare() != null) && (userInput.getSeeShare().matches(match)) ? Byte.parseByte(userInput.getSeeShare()) : 2;
        boolean like = (userInput.getLike() != null) && (userInput.getLike().equals("true"));
        boolean dislike = (userInput.getDislike() != null) && (userInput.getDislike().equals("true"));
        boolean talking = (userInput.getTalking() != null) && (userInput.getTalking().equals("true"));
        boolean comment = (userInput.getComment() != null) && (userInput.getComment().equals("true"));
        boolean share = (userInput.getShare() != null) && (userInput.getShare().equals("true"));
        UserAccountPic savePic = new UserAccountPic();
        long current_timestamp = System.currentTimeMillis();
        String filename = current_timestamp + "_" + user;
        String type = userInput.getImg().getContentType().replace("image/", "");
        long size = userInput.getImg().getSize();
        String deviceId = checkCookie.getDevice(request.getCookies());
        SaveImages saveImage = new SaveImages();
        Accountpics insertPic = new Accountpics(user, filename, deviceId, userInput.getImg().getOriginalFilename(), current_timestamp, current_timestamp, true, false, type, size, privacy, download, doLiDis, seeLiDis, doTalking, seeTalking, doComment, seeComment, doShare, seeShare, like, dislike, talking, comment, share, true, true, true, true, true, true, true, true, true, true);
        saveImage.SaveImage(userInput.getImg(), filename);
        savePic.SavePic(insertPic);
        return "redirect:../../../../info/";
    }

}
