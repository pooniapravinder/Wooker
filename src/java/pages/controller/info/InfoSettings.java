package pages.controller.info;

import cookies.set.get.CheckSaveCookies;
import hibernate.mapping.Showhideeditinfo;
import hibernate.mapping.Showhideinfo;
import hibernate.query.info.ShowHideInfoOpt;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InfoSettings {

    @RequestMapping(value = "/info/settings/", method = RequestMethod.GET)
    public String InfoSettingsView(Model model, HttpServletRequest request, HttpServletResponse response) {
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../login/";
        }
        ShowHideInfoOpt getData = new ShowHideInfoOpt();
        Showhideinfo getOption = getData.getInfoOptions(user);
        Upinfosettings UpSettings = new Upinfosettings(getOption);
        model.addAttribute("upinfosettings", UpSettings);
        return "settings/info";
    }

    @RequestMapping(value = "/info/edit/settings/", method = RequestMethod.GET)
    public String EditInfoSettingsView(Model model, HttpServletRequest request, HttpServletResponse response) {
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../../login/";
        }
        ShowHideInfoOpt getData = new ShowHideInfoOpt();
        Showhideeditinfo getOption = getData.getEditInfoOptions(user);
        Upeditinfosettings UpSettings = new Upeditinfosettings(getOption);
        model.addAttribute("upeditinfosettings", UpSettings);
        return "settings/editinfo";
    }

    @RequestMapping(value = "/info/settings/", method = RequestMethod.POST)
    public String InfoSettingsSubmit(Upinfosettings UpSettings, HttpServletRequest request, HttpServletResponse response) {
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../login/";
        }
        ShowHideInfoOpt getData = new ShowHideInfoOpt();
        Showhideinfo getOption = getData.getInfoOptions(user);
        boolean secInfo = UpSettings.getSecInfo() != null;
        boolean edPrInfo = UpSettings.getEdPrInfo() != null;
        boolean settings = UpSettings.getSettings() != null;
        boolean security = UpSettings.getSecurity() != null;
        boolean accPic = UpSettings.getAccPic() != null;
        boolean edAccPic = UpSettings.getEdAccPic() != null;
        boolean upNew = UpSettings.getUpNew() != null;
        boolean disName = UpSettings.getDisName() != null;
        boolean firName = UpSettings.getFirName() != null;
        boolean lasName = UpSettings.getLasName() != null;
        boolean nicName = UpSettings.getNicName() != null;
        boolean gender = UpSettings.getGender() != null;
        boolean birthDay = UpSettings.getBirthDay() != null;
        boolean age = UpSettings.getAge() != null;
        boolean account = UpSettings.getAccount() != null;
        boolean showHide = UpSettings.getShowHide() != null;
        boolean isChange = ((getOption==null) || (secInfo != getOption.isMoreinfo()) || (edPrInfo != getOption.isEditinfo()) || (settings != getOption.isSetting()) || (security != getOption.isSecurity()) || (accPic != getOption.isAccpic()) || (edAccPic != getOption.isEdaccpic()) || (upNew != getOption.isUploadnew()) || (disName != getOption.isDisplayname()) || (firName != getOption.isFirstname()) || (lasName != getOption.isLastname()) || (nicName != getOption.isNickname()) || (gender != getOption.isGender()) || (birthDay != getOption.isBirthday()) || (age != getOption.isAge()) || (account != getOption.isAccounttype()) || (showHide != getOption.isShowhide()));
        if (isChange) {
            Showhideinfo insertOption = new Showhideinfo(user, checkCookie.getDevice(request.getCookies()), secInfo, edPrInfo, settings, security, accPic, edAccPic, upNew, disName, firName, lasName, nicName, gender, birthDay, age, account, showHide);
            getData.InfoOptions(insertOption);
        }
        return "redirect:../";
    }

    @RequestMapping(value = "/info/edit/settings/", method = RequestMethod.POST)
    public String EditInfoSettingsSubmit(Upeditinfosettings UpSettings, HttpServletRequest request, HttpServletResponse response) {
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../../login/";
        }
        ShowHideInfoOpt getData = new ShowHideInfoOpt();
        Showhideeditinfo getOption = getData.getEditInfoOptions(user);
        boolean prInfo = UpSettings.getPrInfo() != null;
        boolean secInfo = UpSettings.getSecInfo() != null;
        boolean settings = UpSettings.getSettings() != null;
        boolean security = UpSettings.getSecurity() != null;
        boolean lasSaved = UpSettings.getLasChanged() != null;
        boolean firName = UpSettings.getFirName() != null;
        boolean lasName = UpSettings.getLasName() != null;
        boolean nicName = UpSettings.getNicName() != null;
        boolean gender = UpSettings.getGender() != null;
        boolean birthDay = UpSettings.getBirthDay() != null;
        boolean age = UpSettings.getAge() != null;
        boolean account = UpSettings.getAccount() != null;
        boolean showHide = UpSettings.getShowHide() != null;
        boolean isChange = ((getOption==null) || (prInfo != getOption.isInfo()) || (secInfo != getOption.isMoreinfo()) || (settings != getOption.isSetting()) || (security != getOption.isSecurity()) || (lasSaved != getOption.isLastsaved()) || (firName != getOption.isFirstname()) || (lasName != getOption.isLastname()) || (nicName != getOption.isNickname()) || (gender != getOption.isGender()) || (birthDay != getOption.isBirthday()) || (age != getOption.isAge()) || (account != getOption.isAccounttype()) || (showHide != getOption.isShowhide()));
        if (isChange) {
            Showhideeditinfo insertOption = new Showhideeditinfo(user, checkCookie.getDevice(request.getCookies()), prInfo, secInfo, settings, security, lasSaved, firName, lasName, nicName, gender, birthDay, age, account, showHide);
            getData.EditInfoOptions(insertOption);
        }
        return "redirect:../";
    }

}
