package pages.controller.signup;

import Random.String.Generator.RandomString;
import cookies.set.get.CheckSaveCookies;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import hibernate.mapping.Accounts;
import hibernate.mapping.Devicedetails;
import hibernate.mapping.Primaryinfo;
import hibernate.mapping.Tokens;
import hibernate.query.info.InfoAction;
import hibernate.query.RegistrationQuery;
import hibernate.query.TokensData;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import password.encryption.decryption.SCryptUtil;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Register {

    @Autowired
    SignupValidation validation;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.setValidator(validation);
    }

    @RequestMapping(value = "/signup/", method = RequestMethod.GET)
    public String RegisterView(@RequestParam(value = "lang", required = false) String pstLocale, Addaccount setModel, Model model, HttpServletRequest request, HttpServletResponse response) {
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        if ((checkCookie.getCookie(request, response)) == 0) {
            setModel.setLang(checkCookie.getLocale(pstLocale, request.getCookies()));
            model.addAttribute("addaccount", setModel);
            return "signup";
        }
        return "redirect:../home/";
    }

    @RequestMapping(value = "/signup/", method = RequestMethod.POST)
    public String RegisterSubmit(@RequestParam(value = "lang", required = false) String pstLocale, @Valid Addaccount Input, BindingResult results, Model model, HttpServletRequest request, HttpServletResponse response) {
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        if ((checkCookie.getCookie(request, response)) != 0) {
            return "redirect:../home/";
        } else if (results.hasErrors()) {
            Input.setLang(checkCookie.getLocale(pstLocale, request.getCookies()));
            model.addAttribute("addaccount", Input);
            return "signup";
        }
        RegistrationQuery AddUser = new RegistrationQuery();
        InfoAction Info = new InfoAction();
        long current_timestamp = System.currentTimeMillis();
        String birthDay = Input.getMonth() + "/" + Input.getDate() + "/" + Input.getYear();
        String SecurePassword = SCryptUtil.scrypt(Input.getPassword(), 16, 16, 16);
        Random random = new Random();
        String device_id = current_timestamp + "_" + (100000 + random.nextInt(900000));
        Devicedetails GetDevice = new Devicedetails();
        GetDevice.getDeviceInfo(request, device_id);
        long userId;
        if (!Input.isExistUser()) {
            byte val = 0;
            byte val1 = 1;
            byte val2 = 2;
            byte val3 = 3;
            Accounts SaveAccount = new Accounts(device_id, current_timestamp, false, false, Input.getCountry(), Input.getEmailidPhone(), SecurePassword);
            AddUser.addAccount(SaveAccount);
            userId = AddUser.findAccount(Input.getEmailidPhone()).getUserId();
            checkCookie.setCookie(response, request, userId, Input.getEmailidPhone(), device_id, GetDevice.getClientIp());
            Primaryinfo saveInfo = new Primaryinfo(userId, device_id, "", 0, val, "", 0, val, false, Input.getFirstName(), Input.getLastName(), "", val1, val2, Input.getGender(), val3, birthDay, val3, val3, val3, val2, Input.getEmailidPhone(), val1, current_timestamp);
            Info.addPrimaryInfo(saveInfo);
        } else {
            userId = AddUser.findAccount(Input.getEmailidPhone()).getUserId();
            AddUser.UpdateAccount(current_timestamp, Input.getCountry(), Input.getEmailidPhone(), SecurePassword);
            Info.UpdatePrimaryInfo(Input.getFirstName(), Input.getLastName(), Input.getGender(), birthDay, Input.getEmailidPhone(), current_timestamp, userId);
            Info.UpdateDeviceInfo(GetDevice,AddUser.findAccount(Input.getEmailidPhone()).getDeviceId());
            checkCookie.setCookie(response, request, userId, Input.getEmailidPhone(), device_id, GetDevice.getClientIp());
        }
        RandomString getRandom = new RandomString();
        TokensData InsertToken = new TokensData();
        String token = getRandom.RandomString(25000);
        Tokens setToken = new Tokens(userId, token, false, current_timestamp);
        InsertToken.InsertToken(setToken);
        request.setAttribute("token_value", token);
        return "postredirect/AccountVerify";
    }

}
