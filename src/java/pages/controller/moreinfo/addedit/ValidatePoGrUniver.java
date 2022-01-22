package pages.controller.moreinfo.addedit;

import java.util.regex.Pattern;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import timeperiod.duration.calculation.CalculateTime;

@Component
public class ValidatePoGrUniver implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Addpogruniver.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Addpogruniver userInput = (Addpogruniver) target;
        Pattern imagePattern = Pattern.compile("^image/([jpg|jpeg|png|bmp]+)$");
        CalculateTime getTime = new CalculateTime();
        getTime.getCalendar(userInput.getPogrUnenMonth(), userInput.getPogrUnenDate(), userInput.getPogrUnenYear());
        byte enMon = getTime.getMonth();
        byte enDat = getTime.getDay();
        int enYea = getTime.getYear();
        userInput.setPogrUnenMonth((enMon != 0) ? String.valueOf(String.format("%02d", enMon)) : "0");
        userInput.setPogrUnenDate((enDat != 0) ? String.valueOf(String.format("%02d", enDat)) : "0");
        userInput.setPogrUnenYear((enYea != 0) ? String.valueOf(enYea) : "0");

        getTime.getCalendar(userInput.getPogrUnleMonth(), userInput.getPogrUnleDate(), userInput.getPogrUnleYear());
        byte leMon = getTime.getMonth();
        byte leDat = getTime.getDay();
        int leYea = getTime.getYear();
        userInput.setPogrUnleMonth((leMon != 0) ? String.valueOf(String.format("%02d", leMon)) : "0");
        userInput.setPogrUnleDate((leDat != 0) ? String.valueOf(String.format("%02d", leDat)) : "0");
        userInput.setPogrUnleYear((leYea != 0) ? String.valueOf(leYea) : "0");

        if ((userInput.getPogrUniver() == null) || (userInput.getPogrUniver().isEmpty())) {
            errors.rejectValue("pogrUniver", "user.pogruniver.emptyfield");
        } else if ((userInput.getPogrUniver().length() < 10) || (userInput.getPogrUniver().length() > 100)) {
            errors.rejectValue("pogrUniver", "user.pogruniver.invalidlength");
        }
        if ((userInput.getPogrUnPri() == null) || (!userInput.getPogrUnPri().matches("^([1-6])$"))) {
            userInput.setPogrUnPri("2");
        }
        if (((enYea > leYea) && (leYea != 0)) || (((enMon > leMon) && (leMon != 0)) && ((enYea == leYea) && (leYea != 0))) || (((enDat > leDat) && (leDat != 0)) && ((enMon == leMon) && (leMon != 0)) && ((enYea == leYea) && (leYea != 0)))) {
            errors.rejectValue("PogrUnenYear", "user.invalidentrance");
        }
        if ((userInput.getPogrUnPic() != null) && (!userInput.getPogrUnPic().isEmpty()) && (!imagePattern.matcher(userInput.getPogrUnPic().getContentType().toLowerCase()).matches())) {
            errors.rejectValue("pogrUnPic", "uploadpic.invalid.type");
        }
        if ((userInput.getPogrUnDesc() != null) && (userInput.getPogrUnDesc().length() > 100)) {
            errors.rejectValue("pogrUnDesc", "user.description.invalidlength");
        }
    }

}
