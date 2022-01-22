package pages.controller.moreinfo.addedit;

import java.util.regex.Pattern;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import timeperiod.duration.calculation.CalculateTime;

@Component
public class ValidateSchool implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Addschool.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Addschool userInput = (Addschool) target;
        Pattern imagePattern = Pattern.compile("^image/([jpg|jpeg|png|bmp]+)$");
        CalculateTime getTime = new CalculateTime();
        getTime.getCalendar(userInput.getSchenMonth(), userInput.getSchenDate(), userInput.getSchenYear());
        byte enMon = getTime.getMonth();
        byte enDat = getTime.getDay();
        int enYea = getTime.getYear();
        userInput.setSchenMonth((enMon != 0) ? String.valueOf(String.format("%02d", enMon)) : "0");
        userInput.setSchenDate((enDat != 0) ? String.valueOf(String.format("%02d", enDat)) : "0");
        userInput.setSchenYear((enYea != 0) ? String.valueOf(enYea) : "0");

        getTime.getCalendar(userInput.getSchleMonth(), userInput.getSchleDate(), userInput.getSchleYear());
        byte leMon = getTime.getMonth();
        byte leDat = getTime.getDay();
        int leYea = getTime.getYear();
        userInput.setSchleMonth((leMon != 0) ? String.valueOf(String.format("%02d", leMon)) : "0");
        userInput.setSchleDate((leDat != 0) ? String.valueOf(String.format("%02d", leDat)) : "0");
        userInput.setSchleYear((leYea != 0) ? String.valueOf(leYea) : "0");

        if ((userInput.getUserSchool() == null) || (userInput.getUserSchool().isEmpty())) {
            errors.rejectValue("userSchool", "user.school.emptyfield");
        } else if ((userInput.getUserSchool().length() < 10) || (userInput.getUserSchool().length() > 100)) {
            errors.rejectValue("userSchool", "user.school.invalidlength");
        }
        if ((userInput.getSchPri() == null) || (!userInput.getSchPri().matches("^([1-6])$"))) {
            userInput.setSchPri("2");
        }
        if (((enYea > leYea) && (leYea != 0)) || (((enMon > leMon) && (leMon != 0)) && ((enYea == leYea) && (leYea != 0))) || (((enDat > leDat) && (leDat != 0)) && ((enMon == leMon) && (leMon != 0)) && ((enYea == leYea) && (leYea != 0)))) {
            errors.rejectValue("schenYear", "user.invalidentrance");
        }
        if ((userInput.getSchPic() != null) && (!userInput.getSchPic().isEmpty()) && (!imagePattern.matcher(userInput.getSchPic().getContentType().toLowerCase()).matches())) {
            errors.rejectValue("schPic", "uploadpic.invalid.type");
        }
        if ((userInput.getSchDesc() != null) && (userInput.getSchDesc().length() > 100)) {
            errors.rejectValue("schDesc", "user.description.invalidlength");
        }
    }

}
