package pages.controller.moreinfo.addedit;

import hibernate.mapping.Secondaryinfo;
import org.springframework.web.multipart.MultipartFile;

public class Addgruniver implements java.io.Serializable {

    private String gradUniver;
    private String grUnenMonth;
    private String grUnenDate;
    private String grUnenYear;
    private String grUnleMonth;
    private String grUnleDate;
    private String grUnleYear;
    private MultipartFile gradUnPic;
    private String gradUnDesc;
    private String grUnPri;
    private String gradUnPri;

    public Addgruniver() {
    }
    
    public Addgruniver(Secondaryinfo getInfo) {
        this.gradUniver = getInfo.getGraduniver();
        this.grUnenMonth = getInfo.getGraduniverentr().split("/")[0];
        this.grUnenDate = getInfo.getGraduniverentr().split("/")[1];
        this.grUnenYear = getInfo.getGraduniverentr().split("/")[2];
        this.grUnleMonth = getInfo.getGraduniverleave().split("/")[0];
        this.grUnleDate = getInfo.getGraduniverleave().split("/")[1];
        this.grUnleYear = getInfo.getGraduniverleave().split("/")[2];
        this.gradUnDesc = getInfo.getGraduniverdesc();
        this.grUnPri = String.valueOf(getInfo.getGraduniverpri());
        this.gradUnPri = String.valueOf(getInfo.getGraduniverPrivacy());
    }

    public String getGradUniver() {
        return this.gradUniver;
    }

    public void setGradUniver(String gradUniver) {
        this.gradUniver = gradUniver;
    }

    public String getGrUnenMonth() {
        return this.grUnenMonth;
    }

    public void setGrUnenMonth(String grUnenMonth) {
        this.grUnenMonth = grUnenMonth;
    }

    public String getGrUnenDate() {
        return this.grUnenDate;
    }

    public void setGrUnenDate(String grUnenDate) {
        this.grUnenDate = grUnenDate;
    }

    public String getGrUnenYear() {
        return this.grUnenYear;
    }

    public void setGrUnenYear(String grUnenYear) {
        this.grUnenYear = grUnenYear;
    }

    public String getGrUnleMonth() {
        return this.grUnleMonth;
    }

    public void setGrUnleMonth(String grUnleMonth) {
        this.grUnleMonth = grUnleMonth;
    }

    public String getGrUnleDate() {
        return this.grUnleDate;
    }

    public void setGrUnleDate(String grUnleDate) {
        this.grUnleDate = grUnleDate;
    }

    public String getGrUnleYear() {
        return this.grUnleYear;
    }

    public void setGrUnleYear(String grUnleYear) {
        this.grUnleYear = grUnleYear;
    }

    public MultipartFile getGradUnPic() {
        return this.gradUnPic;
    }

    public void setGradUnPic(MultipartFile gradUnPic) {
        this.gradUnPic = gradUnPic;
    }

    public String getGradUnDesc() {
        return this.gradUnDesc;
    }

    public void setGradUnDesc(String gradUnDesc) {
        this.gradUnDesc = gradUnDesc;
    }

    public String getGrUnPri() {
        return this.grUnPri;
    }

    public void setGrUnPri(String grUnPri) {
        this.grUnPri = grUnPri;
    }

    public String getGradUnPri() {
        return this.gradUnPri;
    }

    public void setGradUnPri(String gradUnPri) {
        this.gradUnPri = gradUnPri;
    }

}
