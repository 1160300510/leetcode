package Hard;

import java.util.Arrays;
import java.util.PriorityQueue;

public class candy {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if(n == 1){
            return 1;
        }
        int[] left = new int[n];
        for(int i=0; i<n; i++){
            if(i>0 && ratings[i]>ratings[i-1]){
                left[i] = left[i-1]+1;
            }else{
                left[i] = 1;
            }
        }
        int right = 1, ans = 0;
        for(int i=n-1; i>=0; i--){
            if(i<n-1 && ratings[i]>ratings[i+1]){
                right++;
            }else{
                right = 1;
            }
            ans += Math.max(left[i], right);
        }
        return ans;
    }
    public int candy2(int[] ratings) {
        int n = ratings.length;
        if(n == 1){
            return 1;
        }
        int[] cnt = new int[n];
        Arrays.fill(cnt, 1);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->{
            if(a[0] == b[0]){
                return a[1]-b[1];
            }else{
                return a[0]-b[0];
            }
        });
        for(int i=0; i<n; i++){
            pq.offer(new int[]{ratings[i], i});
        }
        while(!pq.isEmpty()){
            int[] head = pq.poll();
            int val = head[0];
            int i = head[1];
            if(i==0){
                cnt[i] = val>ratings[i+1] ? cnt[i+1]+1 : cnt[i];
            }else if(i==n-1){
                cnt[i] = val>ratings[i-1] ? cnt[i-1]+1 : cnt[i];
            }else{
                if(ratings[i]>ratings[i-1] || ratings[i]>ratings[i+1]){
                    int a=0, b=0;
                    if(ratings[i]>ratings[i-1]){
                        a = cnt[i-1] + 1;
                    }
                    if(ratings[i]>ratings[i+1]){
                        b = cnt[i+1] + 1;
                    }
                    cnt[i] = Math.max(a, b);
                }
            }
        }

        return Arrays.stream(cnt).sum();
    }
}
