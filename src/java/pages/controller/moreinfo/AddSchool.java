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
import pages.controller.moreinfo.addedit.Addschool;
import pages.controller.moreinfo.addedit.ValidateSchool;
import user.attachments.save.SaveImages;

@Controller
public class AddSchool {

    @Autowired
    ValidateSchool validation;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.setValidator(validation);
    }

    @RequestMapping(value = "/more/info/{option}/school/", method = RequestMethod.GET)
    public String AddSchoolView(@PathVariable("option") String option, @RequestParam(value = "sqq", required = false) String id, Model model, HttpServletRequest request, HttpServletResponse response) {
        if (!option.matches("^(add|edit)$")) {
            throw new ResourceNotFoundException();
        }
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../../../login/";
        }
        Addschool addschool;
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
            addschool = new Addschool(getData);
        } else {
            addschool = new Addschool();
        }
        model.addAttribute("addschool", addschool);
        return "secinfo/addedit/school";
    }

    @RequestMapping(value = "/more/info/{option}/school/", method = RequestMethod.POST)
    public String AddSchoolSubmit(@PathVariable("option") String option, @RequestParam(value = "sqq", required = false) String id, @Valid Addschool addschool, BindingResult results, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (!option.matches("^(add|edit)$")) {
            throw new ResourceNotFoundException();
        }
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../../../login/";
        } else if (results.hasErrors()) {
            return "secinfo/addedit/school";
        }
        long currTimestamp = System.currentTimeMillis();
        String defaultId;
        String picId = null;
        String school = addschool.getUserSchool();
        byte privacy = Byte.valueOf(addschool.getSchPri());
        String entrance = addschool.getSchenMonth() + "/" + addschool.getSchenDate() + "/" + addschool.getSchenYear();
        String leave = addschool.getSchleMonth() + "/" + addschool.getSchleDate() + "/" + addschool.getSchleYear();
        String desc = addschool.getSchDesc();
        boolean privacy2 = addschool.getSchlPri() != null;
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
            if ((getData.getSchool().equals(school)) && (getData.getSchoolpri() == privacy) && (getData.getSchoolentr().equals(entrance)) && (getData.getSchoolleave().equals(leave)) && ((addschool.getSchPic() == null) || (addschool.getSchPic().isEmpty())) && (getData.getSchooldesc().equals(desc)) && (getData.getSchoolPrivacy().equals(privacy2))) {
                return "redirect:../../";
            }
            picId = getData.getPicId();
        } else {
            defaultId = currTimestamp + "_" + user;
        }
        String deviceId = checkCookie.getDevice(request.getCookies());
        MoreInfoAction insertInfo = new MoreInfoAction();
        SaveImages saveImage = new SaveImages();
        if ((addschool.getSchPic() != null) && (!addschool.getSchPic().isEmpty())) {
            picId = currTimestamp + "_" + user;
            saveImage.SaveImage(addschool.getSchPic(), picId);
        }
        Secondaryinfo getInfo = new Secondaryinfo(user, deviceId, defaultId, currTimestamp, false, null, null, null, null, null, null, picId, school, privacy, entrance, leave, desc, privacy2, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
        insertInfo.addSecondaryInfo(getInfo);
        return "redirect:../../";
    }
}
