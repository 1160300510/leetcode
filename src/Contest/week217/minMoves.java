package Contest.week217;

public class minMoves {
    public int minMoves(int[] nums, int limit) {
        // 差分数组
        int[] delta = new int[2 * limit + 2];
        int n = nums.length;
        for(int i=0; i<n/2; i++){
            int A = nums[i], B = nums[n-i-1];
            // [2, 2*limit]之内的操作数+2
            int l = 2, r = 2*limit;
            delta[l] += 2;
            delta[r+1] -= 2;
            //[1+min(A,B), limit+max(A,B)]之内的操作数-1
            l = 1 + Math.min(A, B);
            r = limit + Math.max(A, B);
            delta[l] += -1;
            delta[r+1] -= -1;
            //等于A+B的操作数再-1
            l = A+B;
            r = A+B;
            delta[l] += -1;
            delta[r+1] -= -1;
        }
        int sum = 0;
        int res = n;
        for(int i=2; i<=2*limit; i++){
            sum += delta[i];
            if(sum < res){
                res = sum;
            }
        }
        return res;
    }
}
