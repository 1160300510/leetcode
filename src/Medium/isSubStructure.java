package Medium;

import DataStructure.TreeNode;

public class isSubStructure {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A==null || B==null){
            return false;
        }
        return slove(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }
    public boolean slove(TreeNode A, TreeNode B){
        if(B == null){
            return true;
        }
        if(A == null){
            return false;
        }
        if(A.val != B.val){
            return false;
        }
        return slove(A.left, B.left) && slove(A.right, B.right);
    }
}
