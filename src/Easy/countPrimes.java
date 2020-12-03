package Easy;

import java.util.Arrays;

public class countPrimes {
    // 质数筛
    public int countPrimes(int n) {
        boolean[] flag = new boolean[n];
        Arrays.fill(flag, true);
        int ans = 0;
        for(int i=2; i<n; i++){
            if(flag[i]){
                ans++;
                if((long)i*i<n){
                    for(int j=i*i; j<n; j+=i){
                        flag[j] = false;
                    }
                }
            }
        }
        return ans;
    }
}
