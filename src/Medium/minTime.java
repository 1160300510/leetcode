package Medium;

public class minTime {
    // https://leetcode-cn.com/problems/xiao-zhang-shua-ti-ji-hua/
    public int minTime(int[] time, int m) {
        int l=0, r=0;
        for(int t : time){
            r = Math.max(r, t);
        }
        while(l <= r){
            int mid = (l+r)/2;
            if(check(time, m, mid)){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }

    public boolean check(int[] time, int m, int t){
        int sum = 0, max = 0, cnt = 1;
        for(int i=0; i<time.length; i++){
            int next = Math.min(max, time[i]);
            if(next+sum <= t){
                sum += next;
                max = Math.max(max, time[i]);
            }else{
                cnt++;
                sum = 0;
                max = time[i];
            }
        }
        return cnt<=m;
    }
}
