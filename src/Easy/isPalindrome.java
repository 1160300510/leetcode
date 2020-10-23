package Easy;

import DataStructure.ListNode;

public class isPalindrome {
    public boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }
        //找中点
        ListNode mid = findmid(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        //翻转链表
        l2 = reverselist(l2);
        //比较
        while (l1!=null && l2!=null){
            if(l1.val != l2.val){
                return false;
            }else{
                l1 = l1.next;
                l2 = l2.next;
            }
        }
        return true;
    }

    public ListNode findmid(ListNode node){
        ListNode slow = node;
        ListNode fast = node;
        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode reverselist(ListNode node){
        ListNode prev = null;
        ListNode cur = node;
        while (cur != null){
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return prev;
    }
}
