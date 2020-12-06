package Easy;

import java.util.ArrayList;
import java.util.List;

public class generate {
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0){
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<Integer>(){{
            add(1);
        }});
        for(int i=1; i<numRows; i++){
            List<Integer> list = ans.get(i-1);
            List<Integer> next = new ArrayList<>();
            for(int j=0; j<=list.size(); j++){
                if(j==0 || j==list.size()){
                    next.add(1);
                }else{
                    next.add(list.get(j)+list.get(j-1));
                }
            }
            ans.add(next);
        }
        return ans;
    }
}
