package Medium;

import DataStructure.ListNode;

public class removeNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0,head);
        ListNode node = head;
        int sum = 0;
        while(node != null){
            sum++;
            node = node.next;
        }
        ListNode cur = dummy;
        for(int i=1; i<sum-n+1; i++){
            cur = cur.next;
        }
        cur.next = cur.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

    // 一趟扫描，快慢指针，first先走n步
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0,head);
        ListNode first = head;
        ListNode slow = dummy;
        for(int i=0; i<n; i++){
            first = first.next;
        }
        while(first != null){
            first = first.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

}
