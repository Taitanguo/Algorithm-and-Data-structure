import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class SameElements2 {
	private static List<String> find(ArrayList<ArrayList<String>> list){
		ArrayList<String> res = new ArrayList<String>();
		if(list == null || list.size() == 0)return res;
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(String s : list.get(0)) map.put(s, map.containsKey(s)?map.get(s) + 1:1);
		for(int i = 1; i < list.size(); i++){
			Map<String, Integer> temp = new HashMap<String, Integer>();
			for(String s : list.get(i)){
				if(map.containsKey(s) && map.get(s) > 0){
					temp.put(s, temp.containsKey(s)?temp.get(s) + 1 : 1);
					map.put(s, map.get(s) - 1);
				}
			}
			map = temp;
		}
		for(Map.Entry<String, Integer> entry : map.entrySet()){
			for(int i = 0; i < entry.getValue(); i++)
				res.add(entry.getKey());
		}
		return res;
	}
	public static void main(String[] args){
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		ArrayList<String> list1 = new ArrayList<String>();
		ArrayList<String> list2 = new ArrayList<String>();
		ArrayList<String> list3 = new ArrayList<String>();
		list1.add("aa");
		list1.add("aa");
		list1.add("aa");
		list1.add("ba");
		list1.add("ca");
		list1.add("ta");
		list2.add("aa");
		list2.add("aa");
		list2.add("ca");
		list3.add("aa");
		list3.add("aa");
		list3.add("ta");
		list3.add("ca");
		list.add(list1);
		list.add(list2);
		list.add(list3);
		for(String s : find(list)){
			System.out.println(s);
		}
	}
}
