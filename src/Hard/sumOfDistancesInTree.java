package Hard;

import java.util.ArrayList;
import java.util.List;

public class sumOfDistancesInTree {
    int[] ans;
    int[] dp;//dp[u]表示以u为根的子树，它的所有子节点到它的距离之和
    int[] sz;//sz[u]表示以u为根的子树的节点数
    List<List<Integer>> graph;
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        ans = new int[N];
        dp = new int[N];
        sz = new int[N];
        graph = new ArrayList<List<Integer>>();
        for(int i=0; i<N; i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int[] e : edges){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        dfs(0,-1);
        dfs2(0,-1);
        return ans;
    }

    public void dfs(int u, int f){
        dp[u] = 0;
        sz[u] = 1;
        for(int v : graph.get(u)){
            if(v == f){
                continue;
            }
            dfs(v, u);
            dp[u] += dp[v] + sz[v];
            sz[u] += sz[v];
        }
    }

    public void dfs2(int u, int f){
        ans[u] = dp[u];
        for(int v : graph.get(u)){
            if(v == f){
                continue;
            }
            int pu = dp[u];
            int pv = dp[v];
            int su = sz[u];
            int sv = sz[v];

            dp[u] = dp[u]-dp[v]-sz[v];
            sz[u] = sz[u]-sz[v];
            dp[v] = dp[v] + dp[u] + sz[u];
            sz[v] = sz[v] + sz[u];

            dfs2(v, u);
            dp[u] = pu;
            dp[v] = pv;
            sz[u] = su;
            sz[v] = sv;
        }
    }
}
