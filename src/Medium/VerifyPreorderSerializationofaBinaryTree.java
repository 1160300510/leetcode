package Medium;

import java.util.LinkedList;
import java.util.List;

public class VerifyPreorderSerializationofaBinaryTree {
    public boolean isValidSerialization(String preorder) {
        String[] strs = preorder.split(",");
        int n = strs.length;
        LinkedList<String> s = new LinkedList<>();
        int i = 0;
        while(i < n){
            s.push(strs[i]);
            while(s.size()>=3 && s.get(0).equals("#") && s.get(1).equals("#") && !s.get(2).equals("#")){
                s.pop();
                s.pop();
                s.pop();
                s.push("#");
            }
            i++;
        }
        return s.size()==1 && s.peek().equals("#");
    }
}
