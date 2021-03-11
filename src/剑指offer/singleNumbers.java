package 剑指offer;

public class singleNumbers {
    public int[] singleNumbers(int[] nums) {
        int xor = 0;
        for(int n : nums){
            xor ^= n;
        }
        int lowbit = xor & (-xor);
        int a = 0, b = 0;
        for(int n : nums){
            if((n&lowbit) != 0){
                a ^= n;
            }else {
                b ^= n;
            }
        }
        return new int[]{a, b};
    }
}
