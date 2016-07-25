//Given a target number, a non-negative integer k and an integer array A sorted in ascending order, find the k closest numbers to target in A, sorted in ascending order by the difference between the number and target. Otherwise, sorted in ascending order by number if the difference is same.


//Solution 1: use the binary search k times, to find all k results
//time complxity is K*log(N)
public class Solution{
	public int[] kClosestNumbers(int[] A, int target, int k){
		if(A == null){
			return A;
		}
		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<Integer> results = new ArrayList<Integer>();

		for(int i = 0; i < A.length; i++){
			a.add(A[i]);
		}

		for(int i = 0; i < k; i++){
			int result = findClosest(target, a);
			results.add(result);
			a = a.remove(result);
		}

		return Collection.sort(results);
	}

	private int findClosest(int target, ArrayList<integer> a){
		int start = 0;
		int end = a.size();

		while(start + 1 < end){
			int mid = (start + end)/2; 
			if(a.get(mid) == target){
				return mid;
			}else if(a.get(mid) < target){
				start = mid;
			}else{
				end = mid;
			}
		}

		diffS = Math.abs(a.get(start) - target);
		diffe = Math.abs(a.get(end) - target);
		if(diffe < diffS){
			return end;
		}else{
			return start;
		}
	}

}

//Solution2: using binary search find the closest number, mark start and end index which is start = index, end = index - 1 time:(Log(N))
//Then expand the search range from this start and end. compare K times to find out all K closest indexs. 
//Time complexity is K + log(N)
public class Solution {
    /**
     * @param A an integer array
     * @param target an integer
     * @param k a non-negative integer
     * @return an integer array
     */
    public int[] kClosestNumbers(int[] A, int target, int k) {
        int[] result = new int[k];
        
        if (A == null || A.length == 0) {
            return A;
        }
        if (k > A.length) {
            return A;
        }
        
        int index = firstIndex(A, target);
        
        int start = index - 1;
        int end = index;
        for (int i = 0; i < k; i++) {
            if (start < 0) {
                result[i] = A[end++];
            } else if (end >= A.length) {
                result[i] = A[start--];
            } else {
                if (target - A[start] <= A[end] - target) {
                    result[i] = A[start--];
                } else {
                    result[i] = A[end++];
                }
            }
        }
        return result;
    }
    
    private int firstIndex(int[] A, int target) {
        int start = 0, end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] < target) {
                start = mid;
            } else if (A[mid] > target) {
                end = mid;
            } else {
                end = mid;
            }
        }
        
        if (A[start] >= target) {
            return start;
        }
        if (A[end] >= target) {
            return end;
        }
        return A.length;
    }
}