//f[i] means sum from f[0] - f[i] sum array s, then then the minimum difference between two consecutive element is the subarray

class Pair{
    int sum;
    int index;
    public Pair(int s, int i){
        sum = s;
        index = i;
    }
}

public class Solution{
    public int[] subarraySumClosest(int[] nums){
        int[] res = new int[2];
        // special condition judge
        if(nums == null || nums.length == 0){
            return res;
        }

        int len = nums.length;
        if(len == 1){
            res[0] = res[1] = 0;
            return res;
        }
        //get the sum of all list O(N)
        Pair[]sums = new Pair[len + 1];
        int prev = 0;
        sums[0] = new Pair(0,0);
        for(int i = 1; i <= len; i++){
            sums[i] = new Pair(prev + nums[i - 1], i);
            prev = sums[i].sum;
        }

        //sort the array after get sum ascending O(Nlog(N))
        Arrays.sort(sums, new Comparator<Pair>(){
            public int compare(Pair a, Pair b){
                return a.sum - b.sum;
            }
        });
        // get the smallest difference between consective sums O(N)
        int ans = Integer.MAX_VALUE;
        for(int i = 1; i <= len; i++){
            if(ans > sums[i].sum - sums[i - 1].sum){
                ans = sums[i].sum - sums[i - 1].sum;
                int[] temp = new int[]{sums[i].index - 1, sums[i - 1].index - 1};
                Arrays.sort(temp);
                res[0] = temp[0] + 1;
                res[1] = temp[1];
            }
        }

        return res;
    }
}