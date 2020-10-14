package Medium;

public class sortColors {
    public void sortColors(int[] nums) {
        int red=0, white=0, blue=0;
        int n = nums.length;
        for(int num : nums){
            if(num == 0){
                red++;
            }else if(num == 1){
                white++;
            }else{
                blue++;
            }
        }
        for(int i=0; i<n; i++){
            if(i < red){
                nums[i] = 0;
            }else if(i>=red && i<red+white){
                nums[i] = 1;
            }else{
                nums[i] = 2;
            }
        }
    }
}
