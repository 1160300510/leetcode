package Medium;

import DataStructure.TreeNode;

import java.util.*;

public class zigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int flag = 0;
        List<List<Integer>> ans = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int cnt = queue.size();
            for(int i=0; i<cnt; i++){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            if(flag == 0){
                ans.add(list);
            }else{
                Collections.reverse(list);
                ans.add(list);
            }
            flag ^= 1;
        }
        return ans;
    }
}
