public class solution{
public static int[] 2sum(int[] a, int target){
    int[] result = new int[2];
       if( a.length == 0 || a == null){
        return result;
        }

    Map<Integer, Integer> hash = new HashMap<Interger, Integer>();
    int length = a.length;

    for(int i = 0; i < length; i++){
        if(hash.containsKey(target - a[i])){
            retult[0] = hash.get(target - a[i]) + 1;
            result[1] = i + 1;
            break;
        }
        hash.put(a[i], i);
    }

    return result;
}
}