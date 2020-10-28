package Medium;

public class minEatingSpeed {
    // https://leetcode-cn.com/problems/koko-eating-bananas/
    public int minEatingSpeed(int[] piles, int H) {
        int l = 1, r = (int)1e9;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(check(piles, H, mid)){
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return l;
    }

    public boolean check(int[] piles, int H, int speed){
        int cnt = 0;
        for(int pile : piles){
            cnt += (pile-1)/speed + 1;
        }
        return cnt <= H;
    }
}
