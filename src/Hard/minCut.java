package Hard;

import java.util.Arrays;

public class minCut {
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n];
        for(int i=0; i<n; i++){
            dp[i] = i;
        }
        // 预处理判断是否是回文字符串
        boolean[][] g = new boolean[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(g[i], true);
        }
        for(int i=n-1; i>=0; --i){
            for(int j=i+1; j<n; ++j){
                g[i][j] = s.charAt(i)==s.charAt(j) & g[i+1][j-1];
            }
        }
        for(int i=0; i<n; ++i){
            if(g[0][i]){
                dp[i] = 0;
            }else{
                for(int j=0; j<i; ++j){
                    if(g[j+1][i]){
                        dp[i] = Math.min(dp[i], dp[j]+1);
                    }
                }
            }
        }
        return dp[n-1];
    }
}
