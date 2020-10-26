package Contest.week212;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class checkArithmeticSubarrays {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new ArrayList<>();
        int n = l.length;
        int left, right;
        for(int i=0; i<n; i++){
            left = l[i];
            right = r[i];
            if(right-left<2){
                ans.add(true);
                continue;
            }
            int[] temp = Arrays.copyOfRange(nums,left,right+1);
            Arrays.sort(temp);
            int len = temp.length;
            boolean flag = true;
            for(int j=2; j<len; j++){
                if(temp[j]-temp[j-1]!=temp[1]-temp[0]){
                    flag = false;
                    break;
                }
            }
            ans.add(flag);
        }
        return ans;
    }
}
