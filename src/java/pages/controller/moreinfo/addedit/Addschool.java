package pages.controller.moreinfo.addedit;

import hibernate.mapping.Secondaryinfo;
import org.springframework.web.multipart.MultipartFile;

public class Addschool implements java.io.Serializable {

    private String userSchool;
    private String schenMonth;
    private String schenDate;
    private String schenYear;
    private String schleMonth;
    private String schleDate;
    private String schleYear;
    private MultipartFile schPic;
    private String schDesc;
    private String schPri;
    private String schlPri;

    public Addschool() {
    }
    
    public Addschool(Secondaryinfo getInfo) {
        this.userSchool = getInfo.getSchool();
        this.schenMonth = getInfo.getSchoolentr().split("/")[0];
        this.schenDate = getInfo.getSchoolentr().split("/")[1];
        this.schenYear = getInfo.getSchoolentr().split("/")[2];
        this.schleMonth = getInfo.getSchoolleave().split("/")[0];
        this.schleDate = getInfo.getSchoolleave().split("/")[1];
        this.schleYear = getInfo.getSchoolleave().split("/")[2];
        this.schDesc = getInfo.getSchooldesc();
        this.schPri = String.valueOf(getInfo.getSchoolpri());
        this.schlPri = String.valueOf(getInfo.getSchoolPrivacy());
    }

    public String getUserSchool() {
        return this.userSchool;
    }

    public void setUserSchool(String userSchool) {
        this.userSchool = userSchool;
    }

    public String getSchenMonth() {
        return this.schenMonth;
    }

    public void setSchenMonth(String schenMonth) {
        this.schenMonth = schenMonth;
    }

    public String getSchenDate() {
        return this.schenDate;
    }

    public void setSchenDate(String schenDate) {
        this.schenDate = schenDate;
    }

    public String getSchenYear() {
        return this.schenYear;
    }

    public void setSchenYear(String schenYear) {
        this.schenYear = schenYear;
    }

    public String getSchleMonth() {
        return this.schleMonth;
    }

    public void setSchleMonth(String schleMonth) {
        this.schleMonth = schleMonth;
    }

    public String getSchleDate() {
        return this.schleDate;
    }

    public void setSchleDate(String schleDate) {
        this.schleDate = schleDate;
    }

    public String getSchleYear() {
        return this.schleYear;
    }

    public void setSchleYear(String schleYear) {
        this.schleYear = schleYear;
    }

    public MultipartFile getSchPic() {
        return this.schPic;
    }

    public void setSchPic(MultipartFile schPic) {
        this.schPic = schPic;
    }

    public String getSchDesc() {
        return this.schDesc;
    }

    public void setSchDesc(String schDesc) {
        this.schDesc = schDesc.trim().replaceAll("\\s+", " ");
    }

    public String getSchPri() {
        return this.schPri;
    }

    public void setSchPri(String schPri) {
        this.schPri = schPri;
    }

    public String getSchlPri() {
        return this.schlPri;
    }

    public void setSchlPri(String schlPri) {
        this.schlPri = schlPri;
    }

}
