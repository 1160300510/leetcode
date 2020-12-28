package Hard;

import java.util.Arrays;
import java.util.Comparator;

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
