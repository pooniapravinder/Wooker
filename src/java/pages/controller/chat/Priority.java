package pages.controller.chat;

public class Priority {

    private String openChatpage;
    private String position;
    private String notification;

    public Priority() {
    }

    public Priority(String openChatpage, String position, String notification) {
        this.openChatpage = openChatpage;
        this.position = position;
        this.notification = notification;
    }

    public String getOpenChatpage() {
        return this.openChatpage;
    }

    public void setOpenChatpage(String openChatpage) {
        this.openChatpage = openChatpage;
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getNotification() {
        return this.notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }
}
