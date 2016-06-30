//Find a number's index in a Array A[] which is closest to it 
//target

public class Solution{
	public int closestNumber(int[] A, int target){
		int start = 0;
		int end = A.length - 1;

		while(start + 1 < end){
			int mid = (start + end)/2;
			if(A[mid] == target){
				return mid;
			}else if(A[mid] < target){
				start = mid;
			}else{
				end = mid;
			}
		}
		int mins = target - A[start];
		int mine = target - A[end];
		if(Math.abs(mins) > Math.abs(mine)){
			return end;
		}else{
			return start;
		}
}
}