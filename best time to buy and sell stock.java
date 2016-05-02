public class Solution{
    public int maxProfit(int[] prices){
        if(prices == null || prices.length == 0){
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int profit = 0;

        for(int i : prices){
            min = i < min ? i : min;
            profit = profit > (i - min)  ? profit : (i - min);
        }
        return profit;
    }
}