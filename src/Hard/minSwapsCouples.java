package Hard;

public class minSwapsCouples {
    public int minSwapsCouples(int[] row) {
        int len = row.length;
        int n = len / 2;
        UnionFind uf = new UnionFind(n);
        for(int i=0; i<len; i+=2){
            uf.merge(row[i]/2, row[i+1]/2);
        }
        return n - uf.setCount;
    }
}
