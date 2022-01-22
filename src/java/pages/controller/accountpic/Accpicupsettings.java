
package pages.controller.accountpic;

import hibernate.mapping.Showhideuplaccpic;

public class Accpicupsettings {
    private String prInfo;
    private String secInfo;
    private String settings;
    private String security;
    private String picPreview;
    private String chPic;
    private String seePic;
    private String downloadPic;
    private String liDislikeDo;
    private String liDislikeSee;
    private String talkingDo;
    private String talkingSee;
    private String commentDo;
    private String commentSee;
    private String shareDo;
    private String shareSee;
    private String likePri;
    private String dislikePri;
    private String talkingPri;
    private String commentPri;
    private String sharePri;
    private String defseePic;
    private String defdownloadPic;
    private String defliDislikeDo;
    private String defliDislikeSee;
    private String deftalkingDo;
    private String deftalkingSee;
    private String defcommentDo;
    private String defcommentSee;
    private String defshareDo;
    private String defshareSee;
    private String deflikePri;
    private String defdislikePri;
    private String deftalkingPri;
    private String defcommentPri;
    private String defsharePri;
    private String prePics;
    private String showHide;

    public Accpicupsettings() {
    }

    public Accpicupsettings(Showhideuplaccpic option) {
        this.prInfo = String.valueOf(option!=null ? option.isInfo() : true);
        this.secInfo = String.valueOf(option!=null ? option.isMoreinfo() : true);
        this.settings = String.valueOf(option!=null ? option.isSetting() : true);
        this.security = String.valueOf(option!=null ? option.isSecurity() : true);
        this.picPreview = String.valueOf(option!=null ? option.isPicpreview() : true);
        this.chPic = String.valueOf(option!=null ? option.isChoosepic() : true);
        this.seePic = String.valueOf(option!=null ? option.isSee() : true);
        this.downloadPic = String.valueOf(option!=null ? option.isDodownload() : true);
        this.liDislikeDo = String.valueOf(option!=null ? option.isLidislike() : true);
        this.liDislikeSee = String.valueOf(option!=null ? option.isSeelidislike() : true);
        this.talkingDo = String.valueOf(option!=null ? option.isDotalking() : true);
        this.talkingSee = String.valueOf(option!=null ? option.isSeetalking() : true);
        this.commentDo = String.valueOf(option!=null ? option.isDocomment() : true);
        this.commentSee = String.valueOf(option!=null ? option.isSeecomment() : true);
        this.shareDo = String.valueOf(option!=null ? option.isDoshare() : true);
        this.shareSee = String.valueOf(option!=null ? option.isSeeshare() : true);
        this.likePri = String.valueOf(option!=null ? option.isPrilike() : true);
        this.dislikePri = String.valueOf(option!=null ? option.isPridislike() : true);
        this.talkingPri = String.valueOf(option!=null ? option.isPritalking() : true);
        this.commentPri = String.valueOf(option!=null ? option.isPricomment() : true);
        this.sharePri = String.valueOf(option!=null ? option.isPrishare() : true);
        this.defseePic = String.valueOf(option!=null ? option.getDefsee() : 3);
        this.defdownloadPic = String.valueOf(option!=null ? option.getDefdodownload() : 2);
        this.defliDislikeDo = String.valueOf(option!=null ? option.getDeflidislike() : 2);
        this.defliDislikeSee = String.valueOf(option!=null ? option.getDefseelidislike() : 2);
        this.deftalkingDo = String.valueOf(option!=null ? option.getDefdotalking() : 2);
        this.deftalkingSee = String.valueOf(option!=null ? option.getDefseetalking() : 2);
        this.defcommentDo = String.valueOf(option!=null ? option.getDefdocomment() : 2);
        this.defcommentSee = String.valueOf(option!=null ? option.getDefseecomment() : 2);
        this.defshareDo = String.valueOf(option!=null ? option.getDefdoshare() : 2);
        this.defshareSee = String.valueOf(option!=null ? option.getDefseeshare() : 2);
        this.deflikePri = String.valueOf(option!=null ? option.isDefprilike() : 2);
        this.defdislikePri = String.valueOf(option!=null ? option.isDefpridislike() : 2);
        this.deftalkingPri = String.valueOf(option!=null ? option.isDefpritalking() : 2);
        this.defcommentPri = String.valueOf(option!=null ? option.isDefpricomment() : 2);
        this.defsharePri = String.valueOf(option!=null ? option.isDefprishare() : 2);
        this.prePics = String.valueOf(option!=null ? option.isPreviouspics() : true);
        this.showHide = String.valueOf(option!=null ? option.isShowhide() : true);
    }

    public String getPrInfo() {
        return this.prInfo;
    }

    public void setPrInfo(String prInfo) {
        this.prInfo = prInfo;
    }

    public String getSecInfo() {
        return this.secInfo;
    }

    public void setSecInfo(String secInfo) {
        this.secInfo = secInfo;
    }
    

    public String getSettings() {
        return this.settings;
    }

    public void setSettings(String settings) {
        this.settings = settings;
    }

    public String getSecurity() {
        return this.security;
    }

    public void setSecurity(String security) {
        this.security = security;
    }

    public String getPicPreview() {
        return this.picPreview;
    }

    public void setPicPreview(String picPreview) {
        this.picPreview = picPreview;
    }

    public String getChPic() {
        return this.chPic;
    }

    public void setChPic(String chPic) {
        this.chPic = chPic;
    }

    public String getSeePic() {
        return this.seePic;
    }

    public void setSeePic(String seePic) {
        this.seePic = seePic;
    }

    public String getDownloadPic() {
        return this.downloadPic;
    }

    public void setDownloadPic(String downloadPic) {
        this.downloadPic = downloadPic;
    }

    public String getLiDislikeDo() {
        return this.liDislikeDo;
    }

    public void setLiDislikeDo(String likeDislikeDo) {
        this.liDislikeDo = likeDislikeDo;
    }

    public String getLiDislikeSee() {
        return this.liDislikeSee;
    }

    public void setLiDislikeSee(String liDislikeSee) {
        this.liDislikeSee = liDislikeSee;
    }

    public String getTalkingDo() {
        return this.talkingDo;
    }

    public void setTalkingDo(String talkingDo) {
        this.talkingDo = talkingDo;
    }

    public String getTalkingSee() {
        return this.talkingSee;
    }

    public void setTalkingSee(String talkingSee) {
        this.talkingSee = talkingSee;
    }

    public String getCommentDo() {
        return this.commentDo;
    }

    public void setCommentDo(String commentDo) {
        this.commentDo = commentDo;
    }

    public String getCommentSee() {
        return this.commentSee;
    }

    public void setCommentSee(String commentSee) {
        this.commentSee = commentSee;
    }

    public String getShareDo() {
        return this.shareDo;
    }

    public void setShareDo(String shareDo) {
        this.shareDo = shareDo;
    }

    public String getShareSee() {
        return this.shareSee;
    }

    public void setShareSee(String shareSee) {
        this.shareSee = shareSee;
    }

    public String getLikePri() {
        return this.likePri;
    }

    public void setLikePri(String likePri) {
        this.likePri = likePri;
    }

    public String getDislikePri() {
        return this.dislikePri;
    }

    public void setDislikePri(String dislikePri) {
        this.dislikePri = dislikePri;
    }

    public String getTalkingPri() {
        return this.talkingPri;
    }

    public void setTalkingPri(String talkingPri) {
        this.talkingPri = talkingPri;
    }

    public String getCommentPri() {
        return this.commentPri;
    }

    public void setCommentPri(String commentPri) {
        this.commentPri = commentPri;
    }

    public String getSharePri() {
        return this.sharePri;
    }

    public void setSharePri(String sharePri) {
        this.sharePri = sharePri;
    }

    public String getDefseePic() {
        return this.defseePic;
    }

    public void setDefseePic(String defseePic) {
        this.defseePic = defseePic;
    }

    public String getDefdownloadPic() {
        return this.defdownloadPic;
    }

    public void setDefdownloadPic(String defdownloadPic) {
        this.defdownloadPic = defdownloadPic;
    }

    public String getDefliDislikeDo() {
        return this.defliDislikeDo;
    }

    public void setDefliDislikeDo(String deflikeDislikeDo) {
        this.defliDislikeDo = deflikeDislikeDo;
    }

    public String getDefliDislikeSee() {
        return this.defliDislikeSee;
    }

    public void setDefliDislikeSee(String defliDislikeSee) {
        this.defliDislikeSee = defliDislikeSee;
    }

    public String getDeftalkingDo() {
        return this.deftalkingDo;
    }

    public void setDeftalkingDo(String deftalkingDo) {
        this.deftalkingDo = deftalkingDo;
    }

    public String getDeftalkingSee() {
        return this.deftalkingSee;
    }

    public void setDeftalkingSee(String deftalkingSee) {
        this.deftalkingSee = deftalkingSee;
    }

    public String getDefcommentDo() {
        return this.defcommentDo;
    }

    public void setDefcommentDo(String defcommentDo) {
        this.defcommentDo = defcommentDo;
    }

    public String getDefcommentSee() {
        return this.defcommentSee;
    }

    public void setDefcommentSee(String defcommentSee) {
        this.defcommentSee = defcommentSee;
    }

    public String getDefshareDo() {
        return this.defshareDo;
    }

    public void setDefshareDo(String defshareDo) {
        this.defshareDo = defshareDo;
    }

    public String getDefshareSee() {
        return this.defshareSee;
    }

    public void setDefshareSee(String defshareSee) {
        this.defshareSee = defshareSee;
    }

    public String getDeflikePri() {
        return this.deflikePri;
    }

    public void setDeflikePri(String deflikePri) {
        this.deflikePri = deflikePri;
    }

    public String getDefdislikePri() {
        return this.defdislikePri;
    }

    public void setDefdislikePri(String defdislikePri) {
        this.defdislikePri = defdislikePri;
    }

    public String getDeftalkingPri() {
        return this.deftalkingPri;
    }

    public void setDeftalkingPri(String deftalkingPri) {
        this.deftalkingPri = deftalkingPri;
    }

    public String getDefcommentPri() {
        return this.defcommentPri;
    }

    public void setDefcommentPri(String defcommentPri) {
        this.defcommentPri = defcommentPri;
    }

    public String getDefsharePri() {
        return this.defsharePri;
    }

    public void setDefsharePri(String defsharePri) {
        this.defsharePri = defsharePri;
    }

    public String getPrePics() {
        return this.prePics;
    }

    public void setPrePics(String prePics) {
        this.prePics = prePics;
    }

    public String getShowHide() {
        return this.showHide;
    }

    public void setShowHide(String showHide) {
        this.showHide = showHide;
    }
}
