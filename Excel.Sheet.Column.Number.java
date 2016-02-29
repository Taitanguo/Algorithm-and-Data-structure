public class Solution {
    public int titleToNumber(String s) {
        int sum = 0;
        int a = 0;
        for(int i = 0; i < s.length(); i++){
            a = s.charAt(i) - 'A' + 1;
            sum = sum * 26 + a;
        }
        return sum;
    }
}