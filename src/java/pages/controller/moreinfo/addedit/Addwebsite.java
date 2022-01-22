package pages.controller.moreinfo.addedit;

import hibernate.mapping.Secondaryinfo;

public class Addwebsite implements java.io.Serializable {

    private String website;
    private String webpri;
    private String webtyp;
    private String webdesc;

    public Addwebsite() {
    }
    
    public Addwebsite(Secondaryinfo getInfo) {
        this.website = getInfo.getWebsite();
        this.webpri = String.valueOf(getInfo.getWebsitepri());
        this.webtyp = String.valueOf(getInfo.getWebsitetype());
        this.webdesc = getInfo.getWebsitedesc();
    }

    public String getWebsite() {
        return this.website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getWebpri() {
        return this.webpri;
    }

    public void setWebpri(String webpri) {
        this.webpri = webpri;
    }

    public String getWebtyp() {
        return this.webtyp;
    }

    public void setWebtyp(String webtyp) {
        this.webtyp = webtyp;
    }

    public String getWebdesc() {
        return this.webdesc;
    }

    public void setWebdesc(String webdesc) {
        this.webdesc = webdesc;
    }
}
