package 剑指offer;

import java.util.Arrays;

public class LCOF {
    public String minNumber(int[] nums) {
        // 自定义排序规则
        int n = nums.length;
        String[] strs = new String[n];
        for(int i=0; i<n; i++){
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (x,y)->((x+y).compareTo(y+x)));
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            sb.append(strs[i]);
        }
        return sb.toString();
    }
}
