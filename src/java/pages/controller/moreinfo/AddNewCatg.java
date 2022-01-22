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
import pages.controller.moreinfo.addedit.Addnewcatg;
import pages.controller.moreinfo.addedit.ValidateNewCatg;
import user.attachments.save.SaveImages;

@Controller
public class AddNewCatg {

    @Autowired
    ValidateNewCatg validation;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.setValidator(validation);
    }

    @RequestMapping(value = "/more/info/{option}/newcatg/", method = RequestMethod.GET)
    public String AddNewCatgView(@PathVariable("option") String option, @RequestParam(value = "sqq", required = false) String id, Model model, HttpServletRequest request, HttpServletResponse response) {
        if (!option.matches("^(add|edit)$")) {
            throw new ResourceNotFoundException();
        }
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../../../login/";
        }
        Addnewcatg addnewcatg;
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
            addnewcatg = new Addnewcatg(getData);
        } else {
            addnewcatg = new Addnewcatg();
        }
        model.addAttribute("addnewcatg", addnewcatg);
        return "secinfo/addedit/newcatg";
    }

    @RequestMapping(value = "/more/info/{option}/newcatg/", method = RequestMethod.POST)
    public String AddNewCatgSubmit(@PathVariable("option") String option, @RequestParam(value = "sqq", required = false) String id, @Valid Addnewcatg addnewcatg, BindingResult results, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (!option.matches("^(add|edit)$")) {
            throw new ResourceNotFoundException();
        }
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../../../login/";
        } else if (results.hasErrors()) {
            return "secinfo/addedit/newcatg";
        }
        long currTimestamp = System.currentTimeMillis();
        String defaultId;
        String picId = null;
        String name = addnewcatg.getNewcatgnam();
        String value = addnewcatg.getNewcatgval();
        byte privacy = Byte.valueOf(addnewcatg.getNewcatgpri());
        String desc = addnewcatg.getNewcatgdesc();
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
            if ((getData.getCategname().equals(name)) && (getData.getCategvalue().equals(value)) && (getData.getCategpri() == privacy) && ((addnewcatg.getNewcatgpic() == null) || (addnewcatg.getNewcatgpic().isEmpty())) && (getData.getCategdesc().equals(desc))) {
                return "redirect:../../";
            }
            picId = getData.getPicId();
        } else {
            defaultId = currTimestamp + "_" + user;
        }
        String deviceId = checkCookie.getDevice(request.getCookies());
        MoreInfoAction insertInfo = new MoreInfoAction();
        SaveImages saveImage = new SaveImages();
        if ((addnewcatg.getNewcatgpic() != null) && (!addnewcatg.getNewcatgpic().isEmpty())) {
            picId = defaultId;
            saveImage.SaveImage(addnewcatg.getNewcatgpic(), picId);
        }
        Secondaryinfo getInfo = new Secondaryinfo(user, deviceId, defaultId, currTimestamp, false, null, null, null, null, null, null, picId, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, name, value, privacy, desc);
        insertInfo.addSecondaryInfo(getInfo);
        return "redirect:../../";
    }
}
