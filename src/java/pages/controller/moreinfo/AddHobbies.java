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
import pages.controller.moreinfo.addedit.Addhobbies;
import pages.controller.moreinfo.addedit.ValidateHobbies;
import user.attachments.save.SaveImages;

@Controller
public class AddHobbies {

    @Autowired
    ValidateHobbies validation;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.setValidator(validation);
    }

    @RequestMapping(value = "/more/info/{option}/hobbies/", method = RequestMethod.GET)
    public String AddHobbiesView(@PathVariable("option") String option, @RequestParam(value = "sqq", required = false) String id, Model model, HttpServletRequest request, HttpServletResponse response) {
        if (!option.matches("^(add|edit)$")) {
            throw new ResourceNotFoundException();
        }
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../../../login/";
        }
        Addhobbies addhobbies;
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
            addhobbies = new Addhobbies(getData);
        } else {
            addhobbies = new Addhobbies();
        }
        model.addAttribute("addhobbies", addhobbies);
        return "secinfo/addedit/hobbies";
    }

    @RequestMapping(value = "/more/info/{option}/hobbies/", method = RequestMethod.POST)
    public String AddHobbiesSubmit(@PathVariable("option") String option, @RequestParam(value = "sqq", required = false) String id, @Valid Addhobbies addhobbies, BindingResult results, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (!option.matches("^(add|edit)$")) {
            throw new ResourceNotFoundException();
        }
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../../../login/";
        } else if (results.hasErrors()) {
            return "secinfo/addedit/hobbies";
        }
        long currTimestamp = System.currentTimeMillis();
        String defaultId;
        String picId = null;
        String hobbies = addhobbies.getHobbies();
        byte privacy = Byte.valueOf(addhobbies.getHobpri());
        String desc = addhobbies.getHobdesc();
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
            if ((getData.getHobbies().equals(hobbies)) && (getData.getHobbpri() == privacy) && ((addhobbies.getHobPic() == null) || (addhobbies.getHobPic().isEmpty())) && (getData.getHobbiesdesc().equals(desc))) {
                return "redirect:../../";
            }
            picId = getData.getPicId();
        } else {
            defaultId = currTimestamp + "_" + user;
        }
        String deviceId = checkCookie.getDevice(request.getCookies());
        MoreInfoAction insertInfo = new MoreInfoAction();
        SaveImages saveImage = new SaveImages();
        if ((addhobbies.getHobPic() != null) && (!addhobbies.getHobPic().isEmpty())) {
            picId = defaultId;
            saveImage.SaveImage(addhobbies.getHobPic(), picId);
        }
        Secondaryinfo getInfo = new Secondaryinfo(user, deviceId, defaultId, currTimestamp, false, null, null, null, null, null, null, picId, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, hobbies, privacy, desc, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
        insertInfo.addSecondaryInfo(getInfo);
        return "redirect:../../";
    }
}
