package pages.controller.chat;

import org.springframework.web.multipart.MultipartFile;

public class Chatsettings implements java.io.Serializable {

    private String wooks;
    private String remove;
    private String block;
    private String starred;
    private String priority;
    private String mute;
    private String offchat;
    private String privacy;
    private String settings;
    private String msgTime;
    private String msgLength;
    private String defWallpaper;
    private MultipartFile uplWallpaper;
    
    public Chatsettings() {
    }

    public String getWooks() {
        return this.wooks;
    }

    public void setWooks(String wooks) {
        this.wooks = wooks;
    }

    public String getRemove() {
        return this.remove;
    }

    public void setRemove(String remove) {
        this.remove = remove;
    }

    public String getBlock() {
        return this.block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getStarred() {
        return this.starred;
    }

    public void setStarred(String starred) {
        this.starred = starred;
    }

    public String getPriority() {
        return this.priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getMute() {
        return this.mute;
    }

    public void setMute(String mute) {
        this.mute = mute;
    }

    public String getOffchat() {
        return this.offchat;
    }

    public void setOffchat(String offchat) {
        this.offchat = offchat;
    }

    public String getPrivacy() {
        return this.privacy;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    public String getSettings() {
        return this.settings;
    }

    public void setSettings(String settings) {
        this.settings = settings;
    }

    public String getMsgTime() {
        return this.msgTime;
    }

    public void setMsgTime(String msgTime) {
        this.msgTime = msgTime;
    }

    public String getMsgLength() {
        return this.msgLength;
    }

    public void setMsgLength(String msgLength) {
        this.msgLength = msgLength;
    }

    public String getDefWallpaper() {
        return this.defWallpaper;
    }

    public void setDefWallpaper(String defWallpaper) {
        this.defWallpaper = defWallpaper;
    }

    public MultipartFile getUplWallpaper() {
        return this.uplWallpaper;
    }

    public void setUplWallpaper(MultipartFile uplWallpaper) {
        this.uplWallpaper = uplWallpaper;
    }

}
