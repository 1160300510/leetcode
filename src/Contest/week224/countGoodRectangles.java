package Contest.week224;

import java.util.HashMap;
import java.util.Map;

public class countGoodRectangles {
    public int countGoodRectangles(int[][] rectangles) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int[] rectangle : rectangles){
            int min = Math.min(rectangle[0], rectangle[1]);
            int cnt = map.getOrDefault(min, 0);
            map.put(min, cnt+1);
        }
        int ans = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            ans = Math.max(ans, entry.getKey());
        }
        return map.get(ans);
    }
}
