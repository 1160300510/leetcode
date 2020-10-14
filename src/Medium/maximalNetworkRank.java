package Medium;

public class maximalNetworkRank {
    public int maximalNetworkRank(int n, int[][] roads) {
        int m = roads.length;
        int[] node = new int[n];
        int[][] adj = new int[n][n];
        for(int[] road : roads){
            node[road[0]]++;
            node[road[1]]++;
            adj[road[0]][road[1]] = 1;
            adj[road[1]][road[0]] = 1;
        }
        int ans = 0;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                ans = Math.max(ans, node[i]+node[j]-adj[i][j]);
            }
        }
        return ans;
    }
}
