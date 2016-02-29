
import java.util.HashMap;
import java.util.Map;

public class UniqueElement {
	private static void unique(int[] arr){
		/*if(arr == null || arr.length == 0){
			return;
		}
		Arrays.sort(arr);
		if(arr[0] != arr[1]) System.out.print(arr[0]);
		for(int i = 1; i < arr.length - 1; i++){
			if(arr[i] != arr[i - 1] && arr[i] != arr[i + 1]){
				System.out.print(arr[i]);
			}
		}
		if(arr[arr.length - 1] != arr[arr.length - 2]) System.out.print(arr[arr.length - 1]);
		*/
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i : arr){
			if(map.containsKey(i)){
				map.put(i, map.get(i) + 1);
			}else{
				map.put(i, 1);
			}
		}
		for(Map.Entry<Integer, Integer> entry : map.entrySet()){
			if(entry.getValue() == 1){
				System.out.print(entry.getKey());
			}
		}
	}
	public static void main(String[] args){
		int[] a = {2,3,5,4,4,1,2,6,9,8,7,5,1,3};
		unique(a);
	}
}
