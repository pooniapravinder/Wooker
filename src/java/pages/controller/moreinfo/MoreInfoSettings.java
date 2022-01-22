package pages.controller.moreinfo;

import cookies.set.get.CheckSaveCookies;
import hibernate.mapping.Showhideaddmoreinfo;
import hibernate.mapping.Showhidemoreinfo;
import hibernate.query.info.ShowHideInfoOpt;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MoreInfoSettings {

    @RequestMapping(value = "/more/info/settings/", method = RequestMethod.GET)
    public String MoreInfoSettingsview(Model model, HttpServletRequest request, HttpServletResponse response) {
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../../login/";
        }
        ShowHideInfoOpt getData = new ShowHideInfoOpt();
        Showhidemoreinfo getOption = getData.getMoreInfoOptions(user);
        Upmoinsettings UpSettings = new Upmoinsettings(getOption);
        model.addAttribute("upmoinsettings", UpSettings);
        return "settings/moreinfo";
    }

    @RequestMapping(value = "/more/info/add/settings/", method = RequestMethod.GET)
    public String MoreInfoAddSettingsview(Model model, HttpServletRequest request, HttpServletResponse response) {
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../../login/";
        }
        ShowHideInfoOpt getData = new ShowHideInfoOpt();
        Showhideaddmoreinfo getOption = getData.getMoreInfoAddOptions(user);
        Upmoinsettings UpSettings = new Upmoinsettings(getOption);
        model.addAttribute("upmoinsettings", UpSettings);
        return "settings/moreinfo";
    }

    @RequestMapping(value = "/more/info/settings/", method = RequestMethod.POST)
    public String MoreInfoSettingssubmit(Upmoinsettings UpSettings, HttpServletRequest request, HttpServletResponse response) {
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../../../login/";
        }
        ShowHideInfoOpt getData = new ShowHideInfoOpt();
        Showhidemoreinfo getOption = getData.getMoreInfoOptions(user);
        boolean info = UpSettings.getInfo() != null;
        boolean addmoInfo = UpSettings.getAddmoInfo() != null;
        boolean settings = UpSettings.getSettings() != null;
        boolean security = UpSettings.getSecurity() != null;
        boolean school = UpSettings.getSchool() != null;
        boolean grcollege = UpSettings.getGrcollege() != null;
        boolean gruniver = UpSettings.getGruniver() != null;
        boolean pogrcoll = UpSettings.getPogrcoll() != null;
        boolean pogruniver = UpSettings.getPogruniver() != null;
        boolean work = UpSettings.getWork() != null;
        boolean location = UpSettings.getLocation() != null;
        boolean moved = UpSettings.getMoved() != null;
        boolean mobile = UpSettings.getMobile() != null;
        boolean email = UpSettings.getEmail() != null;
        boolean website = UpSettings.getWebsite() != null;
        boolean hobbies = UpSettings.getHobbies() != null;
        boolean relationship = UpSettings.getRelationship() != null;
        boolean relation = UpSettings.getRelation() != null;
        boolean languages = UpSettings.getLanguages() != null;
        boolean religion = UpSettings.getReligion() != null;
        boolean behaviour = UpSettings.getBehaviour() != null;
        boolean myself = UpSettings.getMyself() != null;
        boolean newcateg = UpSettings.getNewcateg() != null;
        boolean isChange = ((getOption == null) || (info != getOption.isInfo()) || (addmoInfo != getOption.isAddmoin()) || (settings != getOption.isSetting()) || (security != getOption.isSecurity()) || (school != getOption.isSchool()) || (grcollege != getOption.isGrcollege()) || (gruniver != getOption.isGruniver()) || (pogrcoll != getOption.isPogrcoll()) || (pogruniver != getOption.isPogruniv()) || (work != getOption.isWorks()) || (location != getOption.isLocation()) || (moved != getOption.isMoved()) || (mobile != getOption.isMobile()) || (email != getOption.isEmail()) || (website != getOption.isWebsite()) || (hobbies != getOption.isHobbies()) || (relationship != getOption.isRelationship()) || (relation != getOption.isRelation()) || (languages != getOption.isLanguages()) || (religion != getOption.isReligion()) || (behaviour != getOption.isBehaviour()) || (myself != getOption.isMyself()) || (newcateg != getOption.isNewcateg()));
        if (isChange) {
            Showhidemoreinfo insertOption = new Showhidemoreinfo(user, checkCookie.getDevice(request.getCookies()), info, addmoInfo, settings, security, school, grcollege, gruniver, pogrcoll, pogruniver, work, location, moved, mobile, email, website, hobbies, relationship, relation, languages, religion, behaviour, myself, newcateg);
            getData.MoreInfoOptions(insertOption);
        }
        return "redirect:../";
    }

    @RequestMapping(value = "/more/info/add/settings/", method = RequestMethod.POST)
    public String MoreInfoAddSettingssubmit(Upmoinsettings UpSettings, HttpServletRequest request, HttpServletResponse response) {
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../../../login/";
        }
        ShowHideInfoOpt getData = new ShowHideInfoOpt();
        Showhideaddmoreinfo getOption = getData.getMoreInfoAddOptions(user);
        boolean info = UpSettings.getInfo() != null;
        boolean moreinfo = UpSettings.getMoreInfo() != null;
        boolean settings = UpSettings.getSettings() != null;
        boolean security = UpSettings.getSecurity() != null;
        boolean school = UpSettings.getSchool() != null;
        boolean grcollege = UpSettings.getGrcollege() != null;
        boolean gruniver = UpSettings.getGruniver() != null;
        boolean pogrcoll = UpSettings.getPogrcoll() != null;
        boolean pogruniver = UpSettings.getPogruniver() != null;
        boolean work = UpSettings.getWork() != null;
        boolean location = UpSettings.getLocation() != null;
        boolean moved = UpSettings.getMoved() != null;
        boolean mobile = UpSettings.getMobile() != null;
        boolean email = UpSettings.getEmail() != null;
        boolean website = UpSettings.getWebsite() != null;
        boolean hobbies = UpSettings.getHobbies() != null;
        boolean relationship = UpSettings.getRelationship() != null;
        boolean relation = UpSettings.getRelation() != null;
        boolean languages = UpSettings.getLanguages() != null;
        boolean religion = UpSettings.getReligion() != null;
        boolean behaviour = UpSettings.getBehaviour() != null;
        boolean myself = UpSettings.getMyself() != null;
        boolean newcateg = UpSettings.getNewcateg() != null;
        boolean showHide = UpSettings.getShowHide() != null;
        boolean isChange = ((getOption == null) || (info != getOption.isInfo()) || (moreinfo != getOption.isMoreinfo()) || (settings != getOption.isSetting()) || (security != getOption.isSecurity()) || (school != getOption.isSchool()) || (grcollege != getOption.isGrcollege()) || (gruniver != getOption.isGruniver()) || (pogrcoll != getOption.isPogrcoll()) || (pogruniver != getOption.isPogruniv()) || (work != getOption.isWorks()) || (location != getOption.isLocation()) || (moved != getOption.isMoved()) || (mobile != getOption.isMobile()) || (email != getOption.isEmail()) || (website != getOption.isWebsite()) || (hobbies != getOption.isHobbies()) || (relationship != getOption.isRelationship()) || (relation != getOption.isRelation()) || (languages != getOption.isLanguages()) || (religion != getOption.isReligion()) || (behaviour != getOption.isBehaviour()) || (myself != getOption.isMyself()) || (newcateg != getOption.isNewcateg()) || (showHide != getOption.isShowhide()));
        if (isChange) {
            Showhideaddmoreinfo insertOption = new Showhideaddmoreinfo(user, checkCookie.getDevice(request.getCookies()), info, moreinfo, settings, security, school, grcollege, gruniver, pogrcoll, pogruniver, work, location, moved, mobile, email, website, hobbies, relationship, relation, languages, religion, behaviour, myself, newcateg, showHide);
            getData.MoreInfoAddOptions(insertOption);
        }
        return "redirect:../";
    }

}
