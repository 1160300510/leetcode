package Hard;

import java.util.Arrays;

public class maxNumEdgesToRemove {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        DSU alice = new DSU(n);
        DSU bob = new DSU(n);
        int ans = 0;
        Arrays.sort(edges, (a, b)->(b[0]-a[0]));
        for(int[] edge : edges){
            int a = edge[1];
            int b = edge[2];
            if(edge[0] == 3){
                if(alice.find(a) != alice.find(b)){
                    alice.merge(a, b);
                    bob.merge(a, b);
                }else{
                    ans++;
                }
            }else if(edge[0] == 2){
                if(bob.find(a) != bob.find(b)){
                    bob.merge(a, b);
                }else{
                    ans++;
                }
            }else if(edge[0] == 1){
                if(alice.find(a) != alice.find(b)){
                    alice.merge(a, b);
                }else{
                    ans++;
                }
            }
        }
        if(alice.getSize(1)!=n || bob.getSize(1)!=n){
            return -1;
        }else{
            return ans;
        }
    }
}

