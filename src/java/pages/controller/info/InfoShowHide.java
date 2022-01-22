package pages.controller.info;

import cookies.set.get.CheckSaveCookies;
import hibernate.mapping.Showhideeditinfo;
import hibernate.mapping.Showhideinfo;
import hibernate.query.info.ShowHideInfoOpt;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pages.controller.errors.ResourceNotFoundException;

@Controller
public class InfoShowHide {

    @RequestMapping(value = "/info/hide/{option}/", method = RequestMethod.GET)
    public String HideOptionInfo(@PathVariable("option") String option, HttpServletRequest request, HttpServletResponse response) {
        if (!option.matches("^(accpic|displayname|firstname|lastname|nickname|gender|birthday|age|acctype)$")) {
            throw new ResourceNotFoundException();
        }
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../../login/";
        }
        ShowHideInfoOpt hideOption = new ShowHideInfoOpt();
        Showhideinfo getValues = hideOption.getInfoOptions(user);
        boolean accPic = getValues != null ? getValues.isAccpic() : true;
        boolean disName = getValues != null ? getValues.isDisplayname() : true;
        boolean firstName = getValues != null ? getValues.isFirstname() : true;
        boolean lastName = getValues != null ? getValues.isLastname() : true;
        boolean nickName = getValues != null ? getValues.isNickname() : true;
        boolean gender = getValues != null ? getValues.isGender() : true;
        boolean birthDay = getValues != null ? getValues.isBirthday() : true;
        boolean age = getValues != null ? getValues.isAge() : true;
        boolean accType = getValues != null ? getValues.isAccounttype() : true;
        boolean isChange = false;
        switch (option) {
            case "accpic":
                if (accPic) {
                    isChange = true;
                }
                accPic = false;
                break;
            case "displayname":
                if (disName) {
                    isChange = true;
                }
                disName = false;
                break;
            case "firstname":
                if (firstName) {
                    isChange = true;
                }
                firstName = false;
                break;
            case "lastname":
                if (lastName) {
                    isChange = true;
                }
                lastName = false;
                break;
            case "nickname":
                if (nickName) {
                    isChange = true;
                }
                nickName = false;
                break;
            case "gender":
                if (gender) {
                    isChange = true;
                }
                gender = false;
                break;
            case "birthday":
                if (birthDay) {
                    isChange = true;
                }
                birthDay = false;
                break;
            case "age":
                if (age) {
                    isChange = true;
                }
                age = false;
                break;
            case "acctype":
                if (accType) {
                    isChange = true;
                }
                accType = false;
                break;
        }
        if ((getValues == null) || (isChange)) {
            Showhideinfo insertData = new Showhideinfo(user, checkCookie.getDevice(request.getCookies()), getValues != null ? getValues.isMoreinfo() : true, getValues != null ? getValues.isEditinfo() : true, getValues != null ? getValues.isSetting() : true, getValues != null ? getValues.isSecurity() : true, accPic, getValues != null ? getValues.isEdaccpic() : true, getValues != null ? getValues.isUploadnew() : true, disName, firstName, lastName, nickName, gender, birthDay, age, accType, getValues != null ? getValues.isShowhide() : true);
            hideOption.InfoOptions(insertData);
        }
        return "redirect:../../";
    }

    @RequestMapping(value = "/info/edit/hide/{option}/", method = RequestMethod.GET)
    public String HideOptionEdit(@PathVariable("option") String option, HttpServletRequest request, HttpServletResponse response) {
        if (!option.matches("^(firstname|lastname|nickname|gender|birthday|age|acctype)$")) {
            throw new ResourceNotFoundException();
        }
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../../../login/";
        }
        ShowHideInfoOpt hideOption = new ShowHideInfoOpt();
        Showhideeditinfo getValues = hideOption.getEditInfoOptions(user);
        boolean firstName = getValues != null ? getValues.isFirstname() : true;
        boolean lastName = getValues != null ? getValues.isLastname() : true;
        boolean nickName = getValues != null ? getValues.isNickname() : true;
        boolean gender = getValues != null ? getValues.isGender() : true;
        boolean birthDay = getValues != null ? getValues.isBirthday() : true;
        boolean age = getValues != null ? getValues.isAge() : true;
        boolean accType = getValues != null ? getValues.isAccounttype() : true;
        boolean isChange = false;
        switch (option) {
            case "firstname":
                if (firstName) {
                    isChange = true;
                }
                firstName = false;
                break;
            case "lastname":
                if (lastName) {
                    isChange = true;
                }
                lastName = false;
                break;
            case "nickname":
                if (nickName) {
                    isChange = true;
                }
                nickName = false;
                break;
            case "gender":
                if (gender) {
                    isChange = true;
                }
                gender = false;
                break;
            case "birthday":
                if (birthDay) {
                    isChange = true;
                }
                birthDay = false;
                break;
            case "age":
                if (age) {
                    isChange = true;
                }
                age = false;
                break;
            case "acctype":
                if (accType) {
                    isChange = true;
                }
                accType = false;
                break;
        }
        if ((getValues == null) || (isChange)) {
            Showhideeditinfo insertData = new Showhideeditinfo(user, checkCookie.getDevice(request.getCookies()), getValues != null ? getValues.isInfo() : true, getValues != null ? getValues.isMoreinfo() : true, getValues != null ? getValues.isSetting() : true, getValues != null ? getValues.isSecurity() : true, getValues != null ? getValues.isLastsaved() : true, firstName, lastName, nickName, gender, birthDay, age, accType, getValues != null ? getValues.isShowhide() : true);
            hideOption.EditInfoOptions(insertData);
        }
        return "redirect:../../";
    }

    @RequestMapping(value = "/info/options/restore/", method = RequestMethod.GET)
    public String OptionInfoRestore(HttpServletRequest request, HttpServletResponse response) {
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../../login/";
        }
        ShowHideInfoOpt hideOption = new ShowHideInfoOpt();
        Showhideinfo getValues = hideOption.getInfoOptions(user);
        if (getValues == null) {
            return "redirect:../../";
        }
        boolean isChange = ((getValues.isMoreinfo() != true) || (getValues.isEditinfo() != true) || (getValues.isSetting() != true) || (getValues.isSecurity() != true) || (getValues.isAccpic() != true) || (getValues.isEdaccpic() != true) || (getValues.isUploadnew() != true) || (getValues.isDisplayname() != true) || (getValues.isFirstname() != true) || (getValues.isLastname() != true) || (getValues.isNickname() != true) || (getValues.isGender() != true) || (getValues.isBirthday() != true) || (getValues.isAge() != true) || (getValues.isAccounttype() != true) || (getValues.isShowhide() != true));
        if (isChange) {
            Showhideinfo insertData = new Showhideinfo(user, checkCookie.getDevice(request.getCookies()), true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true);
            hideOption.InfoOptions(insertData);
        }
        return "redirect:../../";
    }

    @RequestMapping(value = "/info/edit/options/restore/", method = RequestMethod.GET)
    public String OptionEditInfoRestore(HttpServletRequest request, HttpServletResponse response) {
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../../../login/";
        }
        ShowHideInfoOpt hideOption = new ShowHideInfoOpt();
        Showhideeditinfo getValues = hideOption.getEditInfoOptions(user);
        if (getValues == null) {
            return "redirect:../../";
        }
        boolean isChange = ((getValues.isInfo() != true) || (getValues.isMoreinfo() != true) || (getValues.isSetting() != true) || (getValues.isSecurity() != true) || (getValues.isLastsaved() != true) || (getValues.isFirstname() != true) || (getValues.isLastname() != true) || (getValues.isNickname() != true) || (getValues.isGender() != true) || (getValues.isBirthday() != true) || (getValues.isAge() != true) || (getValues.isAccounttype() != true) || (getValues.isShowhide() != true));
        if (isChange) {
            Showhideeditinfo insertData = new Showhideeditinfo(user, checkCookie.getDevice(request.getCookies()), true, true, true, true, true, true, true, true, true, true, true, true, true);
            hideOption.EditInfoOptions(insertData);
        }
        return "redirect:../../";
    }

}
