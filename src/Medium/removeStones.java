package Medium;

import java.util.HashSet;
import java.util.Set;

public class removeStones {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        DSU dsu = new DSU(n);
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(stones[i][0] == stones[j][0] || stones[i][1]==stones[j][1]){
                    dsu.merge(i, j);
                }
            }
        }
        return n-dsu.size();
    }
}

class DSU{
    int[] p;
    int[] rank;
    public DSU(int n){
        p = new int[n];
        rank = new int[n];
        reset();
    }

    public int size(){
        int n = p.length;
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<n; i++){
            set.add(find(i));
        }
        return set.size();
    }

    public void reset(){
        for(int i=0; i<p.length; i++){
            p[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int a){
        if(p[a] == p[p[a]]){
            return p[a];
        }
        return p[a] = find(p[a]);
    }

    public void merge(int a, int b){
        a = find(a);
        b = find(b);
        if(a == b){
            return;
        }
        if(rank[a] == rank[b]){
            rank[a]++;
        }
        if(rank[a] < rank[b]){
            int tmp = a;
            a = b;
            b = tmp;
        }
        p[b] = a;
    }
}
