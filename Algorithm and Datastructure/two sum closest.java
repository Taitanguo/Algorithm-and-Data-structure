// Given an array nums of n integers, find two integers in nums such that the sum is closest to a given number, target.

// Return the difference between the sum of the two integers and the target
//using two pointer solve this question
//once find a good position then upadate corresponding min

public class Solution{
	public int twoSumCloset(int[] nums, int target){
		Arrays.sort(nums);
		int i = 0;
		int j = nums.length - 1;
		int min = Integer.MAX_VALUE;

		while(i < j){
			if(nums[i] + nums[j] > target){
				if((nums[i] + nums[j]) - target < min){
					min = (nums[i] + nums[j]) - target;
				}
				j--;
			}
			else{
				if(target - (nums[i] + nums[j]) < min){
					min = target - (nums[i] + nums[j]);
				}
				i++;
			}
		}
		return min;
	}
}