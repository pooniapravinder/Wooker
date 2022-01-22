package pages.controller.moreinfo.addedit;

import java.util.regex.Pattern;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import timeperiod.duration.calculation.CalculateTime;

@Component
public class ValidateMoved implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Addmoved.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Addmoved userInput = (Addmoved) target;
        Pattern imagePattern = Pattern.compile("^image/([jpg|jpeg|png|bmp]+)$");
        CalculateTime getTime = new CalculateTime();
        getTime.getCalendar(userInput.getMovedMonth(), userInput.getMovedDate(), userInput.getMovedYear());
        userInput.setMovedMonth((getTime.getMonth() != 0) ? String.valueOf(String.format("%02d", getTime.getMonth())) : "0");
        userInput.setMovedDate((getTime.getDay() != 0) ? String.valueOf(String.format("%02d", getTime.getDay())) : "0");
        userInput.setMovedYear((getTime.getYear() != 0) ? String.valueOf(getTime.getYear()) : "0");

        if ((userInput.getMovedfrom() == null) || (userInput.getMovedfrom().isEmpty())) {
            errors.rejectValue("movedfrom", "user.movedfrom.emptyfield");
        } else if ((userInput.getMovedfrom().length() < 3) || (userInput.getMovedfrom().length() > 50)) {
            errors.rejectValue("movedfrom", "user.movedfrom.invalidlength");
        }
        if ((userInput.getMovedto() == null) || (userInput.getMovedto().isEmpty())) {
            errors.rejectValue("movedto", "user.movedto.emptyfield");
        } else if ((userInput.getMovedto().length() < 3) || (userInput.getMovedto().length() > 50)) {
            errors.rejectValue("movedto", "user.movedto.invalidlength");
        }
        if ((userInput.getMovedPri() == null) || (!userInput.getMovedPri().matches("^([1-6])$"))) {
            userInput.setMovedPri("2");
        }
        if ((userInput.getMovedPic() != null) && (!userInput.getMovedPic().isEmpty()) && (!imagePattern.matcher(userInput.getMovedPic().getContentType().toLowerCase()).matches())) {
            errors.rejectValue("movedPic", "uploadpic.invalid.type");
        }
        if ((userInput.getMovedDesc() != null) && (userInput.getMovedDesc().length() > 100)) {
            errors.rejectValue("movedDesc", "user.description.invalidlength");
        }
    }

}
