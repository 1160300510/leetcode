package 剑指offer;

import DataStructure.TreeNode;
import java.util.HashMap;
import java.util.Map;

public class reConstructBinaryTree {
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        for(int i=0; i<in.length; i++){
            map.put(in[i], i);
        }
        TreeNode root = reConstructBinaryTree(pre, 0, pre.length-1, 0);
        return root;
    }

    public TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL){
        if(preL > preR){
            return null;
        }
        TreeNode root = new TreeNode(pre[preL]);
        int index = map.get(pre[preL]);
        int leftsize = index-inL;
        root.left = reConstructBinaryTree(pre, preL+1, preL+leftsize, inL);
        root.right = reConstructBinaryTree(pre, preL+leftsize+1, preR, index+1);
        return root;
    }
}
