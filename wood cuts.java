public class Solution{
	public int woodCut(int[] L, int k){
		//find the maximum length in all woods
		int max = 0;
		for(int i = 0; i <= L.length; i++){
			max = Math.max(max, L[i]);
		}

		//find the maximum length of the cuts and gurantte number of cuts bigger than requirement

		int start = 1;
		int end = max;
		while(start + 1 < end){
			int mid = start + (end - start)/2;
			//satisfy the requirement, then increase the mid value
			if(count(L, mid) >= k){
				start = mid;
			}else{
				end = mid;
			}
		}

		if(count(L, end) >= k){
			return end;
		} 

		if(count(L, start) >= k){
			return start;
		}

		return 0;

	}
	private int count(int L[], int length){
		int sum = 0;
		for(int i = 0; i <= L.length; i++){
			sum += L[i]/length;
		}
		return sum;
	}
}