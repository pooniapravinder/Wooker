package pages.controller.moreinfo.addedit;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ValidateMyself implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Addmyself.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Addmyself userInput = (Addmyself) target;

        if ((userInput.getMyself() == null) || (userInput.getMyself().isEmpty())) {
            errors.rejectValue("myself", "user.myself.emptyfield");
        } else if ((userInput.getMyself().length() < 5) || (userInput.getMyself().length() > 100)) {
            errors.rejectValue("myself", "user.myself.invalidlength");
        }
        if ((userInput.getMyselpri() == null) || (!userInput.getMyselpri().matches("^([1-6])$"))) {
            userInput.setMyselpri("2");
        }
        if ((userInput.getMyseldesc() != null) && (userInput.getMyseldesc().length() > 100)) {
            errors.rejectValue("myseldesc", "user.description.invalidlength");
        }
    }

}
