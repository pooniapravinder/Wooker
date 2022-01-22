package pages.controller.moreinfo.addedit;

import java.util.regex.Pattern;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ValidateLocation implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Addlocation.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Addlocation userInput = (Addlocation) target;
        Pattern imagePattern = Pattern.compile("^image/([jpg|jpeg|png|bmp]+)$");

        if ((userInput.getCurrentCity() == null) || (userInput.getCurrentCity().isEmpty())) {
            errors.rejectValue("currentCity", "user.currentcity.emptyfield");
        } else if ((userInput.getCurrentCity().length() < 3) || (userInput.getCurrentCity().length() > 50)) {
            errors.rejectValue("currentCity", "user.currentcity.invalidlength");
        }
        
        if ((userInput.getHometown() == null) || (userInput.getHometown().isEmpty())) {
            errors.rejectValue("hometown", "user.hometown.emptyfield");
        } else if ((userInput.getHometown().length() < 3) || (userInput.getHometown().length() > 50)) {
            errors.rejectValue("hometown", "user.hometown.invalidlength");
        }
        if ((userInput.getLocPri() == null) || (!userInput.getLocPri().matches("^([1-6])$"))) {
            userInput.setLocPri("2");
        }
        if ((userInput.getLocPic() != null) && (!userInput.getLocPic().isEmpty()) && (!imagePattern.matcher(userInput.getLocPic().getContentType().toLowerCase()).matches())) {
            errors.rejectValue("locPic", "uploadpic.invalid.type");
        }
        if ((userInput.getLocDesc() != null) && (userInput.getLocDesc().length() > 100)) {
            errors.rejectValue("locDesc", "user.description.invalidlength");
        }
    }

}
