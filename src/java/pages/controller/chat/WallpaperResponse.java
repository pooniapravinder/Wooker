package pages.controller.chat;

public class WallpaperResponse implements java.io.Serializable {

    private String status;
    private int type;

    public WallpaperResponse(String status, int type) {
        this.status = status;
        this.type = type;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
