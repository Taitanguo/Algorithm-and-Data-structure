public class Solution {
    public int missingNumber(int[] nums) {
        int xor = 0, i; 
        //����򣬽�index��value��ͬʱ��򣬳ɶԵ�index��value������Ժ��Ϊ0��Ҳ�����໥�����ˣ�ʣ�µ�����forѭ�����i�����ǽ��
        for(i = 0; i < nums.length; i++){ 
            xor = xor ^ i ^ nums[i];
        }
        return xor ^ i;
    }
}