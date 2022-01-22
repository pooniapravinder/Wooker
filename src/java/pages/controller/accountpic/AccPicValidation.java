package pages.controller.accountpic;

import java.util.regex.Pattern;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class AccPicValidation implements Validator {
    
    @Override
    public boolean supports(Class<?> clazz) {
        return Accpicoper.class.isAssignableFrom(clazz);
    }
    
    @Override
    public void validate(Object target, Errors errors) {
        Accpicoper userInput = (Accpicoper)target;
        Pattern imagePattern = Pattern.compile("^image/([jpg|jpeg|png|bmp]+)$");
        if((userInput.getImg()==null)||(userInput.getImg().isEmpty())){
            errors.rejectValue("img","uploadpic.select.image");
        }else{
            if(!imagePattern.matcher(userInput.getImg().getContentType().toLowerCase()).matches()){
                errors.rejectValue("img","uploadpic.invalid.type");
            }else if(userInput.getImg().getOriginalFilename().length()>65500){
                errors.rejectValue("img","uploadpic.invalid.name");
            }
        }
    }

}
