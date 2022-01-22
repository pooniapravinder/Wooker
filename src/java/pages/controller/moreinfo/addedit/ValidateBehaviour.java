package pages.controller.moreinfo.addedit;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ValidateBehaviour implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Addbehaviour.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Addbehaviour userInput = (Addbehaviour) target;

        if ((userInput.getBehaviour() == null) || (userInput.getBehaviour().isEmpty())) {
            errors.rejectValue("behaviour", "user.behaviour.emptyfield");
        } else if ((userInput.getBehaviour().length() < 5) || (userInput.getBehaviour().length() > 100)) {
            errors.rejectValue("behaviour", "user.behaviour.invalidlength");
        }
        if ((userInput.getBehavpri() == null) || (!userInput.getBehavpri().matches("^([1-6])$"))) {
            userInput.setBehavpri("2");
        }
        if ((userInput.getBehavdesc() != null) && (userInput.getBehavdesc().length() > 100)) {
            errors.rejectValue("behavdesc", "user.description.invalidlength");
        }
    }

}
