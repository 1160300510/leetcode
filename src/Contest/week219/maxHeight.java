package Contest.week219;

import java.util.Arrays;
import java.util.Map;

public class maxHeight {
    public int maxHeight(int[][] cuboids) {
        int n = cuboids.length;
        for(int[] c : cuboids){
            Arrays.sort(c);
        }
        Arrays.sort(cuboids, (x,y)->{
            // 因为已经对每个cuboid升序排序, 所以x[0]<x[1]<x[2]
            // 先按x[2]升序排序,再按x[1],x[0]
            if(x[2] != y[2]){
                return Integer.compare(x[2], y[2]);
            }else if(x[1] != y[1]){
                return Integer.compare(x[1], y[1]);
            }else {
                return Integer.compare(x[0], y[0]);
            }
        });
        int ans = 0;
        // dp[i]表示第i块长方体的堆叠高度
        int[] dp = new int[n];
        for(int i=0; i<n; i++){
            // 对于长方体i,最低高度为自身高度
            dp[i] = cuboids[i][2];
            for(int j=0; j<i; j++){
                // 第j块长方体不满足堆叠在第i块长方体上的要求
                if(cuboids[j][0]>cuboids[i][0] || cuboids[j][1]>cuboids[i][1] || cuboids[j][2]>cuboids[i][2]){
                    continue;
                }else{
                    // 满足要求，更新第i块长方体的最大堆叠高度
                    dp[i] = Math.max(dp[i], dp[j] + cuboids[i][2]);
                }
            }
            // 更新答案
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
