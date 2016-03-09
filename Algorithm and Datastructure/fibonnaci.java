class Solution {
    /**
     * @param n: an integer
     * @return an integer f(n)
     */
    public int fibonacci(int n) {
        if(n == 1){
            return 0;
        }
        if(n == 2){
            return 1;
        }
        int[] f = new int[n];
        f[0] = 0;
        f[1] = 1;
        int i = 2;
        while(i < n){
            f[i] = f[i - 1] + f[i - 2];
            i++;
        }

        return f[n-1];
    }
}
// O(n)

class Solution{
public int fibonacci(int n){
    if(n == 1){
        return 0;
    }
    if(n == 2){
        return 1;
    }
    return helper(n);

}

private int helper(int n){
    if(n == 1){
        return 0;
    }
    if(n == 2){
        return 1;
    }
    int result = helper(n-1) + helper(n-2);
    return result;
}
}
