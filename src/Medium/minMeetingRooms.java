package Medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class minMeetingRooms {

    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->{
            if(a[0]==b[0]){
                return a[1]-b[1];
            }
            return a[0]-b[0];
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->Integer.compare(a,b));
        for(int[] interval : intervals){
            if(pq.isEmpty()){
                pq.offer(interval[1]);
                continue;
            }
            if(interval[0] < pq.peek()){
                pq.offer(interval[1]);
            }else{
                pq.poll();
                pq.offer(interval[1]);
            }
        }
        return pq.size();
    }
}
