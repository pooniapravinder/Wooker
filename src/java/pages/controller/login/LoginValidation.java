package pages.controller.login;

import hibernate.mapping.Accounts;
import hibernate.query.InsertInvalidLogin;
import hibernate.query.RegistrationQuery;
import java.util.regex.Pattern;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import password.encryption.decryption.SCryptUtil;

@Component
public class LoginValidation implements Validator {
     
    @Override
    public boolean supports(Class<?> clazz) {
        return Loginuser.class.isAssignableFrom(clazz);
    }
    
    @Override
    public void validate(Object target, Errors errors) {
        Loginuser userInput = (Loginuser)target;
        Pattern PhonePattern = Pattern.compile("^\\+(((99|97|96|89|88|87|85|83|80|69|68|67|59|50|42|38|37|35|29|28|26|25|24|23|22|21)[0-9]{1})|98|95|94|93|92|91|90|86|84|82|81|66|65|64|63|62|61|60|58|57|56|55|54|53|52|51|49|48|47|46|45|44|43|41|40|39|36|34|33|32|31|30|27|20|7|1)[0-9]{6,14}$");
        Pattern  EmailPattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,4})$");
        if((userInput.getEmailphone()==null)||(userInput.getEmailphone().isEmpty())) {
            errors.rejectValue("Emailphone","login.label.emptyfield");
        }else if((!PhonePattern.matcher(userInput.getEmailphone()).matches())&&(!EmailPattern.matcher(userInput.getEmailphone()).matches())) {
            userInput.setEmailphone(null);
            errors.rejectValue("Emailphone","login.label.invalidfield");
        }else{
            long current_timestamp = System.currentTimeMillis();
            RegistrationQuery verifylogin = new RegistrationQuery();
            Accounts userlogin = verifylogin.findAccount(userInput.getEmailphone());
            if(userlogin==null) {
                errors.rejectValue("Emailphone","login.label.invalidaccount");
            }else{
                boolean isAuthenticated = ((userInput.getPassword()!=null)&&(!userInput.getPassword().isEmpty())) ? SCryptUtil.check(userInput.getPassword(),userlogin.getPassword()) : false;
                boolean isVerified = userlogin.isVerifiedAccount();
                InsertInvalidLogin loginfailed = new InsertInvalidLogin();
                boolean isExceed = loginfailed.isExceed(userlogin.getUserId(),current_timestamp-86400000);
                userInput.setId(userlogin.getUserId());
                if(((userInput.getPassword()==null)||(userInput.getPassword().isEmpty()))||(!isAuthenticated)&&(!isExceed)) {
                    if((userInput.getPassword()!=null)&&(!userInput.getPassword().isEmpty())) userInput.setInvalidLogin(true);
                    errors.rejectValue("Emailphone","login.label.invalidpassword");
                }else if((!isAuthenticated)&&(isExceed)&&(userInput.getPassword()!=null)&&(!userInput.getPassword().isEmpty())) {
                    userInput.setExceed(true);
                }else if((isAuthenticated)&&(isVerified)) {
                    userInput.setVerified(true);
                }
            }
        }
    }

}