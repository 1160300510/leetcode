package Contest.week214;

import java.util.PriorityQueue;

public class maxProfit {
    public int maxProfit(int[] inventory, int orders) {
        int l = 0;
        int r = (int)(1e9);
        while(l <= r){
            int mid = (l+r)/2;
            if(check(inventory, orders, mid)){
                r = mid-1;
            }else {
                l = mid+1;
            }
        }
        long res = 0, mod = (long)1e9+7;
        for(int inv : inventory){
            if(inv > l){
                long sum = sum(l+1, inv);
                res += sum;
                res %= mod;
                orders -= (inv-l);
            }
        }
        res += (long)l * orders;
        return (int)(res % mod);
    }

    public boolean check(int[] inventory, int orders, int mid){
        for(int inv : inventory){
            if(inv > mid){
                orders -= (inv-mid);
                if(orders < 0){
                    return false;
                }
            }
        }
        return true;
    }

    public long sum(long l, long r){
        return (l + r) * (r - l + 1) / 2;
    }
}
