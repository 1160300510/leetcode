package Hard;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class maxSlidingWindow {

    // 优先队列
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if(a[0]==b[0]){
                return a[1]-b[1];
            }else{
                return b[0]-a[0];
            }
        });
        for(int i=0; i<k; i++){
            pq.offer(new int[]{nums[i], i});
        }
        int n = nums.length;
        int[] ans = new int[n-k+1];
        ans[0] = pq.peek()[0];
        for(int i=k; i<nums.length; i++){
            pq.offer(new int[]{nums[i], i});
            while (!pq.isEmpty() && i-pq.peek()[1]>=k){
                pq.poll();
            }
            ans[i-k+1] = pq.peek()[0];
        }
        return ans;
    }
    // 单调队列
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> queue = new LinkedList<>();
        int[] ans = new int[n-k+1];
        for(int i=0; i<k; i++){
            while (!queue.isEmpty() && nums[i]>=nums[queue.peekLast()]){
                queue.pollLast();
            }
            queue.offerLast(i);
        }
        ans[0] = nums[queue.peekFirst()];
        for(int i=k; i<n; i++){
            while (!queue.isEmpty() && nums[i]>=nums[queue.peekLast()]){
                queue.pollLast();
            }
            queue.offerLast(i);
            while (!queue.isEmpty() && i-queue.peekFirst()>=k){
                queue.pollFirst();
            }
            ans[i-k+1] = nums[queue.peekFirst()];
        }
        return ans;
    }
}
