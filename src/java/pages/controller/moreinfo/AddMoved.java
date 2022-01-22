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
import pages.controller.moreinfo.addedit.Addmoved;
import pages.controller.moreinfo.addedit.ValidateMoved;
import user.attachments.save.SaveImages;

@Controller
public class AddMoved {

    @Autowired
    ValidateMoved validation;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.setValidator(validation);
    }

    @RequestMapping(value = "/more/info/{option}/moved/", method = RequestMethod.GET)
    public String AddMovedView(@PathVariable("option") String option, @RequestParam(value = "sqq", required = false) String id, Model model, HttpServletRequest request, HttpServletResponse response) {
        if (!option.matches("^(add|edit)$")) {
            throw new ResourceNotFoundException();
        }
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../../../login/";
        }
        Addmoved addmoved;
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
            addmoved = new Addmoved(getData);
        } else {
            addmoved = new Addmoved();
        }
        model.addAttribute("addmoved", addmoved);
        return "secinfo/addedit/moved";
    }

    @RequestMapping(value = "/more/info/{option}/moved/", method = RequestMethod.POST)
    public String AddMovedSubmit(@PathVariable("option") String option, @RequestParam(value = "sqq", required = false) String id, @Valid Addmoved addmoved, BindingResult results, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (!option.matches("^(add|edit)$")) {
            throw new ResourceNotFoundException();
        }
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../../../login/";
        } else if (results.hasErrors()) {
            return "secinfo/addedit/moved";
        }
        long currTimestamp = System.currentTimeMillis();
        String defaultId;
        String picId = null;
        String from = addmoved.getMovedfrom();
        String to = addmoved.getMovedto();
        byte privacy = Byte.valueOf(addmoved.getMovedPri());
        String time = addmoved.getMovedMonth() + "/" + addmoved.getMovedDate() + "/" + addmoved.getMovedYear();
        String desc = addmoved.getMovedDesc();
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
            if ((getData.getMovedfrom().equals(from)) && (getData.getMovedto().equals(to)) && (getData.getMovedpri() == privacy) && (getData.getMovedtime().equals(time)) && ((addmoved.getMovedPic() == null) || (addmoved.getMovedPic().isEmpty())) && (getData.getMoveddesc().equals(desc))) {
                return "redirect:../../";
            }
            picId = getData.getPicId();
        } else {
            defaultId = currTimestamp + "_" + user;
        }
        String deviceId = checkCookie.getDevice(request.getCookies());
        MoreInfoAction insertInfo = new MoreInfoAction();
        SaveImages saveImage = new SaveImages();
        if ((addmoved.getMovedPic() != null) && (!addmoved.getMovedPic().isEmpty())) {
            picId = defaultId;
            saveImage.SaveImage(addmoved.getMovedPic(), picId);
        }
        Secondaryinfo getInfo = new Secondaryinfo(user, deviceId, defaultId, currTimestamp, false, null, null, null, null, null, null, picId, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, from, to, privacy, time, desc, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
        insertInfo.addSecondaryInfo(getInfo);
        return "redirect:../../";
    }
}
