package Medium;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class preorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();

        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                ans.add(root.val);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return ans;
    }

    public void traversal(TreeNode root){
        if(root == null){
            return;
        }
        ans.add(root.val);
        traversal(root.left);
        traversal(root.right);
    }
}
