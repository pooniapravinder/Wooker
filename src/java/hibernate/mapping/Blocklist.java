package hibernate.mapping;
// Generated Jul 15, 2018 2:21:40 AM by Hibernate Tools 4.3.1



/**
 * Blocklist generated by hbm2java
 */
public class Blocklist  implements java.io.Serializable {


     private long autoId;
     private String deviceId;
     private long timestampVal;
     private String targetId;
     private long userId;
     private boolean blockedUser;
     private Long timeperiod;

    public Blocklist() {
    }

	
    public Blocklist(String deviceId, long timestampVal, String targetId, long userId, boolean blockedUser) {
        this.deviceId = deviceId;
        this.timestampVal = timestampVal;
        this.targetId = targetId;
        this.userId = userId;
        this.blockedUser = blockedUser;
    }
    public Blocklist(String deviceId, long timestampVal, String targetId, long userId, boolean blockedUser, Long timeperiod) {
       this.deviceId = deviceId;
       this.timestampVal = timestampVal;
       this.targetId = targetId;
       this.userId = userId;
       this.blockedUser = blockedUser;
       this.timeperiod = timeperiod;
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
    public String getTargetId() {
        return this.targetId;
    }
    
    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }
    public long getUserId() {
        return this.userId;
    }
    
    public void setUserId(long userId) {
        this.userId = userId;
    }
    public boolean isBlockedUser() {
        return this.blockedUser;
    }
    
    public void setBlockedUser(boolean blockedUser) {
        this.blockedUser = blockedUser;
    }
    public Long getTimeperiod() {
        return this.timeperiod;
    }
    
    public void setTimeperiod(Long timeperiod) {
        this.timeperiod = timeperiod;
    }




}


