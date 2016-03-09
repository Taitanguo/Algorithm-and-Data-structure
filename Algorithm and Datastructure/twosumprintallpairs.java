Public class Solution{
    public static  void pair2sum(int A[], int target){
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>;
        if(A[] == null || A.length() == 0){
            System.out.println("no result");
        }

        for(int a : A){
            if(hash.containKey(a)){
                hash.put(a, hash.get(a) + 1);
            }
            hash.put(a, 1);
        }

        for(int a : A){
            if(hash.containKey(target - a)){
                if(hash.get(a) >= 1 && hash.get(target - a) >= 1){
                System.out.println(a, target - a);
                hash.put(a, hash.get(a) - 1);
                hash.put(target - a, hash.get(target - a) - 1);
            }
            }
        }
    }
}