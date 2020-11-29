package Easy;

import java.util.Arrays;

public class largestPerimeter {
    public int largestPerimeter(int[] A) {
        if(A.length < 3){
            return 0;
        }
        Arrays.sort(A);
        int n = A.length;
        int ans = 0;
        for(int i=n-1; i>=2; i--){
            int a=A[i], b=A[i-1], c=A[i-2];
            if(b+c>a){
                ans = a+b+c;
                return ans;
            }
        }
        return ans;
    }
}
