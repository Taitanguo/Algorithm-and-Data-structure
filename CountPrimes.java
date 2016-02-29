public class Solution {
    public int countPrimes(int n) {
        Boolean[]  isPrime = new Boolean[n];//虽然长度为n，但是有效使用是n-1
        for(int i = 2; i < n; i++){ //从index = 2开始，因为之前都是无用的
            isPrime[i] = true;
        }
        for(int i = 2; i * i < n; i++){
            if(!isPrime[i]) continue; //如果基数已经变成了false，那么就skip掉，然后从下一个基数开始
            for(int j = i * i; j < n; j += i){
                isPrime[j] = false;
            }
        }
        int count = 0;
        for(int i = 2; i < n; i++){
            if(isPrime[i]) count++;
        }
        return count;
    }
}