public class Solution {
    public int kthLargestElement(int k, int[] nums ) {
        int start = 0, end = nums.length - 1, index = nums.length - k;
        while (start < end) {
            int pivot = partion(nums, start, end);
            //equals to binary search,
            if (pivot < index) start = pivot + 1;
            else if (pivot > index) end = pivot - 1;
            else return nums[pivot];
        }
        return nums[start];
    }


    private int partion(int[] nums, int start, int end) {
        int pivot = start, temp;// take start as the pivot position,just make a guess
        //use nums[start] as the partition value then partition whole nums
        while (start <= end) {
            while (start <= end && nums[start] <= nums[pivot]) start++;
            while (start <= end && nums[end] > nums[pivot]) end--;
            if (start > end) break;
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
        //end is the position of pivot then change the value of nums[end] and nums[pivot]
        //then end points at the pivot value, return end
        temp = nums[end];
        nums[end] = nums[pivot];
        nums[pivot] = temp;
        return end;
    }
}

// time complexity: best situation n and the worst is n to 2;