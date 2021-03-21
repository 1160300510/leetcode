package 剑指offer;

import DataStructure.ListNode;

public class mergeKLists {
    public ListNode mergeKLists(ListNode[] lists){
        int n = lists.length;
        return merge(lists, 0, n-1);
    }

    public ListNode merge(ListNode[] lists, int l, int r){
        if(l == r){
            return lists[l];
        }
        if(l > r){
            return null;
        }
        int mid = (l+r)>>1;
        ListNode left = merge(lists, l, mid);
        ListNode right = merge(lists, mid+1, r);
        return mergeTwoLists(left, right);
    }

    public ListNode mergeTwoLists(ListNode a, ListNode b){
        ListNode head = new ListNode();
        ListNode cur = head;
        while(a!=null && b!=null){
            if(a.val < b.val){
                cur.next = a;
                cur = cur.next;
                a = a.next;
            }else{
                cur.next = b;
                cur = cur.next;
                b = b.next;
            }
        }
        if(a == null) cur.next = b;
        if(b == null) cur.next = a;
        return head.next;
    }
}
