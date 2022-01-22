package pages.controller.errors;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomErrors {
    
    @RequestMapping(value = "/error/cookies/", method = RequestMethod.GET)
    public String CookiesDisableget(){
        return "errors/CookiesError";
    }
     
    @RequestMapping(value = "/error/http/", method = RequestMethod.GET)
    public ModelAndView httpErrorPages(HttpServletRequest request){
        ModelAndView webPage = new ModelAndView("errors/httperrors");
        String error = null;
        int httpErrorCode = (int) request.getAttribute("javax.servlet.error.status_code");
        switch(httpErrorCode){
            case 400:
                error = "400";
                break;
            case 404:
                error = "404";
                break;
            case 500:
                error = "500";
                break;
        }
        webPage.addObject("error",error);
        return webPage;
    }

}
