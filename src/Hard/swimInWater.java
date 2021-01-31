package Hard;

import java.util.PriorityQueue;

public class swimInWater {
    public int swimInWater(int[][] grid) {
        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[2]-b[2]));
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                pq.offer(new int[]{i, j, grid[i][j]});
            }
        }
        DSU dsu = new DSU(m*n);
        int ans = m*n;
        for (int i=0; i<m*n; i++){
            while (!pq.isEmpty() && pq.peek()[2] <= i){
                int[] node = pq.poll();
                for(int[] dir : dirs){
                    int newx = node[0]+dir[0];
                    int newy = node[1]+dir[1];
                    if(newx>=0 && newx<n && newy>=0 && newy<n && grid[newx][newy]<=i){
                        dsu.merge(node[0]*n+node[1], newx*n+newy);
                    }
                }
            }
            if(dsu.connected(0, m*n-1)){
                ans = i;
                break;
            }
        }
        return ans;
    }
}
