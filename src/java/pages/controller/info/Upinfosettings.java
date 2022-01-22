package pages.controller.info;

import hibernate.mapping.Showhideinfo;

public class Upinfosettings implements java.io.Serializable {

    private String secInfo;
    private String edPrInfo;
    private String settings;
    private String security;
    private String accPic;
    private String edAccPic;
    private String upNew;
    private String disName;
    private String firName;
    private String lasName;
    private String nicName;
    private String gender;
    private String birthDay;
    private String age;
    private String account;
    private String showHide;

    public Upinfosettings() {
    }

    public Upinfosettings(Showhideinfo option) {
        this.secInfo = String.valueOf(option != null ? option.isMoreinfo() : true);
        this.edPrInfo = String.valueOf(option != null ? option.isEditinfo() : true);
        this.settings = String.valueOf(option != null ? option.isSetting() : true);
        this.security = String.valueOf(option != null ? option.isSecurity() : true);
        this.accPic = String.valueOf(option != null ? option.isAccpic() : true);
        this.edAccPic = String.valueOf(option != null ? option.isEdaccpic() : true);
        this.upNew = String.valueOf(option != null ? option.isUploadnew() : true);
        this.disName = String.valueOf(option != null ? option.isDisplayname() : true);
        this.firName = String.valueOf(option != null ? option.isFirstname() : true);
        this.lasName = String.valueOf(option != null ? option.isLastname() : true);
        this.nicName = String.valueOf(option != null ? option.isNickname() : true);
        this.gender = String.valueOf(option != null ? option.isGender() : true);
        this.birthDay = String.valueOf(option != null ? option.isBirthday() : true);
        this.age = String.valueOf(option != null ? option.isAge() : true);
        this.account = String.valueOf(option != null ? option.isAccounttype() : true);
        this.showHide = String.valueOf(option != null ? option.isShowhide() : true);
    }

    public String getSecInfo() {
        return this.secInfo;
    }

    public void setSecInfo(String secInfo) {
        this.secInfo = secInfo;
    }

    public String getEdPrInfo() {
        return this.edPrInfo;
    }

    public void setEdPrInfo(String edPrInfo) {
        this.edPrInfo = edPrInfo;
    }

    public String getSettings() {
        return this.settings;
    }

    public void setSettings(String settings) {
        this.settings = settings;
    }

    public String getSecurity() {
        return this.security;
    }

    public void setSecurity(String security) {
        this.security = security;
    }

    public String getAccPic() {
        return this.accPic;
    }

    public void setAccPic(String accPic) {
        this.accPic = accPic;
    }

    public String getEdAccPic() {
        return this.edAccPic;
    }

    public void setEdAccPic(String edAccPic) {
        this.edAccPic = edAccPic;
    }

    public String getUpNew() {
        return this.upNew;
    }

    public void setUpNew(String upNew) {
        this.upNew = upNew;
    }

    public String getDisName() {
        return this.disName;
    }

    public void setDisName(String disName) {
        this.disName = disName;
    }

    public String getFirName() {
        return this.firName;
    }

    public void setFirName(String firName) {
        this.firName = firName;
    }

    public String getLasName() {
        return this.lasName;
    }

    public void setLasName(String lasName) {
        this.lasName = lasName;
    }

    public String getNicName() {
        return this.nicName;
    }

    public void setNicName(String nicName) {
        this.nicName = nicName;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthDay() {
        return this.birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getAge() {
        return this.age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAccount() {
        return this.account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getShowHide() {
        return this.showHide;
    }

    public void setShowHide(String showHide) {
        this.showHide = showHide;
    }
}
