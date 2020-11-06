package Easy;

import java.util.Arrays;

public class sortByBits {
    public int[] sortByBits(int[] arr) {
        int[][] num = new int[arr.length][2];
        for(int i=0; i<arr.length; i++){
            num[i][0] = arr[i];
            num[i][1] = bitcount(arr[i]);
        }
        Arrays.sort(num, (a, b)->(a[1]==b[1] ? a[0]-b[0] : a[1]-b[1]));
        int[] ans = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            ans[i] = num[i][0];
        }
        return ans;
    }
    //计算二进制中1的个数
    public int bitcount(int x){
        int cnt = 0;
        while (x>0){
            // 清除最低位的1
            x = x & (x-1);
            cnt++;
        }
        return cnt;
    }
    //法2
    public int bitcount2(int x){
        int cnt = 0;
        while (x > 0){
            //最低位是1
            if((x & 1)==1) {
                cnt++;
            }
            //向右移1位
            x >>= 1;
        }
        return cnt;
    }
}
