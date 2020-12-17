package Medium;

import java.util.Map;

public class maxProfit {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        //dp[i][0]第i天持有股票的利润
        //dp[i][1]第i天不持有股票的利润
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for(int i=1; i<n; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]-prices[i]);
            dp[i][1] = Math.max(dp[i-1][0]+prices[i]-fee, dp[i-1][1]);
        }
        return dp[n-1][1];
    }
}
