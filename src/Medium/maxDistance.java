package Medium;

import java.util.Arrays;
import java.util.Map;

public class maxDistance {
    public int maxDistance(int[] position, int m) {
        int l = 0;
        int r = (int)1e9;
        int ans = 0;
        Arrays.sort(position);
        while(l <= r){
            int mid = (l+r)/2;
            if(check(position, mid, m)){
                ans = mid;
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return ans;
    }

    public boolean check(int[] position, int distance, int m){
        int i = 0;
        int count = 1;
        for(int j=1; j<position.length; j++){
            if(position[j]-position[i]>=distance){
                count++;
                i = j;
            }
            if(count >= m){
                return true;
            }
        }
        return false;
    }
}
