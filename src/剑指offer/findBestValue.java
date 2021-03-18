package 剑指offer;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class findBestValue {
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int n = arr.length;
        int[] sum = new int[n+1];
        for(int i=0; i<n; i++){
            sum[i+1] = sum[i] + arr[i];
        }
        int l = 0, r = arr[n-1];
        int ans = -1;
        while(l <= r){
            int mid = (l+r)>>1;
            int index = Arrays.binarySearch(arr, mid);
            if(index < 0){
                index = -index-1;
            }
            int cur = getvalue(sum, index, n, mid);
            if(cur <= target){
                ans = mid;
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        int chooseSmall = check(arr, ans);
        int chooseBig = check(arr, ans + 1);
        return Math.abs(chooseSmall - target) <= Math.abs(chooseBig - target) ? ans : ans + 1;
    }
    public int check(int[] arr, int x) {
        int ret = 0;
        for (int num : arr) {
            ret += Math.min(num, x);
        }
        return ret;
    }


    public int getvalue(int[] sum, int i, int n, int val){
        return (n-i)*val + sum[i];
    }
}
