package pages.controller.moreinfo.addedit;

import java.util.regex.Pattern;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import timeperiod.duration.calculation.CalculateTime;

@Component
public class ValidateWork implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Addwork.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Addwork userInput = (Addwork) target;
        Pattern imagePattern = Pattern.compile("^image/([jpg|jpeg|png|bmp]+)$");
        CalculateTime getTime = new CalculateTime();
        getTime.getCalendar(userInput.getWoenMonth(), userInput.getWoenDate(), userInput.getWoenYear());
        byte enMon = getTime.getMonth();
        byte enDat = getTime.getDay();
        int enYea = getTime.getYear();
        userInput.setWoenMonth((enMon != 0) ? String.valueOf(String.format("%02d", enMon)) : "0");
        userInput.setWoenDate((enDat != 0) ? String.valueOf(String.format("%02d", enDat)) : "0");
        userInput.setWoenYear((enYea != 0) ? String.valueOf(enYea) : "0");

        getTime.getCalendar(userInput.getWoleMonth(), userInput.getWoleDate(), userInput.getWoleYear());
        byte leMon = getTime.getMonth();
        byte leDat = getTime.getDay();
        int leYea = getTime.getYear();
        userInput.setWoleMonth((leMon != 0) ? String.valueOf(String.format("%02d", leMon)) : "0");
        userInput.setWoleDate((leDat != 0) ? String.valueOf(String.format("%02d", leDat)) : "0");
        userInput.setWoleYear((leYea != 0) ? String.valueOf(leYea) : "0");

        if ((userInput.getWorktype() == null) || (userInput.getWorktype().isEmpty())) {
            errors.rejectValue("worktype", "user.worktype.emptyfield");
        } else if ((userInput.getWorktype().length() < 5) || (userInput.getWorktype().length() > 50)) {
            errors.rejectValue("worktype", "user.worktype.invalidlength");
        }
        
        if ((userInput.getWorkplace() == null) || (userInput.getWorkplace().isEmpty())) {
            errors.rejectValue("workplace", "user.workplace.emptyfield");
        } else if ((userInput.getWorkplace().length() < 3) || (userInput.getWorkplace().length() > 50)) {
            errors.rejectValue("workplace", "user.workplace.invalidlength");
        }
        if ((userInput.getWorkPri() == null) || (!userInput.getWorkPri().matches("^([1-6])$"))) {
            userInput.setWorkPri("2");
        }
        if (((enYea > leYea) && (leYea != 0)) || (((enMon > leMon) && (leMon != 0)) && ((enYea == leYea) && (leYea != 0))) || (((enDat > leDat) && (leDat != 0)) && ((enMon == leMon) && (leMon != 0)) && ((enYea == leYea) && (leYea != 0)))) {
            errors.rejectValue("woenYear", "user.invalidstart");
        }
        if ((userInput.getWorkPic() != null) && (!userInput.getWorkPic().isEmpty()) && (!imagePattern.matcher(userInput.getWorkPic().getContentType().toLowerCase()).matches())) {
            errors.rejectValue("workPic", "uploadpic.invalid.type");
        }
        if ((userInput.getWorkDesc() != null) && (userInput.getWorkDesc().length() > 100)) {
            errors.rejectValue("workDesc", "user.description.invalidlength");
        }
    }

}
