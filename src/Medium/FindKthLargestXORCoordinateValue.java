package Medium;

import java.util.Arrays;

public class FindKthLargestXORCoordinateValue {
    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=0; i<m; ++i){
            for(int j=1; j<n; ++j){
                matrix[i][j] ^= matrix[i][j-1];
            }
        }
        for(int i=1; i<m; ++i){
            for(int j=0; j<n; ++j){
                matrix[i][j] ^= matrix[i-1][j];
            }
        }
        int[] xor = new int[m*n];
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                int index = i*n + j;
                xor[index] = matrix[i][j];
            }
        }
        Arrays.sort(xor);
        return xor[m*n-k];
    }
}
