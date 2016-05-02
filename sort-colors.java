class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        int first = 0;
        int i = 0;
        int last = nums.length - 1;

        while(i <= last){
            if(nums[i] == 0){ //this position only could be 0 or 1
                swap(nums, i, first);
                first++;
                i++;
            }else if(nums[i] == 1){
                i++;
            }else{
                swap(nums, i, last); //if nums[i] == 2 扔到后面 i 不动再判断
                last--;
            }
        }
}
    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
