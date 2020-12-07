package Medium;

public class matrixScore {
    public int matrixScore(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        for(int i=0; i<m; i++){
            if(A[i][0] == 0){
                for(int j=0; j<n; j++){
                    if(A[i][j] == 1){
                        A[i][j] = 0;
                    }else{
                        A[i][j] = 1;
                    }
                }
            }
        }
        for(int j=0; j<n; j++){
            int cnt = 0;
            for(int i=0; i<m; i++){
                if(A[i][j] == 0){
                    cnt++;
                }
            }
            if(cnt > (m-cnt)){
                for(int i=0; i<m; i++){
                    if(A[i][j] == 1){
                        A[i][j] = 0;
                    }else{
                        A[i][j] = 1;
                    }
                }
            }
        }
        int sum = 0;
        for(int i=0; i<m; i++){
            int tmp = 0;
            for(int j=0; j<n; j++){
                tmp = (tmp<<1) + A[i][j];
            }
            sum += tmp;
        }
        return sum;
    }
}
