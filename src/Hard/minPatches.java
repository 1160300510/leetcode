package Hard;

public class minPatches {
    public int minPatches(int[] nums, int n) {
        long x = 1;
        int l = nums.length;
        int index = 0, patch = 0;
        while (x <= n){
            if(index<l && nums[index]<=x){
                x += nums[index];
                index++;
            }else{
                x = 2 * x;
                patch++;
            }
        }
        return patch;
    }
}
