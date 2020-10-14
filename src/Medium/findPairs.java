package Medium;

import java.util.Arrays;

public class findPairs {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;
        for(int i=0; i<n; i++){
            if(nums[i] == nums[i-1]){
                continue;
            }
            for(int j=i+1; j<n; j++){
                if(nums[j]-nums[i] > k){
                    break;
                }else if(nums[j]-nums[i]==k){
                    ans++;
                    break;
                }else{
                    continue;
                }
            }
        }
        return ans;
    }
}
