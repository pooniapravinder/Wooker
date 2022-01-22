package pages.controller.moreinfo.addedit;

import java.util.regex.Pattern;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ValidateHobbies implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Addhobbies.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Addhobbies userInput = (Addhobbies) target;
        Pattern imagePattern = Pattern.compile("^image/([jpg|jpeg|png|bmp]+)$");

        if ((userInput.getHobbies() == null) || (userInput.getHobbies().isEmpty())) {
            errors.rejectValue("hobbies", "user.hobbies.emptyfield");
        } else if ((userInput.getHobbies().length() < 10) || (userInput.getHobbies().length() > 100)) {
            errors.rejectValue("hobbies", "user.hobbies.invalidlength");
        }
        if ((userInput.getHobpri() == null) || (!userInput.getHobpri().matches("^([1-6])$"))) {
            userInput.setHobpri("2");
        }
        if ((userInput.getHobPic() != null) && (!userInput.getHobPic().isEmpty()) && (!imagePattern.matcher(userInput.getHobPic().getContentType().toLowerCase()).matches())) {
            errors.rejectValue("hobPic", "uploadpic.invalid.type");
        }
        if ((userInput.getHobdesc() != null) && (userInput.getHobdesc().length() > 100)) {
            errors.rejectValue("hobdesc", "user.description.invalidlength");
        }
    }

}
