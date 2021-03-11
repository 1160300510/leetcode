package Medium;

public class CountNumberofNiceSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        if (k == 0 || nums.length==0){
            return 0;
        }
        int n = nums.length;
        int odd = 0;
        int[] cnt = new int[n+1];
        cnt[0] = 1;
        int ans = 0;
        for(int i=0; i<n; i++){
            if((nums[i]&1) == 1){
                odd++;
            }
            ans += odd>=k ? cnt[odd-k]:0;
            cnt[odd]++;
        }
        return ans;
    }
}
