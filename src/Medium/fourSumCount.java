package Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class fourSumCount {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int ans = 0;
        Map<Integer, Integer> mapAB = new HashMap<>();
        for(int a : A){
            for(int b : B){
                mapAB.put(a+b, mapAB.getOrDefault(a+b, 0)+1);
            }
        }
        for(int c : C){
            for (int d : D){
                ans += mapAB.getOrDefault(-(c+d), 0);
            }
        }
        return ans;
    }
}
