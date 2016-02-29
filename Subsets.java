public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        int totalNumber = 1 << nums.length;
        List<List<Integer>> collection = new ArrayList<List<Integer>>(totalNumber);
        for (int i=0; i<totalNumber; i++) {
            List<Integer> set = new LinkedList<Integer>();
            for (int j=0; j<nums.length; j++) {
                if ((i & (1<<j)) != 0) {
                    set.add(nums[j]);
                }
            }
            collection.add(set);
        }
        return collection;
    }
}





public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        if(nums == null){
            return null;
        }
        result.add(temp);
        Arrays.sort(nums);
        dfs(result, temp, 0, nums);
        return result;
    }
    public void dfs(List<List<Integer>> result, List<Integer> temp, int start, int[] nums){
        for(int i = start; i < nums.length; i++){
            temp.add(nums[i]);
            result.add(new ArrayList<Integer>(temp));
            dfs(result, temp, i + 1, nums);
            temp.remove(temp.size()- 1);
        }
    }
}