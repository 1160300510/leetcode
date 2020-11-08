package Contest.week214;

import java.util.PriorityQueue;

public class maxProfit {
    public int maxProfit(int[] inventory, int orders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        pq.offer(0);
        for(int a : inventory){
            pq.offer(a);
        }
        int inf = (int)(1e9+7);
        int ans = 0;
        int cnt = 0;
        while (orders>0){
            int max = pq.poll();
            ans += max % inf;
            max--;
            orders--;
            while (max >= pq.peek() && orders>0){
                ans += max % inf;
                max--;
                orders--;
            }
            cnt++;
        }
        return ans;

    }
}
