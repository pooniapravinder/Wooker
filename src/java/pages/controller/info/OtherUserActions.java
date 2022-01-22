package pages.controller.info;

import cookies.set.get.CheckSaveCookies;
import data.encryption.decryption.Cryptography;
import hibernate.mapping.Userchatlist;
import hibernate.query.chat.UserRelationActions;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pages.controller.errors.ResourceNotFoundException;

@Controller
public class OtherUserActions {

    @RequestMapping(value = {"/user/list/chat/"}, method = RequestMethod.GET)
    public String OtherUserChatlistView(Searchuserlist search, HttpServletRequest request, HttpServletResponse response) {
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../../login/";
        }
        return "chatlist";
    }

    @RequestMapping(value = {"/user/list/removed/", "/user/list/blocked/"}, method = RequestMethod.GET)
    public String OtherUserActionsView(Searchuserlist search, HttpServletRequest request, HttpServletResponse response) {
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../../login/";
        }
        return "removedblocked";
    }

    @RequestMapping(value = "/user/action/{option}/", method = RequestMethod.GET)
    public String OtherUserAction(@PathVariable("option") String option, @RequestParam(value = "sqq", required = true) String getId, @RequestParam(value = "pagination_forward", required = false) String forward, @RequestParam(value = "pagination_backward", required = false) String backward, @RequestParam(value = "refer", required = true) String refer, HttpServletRequest request, HttpServletResponse response) {
        if (!option.matches("^(accept|reject|cancel|remove|block|unblock)$")) {
            throw new ResourceNotFoundException();
        }
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../../login/";
        }
        Cryptography crypto = new Cryptography();
        String id = crypto.decrypt(getId);
        String url = "../../../home/";
        Pattern idPattern = Pattern.compile("^(([0-9]){1,})$");
        Pattern refPattern = Pattern.compile("^(YidMpE-GTpf_mgL|mmGeOlkf-Fnrf_t|oyNdkT-Nr_kqpFk|mUosKD-BwP_dOVX|hImLkOP-Pj_jkFT|Oid_pehRT-dEtNG|rnJeLo-Iwk_YeJW)$");
        if ((id == null) || (refer == null) || (!idPattern.matcher(id).matches()) || (!refPattern.matcher(refer).matches())) {
            return url;
        }
        boolean setOper = false;
        switch (refer) {
            case "YidMpE-GTpf_mgL":
                url = "user/list/chat/";
                if (backward != null) {
                    url = url + "?" + "pagination_backward=" + crypto.encodeURL(backward);
                } else if (forward != null) {
                    url = url + "?" + "pagination_forward=" + crypto.encodeURL(forward);
                }
                break;
            case "mmGeOlkf-Fnrf_t":
                url = "user/list/removed/";
                if (backward != null) {
                    url = url + "?" + "pagination_backward=" + crypto.encodeURL(backward);
                } else if (forward != null) {
                    url = url + "?" + "pagination_forward=" + crypto.encodeURL(forward);
                }
                break;
            case "oyNdkT-Nr_kqpFk":
                url = "user/list/blocked/";
                if (backward != null) {
                    url = url + "?" + "pagination_backward=" + crypto.encodeURL(backward);
                } else if (forward != null) {
                    url = url + "?" + "pagination_forward=" + crypto.encodeURL(forward);
                }
                break;
            case "mUosKD-BwP_dOVX":
                url = "info/" + "?sqq=" + crypto.encodeURL(getId);
                break;
            case "hImLkOP-Pj_jkFT":
                setOper = true;
                url = "user/send/message/" + "?sqq=";
                break;
            case "Oid_pehRT-dEtNG":
            case "rnJeLo-Iwk_YeJW":
                url = refer.equals("Oid_pehRT-dEtNG") ? "alerts/" : "alerts/sent/";
                if (backward != null) {
                    url = url + "?" + "pagination_backward=" + crypto.encodeURL(backward);
                } else if (forward != null) {
                    url = url + "?" + "pagination_forward=" + crypto.encodeURL(forward);
                }
                break;
        }
        long autoId = Long.parseLong(id);
        UserRelationActions saveAction = new UserRelationActions();
        Userchatlist preData = saveAction.getUserlistById(autoId);
        long otherUser = 0;
        if(preData!=null){
            otherUser = preData.getUserOne()==user ? preData.getUserTwo() : preData.getUserOne();
        }
        String deviceId = checkCookie.getDevice(request.getCookies());
        long timestamp = System.currentTimeMillis();
        switch (option) {
            case "accept":
                if ((preData != null) && (preData.isRequest()) && (user == preData.getUserTwo())) {
                    saveAction.InsertRequest(autoId, true);
                }
                break;
            case "reject":
            case "cancel":
                if ((preData != null) && (preData.isRequest()) && ((user == preData.getUserOne()) || (user == preData.getUserTwo()))) {
                    saveAction.InsertRequest(autoId, false);
                }
                break;
            case "remove":
                if ((preData != null) && (preData.isFriend())) {
                    saveAction.InsertRemove(autoId, user, otherUser);
                }
                break;
            case "block":
                if (preData == null) {
                    Userchatlist chatlist = new Userchatlist(timestamp, deviceId, user, Long.parseLong(id), 0, 0, 0, 0, 0, 0, false, true, false, false, 0, 0);
                    saveAction.insertAction(chatlist);
                } else {
                    saveAction.InsertBlockUnblock(autoId, user, otherUser, true);
                }
                break;
            case "unblock":
                if ((preData != null) && (preData.isBlocked()) && (preData.getUserOne() == user)) {
                    saveAction.InsertBlockUnblock(autoId, user, otherUser, false);
                }
                break;
        }
        return "redirect:../../../" + (setOper ? url + (preData != null ? crypto.encodeURL(crypto.encrypt(String.valueOf(autoId))) : null) : url);
    }

    @RequestMapping(value = "/user/action/{option}/all/", method = RequestMethod.GET)
    public String OtherUserActionAll(@PathVariable("option") String option, HttpServletRequest request, HttpServletResponse response) {
        if (!option.matches("^(accept|reject)$")) {
            throw new ResourceNotFoundException();
        }
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../../../login/";
        }
        UserRelationActions saveAction = new UserRelationActions();
        switch (option) {
            case "accept":
                    saveAction.InsertRequestAll(user,true);
                break;
            case "reject":
                saveAction.InsertRequestAll(user,false);
                break;
        }
        return "redirect:../../../../alerts/";
    }

}
