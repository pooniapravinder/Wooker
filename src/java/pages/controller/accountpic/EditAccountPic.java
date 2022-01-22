package pages.controller.accountpic;

import cookies.set.get.CheckSaveCookies;
import data.encryption.decryption.Cryptography;
import hibernate.mapping.Accountpics;
import hibernate.query.UserAccountPic;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EditAccountPic {

    @RequestMapping(value = "/account/pic/edit/", method = RequestMethod.GET)
    public String EditPicPageView(@RequestParam(value = "sqq", required = true) String imgid,Model model, HttpServletRequest request, HttpServletResponse response) {
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        if (checkCookie.getCookie(request, response) == 0) {
            return "redirect:../../../login/";
        }
        Cryptography decrypt = new Cryptography();
        String user_imgid = decrypt.decrypt(imgid);
        if (user_imgid == null) {
            return "redirect:../../../home/";
        }
        UserAccountPic get_image = new UserAccountPic();
        Accountpics get_data = get_image.AccountImg(user_imgid);
        if (get_data == null) {
            return "redirect:../../../home/";
        }
        Accpicoper set_data = new Accpicoper(get_data);
        model.addAttribute("accpicoper", set_data);
        return "editaccpic";
    }

    @RequestMapping(value = "/account/pic/edit/", method = RequestMethod.POST)
    public String EditPicPageSubmit(Accpicoper userInput, @RequestParam(value = "sqq", required = true) String imgid, @RequestParam(value = "refer", required = false) String refer,  HttpServletRequest request, HttpServletResponse response) throws IOException {
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../../login/";
        }
        Cryptography decrypt = new Cryptography();
        String user_imgid = decrypt.decrypt(imgid);
        UserAccountPic get_image = new UserAccountPic();
        if ((user_imgid != null) ? (get_image.AccountImg(user_imgid) == null) : true) {
            return "redirect:../../../home/";
        }
        UserAccountPic savePic = new UserAccountPic();
        Accountpics getImgid = savePic.AccountImg(user_imgid);
        String match = "^([1-6])$";
        byte privacy = (userInput.getPrivacy() != null) && (userInput.getPrivacy().matches(match)) ? Byte.parseByte(userInput.getPrivacy()) : getImgid.getPrivacy();
        byte download = (userInput.getDownload() != null) && (userInput.getDownload().matches(match)) ? Byte.parseByte(userInput.getDownload()) : getImgid.getDownload();
        byte doLiDis = (userInput.getDoLiDis() != null) && (userInput.getDoLiDis().matches(match)) ? Byte.parseByte(userInput.getDoLiDis()) : getImgid.getDoLidislike();
        byte seeLiDis = (userInput.getSeeLiDis() != null) && (userInput.getSeeLiDis().matches(match)) ? Byte.parseByte(userInput.getSeeLiDis()) : getImgid.getSeeLidislike();
        byte doTalking = (userInput.getDoTalking() != null) && (userInput.getDoTalking().matches(match)) ? Byte.parseByte(userInput.getDoTalking()) : getImgid.getDoTalking();
        byte seeTalking = (userInput.getSeeTalking() != null) && (userInput.getSeeTalking().matches(match)) ? Byte.parseByte(userInput.getSeeTalking()) : getImgid.getSeeTalking();
        byte doComment = (userInput.getDoComment() != null) && (userInput.getDoComment().matches(match)) ? Byte.parseByte(userInput.getDoComment()) : getImgid.getDoComment();
        byte seeComment = (userInput.getSeeComment() != null) && (userInput.getSeeComment().matches(match)) ? Byte.parseByte(userInput.getSeeComment()) : getImgid.getSeeComment();
        byte doShare = (userInput.getDoShare() != null) && (userInput.getDoShare().matches(match)) ? Byte.parseByte(userInput.getDoShare()) : getImgid.getDoShare();
        byte seeShare = (userInput.getSeeShare() != null) && (userInput.getSeeShare().matches(match)) ? Byte.parseByte(userInput.getSeeShare()) : getImgid.getSeeShare();
        boolean like = (userInput.getLike() != null);
        if (userInput.getHlike() == null) {
            like = getImgid.isLikes();
        }
        boolean dislike = (userInput.getDislike() != null);
        if (userInput.getHdislike() == null) {
            dislike = getImgid.isDislikes();
        }
        boolean talking = (userInput.getTalking() != null);
        if (userInput.getHtalking() == null) {
            talking = getImgid.isTalkings();
        }
        boolean comment = (userInput.getComment() != null);
        if (userInput.getHcomment() == null) {
            comment = getImgid.isComments();
        }
        boolean share = (userInput.getShare() != null);
        if (userInput.getHshare() == null) {
            share = getImgid.isShares();
        }
        String deviceId = checkCookie.getDevice(request.getCookies());
        boolean isChange = ((getImgid.getPrivacy() != privacy) || (getImgid.getDownload() != download) || (getImgid.getDoLidislike() != doLiDis) || (getImgid.getSeeLidislike() != seeLiDis) || (getImgid.getDoTalking() != doTalking) || (getImgid.getSeeTalking() != seeTalking) || (getImgid.getDoComment() != doComment) || (getImgid.getSeeComment() != seeComment) || (getImgid.getDoShare() != doShare) || (getImgid.getSeeShare() != seeShare) || (getImgid.isLikes() != like) || (getImgid.isDislikes() != dislike) || (getImgid.isTalkings() != talking) || (getImgid.isComments() != comment) || (getImgid.isShares() != share));
        if (isChange) {
            Accountpics insertPic = new Accountpics(user, getImgid.getPicId(), deviceId, getImgid.getOrigName(), System.currentTimeMillis(), getImgid.getTimeStamp(), true, false, getImgid.getPictype(), getImgid.getPicsize(), privacy, download, doLiDis, seeLiDis, doTalking, seeTalking, doComment, seeComment, doShare, seeShare, like, dislike, talking, comment, share, getImgid.isTalkingImage(), getImgid.isTalkingAudio(), getImgid.isTalkingVideo(), getImgid.isTalkingFile(), getImgid.isTalkingSticker(), getImgid.isCommentImage(), getImgid.isCommentAudio(), getImgid.isCommentVideo(), getImgid.isCommentFile(), getImgid.isCommentSticker());
            savePic.SavePic(insertPic);
        }
        return (refer!=null && refer.equals("oUej-Ge7H7_ByLk")&&(talking)) ? "redirect:../../../accpic/user/oper/talking/?sqq="+decrypt.encodeURL(imgid)+"&refer=oUej-Ge7H7_ByLk" : "redirect:../../../info/";
    }

}
