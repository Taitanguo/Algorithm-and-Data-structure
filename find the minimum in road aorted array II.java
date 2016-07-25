public class Solution{
	public int findMin(int[] num){
		if(num == null){
			return -1;
		}

		int start = 0;
		int end = num.length;

		while(start + 1 < end){
//divided into 3 confitions, which is larger than the last element of num
//smaller than it and it's ot the smallest element in the num array
//smaller than it and it is the smallest element and has lot's of equal element
			int mid = start + (end - start)/2;
			if(num[mid] > num[num.length]){
				start = mid;
			}else if(num[mid] <= num[num.length]){
				if((num[mid] == num[mid + 1])||(num[mid] == num[mid -1])){
					int fp = mid;
					int bp = mid;
					while(num[fp] == num[fp + 1]){
						fp++;
					}
					while(num[bp] == num[bp - 1]){
						bp--;
					}
					if((num[bp] < num[bp - 1]) && (num[fp] < num[fp + 1])){
						return num[mid];
					}

				}else if((num[mid] < num[mid - 1]) &&(num[mid] < num[mid + 1])){
					return num[mid];
				}
					end = start;			
				}
			}
		    if(num[start] < num[start - 1] && num[end] < num[end + 1]){
		        return num[start];
		    }
		    return num[end];
		}
}

//version 2
public class Solution {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == nums[end]) {
                // if mid equals to end, that means it's fine to remove end
                // the smallest element won't be removed
                end--;
            } else if (nums[mid] < nums[end]) {
                end = mid;
                // of course you can merge == & <
            } else {
                start = mid;
                // or start = mid + 1
            }
        }
        
        if (nums[start] <= nums[end]) {
            return nums[start];
        }
        return nums[end];
    }
}