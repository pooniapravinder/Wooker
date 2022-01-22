package hibernate.mapping;
// Generated Jul 8, 2018 11:27:17 PM by Hibernate Tools 4.3.1



/**
 * Likesdislikes generated by hbm2java
 */
public class Likesdislikes  implements java.io.Serializable {


     private Long autoId;
     private String deviceId;
     private long userId;
     private String targetId;
     private long timestampVal;
     private Boolean likeDislike;
     private Boolean blockedUser;

    public Likesdislikes() {
    }

	
    public Likesdislikes(String deviceId, long userId, String targetId, long timestampVal) {
        this.deviceId = deviceId;
        this.userId = userId;
        this.targetId = targetId;
        this.timestampVal = timestampVal;
    }
    public Likesdislikes(String deviceId, long userId, String targetId, long timestampVal, Boolean likeDislike, Boolean blockedUser) {
       this.deviceId = deviceId;
       this.userId = userId;
       this.targetId = targetId;
       this.timestampVal = timestampVal;
       this.likeDislike = likeDislike;
       this.blockedUser = blockedUser;
    }
   
    public Long getAutoId() {
        return this.autoId;
    }
    
    public void setAutoId(Long autoId) {
        this.autoId = autoId;
    }
    public String getDeviceId() {
        return this.deviceId;
    }
    
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
    public long getUserId() {
        return this.userId;
    }
    
    public void setUserId(long userId) {
        this.userId = userId;
    }
    public String getTargetId() {
        return this.targetId;
    }
    
    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }
    public long getTimestampVal() {
        return this.timestampVal;
    }
    
    public void setTimestampVal(long timestampVal) {
        this.timestampVal = timestampVal;
    }
    public Boolean getLikeDislike() {
        return this.likeDislike;
    }
    
    public void setLikeDislike(Boolean likeDislike) {
        this.likeDislike = likeDislike;
    }
    public Boolean getBlockedUser() {
        return this.blockedUser;
    }
    
    public void setBlockedUser(Boolean blockedUser) {
        this.blockedUser = blockedUser;
    }




}


