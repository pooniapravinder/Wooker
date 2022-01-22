package pages.controller.moreinfo.addedit;

import hibernate.mapping.Secondaryinfo;
import org.springframework.web.multipart.MultipartFile;

public class Addpogrcoll implements java.io.Serializable {
    
    private String pogrColl;
    private String PogrCoenMonth;
    private String PogrCoenDate;
    private String PogrCoenYear;
    private String PogrColeMonth;
    private String PogrColeDate;
    private String PogrColeYear;
    private MultipartFile pogrCoPic;
    private String pogrCoDesc;
    private String pogrCollPri;
    private String pogrCoPri;
    
    public Addpogrcoll() {
    }
    
    public Addpogrcoll(Secondaryinfo getInfo) {
        this.pogrColl = getInfo.getPogradcollege();
        this.PogrCoenMonth = getInfo.getPogradcollentr().split("/")[0];
        this.PogrCoenDate = getInfo.getPogradcollentr().split("/")[1];
        this.PogrCoenYear = getInfo.getPogradcollentr().split("/")[2];
        this.PogrColeMonth = getInfo.getPogradcollleave().split("/")[0];
        this.PogrColeDate = getInfo.getPogradcollleave().split("/")[1];
        this.PogrColeYear = getInfo.getPogradcollleave().split("/")[2];
        this.pogrCoDesc = getInfo.getPogradcolldesc();
        this.pogrCollPri = String.valueOf(getInfo.getPogradcollpri());
        this.pogrCoPri = String.valueOf(getInfo.getPogradcollPrivacy());
    }

    public String getPogrColl() {
        return this.pogrColl;
    }

    public void setPogrColl(String pogrColl) {
        this.pogrColl = pogrColl;
    }

    public String getPogrCollPri() {
        return this.pogrCollPri;
    }

    public void setPogrCollPri(String pogrCollPri) {
        this.pogrCollPri = pogrCollPri;
    }

    public String getPogrCoenMonth() {
        return this.PogrCoenMonth;
    }

    public void setPogrCoenMonth(String PogrCoenMonth) {
        this.PogrCoenMonth = PogrCoenMonth;
    }

    public String getPogrCoenDate() {
        return this.PogrCoenDate;
    }

    public void setPogrCoenDate(String PogrCoenDate) {
        this.PogrCoenDate = PogrCoenDate;
    }

    public String getPogrCoenYear() {
        return this.PogrCoenYear;
    }

    public void setPogrCoenYear(String PogrCoenYear) {
        this.PogrCoenYear = PogrCoenYear;
    }

    public String getPogrColeMonth() {
        return this.PogrColeMonth;
    }

    public void setPogrColeMonth(String PogrColeMonth) {
        this.PogrColeMonth = PogrColeMonth;
    }

    public String getPogrColeDate() {
        return this.PogrColeDate;
    }

    public void setPogrColeDate(String PogrColeDate) {
        this.PogrColeDate = PogrColeDate;
    }

    public String getPogrColeYear() {
        return this.PogrColeYear;
    }

    public void setPogrColeYear(String PogrColeYear) {
        this.PogrColeYear = PogrColeYear;
    }

    public MultipartFile getPogrCoPic() {
        return this.pogrCoPic;
    }

    public void setPogrCoPic(MultipartFile pogrCoPic) {
        this.pogrCoPic = pogrCoPic;
    }

    public String getPogrCoDesc() {
        return this.pogrCoDesc;
    }

    public void setPogrCoDesc(String pogrCoDesc) {
        this.pogrCoDesc = pogrCoDesc;
    }

    public String getPogrCoPri() {
        return this.pogrCoPri;
    }

    public void setPogrCoPri(String pogrCoPri) {
        this.pogrCoPri = pogrCoPri;
    }

}
