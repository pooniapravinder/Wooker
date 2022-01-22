package pages.controller.moreinfo.addedit;

import java.util.regex.Pattern;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import timeperiod.duration.calculation.CalculateTime;

@Component
public class ValidateGrCollege implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Addgrcollege.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Addgrcollege userInput = (Addgrcollege) target;
        Pattern imagePattern = Pattern.compile("^image/([jpg|jpeg|png|bmp]+)$");
        CalculateTime getTime = new CalculateTime();
        getTime.getCalendar(userInput.getGrCoenMonth(), userInput.getGrCoenDate(), userInput.getGrCoenYear());
        byte enMon = getTime.getMonth();
        byte enDat = getTime.getDay();
        int enYea = getTime.getYear();
        userInput.setGrCoenMonth((enMon != 0) ? String.valueOf(String.format("%02d", enMon)) : "0");
        userInput.setGrCoenDate((enDat != 0) ? String.valueOf(String.format("%02d", enDat)) : "0");
        userInput.setGrCoenYear((enYea != 0) ? String.valueOf(enYea) : "0");

        getTime.getCalendar(userInput.getGrColeMonth(), userInput.getGrColeDate(), userInput.getGrColeYear());
        byte leMon = getTime.getMonth();
        byte leDat = getTime.getDay();
        int leYea = getTime.getYear();
        userInput.setGrColeMonth((leMon != 0) ? String.valueOf(String.format("%02d", leMon)) : "0");
        userInput.setGrColeDate((leDat != 0) ? String.valueOf(String.format("%02d", leDat)) : "0");
        userInput.setGrColeYear((leYea != 0) ? String.valueOf(leYea) : "0");

        if ((userInput.getGradColl() == null) || (userInput.getGradColl().isEmpty())) {
            errors.rejectValue("gradColl", "user.grcollege.emptyfield");
        } else if ((userInput.getGradColl().length() < 10) || (userInput.getGradColl().length() > 100)) {
            errors.rejectValue("gradColl", "user.grcollege.invalidlength");
        }
        if ((userInput.getGrCollPri() == null) || (!userInput.getGrCollPri().matches("^([1-6])$"))) {
            userInput.setGrCollPri("2");
        }
        if (((enYea > leYea) && (leYea != 0)) || (((enMon > leMon) && (leMon != 0)) && ((enYea == leYea) && (leYea != 0))) || (((enDat > leDat) && (leDat != 0)) && ((enMon == leMon) && (leMon != 0)) && ((enYea == leYea) && (leYea != 0)))) {
            errors.rejectValue("grCoenYear", "user.invalidentrance");
        }
        if ((userInput.getGrCoPic() != null) && (!userInput.getGrCoPic().isEmpty()) && (!imagePattern.matcher(userInput.getGrCoPic().getContentType().toLowerCase()).matches())) {
            errors.rejectValue("grCoPic", "uploadpic.invalid.type");
        }
        if ((userInput.getGrCoDesc() != null) && (userInput.getGrCoDesc().length() > 100)) {
            errors.rejectValue("grCoDesc", "user.description.invalidlength");
        }
    }

}
