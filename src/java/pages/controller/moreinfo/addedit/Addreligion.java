package pages.controller.moreinfo.addedit;

import hibernate.mapping.Secondaryinfo;

public class Addreligion implements java.io.Serializable {

    private String religion;
    private String religpri;
    private String religdesc;

    public Addreligion() {
    }
    
    public Addreligion(Secondaryinfo getInfo) {
        this.religion = getInfo.getReligion();
        this.religpri = String.valueOf(getInfo.getReligpri());
        this.religdesc = getInfo.getReligdesc();
    }

    public String getReligion() {
        return this.religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getReligpri() {
        return this.religpri;
    }

    public void setReligpri(String religpri) {
        this.religpri = religpri;
    }

    public String getReligdesc() {
        return this.religdesc;
    }

    public void setReligdesc(String religdesc) {
        this.religdesc = religdesc;
    }

}
