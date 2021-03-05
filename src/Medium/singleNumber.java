package Medium;

public class singleNumber {
    public int singleNumber(int[] nums) {
        int[] counts = new int[32];
        for(int num : nums){
            for(int i=0; i<32; i++){
                counts[i] += (num & 1);
                num >>= 1;
            }
        }
        int res = 0, m = 3;
        for(int i=31; i>=0; i--){
            res <<= 1;
            res |= (counts[i] % m);
        }
        return res;
    }
}
