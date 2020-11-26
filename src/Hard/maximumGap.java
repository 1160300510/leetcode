package Hard;

import java.util.Arrays;

public class maximumGap {
    // 比较排序, O(nlogn)
    public int maximumGap(int[] nums) {
        int ans = 0;
        if(nums.length<2){
            return 0;
        }
        Arrays.sort(nums);
        for(int i=1; i<nums.length; i++){
            ans = Math.max(ans, nums[i]-nums[i-1]);
        }
        return ans;
    }
    // 基数排序
    public int maximumGap2(int[] nums){
        int n = nums.length;
        if(n < 2){
            return 0;
        }
        int max= Arrays.stream(nums).max().getAsInt();
        long exp = 1;
        int[] buf = new int[n];

        while (exp <= max){
            int[] cnt = new int[10];
            for(int i=0; i<n; i++){
                int digit = (nums[i] / (int)exp) % 10;
                cnt[digit]++;
            }
            for(int i=1; i<10; i++){
                cnt[i] += cnt[i-1];
            }
            for(int i=n-1; i>=0; i--){
                int digit = (nums[i] / (int)exp) % 10;
                buf[cnt[digit]-1] = nums[i];
                cnt[digit]--;
            }
            nums = Arrays.copyOf(buf, n);
            exp *= 10;
        }
        int ans = 0;
        for(int i=1; i<n; i++){
            ans = Math.max(ans, nums[i]-nums[i-1]);
        }
        return ans;
    }
    // 基于桶
    public int maximumGap3(int[] nums){
        int n = nums.length;
        if(n < 2){
            return 0;
        }
        int maxval = Arrays.stream(nums).max().getAsInt();
        int minval = Arrays.stream(nums).min().getAsInt();
        int d = Math.max(1, (maxval-minval)/(n-1));
        int bucketsize = (maxval - minval)/d + 1;
        int[][] bucket = new int[bucketsize][2];
        for(int i=0; i<bucketsize; i++){
            Arrays.fill(bucket[i], -1);
        }
        for(int i=0; i<n; i++){
            int idx = (nums[i]-minval) / d;
            if(bucket[idx][0] == -1){
                bucket[idx][0] = bucket[idx][1] = nums[i];
            }else{
                bucket[idx][0] = Math.min(bucket[idx][0], nums[i]);
                bucket[idx][1] = Math.max(bucket[idx][1], nums[i]);
            }
        }
        int ret = 0;
        int prev = -1;
        for (int i = 0; i < bucketsize; i++) {
            if (bucket[i][0] == -1) {
                continue;
            }
            if (prev != -1) {
                ret = Math.max(ret, bucket[i][0] - bucket[prev][1]);
            }
            prev = i;
        }
        return ret;
    }
}
