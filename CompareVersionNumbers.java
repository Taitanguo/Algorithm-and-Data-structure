public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] l1 = version1.split("\\.");
        String[] l2 = version2.split("\\.");
        for(int i = 0; i < Math.max(l1.length, l2.length); i++){
            int gap = (i < l1.length? Integer.parseInt(l1[i]) : 0) - (i < l2.length? Integer.parseInt(l2[i]) : 0);
            if(gap != 0){
                return (gap > 0? 1 : -1);
            }
        }
        return 0;
    }
}