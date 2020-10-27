package Contest.week212;

import java.util.Arrays;
import java.util.Comparator;

public class matrixRankTransform {
    int[] p;//并查集，用于合并相同大小的元素，保证相同大小的元素秩相同，且应为这些相同元素中秩的最大值
    int[] vals;//对应下标的秩的值(下标使用indexs数组中的下标值表示)
    Integer[] indexs;//转换二维下标为一维，存储下标，并按照矩阵中的值大小排序

    public int find(int x){
        if(p[x] == x){
            return p[x];
        }else{
            return p[x] = find(p[x]);
        }
    }
    public void union(int a, int b){
        int pa = find(a), pb = find(b);
        if(pa != pb){
            p[pb] = pa;
        }
    }
    public int[][] matrixRankTransform(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        p = new int[rows * cols];
        vals = new int[rows * cols];
        indexs = new Integer[rows * cols];
        for(int i=0; i<rows*cols; i++){
            indexs[i] = i;
            p[i] = i;
        }
        Arrays.sort(indexs, (Integer i, Integer j)->(matrix[i/cols][i%cols] - matrix[j/cols][j%cols]));

        /* 由于经过排序后，小的元素先考虑，如果出现更新的位置(i, j) 所在的行、列已
           经更新过，那么当前位置的秩必然大于等于已经更新过的位置的秩，因此记录
           i行，j列之前最后一次更新秩的索引，然后根据索引找到最后一次更新的秩的值
           从行列取到最大值就是(i, j)位置的秩了。*/
        int[] rowMaxRank = new int[rows];//rowMaxRank[i] = j 表示第i行目前(上一次更新的)最大的秩是 matrix[i][j] 的秩
        int[] colMaxRank = new int[cols];//colMaxRank[j] = i 表示第j列目前(上一次更新的)最大的秩是 matrix[i][j] 的秩
        // 初始化
        Arrays.fill(rowMaxRank, -1);
        Arrays.fill(colMaxRank, -1);

        int pos = 0; // 遍历矩阵的索引
        while(pos < rows * cols){
            int val = 1;// 每个位置的秩初始值
            int idx = indexs[pos]; // 获得排序后，第pos位置存储的索引
            int i = idx / cols;
            int j = idx % cols;
            //若i行中有更新过的位置
            if(rowMaxRank[i] != -1){
                //获取最后一次更新过的下标，以及秩的值
                int k = rowMaxRank[i];
                int tmpidx = i*cols + k;
                int tmpleader = find(tmpidx);
                int tmpval = vals[tmpleader];

                //相同元素秩相等
                if(matrix[i][j] == matrix[i][k]){
                    //合并相同元素
                    union(idx, tmpidx);
                    val = tmpval;
                }else{
                    //当前元素大于最后一次更新的元素，那么秩也要大于tmpVal
                    val = tmpval + 1;
                }
            }

            //若j列中有更新过的位置
            if(colMaxRank[j] != -1){
                //获取最后一次更新过的下标，以及秩的值
                int k = colMaxRank[j];
                int tmpidx = k * cols + j;
                int tmpleader = find(tmpidx);
                int tmpval = vals[tmpleader];

                if(matrix[i][j] == matrix[k][j]){
                    union(idx, tmpidx);
                    //由于在rowMaxRank[i] != -1 的条件中可能更新过了val，而我们需要的是行、列中最大的秩，故取max
                    val = Math.max(val, tmpval);
                }else {
                    val = Math.max(val, tmpval+1);
                }
            }
            //更新最大秩的索引
            rowMaxRank[i] = j;
            colMaxRank[j] = i;
            //更新当前索引位置的秩的值，由于有相同元素，故只更新当前位置leader的秩的值
            vals[find(idx)] = val;
            pos++;
        }

        int[][] ans = new int[rows][cols];
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                int idx = i * cols + j;
                ans[i][j] = vals[find(idx)];
            }
        }
        return ans;
    }
}
