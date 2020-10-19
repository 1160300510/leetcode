package Easy;

import java.util.Deque;
import java.util.LinkedList;

public class backspaceCompare {
    /**
     * 双指针，时间复杂度O(M+N),空间复杂度O(1)
     * @param S
     * @param T
     * @return
     */
    public boolean backspaceCompare(String S, String T) {
        int i = S.length()-1, j = T.length()-1;
        int skipS = 0, skipT = 0;
        while(i>=0 || j>=0){
            while(i >= 0){
                if(S.charAt(i) == '#'){
                    skipS++;
                    i--;
                }else if(skipS != 0){
                    i--;
                    skipS--;
                }else {
                    break;
                }
            }
            while (j >= 0){
                if(T.charAt(j) == '#'){
                    skipT++;
                    j--;
                }else if(skipT != 0){
                    j--;
                    skipT--;
                }else {
                    break;
                }
            }
            if(i>=0 && j>=0){
                if(S.charAt(i) != T.charAt(j)){
                    return false;
                }
            }else {
                if(i>=0 || j>=0){
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;
    }

    /**
     * 栈，时间复杂度O(M+N),空间复杂度O(M+N)
     * @param S
     * @param T
     * @return
     */
    public boolean backspaceCompare2(String S, String T) {
        Deque<Character> stack = new LinkedList<>();
        Deque<Character> stack2 = new LinkedList<>();
        for(int i=0; i<S.length(); i++){
            if(S.charAt(i)=='#'){
                if(stack.isEmpty()){
                    continue;
                }else {
                    stack.pop();
                }
            }else{
                stack.push(S.charAt(i));
            }
        }

        for(int i=0; i<T.length(); i++){
            if(T.charAt(i)=='#'){
                if(stack2.isEmpty()){
                    continue;
                }else {
                    stack2.pop();
                }
            }else{
                stack2.push(T.charAt(i));
            }
        }
        while(!stack.isEmpty() && !stack2.isEmpty()){
            Character a = stack.pop();
            Character b = stack2.pop();
            if(a != b){
                return false;
            }
        }
        return stack.isEmpty()&&stack2.isEmpty();
    }
}
