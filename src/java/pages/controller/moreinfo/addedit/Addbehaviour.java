package pages.controller.moreinfo.addedit;

import hibernate.mapping.Secondaryinfo;

public class Addbehaviour implements java.io.Serializable {
    
    private String behaviour;
    private String behavpri;
    private String behavdesc;
    
    public Addbehaviour() {
    }
    
    public Addbehaviour(Secondaryinfo getInfo) {
        this.behaviour = getInfo.getBehaviour();
        this.behavpri = String.valueOf(getInfo.getBehavpri());
        this.behavdesc = getInfo.getBehavdesc();
    }

    public String getBehaviour() {
        return this.behaviour;
    }

    public void setBehaviour(String behaviour) {
        this.behaviour = behaviour;
    }

    public String getBehavpri() {
        return this.behavpri;
    }

    public void setBehavpri(String behavpri) {
        this.behavpri = behavpri;
    }

    public String getBehavdesc() {
        return this.behavdesc;
    }

    public void setBehavdesc(String behavdesc) {
        this.behavdesc = behavdesc;
    }

}
