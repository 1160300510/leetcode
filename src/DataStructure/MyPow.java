package DataStructure;

public class MyPow {
    // 快速幂计算x^n
    public double MyPow(double x, int n){
        if(x == 0) return 0;
        long b = n;
        double res = 1.0;
        if(b < 0){
            b = -b;
            x = 1.0 / x;
        }
        while (b > 0){
            if((b&1) == 1){
                res *= x;
                //如果要取余
                //res %= mod;
            }
            x *= x;
            // x %= mod;
            b >>= 1;
        }
        return res;
    }
}
