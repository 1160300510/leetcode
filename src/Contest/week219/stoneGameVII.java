package Contest.week219;

public class stoneGameVII {
    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        int[] pre = new int[n+1];
        for(int i=0; i<n; i++){
            pre[i+1] = pre[i] + stones[i];
        }
        int[][] dp = new int[n][n];
        for(int i=n-2; i>=0; i--){
            for(int j=i+1; j<n; j++){
                dp[i][j] = Math.max(pre[j+1]-pre[i+1]-dp[i+1][j], pre[j]-pre[i]-dp[i][j-1]);
            }
        }
        return dp[0][n-1];
    }
}
