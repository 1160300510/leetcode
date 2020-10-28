package Medium;

public class minDays {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if(m*k > n){
            return -1;
        }
        int l = 1, r = (int)1e9;
        while(l <= r){
            int mid = (l+r)/2;
            if(check(bloomDay, m, k, mid)){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return r;
    }

    public boolean check(int[] bloomDay, int m, int k, int mid){
        int cnt = 0;
        for(int day : bloomDay){
            if(day <= mid){
                cnt++;
                if(cnt == k){
                    m--;
                    cnt = 0;
                }
            }else{
                cnt = 0;
            }
        }
        return m<=0;
    }
}
