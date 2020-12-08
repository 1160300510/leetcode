package Medium;

import java.util.ArrayList;
import java.util.List;

public class splitIntoFibonacci {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> list = new ArrayList<>();
        int n = S.length();
        if(n < 3){
            return list;
        }
        backtrack(list, S, n,0, 0, 0);
        return list;
    }

    public boolean backtrack(List<Integer> list, String S, int len, int index, int sum, int prev){
        if(index == len){
            return list.size()>=3;
        }
        long curLong = 0;
        for(int i=index; i<len; i++){
            if(i>index && S.charAt(index)=='0'){
                break;
            }
            curLong = curLong*10 + S.charAt(i)-'0';
            if(curLong > Integer.MAX_VALUE){
                break;
            }
            int cur = (int)curLong;
            if(list.size()>=2){
                if(cur > sum){
                    break;
                }else if(cur < sum){
                    continue;
                }
            }
            list.add(cur);
            if(backtrack(list, S, len, i+1, prev+cur, cur)){
                return true;
            }else{
                list.remove(list.size()-1);
            }
        }
        return false;
    }
}
