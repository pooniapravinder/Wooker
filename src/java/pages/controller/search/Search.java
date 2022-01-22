package pages.controller.search;

import cookies.set.get.CheckSaveCookies;
import hibernate.mapping.Searches;
import hibernate.query.SearchQuery;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Search {

    @RequestMapping(value = "/search/", method = RequestMethod.GET)
    public String SearchPage(Searchuser searchuser, HttpServletRequest request, HttpServletResponse response) {
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../login/";
        }
        if ((searchuser.getSearchQuery() != null) && (!searchuser.getSearchQuery().isEmpty())) {
            String deviceId = checkCookie.getDevice(request.getCookies());
            SearchQuery saveSearch = new SearchQuery();
            Searches searchObj = new Searches(user, deviceId, searchuser.getSearchQuery(), System.currentTimeMillis());
            saveSearch.InsertSearch(searchObj);
            return "search";
        } else {
            return "home";
        }
    }

}
