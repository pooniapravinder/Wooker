package hibernate.mapping;
// Generated Jul 18, 2018 9:20:21 PM by Hibernate Tools 4.3.1



/**
 * Comments generated by hbm2java
 */
public class Comments  implements java.io.Serializable {


     private long autoId;
     private String deviceId;
     private long timestampVal;
     private long timestampComment;
     private String operId;
     private long userOne;
     private long userTwo;
     private String targetId;
     private String commentText;
     private boolean selfUser;
     private boolean edited;
     private boolean deleted;
     private String picId;
     private String origName;
     private String mediaType;
     private Long mediaSize;

    public Comments() {
    }

	
    public Comments(String deviceId, long timestampVal, long timestampComment, String operId, long userOne, long userTwo, String targetId, boolean selfUser, boolean edited, boolean deleted) {
        this.deviceId = deviceId;
        this.timestampVal = timestampVal;
        this.timestampComment = timestampComment;
        this.operId = operId;
        this.userOne = userOne;
        this.userTwo = userTwo;
        this.targetId = targetId;
        this.selfUser = selfUser;
        this.edited = edited;
        this.deleted = deleted;
    }
    public Comments(String deviceId, long timestampVal, long timestampComment, String operId, long userOne, long userTwo, String targetId, String commentText, boolean selfUser, boolean edited, boolean deleted, String picId, String origName, String mediaType, Long mediaSize) {
       this.deviceId = deviceId;
       this.timestampVal = timestampVal;
       this.timestampComment = timestampComment;
       this.operId = operId;
       this.userOne = userOne;
       this.userTwo = userTwo;
       this.targetId = targetId;
       this.commentText = commentText;
       this.selfUser = selfUser;
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
    public long getTimestampComment() {
        return this.timestampComment;
    }
    
    public void setTimestampComment(long timestampComment) {
        this.timestampComment = timestampComment;
    }
    public String getOperId() {
        return this.operId;
    }
    
    public void setOperId(String operId) {
        this.operId = operId;
    }
    public long getUserOne() {
        return this.userOne;
    }
    
    public void setUserOne(long userOne) {
        this.userOne = userOne;
    }
    public long getUserTwo() {
        return this.userTwo;
    }
    
    public void setUserTwo(long userTwo) {
        this.userTwo = userTwo;
    }
    public String getTargetId() {
        return this.targetId;
    }
    
    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }
    public String getCommentText() {
        return this.commentText;
    }
    
    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }
    public boolean isSelfUser() {
        return this.selfUser;
    }
    
    public void setSelfUser(boolean selfUser) {
        this.selfUser = selfUser;
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

