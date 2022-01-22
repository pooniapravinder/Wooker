package pages.controller.moreinfo.addedit;

import hibernate.mapping.Secondaryinfo;
import org.springframework.web.multipart.MultipartFile;

public class Addlocation implements java.io.Serializable {
    
    private String currentCity;
    private String hometown;
    private String locPri;
    private MultipartFile locPic;
    private String locDesc;
    
    public Addlocation() {
    }
    
    public Addlocation(Secondaryinfo getInfo) {
        this.currentCity = getInfo.getCurrcity();
        this.hometown = getInfo.getHometown();
        this.locPri = String.valueOf(getInfo.getLocationpri());
        this.locDesc = getInfo.getLocationdesc();
    }

    public String getCurrentCity() {
        return this.currentCity;
    }

    public void setCurrentCity(String currentCity) {
        this.currentCity = currentCity;
    }

    public String getHometown() {
        return this.hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getLocPri() {
        return this.locPri;
    }

    public void setLocPri(String locPri) {
        this.locPri = locPri;
    }

    public MultipartFile getLocPic() {
        return this.locPic;
    }

    public void setLocPic(MultipartFile locPic) {
        this.locPic = locPic;
    }

    public String getLocDesc() {
        return this.locDesc;
    }

    public void setLocDesc(String locDesc) {
        this.locDesc = locDesc;
    }

}
