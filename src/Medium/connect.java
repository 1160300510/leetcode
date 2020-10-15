package Medium;
import DataStructure.Node;

public class connect {
    public Node connect(Node root) {
        if(root==null){
            return null;
        }
        dfs(root.left,root.right);
        return root;
    }
    public void dfs(Node left, Node right){
        if(left==null || right==null){
            return;
        }
        left.next = right;
        dfs(left.left,left.right);
        dfs(left.right,right.left);
        dfs(right.left,right.right);
    }

    public Node connect1(Node root){
        Node dummy = new Node(0);
        Node cur = root;
        while (cur != null){
            dummy.next = null;
            Node pre = dummy;
            while(cur != null){
                if(cur.left!=null){
                    pre.next = cur.left;
                    pre = pre.next;
                }
                if(cur.right!=null){
                    pre.next = cur.right;
                    pre = pre.next;
                }
                cur = cur.next;
            }
            cur = dummy.next;
        }
        return root;
    }
}
