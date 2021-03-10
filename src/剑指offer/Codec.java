package 剑指offer;

import DataStructure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return new String("[]");
        }
        Deque<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node == null){
                sb.append("null,");
            }else{
                sb.append(node.val+",");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("[]")) return null;
        String[] val = data.substring(1,data.length()-1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(val[0]));
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i=1;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(!val[i].equals("null")){
                TreeNode left = new TreeNode(Integer.parseInt(val[i]));
                node.left = left;
                queue.offer(left);
            }
            i++;
            if(!val[i].equals("null")){
                TreeNode right = new TreeNode(Integer.parseInt(val[i]));
                node.right = right;
                queue.offer(right);
            }
            i++;
        }
        return root;
    }
}
