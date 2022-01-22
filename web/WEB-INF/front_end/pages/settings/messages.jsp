<%@page import="data.encryption.decryption.InfoEncryptorDecryptor"%><%@page import="hibernate.query.chat.ChatlistPage"%><%@page import="hibernate.mapping.Messages"%><%@page import="java.util.List"%><%@page import="hibernate.mapping.Usermessages"%><%@page import="data.encryption.decryption.EscapeSpecialChars"%><%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%><%@taglib uri="http://www.springframework.org/tags" prefix="spring"%><%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int get_hour = 0;
    long user_two=0;
    String eli = request.getParameter("eli");
    String next_eli = request.getParameter("next_eli");
    String identify = request.getParameter("identifier");
    InfoEncryptorDecryptor decrypt_val = new InfoEncryptorDecryptor();
    decrypt_val.decrypt(next_eli.trim());
    String getuser_two = decrypt_val.getDecryptedString();
    if(getuser_two!=null){
        user_two = Long.parseLong(getuser_two);
    }
    GetUserById chatuser_detail = new GetUserById();
    Accounts user_detail = chatuser_detail.getUserbyId(user_two);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" "http://www.w3.org/TR/REC-html40/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Chat settings for <%out.print(user_detail.getFirstName()+" "+user_detail.getLastName());%></title>
    </head>
    <body><%@include file="../header.jsp"%>
        <h1>Chat settings for <a href="/user/info/?eli=<%out.print(java.net.URLEncoder.encode(next_eli,"UTF-8"));%>"><%out.print(user_detail.getFirstName()+" "+user_detail.getLastName());%></a></h1>
        <form method="post" action="/user/set/chat/settings/" name="block" id="block">
            <p>While Messaging:<br><br>
            <input type="radio" name="typing" id="typing" value="true">Show what am i typing&nbsp;&nbsp;&nbsp;<input type="radio" name="typing" id="typing" value="false">Show only "typing"</p>
            <p>Chat Display:<br><br>
            <input type="radio" name="typing" id="typing" value="true">Show chat by names&nbsp;&nbsp;&nbsp;<input type="radio" name="typing" id="typing" value="false">Show by colorful chatting</p>
            <p>Chat Wallpaper:<br><br>
            <input type="file" name="gradCollPic" id="gradCollPic" value="" autocorrect="off" autocomplete="off" spellcheck="false"/></p>
            <p>Block to Share:<br><br><input type="checkbox" name="image" id="image" value="true">Image&nbsp;<input type="checkbox" name="image" id="image" value="true">Audio&nbsp;<input type="checkbox" name="image" id="image" value="true">Video&nbsp;<input type="checkbox" name="image" id="image" value="true">File&nbsp;<input type="checkbox" name="image" id="image" value="true">Sticker&nbsp;<input type="checkbox" name="image" id="image" value="true">Emoji</p>
            <p>Messages Per Page:<br><br><select id="hour" name="hour"><%for(int i=1;i<=50;i++){if(i<=9){out.print("<option value=\"0"+i+"\"");}else{out.print("<option value=\""+i+"\"");}if(i==get_hour){out.print(" selected");}if(i<=9){out.print(">0"+i+"</option>");}else{out.print(">"+i+"</option>");}}%></select></p>
        <input type="hidden" name="eli" id="eli" value="<%out.print(eli);%>" autocorrect="off" autocomplete="off" spellcheck="false"/>
        <input type="hidden" name="next_eli" id="next_eli" value="<%out.print(next_eli);%>" autocorrect="off" autocomplete="off" spellcheck="false"/>
        <%if((identify!=null)&&(!"".equals(identify))){%><input type="hidden" name="identifier" id="identifier" value="<%out.print(java.net.URLEncoder.encode(identify,"UTF-8"));%>" autocorrect="off" autocomplete="off" spellcheck="false"/><%}%>
        <br><input type="submit" name="save" id="save" value="Save">
        </form>
    </center>
    </body>
</html>