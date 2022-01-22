package pages.controller.accountpic;

import cookies.set.get.CheckSaveCookies;
import hibernate.mapping.Showhideeditaccpic;
import hibernate.mapping.Showhideuplaccpic;
import hibernate.query.info.ShowHideInfoOpt;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccPicSettings {

    @RequestMapping(value = "/account/pic/edit/settings/", method = RequestMethod.GET)
    public String AccPicEditSettingsView(Model model, HttpServletRequest request, HttpServletResponse response) {
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../../../login/";
        }
        ShowHideInfoOpt getData = new ShowHideInfoOpt();
        Showhideeditaccpic getOption = getData.getPicOptions(user);
        Accpicedsettings UpSettings = new Accpicedsettings(getOption);
        model.addAttribute("accpicedsettings", UpSettings);
        return "settings/editaccpic";
    }

    @RequestMapping(value = "/account/pic/upload/new/settings/", method = RequestMethod.GET)
    public String AccPicUplSettingsView(Model model, HttpServletRequest request, HttpServletResponse response) {
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../../../../login/";
        }
        ShowHideInfoOpt getData = new ShowHideInfoOpt();
        Showhideuplaccpic getOption = getData.getPicUplOptions(user);
        Accpicupsettings UpSettings = new Accpicupsettings(getOption);
        model.addAttribute("accpicupsettings", UpSettings);
        return "settings/uploadaccpic";
    }

    @RequestMapping(value = "/account/pic/edit/settings/", method = RequestMethod.POST)
    public String AccPicEditSettingsSubmit(@RequestParam(value = "sqq", required = true) String imgid, Accpicedsettings UpSettings, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../../../login/";
        }
        ShowHideInfoOpt getData = new ShowHideInfoOpt();
        Showhideeditaccpic getOption = getData.getPicOptions(user);
        boolean prInfo = UpSettings.getPrInfo() != null;
        boolean secInfo = UpSettings.getSecInfo() != null;
        boolean settings = UpSettings.getSettings() != null;
        boolean security = UpSettings.getSecurity() != null;
        boolean accPic = UpSettings.getAccPic() != null;
        boolean upNew = UpSettings.getUpNew() != null;
        boolean remove = UpSettings.getRemove() != null;
        boolean delete = UpSettings.getDelete() != null;
        boolean download = UpSettings.getDownload() != null;
        boolean picTime = UpSettings.getPicTime() != null;
        boolean like = UpSettings.getLike() != null;
        boolean dislike = UpSettings.getDislike() != null;
        boolean talking = UpSettings.getTalking() != null;
        boolean comment = UpSettings.getComment() != null;
        boolean share = UpSettings.getShare() != null;
        boolean seePic = UpSettings.getSeePic() != null;
        boolean downloadPic = UpSettings.getDownloadPic() != null;
        boolean liDislikeDo = UpSettings.getLiDislikeDo() != null;
        boolean liDislikeSee = UpSettings.getLiDislikeSee() != null;
        boolean talkingDo = UpSettings.getTalkingDo() != null;
        boolean talkingSee = UpSettings.getTalkingSee() != null;
        boolean commentDo = UpSettings.getCommentDo() != null;
        boolean commentSee = UpSettings.getCommentSee() != null;
        boolean shareDo = UpSettings.getShareDo() != null;
        boolean shareSee = UpSettings.getShareSee() != null;
        boolean likePri = UpSettings.getLikePri() != null;
        boolean dislikePri = UpSettings.getDislikePri() != null;
        boolean talkingPri = UpSettings.getTalkingPri() != null;
        boolean commentPri = UpSettings.getCommentPri() != null;
        boolean sharePri = UpSettings.getSharePri() != null;
        boolean showHide = UpSettings.getShowHide() != null;
        boolean isChange = ((getOption==null) || (prInfo != getOption.isInfo()) || (secInfo != getOption.isMoreinfo()) || (settings != getOption.isSetting()) || (security != getOption.isSecurity()) || (accPic != getOption.isAccpic()) || (upNew != getOption.isUploadnew()) || (remove != getOption.isRemove()) || (delete != getOption.isDeletes()) || (download != getOption.isDownload()) || (picTime != getOption.isPictime()) || (like != getOption.isLikes()) || (dislike != getOption.isDislike()) || (talking != getOption.isTalking()) || (comment != getOption.isComment()) || (share != getOption.isShare()) || (seePic != getOption.isSee()) || (downloadPic != getOption.isDodownload()) || (liDislikeDo != getOption.isLidislike()) || (liDislikeSee != getOption.isSeelidislike()) || (talkingDo != getOption.isDotalking()) || (talkingSee != getOption.isSeetalking()) || (commentDo != getOption.isDocomment()) || (commentSee != getOption.isSeecomment()) || (shareDo != getOption.isDoshare()) || (shareSee != getOption.isSeeshare()) || (likePri != getOption.isPrilike()) || (dislikePri != getOption.isPridislike()) || (talkingPri != getOption.isPritalking()) || (commentPri != getOption.isPricomment()) || (sharePri != getOption.isPrishare()) || (showHide != getOption.isShowhide()));
        if (isChange) {
            Showhideeditaccpic insertOption = new Showhideeditaccpic(user, checkCookie.getDevice(request.getCookies()), prInfo, secInfo, settings, security, accPic, upNew, remove, delete, download, picTime, like, dislike, talking, comment, share, seePic, downloadPic, liDislikeDo, liDislikeSee, talkingDo, talkingSee, commentDo, commentSee, shareDo, shareSee, likePri, dislikePri, talkingPri, commentPri, sharePri, showHide);
            getData.InfoPicOptions(insertOption);
        }
        return "redirect:../" + "?" + "sqq=" + URLEncoder.encode(imgid, "UTF-8");
    }

    @RequestMapping(value = "/account/pic/upload/new/settings/", method = RequestMethod.POST)
    public String AccPicUplSettingsSubmit(Accpicupsettings UpSettings, HttpServletRequest request, HttpServletResponse response) {
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../../../login/";
        }
        ShowHideInfoOpt getData = new ShowHideInfoOpt();
        Showhideuplaccpic getOption = getData.getPicUplOptions(user);
        String match = "^([1-6])$";
        boolean prInfo = UpSettings.getPrInfo() != null;
        boolean secInfo = UpSettings.getSecInfo() != null;
        boolean settings = UpSettings.getSettings() != null;
        boolean security = UpSettings.getSecurity() != null;
        boolean picPreview = UpSettings.getPicPreview() != null;
        boolean chPic = UpSettings.getChPic() != null;
        boolean seePic = UpSettings.getSeePic() != null;
        boolean downloadPic = UpSettings.getDownloadPic() != null;
        boolean liDislikeDo = UpSettings.getLiDislikeDo() != null;
        boolean liDislikeSee = UpSettings.getLiDislikeSee() != null;
        boolean talkingDo = UpSettings.getTalkingDo() != null;
        boolean talkingSee = UpSettings.getTalkingSee() != null;
        boolean commentDo = UpSettings.getCommentDo() != null;
        boolean commentSee = UpSettings.getCommentSee() != null;
        boolean shareDo = UpSettings.getShareDo() != null;
        boolean shareSee = UpSettings.getShareSee() != null;
        boolean likePri = UpSettings.getLikePri() != null;
        boolean dislikePri = UpSettings.getDislikePri() != null;
        boolean talkingPri = UpSettings.getTalkingPri() != null;
        boolean commentPri = UpSettings.getCommentPri() != null;
        boolean sharePri = UpSettings.getSharePri() != null;
        byte defseePic = (UpSettings.getDefseePic() != null) && (UpSettings.getDefseePic().matches(match)) ? Byte.parseByte(UpSettings.getDefseePic()) : 3;
        byte defdownloadPic = (UpSettings.getDefdownloadPic() != null) && (UpSettings.getDefdownloadPic().matches(match)) ? Byte.parseByte(UpSettings.getDefdownloadPic()) : 2;
        byte defliDislikeDo = (UpSettings.getDefliDislikeDo() != null) && (UpSettings.getDefliDislikeDo().matches(match)) ? Byte.parseByte(UpSettings.getDefliDislikeDo()) : 2;
        byte defliDislikeSee = (UpSettings.getDefliDislikeSee() != null) && (UpSettings.getDefliDislikeSee().matches(match)) ? Byte.parseByte(UpSettings.getDefliDislikeSee()) : 2;
        byte deftalkingDo = (UpSettings.getDeftalkingDo() != null) && (UpSettings.getDeftalkingDo().matches(match)) ? Byte.parseByte(UpSettings.getDeftalkingDo()) : 2;
        byte deftalkingSee = (UpSettings.getDeftalkingSee() != null) && (UpSettings.getDeftalkingSee().matches(match)) ? Byte.parseByte(UpSettings.getDeftalkingSee()) : 2;
        byte defcommentDo = (UpSettings.getDefcommentDo() != null) && (UpSettings.getDefcommentDo().matches(match)) ? Byte.parseByte(UpSettings.getDefcommentDo()) : 2;
        byte defcommentSee = (UpSettings.getDefcommentSee() != null) && (UpSettings.getDefcommentSee().matches(match)) ? Byte.parseByte(UpSettings.getDefcommentSee()) : 2;
        byte defshareDo = (UpSettings.getDefshareDo() != null) && (UpSettings.getDefshareDo().matches(match)) ? Byte.parseByte(UpSettings.getDefshareDo()) : 2;
        byte defshareSee = (UpSettings.getDefshareSee() != null) && (UpSettings.getDefshareSee().matches(match)) ? Byte.parseByte(UpSettings.getDefshareSee()) : 2;
        boolean deflikePri = UpSettings.getDeflikePri() != null;
        boolean defdislikePri = UpSettings.getDefdislikePri() != null;
        boolean deftalkingPri = UpSettings.getDeftalkingPri() != null;
        boolean defcommentPri = UpSettings.getDefcommentPri() != null;
        boolean defsharePri = UpSettings.getDefsharePri() != null;
        boolean prePics = UpSettings.getPrePics() != null;
        boolean showHide = UpSettings.getShowHide() != null;
        boolean isChange = ((getOption==null) || (prInfo != getOption.isInfo()) || (secInfo != getOption.isMoreinfo()) || (settings != getOption.isSetting()) || (security != getOption.isSecurity()) || (picPreview != getOption.isPicpreview()) || (chPic != getOption.isChoosepic()) || (seePic != getOption.isSee()) || (downloadPic != getOption.isDodownload()) || (liDislikeDo != getOption.isLidislike()) || (liDislikeSee != getOption.isSeelidislike()) || (talkingDo != getOption.isDotalking()) || (talkingSee != getOption.isSeetalking()) || (commentDo != getOption.isDocomment()) || (commentSee != getOption.isSeecomment()) || (shareDo != getOption.isDoshare()) || (shareSee != getOption.isSeeshare()) || (likePri != getOption.isPrilike()) || (dislikePri != getOption.isPridislike()) || (talkingPri != getOption.isPritalking()) || (commentPri != getOption.isPricomment()) || (sharePri != getOption.isPrishare()) || (defseePic != getOption.getDefsee()) || (defdownloadPic != getOption.getDefdodownload()) || (defliDislikeDo != getOption.getDeflidislike()) || (defliDislikeSee != getOption.getDefseelidislike()) || (deftalkingDo != getOption.getDefdotalking()) || (deftalkingSee != getOption.getDefseetalking()) || (defcommentDo != getOption.getDefdocomment()) || (defcommentSee != getOption.getDefseecomment()) || (defshareDo != getOption.getDefdoshare()) || (defshareSee != getOption.getDefseeshare()) || (deflikePri != getOption.isDefprilike()) || (defdislikePri != getOption.isDefpridislike()) || (deftalkingPri != getOption.isDefpritalking()) || (defcommentPri != getOption.isDefpricomment()) || (defsharePri != getOption.isDefprishare()) || (prePics != getOption.isPreviouspics()) || (showHide != getOption.isShowhide()));
        if (isChange) {
            Showhideuplaccpic insertOption = new Showhideuplaccpic(user, checkCookie.getDevice(request.getCookies()), prInfo, secInfo, settings, security, picPreview, chPic, seePic, downloadPic, liDislikeDo, liDislikeSee, talkingDo, talkingSee, commentDo, commentSee, shareDo, shareSee, likePri, dislikePri, talkingPri, commentPri, sharePri, defseePic, defdownloadPic, defliDislikeDo, defliDislikeSee, deftalkingDo, deftalkingSee, defcommentDo, defcommentSee, defshareDo, defshareSee, deflikePri, defdislikePri, deftalkingPri, defcommentPri, defsharePri, prePics, showHide);
            getData.InfoPicUplOptions(insertOption);
        }
        return "redirect:../";
    }

}
