package Contest.week218;

public class concatenatedBinary {
    public int concatenatedBinary(int n) {
        int[] bit = new int[n+1];
        bit[0]=1;
        bit[1]=1;
        for(int i=2; i<=n; i++){
            bit[i] = bit[i/2]+1;
        }
        long[] sum = new long[n+1];
        for(int i=n-1; i>=1; i--){
            sum[i] += sum[i+1] + bit[i+1];
        }
        long ans = 0;
        int mod = (int)1e9+7;
        for(int i=n; i>=1; i--){
            long pow = mypow(2, sum[i], mod)%mod;
            ans += (long)(i*pow) % mod;
        }
        return (int)(ans%mod);
    }

    public static long mypow(long a, long b, int c){
        long res = 1;
        a %= c;
        for (; b != 0; b /= 2) {
            if (b % 2 == 1)
                res = (res * a) % c;
            a = (a * a) % c;
        }
        return res;
    }

    public static void main(String[] args) {
        concatenatedBinary c = new concatenatedBinary();
        System.out.println(c.concatenatedBinary((int)1e5));
    }
}

