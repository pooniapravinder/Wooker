package pages.controller.wooks;

import org.springframework.web.multipart.MultipartFile;

public class MakePost implements java.io.Serializable {
    
    private String textData;
    private MultipartFile attachment;
    private String prePic;
    
    public MakePost() {
    }

    public String getTextData() {
        return this.textData;
    }

    public void setTextData(String textData) {
        this.textData = textData;
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

}
