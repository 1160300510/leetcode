package Medium;

import java.util.Arrays;

public class kClosest {
    public int[][] kClosest(int[][] points, int K) {
        int[][] map = new int[points.length][2];
        for(int i=0; i<points.length; i++){
            map[i][0] = i;
            map[i][1] = distance(points[i]);
        }
        Arrays.sort(map, (a, b)->(a[1]-b[1]));
        int[][] ans = new int[K][2];
        for(int i=0; i<K; i++){
            int index = map[i][0];
            ans[i] = points[index];
        }
        return ans;
    }

    public int distance(int[] point){
        return point[0]*point[0] + point[1]*point[1];
    }
}


