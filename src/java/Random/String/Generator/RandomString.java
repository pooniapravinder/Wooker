package Random.String.Generator;

import java.util.Date;
import java.util.Random;

public class RandomString{
    
private final Random random = new Random((new Date()).getTime());
public String generateRandomString(int length){
char[] values = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q',
    'r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K',
    'L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','0','1','2','3','4',
    '5','6','7','8','9','.','/','%','$','&'};
String out = "";
for(int i=0;i<length;i++){
int idx = random.nextInt(values.length);
out += values[idx];
}
return out;
}
public String generateRandomAlphaNumeric(int length){
char[] values = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q',
    'r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K',
    'L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','0','1','2','3','4',
    '5','6','7','8','9'};
String out = "";
for(int i=0;i<length;i++){
int idx = random.nextInt(values.length);
out += values[idx];
}
return out;
}
    public String RandomString(int length){
        char[] values = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','0','1','2','3','4','5','6','7','8','9','-','_'};
        String out = "";
        for(int i=0;i<length;i++){
            int idx = random.nextInt(values.length);
            out += values[idx];
        }
        return out;
    }

}