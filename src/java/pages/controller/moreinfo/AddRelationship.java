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
import pages.controller.moreinfo.addedit.Addrelationship;
import pages.controller.moreinfo.addedit.ValidateRelationship;
import user.attachments.save.SaveImages;

@Controller
public class AddRelationship {

    @Autowired
    ValidateRelationship validation;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.setValidator(validation);
    }

    @RequestMapping(value = "/more/info/{option}/relationship/", method = RequestMethod.GET)
    public String AddRelationshipView(@PathVariable("option") String option, @RequestParam(value = "sqq", required = false) String id, Model model, HttpServletRequest request, HttpServletResponse response) {
        if (!option.matches("^(add|edit)$")) {
            throw new ResourceNotFoundException();
        }
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../../../login/";
        }
        Addrelationship addrelationship;
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
            addrelationship = new Addrelationship(getData);
        } else {
            addrelationship = new Addrelationship();
        }
        model.addAttribute("addrelationship", addrelationship);
        return "secinfo/addedit/relationship";
    }

    @RequestMapping(value = "/more/info/{option}/relationship/", method = RequestMethod.POST)
    public String AddRelationshipSubmit(@PathVariable("option") String option, @RequestParam(value = "sqq", required = false) String id, @Valid Addrelationship addrelationship, BindingResult results, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (!option.matches("^(add|edit)$")) {
            throw new ResourceNotFoundException();
        }
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../../../login/";
        } else if (results.hasErrors()) {
            return "secinfo/addedit/relationship";
        }
        long currTimestamp = System.currentTimeMillis();
        String defaultId;
        String picId = null;
        String name = addrelationship.getRelatiname();
        byte relationship = Byte.valueOf(addrelationship.getRelationship());
        String time = addrelationship.getRelatiMonth() + "/" + addrelationship.getRelatiDate() + "/" + addrelationship.getRelatiYear();
        byte privacy = Byte.valueOf(addrelationship.getRelatipri());
        String desc = addrelationship.getRelatidesc();
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
            if ((getData.getRelatiname().equals(name)) && (getData.getRelationship() == relationship) && (getData.getRelatitime().equals(time)) && (getData.getRelatipri() == privacy) && ((addrelationship.getRelatiPic() == null) || (addrelationship.getRelatiPic().isEmpty())) && (getData.getRelatidesc().equals(desc))) {
                return "redirect:../../";
            }
            picId = getData.getPicId();
        } else {
            defaultId = currTimestamp + "_" + user;
        }
        String deviceId = checkCookie.getDevice(request.getCookies());
        MoreInfoAction insertInfo = new MoreInfoAction();
        SaveImages saveImage = new SaveImages();
        if ((addrelationship.getRelatiPic() != null) && (!addrelationship.getRelatiPic().isEmpty())) {
            picId = defaultId;
            saveImage.SaveImage(addrelationship.getRelatiPic(), picId);
        }
        Secondaryinfo getInfo = new Secondaryinfo(user, deviceId, defaultId, currTimestamp, false, null, null, null, null, null, null, picId, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, name, relationship, time, privacy, desc, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
        insertInfo.addSecondaryInfo(getInfo);
        return "redirect:../../";
    }
}
