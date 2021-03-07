package Medium;

import java.util.Arrays;

public class countPrimes {
    // 埃氏筛法，时间复杂度O(nloglogn)
    public int countPrimes(int n) {
        if(n <= 1){
            return 0;
        }
        int ans = 0;
        boolean[] p = new boolean[n];
        Arrays.fill(p, true);
        for(int i=2; i<n; i++){
            if(p[i]){
                ans++;
                for(int j=2*i; j<n; j+=i){
                    p[j] = false;
                }
            }
        }
        return ans;
    }
}
