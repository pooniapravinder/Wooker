
package pages.controller.wooks;

import org.springframework.web.multipart.MultipartFile;

public class NewWook {
    
    private String title;
    private String type;
    private MultipartFile photo;
    private MultipartFile coverPhoto;
    private String privacy;
    private String writePublish;
    private String text;
    private String image;
    private String audio;
    private String video;
    private String file;
    private String TermsAndService;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public MultipartFile getPhoto() {
        return this.photo;
    }

    public void setPhoto(MultipartFile photo) {
        this.photo = photo;
    }

    public MultipartFile getCoverPhoto() {
        return this.coverPhoto;
    }

    public void setCoverPhoto(MultipartFile coverPhoto) {
        this.coverPhoto = coverPhoto;
    }

    public String getPrivacy() {
        return this.privacy;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    public String getWritePublish() {
        return this.writePublish;
    }

    public void setWritePublish(String writePublish) {
        this.writePublish = writePublish;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
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

    public String getTermsAndService() {
        return this.TermsAndService;
    }

    public void setTermsAndService(String TermsAndService) {
        this.TermsAndService = TermsAndService;
    }
}