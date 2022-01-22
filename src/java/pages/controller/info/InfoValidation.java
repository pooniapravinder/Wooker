package pages.controller.info;

import java.util.Calendar;
import java.util.regex.Pattern;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class InfoValidation implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Editinfo.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Editinfo userInput = (Editinfo) target;
        int currentmonth = Calendar.getInstance().get(Calendar.MONTH) + 1;
        int currentdate = Calendar.getInstance().get(Calendar.DATE);
        int currentyear = Calendar.getInstance().get(Calendar.YEAR);
        String username = userInput.getFirstName() + userInput.getLastName();
        Pattern NamePattern = Pattern.compile("^([A-Za-z]{3,14})((\\s{1})([A-Za-z]{2,14}))*$");
        Pattern NickNamePattern = Pattern.compile("^([A-Za-z]{3,14})*$");
        int NameSpace = username == null ? 0 : username.length() - username.replace(" ", "").length();
        Pattern GenderPattern = Pattern.compile("^(Male|Female|Other)$");
        Pattern MonthPattern = Pattern.compile("^(0[1-9]|1[0-2])$");
        Pattern DatePattern = Pattern.compile("^(0[1-9]|1[0-9]|2[0-9]|3[0-1])$");
        Pattern BirthYearPattern = Pattern.compile("^\\d{4}$");

        if (userInput.getFirstName() == null) {
        } else if (userInput.getFirstName().isEmpty()) {
            errors.rejectValue("firstName", "user.firstname.emptyfield");
        } else if (!NamePattern.matcher(userInput.getFirstName()).matches()) {
            errors.rejectValue("firstName", "user.firstname.invalid");
        } else if ((username != null) && (username.length() > 40)) {
            errors.rejectValue("firstName", "user.firstname.lastname.invalid");
        } else if (NameSpace > 3) {
            errors.rejectValue("firstName", "user.firstname.lastname.morespace");
        }
        if ((userInput.getLastName() != null) && (!userInput.getLastName().isEmpty()) && (!NamePattern.matcher(userInput.getLastName()).matches())) {
            errors.rejectValue("lastName", "user.lastname.invalid");
        }
        if ((userInput.getNickName() != null) && (!userInput.getNickName().isEmpty()) && (!NickNamePattern.matcher(userInput.getNickName()).matches())) {
            errors.rejectValue("nickName", "user.nickname.invalid");
        }
        if (userInput.getGender() == null){
        }else if(userInput.getGender().isEmpty()) {
            errors.rejectValue("gender", "user.gender.noselect");
        } else if (!GenderPattern.matcher(userInput.getGender()).matches()) {
            errors.rejectValue("gender", "user.gender.invalid");
        }
        if (userInput.getBirthMonth() == null){
        }else if(userInput.getBirthMonth().isEmpty()) {
            errors.rejectValue("birthMonth", "user.birthmonth.noselect");
        } else if (!MonthPattern.matcher(userInput.getBirthMonth()).matches()) {
            errors.rejectValue("birthMonth", "user.birthmonth.invalid");
        }
        if (userInput.getBirthDate() == null){
        }else if(userInput.getBirthDate().isEmpty()) {
            errors.rejectValue("birthDate", "user.birthdate.noselect");
        } else if (!DatePattern.matcher(userInput.getBirthDate()).matches()) {
            errors.rejectValue("birthDate", "user.birthdate.invalid");
        }
        if (userInput.getBirthYear() == null){
        }else if(userInput.getBirthYear().isEmpty()) {
            errors.rejectValue("birthYear", "user.birthyear.noselect");
        } else if (!BirthYearPattern.matcher(userInput.getBirthYear()).matches()) {
            errors.rejectValue("birthYear", "user.birthyear.invalid");
        }
        if ((userInput.getBirthMonth() != null) && (!userInput.getBirthMonth().isEmpty()) && (userInput.getBirthDate() != null) && (!userInput.getBirthDate().isEmpty()) && (userInput.getBirthYear() != null) && (!userInput.getBirthYear().isEmpty()) && (MonthPattern.matcher(userInput.getBirthMonth()).matches()) && (DatePattern.matcher(userInput.getBirthDate()).matches()) && (BirthYearPattern.matcher(userInput.getBirthYear()).matches())) {
            int birthDate2 = Integer.parseInt(userInput.getBirthDate());
            int birthMonth2 = Integer.parseInt(userInput.getBirthMonth());
            int birthBirthYear2 = Integer.parseInt(userInput.getBirthYear());
            if ((birthMonth2 < 1) || (birthMonth2 > 12) || ((birthMonth2 > currentmonth) && (birthBirthYear2 == currentyear) && (birthDate2 > currentdate)) || (birthBirthYear2 > currentyear)) {
                errors.rejectValue("birthMonth", "user.birthmonth.invalid");
            }
            if ((birthDate2 < 1) || (birthDate2 > 31) || (birthBirthYear2 > currentyear) || ((birthDate2 > currentdate) && (birthMonth2 > currentmonth) && (birthBirthYear2 == currentyear)) || ((birthBirthYear2 % 400 != 0) && (birthBirthYear2 % 4 != 0) && (birthMonth2 == 2) && (birthDate2 > 28)) || ((birthBirthYear2 % 400 == 0 || birthBirthYear2 % 4 == 0) && (birthMonth2 == 2) && (birthDate2 > 29)) || ((birthMonth2 == 4 || birthMonth2 == 6 || birthMonth2 == 9 || birthMonth2 == 11) && (birthDate2 > 30))) {
                errors.rejectValue("birthDate", "user.birthdate.invalid");
            }
            if ((birthBirthYear2 < currentyear - 115) || (birthBirthYear2 > currentyear) || ((birthDate2 > currentdate) && (birthMonth2 > currentmonth) && (birthBirthYear2 == currentyear))) {
                errors.rejectValue("birthYear", "user.birthyear.invalid");
            } else if (birthBirthYear2 > currentyear - 8) {
                errors.rejectValue("birthYear", "user.birthyear.short");
            }
        }
    }
}
