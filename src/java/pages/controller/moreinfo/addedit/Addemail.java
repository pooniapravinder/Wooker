package pages.controller.moreinfo.addedit;

import hibernate.mapping.Secondaryinfo;

public class Addemail implements java.io.Serializable {

    private String email;
    private String emapri;
    private String ematyp;
    private String emadesc;

    public Addemail() {
    }
    
    public Addemail(Secondaryinfo getInfo) {
        this.email = getInfo.getEmail();
        this.emapri = String.valueOf(getInfo.getEmailpri());
        this.ematyp = String.valueOf(getInfo.getEmailtype());
        this.emadesc = getInfo.getEmaildesc();
    }
    
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmapri() {
        return this.emapri;
    }

    public void setEmapri(String emapri) {
        this.emapri = emapri;
    }

    public String getEmatyp() {
        return this.ematyp;
    }

    public void setEmatyp(String ematyp) {
        this.ematyp = ematyp;
    }

    public String getEmadesc() {
        return this.emadesc;
    }

    public void setEmadesc(String emadesc) {
        this.emadesc = emadesc;
    }
}
