package pages.controller.moreinfo.addedit;

import hibernate.mapping.Secondaryinfo;
import org.springframework.web.multipart.MultipartFile;

public class Addnewcatg implements java.io.Serializable {

    private String newcatgnam;
    private String newcatgval;
    private String newcatgpri;
    private MultipartFile newcatgpic;
    private String newcatgdesc;

    public Addnewcatg() {
    }
    
    public Addnewcatg(Secondaryinfo getInfo) {
        this.newcatgnam = getInfo.getCategname();
        this.newcatgval = getInfo.getCategvalue();
        this.newcatgpri = String.valueOf(getInfo.getCategpri());
        this.newcatgdesc = getInfo.getCategdesc();
    }

    public String getNewcatgnam() {
        return this.newcatgnam;
    }

    public void setNewcatgnam(String newcatgnam) {
        this.newcatgnam = newcatgnam;
    }

    public String getNewcatgval() {
        return this.newcatgval;
    }

    public void setNewcatgval(String newcatgval) {
        this.newcatgval = newcatgval;
    }

    public String getNewcatgpri() {
        return this.newcatgpri;
    }

    public void setNewcatgpri(String newcatgpri) {
        this.newcatgpri = newcatgpri;
    }

    public MultipartFile getNewcatgpic() {
        return this.newcatgpic;
    }

    public void setNewcatgpic(MultipartFile newcatgpic) {
        this.newcatgpic = newcatgpic;
    }

    public String getNewcatgdesc() {
        return this.newcatgdesc;
    }

    public void setNewcatgdesc(String newcatgdesc) {
        this.newcatgdesc = newcatgdesc;
    }

}
