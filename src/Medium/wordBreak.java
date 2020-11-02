package Medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class wordBreak {
    // https://leetcode-cn.com/problems/word-break/
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        Set<String> set = new HashSet<>(wordDict);
        // dp[i]表示s(i,j)是否可以拆分
        dp[0] = true;
        for(int i=0; i<=n; i++){
            for(int j=0; j<i; j++){
                dp[i] = dp[j] & set.contains(s.substring(j,i));
                if(dp[i]){
                    break;
                }
            }
        }
        return dp[n];
    }
}
