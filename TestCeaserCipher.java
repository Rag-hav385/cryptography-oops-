import edu.duke.*;
/**
 * Write a description of TestCeaserCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestCeaserCipher {
    
    public int[] CountLetters(String message){
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        int[] count = new int[26];
        
        for(int i = 0 ; i < message.length() ; i = i+1){
            char ch = Character.toLowerCase(message.charAt(i));
            int dex = alpha.indexOf(ch);
            
            if(dex !=-1){
                count[dex] += 1; 
            }
        }
        return count;
    }
    
    public int maxIndex(int[] val){
        int maxdex = 0;
        for(int i = 0 ; i < val.length; i++){
            if(val[i] > val[maxdex]){
                maxdex = i;
            }
        }
        return maxdex;
    }
    
    public void simpleTest(){
        FileResource fr = new FileResource();
        String f_content = fr.asString();
        CeaserCipher cc = new CeaserCipher(18);
        System.out.println("ENCRYPTED : " + cc.encrypt(f_content));
        
        System.out.println("DECRYPTING....");
        
        System.out.println(cc.decrypt(f_content));
    }
    
    public int getKey(String encrypt){
    int[] freq = CountLetters(encrypt);
        int maxdex = maxIndex(freq);
        int dkey = maxdex - 4;
        
        if(maxdex < 4){
            dkey = 26-(4 - maxdex);
        }
        
    return dkey;
}

    public String breakCaesarCipher(String phrase){
        int key = getKey(phrase);
        CeaserCipher cc = new CeaserCipher(key);
        System.out.println("key :" +  key);
        return cc.decrypt(phrase);
    }
    
    public void simpletest2(){
        FileResource fr = new FileResource();
        String f_content = fr.asString();
        String decrypt = breakCaesarCipher(f_content);
        
        System.out.println(decrypt);
    }


}
