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
import pages.controller.moreinfo.addedit.Addgrcollege;
import pages.controller.moreinfo.addedit.ValidateGrCollege;
import user.attachments.save.SaveImages;

@Controller
public class AddGrCollege {

    @Autowired
    ValidateGrCollege validation;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.setValidator(validation);
    }

    @RequestMapping(value = "/more/info/{option}/grcollege/", method = RequestMethod.GET)
    public String AddGrCollegeView(@PathVariable("option") String option, @RequestParam(value = "sqq", required = false) String id, Model model, HttpServletRequest request, HttpServletResponse response) {
        if (!option.matches("^(add|edit)$")) {
            throw new ResourceNotFoundException();
        }
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../../../login/";
        }
        Addgrcollege addgrcollege;
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
            addgrcollege = new Addgrcollege(getData);
        } else {
            addgrcollege = new Addgrcollege();
        }
        model.addAttribute("addgrcollege", addgrcollege);
        return "secinfo/addedit/grcollege";
    }

    @RequestMapping(value = "/more/info/{option}/grcollege/", method = RequestMethod.POST)
    public String AddGrCollegeSubmit(@PathVariable("option") String option, @RequestParam(value = "sqq", required = false) String id, @Valid Addgrcollege addgrcollege, BindingResult results, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (!option.matches("^(add|edit)$")) {
            throw new ResourceNotFoundException();
        }
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../../../login/";
        } else if (results.hasErrors()) {
            return "secinfo/addedit/grcollege";
        }
        long currTimestamp = System.currentTimeMillis();
        String defaultId;
        String picId = null;
        String college = addgrcollege.getGradColl();
        byte privacy = Byte.valueOf(addgrcollege.getGrCollPri());
        String entrance = addgrcollege.getGrCoenMonth() + "/" + addgrcollege.getGrCoenDate() + "/" + addgrcollege.getGrCoenYear();
        String leave = addgrcollege.getGrColeMonth() + "/" + addgrcollege.getGrColeDate() + "/" + addgrcollege.getGrColeYear();
        String desc = addgrcollege.getGrCoDesc();
        boolean privacy2 = addgrcollege.getGrCoPri() != null;
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
            if ((getData.getGradcollege().equals(college)) && (getData.getGradcollpri() == privacy) && (getData.getGradcollentr().equals(entrance)) && (getData.getGradcollleave().equals(leave)) && ((addgrcollege.getGrCoPic() == null) || (addgrcollege.getGrCoPic().isEmpty())) && (getData.getGradcolldesc().equals(desc)) && (getData.getGradcollPrivacy().equals(privacy2))) {
                return "redirect:../../";
            }
            picId = getData.getPicId();
        } else {
            defaultId = currTimestamp + "_" + user;
        }
        String deviceId = checkCookie.getDevice(request.getCookies());
        MoreInfoAction insertInfo = new MoreInfoAction();
        SaveImages saveImage = new SaveImages();
        if ((addgrcollege.getGrCoPic() != null) && (!addgrcollege.getGrCoPic().isEmpty())) {
            picId = defaultId;
            saveImage.SaveImage(addgrcollege.getGrCoPic(), picId);
        }
        Secondaryinfo getInfo = new Secondaryinfo(user, deviceId, defaultId, currTimestamp, false, null, null, null, null, null, null, picId, null, null, null, null, null, null, college, privacy, entrance, leave, desc, privacy2, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
        insertInfo.addSecondaryInfo(getInfo);
        return "redirect:../../";
    }
}
