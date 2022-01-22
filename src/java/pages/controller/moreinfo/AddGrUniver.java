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
import pages.controller.moreinfo.addedit.Addgruniver;
import pages.controller.moreinfo.addedit.ValidateGrUniver;
import user.attachments.save.SaveImages;

@Controller
public class AddGrUniver {

    @Autowired
    ValidateGrUniver validation;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.setValidator(validation);
    }

    @RequestMapping(value = "/more/info/{option}/gruniver/", method = RequestMethod.GET)
    public String AddGrUniverView(@PathVariable("option") String option, @RequestParam(value = "sqq", required = false) String id, Model model, HttpServletRequest request, HttpServletResponse response) {
        if (!option.matches("^(add|edit)$")) {
            throw new ResourceNotFoundException();
        }
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../../../login/";
        }
        Addgruniver addgruniver;
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
            addgruniver = new Addgruniver(getData);
        } else {
            addgruniver = new Addgruniver();
        }
        model.addAttribute("addgruniver", addgruniver);
        return "secinfo/addedit/gruniver";
    }

    @RequestMapping(value = "/more/info/{option}/gruniver/", method = RequestMethod.POST)
    public String AddGrUniverSubmit(@PathVariable("option") String option, @RequestParam(value = "sqq", required = false) String id, @Valid Addgruniver addgruniver, BindingResult results, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (!option.matches("^(add|edit)$")) {
            throw new ResourceNotFoundException();
        }
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../../../login/";
        } else if (results.hasErrors()) {
            return "secinfo/addedit/gruniver";
        }
        long currTimestamp = System.currentTimeMillis();
        String defaultId;
        String picId = null;
        String university = addgruniver.getGradUniver();
        byte privacy = Byte.valueOf(addgruniver.getGrUnPri());
        String entrance = addgruniver.getGrUnenMonth() + "/" + addgruniver.getGrUnenDate() + "/" + addgruniver.getGrUnenYear();
        String leave = addgruniver.getGrUnleMonth() + "/" + addgruniver.getGrUnleDate() + "/" + addgruniver.getGrUnleYear();
        String desc = addgruniver.getGradUnDesc();
        boolean privacy2 = addgruniver.getGradUnPri() != null;
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
            if ((getData.getGraduniver().equals(university)) && (getData.getGraduniverpri() == privacy) && (getData.getGraduniverentr().equals(entrance)) && (getData.getGraduniverleave().equals(leave)) && ((addgruniver.getGradUnPic() == null) || (addgruniver.getGradUnPic().isEmpty())) && (getData.getGraduniverdesc().equals(desc)) && (getData.getGraduniverPrivacy().equals(privacy2))) {
                return "redirect:../../";
            }
            picId = getData.getPicId();
        } else {
            defaultId = currTimestamp + "_" + user;
        }
        String deviceId = checkCookie.getDevice(request.getCookies());
        MoreInfoAction insertInfo = new MoreInfoAction();
        SaveImages saveImage = new SaveImages();
        if ((addgruniver.getGradUnPic() != null) && (!addgruniver.getGradUnPic().isEmpty())) {
            picId = defaultId;
            saveImage.SaveImage(addgruniver.getGradUnPic(), picId);
        }
        Secondaryinfo getInfo = new Secondaryinfo(user, deviceId, defaultId, currTimestamp, false, null, null, null, null, null, null, picId, null, null, null, null, null, null, null, null, null, null, null, null, university, privacy, entrance, leave, desc, privacy2, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
        insertInfo.addSecondaryInfo(getInfo);
        return "redirect:../../";
    }
}
