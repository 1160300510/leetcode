package Hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class numSimilarGroups {
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        UnionFind uf = new UnionFind(n);
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            if(map.containsKey(strs[i])){
                uf.merge(map.get(strs[i]), i);
            }else {
                map.put(strs[i], i);
            }
        }
        int len = strs[0].length();
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(uf.connected(uf.find(i), uf.find(j))){
                    continue;
                }
                int cnt = 0;
                for(int k=0; k<len; k++){
                    if(strs[i].charAt(k) != strs[j].charAt(k)){
                        cnt++;
                    }
                }
                if(cnt == 2){
                    uf.merge(i, j);
                }
            }
        }
        return uf.setCount;
    }
}

class UnionFind{
    int[] p;
    int[] size;
    int setCount;
    int n;
    public UnionFind(int n){
        this.n = n;
        p = new int[n];
        size = new int[n];
        setCount = n;
        for(int i=0; i<n; i++){
            p[i] = i;
            size[i] = 1;
        }
    }
    public int find(int a){
        if(p[a] == a){
            return a;
        }else{
            return p[a] = find(p[a]);
        }
    }
    public void merge(int a, int b){
        a = find(a);
        b = find(b);
        if(a == b){
            return;
        }
        p[b] = a;
        size[a] += size[b];
        setCount--;
    }

    public boolean connected(int a, int b){
        a = find(a);
        b = find(b);
        return a==b;
    }
}
