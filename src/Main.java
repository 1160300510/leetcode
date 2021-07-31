import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        String[] line1 = sc.nextLine().split(" ");
        String[] line2 = sc.nextLine().split(" ");
        String[] line3 = sc.nextLine().split(" ");
        int[] val = new int[n];
        int[] preorder = new int[n];
        int[] inorder = new int[n];
        for(int i=0; i<n; ++i){
            val[i] = Integer.valueOf(line1[i]);
            preorder[i] = Integer.valueOf(line2[i]);
            inorder[i] = Integer.valueOf(line3[i]);
        }
        TreeNode root = buildTree(preorder, inorder, val, 0, n-1, 0, n-1);
        TreeNode node = bfs(root);
        if(node == null){
            System.out.println(0);
        }else{
            int sum = 0;
            Deque<TreeNode> queue = new ArrayDeque<>();
            queue.offer(node);
            while (!queue.isEmpty()){
                TreeNode cur = queue.poll();
                sum += cur.val;
                if(cur.left != null){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }
            }
            System.out.println(sum);
        }

        List<Integer> list = new ArrayList<>();

        list.stream().mapToInt(Integer::intValue).toArray();
    }


    public static TreeNode bfs(TreeNode root){
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(isSymmetric(node)){
                return node;
            }
            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
        }
        return null;

    }

    public static boolean isSymmetric(TreeNode root){
        if(root == null) return true;
        return recur(root.left, root.right);
    }

    public static boolean recur(TreeNode l, TreeNode r){
        if(l==null && r==null) return true;
        if(l==null || r==null || l.val!=r.val) return false;
        return recur(l.left, r.right) && recur(l.right, r.left);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder, int[] val, int prestart, int preend, int instart, int inend){
        if(prestart>preend || instart>inend){
            return null;
        }
        //System.out.println(prestart+" "+preend+" "+instart+" "+inend);
        TreeNode root = new TreeNode(val[preorder[prestart]-1]);
        int index = -1;
        for(int i=instart; i<=inend; ++i){
            if(val[preorder[prestart]-1] == val[inorder[i]-1]){
                index = i;
            }
        }
        int leftlen = index-instart;
        int rightlen = inend-index;
        root.left = buildTree(preorder,inorder,val,prestart+1, prestart+leftlen, instart, index-1);
        root.right = buildTree(preorder, inorder, val, preend-rightlen+1, preend, index+1, inend);
        return root;
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val){
        this.val = val;
    }
}
