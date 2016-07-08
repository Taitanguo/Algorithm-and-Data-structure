public class Solution{
	public int search(int[] A, int target){
		if(A == null || A.length == 0){
			return -1;
		}

		int start = 0;
		int end = A.length;

		while(start + 1 < end){
			int mid = start + (end - start)/2;
			if(A[mid] == target){
				return mid;
			} 
			//if target and mid in the first line
			if(A[mid] > A[start]){
				if(A[mid] >= target && target >= A[start]){
					end = mid;
				}else{
					start = mid;
				}
			}else{// mid in the green line
				if(A[mid] <= target && target <= A[start]){
					start = mid;
				}else{
					end = mid;
				}
			}
		}
		if(A[start] == target){
			return start;
		}
		if(A[end] == target){
			return end;
		}

		return -1;
	}
}