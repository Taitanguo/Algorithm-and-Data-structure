public class Solution {
    public int singleNumber(int[] nums) {
        //�����ͬΪ0����ͬΪ1
        int result = nums[0];
        for(int i = 1; i < nums.length; i++){
            result = result ^ nums[i]; //��ͬ�������Ϊ0�������������ʣ���Ǹ�single number��
        }
        return result;
    }
}