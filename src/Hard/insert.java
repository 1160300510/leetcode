package Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class insert {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int start = newInterval[0];
        int end = newInterval[1];
        List<int[]> list = new ArrayList<>();
        for(int[] interval : intervals){
            if(interval[0] > end){
                list.add(interval);
            }else if(interval[1] < start){
                list.add(interval);
            }else {
                start = Math.min(start, interval[0]);
                end = Math.max(end, interval[1]);
            }
        }
        list.add(new int[]{start, end});
        int[][] ans = new int[list.size()][2];
        for(int i=0; i<list.size(); i++){
            ans[i] = list.get(i);
        }
        Arrays.sort(ans, ((o1, o2) -> o1[0]-o2[0]));
        return ans;
    }
}
