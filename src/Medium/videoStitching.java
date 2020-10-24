package Medium;

import java.util.Arrays;

public class videoStitching {
    public int videoStitching(int[][] clips, int T) {
        //dp[i][j]表示[i:j]的最少片段数
        int inf = (int)1e5;
        int[][] dp = new int[T+1][T+1];
        for(int i=0; i<=T; i++){
            Arrays.fill(dp[i],inf);
        }
        for(int[] clip : clips){
            int i = clip[0];
            int j = clip[1];
            for(int k=i; k<=j; k++){
                dp[i][k] = 1;
            }
        }

        for(int i=T; i>=0; i--){
            for(int j=i; j<=T; j++){
                if(dp[i][j] == inf){
                    for(int k=i; k<=j; k++){
                        dp[i][j] = Math.min(dp[i][k]+dp[k][j], dp[i][j]);
                    }
                }
            }
        }
        return dp[0][T]==inf ? -1 : dp[0][T];
    }
}
