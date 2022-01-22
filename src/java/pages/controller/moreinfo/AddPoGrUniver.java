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
import pages.controller.moreinfo.addedit.Addpogruniver;
import pages.controller.moreinfo.addedit.ValidatePoGrUniver;
import user.attachments.save.SaveImages;

@Controller
public class AddPoGrUniver {

    @Autowired
    ValidatePoGrUniver validation;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.setValidator(validation);
    }

    @RequestMapping(value = "/more/info/{option}/pogruniver/", method = RequestMethod.GET)
    public String AddPoGrUniverView(@PathVariable("option") String option, @RequestParam(value = "sqq", required = false) String id, Model model, HttpServletRequest request, HttpServletResponse response) {
        if (!option.matches("^(add|edit)$")) {
            throw new ResourceNotFoundException();
        }
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../../../login/";
        }
        Addpogruniver addpogruniver;
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
            addpogruniver = new Addpogruniver(getData);
        } else {
            addpogruniver = new Addpogruniver();
        }
        model.addAttribute("addpogruniver", addpogruniver);
        return "secinfo/addedit/pogruniver";
    }

    @RequestMapping(value = "/more/info/{option}/pogruniver/", method = RequestMethod.POST)
    public String AddPoGrUniverSubmit(@PathVariable("option") String option, @RequestParam(value = "sqq", required = false) String id, @Valid Addpogruniver addpogruniver, BindingResult results, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (!option.matches("^(add|edit)$")) {
            throw new ResourceNotFoundException();
        }
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../../../login/";
        } else if (results.hasErrors()) {
            return "secinfo/addedit/pogruniver";
        }
        long currTimestamp = System.currentTimeMillis();
        String defaultId;
        String picId = null;
        String university = addpogruniver.getPogrUniver();
        byte privacy = Byte.valueOf(addpogruniver.getPogrUnPri());
        String entrance = addpogruniver.getPogrUnenMonth() + "/" + addpogruniver.getPogrUnenDate() + "/" + addpogruniver.getPogrUnenYear();
        String leave = addpogruniver.getPogrUnleMonth() + "/" + addpogruniver.getPogrUnleDate() + "/" + addpogruniver.getPogrUnleYear();
        String desc = addpogruniver.getPogrUnDesc();
        boolean privacy2 = addpogruniver.getPogradUnPri() != null;
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
            if ((getData.getPograduniver().equals(university)) && (getData.getPograduniverpri() == privacy) && (getData.getPograduniverentr().equals(entrance)) && (getData.getPograduniverleave().equals(leave)) && ((addpogruniver.getPogrUnPic() == null) || (addpogruniver.getPogrUnPic().isEmpty())) && (getData.getPograduniverdesc().equals(desc)) && (getData.getPograduniverPrivacy().equals(privacy2))) {
                return "redirect:../../";
            }
            picId = getData.getPicId();
        } else {
            defaultId = currTimestamp + "_" + user;
        }
        String deviceId = checkCookie.getDevice(request.getCookies());
        MoreInfoAction insertInfo = new MoreInfoAction();
        SaveImages saveImage = new SaveImages();
        if ((addpogruniver.getPogrUnPic() != null) && (!addpogruniver.getPogrUnPic().isEmpty())) {
            picId = defaultId;
            saveImage.SaveImage(addpogruniver.getPogrUnPic(), picId);
        }
        Secondaryinfo getInfo = new Secondaryinfo(user, deviceId, defaultId, currTimestamp, false, null, null, null, null, null, null, picId, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, university, privacy, entrance, leave, desc, privacy2, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
        insertInfo.addSecondaryInfo(getInfo);
        return "redirect:../../";
    }
}
