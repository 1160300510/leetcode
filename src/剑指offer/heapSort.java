package 剑指offer;

public class heapSort {
    public void heapSort(int[] nums){
        int n = nums.length;
        createHeap(nums);
        //nums[0:i-1]有序
        for(int i=n-1; i>=0; --i){
            swap(nums, i, 0);
            downadjust(nums,0,i-1);
        }
    }

    public void createHeap(int[] nums){
        int n = nums.length;
        for(int i=(n-1)/2; i>=0; --i){
            downadjust(nums, i, n-1);
        }
    }

    public void downadjust(int[] nums, int low, int high){
        int i = low;//当前结点索引
        int j = 2*low+1;//左儿子结点索引
        while(j <= high){
            //左右儿子结点比较,两者中大的与父节点比较
            if(j+1<=high && nums[j]<nums[j+1]){
                j += 1;
            }
            //父节点与儿子结点比较
            if(nums[i] < nums[j]){
                swap(nums, i, j);
                i = j;
                j = 2*i+1;
            }else{
                break;
            }
        }
    }

    public void upAdjust(int[] nums, int low, int high){
        int i = high;//子节点
        int j = (i-1)/2;//父节点
        while (j >= low){
            if(nums[j] < nums[i]){
                swap(nums, i, j);
                i = j;
                j = (i-1)/2;
            }else{
                break;
            }
        }
    }

    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
