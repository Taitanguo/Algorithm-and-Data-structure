public class Solution{
    public int findkthlargest(int k, int nums[]){
        PriorityQueue<Integer> largek = new PriorityQueue<Integer>();

        for(int el : nums){
            largek.offer(el);
            if(largek.size() > k){
                largek.poll();
            }
        }

        return  largek.poll();
    }
}

//time complexity: n*log(k)