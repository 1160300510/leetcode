package Hard;

public class bestTimeToBuyAndSellStockIV {
    public int maxProfit(int k, int[] prices) {
        if(prices==null || prices.length==0){
            return 0;
        }
        if(k > prices.length/2){
            return maxProfit(prices);
        }
        int n = prices.length;
        // dp[i][j][0]表示第i天最多进行j笔交易不持有股票的收益
        // dp[i][j][1]表示第i天最多进行j笔交易持有股票的收益
        int[][][] dp = new int[n][k+1][2];
        for(int i=0; i<=k; i++){
            dp[0][i][0] = 0;
            dp[0][i][1] = -prices[0];
        }
        for(int i=1; i<n; i++){
            for(int j=k; j>0; j--){
                dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1]+prices[i]);
                dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][0]-prices[i]);
            }
        }
        return dp[n-1][k][0];
    }

    public int maxProfit(int[] prices){
        int n = prices.length;
        // dp[i][0]表示第i天不持有股票的收益
        // dp[i][1]表示第i天持有股票的收益
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i=1; i<n; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]-prices[i]);
        }
        return dp[n-1][0];
    }
}
