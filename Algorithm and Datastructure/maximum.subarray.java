public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        //state sum[i] has the maximum subsum until i
        //sum[i] = Math.max(sum[i-1] + nums[i], sum[i-1])
        int n = nums.length;
        int[] sumuntilnow = new int[n];//that one scan every subarry untill now which has the biggest sum which include nums[i]
        int[] sumsofar     = new int[n];
        //initialization
        sumuntilnow[0] = nums[0];
        sumsofar[0] = nums[0];

        //function
        for(int i = 1; i < n; i++){
            sumuntilnow[i] = Math.max(sumuntilnow[i-1] + nums[i], nums[i]);//找到现在的最大的小弟 加了nums前面的还是不加 保证是连续的
            sumsofar[i] = Math.max(sumuntilnow[i], sumsofar[i - 1]);
            //比较最大的小弟 和以前的
        }
        return sumsofar[n-1];
    }
}