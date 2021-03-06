package hibernate.mapping;
// Generated Jul 8, 2018 11:27:17 PM by Hibernate Tools 4.3.1



/**
 * Accounts generated by hbm2java
 */
public class Accounts  implements java.io.Serializable {


     private Long userId;
     private String deviceId;
     private long creationTimestamp;
     private boolean verifiedAccount;
     private boolean twoStep;
     private String country;
     private String emailidPhone;
     private String password;

    public Accounts() {
    }

    public Accounts(String deviceId, long creationTimestamp, boolean verifiedAccount, boolean twoStep, String country, String emailidPhone, String password) {
       this.deviceId = deviceId;
       this.creationTimestamp = creationTimestamp;
       this.verifiedAccount = verifiedAccount;
       this.twoStep = twoStep;
       this.country = country;
       this.emailidPhone = emailidPhone;
       this.password = password;
    }
   
    public Long getUserId() {
        return this.userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getDeviceId() {
        return this.deviceId;
    }
    
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
    public long getCreationTimestamp() {
        return this.creationTimestamp;
    }
    
    public void setCreationTimestamp(long creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }
    public boolean isVerifiedAccount() {
        return this.verifiedAccount;
    }
    
    public void setVerifiedAccount(boolean verifiedAccount) {
        this.verifiedAccount = verifiedAccount;
    }
    public boolean isTwoStep() {
        return this.twoStep;
    }
    
    public void setTwoStep(boolean twoStep) {
        this.twoStep = twoStep;
    }
    public String getCountry() {
        return this.country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }
    public String getEmailidPhone() {
        return this.emailidPhone;
    }
    
    public void setEmailidPhone(String emailidPhone) {
        this.emailidPhone = emailidPhone;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }




}


