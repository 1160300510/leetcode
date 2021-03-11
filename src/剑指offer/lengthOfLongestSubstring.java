package 剑指offer;

import java.util.HashMap;
import java.util.Map;

public class lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0){
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int i=0, j=0;
        int ans = 1;
        while(j<n){
            if(i == j){
                map.clear();
                map.put(s.charAt(j), j);
                j++;
            }else{
                char c = s.charAt(j);
                if(!map.containsKey(c)){
                    map.put(c, j);
                    j++;
                }else{
                    ans = Math.max(ans, j-i);
                    i = Math.max(i, map.get(c)+1);
                    map.put(c,j);
                    j++;
                }
            }
        }
        ans = Math.max(ans, j-i);
        return ans;
    }
}
