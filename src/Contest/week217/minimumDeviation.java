package Contest.week217;

import java.util.TreeSet;

public class minimumDeviation {
    public int minimumDeviation(int[] nums) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for(int i=0; i<nums.length; i++){
            if(nums[i] % 2 != 0){
                treeSet.add(nums[i] * 2);
            }else{
                treeSet.add(nums[i]);
            }
        }
        int res = treeSet.last() - treeSet.first();
        while (res > 0 && treeSet.last()%2==0){
            int max = treeSet.last();
            treeSet.remove(max);
            treeSet.add(max / 2);
            res = Math.min(res, treeSet.last()-treeSet.first());
        }
        return res;
    }
}
