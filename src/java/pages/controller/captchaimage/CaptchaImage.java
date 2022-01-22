package pages.controller.captchaimage;

import Random.String.Generator.RandomString;
import hibernate.mapping.Captchacode;
import hibernate.query.CaptchaCode;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CaptchaImage {

    @RequestMapping(value = "/captcha_image.jpg", method = RequestMethod.GET)
    public void CaptchaImage(HttpServletResponse response) throws IOException {
        int iTotalChars = 6;
        int iHeight = 40;
        int iWidth = 150;
        Font fntStyle1 = new Font("Arial", Font.BOLD, 30);
        Font fntStyle2 = new Font("Verdana", Font.BOLD, 20);
        Random randChars = new Random();
        String sImageCode = (Long.toString(Math.abs(randChars.nextLong()), 36)).substring(0, iTotalChars);
        
        // Insert to Database
        long timestamp = System.currentTimeMillis();
        RandomString getRandom = new RandomString();
        CaptchaCode SaveCaptcha = new CaptchaCode();
        Captchacode CaptchaVal = new Captchacode(getRandom.RandomString(25000),sImageCode,false,timestamp);
        SaveCaptcha.InsertCaptcha(CaptchaVal);
        //finish
        
        BufferedImage biImage = new BufferedImage(iWidth, iHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2dImage = (Graphics2D) biImage.getGraphics();
        int iCircle = 15;
        for (int i = 0; i < iCircle; i++) {
            g2dImage.setColor(new Color(randChars.nextInt(255), randChars.nextInt(255), randChars.nextInt(255)));
            int iRadius = (int) (Math.random() * iHeight / 2.0);
            int iX = (int) (Math.random() * iWidth - iRadius);
            int iY = (int) (Math.random() * iHeight - iRadius);
        }
        g2dImage.setFont(fntStyle1);
        for (int i = 0; i < iTotalChars; i++){
            g2dImage.setColor(new Color(randChars.nextInt(255), randChars.nextInt(255), randChars.nextInt(255)));
            if (i % 2 == 0){
                g2dImage.drawString(sImageCode.substring(i, i + 1), 25 * i, 24);
            }else{
                g2dImage.drawString(sImageCode.substring(i, i + 1), 25 * i, 35);
            }
        }
        try (OutputStream osImage = response.getOutputStream()){
            ImageIO.write(biImage, "jpeg", osImage);
        }
        g2dImage.dispose();
    }

}