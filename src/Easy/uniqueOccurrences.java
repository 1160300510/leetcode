package Easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class uniqueOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int a : arr){
            map.put(a, map.getOrDefault(a,0)+1);
        }
        Set<Integer> set = new HashSet<>();
        for(Integer key : map.keySet()){
            if(set.contains(map.get(key))){
                return false;
            }else{
                set.add(map.get(key));
            }
        }
        return true;
    }
}
