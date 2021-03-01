package Medium;

import DataStructure.TreeNode;

public class maxPathSum {
    int maxsum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        postorder(root);
        return maxsum;
    }

    public int postorder(TreeNode root){
        if(root == null){
            return 0;
        }
        // 获取左右子树的最大收益
        //如果说返回值小于0，那么当前节点值加上只会更小，因此抛弃小于0的返回值
        int leftGain = Math.max(0, postorder(root.left));
        int rightGain = Math.max(0, postorder(root.right));
        //计算以该节点为根的子树的最大路径和
        maxsum = Math.max(maxsum, leftGain+rightGain+root.val);
        //向上传递最大收益，只能选择一侧
        return root.val+Math.max(leftGain, rightGain);
    }

}
