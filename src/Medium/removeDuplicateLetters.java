package Medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class removeDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        int[] cnt = new int[26];
        for(int i=0; i<s.length(); i++){
            cnt[s.charAt(i)-'a']++;
        }
        Deque<Character> stack = new ArrayDeque<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(stack.contains(c)){
                cnt[c-'a']--;
                continue;
            }
            if(stack.isEmpty()){
                stack.push(c);
                cnt[c-'a']--;
            }else{
                while (!stack.isEmpty()){
                    char top = stack.peek();
                    if(c < top && cnt[top-'a']!=0){
                        stack.pop();
                    }else{
                        break;
                    }
                }
                stack.push(c);
                cnt[c-'a']--;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.getLast());
            stack.removeLast();
        }
        return sb.toString();
    }
}
