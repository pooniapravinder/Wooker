package pages.controller.moreinfo.addedit;

import java.util.regex.Pattern;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import timeperiod.duration.calculation.CalculateTime;

@Component
public class ValidateGrUniver implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Addgruniver.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Addgruniver userInput = (Addgruniver) target;
        Pattern imagePattern = Pattern.compile("^image/([jpg|jpeg|png|bmp]+)$");
        CalculateTime getTime = new CalculateTime();
        getTime.getCalendar(userInput.getGrUnenMonth(), userInput.getGrUnenDate(), userInput.getGrUnenYear());
        byte enMon = getTime.getMonth();
        byte enDat = getTime.getDay();
        int enYea = getTime.getYear();
        userInput.setGrUnenMonth((enMon != 0) ? String.valueOf(String.format("%02d", enMon)) : "0");
        userInput.setGrUnenDate((enDat != 0) ? String.valueOf(String.format("%02d", enDat)) : "0");
        userInput.setGrUnenYear((enYea != 0) ? String.valueOf(enYea) : "0");

        getTime.getCalendar(userInput.getGrUnleMonth(), userInput.getGrUnleDate(), userInput.getGrUnleYear());
        byte leMon = getTime.getMonth();
        byte leDat = getTime.getDay();
        int leYea = getTime.getYear();
        userInput.setGrUnleMonth((leMon != 0) ? String.valueOf(String.format("%02d", leMon)) : "0");
        userInput.setGrUnleDate((leDat != 0) ? String.valueOf(String.format("%02d", leDat)) : "0");
        userInput.setGrUnleYear((leYea != 0) ? String.valueOf(leYea) : "0");

        if ((userInput.getGradUniver() == null) || (userInput.getGradUniver().isEmpty())) {
            errors.rejectValue("gradUniver", "user.gruniver.emptyfield");
        } else if ((userInput.getGradUniver().length() < 10) || (userInput.getGradUniver().length() > 100)) {
            errors.rejectValue("gradUniver", "user.gruniver.invalidlength");
        }
        if ((userInput.getGrUnPri() == null) || (!userInput.getGrUnPri().matches("^([1-6])$"))) {
            userInput.setGrUnPri("2");
        }
        if (((enYea > leYea) && (leYea != 0)) || (((enMon > leMon) && (leMon != 0)) && ((enYea == leYea) && (leYea != 0))) || (((enDat > leDat) && (leDat != 0)) && ((enMon == leMon) && (leMon != 0)) && ((enYea == leYea) && (leYea != 0)))) {
            errors.rejectValue("grUnenYear", "user.invalidentrance");
        }
        if ((userInput.getGradUnPic() != null) && (!userInput.getGradUnPic().isEmpty()) && (!imagePattern.matcher(userInput.getGradUnPic().getContentType().toLowerCase()).matches())) {
            errors.rejectValue("gradUnPic", "uploadpic.invalid.type");
        }
        if ((userInput.getGradUnDesc() != null) && (userInput.getGradUnDesc().length() > 100)) {
            errors.rejectValue("gradUnDesc", "user.description.invalidlength");
        }
    }

}
