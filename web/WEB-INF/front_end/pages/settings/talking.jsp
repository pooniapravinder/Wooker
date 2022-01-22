<%@page import="hibernate.mapping.Likesdislikes"%><%@page import="data.encryption.decryption.InfoEncryptorDecryptor"%><%@page import="hibernate.mapping.Talkings"%><%@page import="hibernate.query.UserDefaultOptions"%><%@page import="hibernate.query.info.ChatUserInfo"%><%@page import="java.util.Calendar"%><%@page import="timeperiod.duration.calculation.CalculateTime"%><%@page import="java.util.List"%><%@taglib uri="http://www.springframework.org/tags" prefix="spring"%><%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%><%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    long user_one = (long) session.getAttribute("user_account"); int get_page=0;
    String integers = "^(?:[0-9]){1,11}$";
    CalculateTime get_time = new CalculateTime();
    int currentyear = Calendar.getInstance().get(Calendar.YEAR);
    String picuser_id = request.getParameter("eli");
    String pic_id = request.getParameter("sqq");
    String talking_id = request.getParameter("kkt");
    String get_type = request.getParameter("type");
    String getnext_type = request.getParameter("next_type");
    String get_pageid = request.getParameter("page");
    if((get_pageid!=null)&&(get_pageid.matches(integers))){
    get_page = Integer.parseInt(get_pageid);
    }
    long user_two=0; byte like_val=1; byte dislike_val=2;
            IdEncryptorDecryptor encrypt_val = new IdEncryptorDecryptor();
            encrypt_val.decryptid(picuser_id.trim());
            String user_eli = encrypt_val.getDecryptedId();
            encrypt_val.decryptid(pic_id.trim());
            String user_sqq = encrypt_val.getDecryptedId();
            if(user_eli!=null){
                user_two = Long.parseLong(user_eli);
            }
            UserAccountPic get_imgval = new UserAccountPic();
            Accountpics get_imgdetail = get_imgval.isAccountImg(user_sqq,user_two);
            UserDefaultOptions get_query = new UserDefaultOptions();
            String lidislike_block = get_query.blocked_lidislikes(user_two,user_one,user_sqq);
            String talking_block = get_query.blocked_talking(user_one,user_two,user_sqq);
            String comment_block = get_query.blocked_comment(user_one,user_two,user_sqq);
                long count_like = get_query.countlikesdislikes(like_val,user_sqq);
                long count_dislike = get_query.countlikesdislikes(dislike_val,user_sqq);
                long count_talking = get_query.counttalkings(true,user_sqq);
                long count_comment = get_query.countcomments(true,user_sqq);
    String set_time=null; int month=0; int date=0; int year=0; int hours=0; int minutes=0; String ampm=null;
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Talking Settings</title>
    </head>
    <body><%@include file="../header.jsp"%>
        <%if(get_imgdetail!=null){
                byte like = get_imgdetail.getLikeOpt();
                byte dislike = get_imgdetail.getDislikeOpt();
                byte talking = get_imgdetail.getTalkingOpt();
                byte do_talking = get_imgdetail.getDoTalking();
                byte see_talking = get_imgdetail.getSeeTalking();
                byte comment = get_imgdetail.getCommentOpt();
                byte share = get_imgdetail.getShareOpt();
                byte permit_image = get_imgdetail.getTalkingImage();
                byte permit_audio = get_imgdetail.getTalkingAudio();
                byte permit_video = get_imgdetail.getTalkingVideo();
                byte permit_file = get_imgdetail.getTalkingFile();
                byte permit_sticker = get_imgdetail.getTalkingSticker();
                String permit_extens = get_imgdetail.getTalkingExtension();
                set_time = get_imgdetail.getTimeDate();
                month = get_time.getMonth(set_time);
                date = get_time.getDate(set_time);
                year = get_time.getYear(set_time);
                hours = get_time.getHours(set_time);
                minutes = get_time.getMinutes(set_time);
                ampm = get_time.getAMPM(set_time);
                encrypt_val.encryptid((user_one+"_"+user_sqq).trim());
                String kkl = encrypt_val.getEncryptedId();
                encrypt_val.encryptid((user_one+"_vttEry_72uhi_TC"+user_sqq).trim());
                String like_id = encrypt_val.getEncryptedId();
                encrypt_val.encryptid((user_one+"_niv_niy6hgTy_ghfh"+user_sqq).trim());
                String dislike_id = encrypt_val.getEncryptedId();
                encrypt_val.encryptid((user_one+"_vbGIhj_fDEb34DIm_h"+user_sqq).trim());
                String comment_id = encrypt_val.getEncryptedId();
                encrypt_val.encryptid((user_one+"_nbYiy6_72uOPLk"+user_sqq).trim());
                String share_id = encrypt_val.getEncryptedId();
                Likesdislikes is_liked = get_query.getlikedislike(like_val,user_one,user_sqq);
                Likesdislikes is_disliked = get_query.getlikedislike(dislike_val,user_one,user_sqq);
        %>
        <a href="/account/pic/full/size/?eli=<%if(picuser_id!=null){out.print(java.net.URLEncoder.encode(picuser_id,"UTF-8"));}%>&amp;sqq=<%if(pic_id!=null){out.print(java.net.URLEncoder.encode(pic_id,"UTF-8"));}%>&amp;kkl=<%if(kkl!=null){out.print(java.net.URLEncoder.encode(kkl,"UTF-8"));}%>"><img src="/account/pic/show/?eli=<%if(picuser_id!=null){out.print(java.net.URLEncoder.encode(picuser_id,"UTF-8"));}%>&amp;sqq=<%if(pic_id!=null){out.print(java.net.URLEncoder.encode(pic_id,"UTF-8"));}%>"></a><br>
        <%if((month==1)){%><spring:message code="label.month.01"/><%}else if(month==2){%><spring:message code="label.month.02"/><%}else if(month==3){%><spring:message code="label.month.03"/><%}else if(month==4){%><spring:message code="label.month.04"/><%}else if(month==5){%><spring:message code="label.month.05"/><%}else if(month==6){%><spring:message code="label.month.06"/><%}else if(month==7){%><spring:message code="label.month.07"/><%}else if(month==8){%><spring:message code="label.month.08"/><%}else if(month==9){%><spring:message code="label.month.09"/><%}else if(month==10){%><spring:message code="label.month.10"/><%}else if(month==11){%><spring:message code="label.month.11"/><%}else if(month==12){%><spring:message code="label.month.12"/><%}if(date<10){out.print(" 0"+date);}else{out.print(" "+date);}if(year!=currentyear){out.print(","+year);}%><%if(hours<10){out.print(" "+"0"+hours+":");}else{out.print(" "+hours+":");}if(minutes<10){out.print("0"+minutes);}else{out.print(minutes);}out.print(" "+ampm);%><br>
        <%if(like==1){if((count_like>0)&&(lidislike_block==null)){%><a href="/user/who/liked/?eli=<%if(picuser_id!=null){out.print(java.net.URLEncoder.encode(picuser_id,"UTF-8"));}%>&amp;sqq=<%if(pic_id!=null){out.print(java.net.URLEncoder.encode(pic_id,"UTF-8"));}%>&amp;type=<%if(get_type!=null){out.print(java.net.URLEncoder.encode(get_type,"UTF-8"));}%>&amp;next_type=<%if(getnext_type!=null){out.print(java.net.URLEncoder.encode(getnext_type,"UTF-8"));}%>"><%out.print(count_like+" ");%></a><%}else if((count_like>0)&&(lidislike_block!=null)){%><%out.print(count_like+" ");}%><a href="/user/do/like/?eli=<%if(picuser_id!=null){out.print(java.net.URLEncoder.encode(picuser_id,"UTF-8"));}%>&amp;sqq=<%if(pic_id!=null){out.print(java.net.URLEncoder.encode(pic_id,"UTF-8"));}%>&amp;kkt=<%if(like_id!=null){out.print(java.net.URLEncoder.encode(like_id,"UTF-8"));}%>&amp;type=<%if(get_type!=null){out.print(java.net.URLEncoder.encode(get_type,"UTF-8"));}%>&amp;next_type=<%if(getnext_type!=null){out.print(java.net.URLEncoder.encode(getnext_type,"UTF-8"));}%>&amp;refer=HqioNjPGwbKnIN&amp;page=<%out.print(get_page);%>"><%if((count_like==1)&&(is_liked==null)){%>Like<%}else if((count_like==1)&&(is_liked!=null)){%>Liked<%}else if((count_like>1)&&(is_liked==null)){%>Likes<%}else if((count_like>1)&&(is_liked!=null)){%>Liked<%}else{%>Like<%}%></a>&nbsp;<%}if(dislike==1){if((count_dislike>0)&&(lidislike_block==null)){%><a href="/user/who/disliked/?eli=<%if(picuser_id!=null){out.print(java.net.URLEncoder.encode(picuser_id,"UTF-8"));}%>&amp;sqq=<%if(pic_id!=null){out.print(java.net.URLEncoder.encode(pic_id,"UTF-8"));}%>&amp;type=<%if(get_type!=null){out.print(java.net.URLEncoder.encode(get_type,"UTF-8"));}%>&amp;next_type=<%if(getnext_type!=null){out.print(java.net.URLEncoder.encode(getnext_type,"UTF-8"));}%>"><%out.print(count_dislike+" ");%></a><%}else if((count_dislike>0)&&(lidislike_block!=null)){out.print(count_dislike+" ");}%><a href="/user/do/dislike/?eli=<%if(picuser_id!=null){out.print(java.net.URLEncoder.encode(picuser_id,"UTF-8"));}%>&amp;sqq=<%if(pic_id!=null){out.print(java.net.URLEncoder.encode(pic_id,"UTF-8"));}%>&amp;kkt=<%if(dislike_id!=null){out.print(java.net.URLEncoder.encode(dislike_id,"UTF-8"));}%>&amp;type=<%if(get_type!=null){out.print(java.net.URLEncoder.encode(get_type,"UTF-8"));}%>&amp;next_type=<%if(getnext_type!=null){out.print(java.net.URLEncoder.encode(getnext_type,"UTF-8"));}%>&amp;refer=HqioNjPGwbKnIN&amp;page=<%out.print(get_page);%>"><%if((count_dislike==1)&&(is_disliked==null)){%>Dislike<%}else if((count_dislike==1)&&(is_disliked!=null)){%>Disliked<%}else if((count_dislike>1)&&(is_disliked==null)){%>Dislikes<%}else if((count_dislike>1)&&(is_disliked!=null)){%>Disliked<%}else{%>Dislike<%}%></a>&nbsp;<%}if(talking==1){if((count_talking>0)&&(talking_block==null)){%><a href="/user/who/talked/?eli=<%if(picuser_id!=null){out.print(java.net.URLEncoder.encode(picuser_id,"UTF-8"));}%>&amp;sqq=<%if(pic_id!=null){out.print(java.net.URLEncoder.encode(pic_id,"UTF-8"));}%>&amp;type=<%if(get_type!=null){out.print(java.net.URLEncoder.encode(get_type,"UTF-8"));}%>&amp;next_type=<%if(getnext_type!=null){out.print(java.net.URLEncoder.encode(getnext_type,"UTF-8"));}%>"><%out.print(count_talking+" ");%></a><%}else if((count_talking>0)&&(talking_block!=null)){out.print(count_talking+" ");}%><a href="/user/do/talking/?eli=<%if(picuser_id!=null){out.print(java.net.URLEncoder.encode(picuser_id,"UTF-8"));}%>&amp;sqq=<%if(pic_id!=null){out.print(java.net.URLEncoder.encode(pic_id,"UTF-8"));}%>&amp;kkt=<%if(talking_id!=null){out.print(java.net.URLEncoder.encode(talking_id,"UTF-8"));}%>&amp;type=<%if(get_type!=null){out.print(java.net.URLEncoder.encode(get_type,"UTF-8"));}%>&amp;next_type=<%if(getnext_type!=null){out.print(java.net.URLEncoder.encode(getnext_type,"UTF-8"));}%>">Talking</a>&nbsp;<%}if(comment==1){if((count_comment>0)&&(comment_block==null)){%><a href="/user/who/commented/?eli=<%if(picuser_id!=null){out.print(java.net.URLEncoder.encode(picuser_id,"UTF-8"));}%>&amp;sqq=<%if(pic_id!=null){out.print(java.net.URLEncoder.encode(pic_id,"UTF-8"));}%>&amp;type=<%if(get_type!=null){out.print(java.net.URLEncoder.encode(get_type,"UTF-8"));}%>&amp;next_type=<%if(getnext_type!=null){out.print(java.net.URLEncoder.encode(getnext_type,"UTF-8"));}%>"><%out.print(count_comment+" ");%></a><%}else if((count_comment>0)&&(comment_block!=null)){out.print(count_comment+" ");}%><a href="/user/do/comment/?eli=<%if(picuser_id!=null){out.print(java.net.URLEncoder.encode(picuser_id,"UTF-8"));}%>&amp;sqq=<%if(pic_id!=null){out.print(java.net.URLEncoder.encode(pic_id,"UTF-8"));}%>&amp;kkt=<%if(comment_id!=null){out.print(java.net.URLEncoder.encode(comment_id,"UTF-8"));}%>&amp;type=<%if(get_type!=null){out.print(java.net.URLEncoder.encode(get_type,"UTF-8"));}%>&amp;next_type=<%if(getnext_type!=null){out.print(java.net.URLEncoder.encode(getnext_type,"UTF-8"));}%>"><%if(count_comment==1){%>Comment<%}else if(count_comment>1){%>Comments<%}else{%>Comment<%}%></a>&nbsp;<%}if(share==1){%><a href="/user/do/share/?eli=<%if(picuser_id!=null){out.print(java.net.URLEncoder.encode(picuser_id,"UTF-8"));}%>&amp;sqq=<%if(pic_id!=null){out.print(java.net.URLEncoder.encode(pic_id,"UTF-8"));}%>&amp;kkt=<%if(share_id!=null){out.print(java.net.URLEncoder.encode(share_id,"UTF-8"));}%>&amp;type=<%if(get_type!=null){out.print(java.net.URLEncoder.encode(get_type,"UTF-8"));}%>">Share</a><%}%>
        <a href="/account/pic/full/download/?eli=<%if(picuser_id!=null){out.print(java.net.URLEncoder.encode(picuser_id,"UTF-8"));}%>&amp;sqq=<%if(pic_id!=null){out.print(java.net.URLEncoder.encode(pic_id,"UTF-8"));}%>&amp;kkl=<%if(kkl!=null){out.print(java.net.URLEncoder.encode(kkl,"UTF-8"));}%>">Download</a><br>
        <p>Try out settings for talking</p>
        <form:form method="post" name="talkingSetting" id="talkingSetting" action="/user/talking/settings/">
            <label for="doTalking">Who can talk on your account pic:</label><select id="doTalking" name="doTalking"><option value="sqqi"<%if(do_talking==1){out.print(" selected");}%>><spring:message code="editinfo.label.onlyme"/></option><option value="nznp"<%if(do_talking==2){out.print(" selected");}%>><spring:message code="editinfo.label.chatlist"/></option><option value="mcni"<%if(do_talking==3){out.print(" selected");}%>><spring:message code="editinfo.label.everyone"/></option><option value="mozp"<%if(do_talking==4){out.print(" selected");}%>><spring:message code="editinfo.label.myschool"/></option><option value="nihx"<%if(do_talking==5){out.print(" selected");}%>><spring:message code="editinfo.label.mycollege"/></option><option value="raop"<%if(do_talking==6){out.print(" selected");}%>><spring:message code="editinfo.label.myuniversity"/></option><option value="qrvt"<%if(do_talking==7){out.print(" selected");}%>><spring:message code="editinfo.label.mycity"/></option></select><br>
            <label for="picTalking">Who can see who has talked your account pic:</label><select id="picTalking" name="picTalking"><option value="dexw"<%if(see_talking==1){out.print(" selected");}%>><spring:message code="editinfo.label.onlyme"/></option><option value="cwqv"<%if(see_talking==2){out.print(" selected");}%>><spring:message code="editinfo.label.chatlist"/></option><option value="qrrn"<%if(see_talking==3){out.print(" selected");}%>><spring:message code="editinfo.label.everyone"/></option><option value="ceer"<%if(see_talking==4){out.print(" selected");}%>><spring:message code="editinfo.label.myschool"/></option><option value="vegt"<%if(see_talking==5){out.print(" selected");}%>><spring:message code="editinfo.label.mycollege"/></option><option value="zcxz"<%if(see_talking==6){out.print(" selected");}%>><spring:message code="editinfo.label.myuniversity"/></option><option value="lppl"<%if(see_talking==7){out.print(" selected");}%>><spring:message code="editinfo.label.mycity"/></option></select><br>
            Allow to media for talking:<input type="checkbox"<%if(permit_image==1){out.print(" checked");}%> name="typeImage" id="typeImage" value="true">Image&nbsp;<input type="checkbox"<%if(permit_audio==1){out.print(" checked");}%> name="typeAudio" id="typeAudio" value="true">Audio&nbsp;<input type="checkbox"<%if(permit_video==1){out.print(" checked");}%> name="typeVideo" id="typeVideo" value="true">Video&nbsp;<input type="checkbox"<%if(permit_file==1){out.print(" checked");}%> name="typeFile" id="typeFile" value="true">File&nbsp;<input type="checkbox"<%if(permit_sticker==1){out.print(" checked");}%> name="typeSticker" id="typeSticker" value="true">Sticker<br>
            <label for="typeExten">if your desired media is not given above then type extension below:</label><br>
            <input type="hidden" name="eli" id="eli" value="<%if(picuser_id!=null){out.print(picuser_id);}%>" autocorrect="off" autocomplete="off" spellcheck="false"/>
            <input type="hidden" name="sqq" id="sqq" value="<%if(pic_id!=null){out.print(pic_id);}%>" autocorrect="off" autocomplete="off" spellcheck="false"/>
            <input type="hidden" name="kkt" id="kkt" value="<%if(talking_id!=null){out.print(talking_id);}%>" autocorrect="off" autocomplete="off" spellcheck="false"/><br>
            <input type="hidden" name="type" id="type" value="<%if(get_type!=null){out.print(get_type);}%>" autocorrect="off" autocomplete="off" spellcheck="false"/>
            <input type="hidden" name="next_type" id="next_type" value="<%if(getnext_type!=null){out.print(getnext_type);}%>" autocorrect="off" autocomplete="off" spellcheck="false"/>
            <input type="hidden" name="get_page" id="get_page" value="<%out.print(get_page);%>" autocorrect="off" autocomplete="off" spellcheck="false"/>
            <input type="text" name="typeExten" id="typeExten" value="<%if(permit_extens!=null){out.print(EscapeSpecialChars.escape(permit_extens));}%>" autocomplete="off" spellcheck="false"/><br>
            Use comma to add more extensions(e.g. jpg,jpeg,mp4,avi)<br>
            <input type="submit" name="submit" id="submit" value="<spring:message code="editmoreinfo.label.save"/>">
        </form:form>
        <%}%>
    </body>
</html>