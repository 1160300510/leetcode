package Hard;

public class splitArray {
    public int splitArray(int[] nums, int m) {
        int l=0, r=0;
        for(int num : nums){
            r += num;
            l = Math.max(l, num);
        }
        while(l <= r){
            int mid = (l+r)/2;
            if(check(nums, m, mid)){
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return l;
    }

    public boolean check(int[] nums, int m, int target){
        int cnt=1, sum=0;
        for(int num : nums){
            if(sum + num <= target){
                sum += num;
            }else{
                sum = num;
                cnt++;
            }
        }
        return cnt <= m;
    }
}
