package Easy;

public class validMountainArray {
    // https://leetcode-cn.com/problems/valid-mountain-array/
    public boolean validMountainArray(int[] A) {
        if(A.length < 3){
            return false;
        }
        int len = A.length;
        int l=0, r=len-1;
        while(l < len){
            if((l+1<len) && (A[l+1] > A[l])){
                l++;
            }else{
                break;
            }
        }
        while(r >=0){
            if((r-1)>=0 && (A[r-1]>A[r])){
                r--;
            }else{
                break;
            }
        }
        return l==r && l!=len-1 && r!=0;
    }
}
