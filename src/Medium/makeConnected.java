package Medium;

public class makeConnected {
    public int makeConnected(int n, int[][] connections) {
        DSU dsu = new DSU(n);
        int extra = 0;
        for(int[] connection : connections){
            int a = connection[0];
            int b = connection[1];
            if(dsu.find(a) != dsu.find(b)){
                dsu.merge(a, b);
            }else{
                extra++;
            }
        }
        int need = dsu.size()-1;
        return extra>=need ? need : -1;
    }
}

