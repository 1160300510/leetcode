package 剑指offer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class permutation {
    List<String> ans = new ArrayList<>();
    public String[] permutation(String s) {
        int n = s.length();
        StringBuilder str = new StringBuilder();
        boolean[] visited = new boolean[n];
        dfs(s, n, str, visited);
        return ans.stream().toArray(String[]::new);
    }

    public void dfs(String s, int len, StringBuilder str, boolean[] visited){
        if(str.length() == len){
            ans.add(str.toString());
            return;
        }
        Set<Character> set = new HashSet<>();
        for(int i=0; i<len; ++i){
            if(set.contains(s.charAt(i))) continue;
            if(visited[i] == false){
                set.add(s.charAt(i));
                str.append(s.charAt(i));
                visited[i] = true;
                dfs(s, len, str, visited);
                visited[i] = false;
                str.deleteCharAt(str.length()-1);
            }
        }
    }

}
