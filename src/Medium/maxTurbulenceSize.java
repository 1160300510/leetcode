package Medium;

public class maxTurbulenceSize {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        int left = 0, right = 0;
        int ans = 1;
        while (right < n-1){
            if(left == right){
                if(arr[left] == arr[left+1]){
                    left++;
                }
                right++;
            }else{
                if(arr[right-1]>arr[right] && arr[right]<arr[right+1]){
                    right++;
                }else if(arr[right-1]<arr[right] && arr[right]>arr[right+1]){
                    right++;
                }else{
                    left = right;
                }
            }
            ans = Math.max(ans, right-left+1);
        }
        return ans;
    }
    //动态规划
    public int maxTurbulenceSize2(int[] arr){
        int n = arr.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 1;
        dp[0][1] = 1;
        for(int i=1; i<n; i++){
            if(arr[i] > arr[i-1]){
                dp[i][1] = dp[i-1][0]+1;
                dp[i][0] = 1;
            }else if(arr[i] < arr[i-1]){
                dp[i][0] = dp[i-1][1]+1;
                dp[i][1] = 1;
            }else{
                dp[i][0] = 1;
                dp[i][1] = 1;
            }
        }
        int ans = 0;
        for(int i=0; i<n; i++){
            ans = Math.max(ans, dp[i][0]);
            ans = Math.max(ans, dp[i][1]);
        }
        return ans;
    }
}
