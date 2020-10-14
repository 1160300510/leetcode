package Medium;

import DataStructure.ListNode;

public class swapPairs {
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode ans = head.next;
        ListNode node = head;
        ListNode pre = null;
        while(node!=null && node.next!=null){
            swap(pre, node, node.next);
            pre = node;
            node = node.next;
        }
        return ans;
    }

    public void swap(ListNode pre, ListNode node1, ListNode node2){
        node1.next = node2.next;
        node2.next = node1;
        if(pre!=null){
            pre.next = node2;
        }
    }
}
