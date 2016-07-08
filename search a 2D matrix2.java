//[
//[1, 3, 5, 7],
//[2, 4, 7, 8],
//[3, 5, 9, 10]
//]
//time complexity N
public class Solution{
	public int searchMatrix(int[][] matrix, int target){
		//check coner case
		if(matrix == null || matrix.length == 0){
			return 0;
		}

		if(matrix[0] == null || matrix[0].length == 0){
			retrun 0;
		}

		//Check from bottom left to top right
		int n = matrix.length;
		int m = matrix[0].length;
		int x = n -1;
		int y = 0;
		int count = 0;

		while(x >=0 && y < m){
			if(matrix[x][y] < target){
				y++;
			}else if(matrix[x][y] > target){
				x--;
			}else{
				count++;
				x--;
				y++;
			}
		}

		return count;
	}
}