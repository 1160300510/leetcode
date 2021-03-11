package 剑指offer;

public class nthUglyNumber {
    public int nthUglyNumber(int n) {
        int a=0, b=0, c=0;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i=1; i<n; i++){
            int n1 = dp[a]*2;
            int n2 = dp[b]*3;
            int n3 = dp[c]*5;
            dp[i] = Math.min(Math.min(n1,n2),n3);
            if(dp[i] == n1) a++;
            if(dp[i] == n2) b++;
            if(dp[i] == n3) c++;
        }
        return dp[n-1];
    }
}
