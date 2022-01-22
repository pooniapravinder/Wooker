package pages.controller.moreinfo.addedit;

import hibernate.mapping.Secondaryinfo;
import org.springframework.web.multipart.MultipartFile;

public class Addpogruniver implements java.io.Serializable {
    
    private String pogrUniver;
    private String PogrUnenMonth;
    private String PogrUnenDate;
    private String PogrUnenYear;
    private String PogrUnleMonth;
    private String PogrUnleDate;
    private String PogrUnleYear;
    private MultipartFile pogrUnPic;
    private String pogrUnDesc;
    private String pogrUnPri;
    private String pogradUnPri;
    
    public Addpogruniver() {
    }
    
    public Addpogruniver(Secondaryinfo getInfo) {
        this.pogrUniver = getInfo.getPograduniver();
        this.PogrUnenMonth = getInfo.getPograduniverentr().split("/")[0];
        this.PogrUnenDate = getInfo.getPograduniverentr().split("/")[1];
        this.PogrUnenYear = getInfo.getPograduniverentr().split("/")[2];
        this.PogrUnleMonth = getInfo.getPograduniverleave().split("/")[0];
        this.PogrUnleDate = getInfo.getPograduniverleave().split("/")[1];
        this.PogrUnleYear = getInfo.getPograduniverleave().split("/")[2];
        this.pogrUnDesc = getInfo.getPograduniverdesc();
        this.pogrUnPri = String.valueOf(getInfo.getPograduniverpri());
        this.pogradUnPri = String.valueOf(getInfo.getPograduniverPrivacy());
    }

    public String getPogrUniver() {
        return this.pogrUniver;
    }

    public void setPogrUniver(String pogrUniver) {
        this.pogrUniver = pogrUniver;
    }

    public String getPogrUnPri() {
        return this.pogrUnPri;
    }

    public void setPogrUnPri(String pogrUnPri) {
        this.pogrUnPri = pogrUnPri;
    }

    public String getPogrUnenMonth() {
        return this.PogrUnenMonth;
    }

    public void setPogrUnenMonth(String PogrUnenMonth) {
        this.PogrUnenMonth = PogrUnenMonth;
    }

    public String getPogrUnenDate() {
        return this.PogrUnenDate;
    }

    public void setPogrUnenDate(String PogrUnenDate) {
        this.PogrUnenDate = PogrUnenDate;
    }

    public String getPogrUnenYear() {
        return this.PogrUnenYear;
    }

    public void setPogrUnenYear(String PogrUnenYear) {
        this.PogrUnenYear = PogrUnenYear;
    }

    public String getPogrUnleMonth() {
        return this.PogrUnleMonth;
    }

    public void setPogrUnleMonth(String PogrUnleMonth) {
        this.PogrUnleMonth = PogrUnleMonth;
    }

    public String getPogrUnleDate() {
        return this.PogrUnleDate;
    }

    public void setPogrUnleDate(String PogrUnleDate) {
        this.PogrUnleDate = PogrUnleDate;
    }

    public String getPogrUnleYear() {
        return this.PogrUnleYear;
    }

    public void setPogrUnleYear(String PogrUnleYear) {
        this.PogrUnleYear = PogrUnleYear;
    }

    public MultipartFile getPogrUnPic() {
        return this.pogrUnPic;
    }

    public void setPogrUnPic(MultipartFile pogrUnPic) {
        this.pogrUnPic = pogrUnPic;
    }

    public String getPogrUnDesc() {
        return this.pogrUnDesc;
    }

    public void setPogrUnDesc(String pogrUnDesc) {
        this.pogrUnDesc = pogrUnDesc;
    }
    
    public String getPogradUnPri() {
        return this.pogradUnPri;
    }

    public void setPogradUnPri(String pogradUnPri) {
        this.pogradUnPri = pogradUnPri;
    }

}
