package 剑指offer;

public class translateNum {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1];
            String sub = s.substring(i-2,i);
            if(Integer.valueOf(sub)>=10 && Integer.valueOf(sub)<=25){
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
}
