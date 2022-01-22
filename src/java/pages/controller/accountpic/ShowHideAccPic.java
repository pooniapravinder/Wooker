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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pages.controller.errors.ResourceNotFoundException;

@Controller
public class ShowHideAccPic {

    @RequestMapping(value = "/account/pic/edit/hide/{option}/", method = RequestMethod.GET)
    public String HideOptionAccPicEdit(@PathVariable("option") String option, @RequestParam(value = "sqq", required = true) String imgid, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        if (!option.matches("^(seepic|downloadpic|dolidislike|seelidislike|dotalk|seetalk|docomment|seecomment|doshare|seeshare)$")) {
            throw new ResourceNotFoundException();
        }
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../../../../login/";
        }
        ShowHideInfoOpt hideOption = new ShowHideInfoOpt();
        Showhideeditaccpic getValues = hideOption.getPicOptions(user);
        boolean seePic = getValues != null ? getValues.isSee() : true;
        boolean downloadPic = getValues != null ? getValues.isDodownload() : true;
        boolean lidislikeDo = getValues != null ? getValues.isLidislike() : true;
        boolean lidislikeSee = getValues != null ? getValues.isSeelidislike() : true;
        boolean talkDo = getValues != null ? getValues.isDotalking() : true;
        boolean talkSee = getValues != null ? getValues.isSeetalking() : true;
        boolean commentDo = getValues != null ? getValues.isDocomment() : true;
        boolean commentSee = getValues != null ? getValues.isSeecomment() : true;
        boolean shareDo = getValues != null ? getValues.isDoshare() : true;
        boolean shareSee = getValues != null ? getValues.isSeeshare() : true;
        boolean isChange = false;
        switch (option) {
            case "seepic":
                if (seePic) {
                    isChange = true;
                }
                seePic = false;
                break;
            case "downloadpic":
                if (downloadPic) {
                    isChange = true;
                }
                downloadPic = false;
                break;
            case "dolidislike":
                if (lidislikeDo) {
                    isChange = true;
                }
                lidislikeDo = false;
                break;
            case "seelidislike":
                if (lidislikeSee) {
                    isChange = true;
                }
                lidislikeSee = false;
                break;
            case "dotalk":
                if (talkDo) {
                    isChange = true;
                }
                talkDo = false;
                break;
            case "seetalk":
                if (talkSee) {
                    isChange = true;
                }
                talkSee = false;
                break;
            case "docomment":
                if (commentDo) {
                    isChange = true;
                }
                commentDo = false;
                break;
            case "seecomment":
                if (commentSee) {
                    isChange = true;
                }
                commentSee = false;
                break;
            case "doshare":
                if (shareDo) {
                    isChange = true;
                }
                shareDo = false;
                break;
            case "seeshare":
                if (shareSee) {
                    isChange = true;
                }
                shareSee = false;
                break;
        }
        if ((getValues == null) || (isChange)) {
            Showhideeditaccpic insertData = new Showhideeditaccpic(user, checkCookie.getDevice(request.getCookies()), getValues != null ? getValues.isInfo() : true, getValues != null ? getValues.isMoreinfo() : true, getValues != null ? getValues.isSetting() : true, getValues != null ? getValues.isSecurity() : true, getValues != null ? getValues.isAccpic() : true, getValues != null ? getValues.isUploadnew() : true, getValues != null ? getValues.isRemove() : true, getValues != null ? getValues.isDeletes() : true, getValues != null ? getValues.isDownload() : true, getValues != null ? getValues.isPictime() : true, getValues != null ? getValues.isLikes() : true, getValues != null ? getValues.isDislike() : true, getValues != null ? getValues.isTalking() : true, getValues != null ? getValues.isComment() : true, getValues != null ? getValues.isShare() : true, seePic, downloadPic, lidislikeDo, lidislikeSee, talkDo, talkSee, commentDo, commentSee, shareDo, shareSee, getValues != null ? getValues.isPrilike() : true, getValues != null ? getValues.isPridislike() : true, getValues != null ? getValues.isPritalking() : true, getValues != null ? getValues.isPricomment() : true, getValues != null ? getValues.isPrishare() : true, getValues != null ? getValues.isShowhide() : true);
            hideOption.InfoPicOptions(insertData);
        }
        return "redirect:../../" + "?" + "sqq=" + URLEncoder.encode(imgid, "UTF-8");
    }

    @RequestMapping(value = "/account/pic/upload/new/hide/{option}/", method = RequestMethod.GET)
    public String HideOptionAccPicUpl(@PathVariable("option") String option, HttpServletRequest request, HttpServletResponse response) {
        if (!option.matches("^(seepic|downloadpic|dolidislike|seelidislike|dotalk|seetalk|docomment|seecomment|doshare|seeshare|prepics)$")) {
            throw new ResourceNotFoundException();
        }
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../../../../../login/";
        }
        ShowHideInfoOpt hideOption = new ShowHideInfoOpt();
        Showhideuplaccpic getValues = hideOption.getPicUplOptions(user);
        boolean seePic = getValues != null ? getValues.isSee() : true;
        boolean downloadPic = getValues != null ? getValues.isDodownload() : true;
        boolean lidislikeDo = getValues != null ? getValues.isLidislike() : true;
        boolean lidislikeSee = getValues != null ? getValues.isSeelidislike() : true;
        boolean talkDo = getValues != null ? getValues.isDotalking() : true;
        boolean talkSee = getValues != null ? getValues.isSeetalking() : true;
        boolean commentDo = getValues != null ? getValues.isDocomment() : true;
        boolean commentSee = getValues != null ? getValues.isSeecomment() : true;
        boolean shareDo = getValues != null ? getValues.isDoshare() : true;
        boolean shareSee = getValues != null ? getValues.isSeeshare() : true;
        boolean prePics = getValues != null ? getValues.isPreviouspics() : true;
        boolean isChange = false;
        switch (option) {
            case "seepic":
                if (seePic) {
                    isChange = true;
                }
                seePic = false;
                break;
            case "downloadpic":
                if (downloadPic) {
                    isChange = true;
                }
                downloadPic = false;
                break;
            case "dolidislike":
                if (lidislikeDo) {
                    isChange = true;
                }
                lidislikeDo = false;
                break;
            case "seelidislike":
                if (lidislikeSee) {
                    isChange = true;
                }
                lidislikeSee = false;
                break;
            case "dotalk":
                if (talkDo) {
                    isChange = true;
                }
                talkDo = false;
                break;
            case "seetalk":
                if (talkSee) {
                    isChange = true;
                }
                talkSee = false;
                break;
            case "docomment":
                if (commentDo) {
                    isChange = true;
                }
                commentDo = false;
                break;
            case "seecomment":
                if (commentSee) {
                    isChange = true;
                }
                commentSee = false;
                break;
            case "doshare":
                if (shareDo) {
                    isChange = true;
                }
                shareDo = false;
                break;
            case "seeshare":
                if (shareSee) {
                    isChange = true;
                }
                shareSee = false;
                break;
            case "prepics":
                if (prePics) {
                    isChange = true;
                }
                prePics = false;
                break;
        }
        if ((getValues == null) || (isChange)) {
            byte val2 = 2;
            byte val3 = 3;
            Showhideuplaccpic insertData = new Showhideuplaccpic(user, checkCookie.getDevice(request.getCookies()), getValues != null ? getValues.isInfo() : true, getValues != null ? getValues.isMoreinfo() : true, getValues != null ? getValues.isSetting() : true, getValues != null ? getValues.isSecurity() : true, getValues != null ? getValues.isPicpreview() : true, getValues != null ? getValues.isChoosepic() : true, seePic, downloadPic, lidislikeDo, lidislikeSee, talkDo, talkSee, commentDo, commentSee, shareDo, shareSee, getValues != null ? getValues.isPrilike() : true, getValues != null ? getValues.isPridislike() : true, getValues != null ? getValues.isPritalking() : true, getValues != null ? getValues.isPricomment() : true, getValues != null ? getValues.isPrishare() : true, getValues != null ? getValues.getDefsee() : val3, getValues != null ? getValues.getDefdodownload() : val2, getValues != null ? getValues.getDeflidislike() : val2, getValues != null ? getValues.getDefseelidislike() : val2, getValues != null ? getValues.getDefdotalking() : val2, getValues != null ? getValues.getDefseetalking() : val2, getValues != null ? getValues.getDefdocomment() : val2, getValues != null ? getValues.getDefseecomment() : val2, getValues != null ? getValues.getDefdoshare() : val2, getValues != null ? getValues.getDefseeshare() : val2, getValues != null ? getValues.isDefprilike() : true, getValues != null ? getValues.isDefpridislike() : true, getValues != null ? getValues.isDefpritalking() : true, getValues != null ? getValues.isDefpricomment() : true, getValues != null ? getValues.isDefprishare() : true, prePics, getValues != null ? getValues.isShowhide() : true);
            hideOption.InfoPicUplOptions(insertData);
        }
        return "redirect:../../";
    }

    @RequestMapping(value = "/account/pic/edit/options/restore/", method = RequestMethod.GET)
    public String OptionEditInfoRestore(@RequestParam(value = "sqq", required = true) String imgid, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../../../../login/";
        }
        ShowHideInfoOpt hideOption = new ShowHideInfoOpt();
        Showhideeditaccpic getOption = hideOption.getPicOptions(user);
        if (getOption == null) {
            return "redirect:../../" + "?" + "sqq=" + URLEncoder.encode(imgid, "UTF-8");
        }
        boolean isChange = ((getOption.isInfo() != true) || (getOption.isMoreinfo() != true) || (getOption.isSetting() != false) || (getOption.isSecurity() != false) || (getOption.isAccpic() != true) || (getOption.isUploadnew() != true) || (getOption.isRemove() != true) || (getOption.isDeletes() != true) || (getOption.isDownload() != true) || (getOption.isPictime() != true) || (getOption.isLikes() != true) || (getOption.isDislike() != true) || (getOption.isTalking() != true) || (getOption.isComment() != true) || (getOption.isShare() != true) || (getOption.isSee() != true) || (getOption.isDodownload() != true) || (getOption.isLidislike() != true) || (getOption.isSeelidislike() != true) || (getOption.isDotalking() != true) || (getOption.isSeetalking() != true) || (getOption.isDocomment() != true) || (getOption.isSeecomment() != true) || (getOption.isDoshare() != true) || (getOption.isSeeshare() != true) || (getOption.isPrilike() != true) || (getOption.isPridislike() != true) || (getOption.isPritalking() != true) || (getOption.isPricomment() != true) || (getOption.isPrishare() != true) || (getOption.isShowhide() != true));
        if (isChange) {
            Showhideeditaccpic insertData = new Showhideeditaccpic(user, checkCookie.getDevice(request.getCookies()), true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true);
            hideOption.InfoPicOptions(insertData);
        }
        return "redirect:../../" + "?" + "sqq=" + URLEncoder.encode(imgid, "UTF-8");
    }

    @RequestMapping(value = "/account/pic/upload/new/options/restore/", method = RequestMethod.GET)
    public String OptionUplPicRestore(HttpServletRequest request, HttpServletResponse response) {
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../../../../../login/";
        }
        byte val2 = 2;
        byte val3 = 3;
        ShowHideInfoOpt hideOption = new ShowHideInfoOpt();
        Showhideuplaccpic getOption = hideOption.getPicUplOptions(user);
        if (getOption == null) {
            return "redirect:../../";
        }
        boolean isChange = ((getOption.isInfo() != true) || (getOption.isMoreinfo() != true) || (getOption.isSetting() != false) || (getOption.isSecurity() != false) || (getOption.isPicpreview() != true) || (getOption.isChoosepic() != true) || (getOption.isSee() != true) || (getOption.isDodownload() != true) || (getOption.isLidislike() != true) || (getOption.isSeelidislike() != true) || (getOption.isDotalking() != true) || (getOption.isSeetalking() != true) || (getOption.isDocomment() != true) || (getOption.isSeecomment() != true) || (getOption.isDoshare() != true) || (getOption.isSeeshare() != true) || (getOption.isPrilike() != true) || (getOption.isPridislike() != true) || (getOption.isPritalking() != true) || (getOption.isPricomment() != true) || (getOption.isPrishare() != true) || (getOption.getDefsee() != 3) || (getOption.getDefdodownload() != 2) || (getOption.getDeflidislike() != 1) || (getOption.getDefseelidislike() != 1) || (getOption.getDefdotalking() != 1) || (getOption.getDefseetalking() != 1) || (getOption.getDefdocomment() != 1) || (getOption.getDefseecomment() != 1) || (getOption.getDefdoshare() != 1) || (getOption.getDefseeshare() != 1) || (getOption.isDefprilike() != true) || (getOption.isDefpridislike() != true) || (getOption.isDefpritalking() != true) || (getOption.isDefpricomment() != true) || (getOption.isDefprishare() != true) || (getOption.isShowhide() != true));
        if (isChange) {
            Showhideuplaccpic insertData = new Showhideuplaccpic(user, checkCookie.getDevice(request.getCookies()), true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, val3, val2, val2, val2, val2, val2, val2, val2, val2, val2, true, true, true, true, true, true, true);
            hideOption.InfoPicUplOptions(insertData);
        }
        return "redirect:../../";
    }

}
