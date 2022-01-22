package pages.controller.moreinfo.addedit;

import hibernate.mapping.Secondaryinfo;

public class Addmobile implements java.io.Serializable {

    private String mobile;
    private String mobpri;
    private String mobtyp;
    private String mobdesc;

    public Addmobile() {
    }
    
    public Addmobile(Secondaryinfo getInfo) {
        this.mobile = getInfo.getMobilenumber();
        this.mobpri = String.valueOf(getInfo.getMobilepri());
        this.mobtyp = String.valueOf(getInfo.getMobiletype());
        this.mobdesc = getInfo.getMobiledesc();
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMobpri() {
        return this.mobpri;
    }

    public void setMobpri(String mobpri) {
        this.mobpri = mobpri;
    }

    public String getMobtyp() {
        return this.mobtyp;
    }

    public void setMobtyp(String mobtyp) {
        this.mobtyp = mobtyp;
    }

    public String getMobdesc() {
        return this.mobdesc;
    }

    public void setMobdesc(String mobdesc) {
        this.mobdesc = mobdesc;
    }
}
