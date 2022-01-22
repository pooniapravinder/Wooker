
package pages.controller.moreinfo;

import org.springframework.web.multipart.MultipartFile;

public class Editmoreinfo implements java.io.Serializable {
    
    private String hobbDesc;
    private String relatiDesc;
    private String relationna;
    private MultipartFile relatPic;
    private String relatDesc;
    private String languages;
    private String langDesc;
    private String religion;
    private String religDesc;
    private String behaviour;
    private String aboutme;
    private String newcategName;
    private String newcategValue;
    private MultipartFile newcategPic;
    private String newcategDesc;
    
    public Editmoreinfo() {
    }

    public String getHobbDesc() {
        return this.hobbDesc;
    }

    public void setHobbDesc(String hobbDesc) {
        this.hobbDesc = hobbDesc;
    }

    public String getRelatiDesc() {
        return this.relatiDesc;
    }

    public void setRelatiDesc(String relatiDesc) {
        this.relatiDesc = relatiDesc;
    }

    public String getRelationna() {
        return this.relationna;
    }

    public void setRelationna(String relationna) {
        this.relationna = relationna;
    }

    public MultipartFile getRelatPic() {
        return this.relatPic;
    }

    public void setRelatPic(MultipartFile relatPic) {
        this.relatPic = relatPic;
    }

    public String getRelatDesc() {
        return this.relatDesc;
    }

    public void setRelatDesc(String relatDesc) {
        this.relatDesc = relatDesc;
    }

    public String getLanguages() {
        return this.languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getLangDesc() {
        return this.langDesc;
    }

    public void setLangDesc(String langDesc) {
        this.langDesc = langDesc;
    }

    public String getReligion() {
        return this.religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getReligDesc() {
        return this.religDesc;
    }

    public void setReligDesc(String religDesc) {
        this.religDesc = religDesc;
    }

    public String getBehaviour() {
        return this.behaviour;
    }

    public void setBehaviour(String behaviour) {
        this.behaviour = behaviour;
    }

    public String getAboutme() {
        return this.aboutme;
    }

    public void setAboutme(String aboutme) {
        this.aboutme = aboutme;
    }

    public String getNewcategName() {
        return this.newcategName;
    }

    public void setNewcategName(String newcategName) {
        this.newcategName = newcategName;
    }

    public String getNewcategValue() {
        return this.newcategValue;
    }

    public void setNewcategValue(String newcategValue) {
        this.newcategValue = newcategValue;
    }

    public MultipartFile getNewcategPic() {
        return this.newcategPic;
    }

    public void setNewcategPic(MultipartFile newcategPic) {
        this.newcategPic = newcategPic;
    }

    public String getNewcategDesc() {
        return this.newcategDesc;
    }

    public void setNewcategDesc(String newcategDesc) {
        this.newcategDesc = newcategDesc;
    }

}
