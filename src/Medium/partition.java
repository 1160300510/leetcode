package Medium;

import java.util.ArrayList;
import java.util.List;

public class partition {
    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> partition(String s) {
        List<String> tmp = new ArrayList<>();
        dfs(s, tmp, 0, s.length());
        return ans;
    }

    public void dfs(String s, List<String> tmp, int start, int len){
        if(start==len && tmp.size()>0){
            ans.add(new ArrayList<String>(tmp));
            return;
        }
        for(int i=start+1; i<=len; i++){
            String str = s.substring(start, i);
            if(isPalindrome(str)){
                tmp.add(str);
                dfs(s, tmp, i, len);
                tmp.remove(tmp.size()-1);
            }
        }
    }

    public boolean isPalindrome(String s){
        if(s.length() == 1){
            return true;
        }
        int l = 0, r = s.length()-1;
        while (l<r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
