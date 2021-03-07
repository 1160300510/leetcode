package Medium;

import java.util.*;

public class nextGreaterElements {
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for(int i=0; i<2*n; i++){
            if(stack.isEmpty()){
                stack.offerLast(i);
            }else {
                if(nums[stack.peekLast()%n] >= nums[i%n]){
                    stack.offerLast(i);
                }else{
                    while (!stack.isEmpty() && nums[stack.peekLast()%n] < nums[i%n]){
                        ans[stack.peekLast()%n] = nums[i%n];
                        stack.pollLast();
                    }
                    stack.offerLast(i);
                }
            }
        }
        return ans;
    }
}
