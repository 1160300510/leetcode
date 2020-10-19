package Contest.week211;

import java.util.ArrayList;
import java.util.List;
import DataStructure.DSU;

public class areConnected {
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        DSU dsu = new DSU(n+1);
        for(int i=threshold+1; i<=n; i++){
            for(int j=i*2; j<=n; j+=i){
                dsu.merge(i,j);
            }
        }
        List<Boolean> ans = new ArrayList<>();
        for(int[] query : queries){
            int u = query[0], v = query[1];
            ans.add(dsu.find(u)==dsu.find(v));
        }
        return ans;
    }
}

