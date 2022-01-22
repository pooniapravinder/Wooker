package pages.controller.chat;

import org.springframework.web.multipart.MultipartFile;

public class SendMessage implements java.io.Serializable {

    private String message;
    private MultipartFile attachment;
    private String prePic;
    private String requestConnect;

    public SendMessage() {
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public String getRequestConnect() {
        return this.requestConnect;
    }

    public void setRequestConnect(String requestConnect) {
        this.requestConnect = requestConnect;
    }

}
