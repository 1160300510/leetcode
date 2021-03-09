package 剑指offer;

import java.util.ArrayDeque;
import java.util.Deque;

public class verifyPostorder {
    public boolean verifyPostorder(int[] postorder) {
        int root = Integer.MAX_VALUE;
        Deque<Integer> stack = new ArrayDeque<>();
        int n = postorder.length;
        for(int i=n-1; i>=0; --i){
            if(postorder[i] > root){
                return false;
            }
            while(!stack.isEmpty() && stack.peekLast()>postorder[i]){
                root = stack.pollLast();
            }
            stack.offerLast(postorder[i]);
        }
        return true;
    }
}
