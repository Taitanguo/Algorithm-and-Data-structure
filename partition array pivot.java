public class Solution{
    public int partitionArray(int nums[], int k){
        if(nums == null || nums.length == 0){
            return 0;
        }

        int i = 0;
        int j = nums.length - 1;
            for(; i <= j; i++){
                if(nums[i] < k){
                    continue;
                }
                while(j >= i && nums[j] >= k){
                    j--;
                }
                //at this time
                //i points to number >= k
                //j points to a number < k
                //swap i and j
                if(j >= 0 && i < j){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    j--;
                }
            }//end for
            return j + 1;
    }
}