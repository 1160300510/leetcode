package Easy;

import java.util.*;

public class intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<nums1.length; i++){
            set.add(nums1[i]);
        }
        for(int i=0; i<nums2.length; i++){
            if(set.contains(nums2[i])){
                ans.add(nums2[i]);
                set.remove(nums2[i]);
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
