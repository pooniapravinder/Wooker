package pages.controller.login;

import Random.String.Generator.RandomString;
import cookies.set.get.CheckSaveCookies;
import hibernate.mapping.Devicedetails;
import hibernate.mapping.Invalidlogin;
import hibernate.mapping.Primaryinfo;
import hibernate.mapping.Tokens;
import hibernate.query.InsertInvalidLogin;
import hibernate.query.TokensData;
import hibernate.query.info.InfoAction;
import java.util.Random;
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
import org.springframework.web.bind.annotation.RequestParam;
import pages.controller.home.CurrentUser;

@Controller
public class LoginCheck {

    @Autowired
    LoginValidation validation;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.setValidator(validation);
    }

    @RequestMapping(value = "/login/", method = RequestMethod.GET)
    public String LoginCheckView(@RequestParam(value = "lang", required = false) String pstLocale, Loginuser setModel, Model model, HttpServletRequest request, HttpServletResponse response) {
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        if ((checkCookie.getCookie(request, response)) != 0) {
            return "redirect:../home/";
        }
        InfoAction getData = new InfoAction();
        Primaryinfo getInfo = getData.getPriInfo(CurrentUser.getUserId());
        if (getInfo != null) {
            setModel.setEmailphone(getInfo.getEmailidPhone());
        }
        setModel.setLang(checkCookie.getLocale(pstLocale, request.getCookies()));
        model.addAttribute("loginuser", setModel);
        return "login";
    }

    @RequestMapping(value = "/login/", method = RequestMethod.POST)
    public String LoginCheckSubmit(@RequestParam(value = "lang", required = false) String pstLocale, @Valid Loginuser Input, BindingResult results, Model model, HttpServletRequest request, HttpServletResponse response) {
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        if ((checkCookie.getCookie(request, response)) != 0) {
            return "redirect:../home/";
        }
        long current_timestamp = System.currentTimeMillis();
        Random random = new Random();
        String device_id = current_timestamp + "_" + (100000 + random.nextInt(900000));
        Devicedetails SaveDevice = new Devicedetails();
        SaveDevice.getDeviceInfo(request, device_id);
        if ((Input.isExceed()) || (Input.isInvalidLogin())) {
            InsertInvalidLogin loginfailed = new InsertInvalidLogin();
            Invalidlogin values = new Invalidlogin(device_id, Input.getId(), current_timestamp);
            loginfailed.InsertUser(values);
        } else if (!results.hasErrors()) {
            checkCookie.setCookie(response, request, Input.getId(), Input.getEmailphone(), device_id, SaveDevice.getClientIp());
            if (Input.isVerified()) {
                return "redirect:../home/";
            }
            RandomString getRandom = new RandomString();
            TokensData InsertToken = new TokensData();
            String token = getRandom.RandomString(25000);
            Tokens setToken = new Tokens(Input.getId(), token, false, current_timestamp);
            InsertToken.InsertToken(setToken);
            request.setAttribute("token_value", token);
            return "postredirect/AccountVerify";
        }
        Input.setLang(checkCookie.getLocale(pstLocale, request.getCookies()));
        model.addAttribute("loginuser", Input);
        return "login";
    }

}
