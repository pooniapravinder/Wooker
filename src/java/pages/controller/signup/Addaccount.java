package pages.controller.signup;

import utils.words.capitalize.Capitalize;

public class Addaccount {

    private String firstName;
    private String lastName;
    private String gender;
    private String month;
    private String date;
    private String year;
    private String country;
    private String emailidPhone;
    private String password;
    private String confPassword;
    private String captchaCode;
    private String TermsAndService;
    private boolean existUser;
    private String lang;

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = Capitalize.getCapitalize(firstName);
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = Capitalize.getCapitalize(lastName);
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMonth() {
        return this.month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getYear() {
        return this.year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmailidPhone() {
        return this.emailidPhone;
    }

    public void setEmailidPhone(String emailidPhone) {
        this.emailidPhone = Capitalize.getCapitalize(emailidPhone);
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfPassword() {
        return this.confPassword;
    }

    public void setConfPassword(String confPassword) {
        this.confPassword = confPassword;
    }

    public String getCaptchaCode() {
        return this.captchaCode;
    }

    public void setCaptchaCode(String captchaCode) {
        this.captchaCode = captchaCode;
    }

    public String getTermsAndService() {
        return this.TermsAndService;
    }

    public void setTermsAndService(String TermsAndService) {
        this.TermsAndService = TermsAndService;
    }

    public boolean isExistUser() {
        return this.existUser;
    }

    public void setExistUser(boolean existUser) {
        this.existUser = existUser;
    }

    public String getLang() {
        return this.lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

}
