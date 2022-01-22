package pages.controller.chat;

import cookies.set.get.CheckSaveCookies;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SearchMessages {
    
    @RequestMapping(value = "/search/message/", method = RequestMethod.GET)
    public String SearchRedirect(Searchmsg search, HttpServletRequest request, HttpServletResponse response) {
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../login/";
        }
        return "redirect:../../chat/";
    }
    
    @RequestMapping(value = "/search/message/", method = RequestMethod.POST)
    public String SearchPage(Model model,Searchmsg search, HttpServletRequest request, HttpServletResponse response) {
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../login/";
        }
        if ((search.getSearchQuery() == null) || (search.getSearchQuery().isEmpty())) {
            return "redirect:../../home/";
        }
        model.addAttribute("query",search.getSearchQuery());
        return "chat/searchmsg";
    }
}
