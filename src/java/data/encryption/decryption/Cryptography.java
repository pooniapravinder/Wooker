package data.encryption.decryption;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import org.apache.tomcat.util.codec.binary.Base64;

public class Cryptography {

    private SecretKeySpec secretKey;
    private byte[] key;

    public void setKey() {
        MessageDigest sha;
        try {
            String myKey = "s041010XSQxm9zobewQKupvUdr6qJKxr5moqxCugO07T2os0410101SihKwDcxambqlXXrJLOO2yPVj6uQA8ZlJRf5ZawRhVe54h5ExXkxAYaZR3u98DB4fduPgRfZwLrKzIgPPj6ug98qfiaUicP9u2QhUuYx67dDLtpymwVKCEDyYWpffJ0PnrFkg9NRvDU6Mnf8ZpJpEqL38nPwz03hluakWtHV33mF0oq6GQjr4yauS4YvA5EQ9FCLaaS0AipjOQNBkBR10tNnReyGaUV0Dkee8jkUfKNNHmwqqhiy59mxqNz9BGVQelISTvMw6sfO1efkfWMpBzbnJ0caKoqKpDIcD2POROAJKWLdbKQFt8jSSIGLbwDLykOaALPD3YwYWFEK2UudeI5hCnBsVCifXvRhjHA23Z1x7Cg7TjfkEViWr4Ia50SptRn0LxqbboOxdtbdTEi3BJVcaKGdWBvqyM73qiR2msNQcn3Ix2etRh7yK2RkTfLks041010papYPqfCDpiaLaP5OvV23k8dRyGvDHjyERZbwOqtPzBq8SkUpgmQl3JqqAcjYnHbKQpJ6Y7i2Ltn4vIGElSUmPPaonJOixyPzSTX9YnqB098fNl5mlyPUjv5qnVPoMkJeQ23M7FSIAoHBRvCYyB4C3c5bWUxogiZt0AZUoXWqqNw6QZzxxNTdg5CfTckvNiw2WhNlpgihVEePSF16VIR4pShlPKPlS6WdOgA1iRHNPOmbOMktmDzQ0o3DIFqKktgKuL";
            key = myKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, "AES");
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
        }
    }

    public String encrypt(String strToEncrypt) {
        if ((strToEncrypt==null)||(strToEncrypt.isEmpty())) return null;
        try {
            setKey();
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.encodeBase64String(cipher.doFinal(strToEncrypt.trim().getBytes("UTF-8"))).replace("=", "");
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | UnsupportedEncodingException | IllegalBlockSizeException | BadPaddingException e) {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }

    public String encodeURL(String url) {
        if ((url==null)||(url.isEmpty())) return null;
        String encodedURL = null;
        try {
            encodedURL = java.net.URLEncoder.encode(url, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Cryptography.class.getName()).log(Level.SEVERE, null, ex);
        }
        return encodedURL;
    }

    public String decrypt(String strToDecrypt) {
        if ((strToDecrypt==null)||(strToDecrypt.isEmpty())) return null;
        try {
            setKey();
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.decodeBase64(strToDecrypt.trim())));
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }

    public String decodeURL(String url) {
        if ((url==null)||(url.isEmpty())) return null;
        String decodedURL = null;
        try {
            decodedURL = java.net.URLDecoder.decode(url, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Cryptography.class.getName()).log(Level.SEVERE, null, ex);
        }
        return decodedURL;
    }

}
