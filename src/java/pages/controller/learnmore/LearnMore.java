package pages.controller.learnmore;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LearnMore {

    @RequestMapping(value = "/wooker/learn/more/{id}/", method = RequestMethod.GET)
    public String EditInfoview(@PathVariable("id") String id) {
        return "learnmore"+"/"+id;
    }
}
