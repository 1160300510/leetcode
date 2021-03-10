package 剑指offer;

import java.util.Arrays;

public class getLeastNumbers {
    public int[] getLeastNumbers(int[] arr, int k) {
        if(k >= arr.length){
            return arr;
        }
        return quickSort(arr, 0, arr.length-1, k);
    }
    public int[] quickSort(int[] arr, int l, int r, int k){
        int pos = partition(arr, l, r);
        if(pos == k){
            return Arrays.copyOf(arr, k);
        }
        return pos>k ? quickSort(arr,l,pos-1,k) : quickSort(arr, pos+1, r, k);
    }

    public int partition(int[] arr, int l, int r){
        int pivot = arr[l];
        int i = l;
        for(int j=l+1; j<=r; j++){
            if(arr[j] <= pivot){
                i++;
                swap(arr, j, i);
            }
        }
        swap(arr, l, i);
        return i;
    }

    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
