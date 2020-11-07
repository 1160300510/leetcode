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
