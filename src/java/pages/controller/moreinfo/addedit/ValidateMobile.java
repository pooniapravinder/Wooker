package pages.controller.moreinfo.addedit;

import java.util.regex.Pattern;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ValidateMobile implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Addmobile.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Addmobile userInput = (Addmobile) target;
        Pattern PhonePattern = Pattern.compile("^([\\+0-9]){10,13}$");
        if ((userInput.getMobile() == null) || (userInput.getMobile().isEmpty())) {
            errors.rejectValue("mobile", "user.mobile.emptyfield");
        } else if (!PhonePattern.matcher(userInput.getMobile()).matches()) {
            errors.rejectValue("mobile", "user.mobile.invalid");
        }
        if ((userInput.getMobtyp() == null) || (!userInput.getMobtyp().matches("^([1-7])$"))) {
            userInput.setMobtyp("1");
        }
        if ((userInput.getMobpri() == null) || (!userInput.getMobpri().matches("^([1-6])$"))) {
            userInput.setMobpri("2");
        }
        if ((userInput.getMobdesc() != null) && (userInput.getMobdesc().length() > 100)) {
            errors.rejectValue("mobdesc", "user.description.invalidlength");
        }
    }

}