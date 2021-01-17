package Contest.week224;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class tupleSameProduct {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        if(len < 4){
            return 0;
        }
        for(int i=0; i<len; i++){
            for(int j=i+1; j<len; j++){
                int val = nums[i]*nums[j];
                map.put(val, map.getOrDefault(val,0)+1);
            }
        }
        int ans = 0;
        for(Integer val : map.values()){
            ans += val * (val-1) / 2;
        }
        return ans*8;
    }
    public int tupleSameProduct2(int[] nums) {
        if(nums.length < 4){
            return 0;
        }
        Arrays.sort(nums);
        int len = nums.length;
        int ans = 0;
        for(int i=0; i<len; i++){
            for(int j=len-1; j>i+2; j--){
                int a = nums[i];
                int b = nums[j];
                int left = i+1;
                int right = j-1;
                while (left < right){
                    int c = nums[left];
                    int d = nums[right];
                    if(a*b == c*d){
                        ans++;
                        left++;
                        right--;
                    }else if(a*b > c*d){
                        left++;
                    }else{
                        right--;
                    }
                }
            }
        }
        return ans*8;
    }

}
