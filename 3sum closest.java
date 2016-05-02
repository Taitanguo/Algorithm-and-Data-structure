public class Solution{
    public int threeSumClosest(int[] numbers, int target){
       if(numbers == null || numbers.length < 3){
        return Integer.MAX_VALUE;
       }
       Arrays.sort(numbers);
       int closet = Integer.MAX_VALUE / 2;// otherwise it will oevrflow for operation(closet - target)
       for(int i = 0; i < numbers.length - 2; i++){
            int left = i + 1;
            int right = numbers.length - 1;
            while(left < right){
                int sum = numbers[i] + numbers[left] + numbers[right];
                if(sum == target){
                    return sum;
                } else if(sum < target){
                    left++;
                }else{
                    right--;
                }
                closet = Math.abs(sum - target) < Math.abs(closet - target) ? sum : closet;
                }
            }
            return closet;
       }
}