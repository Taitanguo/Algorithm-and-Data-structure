public class Solution {
    /**
     * @param s a string,  encoded message
     * @return an integer, the number of ways decoding
     */
    public int numDecodings(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        //definition f[i] represent the ways to decode message in the size of i
        int[] f = new int[s.length() + 1];
        //initialization
        f[0] = 1;
        f[1] = s.charAt(0) != '0' ? 1 : 0;
        
        for(int i = 2; i <= s.length(); i++){
        // only increase ways of decoding by one
        if(s.charAt(i - 1) != '0' ){
            f[i] = f[i - 1];
        }
        int twoDigits = (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0');
        if(twoDigits >= 10 && twoDigits <= 26){
            f[i] += f[i - 2];
        }
        }
        
        return f[s.length()];
    }
} 