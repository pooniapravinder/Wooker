package pages.controller.accountverify;

import utils.words.capitalize.Capitalize;

public class Verifyaccount {

    private String verifycode;
    private String emailphone;
    private String email;
    private String phone;
    private String rnlm;
    private String errors;
    private String success;
    private String sendCode;
    private String callCode;
    private String verify;
    private String change;
    private String logoutId;

    public String getVerifycode() {
        return this.verifycode;
    }

    public void setVerifycode(String verifycode) {
        this.verifycode = verifycode;
    }

    public String getEmailphone() {
        return this.emailphone;
    }

    public void setEmailphone(String emailphone) {
        this.emailphone = Capitalize.getCapitalize(emailphone);
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRnlm() {
        return this.rnlm;
    }

    public void setRnlm(String rnlm) {
        this.rnlm = rnlm;
    }

    public String getErrors() {
        return this.errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }

    public String getSuccess() {
        return this.success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getVerify() {
        return this.verify;
    }

    public void setVerify(String verify) {
        this.verify = verify;
    }

    public String getSendCode() {
        return this.sendCode;
    }

    public void setSendCode(String sendCode) {
        this.sendCode = sendCode;
    }

    public String getCallCode() {
        return this.callCode;
    }

    public void setCallCode(String callCode) {
        this.callCode = callCode;
    }

    public String getChange() {
        return this.change;
    }

    public void setChange(String change) {
        this.change = change;
    }

    public String getLogoutId() {
        return this.logoutId;
    }

    public void setLogoutId(String logoutId) {
        this.logoutId = logoutId;
    }

}
