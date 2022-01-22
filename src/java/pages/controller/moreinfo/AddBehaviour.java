package pages.controller.moreinfo;

import cookies.set.get.CheckSaveCookies;
import data.encryption.decryption.Cryptography;
import hibernate.mapping.Secondaryinfo;
import hibernate.query.info.MoreInfoAction;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pages.controller.errors.ResourceNotFoundException;
import pages.controller.moreinfo.addedit.Addbehaviour;
import pages.controller.moreinfo.addedit.ValidateBehaviour;

@Controller
public class AddBehaviour {

    @Autowired
    ValidateBehaviour validation;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.setValidator(validation);
    }

    @RequestMapping(value = "/more/info/{option}/behaviour/", method = RequestMethod.GET)
    public String AddBehaviourView(@PathVariable("option") String option, @RequestParam(value = "sqq", required = false) String id, Model model, HttpServletRequest request, HttpServletResponse response) {
        if (!option.matches("^(add|edit)$")) {
            throw new ResourceNotFoundException();
        }
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../../../login/";
        }
        Addbehaviour addbehaviour;
        if (option.equals("edit")) {
            Cryptography decrypt = new Cryptography();
            String defaultId = decrypt.decrypt(id);
            if (defaultId == null) {
                return "redirect:../../../../home/";
            }
            MoreInfoAction getInfo = new MoreInfoAction();
            Secondaryinfo getData = getInfo.getSingleSecInfo(defaultId, user);
            if (getData == null) {
                return "redirect:../../../../home/";
            }
            addbehaviour = new Addbehaviour(getData);
        } else {
            addbehaviour = new Addbehaviour();
        }
        model.addAttribute("addbehaviour", addbehaviour);
        return "secinfo/addedit/behaviour";
    }

    @RequestMapping(value = "/more/info/{option}/behaviour/", method = RequestMethod.POST)
    public String AddBehaviourSubmit(@PathVariable("option") String option, @RequestParam(value = "sqq", required = false) String id, @Valid Addbehaviour addbehaviour, BindingResult results, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (!option.matches("^(add|edit)$")) {
            throw new ResourceNotFoundException();
        }
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../../../login/";
        } else if (results.hasErrors()) {
            return "secinfo/addedit/behaviour";
        }
        long currTimestamp = System.currentTimeMillis();
        String defaultId;
        String behaviour = addbehaviour.getBehaviour();
        byte privacy = Byte.valueOf(addbehaviour.getBehavpri());
        String desc = addbehaviour.getBehavdesc();
        if (option.equals("edit")) {
            Cryptography decrypt = new Cryptography();
            defaultId = decrypt.decrypt(id);
            if (defaultId == null) {
                return "redirect:../../../../home/";
            }
            MoreInfoAction getInfo = new MoreInfoAction();
            Secondaryinfo getData = getInfo.getSingleSecInfo(defaultId, user);
            if (getData == null) {
                return "redirect:../../../../home/";
            }
            if ((getData.getBehaviour().equals(behaviour)) && (getData.getBehavpri() == privacy) && (getData.getBehavdesc().equals(desc))) {
                return "redirect:../../";
            }
        } else {
            defaultId = currTimestamp + "_" + user;
        }
        String deviceId = checkCookie.getDevice(request.getCookies());
        MoreInfoAction insertInfo = new MoreInfoAction();
        Secondaryinfo getInfo = new Secondaryinfo(user, deviceId, defaultId, currTimestamp, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, behaviour, privacy, desc, null, null, null, null, null, null, null);
        insertInfo.addSecondaryInfo(getInfo);
        return "redirect:../../";
    }
}
