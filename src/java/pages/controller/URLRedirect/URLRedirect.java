package pages.controller.URLRedirect;

import java.io.IOException;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;
import pages.controller.errors.ResourceNotFoundException;

@Controller
public class URLRedirect {

    @RequestMapping(value = "/link/url/redirect/", method = RequestMethod.GET)
    public RedirectView URLRedirect(@RequestParam(value = "url", required = true) String url, HttpServletResponse response) throws IOException {
        Pattern WebsitePattern = Pattern.compile("^((http:\\/\\/)|(https:\\/\\/)|(www\\.)).*$");
        if (!WebsitePattern.matcher(url).matches()) {
            throw new ResourceNotFoundException();
        }
        return new RedirectView(url);
    }

}
