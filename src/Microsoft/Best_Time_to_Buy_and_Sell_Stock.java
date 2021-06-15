package Microsoft;

public class Best_Time_to_Buy_and_Sell_Stock {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int cur = 0;
        int next = cur+1;
        while(next < prices.length) {
            int profit = prices[next] - prices[cur];
            if(profit > 0) {
                maxProfit = Math.max(profit, maxProfit);
            }
            else {
                cur = next;
            }
            next++;
        }
        return maxProfit;
    }
}
