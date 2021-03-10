package Hard;

import java.util.ArrayDeque;
import java.util.Deque;

public class calculate {
    public int calculate(String s) {
        Deque<Integer> ops = new ArrayDeque<>();
        ops.offerLast(1);
        int sign = 1;
        int n = s.length();
        int i = 0;
        int ret = 0;
        while (i < n){
            char c = s.charAt(i);
            if(c == ' '){
                i++;
            }else if(c == '+') {
                sign = ops.peekLast();
                i++;
            }else if(c == '-'){
                sign = -ops.peekLast();
                i++;
            }else if(c == '('){
                ops.offerLast(sign);
                i++;
            }else if(c == ')'){
                ops.pollLast();
                i++;
            }else{
                long num = 0;
                while(i<n && Character.isDigit(s.charAt(i))){
                    num = 10*num + s.charAt(i)-'0';
                    i++;
                }
                ret += sign*num;
            }
        }
        return ret;
    }
}
