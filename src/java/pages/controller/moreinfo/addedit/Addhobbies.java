package pages.controller.moreinfo.addedit;

import hibernate.mapping.Secondaryinfo;
import org.springframework.web.multipart.MultipartFile;

public class Addhobbies implements java.io.Serializable {

    private String hobbies;
    private String hobpri;
    private MultipartFile hobPic;
    private String hobdesc;

    public Addhobbies() {
    }
    
    public Addhobbies(Secondaryinfo getInfo) {
        this.hobbies = getInfo.getHobbies();
        this.hobpri = String.valueOf(getInfo.getHobbpri());
        this.hobdesc = getInfo.getHobbiesdesc();
    }
    
    public String getHobbies() {
        return this.hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }
    
    public String getHobpri() {
        return this.hobpri;
    }

    public void setHobpri(String hobpri) {
        this.hobpri = hobpri;
    }

    public MultipartFile getHobPic() {
        return this.hobPic;
    }

    public void setHobPic(MultipartFile hobPic) {
        this.hobPic = hobPic;
    }
    
    public String getHobdesc() {
        return this.hobdesc;
    }

    public void setHobdesc(String hobdesc) {
        this.hobdesc = hobdesc;
    }

}
