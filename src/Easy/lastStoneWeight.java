package Easy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class lastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 1){
            return stones[0];
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(b.compareTo(a)));
        for(int stone : stones){
            pq.offer(stone);
        }
        while (pq.size()>1){
            int a = pq.poll();
            int b = pq.poll();
            if(a == b){
                continue;
            }else{
                pq.offer(Math.abs(a-b));
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}
