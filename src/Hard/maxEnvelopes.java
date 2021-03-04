package Hard;

import java.util.Arrays;

public class maxEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        if(n <= 1){
            return n;
        }
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        Arrays.sort(envelopes, (a,b)->{
            if(a[0] == b[0]){
                return b[1]-a[1];
            }
            return a[0]-b[0];
        });
        int max = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                if(envelopes[j][1]<envelopes[i][1]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
