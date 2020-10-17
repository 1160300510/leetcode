package Hard;

import java.util.HashSet;
import java.util.Set;

public class totalNQueens {
    Set<Integer> rows = new HashSet<>();
    Set<Integer> cols = new HashSet<>();
    Set<Integer> dig1 = new HashSet<>();
    Set<Integer> dig2 = new HashSet<>();
    int ans = 0;
    public int totalNQueens(int n) {
        dfs(n,0);
        return ans;
    }

    public void dfs(int n, int x){
        if(x == n){
            ans++;
            return;
        }
        for(int i=0; i<n; i++){
            if(!rows.contains(x) && !cols.contains(i) && !dig1.contains(x-i) && !dig2.contains(x+i)){
                rows.add(x);
                cols.add(i);
                dig1.add(x-i);
                dig2.add(x+i);
                dfs(n, x+1);
                rows.remove(x);
                cols.remove(i);
                dig1.remove(x-i);
                dig2.remove(x+i);
            }
        }
    }
}
