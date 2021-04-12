package Medium;

import java.util.Arrays;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] numsString = new String[n];
        for(int i=0; i<n; ++i){
            numsString[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numsString, (a,b)->{
            return (b+a).compareTo(a+b);
        });
        StringBuffer stringBuffer = new StringBuffer();
        for(int i=0; i<n; ++i){
            stringBuffer.append(numsString[i]);
        }
        String res = stringBuffer.toString();
        return res.charAt(0)=='0' ? "0" : res;
    }
}
