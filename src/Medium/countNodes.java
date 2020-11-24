package Medium;

import DataStructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class countNodes {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            ans += size;
            for(int i=0; i<size; i++){
                TreeNode cur = queue.poll();
                if(cur.left != null){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }
            }
        }
        return ans;
    }
    public int countNodes2(TreeNode root){
        if(root == null) return 0;
        int left = countNodes2(root.left);
        int right = countNodes2(root.right);
        return left+right+1;
    }

    public int countNodes3(TreeNode root){
        if (root == null) {
            return 0;
        }
        int level = 0;
        TreeNode node = root;
        while (node.left != null) {
            level++;
            node = node.left;
        }
        int low = 1 << level, high = (1 << (level + 1)) - 1;
        while(low < high){
            int mid = low + (high-low+1)/2;
            if(exist(root, mid, level)){
                low = mid;
            }else{
                high = mid - 1;
            }
        }
        return low;
    }
    public boolean exist(TreeNode root, int k, int level){
        int bits = 1 << (level-1);
        TreeNode node = root;
        while (node!=null && bits>0){
            if((bits & k) == 0){
                node = node.left;
            }else{
                node = node.right;
            }
            bits >>= 1;
        }
        return node!=null;
    }
}
