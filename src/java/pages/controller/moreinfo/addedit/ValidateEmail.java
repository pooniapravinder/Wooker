package pages.controller.moreinfo.addedit;

import java.util.regex.Pattern;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ValidateEmail implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Addemail.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Addemail userInput = (Addemail) target;
        Pattern EmailPattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,4})$");
        if ((userInput.getEmail() == null) || (userInput.getEmail().isEmpty())) {
            errors.rejectValue("email", "user.email.emptyfield");
        } else if (!EmailPattern.matcher(userInput.getEmail()).matches()) {
            errors.rejectValue("email", "user.email.invalid");
        } else if (userInput.getEmail().length() > 50) {
            errors.rejectValue("email", "user.email.invalidlength");
        }
        if ((userInput.getEmatyp() == null) || (!userInput.getEmatyp().matches("^([1-5])$"))) {
            userInput.setEmatyp("1");
        }
        if ((userInput.getEmapri() == null) || (!userInput.getEmapri().matches("^([1-6])$"))) {
            userInput.setEmapri("2");
        }
        if ((userInput.getEmadesc() != null) && (userInput.getEmadesc().length() > 100)) {
            errors.rejectValue("emadesc", "user.description.invalidlength");
        }
    }

}
