package pages.controller.moreinfo.addedit;

import java.util.regex.Pattern;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ValidateNewCatg implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Addnewcatg.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Addnewcatg userInput = (Addnewcatg) target;
        Pattern imagePattern = Pattern.compile("^image/([jpg|jpeg|png|bmp]+)$");

        if ((userInput.getNewcatgnam() == null) || (userInput.getNewcatgnam().isEmpty())) {
            errors.rejectValue("newcatgnam", "user.newcatgnam.emptyfield");
        } else if ((userInput.getNewcatgnam().length() < 3) || (userInput.getNewcatgnam().length() > 20)) {
            errors.rejectValue("newcatgnam", "user.newcatgnam.invalidlength");
        }
        
        if ((userInput.getNewcatgval() == null) || (userInput.getNewcatgval().isEmpty())) {
            errors.rejectValue("newcatgval", "user.newcatgval.emptyfield");
        } else if ((userInput.getNewcatgval().length() < 5) || (userInput.getNewcatgval().length() > 100)) {
            errors.rejectValue("newcatgval", "user.newcatgval.invalidlength");
        }
        
        if ((userInput.getNewcatgpri() == null) || (!userInput.getNewcatgpri().matches("^([1-6])$"))) {
            userInput.setNewcatgpri("2");
        }
        if ((userInput.getNewcatgpic() != null) && (!userInput.getNewcatgpic().isEmpty()) && (!imagePattern.matcher(userInput.getNewcatgpic().getContentType().toLowerCase()).matches())) {
            errors.rejectValue("newcatgpic", "uploadpic.invalid.type");
        }
        if ((userInput.getNewcatgdesc() != null) && (userInput.getNewcatgdesc().length() > 100)) {
            errors.rejectValue("newcatgdesc", "user.description.invalidlength");
        }
    }

}
