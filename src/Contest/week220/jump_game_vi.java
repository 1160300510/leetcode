package Contest.week220;

import java.util.PriorityQueue;

public class jump_game_vi {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b)->(b[0]-a[0]));
        pq.offer(new int[]{nums[0], 0});
        for(int i=1; i<n; i++){
            while (!pq.isEmpty()){
                int[] head = pq.peek();
                if(i-head[1] > k){
                    pq.poll();
                }else{
                    break;
                }
            }
            dp[i] = pq.peek()[0] + nums[i];
            pq.offer(new int[]{dp[i], i});
        }
        return dp[n-1];
    }
}
