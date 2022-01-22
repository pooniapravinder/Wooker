package pages.controller.moreinfo.addedit;

import hibernate.mapping.Secondaryinfo;
import org.springframework.web.multipart.MultipartFile;

public class Addgrcollege implements java.io.Serializable {

    private String gradColl;
    private String grCoenMonth;
    private String grCoenDate;
    private String grCoenYear;
    private String grColeMonth;
    private String grColeDate;
    private String grColeYear;
    private MultipartFile grCoPic;
    private String grCoDesc;
    private String grCollPri;
    private String grCoPri;

    public Addgrcollege() {
    }
    
    public Addgrcollege(Secondaryinfo getInfo) {
        this.gradColl = getInfo.getGradcollege();
        this.grCoenMonth = getInfo.getGradcollentr().split("/")[0];
        this.grCoenDate = getInfo.getGradcollentr().split("/")[1];
        this.grCoenYear = getInfo.getGradcollentr().split("/")[2];
        this.grColeMonth = getInfo.getGradcollleave().split("/")[0];
        this.grColeDate = getInfo.getGradcollleave().split("/")[1];
        this.grColeYear = getInfo.getGradcollleave().split("/")[2];
        this.grCoDesc = getInfo.getGradcolldesc();
        this.grCollPri = String.valueOf(getInfo.getGradcollpri());
        this.grCoPri = String.valueOf(getInfo.getGradcollPrivacy());
    }

    public String getGradColl() {
        return this.gradColl;
    }

    public void setGradColl(String gradColl) {
        this.gradColl = gradColl;
    }

    public String getGrCoenMonth() {
        return this.grCoenMonth;
    }

    public void setGrCoenMonth(String grCoenMonth) {
        this.grCoenMonth = grCoenMonth;
    }

    public String getGrCoenDate() {
        return this.grCoenDate;
    }

    public void setGrCoenDate(String grCoenDate) {
        this.grCoenDate = grCoenDate;
    }

    public String getGrCoenYear() {
        return this.grCoenYear;
    }

    public void setGrCoenYear(String grCoenYear) {
        this.grCoenYear = grCoenYear;
    }

    public String getGrColeMonth() {
        return this.grColeMonth;
    }

    public void setGrColeMonth(String grColeMonth) {
        this.grColeMonth = grColeMonth;
    }

    public String getGrColeDate() {
        return this.grColeDate;
    }

    public void setGrColeDate(String grColeDate) {
        this.grColeDate = grColeDate;
    }

    public String getGrColeYear() {
        return this.grColeYear;
    }

    public void setGrColeYear(String grColeYear) {
        this.grColeYear = grColeYear;
    }

    public MultipartFile getGrCoPic() {
        return this.grCoPic;
    }

    public void setGrCoPic(MultipartFile grCoPic) {
        this.grCoPic = grCoPic;
    }

    public String getGrCoDesc() {
        return this.grCoDesc;
    }

    public void setGrCoDesc(String grCoDesc) {
        this.grCoDesc = grCoDesc;
    }

    public String getGrCollPri() {
        return this.grCollPri;
    }

    public void setGrCollPri(String grCollPri) {
        this.grCollPri = grCollPri;
    }

    public String getGrCoPri() {
        return this.grCoPri;
    }

    public void setGrCoPri(String grCoPri) {
        this.grCoPri = grCoPri;
    }
}
