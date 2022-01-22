package pages.controller.moreinfo.addedit;

import java.util.regex.Pattern;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import timeperiod.duration.calculation.CalculateTime;

@Component
public class ValidateRelationship implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Addrelationship.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Addrelationship userInput = (Addrelationship) target;
        Pattern imagePattern = Pattern.compile("^image/([jpg|jpeg|png|bmp]+)$");
        CalculateTime getTime = new CalculateTime();
        getTime.getCalendar(userInput.getRelatiMonth(), userInput.getRelatiDate(), userInput.getRelatiYear());
        userInput.setRelatiMonth((getTime.getMonth() != 0) ? String.valueOf(String.format("%02d", getTime.getMonth())) : "0");
        userInput.setRelatiDate((getTime.getDay() != 0) ? String.valueOf(String.format("%02d", getTime.getDay())) : "0");
        userInput.setRelatiYear((getTime.getYear() != 0) ? String.valueOf(getTime.getYear()) : "0");

        if ((userInput.getRelatiname() != null) && (!userInput.getRelatiname().isEmpty()) && ((userInput.getRelatiname().length() < 3) || (userInput.getRelatiname().length() > 50))) {
            errors.rejectValue("relatiname", "user.relatiname.invalidlength");
        }
        if ((userInput.getRelationship() == null) || (userInput.getRelationship().isEmpty())) {
            errors.rejectValue("relationship", "user.relationship.emptyfield");
        } else if (!userInput.getRelationship().matches("^([1-6])$")) {
            errors.rejectValue("relationship", "user.relationship.invalid");
        } else if ((Byte.valueOf(userInput.getRelationship()) == 1) && (userInput.getRelatiname() != null) && (!userInput.getRelatiname().isEmpty())) {
            errors.rejectValue("relatiname", "user.relatisingle.invalid");
        }
        if ((userInput.getRelatipri() == null) || (!userInput.getRelatipri().matches("^([1-6])$"))) {
            userInput.setRelatipri("2");
        }
        if ((userInput.getRelatiPic() != null) && (!userInput.getRelatiPic().isEmpty()) && (!imagePattern.matcher(userInput.getRelatiPic().getContentType().toLowerCase()).matches())) {
            errors.rejectValue("relatiPic", "uploadpic.invalid.type");
        }
        if ((userInput.getRelatidesc() != null) && (userInput.getRelatidesc().length() > 100)) {
            errors.rejectValue("relatidesc", "user.description.invalidlength");
        }
    }

}
