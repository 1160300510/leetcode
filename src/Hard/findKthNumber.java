package Hard;

public class findKthNumber {
    public int findKthNumber(int n, int k){
        int pre = 1;
        k--;
        while(k > 0){
            int cnt = getCount(n, pre, pre+1);
            if(k >= cnt){
                k -= cnt;
                pre++;
            }else{
                pre *= 10;
                k--;
            }
        }
        return pre;
    }

    public int getCount(int n, long x, long y){
        int sum = 0;
        while (x <= n){
            sum += Math.min(y, n+1) - x;
            x *= 10;
            y *= 10;
        }
        return sum;
    }
}
