package Medium;

import java.util.*;

public class groupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] s = str.toCharArray();
            Arrays.sort(s);
            String cur = String.valueOf(s);
            //System.out.println(s.toString());
            if(!map.containsKey(cur)){
                map.put(cur, new ArrayList<String>());
            }
            map.get(cur).add(str);
        }
        List<List<String>> ans = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry : map.entrySet()){
            List<String> tmp = new ArrayList<>();
            for(String s : entry.getValue()){
                tmp.add(s);
            }
            ans.add(tmp);
        }
        return ans;
    }

}
