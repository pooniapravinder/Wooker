package pages.controller.moreinfo.addedit;

import java.util.regex.Pattern;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ValidateWebsite implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Addwebsite.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Addwebsite userInput = (Addwebsite) target;
        Pattern WebsitePattern = Pattern.compile("^((http:\\/\\/)|(https:\\/\\/)|(www\\.)).*$");
        if ((userInput.getWebsite() == null) || (userInput.getWebsite().isEmpty())) {
            errors.rejectValue("website", "user.website.emptyfield");
        } else if (!WebsitePattern.matcher(userInput.getWebsite()).matches()) {
            errors.rejectValue("website", "user.website.invalid");
        }
        if ((userInput.getWebtyp() == null) || (!userInput.getWebtyp().matches("^([1-9]|1[0-4])$"))) {
            userInput.setWebtyp("1");
        }
        if ((userInput.getWebpri() == null) || (!userInput.getWebpri().matches("^([1-6])$"))) {
            userInput.setWebpri("2");
        }
        if ((userInput.getWebdesc() != null) && (userInput.getWebdesc().length() > 100)) {
            errors.rejectValue("webdesc", "user.description.invalidlength");
        }
    }

}