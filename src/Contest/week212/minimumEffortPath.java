package Contest.week212;

import java.util.Arrays;

public class minimumEffortPath {

    int m, n;
    int[][] h;
    boolean[][] visited;
    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    public int minimumEffortPath(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        visited = new boolean[m][n];
        this.h = heights;
        int l = 0;
        int r = (int)1e6;
        while(l<r){
            int mid = (l+r)/2;
            for(int i=0; i<m; i++){
                Arrays.fill(visited[i], false);
            }
            dfs(0, 0, heights[0][0],mid);
            if(visited[m-1][n-1]){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return l;
    }

    public void dfs(int i, int j, int src,int t){
        if(i<0 || j<0 || i>=m || j>=n || visited[i][j] || Math.abs(h[i][j]-src)>t){
            return;
        }
        visited[i][j] = true;
        for(int[] dir : dirs){
            int x = i+dir[0];
            int y = j+dir[1];
            dfs(x, y, h[i][j], t);
        }
    }

}
