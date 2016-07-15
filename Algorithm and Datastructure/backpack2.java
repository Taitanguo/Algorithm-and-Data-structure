// Given n items with size Ai and value Vi, and a backpack with size m. What's the maximum value can you put into the backpack?

public class Solution{
	public int backpackII(int m, int[] A, int V[]){
		//difinition
		//the value of i size things 
		int[] f = new int[m + 1];
		//initialize
		for(int i = 0; i <= m; ++i){
			f[i] = 0;
		}
		int n = A.length, i, j;
		//dynamic
		//try every items and then update every f [] n times 
		for(i = 0; i < n; i++){
			for(j = m; j >= A[i]; j--){
				if(f[j] < f[j - A[i]] + v[i]){
					f[j] = f[j - A[i]] + v[i];
				}
			}
		}

		return f[m];
	}
}