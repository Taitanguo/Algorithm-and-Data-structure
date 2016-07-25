// 本题是典型的01背包问题，每种类型的物品最多只能选择一件。先来看看 九章算法 的### 题解

// 状态: result[i][S] 表示前i个物品，取出一些物品能否组成体积和为S的背包
// 状态转移方程: f[i][S]=f[i−1][S−A[i]] or f[i−1][S] (A[i]为第i个物品的大小)
// 欲从前i个物品中取出一些组成体积和为S的背包，可从两个状态转换得到。
// f[i−1][S−A[i]]: 放入第i个物品，前 i−1 个物品能否取出一些体积和为 S−A[i] 的背包。
// f[i−1][S]: 不放入第i个物品，前 i−1 个物品能否取出一些组成体积和为S的背包。
// 状态初始化: f[1⋯n][0]=true; f[0][1⋯m]=false. 前1~n个物品组成体积和为0的背包始终为真，其他情况为假。
// 返回结果: 寻找使 f[n][S] 值为true的最大S (1≤S≤m)

public class Solution{
	public int backPack(int m, int[] A){
		//definition of f
		boolean f[][] = new boolean[A.length + 1][m + 1];
		//initialize
		for(int i = 0; i <= A.length; i++){
			for(int j = 0; j <= m; j++){
				f[i][j] = false;
			}
		}

		f[0][0] = true;
		//dynamic core
		for(int i = 0; i < A.length; i++){
			for(int j = 0; j <= m; j++){
				//if we dont need A[j] to fill j which means A[i] can fill j already A[i + 1] is useless
				f[i + 1][j] = f[i][j];
				//if f[i + 1][j] == false which means A[i + 1] is needed
				if(j >= A[i] && f[i]f[j - A[i]]){
					f[i+1][j] = true;
				}
			}
		}
		//return result
		for(int i = m; i >= 0; i--){
			if(f[A.length][i]){
				return i;
			}
		}

		return 0;
	}
}
}