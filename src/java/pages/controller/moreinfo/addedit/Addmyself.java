package pages.controller.moreinfo.addedit;

import hibernate.mapping.Secondaryinfo;

public class Addmyself implements java.io.Serializable {
    
    private String myself;
    private String myselpri;
    private String myseldesc;
    
    public Addmyself() {
    }
    
    public Addmyself(Secondaryinfo getInfo) {
        this.myself = getInfo.getMyself();
        this.myselpri = String.valueOf(getInfo.getMyselpri());
        this.myseldesc = getInfo.getMyseldesc();
    }

    public String getMyself() {
        return this.myself;
    }

    public void setMyself(String myself) {
        this.myself = myself;
    }

    public String getMyselpri() {
        return this.myselpri;
    }

    public void setMyselpri(String myselpri) {
        this.myselpri = myselpri;
    }

    public String getMyseldesc() {
        return this.myseldesc;
    }

    public void setMyseldesc(String myseldesc) {
        this.myseldesc = myseldesc;
    }

}
