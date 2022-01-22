package pages.controller.moreinfo.addedit;

import java.util.regex.Pattern;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import timeperiod.duration.calculation.CalculateTime;

@Component
public class ValidatePoGrColl implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Addpogrcoll.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Addpogrcoll userInput = (Addpogrcoll) target;
        Pattern imagePattern = Pattern.compile("^image/([jpg|jpeg|png|bmp]+)$");
        CalculateTime getTime = new CalculateTime();
        getTime.getCalendar(userInput.getPogrCoenMonth(), userInput.getPogrCoenDate(), userInput.getPogrCoenYear());
        byte enMon = getTime.getMonth();
        byte enDat = getTime.getDay();
        int enYea = getTime.getYear();
        userInput.setPogrCoenMonth((enMon != 0) ? String.valueOf(String.format("%02d", enMon)) : "0");
        userInput.setPogrCoenDate((enDat != 0) ? String.valueOf(String.format("%02d", enDat)) : "0");
        userInput.setPogrCoenYear((enYea != 0) ? String.valueOf(enYea) : "0");

        getTime.getCalendar(userInput.getPogrColeMonth(), userInput.getPogrColeDate(), userInput.getPogrColeYear());
        byte leMon = getTime.getMonth();
        byte leDat = getTime.getDay();
        int leYea = getTime.getYear();
        userInput.setPogrColeMonth((leMon != 0) ? String.valueOf(String.format("%02d", leMon)) : "0");
        userInput.setPogrColeDate((leDat != 0) ? String.valueOf(String.format("%02d", leDat)) : "0");
        userInput.setPogrColeYear((leYea != 0) ? String.valueOf(leYea) : "0");

        if ((userInput.getPogrColl() == null) || (userInput.getPogrColl().isEmpty())) {
            errors.rejectValue("pogrColl", "user.pogrcoll.emptyfield");
        } else if ((userInput.getPogrColl().length() < 10) || (userInput.getPogrColl().length() > 100)) {
            errors.rejectValue("pogrColl", "user.pogrcoll.invalidlength");
        }
        if ((userInput.getPogrCollPri() == null) || (!userInput.getPogrCollPri().matches("^([1-6])$"))) {
            userInput.setPogrCollPri("2");
        }
        if (((enYea > leYea) && (leYea != 0)) || (((enMon > leMon) && (leMon != 0)) && ((enYea == leYea) && (leYea != 0))) || (((enDat > leDat) && (leDat != 0)) && ((enMon == leMon) && (leMon != 0)) && ((enYea == leYea) && (leYea != 0)))) {
            errors.rejectValue("PogrCoenYear", "user.invalidentrance");
        }
        if ((userInput.getPogrCoPic() != null) && (!userInput.getPogrCoPic().isEmpty()) && (!imagePattern.matcher(userInput.getPogrCoPic().getContentType().toLowerCase()).matches())) {
            errors.rejectValue("pogrCoPic", "uploadpic.invalid.type");
        }
        if ((userInput.getPogrCoDesc() != null) && (userInput.getPogrCoDesc().length() > 100)) {
            errors.rejectValue("pogrCoDesc", "user.description.invalidlength");
        }
    }

}
