package pages.controller.moreinfo.addedit;

import hibernate.mapping.Secondaryinfo;
import org.springframework.web.multipart.MultipartFile;

public class Addrelationship implements java.io.Serializable {
    
    private String relatiname;
    private String relationship;
    private String relatiMonth;
    private String relatiDate;
    private String relatiYear;
    private String relatipri;
    private MultipartFile relatiPic;
    private String relatidesc;
    
    public Addrelationship() {
    }
    
    public Addrelationship(Secondaryinfo getInfo) {
        this.relatiname = getInfo.getRelatiname();
        this.relationship = String.valueOf(getInfo.getRelationship());
        this.relatiMonth = getInfo.getRelatitime().split("/")[0];
        this.relatiDate = getInfo.getRelatitime().split("/")[1];
        this.relatiYear = getInfo.getRelatitime().split("/")[2];
        this.relatipri = String.valueOf(getInfo.getRelatipri());
        this.relatidesc = getInfo.getRelatidesc();
    }
    
    public String getRelatiname() {
        return this.relatiname;
    }

    public void setRelatiname(String relatiname) {
        this.relatiname = relatiname;
    }
    
    public String getRelationship() {
        return this.relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }
    
    public String getRelatiMonth() {
        return this.relatiMonth;
    }

    public void setRelatiMonth(String relatiMonth) {
        this.relatiMonth = relatiMonth;
    }
    
    public String getRelatiDate() {
        return this.relatiDate;
    }

    public void setRelatiDate(String relatiDate) {
        this.relatiDate = relatiDate;
    }
    
    public String getRelatiYear() {
        return this.relatiYear;
    }

    public void setRelatiYear(String relatiYear) {
        this.relatiYear = relatiYear;
    }
    
    public String getRelatipri() {
        return this.relatipri;
    }

    public void setRelatipri(String relatipri) {
        this.relatipri = relatipri;
    }

    public MultipartFile getRelatiPic() {
        return this.relatiPic;
    }

    public void setRelatiPic(MultipartFile relatiPic) {
        this.relatiPic = relatiPic;
    }
    
    public String getRelatidesc() {
        return this.relatidesc;
    }

    public void setRelatidesc(String relatidesc) {
        this.relatidesc = relatidesc;
    }
}
