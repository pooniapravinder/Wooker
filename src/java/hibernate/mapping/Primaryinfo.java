package hibernate.mapping;
// Generated Jul 8, 2018 11:27:17 PM by Hibernate Tools 4.3.1



/**
 * Primaryinfo generated by hbm2java
 */
public class Primaryinfo  implements java.io.Serializable {


     private Long autoId;
     private long userId;
     private String deviceId;
     private String prisecurPass;
     private long prisecurTstmp;
     private byte prisecurAttempt;
     private String edprisecurPass;
     private long edprisecurTstmp;
     private byte edprisecurAttempt;
     private boolean primaryUpdate;
     private String firstName;
     private String lastName;
     private String nickName;
     private byte nicknameCombination;
     private byte nicknamePrivacy;
     private String gender;
     private byte genderPrivacy;
     private String birthDay;
     private byte monthPrivacy;
     private byte datePrivacy;
     private byte yearPrivacy;
     private byte agePrivacy;
     private String emailidPhone;
     private byte accountPrivacy;
     private long timestampVal;

    public Primaryinfo() {
    }

    public Primaryinfo(long userId, String deviceId, String prisecurPass, long prisecurTstmp, byte prisecurAttempt, String edprisecurPass, long edprisecurTstmp, byte edprisecurAttempt, boolean primaryUpdate, String firstName, String lastName, String nickName, byte nicknameCombination, byte nicknamePrivacy, String gender, byte genderPrivacy, String birthDay, byte monthPrivacy, byte datePrivacy, byte yearPrivacy, byte agePrivacy, String emailidPhone, byte accountPrivacy, long timestampVal) {
       this.userId = userId;
       this.deviceId = deviceId;
       this.prisecurPass = prisecurPass;
       this.prisecurTstmp = prisecurTstmp;
       this.prisecurAttempt = prisecurAttempt;
       this.edprisecurPass = edprisecurPass;
       this.edprisecurTstmp = edprisecurTstmp;
       this.edprisecurAttempt = edprisecurAttempt;
       this.primaryUpdate = primaryUpdate;
       this.firstName = firstName;
       this.lastName = lastName;
       this.nickName = nickName;
       this.nicknameCombination = nicknameCombination;
       this.nicknamePrivacy = nicknamePrivacy;
       this.gender = gender;
       this.genderPrivacy = genderPrivacy;
       this.birthDay = birthDay;
       this.monthPrivacy = monthPrivacy;
       this.datePrivacy = datePrivacy;
       this.yearPrivacy = yearPrivacy;
       this.agePrivacy = agePrivacy;
       this.emailidPhone = emailidPhone;
       this.accountPrivacy = accountPrivacy;
       this.timestampVal = timestampVal;
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
    public String getPrisecurPass() {
        return this.prisecurPass;
    }
    
    public void setPrisecurPass(String prisecurPass) {
        this.prisecurPass = prisecurPass;
    }
    public long getPrisecurTstmp() {
        return this.prisecurTstmp;
    }
    
    public void setPrisecurTstmp(long prisecurTstmp) {
        this.prisecurTstmp = prisecurTstmp;
    }
    public byte getPrisecurAttempt() {
        return this.prisecurAttempt;
    }
    
    public void setPrisecurAttempt(byte prisecurAttempt) {
        this.prisecurAttempt = prisecurAttempt;
    }
    public String getEdprisecurPass() {
        return this.edprisecurPass;
    }
    
    public void setEdprisecurPass(String edprisecurPass) {
        this.edprisecurPass = edprisecurPass;
    }
    public long getEdprisecurTstmp() {
        return this.edprisecurTstmp;
    }
    
    public void setEdprisecurTstmp(long edprisecurTstmp) {
        this.edprisecurTstmp = edprisecurTstmp;
    }
    public byte getEdprisecurAttempt() {
        return this.edprisecurAttempt;
    }
    
    public void setEdprisecurAttempt(byte edprisecurAttempt) {
        this.edprisecurAttempt = edprisecurAttempt;
    }
    public boolean isPrimaryUpdate() {
        return this.primaryUpdate;
    }
    
    public void setPrimaryUpdate(boolean primaryUpdate) {
        this.primaryUpdate = primaryUpdate;
    }
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getNickName() {
        return this.nickName;
    }
    
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public byte getNicknameCombination() {
        return this.nicknameCombination;
    }
    
    public void setNicknameCombination(byte nicknameCombination) {
        this.nicknameCombination = nicknameCombination;
    }
    public byte getNicknamePrivacy() {
        return this.nicknamePrivacy;
    }
    
    public void setNicknamePrivacy(byte nicknamePrivacy) {
        this.nicknamePrivacy = nicknamePrivacy;
    }
    public String getGender() {
        return this.gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    public byte getGenderPrivacy() {
        return this.genderPrivacy;
    }
    
    public void setGenderPrivacy(byte genderPrivacy) {
        this.genderPrivacy = genderPrivacy;
    }
    public String getBirthDay() {
        return this.birthDay;
    }
    
    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }
    public byte getMonthPrivacy() {
        return this.monthPrivacy;
    }
    
    public void setMonthPrivacy(byte monthPrivacy) {
        this.monthPrivacy = monthPrivacy;
    }
    public byte getDatePrivacy() {
        return this.datePrivacy;
    }
    
    public void setDatePrivacy(byte datePrivacy) {
        this.datePrivacy = datePrivacy;
    }
    public byte getYearPrivacy() {
        return this.yearPrivacy;
    }
    
    public void setYearPrivacy(byte yearPrivacy) {
        this.yearPrivacy = yearPrivacy;
    }
    public byte getAgePrivacy() {
        return this.agePrivacy;
    }
    
    public void setAgePrivacy(byte agePrivacy) {
        this.agePrivacy = agePrivacy;
    }
    public String getEmailidPhone() {
        return this.emailidPhone;
    }
    
    public void setEmailidPhone(String emailidPhone) {
        this.emailidPhone = emailidPhone;
    }
    public byte getAccountPrivacy() {
        return this.accountPrivacy;
    }
    
    public void setAccountPrivacy(byte accountPrivacy) {
        this.accountPrivacy = accountPrivacy;
    }
    public long getTimestampVal() {
        return this.timestampVal;
    }
    
    public void setTimestampVal(long timestampVal) {
        this.timestampVal = timestampVal;
    }




}


