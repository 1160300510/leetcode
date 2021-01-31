package Hard;

public class hitBricks {
    private int rows, cols;
    int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    public int[] hitBricks(int[][] grid, int[][] hits) {
        rows = grid.length;
        cols = grid[0].length;
        int size = rows * cols;
        DSU dsu = new DSU(size+1);
        // 第一步，复制输入
        int[][] copy = new int[rows][cols];
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                copy[i][j] = grid[i][j];
            }
        }
        //第二步，打碎砖块，逆向思考
        for(int[] hit : hits){
            copy[hit[0]][hit[1]] = 0;
        }
        for(int i=0; i<cols; i++){
            if(copy[0][i] == 1){
                dsu.merge(size, getIndex(0, i));
            }
        }
        for(int i=1; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(copy[i][j] == 1){
                    if(copy[i-1][j] == 1){
                        dsu.merge(getIndex(i-1,j), getIndex(i,j));
                    }
                    if(j>0 && copy[i][j-1]==1){
                        dsu.merge(getIndex(i,j-1), getIndex(i,j));
                    }
                }
            }
        }
        //第三步，补上砖块
        int hitlen = hits.length;
        int[] res = new int[hitlen];
        for(int i=hitlen-1; i>=0; i--){
            int[] hit = hits[i];
            if(grid[hit[0]][hit[1]] == 0){
                continue;
            }
            int origin = dsu.getSize(size);
            if(hit[0] == 0){
                dsu.merge(size, getIndex(hit[0], hit[1]));
            }
            for(int j=0; j<4; j++){
                int newX = hit[0]+dirs[j][0];
                int newY = hit[1]+dirs[j][1];
                if(newX>=0 && newX<rows && newY>=0 && newY<cols && copy[newX][newY]==1){
                    dsu.merge(getIndex(newX,newY), getIndex(hit[0],hit[1]));
                }
            }
            int current = dsu.getSize(size);
            res[i] = Math.max(current-origin-1, 0);
            copy[hit[0]][hit[1]] = 1;
        }
        return res;
    }

    private int getIndex(int i, int j){
        return i*cols + j;
    }
}

class DSU {
    private int[] p;
    private int[] rank;
    private int[] size;
    public DSU(int n){
        p = new int[n];
        rank = new int[n];
        size = new int[n];
        reset();
    }
    public void reset(){
        for(int i=0; i<p.length; i++){
            p[i] = i;
            rank[i] = 0;
            size[i] = 1;
        }
    }
    public int find(int a){
        if(p[a] == p[p[a]]){
            return p[a];
        }
        return p[a] = find(p[a]);
    }

    public void merge(int a, int b){
        a = find(a);
        b = find(b);
        if(a == b){
            return;
        }
        if(rank[a] == rank[b]){
            rank[a]++;
        }
        if(rank[a] < rank[b]){
            int tmp = a;
            a = b;
            b = tmp;
        }
        p[b] = a;
        size[a] += size[b];
    }

    public int getSize(int a){
        a = find(a);
        return size[a];
    }

    public boolean connected(int a, int b){
        return find(a) == find(b);
    }
}
