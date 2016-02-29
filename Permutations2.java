public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        if(nums == null){
            return result;
        }
        Arrays.sort(nums);
        int[] visited = new int[nums.length];
        help(nums, result, visited, list);
        return result;
    }
    private void help(int[] nums, List<List<Integer>> result, int[] visited, List<Integer> list){
        if(list.size() == nums.length){
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(visited[i] == 1 || (i != 0 && nums[i] == nums[i - 1] && visited[i - 1] == 0)){
                continue;
            }
            visited[i] = 1;
            list.add(nums[i]);
            help(nums, result, visited, list);
            list.remove(list.size() - 1);
            visited[i] = 0;
        }
    }
}