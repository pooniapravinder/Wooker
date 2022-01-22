package pages.controller.moreinfo;

import cookies.set.get.CheckSaveCookies;
import hibernate.mapping.Showhideaddmoreinfo;
import hibernate.mapping.Showhidemoreinfo;
import hibernate.query.info.ShowHideInfoOpt;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pages.controller.errors.ResourceNotFoundException;

@Controller
public class MoreInfoShowHide {

    @RequestMapping(value = "/more/info/add/hide/{option}/", method = RequestMethod.GET)
    public String HideOptionMoreInfoAdd(@PathVariable("option") String option, HttpServletRequest request, HttpServletResponse response) {
        if (!option.matches("^(school|grcollege|gruniver|pogrcoll|pogruniver|work|location|moved|mobile|email|website|hobbies|relationship|relation|languages|religion|behaviour|myself|newcatg)$")) {
            throw new ResourceNotFoundException();
        }
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../../login/";
        }
        ShowHideInfoOpt hideOption = new ShowHideInfoOpt();
        Showhideaddmoreinfo getValues = hideOption.getMoreInfoAddOptions(user);
        boolean school = getValues!=null ? getValues.isSchool() : true;
        boolean grcollege = getValues!=null ? getValues.isGrcollege() : true;
        boolean gruniver = getValues!=null ? getValues.isGruniver() : true;
        boolean pogrcoll = getValues!=null ? getValues.isPogrcoll() : true;
        boolean pogruniver = getValues!=null ? getValues.isPogruniv() : true;
        boolean work = getValues!=null ? getValues.isWorks() : true;
        boolean location = getValues!=null ? getValues.isLocation() : true;
        boolean moved = getValues!=null ? getValues.isMoved() : true;
        boolean mobile = getValues!=null ? getValues.isMobile() : true;
        boolean email = getValues!=null ? getValues.isEmail() : true;
        boolean website = getValues!=null ? getValues.isWebsite() : true;
        boolean hobbies = getValues!=null ? getValues.isHobbies() : true;
        boolean relationship = getValues!=null ? getValues.isRelationship() : true;
        boolean relation = getValues!=null ? getValues.isRelation() : true;
        boolean languages = getValues!=null ? getValues.isLanguages() : true;
        boolean religion = getValues!=null ? getValues.isReligion() : true;
        boolean behaviour = getValues!=null ? getValues.isBehaviour() : true;
        boolean myself = getValues!=null ? getValues.isMyself() : true;
        boolean newcatg = getValues!=null ? getValues.isNewcateg() : true;
        boolean isChange = false;
        switch (option) {
            case "school":
                if (school) {
                    isChange = true;
                }
                school = false;
                break;
            case "grcollege":
                if (grcollege) {
                    isChange = true;
                }
                grcollege = false;
                break;
            case "gruniver":
                if (gruniver) {
                    isChange = true;
                }
                gruniver = false;
                break;
            case "pogrcoll":
                if (pogrcoll) {
                    isChange = true;
                }
                pogrcoll = false;
                break;
            case "pogruniver":
                if (pogruniver) {
                    isChange = true;
                }
                pogruniver = false;
                break;
            case "work":
                if (work) {
                    isChange = true;
                }
                work = false;
                break;
            case "location":
                if (location) {
                    isChange = true;
                }
                location = false;
                break;
            case "moved":
                if (moved) {
                    isChange = true;
                }
                moved = false;
                break;
            case "mobile":
                if (mobile) {
                    isChange = true;
                }
                mobile = false;
                break;
            case "email":
                if (email) {
                    isChange = true;
                }
                email = false;
                break;
            case "website":
                if (website) {
                    isChange = true;
                }
                website = false;
                break;
            case "hobbies":
                if (hobbies) {
                    isChange = true;
                }
                hobbies = false;
                break;
            case "relationship":
                if (relationship) {
                    isChange = true;
                }
                relationship = false;
                break;
            case "relation":
                if (relation) {
                    isChange = true;
                }
                relation = false;
                break;
            case "languages":
                if (languages) {
                    isChange = true;
                }
                languages = false;
                break;
            case "religion":
                if (religion) {
                    isChange = true;
                }
                religion = false;
                break;
            case "behaviour":
                if (behaviour) {
                    isChange = true;
                }
                behaviour = false;
                break;
            case "myself":
                if (myself) {
                    isChange = true;
                }
                myself = false;
                break;
            case "newcatg":
                if (newcatg) {
                    isChange = true;
                }
                newcatg = false;
                break;
        }
        if ((getValues==null)||(isChange)) {
            Showhideaddmoreinfo insertData = new Showhideaddmoreinfo(user, checkCookie.getDevice(request.getCookies()), getValues!=null ? getValues.isInfo() : true, getValues!=null ? getValues.isMoreinfo() : true, getValues!=null ? getValues.isSetting() : true, getValues!=null ?  getValues.isSecurity() : true, school, grcollege, gruniver, pogrcoll, pogruniver, work, location, moved, mobile, email, website, hobbies, relationship, relation, languages, religion, behaviour, myself, newcatg, getValues!=null ? getValues.isShowhide() : true);
            hideOption.MoreInfoAddOptions(insertData);
        }
        return "redirect:../../";
    }

    @RequestMapping(value = "/more/info/options/restore/", method = RequestMethod.GET)
    public String OptionMoreInfoRestore(HttpServletRequest request, HttpServletResponse response) {
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../../login/";
        }
        ShowHideInfoOpt hideOption = new ShowHideInfoOpt();
        Showhidemoreinfo getValues = hideOption.getMoreInfoOptions(user);
        boolean isChange = ((getValues==null) || (getValues.isInfo() != true) || (getValues.isAddmoin() != true) || (getValues.isSetting() != false) || (getValues.isSecurity() != false) || (getValues.isSchool() != true) || (getValues.isGrcollege() != true) || (getValues.isGruniver() != true) || (getValues.isPogrcoll() != true) || (getValues.isPogruniv() != true) || (getValues.isWorks() != true) || (getValues.isMoved() != true) || (getValues.isLocation() != true) || (getValues.isMobile() != true) || (getValues.isEmail() != true) || (getValues.isWebsite() != true) || (getValues.isHobbies() != true) || (getValues.isRelationship() != true) || (getValues.isRelation() != true) || (getValues.isLanguages() != true) || (getValues.isReligion() != true) || (getValues.isBehaviour() != true) || (getValues.isMyself() != true) || (getValues.isNewcateg() != true));
        if (isChange) {
            Showhidemoreinfo insertData = new Showhidemoreinfo(user, checkCookie.getDevice(request.getCookies()), true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true);
            hideOption.MoreInfoOptions(insertData);
        }
        return "redirect:../../";
    }

    @RequestMapping(value = "/more/info/add/options/restore/", method = RequestMethod.GET)
    public String OptionMoreInfoAddRestore(HttpServletRequest request, HttpServletResponse response) {
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../../../login/";
        }
        ShowHideInfoOpt hideOption = new ShowHideInfoOpt();
        Showhideaddmoreinfo getValues = hideOption.getMoreInfoAddOptions(user);
        boolean isChange = ((getValues==null) || (getValues.isInfo() != true) || (getValues.isMoreinfo() != true) || (getValues.isSetting() != false) || (getValues.isSecurity() != false) || (getValues.isSchool() != true) || (getValues.isGrcollege() != true) || (getValues.isGruniver() != true) || (getValues.isPogrcoll() != true) || (getValues.isPogruniv() != true) || (getValues.isWorks() != true) || (getValues.isMoved() != true) || (getValues.isLocation() != true) || (getValues.isMobile() != true) || (getValues.isEmail() != true) || (getValues.isWebsite() != true) || (getValues.isHobbies() != true) || (getValues.isRelationship() != true) || (getValues.isRelation() != true) || (getValues.isLanguages() != true) || (getValues.isReligion() != true) || (getValues.isBehaviour() != true) || (getValues.isMyself() != true) || (getValues.isNewcateg() != true) || (getValues.isShowhide() != true));
        if (isChange) {
            Showhideaddmoreinfo insertData = new Showhideaddmoreinfo(user, checkCookie.getDevice(request.getCookies()), true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true);
            hideOption.MoreInfoAddOptions(insertData);
        }
        return "redirect:../../";
    }

}
