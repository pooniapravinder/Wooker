package pages.controller.accountpic;

import hibernate.mapping.Accountpics;
import hibernate.mapping.Showhideuplaccpic;
import org.springframework.web.multipart.MultipartFile;

public class Accpicoper implements java.io.Serializable {

    private MultipartFile img;
    private long timestampVal;
    private String privacy;
    private String download;
    private String doLiDis;
    private String seeLiDis;
    private String doTalking;
    private String seeTalking;
    private String doComment;
    private String seeComment;
    private String doShare;
    private String seeShare;
    private String like;
    private String hlike;
    private String dislike;
    private String hdislike;
    private String talking;
    private String htalking;
    private String comment;
    private String hcomment;
    private String share;
    private String hshare;

    public Accpicoper() {

    }
    
    public Accpicoper(Accountpics get_values) {
        this.timestampVal = get_values.getTimeStamp();
        this.privacy = String.valueOf(get_values.getPrivacy());
        this.download = String.valueOf(get_values.getDownload());
        this.doLiDis = String.valueOf(get_values.getDoLidislike());
        this.seeLiDis = String.valueOf(get_values.getSeeLidislike());
        this.doTalking = String.valueOf(get_values.getDoTalking());
        this.seeTalking = String.valueOf(get_values.getSeeTalking());
        this.doComment = String.valueOf(get_values.getDoComment());
        this.seeComment = String.valueOf(get_values.getSeeComment());
        this.doShare = String.valueOf(get_values.getDoShare());
        this.seeShare = String.valueOf(get_values.getSeeShare());
        this.like = String.valueOf(get_values.isLikes());
        this.dislike = String.valueOf(get_values.isDislikes());
        this.talking = String.valueOf(get_values.isTalkings());
        this.comment = String.valueOf(get_values.isComments());
        this.share = String.valueOf(get_values.isShares());
    }
    
    public Accpicoper(Showhideuplaccpic get_values) {
        this.privacy = String.valueOf(get_values!=null ? get_values.getDefsee() : 3);
        this.download = String.valueOf(get_values!=null ? get_values.getDefdodownload() : 2);
        this.doLiDis = String.valueOf(get_values!=null ? get_values.getDeflidislike() : 2);
        this.seeLiDis = String.valueOf(get_values!=null ? get_values.getDefseelidislike() : 2);
        this.doTalking = String.valueOf(get_values!=null ? get_values.getDefdotalking() : 2);
        this.seeTalking = String.valueOf(get_values!=null ? get_values.getDefseetalking() : 2);
        this.doComment = String.valueOf(get_values!=null ? get_values.getDefdocomment() : 2);
        this.seeComment = String.valueOf(get_values!=null ? get_values.getDefseecomment() : 2);
        this.doShare = String.valueOf(get_values!=null ? get_values.getDefdoshare() : 2);
        this.seeShare = String.valueOf(get_values!=null ? get_values.getDefseeshare() : 2);
        this.like = String.valueOf(get_values!=null ? get_values.isDefprilike() : 2);
        this.dislike = String.valueOf(get_values!=null ? get_values.isDefpridislike() : 2);
        this.talking = String.valueOf(get_values!=null ? get_values.isDefpritalking() : 2);
        this.comment = String.valueOf(get_values!=null ? get_values.isDefpricomment() : 2);
        this.share = String.valueOf(get_values!=null ? get_values.isDefprishare() : 2);
    }

    public MultipartFile getImg() {
        return this.img;
    }

    public void setImg(MultipartFile img) {
        this.img = img;
    }
    
    public long getTimestampVal() {
        return this.timestampVal;
    }

    public void setTimestampVal(long timestampVal) {
        this.timestampVal = timestampVal;
    }

    public String getPrivacy() {
        return this.privacy;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    public String getDownload() {
        return this.download;
    }

    public void setDownload(String download) {
        this.download = download;
    }

    public String getDoLiDis() {
        return this.doLiDis;
    }

    public void setDoLiDis(String doLiDis) {
        this.doLiDis = doLiDis;
    }

    public String getSeeLiDis() {
        return this.seeLiDis;
    }

    public void setSeeLiDis(String seeLiDis) {
        this.seeLiDis = seeLiDis;
    }

    public String getDoTalking() {
        return this.doTalking;
    }

    public void setDoTalking(String doTalking) {
        this.doTalking = doTalking;
    }

    public String getSeeTalking() {
        return this.seeTalking;
    }

    public void setSeeTalking(String seeTalking) {
        this.seeTalking = seeTalking;
    }

    public String getDoComment() {
        return this.doComment;
    }

    public void setDoComment(String doComment) {
        this.doComment = doComment;
    }

    public String getSeeComment() {
        return this.seeComment;
    }

    public void setSeeComment(String seeComment) {
        this.seeComment = seeComment;
    }

    public String getSeeShare() {
        return this.seeShare;
    }

    public void setSeeShare(String seeShare) {
        this.seeShare = seeShare;
    }

    public String getDoShare() {
        return this.doShare;
    }

    public void setDoShare(String doShare) {
        this.doShare = doShare;
    }

    public String getLike() {
        return this.like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public String getHlike() {
        return this.hlike;
    }

    public void setHlike(String hlike) {
        this.hlike = hlike;
    }

    public String getDislike() {
        return this.dislike;
    }

    public void setDislike(String dislike) {
        this.dislike = dislike;
    }

    public String getHdislike() {
        return this.hdislike;
    }

    public void setHdislike(String hdislike) {
        this.hdislike = hdislike;
    }

    public String getTalking() {
        return this.talking;
    }

    public void setTalking(String talking) {
        this.talking = talking;
    }

    public String getHtalking() {
        return this.htalking;
    }

    public void setHtalking(String htalking) {
        this.htalking = htalking;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getHcomment() {
        return this.hcomment;
    }

    public void setHcomment(String hcomment) {
        this.hcomment = hcomment;
    }

    public String getShare() {
        return this.share;
    }

    public void setShare(String share) {
        this.share = share;
    }

    public String getHshare() {
        return this.hshare;
    }

    public void setHshare(String hshare) {
        this.hshare = hshare;
    }

}
