package Contest.week211;

import java.util.Arrays;
import java.util.Comparator;

public class bestTeamScore {
    public int bestTeamScore(int[] scores, int[] ages) {
        int ans = 0;
        if(scores.length == 1){
            return scores[0];
        }
        int[][] arr = new int[scores.length][2];
        for(int i=0; i<scores.length; i++){
            arr[i][0] = ages[i];
            arr[i][1] = scores[i];
        }
        // 排序，按年龄从小到大排序，年龄相同按分数从小到大排
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o1[1]-o2[1];
                }else {
                    return o1[0]-o2[0];
                }
            }
        });
        // dp[i]表示以第i位球员结束时最大分数
        int[] dp = new int[scores.length];
        for(int i=0; i<scores.length; i++){
            dp[i] = arr[i][1];
        }
        for(int i=0; i<scores.length; i++){
            for(int j=i-1; j>=0; j--){
                if(arr[j][1] <= arr[i][1]){
                    dp[i] = Math.max(dp[i], dp[j]+arr[i][1]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
