package 剑指offer;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

import DataStructure.ListNode;

public class printListFromTailToHead {
    // 栈实现
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Deque<ListNode> stack = new LinkedList<>();
        while(listNode != null){
            stack.push(listNode);
            listNode = listNode.next;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(!stack.isEmpty()){
            ans.add(stack.pop().val);
        }
        return ans;
    }
    // 递归实现
    ArrayList<Integer> ans = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        if(listNode != null){
            if(listNode.next != null){
                printListFromTailToHead1(listNode.next);
            }
            ans.add(listNode.val);
        }
        return ans;
    }
}
