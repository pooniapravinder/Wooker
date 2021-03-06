package hibernate.mapping;
// Generated Jul 8, 2018 11:27:17 PM by Hibernate Tools 4.3.1



/**
 * Showhideeditinfo generated by hbm2java
 */
public class Showhideeditinfo  implements java.io.Serializable {


     private Long autoId;
     private long userId;
     private String deviceId;
     private boolean info;
     private boolean moreinfo;
     private boolean setting;
     private boolean security;
     private boolean lastsaved;
     private boolean firstname;
     private boolean lastname;
     private boolean nickname;
     private boolean gender;
     private boolean birthday;
     private boolean age;
     private boolean accounttype;
     private boolean showhide;

    public Showhideeditinfo() {
    }

    public Showhideeditinfo(long userId, String deviceId, boolean info, boolean moreinfo, boolean setting, boolean security, boolean lastsaved, boolean firstname, boolean lastname, boolean nickname, boolean gender, boolean birthday, boolean age, boolean accounttype, boolean showhide) {
       this.userId = userId;
       this.deviceId = deviceId;
       this.info = info;
       this.moreinfo = moreinfo;
       this.setting = setting;
       this.security = security;
       this.lastsaved = lastsaved;
       this.firstname = firstname;
       this.lastname = lastname;
       this.nickname = nickname;
       this.gender = gender;
       this.birthday = birthday;
       this.age = age;
       this.accounttype = accounttype;
       this.showhide = showhide;
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
    public boolean isInfo() {
        return this.info;
    }
    
    public void setInfo(boolean info) {
        this.info = info;
    }
    public boolean isMoreinfo() {
        return this.moreinfo;
    }
    
    public void setMoreinfo(boolean moreinfo) {
        this.moreinfo = moreinfo;
    }
    public boolean isSetting() {
        return this.setting;
    }
    
    public void setSetting(boolean setting) {
        this.setting = setting;
    }
    public boolean isSecurity() {
        return this.security;
    }
    
    public void setSecurity(boolean security) {
        this.security = security;
    }
    public boolean isLastsaved() {
        return this.lastsaved;
    }
    
    public void setLastsaved(boolean lastsaved) {
        this.lastsaved = lastsaved;
    }
    public boolean isFirstname() {
        return this.firstname;
    }
    
    public void setFirstname(boolean firstname) {
        this.firstname = firstname;
    }
    public boolean isLastname() {
        return this.lastname;
    }
    
    public void setLastname(boolean lastname) {
        this.lastname = lastname;
    }
    public boolean isNickname() {
        return this.nickname;
    }
    
    public void setNickname(boolean nickname) {
        this.nickname = nickname;
    }
    public boolean isGender() {
        return this.gender;
    }
    
    public void setGender(boolean gender) {
        this.gender = gender;
    }
    public boolean isBirthday() {
        return this.birthday;
    }
    
    public void setBirthday(boolean birthday) {
        this.birthday = birthday;
    }
    public boolean isAge() {
        return this.age;
    }
    
    public void setAge(boolean age) {
        this.age = age;
    }
    public boolean isAccounttype() {
        return this.accounttype;
    }
    
    public void setAccounttype(boolean accounttype) {
        this.accounttype = accounttype;
    }
    public boolean isShowhide() {
        return this.showhide;
    }
    
    public void setShowhide(boolean showhide) {
        this.showhide = showhide;
    }




}


