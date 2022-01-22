package pages.controller.wooks;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import java.util.regex.Pattern;

@Component
public class WookValidation implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return NewWook.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        NewWook userInput = (NewWook) target;
        Pattern pattern = Pattern.compile("^[a-zA-Z-_.\\s]*$");
        Pattern imagePattern = Pattern.compile("^image/([jpg|jpeg|png|bmp]+)$");
        if ((userInput.getTitle() == null) || (userInput.getTitle().isEmpty())) {
            errors.rejectValue("title", "wook.title.emptyfield");
        } else if (!pattern.matcher(userInput.getTitle()).matches()) {
            errors.rejectValue("title", "wook.title.invalid");
        } else if ((userInput.getTitle() != null) && (userInput.getTitle().length() > 25)) {
            errors.rejectValue("title", "wook.title.length.invalid");
        }
        if ((userInput.getType() == null) || (userInput.getType().isEmpty())) {
            errors.rejectValue("type", "wook.type.emptyfield");
        }
        if ((userInput.getPhoto() != null) && (!userInput.getPhoto().isEmpty()) && (!imagePattern.matcher(userInput.getPhoto().getContentType().toLowerCase()).matches())) {
            errors.rejectValue("photo", "wook.photo.invalid.type");
        }
        if ((userInput.getCoverPhoto() != null) && (!userInput.getCoverPhoto().isEmpty()) && (!imagePattern.matcher(userInput.getCoverPhoto().getContentType().toLowerCase()).matches())) {
            errors.rejectValue("coverPhoto", "wook.coverphoto.invalid.type");
        }
        if ((userInput.getText()== null) && (userInput.getImage()==null) && (userInput.getAudio()==null) && (userInput.getVideo()==null) && (userInput.getFile()==null)) {
            errors.rejectValue("text", "wook.allowed.invalid");
        }
        if ((userInput.getTermsAndService() == null) || (userInput.getTermsAndService().isEmpty())) {
            errors.rejectValue("TermsAndService", "user.TermsAndService.noselect");
        } else if (!"accept".equals(userInput.getTermsAndService())) {
            errors.rejectValue("TermsAndService", "user.TermsAndService.invalid");
        }
    }

}
