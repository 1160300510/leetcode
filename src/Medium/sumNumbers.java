package Medium;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class sumNumbers {
    // https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
    int ans = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        dfs(root, 0);
        return ans;
    }

    public void dfs(TreeNode root, int val){
        if(root.left==null && root.right==null){
            val = val*10 + root.val;
            ans += val;
            return;
        }
        val = 10*val + root.val;
        if(root.left != null){
            dfs(root.left, val);
        }
        if(root.right != null){
            dfs(root.right, val);
        }
    }
}
