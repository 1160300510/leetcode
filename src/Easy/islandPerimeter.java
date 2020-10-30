package Easy;

import java.util.Deque;
import java.util.LinkedList;

public class islandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int ans = 0;
        int m = grid.length, n = grid[0].length;
        Deque<int[]> queue = new LinkedList<>();
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        int[] start = new int[2];
        boolean flag = false;
        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<m && !flag; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    start[0] = i;
                    start[1] = j;
                    flag = true;
                    break;
                }
            }
        }
        queue.offer(start);
        visited[start[0]][start[1]] = true;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int cnt = 0;
            for(int[] dir : dirs){
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if(x>=0 && x<m && y>=0 && y<n && grid[x][y]==1){
                    cnt++;
                    if(!visited[x][y]){
                        queue.offer(new int[]{x,y});
                        visited[x][y] = true;
                    }
                }
            }
            ans += 4 - cnt;
        }
        return ans;
    }
}
