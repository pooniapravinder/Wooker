package pages.controller.reactoper;

import data.encryption.decryption.Cryptography;
import hibernate.mapping.Accountpics;
import hibernate.mapping.Comments;
import hibernate.mapping.Talkings;
import hibernate.mapping.Userchatlist;
import hibernate.query.BlockDisable;
import hibernate.query.UserAccountPic;
import hibernate.query.reactoper.ReactOper;
import java.util.regex.Pattern;

public class ReactOperValidate {

    private String tarId;
    private String url;
    private boolean allowed;
    private boolean privacySucceed;
    private long selfUser;

    Cryptography crypto = new Cryptography();
    ReactOper getData = new ReactOper();
    BlockDisable getBlockDisable = new BlockDisable();

    public ReactOperValidate getAccountPic(String getId, String refer, String prerefer, long user, String option, long page, long prepage) {
        ReactOperValidate invalid = new ReactOperValidate(null, null, false, false, 0);
        String id = crypto.decrypt(getId);
        if (id == null) {
            return invalid;
        }
        String getRefer = getURL(0, refer, prerefer, getId, page, prepage);
        if (getRefer == null) {
            return invalid;
        }
        UserAccountPic getPic = new UserAccountPic();
        Accountpics getPicData = getPic.AccountImg(id);
        if (getPicData == null) {
            return invalid;
        }
        if (getBlockDisable.isBlocked(user, id)) {
            return invalid;
        }
        boolean allow;
        byte allowUser;
        switch (option) {
            case "like":
                allow = getPicData.isLikes();
                allowUser = getPicData.getDoLidislike();
                break;
            case "liked":
                allow = getPicData.isLikes();
                allowUser = getPicData.getSeeLidislike();
                break;
            case "dislike":
                allow = getPicData.isDislikes();
                allowUser = getPicData.getDoLidislike();
                break;
            case "disliked":
                allow = getPicData.isDislikes();
                allowUser = getPicData.getSeeLidislike();
                break;
            case "talking":
                allow = getPicData.isTalkings();
                allowUser = getPicData.getDoTalking();
                break;
            case "talked":
                allow = getPicData.isTalkings();
                allowUser = getPicData.getSeeTalking();
                break;
            case "comment":
                allow = getPicData.isComments();
                allowUser = getPicData.getDoComment();
                break;
            case "commented":
                allow = getPicData.isComments();
                allowUser = getPicData.getSeeComment();
                break;
            case "share":
                allow = getPicData.isShares();
                allowUser = getPicData.getDoShare();
                break;
            case "shared":
                allow = getPicData.isShares();
                allowUser = getPicData.getSeeShare();
                break;
            default:
                allow = false;
                allowUser = 1;
                break;
        }
        return new ReactOperValidate(id, getRefer, allow, privacyChecker(getPicData.getUserId(), user, allowUser), getPicData.getUserId());
    }

    public boolean isValidPicData(String getId, long user, String option) {
        boolean success = true;
        UserAccountPic getPic = new UserAccountPic();
        Accountpics getPicData = getPic.AccountImg(getId);
        boolean allow = true;
        boolean makeCheck = false;
        byte allowUser = 1;
        switch (option) {
            case "like":
                makeCheck = true;
                allow = getPicData.isLikes();
                allowUser = getPicData.getDoLidislike();
                break;
            case "liked":
                makeCheck = true;
                allow = getPicData.isLikes();
                allowUser = getPicData.getSeeLidislike();
                break;
            case "dislike":
                makeCheck = true;
                allow = getPicData.isDislikes();
                allowUser = getPicData.getDoLidislike();
                break;
            case "disliked":
                makeCheck = true;
                allow = getPicData.isDislikes();
                allowUser = getPicData.getSeeLidislike();
                break;
            case "reply":
                makeCheck = true;
                allow = getPicData.isTalkings();
                allowUser = getPicData.getDoTalking();
                break;
        }
        if ((makeCheck) && ((!allow) || (!privacyChecker(getPicData.getUserId(), user, allowUser)))) {
            success = false;
        }
        return success;
    }

    public ReactOperValidate getTalking(String getId, String refer, String prerefer, long user, String option, long page, long prepage) {
        ReactOperValidate invalid = new ReactOperValidate(null, null, false, false, 0);
        String id = crypto.decrypt(getId);
        if (id == null) {
            return invalid;
        }
        Talkings preData = getData.getTalkingByOperId(id);
        if ((preData == null) || (preData.isDeleted())) {
            return invalid;
        }
        long setUser = preData.getUserOne();
        Talkings getTarId = getData.getTalkingByOperId(preData.getTargetId());
        boolean isBlocked = getBlockDisable.isBlocked(setUser, getTarId != null ? getTarId.getTargetId() : preData.getTargetId());
        if ((isBlocked) && (user != preData.getUserTwo())) {
            return invalid;
        }
        boolean isDisabled = getBlockDisable.isDisabled(id);
        String getRefer = getURL(0, refer, prerefer, getId, page, prepage);
        if (getRefer == null) {
            return invalid;
        }
        ReactOperValidate checkValid = new ReactOperValidate();
        boolean getValid = false;
        switch (prerefer) {
            case "oUej-Ge7H7_ByLk":
                getValid = checkValid.isValidPicData(getTarId != null ? getTarId.getTargetId() : preData.getTargetId(), user, option);
        }
        if (!getValid) {
            return invalid;
        }
        switch (option) {
            case "like":
            case "dislike":
                if (isDisabled) {
                    return invalid;
                }
                break;
            case "liked":
            case "disliked":
                if ((isDisabled) && (user != preData.getUserTwo())) {
                    return invalid;
                }
                break;
            case "reply":
                if (((isDisabled) && (user != preData.getUserTwo())) || (preData.isReplied())) {
                    return invalid;
                }
                setUser = preData.getUserTwo();
                break;
            case "edit":
                if ((preData.isDeleted()) || ((isDisabled) && (user != preData.getUserTwo()))) {
                    return invalid;
                }
                break;
            case "delete":
                if (((user != preData.getUserOne()) && (user != preData.getUserTwo())) || ((user != preData.getUserTwo()) && (isDisabled))) {
                    return invalid;
                }
                break;
            case "disable":
                if ((user != preData.getUserTwo()) || (preData.isDeleted()) || (isDisabled)) {
                    return invalid;
                }
                break;
            case "enable":
                if ((user != preData.getUserTwo()) || (preData.isDeleted()) || (!isDisabled)) {
                    return invalid;
                }
                break;
            case "block":
                if ((user != preData.getUserTwo()) || (user == preData.getUserOne()) || (isBlocked)) {
                    return invalid;
                }
                id = getTarId != null ? getTarId.getTargetId() : preData.getTargetId();
                break;
            case "unblock":
                if ((user != preData.getUserTwo()) || (user == preData.getUserOne()) || (!isBlocked)) {
                    return invalid;
                }
                id = getTarId != null ? getTarId.getTargetId() : preData.getTargetId();
                break;
        }
        return new ReactOperValidate(id, getRefer, true, true, setUser);
    }

    public ReactOperValidate getComment(String getId, String getUserId, String refer, String prerefer, long user, String option, long page, long prepage) {
        ReactOperValidate invalid = new ReactOperValidate(null, null, false, false, 0);
        String id = crypto.decrypt(getId);
        String userId = crypto.decrypt(getUserId);
        if (id == null) {
            return invalid;
        }
        Comments preData = null;
        long commenter = userId != null ? Long.parseLong(userId) : 0;
        if (option.equals("write") && (commenter != 0)) {
            preData = getData.getCommentByUser(commenter, id);
        } else if (!option.equals("write")) {
            preData = getData.getCommentByOperId(id);
        }
        if ((preData == null) || (preData.isDeleted())) {
            return invalid;
        }
        long setUser = preData.getUserOne();
        boolean isBlocked = getBlockDisable.isBlocked(setUser, preData.getTargetId());
        if ((isBlocked) && (user != preData.getUserTwo())) {
            return invalid;
        }
        boolean isDisabled = getBlockDisable.isDisabled(id);
        String getRefer = getURL(commenter, refer, prerefer, getId, page, prepage);
        if (getRefer == null) {
            return invalid;
        }
        ReactOperValidate checkValid = new ReactOperValidate();
        boolean getValid = false;
        switch (prerefer) {
            case "oUej-Ge7H7_ByLk":
                getValid = checkValid.isValidPicData(preData.getTargetId(), user, option);
        }
        if (!getValid) {
            return invalid;
        }
        switch (option) {
            case "like":
            case "dislike":
                if (isDisabled) {
                    return invalid;
                }
                break;
            case "liked":
            case "disliked":
                if ((isDisabled) && (user != preData.getUserTwo())) {
                    return invalid;
                }
                break;
            case "write":
                if ((preData.isDeleted()) || (user != preData.getUserTwo())) {
                    return invalid;
                }
                id = preData.getTargetId();
                break;
            case "edit":
                if ((preData.isDeleted()) || ((isDisabled) && (user != preData.getUserTwo()))) {
                    return invalid;
                }
                break;
            case "delete":
                if (((user != preData.getUserOne()) && (user != preData.getUserTwo())) || ((user != preData.getUserTwo()) && (isDisabled))) {
                    return invalid;
                }
                break;
            case "disable":
                if ((user != preData.getUserTwo()) || (preData.isDeleted()) || (isDisabled)) {
                    return invalid;
                }
                break;
            case "enable":
                if ((user != preData.getUserTwo()) || (preData.isDeleted()) || (!isDisabled)) {
                    return invalid;
                }
                break;
            case "block":
                if ((user != preData.getUserTwo()) || (user == preData.getUserOne()) || (isBlocked)) {
                    return invalid;
                }
                id = preData.getTargetId();
                break;
            case "unblock":
                if ((user != preData.getUserTwo()) || (user == preData.getUserOne()) || (!isBlocked)) {
                    return invalid;
                }
                id = preData.getTargetId();
                break;
        }
        return new ReactOperValidate(id, getRefer, true, true, setUser);
    }

    public String getURL(long userOne, String refer, String prerefer, String sqq, long page, long prepage) {
        Pattern pattern = Pattern.compile("^(oUej-Ge7H7_ByLk|mrPdk_dm-dnn_dk|HjDOplM-JEkr_fs|ErtBh_qwOsKL-sS|je_PO-zxcIMdEqP|NoeKmf-F_fkERMl|kp_w8AAy-OaK_5P|bdGhwKd-GbOW_nR|kHy_d-sdKhdIIDj|vbYUn-MnIOA_sEL|weU_sJ-HQkjUsMl|NdwJfLnr_dj-dND|yYhjT_gdUmcO-KD|KmEpF-NJKL_qRdh|AodiEj-dL_dejEW)$");
        Pattern refPattern = Pattern.compile("^(oUej-Ge7H7_ByLk)$");
        String urlCreated = null;
        if ((refer == null) || (!pattern.matcher(refer).matches())) {
            return urlCreated;
        }
        switch (refer) {
            case "oUej-Ge7H7_ByLk":
                urlCreated = "account/pic/edit/" + "?" + "sqq=" + crypto.encodeURL(sqq);
                break;
            case "mrPdk_dm-dnn_dk":
                if ((prerefer == null) || (!refPattern.matcher(prerefer).matches())) {
                    return urlCreated;
                }
                urlCreated = "accpic/user/oper/talking/" + "?" + "sqq=" + crypto.encodeURL(sqq) + "&" + "refer=" + prerefer;
                break;
            case "HjDOplM-JEkr_fs":
                if ((prerefer == null) || (!refPattern.matcher(prerefer).matches())) {
                    return urlCreated;
                }
                urlCreated = "accpic/user/oper/comment/" + "?" + "sqq=" + crypto.encodeURL(sqq) + "&" + "refer=" + prerefer;
                break;
            case "ErtBh_qwOsKL-sS":
                if ((prerefer == null) || (!refPattern.matcher(prerefer).matches())) {
                    return urlCreated;
                }
                Comments commentData = getData.getCommentByOperId(crypto.decrypt(sqq));
                urlCreated = "comment/user/oper/write/" + "?" + "sqq=" + crypto.encodeURL(crypto.encrypt(commentData.getTargetId())) + "&" + "user=" + crypto.encodeURL(crypto.encrypt(String.valueOf(commentData.getUserOne()))) + "&" + "refer=vbYUn-MnIOA_sEL" + "&" + "prerefer=" + prerefer;
                break;
            case "je_PO-zxcIMdEqP":
                if ((prerefer == null) || (!refPattern.matcher(prerefer).matches())) {
                    return urlCreated;
                }
                Comments commentsData = getData.getCommentByOperId(crypto.decrypt(sqq));
                urlCreated = "comment/user/oper/write/" + "?" + "sqq=" + crypto.encodeURL(crypto.encrypt(commentsData.getTargetId())) + "&" + "user=" + crypto.encodeURL(crypto.encrypt(String.valueOf(commentsData.getUserOne()))) + "&" + "refer=vbYUn-MnIOA_sEL" + "&" + "prerefer=" + prerefer;
                break;
            case "NoeKmf-F_fkERMl":
                if ((prerefer == null) || (!refPattern.matcher(prerefer).matches())) {
                    return urlCreated;
                }
                urlCreated = "comment/user/oper/write/" + "?" + "sqq=" + crypto.encodeURL(sqq) + "&" + "user=" + crypto.encodeURL(crypto.encrypt(String.valueOf(userOne))) + "&" + "refer=vbYUn-MnIOA_sEL" + "&" + "prerefer=" + prerefer;
                break;
            case "kp_w8AAy-OaK_5P":
                if ((prerefer == null) || (!refPattern.matcher(prerefer).matches())) {
                    return urlCreated;
                }
                String idTalkValue = getData.getTalkingByOperId(crypto.decrypt(sqq)).getTargetId();
                urlCreated = "accpic/user/oper/talking/" + "?" + "sqq=" + crypto.encodeURL(crypto.encrypt(idTalkValue)) + "&" + "refer=" + prerefer;
                break;
            case "bdGhwKd-GbOW_nR":
                if ((prerefer == null) || (!refPattern.matcher(prerefer).matches())) {
                    return urlCreated;
                }
                page = prepage;
                prepage = 0;
                String idTalkingValue = getData.getTalkingByOperId(crypto.decrypt(sqq)).getTargetId();
                urlCreated = "accpic/user/oper/talking/" + "?" + "sqq=" + crypto.encodeURL(crypto.encrypt(idTalkingValue)) + "&" + "refer=" + prerefer;
                break;
            case "kHy_d-sdKhdIIDj":
                if ((prerefer == null) || (!refPattern.matcher(prerefer).matches())) {
                    return urlCreated;
                }
                String idCommentValue = getData.getCommentByOperId(crypto.decrypt(sqq)).getTargetId();
                urlCreated = "accpic/user/oper/comment/" + "?" + "sqq=" + crypto.encodeURL(crypto.encrypt(idCommentValue)) + "&" + "refer=" + prerefer;
                break;
            case "vbYUn-MnIOA_sEL":
                if ((prerefer == null) || (!refPattern.matcher(prerefer).matches())) {
                    return urlCreated;
                }
                urlCreated = "accpic/user/oper/comment/" + "?" + "sqq=" + crypto.encodeURL(sqq) + "&" + "refer=" + prerefer;
                break;
            case "weU_sJ-HQkjUsMl":
                if ((prerefer == null) || (!refPattern.matcher(prerefer).matches())) {
                    return urlCreated;
                }
                urlCreated = "talking/user/oper/reply/" + "?" + "sqq=" + crypto.encodeURL(sqq) + "&" + "refer=kp_w8AAy-OaK_5P" + "&" + "prerefer=" + prerefer;
                break;
            case "NdwJfLnr_dj-dND":
                if ((prerefer == null) || (!refPattern.matcher(prerefer).matches())) {
                    return urlCreated;
                }
                page = prepage;
                prepage = 0;
                urlCreated = "talking/user/oper/reply/" + "?" + "sqq=" + crypto.encodeURL(sqq) + "&" + "refer=kp_w8AAy-OaK_5P" + "&" + "prerefer=" + prerefer;
                break;
            case "yYhjT_gdUmcO-KD":
                if ((prerefer == null) || (!refPattern.matcher(prerefer).matches())) {
                    return urlCreated;
                }
                String idVal = getData.getTalkingByOperId(crypto.decrypt(sqq)).getTargetId();
                urlCreated = "talking/user/oper/reply/" + "?" + "sqq=" + crypto.encodeURL(crypto.encrypt(idVal)) + "&" + "refer=kp_w8AAy-OaK_5P" + "&" + "prerefer=" + prerefer;
                break;
            case "KmEpF-NJKL_qRdh":
                if ((prerefer == null) || (!refPattern.matcher(prerefer).matches())) {
                    return urlCreated;
                }
                page = prepage;
                prepage = 0;
                String idNewVal = getData.getTalkingByOperId(crypto.decrypt(sqq)).getTargetId();
                urlCreated = "talking/user/oper/reply/" + "?" + "sqq=" + crypto.encodeURL(crypto.encrypt(idNewVal)) + "&" + "refer=kp_w8AAy-OaK_5P" + "&" + "prerefer=" + prerefer;
                break;
            case "AodiEj-dL_dejEW":
                urlCreated = "account/pic/upload/new/";
                break;
        }
        page = prepage != 0 ? prepage : page;
        return page != 0 ? urlCreated + "&" + "page=" + page : urlCreated;
    }

    public boolean privacyChecker(long selfUser, long user, byte allowUsers) {
        boolean success = false;
        ReactOper getPrivacy = new ReactOper();
        /*
         check if the both the users are being blocked or not
         */
        Userchatlist getChatlist = getPrivacy.getChatlistPrivacy(selfUser, user);
        if ((getChatlist != null) && (getChatlist.isBlocked())) {
            return false;
        }
        /*
         if current user in session is self then it can perform all reactions (selfUser == user)
         if allow users or privacy is 3 then everyone will be able to perform reaction (allowUsers == 3)
         */
        if ((selfUser == user) || (allowUsers == 3)) {
            return true;
        }
        switch (allowUsers) {
            case 2:
                success = (getChatlist != null) && (getChatlist.isFriend());
                break;
            case 4:
                success = getPrivacy.getSchoolPrivacy(selfUser, user);
                break;
            case 5:
                success = getPrivacy.getCollegePrivacy(selfUser, user);
                break;
            case 6:
                success = getPrivacy.getUniverPrivacy(selfUser, user);
                break;
        }
        return success;
    }

    public ReactOperValidate() {
    }

    public ReactOperValidate(String tarId, String url, boolean allowed, boolean privacySucceed, long selfUser) {
        this.tarId = tarId;
        this.url = url;
        this.allowed = allowed;
        this.privacySucceed = privacySucceed;
        this.selfUser = selfUser;
    }

    public String getTarId() {
        return this.tarId;
    }

    public void setTarId(String tarId) {
        this.tarId = tarId;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isAllowed() {
        return this.allowed;
    }

    public void setAllowed(boolean allowed) {
        this.allowed = allowed;
    }

    public boolean isPrivacySucceed() {
        return this.privacySucceed;
    }

    public void setPrivacySucceed(boolean privacySucceed) {
        this.privacySucceed = privacySucceed;
    }

    public long getSelfUser() {
        return this.selfUser;
    }

    public void setSelfUser(long selfUser) {
        this.selfUser = selfUser;
    }

}
