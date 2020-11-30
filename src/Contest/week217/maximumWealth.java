package Contest.week217;

import java.util.Arrays;

public class maximumWealth {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for(int[] account : accounts){
            max = Math.max(max, Arrays.stream(account).sum());
        }
        return max;
    }
}
