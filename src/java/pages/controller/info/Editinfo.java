package pages.controller.info;

import hibernate.mapping.Primaryinfo;
import java.util.Calendar;

public class Editinfo implements java.io.Serializable {

    private long timestampVal;
    private String combination;
    private String firstName;
    private String lastName;
    private String nickName;
    private String nickPrivacy;
    private String gender;
    private String genPrivacy;
    private String birthMonth;
    private String birthDate;
    private String birthYear;
    private int currentYear;
    private String monthPrivacy;
    private String datePrivacy;
    private String yearPrivacy;
    private String agePrivacy;
    private String accountType;
    private String accPrivacy;
    private long exceedTime;
    private boolean exceedUpdate;

    public Editinfo() {
    }

    public Editinfo(Primaryinfo get_values) {
        this.timestampVal = get_values.getTimestampVal();
        this.combination = String.valueOf(get_values.getNicknameCombination());
        this.firstName = String.valueOf(get_values.getFirstName());
        this.lastName = String.valueOf(get_values.getLastName());
        this.nickName = String.valueOf(get_values.getNickName());
        this.nickPrivacy = String.valueOf(get_values.getNicknamePrivacy());
        this.gender = String.valueOf(get_values.getGender());
        this.genPrivacy = String.valueOf(get_values.getGenderPrivacy());
        this.birthMonth = get_values.getBirthDay().split("/")[0];
        this.birthDate = get_values.getBirthDay().split("/")[1];
        this.birthYear = get_values.getBirthDay().split("/")[2];
        this.currentYear = Calendar.getInstance().get(Calendar.YEAR);
        this.monthPrivacy = String.valueOf(get_values.getMonthPrivacy());
        this.datePrivacy = String.valueOf(get_values.getDatePrivacy());
        this.yearPrivacy = String.valueOf(get_values.getDatePrivacy());
        this.agePrivacy = String.valueOf(get_values.getAgePrivacy());
        this.accountType = String.valueOf(get_values.getEmailidPhone());
        this.accPrivacy = String.valueOf(get_values.getAccountPrivacy());
    }

    public long getTimestampVal() {
        return this.timestampVal;
    }

    public void setTimestampVal(long timestampVal) {
        this.timestampVal = timestampVal;
    }

    public String getCombination() {
        return this.combination;
    }

    public void setCombination(String combination) {
        this.combination = combination;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getNickName() {
        return this.nickName;
    }

    public String getNickPrivacy() {
        return this.nickPrivacy;
    }

    public void setNickPrivacy(String nickPrivacy) {
        this.nickPrivacy = nickPrivacy;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return this.gender;
    }

    public String getGenPrivacy() {
        return this.genPrivacy;
    }

    public void setGenPrivacy(String genPrivacy) {
        this.genPrivacy = genPrivacy;
    }

    public String getBirthMonth() {
        return this.birthMonth;
    }

    public void setBirthMonth(String birthMonth) {
        this.birthMonth = birthMonth;
    }

    public String getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthYear() {
        return this.birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public int getCurrentYear() {
        return this.currentYear;
    }

    public void setCurrentYear(int currentYear) {
        this.currentYear = currentYear;
    }

    public String getMonthPrivacy() {
        return this.monthPrivacy;
    }

    public void setMonthPrivacy(String monthPrivacy) {
        this.monthPrivacy = monthPrivacy;
    }

    public String getDatePrivacy() {
        return this.datePrivacy;
    }

    public void setDatePrivacy(String datePrivacy) {
        this.datePrivacy = datePrivacy;
    }

    public String getYearPrivacy() {
        return this.yearPrivacy;
    }

    public void setYearPrivacy(String yearPrivacy) {
        this.yearPrivacy = yearPrivacy;
    }

    public String getAgePrivacy() {
        return this.agePrivacy;
    }

    public void setAgePrivacy(String agePrivacy) {
        this.agePrivacy = agePrivacy;
    }

    public String getAccountType() {
        return this.accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccPrivacy() {
        return this.accPrivacy;
    }

    public void setAccPrivacy(String accPrivacy) {
        this.accPrivacy = accPrivacy;
    }

    public long getExceedTime() {
        return this.exceedTime;
    }

    public void setExceedTime(long exceedTime) {
        this.exceedTime = exceedTime;
    }

    public boolean isExceedUpdate() {
        return this.exceedUpdate;
    }

    public void setExceedUpdate(boolean exceedUpdate) {
        this.exceedUpdate = exceedUpdate;
    }

}
