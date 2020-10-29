package Medium;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class smallestFromLeaf {
    // https://leetcode-cn.com/problems/smallest-string-starting-from-leaf/
    String ans = "";
    List<Integer> list = new ArrayList<>();
    public String smallestFromLeaf(TreeNode root) {
        if(root == null) return null;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root){
        list.add(root.val);
        if(root.left==null && root.right==null){
            StringBuilder sb = new StringBuilder();
            for(int i=list.size()-1; i>=0; i--){
                sb.append((char)(list.get(i)+'a'));
            }
            if (ans.equals("")){
                ans = sb.toString();
            }else{
                if(ans.compareTo(sb.toString()) > 0){
                    ans = sb.toString();
                }
            }
            return;
        }
        if(root.left != null){
            dfs(root.left);
            list.remove(list.size()-1);
        }
        if(root.right != null){
            dfs(root.right);
            list.remove(list.size()-1);
        }
    }
}
