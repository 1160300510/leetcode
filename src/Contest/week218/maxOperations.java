package Contest.week218;

import java.util.Arrays;

public class maxOperations {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length;
        int l = 0, r = len-1;
        int ans = 0;
        while (l<r){
            if(nums[l]+nums[r] == k){
                l++;
                r--;
                ans++;
            }else if(nums[l]+nums[r] < k){
                l++;
            }else{
                r--;
            }
        }
        return ans;
    }
}
