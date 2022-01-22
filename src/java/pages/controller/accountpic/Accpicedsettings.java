package pages.controller.accountpic;

import hibernate.mapping.Showhideeditaccpic;

public class Accpicedsettings {

    private String prInfo;
    private String secInfo;
    private String settings;
    private String security;
    private String accPic;
    private String upNew;
    private String remove;
    private String delete;
    private String download;
    private String picTime;
    private String like;
    private String dislike;
    private String talking;
    private String comment;
    private String share;
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
    private String showHide;

    public Accpicedsettings() {
    }

    public Accpicedsettings(Showhideeditaccpic option) {
        this.prInfo = String.valueOf(option != null ? option.isInfo() : true);
        this.secInfo = String.valueOf(option != null ? option.isMoreinfo() : true);
        this.settings = String.valueOf(option != null ? option.isSetting() : true);
        this.security = String.valueOf(option != null ? option.isSecurity() : true);
        this.accPic = String.valueOf(option != null ? option.isAccpic() : true);
        this.upNew = String.valueOf(option != null ? option.isUploadnew() : true);
        this.remove = String.valueOf(option != null ? option.isRemove() : true);
        this.delete = String.valueOf(option != null ? option.isDeletes() : true);
        this.download = String.valueOf(option != null ? option.isDownload() : true);
        this.picTime = String.valueOf(option != null ? option.isPictime() : true);
        this.like = String.valueOf(option != null ? option.isLikes() : true);
        this.dislike = String.valueOf(option != null ? option.isDislike() : true);
        this.talking = String.valueOf(option != null ? option.isTalking() : true);
        this.comment = String.valueOf(option != null ? option.isComment() : true);
        this.share = String.valueOf(option != null ? option.isShare() : true);
        this.seePic = String.valueOf(option != null ? option.isSee() : true);
        this.downloadPic = String.valueOf(option != null ? option.isDodownload() : true);
        this.liDislikeDo = String.valueOf(option != null ? option.isLidislike() : true);
        this.liDislikeSee = String.valueOf(option != null ? option.isSeelidislike() : true);
        this.talkingDo = String.valueOf(option != null ? option.isDotalking() : true);
        this.talkingSee = String.valueOf(option != null ? option.isSeetalking() : true);
        this.commentDo = String.valueOf(option != null ? option.isDocomment() : true);
        this.commentSee = String.valueOf(option != null ? option.isSeecomment() : true);
        this.shareDo = String.valueOf(option != null ? option.isDoshare() : true);
        this.shareSee = String.valueOf(option != null ? option.isSeeshare() : true);
        this.likePri = String.valueOf(option != null ? option.isPrilike() : true);
        this.dislikePri = String.valueOf(option != null ? option.isPridislike() : true);
        this.talkingPri = String.valueOf(option != null ? option.isPritalking() : true);
        this.commentPri = String.valueOf(option != null ? option.isPricomment() : true);
        this.sharePri = String.valueOf(option != null ? option.isPrishare() : true);
        this.showHide = String.valueOf(option != null ? option.isShowhide() : true);
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

    public String getAccPic() {
        return this.accPic;
    }

    public void setAccPic(String accPic) {
        this.accPic = accPic;
    }

    public String getUpNew() {
        return this.upNew;
    }

    public void setUpNew(String upNew) {
        this.upNew = upNew;
    }

    public String getRemove() {
        return this.remove;
    }

    public void setRemove(String remove) {
        this.remove = remove;
    }

    public String getDelete() {
        return this.delete;
    }

    public void setDelete(String delete) {
        this.delete = delete;
    }

    public String getDownload() {
        return this.download;
    }

    public void setDownload(String download) {
        this.download = download;
    }

    public String getPicTime() {
        return this.picTime;
    }

    public void setPicTime(String picTime) {
        this.picTime = picTime;
    }

    public String getLike() {
        return this.like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public String getDislike() {
        return this.dislike;
    }

    public void setDislike(String dislike) {
        this.dislike = dislike;
    }

    public String getTalking() {
        return this.talking;
    }

    public void setTalking(String talking) {
        this.talking = talking;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getShare() {
        return this.share;
    }

    public void setShare(String share) {
        this.share = share;
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

    public String getShowHide() {
        return this.showHide;
    }

    public void setShowHide(String showHide) {
        this.showHide = showHide;
    }

}
