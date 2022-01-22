package pages.controller.chat;

import hibernate.mapping.Chatuseroptions;

public class Chatuserprivacy implements java.io.Serializable {

    private String likeDislike;
    private String talking;
    private String comment;
    private String share;
    private String chat;
    private String image;
    private String audio;
    private String video;
    private String file;
    private String gif;

    public Chatuserprivacy() {
    }

    public Chatuserprivacy(Chatuseroptions option, boolean chat) {
        this.likeDislike = String.valueOf(option != null ? option.isLikeDislike() : true);
        this.talking = String.valueOf(option != null ? option.isTalking() : true);
        this.comment = String.valueOf(option != null ? option.isComment() : true);
        this.share = String.valueOf(option != null ? option.isShare() : true);
        this.chat = String.valueOf(chat);
        this.image = String.valueOf(option != null ? option.isChatImage() : true);
        this.audio = String.valueOf(option != null ? option.isChatAudio() : true);
        this.video = String.valueOf(option != null ? option.isChatVideo() : true);
        this.file = String.valueOf(option != null ? option.isChatFile() : true);
        this.gif = String.valueOf(option != null ? option.isChatGif() : true);
    }

    public String getLikeDislike() {
        return this.likeDislike;
    }

    public void setLikeDislike(String likeDislike) {
        this.likeDislike = likeDislike;
    }

    public String getTalking() {
        return this.talking;
    }

    public void setTalking(String talking) {
        this.talking = talking;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getShare() {
        return this.share;
    }

    public void setShare(String share) {
        this.share = share;
    }

    public String getChat() {
        return this.chat;
    }

    public void setChat(String chat) {
        this.chat = chat;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAudio() {
        return this.audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public String getVideo() {
        return this.video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getFile() {
        return this.file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getGif() {
        return this.gif;
    }

    public void setGif(String gif) {
        this.gif = gif;
    }

}
