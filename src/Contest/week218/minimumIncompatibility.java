package Contest.week218;

import java.util.Arrays;
import java.util.Map;

public class minimumIncompatibility {
    public int minimumIncompatibility(int[] nums, int k) {
        int n = nums.length;
        if(n == k){
            return 0;
        }
        int m = n/k;
        int[] cost = new int[1<<n];
        Arrays.fill(cost, -1);
        for(int i=0; i<(1<<n); i++){
            int max = -1;
            int min = n+1;
            boolean flag = false;
            // 判断sub是否有n/k个1
            if(Integer.bitCount(i) == m){
                // 判断是否有重复数
                int[] freq = new int[n];
                for(int j=0; j<n; j++){
                    // 选了nums数组中第j个数
                    if(((i>>j)&1) == 1){
                        freq[nums[j]]++;
                        // 出现重复数
                        if(freq[nums[j]] > 1){
                            flag = true;
                            break;
                        }
                        max = Math.max(max, nums[j]);
                        min = Math.min(min, nums[j]);
                    }
                }
                if(!flag){
                    cost[i] = max-min;
                }
            }
        }
        int[] dp = new int[1<<n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for(int mask=1; mask<(1<<n); mask++){
            // 判断 mask 是否有 n/k 倍数个 1
            if(Integer.bitCount(mask)%m == 0){
                for(int sub=mask; sub!=0; sub = (sub-1)&mask){
                    if(cost[sub]!=-1 && dp[mask^sub]!=-1){
                        if(dp[mask] == -1){
                            dp[mask] = dp[mask^sub] + cost[sub];
                        }else {
                            dp[mask] = Math.min(dp[mask], dp[mask^sub]+cost[sub]);
                        }
                    }
                }
            }
        }
        return dp[(1<<n)-1];
    }
}
