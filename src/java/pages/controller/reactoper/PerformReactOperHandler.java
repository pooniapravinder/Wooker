package pages.controller.reactoper;

import cookies.set.get.CheckSaveCookies;
import hibernate.mapping.Blocklist;
import hibernate.mapping.Chatuseroptions;
import hibernate.mapping.Comments;
import hibernate.mapping.Disabledata;
import hibernate.mapping.Likesdislikes;
import hibernate.mapping.Talkings;
import hibernate.query.BlockDisable;
import hibernate.query.chat.ChatPrivacy;
import hibernate.query.reactoper.ReactOper;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pages.controller.errors.ResourceNotFoundException;

@Controller
public class PerformReactOperHandler {

    @RequestMapping(value = "/{page}/user/oper/{option}/", method = RequestMethod.GET)
    public String ReactOperHandler(@PathVariable("page") String page, @PathVariable("option") String option, @RequestParam(value = "sqq", required = true) String getId, @RequestParam(value = "user", required = false) String userId, @RequestParam(value = "refer", required = true) String refer, @RequestParam(value = "prerefer", required = false) String prerefer, @RequestParam(value = "page", required = false) String pagination, @RequestParam(value = "prepage", required = false) String prepagination, Model model, HttpServletRequest request, HttpServletResponse response) {
        if (((!page.matches("^(accpic)$") && !page.matches("^(talking|comment)$")) || (page.matches("^(accpic)$") && !option.matches("^(like|liked|dislike|disliked|talking|talked|comment|commented|share|shared)$"))) || (page.matches("^(talking)$") && !option.matches("^(like|liked|dislike|disliked|reply|edit|delete|disable|enable|block|unblock)$")) || (page.matches("^(comment)$") && !option.matches("^(like|liked|dislike|disliked|write|edit|delete|disable|enable|block|unblock)$"))) {
            throw new ResourceNotFoundException();
        }
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../../../login/";
        }
        long paginationPage = (pagination != null) && (pagination.matches("^(?:[0-9]){1,11}$")) ? Long.parseLong(pagination) : 0;
        long prepaginationPage = (prepagination != null) && (prepagination.matches("^(?:[0-9]){1,11}$")) ? Long.parseLong(prepagination) : 0;
        ReactOper insertData = new ReactOper();
        ReactOperValidate checkValid = new ReactOperValidate();
        ReactOperValidate getValid;
        switch (page) {
            case "accpic":
                getValid = checkValid.getAccountPic(getId, refer, prerefer, user, option, paginationPage, prepaginationPage);
                break;
            case "talking":
                getValid = checkValid.getTalking(getId, refer, prerefer, user, option, paginationPage, prepaginationPage);
                break;
            case "comment":
                getValid = checkValid.getComment(getId, userId, refer, prerefer, user, option, paginationPage, prepaginationPage);
                break;
            default:
                getValid = null;
                break;
        }
        if ((getValid == null) || (getValid.getTarId() == null) || (!getValid.isAllowed()) || (!getValid.isPrivacySucceed())) {
            return "redirect:../../../../home/";
        }
        ChatPrivacy chatPrivacy = new ChatPrivacy();
        Chatuseroptions getPrivacy = chatPrivacy.getPrivacy(getValid.getSelfUser(), user);
        String deviceId = checkCookie.getDevice(request.getCookies());
        ReactData reactData = new ReactData();
        switch (option) {
            case "like":
            case "dislike":
                Likesdislikes preData = insertData.getSingleLikeDislike(user, getValid.getTarId());
                if (((preData != null) && (preData.getBlockedUser()))||((getPrivacy!=null)&&(!getPrivacy.isLikeDislike()))) {
                    break;
                }
                    Boolean isLikeDislike;
                    if ((preData == null) || (preData.getLikeDislike() == null)) {
                        isLikeDislike = (option.equals("like"));
                    } else {
                        if ((!preData.getLikeDislike()) && (option.equals("like"))) {
                            isLikeDislike = true;
                        } else if ((preData.getLikeDislike()) && (option.equals("dislike"))) {
                            isLikeDislike = false;
                        } else {
                            isLikeDislike = null;
                        }
                    }
                    Likesdislikes data = new Likesdislikes(deviceId, user, getValid.getTarId(), System.currentTimeMillis(), isLikeDislike, false);
                    insertData.insertLikeDislike(data);
                
                break;
            case "talking":
                model.addAttribute("talking", reactData);
                return "reactoper/" + option;
            case "reply":
                model.addAttribute("reply", reactData);
                return "reactoper/" + option;
            case "edit":
                switch (page) {
                    case "talking":
                        model.addAttribute("edit", reactData);
                        return "reactoper/edittalking";
                    case "comment":
                        model.addAttribute("edit", reactData);
                        return "reactoper/editcomment";
                }
                break;
            case "comment":
                model.addAttribute("comment", reactData);
                return "reactoper/" + option;
            case "write":
                model.addAttribute("writecomment", reactData);
                return "reactoper/writecomment";
            case "delete":
                switch (page) {
                    case "talking":
                        Talkings prevTalking = insertData.getTalkingByOperId(getValid.getTarId());
                        Talkings saveTalkings = new Talkings(deviceId, System.currentTimeMillis(), prevTalking.getTimestampTalk(), prevTalking.getOperId(), prevTalking.getUserOne(), prevTalking.getUserTwo(), prevTalking.getTargetId(), prevTalking.getTalkingText(), prevTalking.isReplied(), false, true, prevTalking.getPicId(), prevTalking.getOrigName(), prevTalking.getMediaType(), prevTalking.getMediaSize());
                        insertData.insertTalkings(saveTalkings);
                        break;
                    case "comment":
                        Comments prevComments = insertData.getCommentByOperId(getValid.getTarId());
                        Comments saveComments = new Comments(deviceId, System.currentTimeMillis(), prevComments.getTimestampComment(), prevComments.getOperId(), prevComments.getUserOne(), prevComments.getUserTwo(), prevComments.getTargetId(), prevComments.getCommentText(), prevComments.isSelfUser(), false, true, prevComments.getPicId(), prevComments.getOrigName(), prevComments.getMediaType(), prevComments.getMediaSize());
                        insertData.insertComments(saveComments);
                        break;
                }
                break;
            case "disable":
            case "enable":
                BlockDisable saveDisable = new BlockDisable();
                Disabledata disable = new Disabledata(deviceId, System.currentTimeMillis(), getValid.getTarId(), option.equals("disable"));
                saveDisable.insertDisable(disable);
                break;
            case "block":
            case "unblock":
                BlockDisable saveBlock = new BlockDisable();
                Blocklist blockUser = new Blocklist(deviceId, System.currentTimeMillis(), getValid.getTarId(), getValid.getSelfUser(), option.equals("block"));
                saveBlock.insertBlock(blockUser);
                break;
            case "liked":
            case "disliked":
            case "talked":
            case "commented":
            case "shared":
                return "reactoper/reactedby";
        }
        return "redirect:../../../../" + getValid.getUrl();
    }
}
