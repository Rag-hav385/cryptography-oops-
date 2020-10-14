
/**
 * Write a description of CeaserCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CeaserCipher {
        //Fields//
        private String Test_C;
        private String Test_S;
        private String shifted_C;
        private String shifted_S;
        private int dkey;
        //Constructor//
        public CeaserCipher(int key){
            String Test_C = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String Test_S = "abcdefghijklmnopqrstuvwxyz";
            String shifted_C = Test_C.substring(key) + Test_C.substring(0 , key);
            String shifted_S = Test_S.substring(key) + Test_S.substring(0 , key);
            int dkey =  key;
        }
        
        //Method1//
        public String encrypt(String phrase){
            StringBuilder ph = new StringBuilder(phrase);
            
            for (int i = 0 ; i < phrase.length() ; i = i + 1){
            char currChar = ph.charAt(i);
            int idx_C = Test_C.indexOf(currChar);
            int idx_S = Test_S.indexOf(currChar);
            if(idx_C !=-1 && Character.isUpperCase(currChar)){
                char new_char = shifted_C.charAt(idx_C);
                
                ph.setCharAt(i , new_char);
            }
            
            if(idx_S !=-1 && Character.isLowerCase(currChar)){
                char new_char = shifted_S.charAt(idx_S);
                
                ph.setCharAt(i , new_char);
            }
        }
        return ph.toString();
   }
    
    //method2//
        public String decrypt(String phrase){
        CeaserCipher cc = new CeaserCipher(26 - dkey);
        return cc.encrypt(phrase);
        
    }
    
}
        
        


