package Medium;

import DataStructure.TreeNode;

import java.util.*;
public class postorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();

        while(root!=null || !stack.isEmpty()){
            while(root != null){
                ans.add(root.val);
                stack.push(root);
                root = root.right;
            }
            // 走到头了
            // 查看右子树
            root = stack.pop();
            root = root.left;
        }
        // 因为是反过来遍历的，所以还需要翻转回来
        Collections.reverse(ans);
        return ans;
    }
}
