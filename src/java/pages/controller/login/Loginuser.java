package pages.controller.login;

import utils.words.capitalize.Capitalize;

public class Loginuser {

    private long id;
    private String emailphone;
    private String password;
    private boolean exceed;
    private boolean verified;
    private boolean invalidLogin;
    private String lang;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmailphone() {
        return this.emailphone;
    }

    public void setEmailphone(String emailphone) {
        this.emailphone = Capitalize.getCapitalize(emailphone);
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isExceed() {
        return this.exceed;
    }

    public void setExceed(boolean exceed) {
        this.exceed = exceed;
    }

    public boolean isVerified() {
        return this.verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public boolean isInvalidLogin() {
        return this.invalidLogin;
    }

    public void setInvalidLogin(boolean invalidLogin) {
        this.invalidLogin = invalidLogin;
    }

    public String getLang() {
        return this.lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

}
