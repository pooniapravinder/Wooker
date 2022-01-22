package pages.controller.chat;

import cookies.set.get.CheckSaveCookies;
import data.encryption.decryption.Cryptography;
import hibernate.mapping.Chatuseroptions;
import hibernate.mapping.Messages;
import hibernate.mapping.Starredmessages;
import hibernate.mapping.Userchatlist;
import hibernate.mapping.Usermessages;
import hibernate.query.chat.ChatPrivacy;
import hibernate.query.chat.GetMessages;
import hibernate.query.chat.ReadMessages;
import hibernate.query.chat.SaveMessages;
import hibernate.query.chat.UserRelationActions;
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
import user.attachments.save.SaveAudios;
import user.attachments.save.SaveImages;
import user.attachments.save.SaveVideos;

@Controller
public class UserChatHandler {

    @RequestMapping(value = "/user/chat/", method = RequestMethod.GET)
    public String UserChatHandler(@RequestParam(value = "sqq", required = true) String getId, HttpServletRequest request, HttpServletResponse response) {
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../login/";
        }
        Cryptography crypto = new Cryptography();
        String id = crypto.decrypt(getId);
        Pattern pattern = Pattern.compile("^([0-9]){1,}$");
        if ((id == null) || (!pattern.matcher(id).matches()) || (Long.valueOf(id) == user)) {
            return "redirect:../../home/";
        }
        UserRelationActions saveChatlist = new UserRelationActions();
        Userchatlist preData = saveChatlist.getUserslist(user, Long.parseLong(id));
        String deviceId = checkCookie.getDevice(request.getCookies());
        long timestamp = System.currentTimeMillis();
        long defaultId;
        if (preData == null) {
            Userchatlist chatlist = new Userchatlist(timestamp, deviceId, user, Long.parseLong(id), 0, 0, 0, 0, 0, 0, false, false, false, false, 0, 0);
            saveChatlist.insertAction(chatlist);
            defaultId = saveChatlist.getUserslist(user, Long.parseLong(id)).getAutoId();
        } else {
            defaultId = preData.getAutoId();
        }
        return "redirect:../../user/send/message/" + "?sqq=" + crypto.encodeURL(crypto.encrypt(String.valueOf(defaultId)));
    }

    @RequestMapping(value = "/user/send/message/", method = RequestMethod.GET)
    public String UserSendMessageView(@RequestParam(value = "sqq", required = true) String getId, @RequestParam(value = "pagination_forward", required = false) String forward, @RequestParam(value = "pagination_backward", required = false) String backward, SendMessage sendmessage, HttpServletRequest request, HttpServletResponse response) {
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../../login/";
        }
        Cryptography crypto = new Cryptography();
        String id = crypto.decrypt(getId);
        Pattern pattern = Pattern.compile("^([0-9]){1,}$");
        if ((id == null) || (!pattern.matcher(id).matches())) {
            return "redirect:../../../home/";
        }
        UserRelationActions saveChatlist = new UserRelationActions();
        Userchatlist preData = saveChatlist.getUserlistById(Long.valueOf(id));
        if ((preData == null) || ((preData.getUserOne() != user) && (preData.getUserTwo() != user))) {
            return "redirect:../../../home/";
        }
        if ((crypto.decrypt(forward) == null) && (crypto.decrypt(backward) == null)) {
            ReadMessages read = new ReadMessages();
            read.ReadChatpageMsg(Long.valueOf(id), System.currentTimeMillis(), user);
        }
        return "chat/chatpage";
    }

    @RequestMapping(value = "/user/send/message/chat/", method = RequestMethod.POST)
    public String UserSendMessageSubmit(@RequestParam(value = "sqq", required = true) String getId, SendMessage sendmessage, HttpServletRequest request, HttpServletResponse response) throws IOException {
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../../../login/";
        }
        Cryptography crypto = new Cryptography();
        String id = crypto.decrypt(getId);
        Pattern pattern = Pattern.compile("^([0-9]){1,}$");
        if ((id == null) || (!pattern.matcher(id).matches())) {
            return "redirect:../../../../home/";
        }
        UserRelationActions saveChatlist = new UserRelationActions();
        Userchatlist preData = saveChatlist.getUserlistById(Long.valueOf(id));
        if ((preData == null) || ((preData.getUserOne() != user) && (preData.getUserTwo() != user)) || (preData.isBlocked())) {
            return "redirect:../../../../home/";
        }
        String url = "redirect:../" + "?sqq=" + crypto.encodeURL(getId);
        if ((sendmessage.getMessage() == null) || (sendmessage.getMessage().isEmpty()) && ((sendmessage.getAttachment() == null) || (sendmessage.getAttachment().isEmpty())) && ((sendmessage.getPrePic() == null) || (sendmessage.getPrePic().isEmpty()))) {
            return url;
        }
        long receiver = (preData.getUserOne() == user ? preData.getUserTwo() : preData.getUserOne());
        String msgAttachment = sendmessage.getAttachment().getContentType().toLowerCase();
        ChatPrivacy chatPrivacy = new ChatPrivacy();
        Chatuseroptions getPrivacy = chatPrivacy.getPrivacy(receiver, user);
        boolean chatBlock = ((preData.getBlockedchatOne() == receiver) || (preData.getBlockedchatOne() == user) || (preData.getBlockedchatTwo() == receiver) || (preData.getBlockedchatTwo() == user));
        if ((chatBlock) || ((getPrivacy != null) && ((!getPrivacy.isChatImage() && msgAttachment.contains("image")) || (!getPrivacy.isChatAudio() && msgAttachment.contains("audio")) || (!getPrivacy.isChatVideo() && msgAttachment.contains("video")) || (!getPrivacy.isChatFile() && msgAttachment.contains("file"))))) {
            return url;
        }
        String deviceId = checkCookie.getDevice(request.getCookies());
        long timestamp = System.currentTimeMillis();
        if ((sendmessage.getRequestConnect() != null) && (!preData.isRequest())) {
            saveChatlist.makeRequest(Long.valueOf(id), user, preData.getUserOne() == user ? preData.getUserTwo() : preData.getUserOne());
        }
        SaveMessages insertMessage = new SaveMessages();
        Usermessages newMessage;
        Messages message;
        if ((sendmessage.getPrePic() != null) && (!sendmessage.getPrePic().isEmpty())) {
            newMessage = new Usermessages(deviceId, preData.getAutoId(), timestamp, user, receiver, false, false, false, false, 0, 0, timestamp, 0);
            message = new Messages(newMessage, sendmessage.getMessage(), null, null, null, null);
            insertMessage.InsertUserMessage(newMessage);
            insertMessage.InsertMessage(message);
        } else if ((sendmessage.getAttachment() != null) && (!sendmessage.getAttachment().isEmpty()) && (Pattern.compile("^(image|video|audio)/([jpg|jpeg|png|bmp|mp4|3gp|mp3|wav]+)$").matcher(msgAttachment).matches())) {
            newMessage = new Usermessages(deviceId, preData.getAutoId(), timestamp, user, receiver, false, false, false, false, 0, 0, timestamp, 0);
            message = new Messages(newMessage, sendmessage.getMessage(), timestamp + "_" + user, sendmessage.getAttachment().getOriginalFilename(), sendmessage.getAttachment().getContentType(), sendmessage.getAttachment().getSize());
            if ((Pattern.compile("^image/([jpg|jpeg|png|bmp]+)$").matcher(msgAttachment).matches())) {
                SaveImages saveImage = new SaveImages();
                saveImage.SaveImage(sendmessage.getAttachment(), timestamp + "_" + user);
            } else if ((Pattern.compile("^video/([mp4|3gp]+)$").matcher(msgAttachment).matches())) {
                SaveVideos saveVideos = new SaveVideos();
                saveVideos.SaveVideo(sendmessage.getAttachment(), timestamp + "_" + user);
            } else if ((Pattern.compile("^audio/([mp3|wav]+)$").matcher(msgAttachment).matches())) {
                SaveAudios saveAudios = new SaveAudios();
                saveAudios.SaveAudio(sendmessage.getAttachment(), timestamp + "_" + user);
            }
            insertMessage.InsertUserMessage(newMessage);
            insertMessage.InsertMessage(message);
        } else if ((sendmessage.getMessage() != null) && (!sendmessage.getMessage().isEmpty())) {
            newMessage = new Usermessages(deviceId, preData.getAutoId(), timestamp, user, receiver, false, false, false, false, 0, 0, timestamp, 0);
            message = new Messages(newMessage, sendmessage.getMessage(), null, null, null, null);
            insertMessage.InsertUserMessage(newMessage);
            insertMessage.InsertMessage(message);
        }
        return url;
    }

    @RequestMapping(value = "/user/send/message/action/{option}/", method = RequestMethod.GET)
    public String UserMessageDefault(@PathVariable("option") String option, @RequestParam(value = "pagination_forward", required = false) String forward, @RequestParam(value = "pagination_backward", required = false) String backward, @RequestParam(value = "sqq", required = false) String getId, @RequestParam(value = "refer", required = true) String refer, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (!option.matches("^(getback|delete|forward|star|info|unread)$")) {
            throw new ResourceNotFoundException();
        }
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../../../../login/";
        }
        Cryptography crypto = new Cryptography();
        String id = crypto.decrypt(getId);
        if ((id == null) || (!id.matches("^(?:[0-9]){1,}$"))) {
            return "redirect:../../../../../home/";
        }
        GetMessages message = new GetMessages();
        Usermessages data = message.getMessageById(Long.valueOf(id));
        if (data == null) {
            return "redirect:../../../../../home/";
        }
        Pattern pattern = Pattern.compile("^(FgWoDj_heM-dNEK|m-Ge_jdRmf-Frfs)$");
        if ((refer == null) || (!pattern.matcher(refer).matches())) {
            return "redirect:../../../../../home/";
        }
        String url = null;
        switch (refer) {
            case "FgWoDj_heM-dNEK":
                url = "redirect:../../../../../chat/option/perform/starred/" + "?sqq=" + crypto.encodeURL(crypto.encrypt(String.valueOf(data.getOperId())));
                break;
            case "m-Ge_jdRmf-Frfs":
                url = "redirect:../../" + "?sqq=" + crypto.encodeURL(crypto.encrypt(String.valueOf(data.getOperId())));
                break;
        }

        if (backward != null) {
            url = url + "&" + "pagination_backward=" + crypto.encodeURL(backward);
        } else if (forward != null) {
            url = url + "&" + "pagination_forward=" + crypto.encodeURL(forward);
        }
        UserRelationActions saveChatlist = new UserRelationActions();
        Userchatlist preData = saveChatlist.getUserlistById(data.getOperId());
        SaveMessages insertMessage = new SaveMessages();
        switch (option) {
            case "getback":
                if ((data.isChatpageRead()) || (data.getSender() != user) || (data.getDeletedOne() == user) || (data.getDeletedTwo() == user)) {
                    break;
                }
                insertMessage.InsertGetBack(Long.valueOf(id));
                break;
            case "delete":
                if (((preData.getUserOne() != user) && (preData.getUserTwo() != user)) || (data.getDeletedOne() == user) || (data.getDeletedTwo() == user)) {
                    break;
                }
                insertMessage.InsertDelete(Long.valueOf(id), user, data.getDeletedOne() != 0);
                break;
            case "forward":

                break;
            case "star":
                if (((preData.getUserOne() != user) && (preData.getUserTwo() != user)) || (data.getDeletedOne() == user) || (data.getDeletedTwo() == user) || (data.getDeletedOne() == user) || (data.getDeletedTwo() == user)) {
                    break;
                }
                if (insertMessage.isStarredMsg(Long.valueOf(id), user)) {
                    insertMessage.RemoveStar(Long.valueOf(id), user);
                } else {
                    Starredmessages starMsg = new Starredmessages(Long.valueOf(id), preData.getAutoId(), user);
                    insertMessage.InsertStarMessage(starMsg);
                }
                break;
            case "info":
                if (((preData.getUserOne() != user) && (preData.getUserTwo() != user)) || (data.getDeletedOne() == user) || (data.getDeletedTwo() == user)) {
                    break;
                }
                return "chat/chatpageinfo";
            case "unread":
                if ((data.getDeletedOne() == user) || (data.getDeletedTwo() == user)) {
                    break;
                }
                long autoId = insertMessage.getLastMsgId(data.getOperId(), user);
                if (autoId != 0) {
                    insertMessage.InsertUnread(autoId, data.getOperId());
                }
                if (preData.isFriend()) {
                    url = "redirect:../../../../../chat/";
                } else if (preData.isRequest()) {
                    url = "redirect:../../../../../alerts/";
                } else {
                    url = "redirect:../../../../../spam/";
                }
                break;
        }
        return url;
    }
}
