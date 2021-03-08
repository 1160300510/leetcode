package 剑指offer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class spiralOrder {
    List<Integer> list;
    int m, n;
    int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};//右、下、左、上四个方向
    public int[] spiralOrder(int[][] matrix) {
        this.m = matrix.length;
        if(m == 0){
            return new int[]{};
        }
        this.n = matrix[0].length;
        list = new ArrayList<>();
        boolean[][] visited = new boolean[m][n];
        dfs(0, 0, visited, matrix, 0);
        return list.stream().mapToInt(i->i).toArray();
    }
    public void dfs(int x, int y, boolean[][] visited, int[][] matrix, int direction){
        list.add(matrix[x][y]);
        visited[x][y] = true;
        for(int i=0; i<4; i++){
            direction = (direction+i)%4;
            int newx = dirs[direction][0]+x;
            int newy = dirs[direction][1]+y;
            if(newx>=0 && newx<m && newy>=0 && newy<n && !visited[newx][newy]){
                dfs(newx, newy, visited, matrix, direction);
            }
        }
    }
}
