public class Solution {
    public int trap(int[] height) {
        int secheight = 0;
        int left = 0;
        int right = height.length - 1;
        int s = 0;
        while(left < right){
            if(height[left] < height[right]){
                secheight = Math.max(secheight, height[left]);
                s += secheight - height[left];
                left++;
            }
            else{
                secheight = Math.max(secheight, height[right]);
                s += secheight - height[right];
                right--;
            }
        }
        return s;
    }
}