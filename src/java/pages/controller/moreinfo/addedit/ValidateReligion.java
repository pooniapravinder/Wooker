package pages.controller.moreinfo.addedit;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ValidateReligion implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Addreligion.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Addreligion userInput = (Addreligion) target;

        if ((userInput.getReligion() == null) || (userInput.getReligion().isEmpty())) {
            errors.rejectValue("religion", "user.religion.emptyfield");
        } else if ((userInput.getReligion().length() < 3) || (userInput.getReligion().length() > 50)) {
            errors.rejectValue("religion", "user.religion.invalidlength");
        }
        if ((userInput.getReligpri() == null) || (!userInput.getReligpri().matches("^([1-6])$"))) {
            userInput.setReligpri("2");
        }
        if ((userInput.getReligdesc() != null) && (userInput.getReligdesc().length() > 100)) {
            errors.rejectValue("religdesc", "user.description.invalidlength");
        }
    }

}
