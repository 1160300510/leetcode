package Contest.week217;

import java.util.*;

public class mostCompetitive {
    // 单调栈
    public int[] mostCompetitive(int[] nums, int k) {
        Deque<Integer> stack = new LinkedList<Integer>();
        int n = nums.length;
        stack.add(-1);
        for(int i=0; i<n; i++){
            while (nums[i] < stack.peek() && (n-i)>(k-stack.size()+1)){
                stack.pop();
            }
            if(stack.size()-1 < k){
                stack.push(nums[i]);
            }
        }
        int[] ans = new int[k];
        while (k > 0){
            ans[--k] = stack.pop();
        }
        return ans;

    }
    // 优先队列
    public int[] mostCompetitive2(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o1[1]<o2[1]?-1:1;
                }else {
                    return o1[0]<o2[0]?-1:1;
                }
            }
        });
        int n = nums.length;
        for(int i=0; i<n-k+1; i++){
            pq.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[k];
        int ansidx = 0;
        int l = 0;
        for(int i=0; i<k; i++){
            while (pq.peek()[1] < l){
                pq.poll();
            }
            int[] cur = pq.poll();
            ans[ansidx++] = cur[0];
            l = cur[1] + 1;
            if(i < k-1){
                pq.offer(new int[]{nums[n-k+i+1], n-k+i+1});
            }
        }
        return ans;
    }
}
