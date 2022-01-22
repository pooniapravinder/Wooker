package pages.controller.signup;

import hibernate.mapping.Accounts;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import hibernate.query.RegistrationQuery;
import java.util.Calendar;
import java.util.regex.Pattern;

@Component
public class SignupValidation implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Addaccount.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Addaccount userInput = (Addaccount) target;
        RegistrationQuery GetQuery = new RegistrationQuery();
        Accounts GetAccount = GetQuery.findAccount(userInput.getEmailidPhone());
        boolean isVerified = false;
        if (GetAccount != null) {
            isVerified = GetAccount.isVerifiedAccount();
        }
        int currentmonth = Calendar.getInstance().get(Calendar.MONTH) + 1;
        int currentdate = Calendar.getInstance().get(Calendar.DATE);
        int currentyear = Calendar.getInstance().get(Calendar.YEAR);
        String username = userInput.getFirstName() + userInput.getLastName();
        Pattern NamePattern = Pattern.compile("^([A-Za-z]{3,14})((\\s{1})([A-Za-z]{2,14}))*$");
        int NameSpace = username == null ? 0 : username.length() - username.replace(" ", "").length();
        Pattern GenderPattern = Pattern.compile("^(Male|Female|Other)$");
        Pattern MonthPattern = Pattern.compile("^(0[1-9]|1[0-2])$");
        Pattern DatePattern = Pattern.compile("^(0[1-9]|1[0-9]|2[0-9]|3[0-1])$");
        Pattern YearPattern = Pattern.compile("^\\d{4}$");
        Pattern CountryPattern = Pattern.compile("^([AO|AQ|AZ|AF|AS|AW|AR|SV|DZ|AL|AC|IM|IS|IE|AM|ID|EC|GQ|IT|ET|IQ|ER|IL|IR|UZ|KP|MP|UY|AI|AG|AD|AX|EE|OM|AT|AU|KH|KZ|CA|CD|CG|KI|KG|CK|KW|KE|CV|KY|IC|CM|BQ|CC|CI|KM|CO|XK|CR|CU|CW|CX|HR|CP|QA|GY|GG|GM|GN|GW|GU|GA|GL|GD|GT|GP|GH|TD|CL|CN|CZ|JM|DE|JE|JP|DJ|GI|GE|JO|ZM|ZW|TO|TG|TN|DG|DK|DO|DM|TZ|TW|TJ|TL|TC|TM|TR|TV|TK|TT|TA|TH|ZA|KR|GS|SS|NE|NG|NR|NA|NI|NL|NU|NP|NF|NO|NC|NZ|PA|PW|EH|PK|PG|PN|PT|PY|PE|PR|PL|FJ|FI|PH|PS|FO|FK|FR|TF|GF|PF|BM|BH|BS|BD|BB|BI|BF|BG|BJ|BY|BZ|BE|BW|BO|BV|BA|BR|VG|IO|BN|IN|BT|MN|MO|CF|MW|MY|FM|YT|MQ|MH|MV|ML|MT|EG|MG|MX|MK|MS|ME|MZ|MC|MA|MR|MU|MD|MM|YE|UG|UM|VI|UA|GB|GR|RW|RE|RU|RO|LU|LR|LA|LV|LI|LT|LY|LB|LS|VU|WF|VN|VA|VE|LK|AE|US|SA|WS|RS|CY|ST|SG|SX|SL|SY|SD|SR|KN|PM|BL|MF|LC|VC|SH|EA|SN|SC|SM|SO|SB|ES|SK|SI|SZ|SJ|CH|SE|HU|HM|HK|HT|HN]){2}$");
        Pattern PhonePattern = Pattern.compile("^([\\+0-9]){10,13}$");
        Pattern EmailPattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,4})$");
        if ((userInput.getFirstName() == null) || (userInput.getFirstName().isEmpty())) {
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
        if ((userInput.getGender() == null) || (userInput.getGender().isEmpty())) {
            errors.rejectValue("gender", "user.gender.noselect");
        } else if (!GenderPattern.matcher(userInput.getGender()).matches()) {
            errors.rejectValue("gender", "user.gender.invalid");
        }
        if ((userInput.getMonth() == null) || (userInput.getMonth().isEmpty())) {
            errors.rejectValue("month", "user.birthmonth.noselect");
        } else if (!MonthPattern.matcher(userInput.getMonth()).matches()) {
            errors.rejectValue("month", "user.birthmonth.invalid");
        }
        if ((userInput.getDate() == null) || (userInput.getDate().isEmpty())) {
            errors.rejectValue("date", "user.birthdate.noselect");
        } else if (!DatePattern.matcher(userInput.getDate()).matches()) {
            errors.rejectValue("date", "user.birthdate.invalid");
        }
        if ((userInput.getYear() == null) || (userInput.getYear().isEmpty())) {
            errors.rejectValue("year", "user.birthyear.noselect");
        } else if (!YearPattern.matcher(userInput.getYear()).matches()) {
            errors.rejectValue("year", "user.birthyear.invalid");
        }
        if ((userInput.getMonth() != null) && (!userInput.getMonth().isEmpty()) && (userInput.getDate() != null) && (!userInput.getDate().isEmpty()) && (userInput.getYear() != null) && (!userInput.getYear().isEmpty()) && (MonthPattern.matcher(userInput.getMonth()).matches()) && (DatePattern.matcher(userInput.getDate()).matches()) && (YearPattern.matcher(userInput.getYear()).matches())) {
            int birthDate2 = Integer.parseInt(userInput.getDate());
            int birthMonth2 = Integer.parseInt(userInput.getMonth());
            int birthYear2 = Integer.parseInt(userInput.getYear());
            if ((birthMonth2 < 1) || (birthMonth2 > 12) || ((birthMonth2 > currentmonth) && (birthYear2 == currentyear) && (birthDate2 > currentdate)) || (birthYear2 > currentyear)) {
                errors.rejectValue("month", "user.birthmonth.invalid");
            }
            if ((birthDate2 < 1) || (birthDate2 > 31) || (birthYear2 > currentyear) || ((birthDate2 > currentdate) && (birthMonth2 > currentmonth) && (birthYear2 == currentyear)) || ((birthYear2 % 400 != 0) && (birthYear2 % 4 != 0) && (birthMonth2 == 2) && (birthDate2 > 28)) || ((birthYear2 % 400 == 0 || birthYear2 % 4 == 0) && (birthMonth2 == 2) && (birthDate2 > 29)) || ((birthMonth2 == 4 || birthMonth2 == 6 || birthMonth2 == 9 || birthMonth2 == 11) && (birthDate2 > 30))) {
                errors.rejectValue("date", "user.birthdate.invalid");
            }
            if ((birthYear2 < currentyear - 115) || (birthYear2 > currentyear) || ((birthDate2 > currentdate) && (birthMonth2 > currentmonth) && (birthYear2 == currentyear))) {
                errors.rejectValue("year", "user.birthyear.invalid");
            } else if (birthYear2 > currentyear - 8) {
                errors.rejectValue("year", "user.birthyear.short");
            }
        }
        if ((userInput.getCountry() == null) || (userInput.getCountry().isEmpty())) {
            errors.rejectValue("country", "user.country.noselect");
        } else if (!CountryPattern.matcher(userInput.getCountry().toUpperCase()).matches()) {
            errors.rejectValue("country", "user.country.invalid");
        }
        if ((userInput.getEmailidPhone() == null) || (userInput.getEmailidPhone().isEmpty())) {
            errors.rejectValue("emailidPhone", "user.emailidphone.emptyfield");
        } else if ((!EmailPattern.matcher(userInput.getEmailidPhone()).matches()) && (!PhonePattern.matcher(userInput.getEmailidPhone()).matches())) {
            errors.rejectValue("emailidPhone", "user.emailidphone.invalid");
        } else if (userInput.getEmailidPhone().length() > 50) {
            errors.rejectValue("emailidPhone", "user.emailid.invalidlength");
        } else if (isVerified) {
            errors.rejectValue("emailidPhone", "user.account.exists");
        } else if ((GetAccount != null) && (!isVerified)) {
            userInput.setExistUser(true);
        }
        if ((userInput.getPassword() == null) || (userInput.getPassword().isEmpty())) {
            errors.rejectValue("password", "user.password.emptyfield");
        } else if ((userInput.getConfPassword() == null) || (!userInput.getPassword().equals(userInput.getConfPassword()))) {
            errors.rejectValue("password", "user.password.mismatch");
        } else if (userInput.getPassword().length() < 8 || userInput.getPassword().length() > 16) {
            errors.rejectValue("password", "user.password.invalidlength");
        }
        /*
        if ((userInput.getCaptchaCode() == null) || (userInput.getCaptchaCode().isEmpty())) {
            errors.rejectValue("captchaCode", "user.captchacode.emptyfield");
        } else if (!userInput.getCaptchaCode().equals("a")) {
            errors.rejectValue("captchaCode", "user.captchacode.wrong");
        }
        */
        if ((userInput.getTermsAndService() == null) || (userInput.getTermsAndService().isEmpty())) {
            errors.rejectValue("TermsAndService", "user.TermsAndService.noselect");
        } else if (!"accept".equals(userInput.getTermsAndService())) {
            errors.rejectValue("TermsAndService", "user.TermsAndService.invalid");
        }
    }

}
