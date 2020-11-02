package Contest.week213;

import java.util.*;

public class furthestBuilding {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        int l = 0, r = n-1;
        while (l <= r){
            int mid = (l + r)/2;
            if(check(heights, bricks, ladders, mid)){
                l = mid+1;
            }else {
                r = mid-1;
            }
        }
        return l;
    }

    public boolean check(int[] heights, int bricks, int ladders, int mid){
        List<Integer> list = new ArrayList<>();
        for(int i=1; i<=mid; i++){
            if(heights[i]-heights[i-1]>0){
                list.add(heights[i]-heights[i-1]);
            }
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for(int i=0; i<list.size(); i++){
            if(ladders > 0){
                ladders--;
                continue;
            }else{
                if(bricks >= list.get(i)){
                    bricks -= list.get(i);
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}
