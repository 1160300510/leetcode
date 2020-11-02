package Hard;

import java.util.*;

public class wordBreak {
    // https://leetcode-cn.com/problems/word-break-ii/
    Map<Integer, List<List<String>>> map;
    Set<String> set;
    public List<String> wordBreak(String s, List<String> wordDict) {
        map = new HashMap<Integer, List<List<String>>>();
        set = new HashSet<>(wordDict);
        List<List<String>> wordbreaks = backtrack(s, s.length(), 0);
        List<String> ans = new ArrayList<>();
        for(List<String> wordbreak : wordbreaks){
            ans.add(String.join(" ", wordbreak));
        }
        return ans;
    }

    public List<List<String>> backtrack(String s, int length, int index){
        if(!map.containsKey(index)){
            List<List<String>> wordbreaks = new LinkedList<List<String>>();
            if(index == length){
                wordbreaks.add(new LinkedList<>());
            }
            for(int i=index+1; i<=length; i++){
                String sub = s.substring(index, i);
                if(set.contains(sub)){
                    List<List<String>> nextbreaks = backtrack(s, length, i);
                    for(List<String> l : nextbreaks){
                        LinkedList<String> next = new LinkedList<>(l);
                        next.addFirst(sub);
                        wordbreaks.add(next);
                    }
                }
            }
            map.put(index, wordbreaks);
        }
        return map.get(index);
    }
}
