package hibernate.mapping;
// Generated Jul 8, 2018 11:27:17 PM by Hibernate Tools 4.3.1



/**
 * Searches generated by hbm2java
 */
public class Searches  implements java.io.Serializable {


     private Long autoId;
     private long userId;
     private String deviceId;
     private String searchText;
     private long setTimestamp;

    public Searches() {
    }

    public Searches(long userId, String deviceId, String searchText, long setTimestamp) {
       this.userId = userId;
       this.deviceId = deviceId;
       this.searchText = searchText;
       this.setTimestamp = setTimestamp;
    }
   
    public Long getAutoId() {
        return this.autoId;
    }
    
    public void setAutoId(Long autoId) {
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
    public String getSearchText() {
        return this.searchText;
    }
    
    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }
    public long getSetTimestamp() {
        return this.setTimestamp;
    }
    
    public void setSetTimestamp(long setTimestamp) {
        this.setTimestamp = setTimestamp;
    }




}

