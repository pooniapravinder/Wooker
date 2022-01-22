package pages.controller.moreinfo.addedit;

import hibernate.mapping.Secondaryinfo;
import org.springframework.web.multipart.MultipartFile;

public class Addmoved implements java.io.Serializable {
    
    private String movedfrom;
    private String movedto;
    private String movedPri;
    private String movedMonth;
    private String movedDate;
    private String movedYear;
    private MultipartFile movedPic;
    private String movedDesc;
    
    public Addmoved() {
    }
    
    public Addmoved(Secondaryinfo getInfo) {
        this.movedfrom = getInfo.getMovedfrom();
        this.movedto = getInfo.getMovedto();
        this.movedPri = String.valueOf(getInfo.getMovedpri());
        this.movedMonth = getInfo.getMovedtime().split("/")[0];
        this.movedDate = getInfo.getMovedtime().split("/")[1];
        this.movedYear = getInfo.getMovedtime().split("/")[2];
        this.movedDesc = getInfo.getMoveddesc();
    }

    public String getMovedfrom() {
        return this.movedfrom;
    }

    public void setMovedfrom(String movedfrom) {
        this.movedfrom = movedfrom;
    }

    public String getMovedto() {
        return this.movedto;
    }

    public void setMovedto(String movedto) {
        this.movedto = movedto;
    }

    public String getMovedMonth() {
        return this.movedMonth;
    }

    public void setMovedMonth(String movedMonth) {
        this.movedMonth = movedMonth;
    }

    public String getMovedDate() {
        return this.movedDate;
    }

    public void setMovedDate(String movedDate) {
        this.movedDate = movedDate;
    }

    public String getMovedYear() {
        return this.movedYear;
    }

    public void setMovedYear(String movedYear) {
        this.movedYear = movedYear;
    }

    public String getMovedPri() {
        return this.movedPri;
    }

    public void setMovedPri(String movedPri) {
        this.movedPri = movedPri;
    }

    public MultipartFile getMovedPic() {
        return this.movedPic;
    }

    public void setMovedPic(MultipartFile movedPic) {
        this.movedPic = movedPic;
    }

    public String getMovedDesc() {
        return this.movedDesc;
    }

    public void setMovedDesc(String movedDesc) {
        this.movedDesc = movedDesc;
    }

}
