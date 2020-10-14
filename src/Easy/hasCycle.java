package Easy;

import DataStructure.ListNode;

//https://leetcode-cn.com/problems/linked-list-cycle/
public class hasCycle {
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null){
            return false;
        }
        ListNode fast = head, slow = head;
        while(fast != null){
            if(fast.next != null){
                fast = fast.next.next;
            }else{
                return false;
            }
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
}
