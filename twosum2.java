import java.util.ArrayList;
import java.util.HashMap;

public class twosum {
	private static void twosums(int[] nums, int target){
		if(nums == null || nums.length == 0){
			return;
		}
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		for(int i = 0; i < nums.length; i++){
			if(map.containsKey(target - nums[i])){
				for(int j : map.get(target - nums[i])){
					System.out.println(i + " " + j);
				} 
			}
			if(!map.containsKey(nums[i])){
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.add(i);
				map.put(nums[i], temp);
			}
			else{
				map.get(nums[i]).add(i);
			}
		}
	}
	
	public static void main(String[] args){
		int[] nums = {1,2,2,3,3,4,6,2,7,8,5,4,6,3,2};
		twosums(nums, 5);
	}
}
