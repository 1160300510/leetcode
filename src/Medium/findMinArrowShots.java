package Medium;

import java.util.Arrays;

public class findMinArrowShots {
    // 按右端排序
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0) return 0;
        Arrays.sort(points, (a, b)->a[1]<b[1]?-1:1);
        int ans = 1;
        int right = points[0][1];
        for(int i=1; i<points.length; i++){
            if(points[i][0] > right){
                ans++;
                right = points[i][1];
            }
        }
        return ans;
    }
    // 按左端排序
    public int findMinArrowShots2(int[][] points) {
        if(points.length == 0) return 0;
        Arrays.sort(points, (a, b)->a[0]<b[0]?-1:1);
        int ans = 1;
        int right = points[0][1];
        for(int i=1; i<points.length; i++){
            if(points[i][0] > right){
                ans++;
                right = points[i][1];
            }
            right = Math.min(right, points[i][1]);
        }
        return ans;
    }
}
