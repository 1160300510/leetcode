package Medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class longestSubarray {
    public int longestSubarray(int[] nums, int limit) {
        int ans = 0;
        Deque<Integer> min = new ArrayDeque<>();
        Deque<Integer> max = new ArrayDeque<>();
        int l = 0, r;
        for(r=0; r<nums.length; r++){
            int num = nums[r];
            while (!min.isEmpty() && num<min.peekLast()){
                min.pollLast();
            }
            while (!max.isEmpty() && num>max.peekLast()){
                max.pollLast();
            }
            min.offerLast(num);
            max.offerLast(num);
            while (max.peek()-min.peek() > limit){
                if(nums[l] == max.peek()){
                    max.poll();
                }
                if(nums[l] == min.peek()){
                    min.poll();
                }
                l++;
            }
            ans = Math.max(ans, r-l+1);
        }
        return ans;
    }
}
