public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        int len = nums.length;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        hash.put(0, -1);
        int sum = 0;
        for(int i = 0; i < len; i++){
            sum = sum + nums[i];
            if(hash.containsKey(sum)){
                ans.add(hash.get(sum) + 1);
                ans.add(i);
                return ans;
            }
            hash.put(sum, i);
        }
        return ans;

    }
}