package Contest.week218;

public class concatenatedBinary {
    public int concatenatedBinary(int n) {
        int[] bit = new int[n+2];
        bit[0]=1;
        bit[1]=1;
        for(int i=2; i<=n; i++){
            bit[i] = bit[i/2]+1;
        }
        long ans = 0;
        long mod = (long)1e9+7;
        for(int i=1; i<=n; i++){
            ans = ((long)ans<<bit[i])%mod + i;
        }
        return (int)(ans%mod);
    }
    // 快速幂
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
}

