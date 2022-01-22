package cookies.set.get;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import org.apache.tomcat.util.codec.binary.Base64;

public class CookieEncryptorDecryptor{
    private static SecretKeySpec secretKey ;
    private static byte[] key ;
    private static String decryptedString;
    private static String encryptedString;
    
    public static void setKey(String myKey){
    	MessageDigest sha = null;
		try {
		key = myKey.getBytes("UTF-8");
		sha = MessageDigest.getInstance("SHA-1");
		key = sha.digest(key);
	    	key = Arrays.copyOf(key, 16);
		secretKey = new SecretKeySpec(key, "AES");
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
		}
    }
    
    public static String getDecryptedString() {
		return decryptedString;
	}
	public static void setDecryptedString(String decryptedString){
		CookieEncryptorDecryptor.decryptedString = decryptedString;
	}
    public static String getEncryptedString() {
		return encryptedString;
	}
	public static void setEncryptedString(String encryptedString){
		CookieEncryptorDecryptor.encryptedString = encryptedString;
	}
        
	public static String encrypt(String strToEncrypt){
        try{
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            setEncryptedString(Base64.encodeBase64String(cipher.doFinal(strToEncrypt.getBytes("UTF-8"))));
        }
        catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | UnsupportedEncodingException | IllegalBlockSizeException | BadPaddingException e){
            System.out.println("Error while encrypting: "+e.toString());
        }
        return null;
    }

    public static String decrypt(String strToDecrypt){
        try{
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
           cipher.init(Cipher.DECRYPT_MODE, secretKey);
            setDecryptedString(new String(cipher.doFinal(Base64.decodeBase64(strToDecrypt))));
        }
        catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e){
         System.out.println("Error while decrypting: "+e.toString());
        }
        return null;
        }
}
