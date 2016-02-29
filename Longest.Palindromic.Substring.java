public class Solution {
    private int maxlength = 1;
    private int maxstart = 0;
    public String longestPalindrome(String s) {
        int n = s.length();
        for(int i = 0; i < n; i++){
            find(s, i, 0, n);
            find(s, i, 1, n);
        }
        return s.substring(maxstart, maxstart + maxlength);
    }
    private void find(String s, int i, int shift, int n){
        int left = i;
        int right = i + shift;
        while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)){
            if(maxlength < right - left + 1){
                maxlength = right - left + 1;
                maxstart = left;
            }
            left--;
            right++;
        }
    }
}