package email.phone.otp;

import hibernate.mapping.Otpcode;
import hibernate.query.UserOTP;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;
import java.util.regex.Pattern;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendVerifyCode {

    public void sendOTP(long UserId, String EmailPhone, int OtpCode, boolean doUpdate) {
        saveOTP(UserId, OtpCode, doUpdate);
        Pattern EmailPattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,4})$");
        if (EmailPattern.matcher(EmailPhone).matches()) {
            sendMail(EmailPhone, OtpCode);
        } else {
            sendMessage(EmailPhone, OtpCode);
        }
    }

    public void sendCallOTP(long UserId, String EmailPhone, int OtpCode, boolean doUpdate) {
        saveOTP(UserId, OtpCode, doUpdate);
        sendCallMessage(EmailPhone, OtpCode);
    }

    public void sendMail(String MailTo, int OtpCode) {
        final String username = "pooniapravinder@gmail.com";
        final String password = "Poonia6475";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("pooniapravinder@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(MailTo));
            message.setSubject("Wooker Verification Code !!!");
            message.setText("Dear User,\n\n Your verification code is " + OtpCode + "\n\n We are glad to see you here \n It's time to verify your account.");
            Transport.send(message);
        } catch (MessagingException e) {
            System.out.println("Username or Password are incorrect ... exiting !");
            throw new RuntimeException(e);
        }
    }

    public void sendMessage(String MsgTo, int OtpCode) {
        try {
            String msg = "Your Wooker verification code is " + OtpCode + "\n Please do not share with anyone";
            URL url = new URL("https://smsapi.engineeringtgr.com/send/?Mobile=8708669401&Password=poonia1234&Message=" + java.net.URLEncoder.encode(msg, "UTF-8") + "&To=" + MsgTo + "&Key=PinkuJuxoheH4G2PBdRQMEWcI");
            URLConnection urlcon = url.openConnection();
            InputStream stream = urlcon.getInputStream();
            int i;
            String response = "";
            while ((i = stream.read()) != -1) {
                response += (char) i;
            }
            if (response.contains("success")) {
                System.out.println("Successfully sent SMS");
                //your code when message send success
            } else {
                System.out.println(response);
                //your code when message not send
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public void sendCallMessage(String MsgTo, int OtpCode) {

    }

    public void saveOTP(long userid, int OtpCode, boolean doUpdate) {
        UserOTP saveOTP = new UserOTP();
        long current_timestamp = System.currentTimeMillis();
        if (doUpdate) {
            saveOTP.NewOTP(userid, current_timestamp, OtpCode);
        } else {
            byte val = 0;
            Otpcode setOTP = new Otpcode(userid, current_timestamp, OtpCode, val);
            saveOTP.saveOTP(setOTP);
        }
    }

}
