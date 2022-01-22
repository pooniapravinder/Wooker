package pages.controller.moreinfo.addedit;

import java.util.regex.Pattern;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ValidateRelation implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Addrelation.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Addrelation userInput = (Addrelation) target;
        Pattern imagePattern = Pattern.compile("^image/([jpg|jpeg|png|bmp]+)$");

        if ((userInput.getRelatname() == null) || (userInput.getRelatname().isEmpty())) {
            errors.rejectValue("relatname", "user.relatname.emptyfield");
        } else if ((userInput.getRelatname().length() < 3) || (userInput.getRelatname().length() > 50)) {
            errors.rejectValue("relatname", "user.relatname.invalidlength");
        }
        if ((userInput.getRelation() == null) ||(userInput.getRelation().isEmpty())) {
            errors.rejectValue("relation", "user.relation.emptyfield");
        }else if(!userInput.getRelation().matches("^([1-9]|1[0-9]|2[0-9]|3[0-4])$")){
            errors.rejectValue("relation", "user.relation.invalid");
        }
        if ((userInput.getRelatpri() == null) || (!userInput.getRelatpri().matches("^([1-6])$"))) {
            userInput.setRelatpri("2");
        }
        if ((userInput.getRelatPic() != null) && (!userInput.getRelatPic().isEmpty()) && (!imagePattern.matcher(userInput.getRelatPic().getContentType().toLowerCase()).matches())) {
            errors.rejectValue("relatPic", "uploadpic.invalid.type");
        }
        if ((userInput.getRelatdesc() != null) && (userInput.getRelatdesc().length() > 100)) {
            errors.rejectValue("relatdesc", "user.description.invalidlength");
        }
    }

}
