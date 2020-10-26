package Easy;

import java.util.Arrays;
import java.util.Comparator;

public class smallerNumbersThanCurrent {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(nums[j]<nums[i]){
                    ans[i]++;
                }
            }
        }
        return ans;
    }
    // 快速排序
    public int[] smallerNumbersThanCurrent2(int[] nums){
        int n = nums.length;
        int[][] data = new int[n][2];
        for(int i=0; i<n; i++){
            data[i][0] = nums[i];
            data[i][1] = i;
        }
        Arrays.sort(data, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int[] ans = new int[n];
        int prev = -1;
        for(int i=0; i<n; i++){
            if(prev == -1 || data[i][0]!=data[i-1][0]){
                prev = i;
            }
            ans[data[i][1]] = prev;
        }
        return ans;
    }
    // 计数排序
    public int[] smallerNumbersThanCurrent3(int[] nums){
        int[] cnt = new int[101];
        int n = nums.length;
        for(int i=0; i<n; i++){
            cnt[nums[i]]++;
        }
        for(int i=1; i<101; i++){
            cnt[i] += cnt[i-1];
        }
        int[] ans = new int[n];
        for(int i=0; i<n; i++){
            if(nums[i] != 0){
                ans[i] = cnt[nums[i]-1];
            }else{
                ans[i] = 0;
            }
        }
        return ans;
    }
}
