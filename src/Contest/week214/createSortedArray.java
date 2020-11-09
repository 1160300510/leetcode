package Contest.week214;

public class createSortedArray {
    public int createSortedArray(int[] instructions) {
        int top = (int)(1e5+1);
        int mod = (int)(1e9+7);
        IntegerBIT bit = new IntegerBIT(top);
        int ans = 0;
        for(int x : instructions){
            int low = bit.query(x-1);
            int high = bit.query(top)-bit.query(x);
            ans += Math.min(low, high);
            ans %= mod;
            bit.update(x, 1);
        }
        return ans%mod;
    }
}

class IntegerBIT{
    int[] data;
    int n;
    public IntegerBIT(int n){
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
    public int query(int l, int r) {
        return query(r) - query(l - 1);
    }
}

