public class Solution {
    public int missingNumber(int[] nums) {
        int xor = 0, i; 
        //用异或，将index和value都同时异或，成对的index和value在异或以后就为0，也就是相互抵消了，剩下的再与for循环后的i异或就是结果
        for(i = 0; i < nums.length; i++){ 
            xor = xor ^ i ^ nums[i];
        }
        return xor ^ i;
    }
}