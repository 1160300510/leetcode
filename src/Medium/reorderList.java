package Medium;

import DataStructure.ListNode;

import java.util.HashMap;
import java.util.Map;

public class reorderList {
    public void reorderList(ListNode head) {
        if(head == null){
            return;
        }
        int sum = 0;
        ListNode node = head;
        Map<ListNode, ListNode> map = new HashMap<>();
        while(true){
            sum++;
            if(node.next != null){
                map.put(node.next, node);
            }else{
                break;
            }
            node = node.next;
        }
        int count = (sum-1)/2;
        ListNode cur = head;
        while(count != 0){
            ListNode next = cur.next;
            cur.next = node;
            node.next = next;
            node = map.get(node);
            node.next = null;
            cur = cur.next.next;
            count--;
        }
    }
    // 1.找中点
    // 2.反转右半部分链表
    // 3.合并两个链表
    public void reorderList2(ListNode head){
        if(head == null){
            return;
        }
        ListNode mid = findmid(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverseList(l2);
        mergeList(l1, l2);
    }

    public ListNode findmid(ListNode node){
        ListNode slow = node;
        ListNode fast = node;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode node){
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

    public void mergeList(ListNode l1, ListNode l2){
        while(l1!=null && l2!=null){
            ListNode l1tmp = l1.next;
            ListNode l2tmp = l2.next;
            l1.next = l2;
            l1 = l1tmp;
            l2.next = l1;
            l2 = l2tmp;
        }
    }
}
