package 剑指offer;

import DataStructure.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class reverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        Deque<ListNode> stack = new ArrayDeque<>();
        int cnt = 0;
        ListNode cur = head;
        while(cur != null){
            if(cnt < k){
                cnt++;
                stack.push(cur);
                cur = cur.next;
            }
            if(cnt == k){
                ListNode top = stack.pop();
                pre.next = top;
                ListNode succ = top.next;
                while(!stack.isEmpty()){
                    top.next = stack.peek();
                    top = stack.pop();
                }
                top.next = succ;
                pre = top;
                cnt = 0;
            }
        }
        return dummy.next;
    }
}
