package Hard;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class countRangeSum {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long sum = 0;
        long[] preSum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            preSum[i + 1] = sum;
        }

        Set<Long> allNumbers = new TreeSet<Long>();
        for (long x : preSum) {
            allNumbers.add(x);
            allNumbers.add(x - lower);
            allNumbers.add(x - upper);
        }
        // 利用哈希表进行离散化
        Map<Long, Integer> values = new HashMap<Long, Integer>();
        int idx = 0;
        for (long x: allNumbers) {
            values.put(x, idx);
            idx++;
        }

        int ret = 0;
        BIT bit = new BIT(values.size());
        for (int i = 0; i < preSum.length; i++) {
            int left = values.get(preSum[i] - upper), right = values.get(preSum[i] - lower);
            ret += bit.query(right + 1) - bit.query(left);
            bit.update(values.get(preSum[i]) + 1, 1);
        }
        return ret;
    }

    public int countRangeSum2(int[] nums, int lower, int upper){
        long s = 0;
        long[] sum = new long[nums.length+1];
        for(int i=0; i<nums.length; i++){
            s += nums[i];
            sum[i+1] = s;
        }
        return countRangeSumRecursive(sum, lower, upper, 0, sum.length-1);
    }

    public int countRangeSumRecursive(long[] sum, int lower, int upper, int left, int right){
        if(left == right){
            return 0;
        }
        int mid = (left+right)/2;
        int n1 = countRangeSumRecursive(sum, lower, upper, left, mid);
        int n2 = countRangeSumRecursive(sum, lower, upper, mid+1, right);
        int ret = n1+n2;

        int l = mid+1, r=mid+1;
        int i = left;
        while (i <= mid){
            while (l<=right && (sum[l]-sum[i])<lower){
                l++;
            }
            while (r<=right && (sum[r]-sum[i])<=upper){
                r++;
            }
            ret += r-l;
            i++;
        }
        //合并两个排序数组
        int[] sorted = new int[right-left+1];
        int p1 = left, p2 = mid+1;
        int p = 0;
        while (p1<=mid || p2<=right){
            if(p1 > mid){
                sorted[p++] = (int) sum[p2++];
            }else if(p2 > right){
                sorted[p++] = (int) sum[p1++];
            }else {
                if(sum[p1]<sum[p2]){
                    sorted[p++] = (int)sum[p1++];
                }else {
                    sorted[p++] = (int)sum[p2++];
                }
            }
        }
        for(int k=0; k<sorted.length; k++){
            sum[left+k] = sorted[k];
        }
        return ret;
    }
}

class BIT{
    int[] data;
    int n;
    public BIT(int n){
        this.n = n;
        data = new int[n+1];
    }
    public int lowbit(int x){
        return x & (-x);
    }
    public void update(int i, int mod){
        if(i<=0){
            return;
        }
        while(i <= n){
            data[i] += mod;
            i += lowbit(i);
        }
    }
    public int query(int i){
        int sum = 0;
        while(i > 0){
            sum += data[i];
            i -= lowbit(i);
        }
        return sum;
    }
}
