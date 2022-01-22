package pages.controller.moreinfo.addedit;

import hibernate.mapping.Secondaryinfo;
import org.springframework.web.multipart.MultipartFile;

public class Addrelation implements java.io.Serializable {

    private String relatname;
    private String relation;
    private String relatpri;
    private MultipartFile relatPic;
    private String relatdesc;

    public Addrelation() {
    }
    
    public Addrelation(Secondaryinfo getInfo) {
        this.relatname = getInfo.getRelatname();
        this.relation = String.valueOf(getInfo.getRelation());
        this.relatpri = String.valueOf(getInfo.getRelatpri());
        this.relatdesc = getInfo.getRelatdesc();
    }

    public String getRelatname() {
        return this.relatname;
    }

    public void setRelatname(String relatname) {
        this.relatname = relatname;
    }

    public String getRelation() {
        return this.relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getRelatpri() {
        return this.relatpri;
    }

    public void setRelatpri(String relatpri) {
        this.relatpri = relatpri;
    }

    public MultipartFile getRelatPic() {
        return this.relatPic;
    }

    public void setRelatPic(MultipartFile relatPic) {
        this.relatPic = relatPic;
    }

    public String getRelatdesc() {
        return this.relatdesc;
    }

    public void setRelatdesc(String relatdesc) {
        this.relatdesc = relatdesc;
    }

}
