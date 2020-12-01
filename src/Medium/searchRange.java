package Medium;

public class searchRange {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0){
            return new int[]{-1,-1};
        }
        int l = 0, r = nums.length-1;
        int[] ans = new int[2];
        // 左边界
        while (l <= r){
            int mid = l + (r-l)/2;
            if(nums[mid] < target){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        if(l<0 || l>=nums.length || nums[l] != target){
            return new int[]{-1,-1};
        }else{
            ans[0] = l;
        }
        l = 0;
        r = nums.length-1;
        //右边界
        while (l <= r){
            int mid = l + (r-l)/2;
            if(nums[mid] <= target){
                l = mid+1;
            }else {
                r = mid-1;
            }
        }
        ans[1] = r;
        return ans;
    }
}
