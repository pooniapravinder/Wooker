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
import pages.controller.moreinfo.addedit.Addwork;
import pages.controller.moreinfo.addedit.ValidateWork;
import user.attachments.save.SaveImages;

@Controller
public class AddWork {

    @Autowired
    ValidateWork validation;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.setValidator(validation);
    }

    @RequestMapping(value = "/more/info/{option}/work/", method = RequestMethod.GET)
    public String AddWorkView(@PathVariable("option") String option, @RequestParam(value = "sqq", required = false) String id, Model model, HttpServletRequest request, HttpServletResponse response) {
        if (!option.matches("^(add|edit)$")) {
            throw new ResourceNotFoundException();
        }
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../../../login/";
        }
        Addwork addwork;
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
            addwork = new Addwork(getData);
        } else {
            addwork = new Addwork();
        }
        model.addAttribute("addwork", addwork);
        return "secinfo/addedit/work";
    }

    @RequestMapping(value = "/more/info/{option}/work/", method = RequestMethod.POST)
    public String AddWorkSubmit(@PathVariable("option") String option, @RequestParam(value = "sqq", required = false) String id, @Valid Addwork addwork, BindingResult results, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (!option.matches("^(add|edit)$")) {
            throw new ResourceNotFoundException();
        }
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../../../login/";
        } else if (results.hasErrors()) {
            return "secinfo/addedit/work";
        }
        long currTimestamp = System.currentTimeMillis();
        String defaultId;
        String picId = null;
        String type = addwork.getWorktype();
        String place = addwork.getWorkplace();
        byte privacy = Byte.valueOf(addwork.getWorkPri());
        String start = addwork.getWoenMonth() + "/" + addwork.getWoenDate() + "/" + addwork.getWoenYear();
        String leave = addwork.getWoleMonth() + "/" + addwork.getWoleDate() + "/" + addwork.getWoleYear();
        String desc = addwork.getWorkDesc();
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
            if ((getData.getWorktype().equals(type)) && (getData.getWorkplace().equals(place)) && (getData.getWorkpri() == privacy) && (getData.getWorkstart().equals(start)) && (getData.getWorkleave().equals(leave)) && ((addwork.getWorkPic() == null) || (addwork.getWorkPic().isEmpty())) && (getData.getWorkdesc().equals(desc))) {
                return "redirect:../../";
            }
            picId = getData.getPicId();
        } else {
            defaultId = currTimestamp + "_" + user;
        }
        String deviceId = checkCookie.getDevice(request.getCookies());
        MoreInfoAction insertInfo = new MoreInfoAction();
        SaveImages saveImage = new SaveImages();
        if ((addwork.getWorkPic() != null) && (!addwork.getWorkPic().isEmpty())) {
            picId = defaultId;
            saveImage.SaveImage(addwork.getWorkPic(), picId);
        }
        Secondaryinfo getInfo = new Secondaryinfo(user, deviceId, defaultId, currTimestamp, false, null, null, null, null, null, null, picId, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, type, place, privacy, start, leave, desc, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
        insertInfo.addSecondaryInfo(getInfo);
        return "redirect:../../";
    }
}
