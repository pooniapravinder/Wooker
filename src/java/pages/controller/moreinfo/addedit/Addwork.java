package pages.controller.moreinfo.addedit;

import hibernate.mapping.Secondaryinfo;
import org.springframework.web.multipart.MultipartFile;

public class Addwork implements java.io.Serializable {

    private String worktype;
    private String workplace;
    private String workPri;
    private String woenMonth;
    private String woenDate;
    private String woenYear;
    private String woleMonth;
    private String woleDate;
    private String woleYear;
    private MultipartFile workPic;
    private String workDesc;
    
    public Addwork() {
    }
    
    public Addwork(Secondaryinfo getInfo) {
        this.worktype = getInfo.getWorktype();
        this.workplace = getInfo.getWorkplace();
        this.workPri = String.valueOf(getInfo.getWorkpri());
        this.woenMonth = getInfo.getWorkstart().split("/")[0];
        this.woenDate = getInfo.getWorkstart().split("/")[1];
        this.woenYear = getInfo.getWorkstart().split("/")[2];
        this.woleMonth = getInfo.getWorkleave().split("/")[0];
        this.woleDate = getInfo.getWorkleave().split("/")[1];
        this.woleYear = getInfo.getWorkleave().split("/")[2];
        this.workDesc = getInfo.getWorkdesc();
    }

    public String getWorktype() {
        return this.worktype;
    }

    public void setWorktype(String worktype) {
        this.worktype = worktype;
    }

    public String getWorkplace() {
        return this.workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public String getWorkPri() {
        return this.workPri;
    }

    public void setWorkPri(String workPri) {
        this.workPri = workPri;
    }

    public String getWoenMonth() {
        return this.woenMonth;
    }

    public void setWoenMonth(String woenMonth) {
        this.woenMonth = woenMonth;
    }

    public String getWoenDate() {
        return this.woenDate;
    }

    public void setWoenDate(String woenDate) {
        this.woenDate = woenDate;
    }

    public String getWoenYear() {
        return this.woenYear;
    }

    public void setWoenYear(String woenYear) {
        this.woenYear = woenYear;
    }

    public String getWoleMonth() {
        return this.woleMonth;
    }

    public void setWoleMonth(String woleMonth) {
        this.woleMonth = woleMonth;
    }

    public String getWoleDate() {
        return this.woleDate;
    }

    public void setWoleDate(String woleDate) {
        this.woleDate = woleDate;
    }

    public String getWoleYear() {
        return this.woleYear;
    }

    public void setWoleYear(String woleYear) {
        this.woleYear = woleYear;
    }

    public MultipartFile getWorkPic() {
        return this.workPic;
    }

    public void setWorkPic(MultipartFile workPic) {
        this.workPic = workPic;
    }

    public String getWorkDesc() {
        return this.workDesc;
    }

    public void setWorkDesc(String workDesc) {
        this.workDesc = workDesc;
    }
}
