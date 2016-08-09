public class Solution {
    /**
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(ArrayList<Integer> nums) {
        // write your code
        int len = nums.size();
        int[] localMin = new int[len];
        int[] globalMin = new int[len];

        for(int i = 0; i < len; i++){
            if(i == 0){
                //initialization
                localMin[i] = nums.get(i);
                globalMin[i] = nums.get(i);
            }else{
                localMin[i] = Math.min(localMin[i - 1] + nums.get(i), nums.get(i));
                globalMin[i] = Math.min(globalMin[i - 1], localMin[i]);
            }
        }
        return globalMin[len - 1];
    }
}
