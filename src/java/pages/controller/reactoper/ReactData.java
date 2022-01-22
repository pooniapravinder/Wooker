package pages.controller.reactoper;

import org.springframework.web.multipart.MultipartFile;

public class ReactData implements java.io.Serializable {
    
    private String talking;
    private String comment;
    private MultipartFile attachment;
    private String prePic;
    private String remAttachment;
    
    public ReactData() {
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
    
    public MultipartFile getAttachment() {
        return this.attachment;
    }

    public void setAttachment(MultipartFile attachment) {
        this.attachment = attachment;
    }
    
    public String getPrePic() {
        return this.prePic;
    }

    public void setPrePic(String prePic) {
        this.prePic = prePic;
    }
    
    public String getRemAttachment() {
        return this.remAttachment;
    }

    public void setRemAttachment(String remAttachment) {
        this.remAttachment = remAttachment;
    }
    
}
