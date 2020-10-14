package Easy;
//https://leetcode-cn.com/problems/maximum-nesting-depth-of-the-parentheses/
public class maxDepth {
    public int maxDepth(String s) {
        int ans=0, depth=0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                depth++;
                ans = Math.max(ans, depth);
            }
            if(c == ')'){
                depth--;
            }
        }
        return ans;
    }
}
