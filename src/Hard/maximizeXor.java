package Hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class maximizeXor {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        int n = queries.length;
        Query[] qs = new Query[n];
        for(int i=0; i<n; i++){
            qs[i] = new Query(queries[i][0], queries[i][1]);
        }
        Query[] sorted = qs.clone();
        Arrays.sort(sorted, Comparator.comparingInt(x->x.m));
        int l = 0;
        int height = 30;
        BinaryTree bt = new BinaryTree();
        for(Query query : sorted){
            while (l<nums.length && nums[l]<=query.m){
                bt.add(nums[l], height, 1);
                l++;
            }
            query.ans = bt.size==0 ? -1 : bt.maxXor(query.x, height);
        }
        return Arrays.stream(qs).mapToInt(x->x.ans).toArray();
    }

    public int[] maximizeXor2(int[] nums, int[][] queries){
        TrieNode root = new TrieNode();
        int n = queries.length;
        for(int num : nums){
            TrieNode node = root;
            for(int i=30; i>=0; i--){
                int bit = (num & (1<<i))>0 ? 1 : 0;
                if(!node.children.containsKey(bit)){
                    node.children.put(bit, new TrieNode());
                }
                node = node.children.get(bit);
                node.min = Math.min(node.min, num);
            }
        }

        int[] ans = new int[n];
        for(int i=0; i<n; i++){
            int x = queries[i][0];
            int m = queries[i][1];
            TrieNode node = root;
            int xor = 0;
            for(int j=30; j>=0; j--){
                int bit = (x & (1<<j))>0 ? 1 : 0;
                int targetbit = bit==1 ? 0 : 1;
                if(bit==1){
                    if(node.children.containsKey(0)){
                        node = node.children.get(0);
                        xor ^= (1<<j);
                    }else if(!node.children.containsKey(1) || node.children.get(1).min>m){
                        xor = -1;
                        break;
                    }else{
                        node = node.children.get(1);
                    }
                }else{
                    if(node.children.containsKey(1) && node.children.get(1).min<=m){
                        node = node.children.get(1);
                        xor ^= (1<<j);
                    }else if(!node.children.containsKey(0)){
                        xor = -1;
                        break;
                    }else{
                        node = node.children.get(0);
                    }
                }
            }
            ans[i] = xor;
        }
        return ans;
    }
}

class TrieNode{
    int min = Integer.MAX_VALUE;
    HashMap<Integer, TrieNode> children = new HashMap<>();
}

class Query {
    int x;
    int m;
    int ans = -1;

    public Query(int x, int m) {
        this.x = x;
        this.m = m;
    }
}

class BinaryTree {
    public BinaryTree left;
    public BinaryTree right;
    public int size;

    private BinaryTree get(int i) {
        if (i == 0) {
            if (left == null) {
                left = new BinaryTree();
            }
            return left;
        } else {
            if (right == null) {
                right = new BinaryTree();
            }
            return right;
        }
    }

    public int size(int i) {
        if (i == 0) {
            return left == null ? 0 : left.size;
        }
        return right == null ? 0 : right.size;
    }

    public void add(int x, int height, int mod) {
        if (height < 0) {
            size += mod;
            return;
        }
        get(get(x, height)).add(x, height - 1, mod);
        size += mod;
    }

    public int find(int x, int height) {
        if (height < 0) {
            return size;
        }
        return get(get(x, height)).find(x, height - 1);
    }

    public int kthElement(int k, int height) {
        if (height < 0) {
            return 0;
        }
        if (size(0) >= k) {
            return get(0).kthElement(k, height - 1);
        }
        return get(1).kthElement(k - size(0), height - 1);
    }

    public int prefixSum(int x, int height) {
        if (height < 0) {
            return size;
        }
        int ans = get(get(x, height)).prefixSum(x, height - 1);
        if (get(x, height) == 1) {
            ans += size(0);
        }
        return ans;
    }

    public int interval(int l, int r, int h) {
        int ans = prefixSum(r, h);
        if (l > 0) {
            ans -= prefixSum(l - 1, h);
        }
        return ans;
    }

    public int maxXor(int x, int height) {
        if (height < 0) {
            return 0;
        }
        int prefer = get(x, height) ^ 1;
        int ans;
        if (size(prefer) > 0) {
            ans = get(prefer).maxXor(x, height - 1);
            ans = set(ans, height);
        } else {
            ans = get(1 ^ prefer).maxXor(x, height - 1);
        }
        return ans;
    }

    public int minXor(int x, int height) {
        if (height < 0) {
            return 0;
        }
        int prefer = get(x, height);
        int ans;
        if (size(prefer) > 0) {
            ans = get(prefer).minXor(x, height - 1);
        } else {
            ans = get(1 ^ prefer).minXor(x, height - 1);
            ans = set(ans, height);
        }
        return ans;
    }

    public static int get(int x, int i) {
        return (x >>> i) & 1;
    }

    public static int set(int x, int i) {
        return x | (1 << i);
    }
}
