public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        permutation(result, list, nums);
        return result;
    }
    public void permutation(List<List<Integer>> result, List<Integer> list, int[] nums){
        if(list.size()== nums.length){
            result.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(list.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);
            permutation(result, list, nums);
            list.remove(list.size() - 1);
        }
    }
}