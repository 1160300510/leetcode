package Medium;

import java.util.PriorityQueue;

public class minCostConnectPoints {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        DSU dsu = new DSU(n);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[0]-b[0]));
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int[] x = points[i];
                int[] y = points[j];
                int val = Math.abs(x[0]-y[0])+Math.abs(x[1]-y[1]);
                pq.offer(new int[]{val, i, j});
            }
        }
        int ans = 0;
        while (!pq.isEmpty()){
            int[] now = pq.poll();
            if(dsu.find(now[1]) != dsu.find(now[2])){
                dsu.merge(now[1], now[2]);
                ans += now[0];
            }else{
                continue;
            }
        }
        return ans;
    }
}
