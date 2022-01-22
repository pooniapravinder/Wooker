package pages.controller.accountverify;

import Random.String.Generator.RandomString;
import cookies.set.get.CheckSaveCookies;
import email.phone.otp.SendVerifyCode;
import hibernate.mapping.Devicedetails;
import hibernate.mapping.Online;
import hibernate.mapping.Otpcode;
import hibernate.mapping.Tokens;
import hibernate.query.GetUser;
import hibernate.query.OnlineUser;
import hibernate.query.info.InfoAction;
import hibernate.query.RegistrationQuery;
import hibernate.query.TokensData;
import hibernate.query.UserOTP;
import java.util.Random;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletResponse;
import pages.controller.home.CurrentUser;

@Controller
public class AccountVerify {

    @RequestMapping(value = "/verify/account/", method = RequestMethod.GET)
    public String AccountConfirmView() {
        return "errors/InvalidPage";
    }

    @RequestMapping(value = "/verify/account/", method = RequestMethod.POST)
    public String AccountConfirmSubmit(Verifyaccount userInput, HttpServletRequest request, HttpServletResponse response) {
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getVerifyCookie(request, response);
        if (checkCookie.getCookie(request, response) != 0) {
            return "redirect:../../home/";
        } else if ((user) == 0) {
            return "redirect:../../login/";
        }
        long current_timestamp = System.currentTimeMillis();
        RandomString getRandom = new RandomString();
        TokensData getTokens = new TokensData();
        boolean isValidToken = ((userInput.getRnlm() != null) && (userInput.getRnlm().matches("^([a-zA-Z0-9-_]{25000})$"))) ? getTokens.isValidToken(user, userInput.getRnlm(), current_timestamp - 900000) : false;
        if ((!isValidToken)) {
            return "errors/InvalidPage";
        }
        String token = getRandom.RandomString(25000);
        Tokens setToken = new Tokens(user, token, false, current_timestamp);
        getTokens.InsertToken(setToken);
        userInput.setRnlm(token);
        userInput.setLogoutId(CurrentUser.getLogoutValue());
        UserOTP getOTP = new UserOTP();
        GetUser getQuery = new GetUser();
        Otpcode OTPCode = getOTP.GetOTP(user);
        String EmailPhone = getQuery.getUserbyId(user).getEmailidPhone();
        if ((userInput.getVerify() != null) && (OTPCode != null)) {
            int PostCode = (userInput.getVerifycode() != null) && (userInput.getVerifycode().matches("^\\d{6}$")) ? Integer.parseInt(userInput.getVerifycode()) : 0;
            if (OTPCode.getAttempts() > 4) {
                userInput.setVerify(null);
                userInput.setErrors("accountverify.label.otpinvalid");
            } else if (OTPCode.getSetTimestamp() < current_timestamp - 600000) {
                userInput.setVerify(null);
                userInput.setErrors("accountverify.label.otpexpired");
            } else if ((OTPCode.getVerifyCode()) != (PostCode)) {
                userInput.setVerify(null);
                userInput.setVerify("submit");
                if (PostCode != 0) {
                    getOTP.updateAttempts(user);
                }
                if (userInput.getVerifycode() != null) {
                    userInput.setErrors("accountverify.label.incorrectotp");
                }
            } else if ((OTPCode.getVerifyCode()) == (PostCode)) {
                OnlineUser online = new OnlineUser();
                Online saveOnline = new Online(user,current_timestamp);
                getOTP.AccountVerifySuccess(user);
                online.insertOnline(saveOnline);
                return "redirect:../../account/pic/upload/";
            }
        } else if (userInput.getChange() != null) {
            Pattern PhonePattern = Pattern.compile("^([\\+0-9]){10,13}$");
            Pattern EmailPattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,4})$");
            RegistrationQuery GetResult = new RegistrationQuery();
            boolean isVerified = GetResult.findAccount(userInput.getEmailphone()) != null ? GetResult.findAccount(userInput.getEmailphone()).isVerifiedAccount() : false;
            if ((userInput.getEmailphone() == null) || (userInput.getEmailphone().isEmpty())) {
                userInput.setErrors("user.emailidphone.emptyfield");
            } else if ((!EmailPattern.matcher(userInput.getEmailphone()).matches()) && (!PhonePattern.matcher(userInput.getEmailphone()).matches())) {
                userInput.setErrors("user.emailidphone.invalid");
            } else if (userInput.getEmailphone().length() > 50) {
                userInput.setErrors("user.emailid.invalidlength");
            } else if (isVerified) {
                userInput.setErrors("user.account.exists");
            } else if (!userInput.getEmailphone().equals(EmailPhone)) {
                userInput.setChange(null);
                userInput.setSendCode("submit");
                GetResult.UpdateEmailPhone(userInput.getEmailphone(), user);
                InfoAction updateInfo = new InfoAction();
                updateInfo.UpdateEmailPhone(userInput.getEmailphone(), user);
                Devicedetails SaveDevice = new Devicedetails();
                SaveDevice.getDeviceInfo(request, null);
                checkCookie.setCookie(response, request, user, userInput.getEmailphone(), null, SaveDevice.getClientIp());
                EmailPhone = userInput.getEmailphone();
                userInput.setSuccess("accountverify.label.updated");
            }
        } else if ((userInput.getSendCode()) != null) {
            if ((!EmailPhone.equals(userInput.getEmailphone()))) {
                userInput.setErrors("accountverify.label.userchange");
            } else {
                userInput.setVerify("submit");
                Random random = new Random();
                SendVerifyCode senderOTP = new SendVerifyCode();
                if (OTPCode != null) {
                    senderOTP.sendOTP(user, EmailPhone, (100000 + random.nextInt(900000)), true);
                } else {
                    senderOTP.sendOTP(user, EmailPhone, (100000 + random.nextInt(900000)), false);
                }
            }
        } else if ((userInput.getCallCode()) != null) {
            if ((!EmailPhone.equals(userInput.getEmailphone()))) {
                userInput.setErrors("accountverify.label.userchange");
            } else if (EmailPhone.contains("@")) {
                userInput.setErrors("accountverify.label.invalidphone");
            } else {
                userInput.setVerify("submit");
                Random random = new Random();
                SendVerifyCode senderOTP = new SendVerifyCode();
                if (OTPCode != null) {
                    senderOTP.sendCallOTP(user, EmailPhone, (100000 + random.nextInt(900000)), true);
                } else {
                    senderOTP.sendCallOTP(user, EmailPhone, (100000 + random.nextInt(900000)), false);
                }
            }
        }
        if (EmailPhone.contains("@")) {
            userInput.setEmail(EmailPhone);
        } else {
            userInput.setPhone(EmailPhone);
        }
        userInput.setEmailphone(EmailPhone);
        return "AccountVerify";
    }

}
