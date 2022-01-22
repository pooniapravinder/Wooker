package pages.controller.chat;

import cookies.set.get.CheckSaveCookies;
import data.encryption.decryption.Cryptography;
import hibernate.mapping.Chatuseroptions;
import hibernate.mapping.Showhidechatpage;
import hibernate.mapping.Userchatlist;
import hibernate.query.chat.ChatPrivacy;
import hibernate.query.chat.ShowHideChatpage;
import hibernate.query.chat.UserRelationActions;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pages.controller.errors.ResourceNotFoundException;

@Controller
public class ChatOptions {

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/chat/option/perform/{option}/", method = RequestMethod.GET)
    public String ChatOptionsHandler(@PathVariable("option") String option, @RequestParam(value = "sqq", required = true) String getId, Model model, HttpServletRequest request, HttpServletResponse response) {
        if (!option.matches("^(starred|priority|mute|offchat|privacy|settings)$")) {
            throw new ResourceNotFoundException();
        }
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../../../login/";
        }
        Cryptography crypto = new Cryptography();
        String id = crypto.decrypt(getId);
        Pattern idPattern = Pattern.compile("^(([0-9]){1,})$");
        if ((id == null) || (!idPattern.matcher(id).matches())) {
            return "redirect:../../../../home/";
        }
        UserRelationActions saveAction = new UserRelationActions();
        Userchatlist preData = saveAction.getUserlistById(Long.parseLong(id));
        if ((preData == null) || ((preData.getUserOne() != user) && (preData.getUserTwo() != user))) {
            return "redirect:../../../../home/";
        }
        long otherUser = preData.getUserOne() == user ? preData.getUserTwo() : preData.getUserOne();
        switch (option) {
            case "starred":
                return "chat/starredchat";
            case "priority":
                Priority priority = new Priority();
                model.addAttribute("priority", priority);
                return "chat/priority";
            case "mute":
                if (preData.getMuteOne() == otherUser) {
                    saveAction.InsertUnmute(Long.valueOf(id), true);
                } else if (preData.getMuteTwo() == otherUser) {
                    saveAction.InsertUnmute(Long.valueOf(id), false);
                } else {
                    saveAction.InsertMute(Long.valueOf(id), otherUser, preData.getMuteOne() != 0);
                }
                break;
            case "offchat":
                if (preData.getOffchatOne() == otherUser) {
                    saveAction.InsertOnchat(Long.valueOf(id), true);
                } else if (preData.getOffchatTwo() == otherUser) {
                    saveAction.InsertOnchat(Long.valueOf(id), false);
                } else {
                    saveAction.InsertOffchat(Long.valueOf(id), otherUser, preData.getOffchatOne() != 0);
                }
                break;
            case "privacy":
                ChatPrivacy chatPrivacy = new ChatPrivacy();
                Chatuseroptions getPrivacy = chatPrivacy.getPrivacy(user, otherUser);
                Chatuserprivacy privacy = new Chatuserprivacy(getPrivacy, preData.getBlockedchatOne() != otherUser && preData.getBlockedchatTwo() != otherUser);
                model.addAttribute("chatuserprivacy", privacy);
                return "chat/privacy";
            case "settings":
                Chatsettings settings = new Chatsettings();
                model.addAttribute("chatsettings", settings);
                return "chat/settings";
        }
        return "redirect:../../../../user/send/message/?sqq=" + crypto.encodeURL(getId);
    }

    @RequestMapping(value = "/chat/option/perform/priority/", method = RequestMethod.POST)
    public String ChatPriority(@RequestParam(value = "sqq", required = true) String getId, HttpServletRequest request, HttpServletResponse response) {
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../../../login/";
        }
        Cryptography crypto = new Cryptography();
        String id = crypto.decrypt(getId);
        Pattern idPattern = Pattern.compile("^(([0-9]){1,})$");
        if ((id == null) || (!idPattern.matcher(id).matches())) {
            return "redirect:../../../../home/";
        }
        UserRelationActions saveAction = new UserRelationActions();
        Userchatlist preData = saveAction.getUserlistById(Long.parseLong(id));
        if ((preData == null) || ((preData.getUserOne() != user) && (preData.getUserTwo() != user))) {
            return "redirect:../../../../home/";
        }
        return "redirect:../../../../user/send/message/?sqq=" + crypto.encodeURL(getId);
    }

    @RequestMapping(value = "/chat/option/perform/privacy/", method = RequestMethod.POST)
    public String ChatPrivacy(Chatuserprivacy privacy, @RequestParam(value = "sqq", required = true) String getId, HttpServletRequest request, HttpServletResponse response) {
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../../../login/";
        }
        Cryptography crypto = new Cryptography();
        String id = crypto.decrypt(getId);
        Pattern idPattern = Pattern.compile("^(([0-9]){1,})$");
        if ((id == null) || (!idPattern.matcher(id).matches())) {
            return "redirect:../../../../home/";
        }
        UserRelationActions saveAction = new UserRelationActions();
        Userchatlist preData = saveAction.getUserlistById(Long.parseLong(id));
        if ((preData == null) || ((preData.getUserOne() != user) && (preData.getUserTwo() != user))) {
            return "redirect:../../../../home/";
        }
        long otherUser = preData.getUserOne() == user ? preData.getUserTwo() : preData.getUserOne();
        ChatPrivacy chatPrivacy = new ChatPrivacy();
        Chatuseroptions getPrivacy = chatPrivacy.getPrivacy(user, otherUser);
        String deviceId = checkCookie.getDevice(request.getCookies());
        if ((preData.getBlockedchatOne() == otherUser) && (privacy.getChat() != null)) {
            chatPrivacy.ChatUnblock(preData.getAutoId(), true);
        } else if ((preData.getBlockedchatTwo() == otherUser) && (privacy.getChat() != null)) {
            chatPrivacy.ChatUnblock(preData.getAutoId(), false);
        } else if (privacy.getChat() == null) {
            chatPrivacy.ChatBlock(preData.getAutoId(), otherUser, preData.getBlockedchatOne() != 0);
        }
        if (getPrivacy == null) {
            Chatuseroptions chatoptions = new Chatuseroptions(deviceId, user, otherUser, privacy.getLikeDislike() != null, privacy.getTalking() != null, privacy.getComment() != null, privacy.getShare() != null, privacy.getImage() != null, privacy.getAudio() != null, privacy.getVideo() != null, privacy.getFile() != null, privacy.getGif() != null);
            chatPrivacy.InsertChatPrivacy(chatoptions);
        } else {
            chatPrivacy.updatePrivacy(getPrivacy.getAutoId(), deviceId, privacy.getLikeDislike() != null, privacy.getTalking() != null, privacy.getComment() != null, privacy.getShare() != null, privacy.getImage() != null, privacy.getAudio() != null, privacy.getVideo() != null, privacy.getFile() != null, privacy.getGif() != null);
        }
        return "redirect:../../../../user/send/message/?sqq=" + crypto.encodeURL(getId);
    }

    @RequestMapping(value = "/chat/option/perform/settings/", method = RequestMethod.POST)
    public String ChatSettings(Chatsettings settings, @RequestParam(value = "sqq", required = true) String getId, HttpServletRequest request, HttpServletResponse response) {
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return "redirect:../../../../login/";
        }
        Cryptography crypto = new Cryptography();
        String deviceId = checkCookie.getDevice(request.getCookies());
        byte msgLength = 20;
        byte defWallpaper = 0;
        String wallpaperId = null;
        Pattern msgLenPattern = Pattern.compile("^(5|10|15|20)$");
        Pattern defWall = Pattern.compile("^([0-9]|1[0-9]|20)$");
        if ((settings.getMsgLength() != null) && (msgLenPattern.matcher(settings.getMsgLength()).matches())) {
            msgLength = Byte.valueOf(settings.getMsgLength());
        }
        if ((settings.getDefWallpaper() != null) && (defWall.matcher(settings.getDefWallpaper()).matches())) {
            defWallpaper = Byte.valueOf(settings.getDefWallpaper());
        }
        ShowHideChatpage saveSettings = new ShowHideChatpage();
        Showhidechatpage getSettings = saveSettings.getChatSettings(user);
        Showhidechatpage chatpageOption = new Showhidechatpage(user, deviceId, settings.getWooks() != null, settings.getRemove() != null, settings.getBlock() != null, settings.getStarred() != null, settings.getPriority() != null, settings.getMute() != null, settings.getOffchat() != null, settings.getPrivacy() != null, settings.getSettings() != null, settings.getMsgTime() != null, msgLength, defWallpaper, wallpaperId);
        if (getSettings == null) {
            saveSettings.ChatpageOptions(chatpageOption);
        } else {
            saveSettings.UpdateChatSettings(chatpageOption);
        }
        return "redirect:../../../../user/send/message/?sqq=" + crypto.encodeURL(getId);
    }

    @RequestMapping(value = "/chat/option/perform/settings/wallpaper/upload/", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    
    public @ResponseBody WallpaperResponse ChatSettingsWallpaper(Locale locale, Chatsettings settings, HttpServletRequest request, HttpServletResponse response) {
        CheckSaveCookies checkCookie = new CheckSaveCookies();
        long user = checkCookie.getCookie(request, response);
        if (user == 0) {
            return res("chatsettings.upload.wallpaper.invaliderror", 0, locale);
        }
        return res("chatsettings.upload.wallpaper.success", 1, locale);
    }

    public WallpaperResponse res(String a, int b, Locale c) {
        return new WallpaperResponse(messageSource.getMessage(a, null, c), b);
    }

}
