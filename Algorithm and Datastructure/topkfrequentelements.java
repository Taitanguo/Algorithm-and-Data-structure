// 1. 将全部元素放到 Hashtable 里面，统计各个元素的出现次数

// 2. 将 Hashtable 里面的全部 Entry 拷贝一份到 List<Entry> 里面

// 3. 根据元素出现次数的值，对 List<Entry> 里面的元素进行排序

// 4. 将 List<Entry> 中出现次数的值最最大的前 k 个拷贝到一个新的 List<Integer> 中，得到结果


import static java.lang.System.out;

import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

public class Solution {
    
    class Compartr implements Comparator<Entry<?, Integer>>{

        @Override
        public int compare(Entry<?, Integer> o1, Entry<?, Integer> o2) {
            return o2.getValue().compareTo(o1.getValue());
        }
    }
    
    public List<Integer> topKFrequent(int[] nums, int k) {
        Hashtable<Integer, Integer> key_cnt = new Hashtable<Integer, Integer>();
        
        for(int key : nums){
            if(key_cnt.containsKey(key)){
                key_cnt.put(key, (Integer)key_cnt.get(key) + 1 );
            }else{
                key_cnt.put(key, 1);
            }
        }        
        
        List<Entry<Integer, Integer>> list = new LinkedList<Entry<Integer, Integer>>(key_cnt.entrySet());

        Compartr cpr = new Compartr();
        Collections.sort(list, cpr);
        
        list.subList(k, list.size()).clear();
        
        List<Integer> res = new LinkedList<Integer>();

        Iterator<Entry<Integer, Integer>> iter = list.iterator();
        
        int tmpk = k;
        while(iter.hasNext() && tmpk > 0){
            Entry<Integer, Integer> entry = iter.next();
            res.add(entry.getKey());
        }
        
        return res;
    }
}