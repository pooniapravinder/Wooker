package pages.controller.reactoper;

import cookies.set.get.CheckSaveCookies;
import hibernate.mapping.Chatuseroptions;
import hibernate.mapping.Comments;
import hibernate.mapping.Talkings;
import hibernate.query.BlockDisable;
import hibernate.query.chat.ChatPrivacy;
import hibernate.query.reactoper.ReactOper;
import java.io.IOException;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pages.controller.errors.ResourceNotFoundException;
import user.attachments.save.SaveImages;

@Controller
public class PerformReactOperSubmit {

    @RequestMapping(value = "/{page}/user/oper/{option}/", method = RequestMethod.POST)
    public String ReactOperSubmit(@PathVariable("page") String page, @PathVariable("option") String option, @RequestParam(value = "sqq", required = true) String getId, @RequestParam(value = "user", required = false) String userId, @RequestParam(value = "refer", required = true) String refer, @RequestParam(value = "prerefer", required = false) String prerefer, @RequestParam(value = "page", required = false) String pagination, @RequestParam(value = "prepage", required = false) String prepagination, ReactData reactData, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if ((!page.matches("^(accpic)$") && !page.matches("^(talking|comment)$")) || (page.matches("^(talking)$") && !option.matches("^(reply|edit)$")) || (page.matches("^(comment)$") && !option.matches("^(edit|write)$"))) {
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
        long selfUser = getValid.getSelfUser();
        ChatPrivacy chatPrivacy = new ChatPrivacy();
        Chatuseroptions getPrivacy = chatPrivacy.getPrivacy(getValid.getSelfUser(), user);
        ReactOper getData = new ReactOper();
        BlockDisable getBlockDisable = new BlockDisable();
        String deviceId = checkCookie.getDevice(request.getCookies());
        long timestamp = System.currentTimeMillis();
        switch (option) {
            case "talking":
            case "reply":
                if (((getPrivacy != null) && (!getPrivacy.isTalking())) || ((option.equals("reply")) && (getBlockDisable.isDisabled(getValid.getTarId()))) || (((reactData.getTalking() == null) || reactData.getTalking().isEmpty()) && ((reactData.getAttachment() == null) || (reactData.getAttachment().isEmpty())) && ((reactData.getPrePic() == null) || (reactData.getPrePic().isEmpty())))) {
                    break;
                }
                Talkings talkData = null;
                if ((reactData.getPrePic() != null) && (!reactData.getPrePic().isEmpty())) {
                    talkData = new Talkings(deviceId, timestamp, timestamp, timestamp + "_" + user, user, selfUser, getValid.getTarId(), reactData.getTalking(), (option.equals("reply")), false, false, null, null, null, null);
                } else if ((reactData.getAttachment() != null) && (!reactData.getAttachment().isEmpty()) && (Pattern.compile("^image/([jpg|jpeg|png|bmp]+)$").matcher(reactData.getAttachment().getContentType().toLowerCase()).matches())) {
                    SaveImages saveImage = new SaveImages();
                    talkData = new Talkings(deviceId, timestamp, timestamp, timestamp + "_" + user, user, selfUser, getValid.getTarId(), reactData.getTalking(), (option.equals("reply")), false, false, timestamp + "_" + user, reactData.getAttachment().getOriginalFilename(), reactData.getAttachment().getContentType().replace("image/", ""), reactData.getAttachment().getSize());
                    saveImage.SaveImage(reactData.getAttachment(), timestamp + "_" + user);
                } else if ((reactData.getTalking() != null) && (!reactData.getTalking().isEmpty())) {
                    talkData = new Talkings(deviceId, timestamp, timestamp, timestamp + "_" + user, user, selfUser, getValid.getTarId(), reactData.getTalking(), (option.equals("reply")), false, false, null, null, null, null);
                }
                insertData.insertTalkings(talkData);
                break;
            case "comment":
            case "write":
                if (((getPrivacy != null) && (!getPrivacy.isComment())) || (((reactData.getComment() == null) || reactData.getComment().isEmpty()) && ((reactData.getAttachment() == null) || (reactData.getAttachment().isEmpty())) && ((reactData.getPrePic() == null) || (reactData.getPrePic().isEmpty())))) {
                    break;
                }
                Comments commData = null;
                long sessUser = user;
                user = (option.equals("write")) ? selfUser : user;
                selfUser = (option.equals("write")) ? sessUser : selfUser;
                if ((reactData.getPrePic() != null) && (!reactData.getPrePic().isEmpty())) {
                    commData = new Comments(deviceId, timestamp, timestamp, timestamp + "_" + user, user, selfUser, getValid.getTarId(), reactData.getComment(), (option.equals("write")), false, false, null, null, null, null);
                } else if ((reactData.getAttachment() != null) && (!reactData.getAttachment().isEmpty()) && (Pattern.compile("^image/([jpg|jpeg|png|bmp]+)$").matcher(reactData.getAttachment().getContentType().toLowerCase()).matches())) {
                    SaveImages saveImage = new SaveImages();
                    commData = new Comments(deviceId, timestamp, timestamp, timestamp + "_" + user, user, selfUser, getValid.getTarId(), reactData.getComment(), (option.equals("write")), false, false, timestamp + "_" + user, reactData.getAttachment().getOriginalFilename(), reactData.getAttachment().getContentType().replace("image/", ""), reactData.getAttachment().getSize());
                    saveImage.SaveImage(reactData.getAttachment(), timestamp + "_" + user);
                } else if ((reactData.getComment() != null) && (!reactData.getComment().isEmpty())) {
                    commData = new Comments(deviceId, timestamp, timestamp, timestamp + "_" + user, user, selfUser, getValid.getTarId(), reactData.getComment(), (option.equals("write")), false, false, null, null, null, null);
                }
                insertData.insertComments(commData);
                break;
            case "edit":
                switch (page) {
                    case "talking":
                        Talkings talkpreData = getData.getTalkingByOperId(getValid.getTarId());
                        Talkings talkingData;
                        if ((talkpreData.getUserOne() != user) || (getBlockDisable.isDisabled(getValid.getTarId())) || ((reactData.getTalking() == null) || (reactData.getTalking().isEmpty()) || (reactData.getTalking().equals(talkpreData.getTalkingText()))) && ((reactData.getPrePic() == null) || (reactData.getPrePic().isEmpty()) || (reactData.getPrePic().equals(talkpreData.getPicId()))) && ((reactData.getAttachment() == null) || (reactData.getAttachment().isEmpty())) && ((talkpreData.getPicId() == null) || (reactData.getRemAttachment() == null) || (reactData.getTalking() == null) || (reactData.getTalking().isEmpty()))) {
                            break;
                        }
                        if ((reactData.getPrePic() != null) && (!reactData.getPrePic().isEmpty())) {
                            talkingData = new Talkings(deviceId, timestamp, talkpreData.getTimestampTalk(), talkpreData.getOperId(), talkpreData.getUserOne(), talkpreData.getUserTwo(), talkpreData.getTargetId(), reactData.getTalking(), talkpreData.isReplied(), true, false, null, null, null, null);
                        } else if ((reactData.getAttachment() != null) && (!reactData.getAttachment().isEmpty()) && (Pattern.compile("^image/([jpg|jpeg|png|bmp]+)$").matcher(reactData.getAttachment().getContentType().toLowerCase()).matches())) {
                            SaveImages saveImage = new SaveImages();
                            talkingData = new Talkings(deviceId, timestamp, talkpreData.getTimestampTalk(), talkpreData.getOperId(), talkpreData.getUserOne(), talkpreData.getUserTwo(), talkpreData.getTargetId(), reactData.getTalking(), talkpreData.isReplied(), true, false, timestamp + "_" + user, reactData.getAttachment().getOriginalFilename(), reactData.getAttachment().getContentType().replace("image/", ""), reactData.getAttachment().getSize());
                            saveImage.SaveImage(reactData.getAttachment(), timestamp + "_" + user);
                        } else if (reactData.getRemAttachment() != null) {
                            talkingData = new Talkings(deviceId, timestamp, talkpreData.getTimestampTalk(), talkpreData.getOperId(), talkpreData.getUserOne(), talkpreData.getUserTwo(), talkpreData.getTargetId(), reactData.getTalking(), talkpreData.isReplied(), true, false, null, null, null, null);
                        } else {
                            talkingData = new Talkings(deviceId, timestamp, talkpreData.getTimestampTalk(), talkpreData.getOperId(), talkpreData.getUserOne(), talkpreData.getUserTwo(), talkpreData.getTargetId(), reactData.getTalking(), talkpreData.isReplied(), true, false, talkpreData.getPicId(), talkpreData.getOrigName(), talkpreData.getMediaType(), talkpreData.getMediaSize());
                        }
                        insertData.insertTalkings(talkingData);
                        break;
                    case "comment":
                        Comments commpreData = getData.getCommentByOperId(getValid.getTarId());
                        Comments commentData;
                        if (((commpreData.isSelfUser()) && (commpreData.getUserTwo() != user)) || ((!commpreData.isSelfUser()) && (commpreData.getUserOne() != user)) || (getBlockDisable.isDisabled(getValid.getTarId())) || ((reactData.getComment() == null) || (reactData.getComment().isEmpty()) || (reactData.getComment().equals(commpreData.getCommentText()))) && ((reactData.getPrePic() == null) || (reactData.getPrePic().isEmpty()) || (reactData.getPrePic().equals(commpreData.getPicId()))) && ((reactData.getAttachment() == null) || (reactData.getAttachment().isEmpty())) && ((commpreData.getPicId() == null) || (reactData.getRemAttachment() == null) || (reactData.getComment() == null) || (reactData.getComment().isEmpty()))) {
                            break;
                        }
                        if ((reactData.getPrePic() != null) && (!reactData.getPrePic().isEmpty())) {
                            commentData = new Comments(deviceId, timestamp, commpreData.getTimestampComment(), commpreData.getOperId(), commpreData.getUserOne(), commpreData.getUserTwo(), commpreData.getTargetId(), reactData.getComment(), commpreData.isSelfUser(), true, false, null, null, null, null);
                        } else if ((reactData.getAttachment() != null) && (!reactData.getAttachment().isEmpty()) && (Pattern.compile("^image/([jpg|jpeg|png|bmp]+)$").matcher(reactData.getAttachment().getContentType().toLowerCase()).matches())) {
                            SaveImages saveImage = new SaveImages();
                            commentData = new Comments(deviceId, timestamp, commpreData.getTimestampComment(), commpreData.getOperId(), commpreData.getUserOne(), commpreData.getUserTwo(), commpreData.getTargetId(), reactData.getComment(), commpreData.isSelfUser(), true, false, timestamp + "_" + user, reactData.getAttachment().getOriginalFilename(), reactData.getAttachment().getContentType().replace("image/", ""), reactData.getAttachment().getSize());
                            saveImage.SaveImage(reactData.getAttachment(), timestamp + "_" + user);
                        } else if (reactData.getRemAttachment() != null) {
                            commentData = new Comments(deviceId, timestamp, commpreData.getTimestampComment(), commpreData.getOperId(), commpreData.getUserOne(), commpreData.getUserTwo(), commpreData.getTargetId(), reactData.getComment(), commpreData.isSelfUser(), true, false, null, null, null, null);
                        } else {
                            commentData = new Comments(deviceId, timestamp, commpreData.getTimestampComment(), commpreData.getOperId(), commpreData.getUserOne(), commpreData.getUserTwo(), commpreData.getTargetId(), reactData.getComment(), commpreData.isSelfUser(), true, false, commpreData.getPicId(), commpreData.getOrigName(), commpreData.getMediaType(), commpreData.getMediaSize());
                        }
                        insertData.insertComments(commentData);
                        break;
                }
                break;
        }
        return "redirect:../../../../" + getValid.getUrl();
    }
}
