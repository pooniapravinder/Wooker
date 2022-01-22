package pages.controller.info;

import cookies.set.get.CheckSaveCookies;
import hibernate.mapping.Primaryinfo;
import hibernate.query.info.InfoAction;
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

@Controller
public class EditInfoHandler {

    @Autowired
    InfoValidation validation;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.setValidator(validation);
    }

    @RequestMapping(value = "/info/edit/", method = RequestMethod.GET)
    public String EditInfoview(Model model, HttpServletRequest request, HttpServletResponse response) {
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../login/";
        }
        InfoAction getData = new InfoAction();
        Primaryinfo getInfo = getData.getPriInfo(user);
        Editinfo set_data = new Editinfo(getInfo);
        Object getExceed = getData.getInfoUpdate(user);
        long time = (getExceed != null) ? (long) ((Object[]) getExceed)[1] : 0;
        long cal = (getExceed != null) ? System.currentTimeMillis() - 2592000000L * ((long) ((Object[]) getExceed)[0]) : 0;
        long cal2 = (getExceed != null) ? (long) ((Object[]) getExceed)[0] : 0;
        if (time > cal) {
            set_data.setExceedUpdate(true);
            set_data.setExceedTime((time - cal) / 1000 / 60 / 60 / 24 + 1);
        } else {
            set_data.setExceedTime((cal2 + 1) * 30);
        }
        model.addAttribute("editinfo", set_data);
        return "editinfo";
    }

    @RequestMapping(value = "/info/edit/", method = RequestMethod.POST)
    public String EditInfosubmit(@Valid Editinfo userInput, BindingResult results, HttpServletRequest request, Model model, HttpServletResponse response) {
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../login/";
        }
        InfoAction getData = new InfoAction();
        Primaryinfo getInfo = getData.getPriInfo(user);
        Object getExceed = getData.getInfoUpdate(user);
        long time = (getExceed != null) ? (long) ((Object[]) getExceed)[1] : 0;
        long cal = (getExceed != null) ? System.currentTimeMillis() - 2592000000L * ((long) ((Object[]) getExceed)[0]) : 0;
        long cal2 = (getExceed != null) ? (long) ((Object[]) getExceed)[0] : 0;
        if (time > cal) {
            userInput.setExceedUpdate(true);
            userInput.setExceedTime((time - cal) / 1000 / 60 / 60 / 24 + 1);
        } else {
            userInput.setExceedTime((cal2 + 1) * 30);
        }
        if ((results.hasErrors()) && (!userInput.isExceedUpdate())) {
            userInput.setTimestampVal(getInfo.getTimestampVal());
            userInput.setAccountType(getInfo.getEmailidPhone());
            model.addAttribute("editinfo", userInput);
            return "editinfo";
        }
        String match = "^([1-6])$";
        byte combination = (userInput.getCombination() != null) && (userInput.getCombination().matches("^([1-3])$")) ? Byte.parseByte(userInput.getCombination()) : getInfo.getNicknameCombination();
        byte nicknamePrivacy = (userInput.getNickPrivacy() != null) && (userInput.getNickPrivacy().matches(match)) ? Byte.parseByte(userInput.getNickPrivacy()) : getInfo.getNicknamePrivacy();
        byte GenderPrivacy = (userInput.getGenPrivacy() != null) && (userInput.getGenPrivacy().matches(match)) ? Byte.parseByte(userInput.getGenPrivacy()) : getInfo.getGenderPrivacy();
        byte MonthPrivacy = (userInput.getMonthPrivacy() != null) && (userInput.getMonthPrivacy().matches(match)) ? Byte.parseByte(userInput.getMonthPrivacy()) : getInfo.getMonthPrivacy();
        byte DatePrivacy = (userInput.getDatePrivacy() != null) && (userInput.getDatePrivacy().matches(match)) ? Byte.parseByte(userInput.getDatePrivacy()) : getInfo.getDatePrivacy();
        byte YearPrivacy = (userInput.getYearPrivacy() != null) && (userInput.getYearPrivacy().matches(match)) ? Byte.parseByte(userInput.getYearPrivacy()) : getInfo.getYearPrivacy();
        byte AgePrivacy = (userInput.getAgePrivacy() != null) && (userInput.getAgePrivacy().matches(match)) ? Byte.parseByte(userInput.getAgePrivacy()) : getInfo.getAgePrivacy();
        byte AccountPrivacy = (userInput.getAccPrivacy() != null) && (userInput.getAccPrivacy().matches(match)) ? Byte.parseByte(userInput.getAccPrivacy()) : getInfo.getAccountPrivacy();
        long current_timestamp = System.currentTimeMillis();
        String month = userInput.getBirthMonth() != null ? userInput.getBirthMonth() : getInfo.getBirthDay().split("/")[0];
        String date = userInput.getBirthDate() != null ? userInput.getBirthDate() : getInfo.getBirthDay().split("/")[1];
        String year = userInput.getBirthYear() != null ? userInput.getBirthYear() : getInfo.getBirthDay().split("/")[2];
        String birthDay = month + "/" + date + "/" + year;
        String deviceId = checkCookie.getDevice(request.getCookies());
        boolean isChange = ((getInfo.getNicknameCombination() != combination) || (getInfo.getNicknamePrivacy() != nicknamePrivacy) || (getInfo.getGenderPrivacy() != GenderPrivacy) || (getInfo.getMonthPrivacy() != MonthPrivacy) || (getInfo.getDatePrivacy() != DatePrivacy) || (getInfo.getYearPrivacy() != YearPrivacy) || (getInfo.getAgePrivacy() != AgePrivacy) || (getInfo.getAccountPrivacy() != AccountPrivacy));
        boolean isPriChange = (((userInput.getFirstName() != null) && (!getInfo.getFirstName().equals(userInput.getFirstName()))) || ((userInput.getLastName() != null) && (!getInfo.getLastName().equals(userInput.getLastName()))) || ((userInput.getNickName() != null) && (!getInfo.getNickName().equals(userInput.getNickName()))) || ((userInput.getGender() != null) && (!getInfo.getGender().equals(userInput.getGender()))) || ((birthDay != null) && (!getInfo.getBirthDay().equals(birthDay)))) && (!userInput.isExceedUpdate());
        if (isPriChange) {
            Primaryinfo saveInfo = new Primaryinfo(user, deviceId, getInfo.getPrisecurPass(), getInfo.getPrisecurTstmp(), getInfo.getPrisecurAttempt(), getInfo.getEdprisecurPass(), getInfo.getEdprisecurTstmp(), getInfo.getEdprisecurAttempt(), isPriChange, userInput.getFirstName() != null ? userInput.getFirstName() : getInfo.getFirstName(), userInput.getLastName() != null ? userInput.getLastName() : getInfo.getLastName(), userInput.getNickName() != null ? userInput.getNickName() : getInfo.getNickName(), combination, nicknamePrivacy, userInput.getGender() != null ? userInput.getGender() : getInfo.getGender(), GenderPrivacy, birthDay != null ? birthDay : getInfo.getBirthDay(), MonthPrivacy, DatePrivacy, YearPrivacy, AgePrivacy, getInfo.getEmailidPhone(), AccountPrivacy, current_timestamp);
            getData.addPrimaryInfo(saveInfo);
        } else if (isChange) {
            Primaryinfo saveInfo = new Primaryinfo(user, deviceId, getInfo.getPrisecurPass(), getInfo.getPrisecurTstmp(), getInfo.getPrisecurAttempt(), getInfo.getEdprisecurPass(), getInfo.getEdprisecurTstmp(), getInfo.getEdprisecurAttempt(), false, getInfo.getFirstName(), getInfo.getLastName(), getInfo.getNickName(), combination, nicknamePrivacy, getInfo.getGender(), GenderPrivacy, getInfo.getBirthDay(), MonthPrivacy, DatePrivacy, YearPrivacy, AgePrivacy, getInfo.getEmailidPhone(), AccountPrivacy, current_timestamp);
            getData.addPrimaryInfo(saveInfo);
        }
        return "redirect:../../info/";
    }
}
