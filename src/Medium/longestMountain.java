package Medium;

public class longestMountain {
    public int longestMountain(int[] A) {
        int n = A.length;
        if(n == 0){
            return 0;
        }
        int[] left = new int[n];
        int[] right = new int[n];
        for(int i=1; i<n; i++){
            left[i] = A[i]>A[i-1] ? left[i-1]+1 : 0;
        }
        for(int i=n-2; i>=0; i--){
            right[i] = A[i]>A[i+1] ? right[i+1]+1 : 0;
        }
        int ans = 0;
        for(int i=0; i<n; i++){
            if(left[i]>0 && right[i]>0){
                ans = Math.max(ans, left[i]+right[i]+1);
            }
        }
        return ans;
    }
}
