package pages.controller.moreinfo;

import hibernate.mapping.Showhideaddmoreinfo;
import hibernate.mapping.Showhidemoreinfo;

public class Upmoinsettings implements java.io.Serializable {

    private String info;
    private String moreInfo;
    private String addmoInfo;
    private String settings;
    private String security;
    private String school;
    private String grcollege;
    private String gruniver;
    private String pogrcoll;
    private String pogruniver;
    private String work;
    private String location;
    private String moved;
    private String mobile;
    private String email;
    private String website;
    private String hobbies;
    private String relationship;
    private String relation;
    private String languages;
    private String religion;
    private String behaviour;
    private String myself;
    private String newcateg;
    private String showHide;

    public Upmoinsettings() {
    }

    public Upmoinsettings(Showhidemoreinfo getInfo) {
        this.info = String.valueOf(getInfo != null ? getInfo.isInfo() : true);
        this.addmoInfo = String.valueOf(getInfo != null ? getInfo.isAddmoin() : true);
        this.settings = String.valueOf(getInfo != null ? getInfo.isSetting() : true);
        this.security = String.valueOf(getInfo != null ? getInfo.isSecurity() : true);
        this.school = String.valueOf(getInfo != null ? getInfo.isSchool() : true);
        this.grcollege = String.valueOf(getInfo != null ? getInfo.isGrcollege() : true);
        this.gruniver = String.valueOf(getInfo != null ? getInfo.isGruniver() : true);
        this.pogrcoll = String.valueOf(getInfo != null ? getInfo.isPogrcoll() : true);
        this.pogruniver = String.valueOf(getInfo != null ? getInfo.isPogruniv() : true);
        this.work = String.valueOf(getInfo != null ? getInfo.isWorks() : true);
        this.location = String.valueOf(getInfo != null ? getInfo.isLocation() : true);
        this.moved = String.valueOf(getInfo != null ? getInfo.isMoved() : true);
        this.mobile = String.valueOf(getInfo != null ? getInfo.isMobile() : true);
        this.email = String.valueOf(getInfo != null ? getInfo.isEmail() : true);
        this.website = String.valueOf(getInfo != null ? getInfo.isWebsite() : true);
        this.hobbies = String.valueOf(getInfo != null ? getInfo.isHobbies() : true);
        this.relationship = String.valueOf(getInfo != null ? getInfo.isRelationship() : true);
        this.relation = String.valueOf(getInfo != null ? getInfo.isRelation() : true);
        this.languages = String.valueOf(getInfo != null ? getInfo.isLanguages() : true);
        this.religion = String.valueOf(getInfo != null ? getInfo.isReligion() : true);
        this.behaviour = String.valueOf(getInfo != null ? getInfo.isBehaviour() : true);
        this.myself = String.valueOf(getInfo != null ? getInfo.isMyself() : true);
        this.newcateg = String.valueOf(getInfo != null ? getInfo.isNewcateg() : true);
    }

    public Upmoinsettings(Showhideaddmoreinfo getInfo) {
        this.info = String.valueOf(getInfo != null ? getInfo.isInfo() : true);
        this.moreInfo = String.valueOf(getInfo != null ? getInfo.isMoreinfo() : true);
        this.settings = String.valueOf(getInfo != null ? getInfo.isSetting() : true);
        this.security = String.valueOf(getInfo != null ? getInfo.isSecurity() : true);
        this.school = String.valueOf(getInfo != null ? getInfo.isSchool() : true);
        this.grcollege = String.valueOf(getInfo != null ? getInfo.isGrcollege() : true);
        this.gruniver = String.valueOf(getInfo != null ? getInfo.isGruniver() : true);
        this.pogrcoll = String.valueOf(getInfo != null ? getInfo.isPogrcoll() : true);
        this.pogruniver = String.valueOf(getInfo != null ? getInfo.isPogruniv() : true);
        this.work = String.valueOf(getInfo != null ? getInfo.isWorks() : true);
        this.location = String.valueOf(getInfo != null ? getInfo.isLocation() : true);
        this.moved = String.valueOf(getInfo != null ? getInfo.isMoved() : true);
        this.mobile = String.valueOf(getInfo != null ? getInfo.isMobile() : true);
        this.email = String.valueOf(getInfo != null ? getInfo.isEmail() : true);
        this.website = String.valueOf(getInfo != null ? getInfo.isWebsite() : true);
        this.hobbies = String.valueOf(getInfo != null ? getInfo.isHobbies() : true);
        this.relationship = String.valueOf(getInfo != null ? getInfo.isRelationship() : true);
        this.relation = String.valueOf(getInfo != null ? getInfo.isRelation() : true);
        this.languages = String.valueOf(getInfo != null ? getInfo.isLanguages() : true);
        this.religion = String.valueOf(getInfo != null ? getInfo.isReligion() : true);
        this.behaviour = String.valueOf(getInfo != null ? getInfo.isBehaviour() : true);
        this.myself = String.valueOf(getInfo != null ? getInfo.isMyself() : true);
        this.newcateg = String.valueOf(getInfo != null ? getInfo.isNewcateg() : true);
        this.showHide = String.valueOf(getInfo != null ? getInfo.isInfo() : true);

    }

    public String getInfo() {
        return this.info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getMoreInfo() {
        return this.moreInfo;
    }

    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
    }

    public String getAddmoInfo() {
        return this.addmoInfo;
    }

    public void setAddmoInfo(String addmoInfo) {
        this.addmoInfo = addmoInfo;
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

    public String getSchool() {
        return this.school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getGrcollege() {
        return this.grcollege;
    }

    public void setGrcollege(String grcollege) {
        this.grcollege = grcollege;
    }

    public String getGruniver() {
        return this.gruniver;
    }

    public void setGruniver(String gruniver) {
        this.gruniver = gruniver;
    }

    public String getPogrcoll() {
        return this.pogrcoll;
    }

    public void setPogrcoll(String pogrcoll) {
        this.pogrcoll = pogrcoll;
    }

    public String getPogruniver() {
        return this.pogruniver;
    }

    public void setPogruniver(String pogruniver) {
        this.pogruniver = pogruniver;
    }

    public String getWork() {
        return this.work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMoved() {
        return this.moved;
    }

    public void setMoved(String moved) {
        this.moved = moved;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return this.website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getHobbies() {
        return this.hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public String getRelationship() {
        return this.relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getRelation() {
        return this.relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getLanguages() {
        return this.languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getReligion() {
        return this.religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getBehaviour() {
        return this.behaviour;
    }

    public void setBehaviour(String behaviour) {
        this.behaviour = behaviour;
    }

    public String getMyself() {
        return this.myself;
    }

    public void setMyself(String myself) {
        this.myself = myself;
    }

    public String getNewcateg() {
        return this.newcateg;
    }

    public void setNewcateg(String newcateg) {
        this.newcateg = newcateg;
    }

    public String getShowHide() {
        return this.showHide;
    }

    public void setShowHide(String showHide) {
        this.showHide = showHide;
    }

}
