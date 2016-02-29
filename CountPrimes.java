public class Solution {
    public int countPrimes(int n) {
        Boolean[]  isPrime = new Boolean[n];//��Ȼ����Ϊn��������Чʹ����n-1
        for(int i = 2; i < n; i++){ //��index = 2��ʼ����Ϊ֮ǰ�������õ�
            isPrime[i] = true;
        }
        for(int i = 2; i * i < n; i++){
            if(!isPrime[i]) continue; //��������Ѿ������false����ô��skip����Ȼ�����һ��������ʼ
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