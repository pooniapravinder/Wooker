package hibernate.mapping;

public class Wooks implements java.io.Serializable {

    private long autoId;
    private long userId;
    private String deviceId;
    private String title;
    private String wtype;
    private String photo;
    private String coverPhoto;
    private byte privacy;
    private byte publish;
    private boolean text;
    private boolean image;
    private boolean audio;
    private boolean video;
    private boolean file;
    private long timestampVal;

    public Wooks() {
    }

    public Wooks(long userId, String deviceId, String title, String wtype, byte privacy, byte publish, boolean text, boolean image, boolean audio, boolean video, boolean file, long timestampVal) {
        this.userId = userId;
        this.deviceId = deviceId;
        this.title = title;
        this.wtype = wtype;
        this.privacy = privacy;
        this.publish = publish;
        this.text = text;
        this.image = image;
        this.audio = audio;
        this.video = video;
        this.file = file;
        this.timestampVal = timestampVal;
    }

    public Wooks(long userId, String deviceId, String title, String wtype, String photo, String coverPhoto, byte privacy, byte publish, boolean text, boolean image, boolean audio, boolean video, boolean file, long timestampVal) {
        this.userId = userId;
        this.deviceId = deviceId;
        this.title = title;
        this.wtype = wtype;
        this.photo = photo;
        this.coverPhoto = coverPhoto;
        this.privacy = privacy;
        this.publish = publish;
        this.text = text;
        this.image = image;
        this.audio = audio;
        this.video = video;
        this.file = file;
        this.timestampVal = timestampVal;
    }

    public long getAutoId() {
        return this.autoId;
    }

    public void setAutoId(long autoId) {
        this.autoId = autoId;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWtype() {
        return this.wtype;
    }

    public void setWtype(String wtype) {
        this.wtype = wtype;
    }

    public String getPhoto() {
        return this.photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getCoverPhoto() {
        return this.coverPhoto;
    }

    public void setCoverPhoto(String coverPhoto) {
        this.coverPhoto = coverPhoto;
    }

    public byte getPrivacy() {
        return this.privacy;
    }

    public void setPrivacy(byte privacy) {
        this.privacy = privacy;
    }

    public byte getPublish() {
        return this.publish;
    }

    public void setPublish(byte publish) {
        this.publish = publish;
    }

    public boolean isText() {
        return this.text;
    }

    public void setText(boolean text) {
        this.text = text;
    }

    public boolean isImage() {
        return this.image;
    }

    public void setImage(boolean image) {
        this.image = image;
    }

    public boolean isAudio() {
        return this.audio;
    }

    public void setAudio(boolean audio) {
        this.audio = audio;
    }

    public boolean isVideo() {
        return this.video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public boolean isFile() {
        return this.file;
    }

    public void setFile(boolean file) {
        this.file = file;
    }

    public long getTimestampVal() {
        return this.timestampVal;
    }

    public void setTimestampVal(long timestampVal) {
        this.timestampVal = timestampVal;
    }

}
