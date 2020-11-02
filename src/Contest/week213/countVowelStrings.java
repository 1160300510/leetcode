package Contest.week213;

import java.util.Arrays;

public class countVowelStrings {
    public int countVowelStrings(int n) {
        int[][] cnt = new int[n][5];
        Arrays.fill(cnt[0], 1);
        for(int i=1; i<n; i++){
            for(int j=0; j<5; j++){
                for(int k=0; k<=j; k++){
                    cnt[i][j] += cnt[i-1][k];
                }
            }
        }
        int ans = 0;
        for(int i=0; i<5; i++){
            ans += cnt[n-1][i];
        }
        return ans;
    }
}
