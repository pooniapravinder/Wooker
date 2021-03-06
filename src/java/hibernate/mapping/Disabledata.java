package hibernate.mapping;
// Generated Jul 15, 2018 2:21:40 AM by Hibernate Tools 4.3.1



/**
 * Disabledata generated by hbm2java
 */
public class Disabledata  implements java.io.Serializable {


     private long autoId;
     private String deviceId;
     private long timestampVal;
     private String targetId;
     private boolean disabled;
     private Long timeperiod;

    public Disabledata() {
    }

	
    public Disabledata(String deviceId, long timestampVal, String targetId, boolean disabled) {
        this.deviceId = deviceId;
        this.timestampVal = timestampVal;
        this.targetId = targetId;
        this.disabled = disabled;
    }
    public Disabledata(String deviceId, long timestampVal, String targetId, boolean disabled, Long timeperiod) {
       this.deviceId = deviceId;
       this.timestampVal = timestampVal;
       this.targetId = targetId;
       this.disabled = disabled;
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
    public boolean isDisabled() {
        return this.disabled;
    }
    
    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }
    public Long getTimeperiod() {
        return this.timeperiod;
    }
    
    public void setTimeperiod(Long timeperiod) {
        this.timeperiod = timeperiod;
    }




}


