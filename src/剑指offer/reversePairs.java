package 剑指offer;

public class reversePairs {
    int ans = 0;
    public int reversePairs(int[] nums) {
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        mergeSort(nums, 0, n-1);
        return ans;
    }
    public void mergeSort(int[] nums, int l, int r){
        if(l >= r){
            return;
        }
        int mid = (l+r)>>1;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid+1, r);

        //计算逆序对
        int i=mid, j=r;
        for(; i>=l; --i){
            while(j>mid && nums[j] >= nums[i]){
                j--;
            }
            ans += j-mid;
        }
        //归并
        int[] tmp = new int[r-l+1];
        int m = l, n = mid+1;
        int k = 0;
        while(m<=mid && n<=r){
            if(nums[m] <= nums[n]){
                tmp[k++] = nums[m++];
            }else{
                tmp[k++] = nums[n++];
            }
        }
        while(m <= mid){
            tmp[k++] = nums[m++];
        }
        while (n <= r){
            tmp[k++] = nums[n++];
        }
        for(int a=0; a<=(r-l); a++){
            nums[a+l] = tmp[a];
        }
    }
}
