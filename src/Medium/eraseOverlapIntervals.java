package Medium;

import java.util.PriorityQueue;

public class eraseOverlapIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0){
            return 0;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if(a[0]==b[0]){
                return a[1]-b[1];
            }else {
                return a[0]-b[0];
            }
        });
        for(int[] interval : intervals){
            pq.offer(interval);
        }
        int ans = 0;
        int right = pq.poll()[1];
        while (!pq.isEmpty()){
            int[] inter = pq.poll();
            if(right <= inter[0]){
                right = inter[1];
            }else{
                // 小区间包含在大区间内，就把右边界改为小区间的右边界
                // 这样可以保留更多的区间，删去最少的区间
                if(right >= inter[1]){
                    right = inter[1];
                }
                ans++;
            }
        }
        return ans;
    }
}
