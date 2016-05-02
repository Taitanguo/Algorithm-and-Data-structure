public static class Solution{
    public static int findOdd(int[] A){
        if(A.size() == 0 || A == null){
            return -1;
        }

        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();

        for(int a : A){
            if(hash.containsKey(a)){
                hash.put(a, hash.get(a) + 1);
            }
            hash.put(a, 1);
        }

        for(int a : A){
            if(hash.get(a) % 2 != 0){
                return a;
            }
        }
    }
}

//time complexity O(n)

//find maximum

public static class Solution{
    public static int finMaximum(int[] A){
        if(A.size() == 0 || A == null){
            return -1;
        }
        
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        
        for(int a : A){
            if(hash.containsKey(a)){
                hash.put(a, hash.get(a) + 1);
            }
            hash.put(a, 1);
        }
        int max = 0;
        for(int a : A){
            if(hash.get(a) >= max){
                max = hash.get(a);
            }
        }
        
        return max;
    }
}