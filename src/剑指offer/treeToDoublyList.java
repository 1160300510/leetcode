package 剑指offer;

import DataStructure.Node;

public class treeToDoublyList {
    Node head = null;
    Node pre = null;
    public Node treeToDoublyList(Node root) {
        if(root == null){
            return root;
        }
        treeToDoublyList(root.left);
        if(head == null){
            head = root;
        }else{
            pre.right = root;
        }
        root.left = pre;
        pre = root;
        treeToDoublyList(root.right);
        pre.right = head;
        head.left = pre;
        return head;
    }
}
