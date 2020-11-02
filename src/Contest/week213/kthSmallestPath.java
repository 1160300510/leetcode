package Contest.week213;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class kthSmallestPath {

    public String kthSmallestPath(int[] destination, int k) {
        int m = destination[0];
        int n = destination[1];
        // H的数量
        int h = n;
        // V的数量
        int v = m;
        StringBuilder sb = new StringBuilder();
        // dp求组合数
        int[][] dp = new int[h+v][h];
        dp[0][0] = 1;
        for(int i=0; i<h+v; i++){
            dp[i][0] = 1;
            for(int j=1; j<h && j<=i; j++){
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }
        while (h>0 && v>0){
            if(k > dp[h+v-1][h-1]){
                k -= dp[h+v-1][h-1];
                v--;
                sb.append('V');
            }else{
                h--;
                sb.append('H');
            }
        }
        if(h == 0){
            for(int i=0; i<v; i++){
                sb.append('V');
            }
        }else{
            for(int i=0; i<h; i++){
                sb.append('H');
            }
        }
        return sb.toString();

    }

}
