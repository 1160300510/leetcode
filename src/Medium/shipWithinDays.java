package Medium;

public class shipWithinDays {
    public int shipWithinDays(int[] weights, int D) {
        int l = 0, r = 0;
        for(int i=0; i<weights.length; i++){
            l = Math.max(l, weights[i]);
            r += weights[i];
        }
        while(l <= r){
            int mid = (l+r)/2;
            if(check(weights, D, mid)){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return l;
    }

    public boolean check(int[] weights, int D, int m){
        int sum = 0, cnt = 0;
        for(int weight : weights){
            if(sum + weight <= m){
                sum += weight;
            }else {
                sum = weight;
                cnt++;
            }
        }
        return D>=cnt;
    }
}
