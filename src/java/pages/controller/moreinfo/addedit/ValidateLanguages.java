package pages.controller.moreinfo.addedit;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ValidateLanguages implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Addlanguages.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Addlanguages userInput = (Addlanguages) target;

        if ((userInput.getLanguages() == null) || (userInput.getLanguages().isEmpty())) {
            errors.rejectValue("languages", "user.languages.emptyfield");
        } else if ((userInput.getLanguages().length() < 5) || (userInput.getLanguages().length() > 100)) {
            errors.rejectValue("languages", "user.languages.invalidlength");
        }
        if ((userInput.getLangpri() == null) || (!userInput.getLangpri().matches("^([1-6])$"))) {
            userInput.setLangpri("2");
        }
        if ((userInput.getLangdesc() != null) && (userInput.getLangdesc().length() > 100)) {
            errors.rejectValue("langdesc", "user.description.invalidlength");
        }
    }

}
