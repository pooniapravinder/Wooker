package hibernate.mapping;

public class Posts  implements java.io.Serializable {

     private long autoId;
     private long wookId;
     private String deviceId;
     private long timestampVal;
     private long user;
     private String text;
     private boolean edited;
     private boolean deleted;
     private String picId;
     private String origName;
     private String mediaType;
     private Long mediaSize;

    public Posts() {
    }

	
    public Posts(long wookId, String deviceId, long timestampVal, long user, boolean edited, boolean deleted) {
        this.wookId = wookId;
        this.deviceId = deviceId;
        this.timestampVal = timestampVal;
        this.user = user;
        this.edited = edited;
        this.deleted = deleted;
    }
    public Posts(long wookId, String deviceId, long timestampVal, long user, String text, boolean edited, boolean deleted, String picId, String origName, String mediaType, Long mediaSize) {
       this.wookId = wookId;
       this.deviceId = deviceId;
       this.timestampVal = timestampVal;
       this.user = user;
       this.text = text;
       this.edited = edited;
       this.deleted = deleted;
       this.picId = picId;
       this.origName = origName;
       this.mediaType = mediaType;
       this.mediaSize = mediaSize;
    }
   
    public long getAutoId() {
        return this.autoId;
    }
    
    public void setAutoId(long autoId) {
        this.autoId = autoId;
    }
    public long getWookId() {
        return this.wookId;
    }
    
    public void setWookId(long wookId) {
        this.wookId = wookId;
    }
    public String getDeviceId() {
        return this.deviceId;
    }
    
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
    public long getTimestampVal() {
        return this.timestampVal;
    }
    
    public void setTimestampVal(long timestampVal) {
        this.timestampVal = timestampVal;
    }
    public long getUser() {
        return this.user;
    }
    
    public void setUser(long user) {
        this.user = user;
    }
    public String getText() {
        return this.text;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    public boolean isEdited() {
        return this.edited;
    }
    
    public void setEdited(boolean edited) {
        this.edited = edited;
    }
    public boolean isDeleted() {
        return this.deleted;
    }
    
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
    public String getPicId() {
        return this.picId;
    }
    
    public void setPicId(String picId) {
        this.picId = picId;
    }
    public String getOrigName() {
        return this.origName;
    }
    
    public void setOrigName(String origName) {
        this.origName = origName;
    }
    public String getMediaType() {
        return this.mediaType;
    }
    
    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }
    public Long getMediaSize() {
        return this.mediaSize;
    }
    
    public void setMediaSize(Long mediaSize) {
        this.mediaSize = mediaSize;
    }




}


