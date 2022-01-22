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
import pages.controller.moreinfo.addedit.Addpogrcoll;
import pages.controller.moreinfo.addedit.ValidatePoGrColl;
import user.attachments.save.SaveImages;

@Controller
public class AddPoGrColl {

    @Autowired
    ValidatePoGrColl validation;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.setValidator(validation);
    }

    @RequestMapping(value = "/more/info/{option}/pogrcoll/", method = RequestMethod.GET)
    public String AddPoGrCollView(@PathVariable("option") String option, @RequestParam(value = "sqq", required = false) String id, Model model, HttpServletRequest request, HttpServletResponse response) {
        if (!option.matches("^(add|edit)$")) {
            throw new ResourceNotFoundException();
        }
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../../../login/";
        }
        Addpogrcoll addpogrcoll;
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
            addpogrcoll = new Addpogrcoll(getData);
        } else {
            addpogrcoll = new Addpogrcoll();
        }
        model.addAttribute("addpogrcoll", addpogrcoll);
        return "secinfo/addedit/pogrcoll";
    }

    @RequestMapping(value = "/more/info/{option}/pogrcoll/", method = RequestMethod.POST)
    public String AddPoGrCollSubmit(@PathVariable("option") String option, @RequestParam(value = "sqq", required = false) String id, @Valid Addpogrcoll addpogrcoll, BindingResult results, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (!option.matches("^(add|edit)$")) {
            throw new ResourceNotFoundException();
        }
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../../../login/";
        } else if (results.hasErrors()) {
            return "secinfo/addedit/pogrcoll";
        }
        long currTimestamp = System.currentTimeMillis();
        String defaultId;
        String picId = null;
        String college = addpogrcoll.getPogrColl();
        byte privacy = Byte.valueOf(addpogrcoll.getPogrCollPri());
        String entrance = addpogrcoll.getPogrCoenMonth() + "/" + addpogrcoll.getPogrCoenDate() + "/" + addpogrcoll.getPogrCoenYear();
        String leave = addpogrcoll.getPogrColeMonth() + "/" + addpogrcoll.getPogrColeDate() + "/" + addpogrcoll.getPogrColeYear();
        String desc = addpogrcoll.getPogrCoDesc();
        boolean privacy2 = addpogrcoll.getPogrCoPri() != null;
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
            if ((getData.getPogradcollege().equals(college)) && (getData.getPogradcollpri() == privacy) && (getData.getPogradcollentr().equals(entrance)) && (getData.getPogradcollleave().equals(leave)) && ((addpogrcoll.getPogrCoPic() == null) || (addpogrcoll.getPogrCoPic().isEmpty())) && (getData.getPogradcolldesc().equals(desc)) && (getData.getPogradcollPrivacy().equals(privacy2))) {
                return "redirect:../../";
            }
            picId = getData.getPicId();
        } else {
            defaultId = currTimestamp + "_" + user;
        }
        String deviceId = checkCookie.getDevice(request.getCookies());
        MoreInfoAction insertInfo = new MoreInfoAction();
        SaveImages saveImage = new SaveImages();
        if ((addpogrcoll.getPogrCoPic() != null) && (!addpogrcoll.getPogrCoPic().isEmpty())) {
            picId = defaultId;
            saveImage.SaveImage(addpogrcoll.getPogrCoPic(), picId);
        }
        Secondaryinfo getInfo = new Secondaryinfo(user, deviceId, defaultId, currTimestamp, false, null, null, null, null, null, null, picId, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, college, privacy, entrance, leave, desc, privacy2, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
        insertInfo.addSecondaryInfo(getInfo);
        return "redirect:../../";
    }
}
