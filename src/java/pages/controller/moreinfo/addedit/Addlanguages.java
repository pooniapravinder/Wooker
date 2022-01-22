package pages.controller.moreinfo.addedit;

import hibernate.mapping.Secondaryinfo;

public class Addlanguages implements java.io.Serializable {

    private String languages;
    private String langpri;
    private String langdesc;

    public Addlanguages() {
    }
    
    public Addlanguages(Secondaryinfo getInfo) {
        this.languages = getInfo.getLanguages();
        this.langpri = String.valueOf(getInfo.getLangpri());
        this.langdesc = getInfo.getLangdesc();
    }

    public String getLanguages() {
        return this.languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getLangpri() {
        return this.langpri;
    }

    public void setLangpri(String langpri) {
        this.langpri = langpri;
    }

    public String getLangdesc() {
        return this.langdesc;
    }

    public void setLangdesc(String langdesc) {
        this.langdesc = langdesc;
    }

}
