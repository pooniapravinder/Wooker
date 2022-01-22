package pages.controller.moreinfo;

import cookies.set.get.CheckSaveCookies;
import data.encryption.decryption.Cryptography;
import hibernate.mapping.Secondaryinfo;
import hibernate.query.info.MoreInfoAction;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pages.controller.errors.ResourceNotFoundException;

@Controller
public class RemoveMoreInfo {

    @RequestMapping(value = "/more/info/remove/detail/", method = RequestMethod.GET)
    public String RemoveMoreInfo(@RequestParam(value = "sqq", required = true) String id, HttpServletRequest request, HttpServletResponse response) {
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../../../login/";
        }
        Cryptography decrypt = new Cryptography();
        String defaultId = decrypt.decrypt(id);
        if (defaultId == null) {
            return "redirect:../../../../home/";
        }
        MoreInfoAction getInfo = new MoreInfoAction();
        Secondaryinfo getData = getInfo.getSingleSecInfo(defaultId, user);
        if ((getData == null) || (getData.getDeleted())) {
            return "redirect:../../../../home/";
        }
        String deviceId = checkCookie.getDevice(request.getCookies());
        Secondaryinfo insertInfo = new Secondaryinfo(user, deviceId, defaultId, System.currentTimeMillis(), true, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
        getInfo.addSecondaryInfo(insertInfo);
        return "redirect:../../";
    }

    @RequestMapping(value = "/more/info/set/privacy/{option}/", method = RequestMethod.GET)
    public String SetMoreInfoPrivacy(@PathVariable("option") String option, @RequestParam(value = "sqq", required = true) String id, HttpServletRequest request, HttpServletResponse response) {
        if (!option.matches("^(school|grcollege|gruniver|pogrcoll|pogruniver)$")) {
            throw new ResourceNotFoundException();
        }
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../../../../login/";
        }
        Cryptography decrypt = new Cryptography();
        String defaultId = decrypt.decrypt(id);
        if (defaultId == null) {
            return "redirect:../../../../../home/";
        }
        MoreInfoAction getInfo = new MoreInfoAction();
        Secondaryinfo getData = getInfo.getSingleSecInfo(defaultId, user);
        if ((getData == null) || (getData.getDeleted()) || ((option.equals("school"))&&(getData.getSchoolPrivacy())) || ((option.equals("grcollege"))&&(getData.getGradcollPrivacy())) || ((option.equals("gruniver"))&&(getData.getGraduniverPrivacy())) || ((option.equals("pogrcoll"))&&(getData.getPogradcollPrivacy())) || ((option.equals("pogruniver"))&&(getData.getPograduniverPrivacy()))) {
            return "redirect:../../../../../home/";
        }
        String deviceId = checkCookie.getDevice(request.getCookies());
        Secondaryinfo insertInfo = null;
        switch (option) {
            case "school":
                insertInfo = new Secondaryinfo(user, deviceId, defaultId, System.currentTimeMillis(), false, null, null, null, null, null, null, getData.getPicId(), getData.getSchool(), getData.getSchoolpri(), getData.getSchoolentr(), getData.getSchoolleave(), getData.getSchooldesc(), true, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
                break;
            case "grcollege":
                insertInfo = new Secondaryinfo(user, deviceId, defaultId, System.currentTimeMillis(), false, null, null, null, null, null, null, getData.getPicId(), null, null, null, null, null, null, getData.getGradcollege(), getData.getGradcollpri(), getData.getGradcollentr(), getData.getGradcollleave(), getData.getGradcolldesc(), true, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
                break;
            case "gruniver":
                insertInfo = new Secondaryinfo(user, deviceId, defaultId, System.currentTimeMillis(), false, null, null, null, null, null, null, getData.getPicId(), null, null, null, null, null, null, null, null, null, null, null, null, getData.getGraduniver(), getData.getGraduniverpri(), getData.getGraduniverentr(), getData.getGraduniverleave(), getData.getGraduniverdesc(), true, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
                break;
            case "pogrcoll":
                insertInfo = new Secondaryinfo(user, deviceId, defaultId, System.currentTimeMillis(), false, null, null, null, null, null, null, getData.getPicId(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, getData.getPogradcollege(), getData.getPogradcollpri(), getData.getPogradcollentr(), getData.getPogradcollleave(), getData.getPogradcolldesc(), true, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
                break;
            case "pogruniver":
                insertInfo = new Secondaryinfo(user, deviceId, defaultId, System.currentTimeMillis(), false, null, null, null, null, null, null, getData.getPicId(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, getData.getPograduniver(), getData.getPograduniverpri(), getData.getPograduniverentr(), getData.getPograduniverleave(), getData.getPograduniverdesc(), true, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
                break;
        }
        getInfo.addSecondaryInfo(insertInfo);
        return "redirect:../../../";
    }

    @RequestMapping(value = "/more/info/remove/privacy/{option}/", method = RequestMethod.GET)
    public String RemoveMoreInfoPrivacy(@PathVariable("option") String option, @RequestParam(value = "sqq", required = true) String id, HttpServletRequest request, HttpServletResponse response) {
        if (!option.matches("^(school|grcollege|gruniver|pogrcoll|pogruniver)$")) {
            throw new ResourceNotFoundException();
        }
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../../../../login/";
        }
        Cryptography decrypt = new Cryptography();
        String defaultId = decrypt.decrypt(id);
        if (defaultId == null) {
            return "redirect:../../../../../home/";
        }
        MoreInfoAction getInfo = new MoreInfoAction();
        Secondaryinfo getData = getInfo.getSingleSecInfo(defaultId, user);
        if ((getData == null) || (getData.getDeleted()) || ((option.equals("school"))&&(!getData.getSchoolPrivacy())) || ((option.equals("grcollege"))&&(!getData.getGradcollPrivacy())) || ((option.equals("gruniver"))&&(!getData.getGraduniverPrivacy())) || ((option.equals("pogrcoll"))&&(!getData.getPogradcollPrivacy())) || ((option.equals("pogruniver"))&&(!getData.getPograduniverPrivacy()))) {
            return "redirect:../../../../../home/";
        }
        String deviceId = checkCookie.getDevice(request.getCookies());
        Secondaryinfo insertInfo = null;
        switch (option) {
            case "school":
                insertInfo = new Secondaryinfo(user, deviceId, defaultId, System.currentTimeMillis(), false, null, null, null, null, null, null, getData.getPicId(), getData.getSchool(), getData.getSchoolpri(), getData.getSchoolentr(), getData.getSchoolleave(), getData.getSchooldesc(), false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
                break;
            case "grcollege":
                insertInfo = new Secondaryinfo(user, deviceId, defaultId, System.currentTimeMillis(), false, null, null, null, null, null, null, getData.getPicId(), null, null, null, null, null, null, getData.getGradcollege(), getData.getGradcollpri(), getData.getGradcollentr(), getData.getGradcollleave(), getData.getGradcolldesc(), false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
                break;
            case "gruniver":
                insertInfo = new Secondaryinfo(user, deviceId, defaultId, System.currentTimeMillis(), false, null, null, null, null, null, null, getData.getPicId(), null, null, null, null, null, null, null, null, null, null, null, null, getData.getGraduniver(), getData.getGraduniverpri(), getData.getGraduniverentr(), getData.getGradcollleave(), getData.getGraduniverdesc(), false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
                break;
            case "pogrcoll":
                insertInfo = new Secondaryinfo(user, deviceId, defaultId, System.currentTimeMillis(), false, null, null, null, null, null, null, getData.getPicId(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, getData.getPogradcollege(), getData.getPogradcollpri(), getData.getPogradcollentr(), getData.getPogradcollleave(), getData.getPogradcolldesc(), false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
                break;
            case "pogruniver":
                insertInfo = new Secondaryinfo(user, deviceId, defaultId, System.currentTimeMillis(), false, null, null, null, null, null, null, getData.getPicId(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, getData.getPograduniver(), getData.getPograduniverpri(), getData.getPograduniverentr(), getData.getPograduniverleave(), getData.getPograduniverdesc(), false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
                break;
        }
        getInfo.addSecondaryInfo(insertInfo);
        return "redirect:../../../";
    }
}
