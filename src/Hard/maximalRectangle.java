package Hard;

import java.util.Arrays;

public class maximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if(m == 0){
            return 0;
        }
        int n = matrix[0].length;
        if(m==1 &&  n==1){
            return matrix[0][0]-'0';
        }
        int[][] mar = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                mar[i][j] = matrix[i][j]-'0';
            }
        }
        int ans = 0;
        for(int i=0; i<m; i++){
            int[] bit = new int[n];
            int l = 0;
            int max = 0;
            for(int k=0; k<n; k++){
                bit[k] = mar[i][k];
                if(bit[k] == 1){
                    l++;
                }else{
                    max = Math.max(max, l);
                    l = 0;
                }
            }
            max = Math.max(max, l);
            ans = Math.max(ans, max);
            for(int j=i+1; j<m; j++){
                for(int k=0; k<n; k++){
                    bit[k] = bit[k] & mar[j][k];
                }
                int len = 0;
                int maxlen = 0;
                for(int x=0; x<n; x++){
                    if(bit[x] == 1){
                        len++;
                    }else{
                        maxlen = Math.max(maxlen, len);
                        len = 0;
                    }
                }
                maxlen = Math.max(maxlen, len);
                ans = Math.max(ans, maxlen*(j-i+1));
            }
        }
        return ans;
    }
}
