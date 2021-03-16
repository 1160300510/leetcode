package 剑指offer;

public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int totallen = len1+len2;
        if(totallen % 2 == 1){
            int index = totallen/2;
            return getKthElement(nums1, nums2, index+1);
        }else{
            int index1 = totallen/2-1, index2 = totallen/2;
            return (getKthElement(nums1,nums2,index1+1)+getKthElement(nums1,nums2,index2+1))/2.0;
        }
    }
    public double getKthElement(int[] nums1, int[] nums2, int k){
        int index1 = 0, index2 = 0;
        int len1 = nums1.length;
        int len2 = nums2.length;
        while (true){
            if(index1 >= len1){
                return nums2[index2+k-1];
            }
            if(index2 >= len2){
                return nums1[index1+k-1];
            }
            if(k == 1){
                return Math.min(nums1[index1], nums2[index2]);
            }
            int pivot = k/2;
            int newIndex1 = Math.min(len1, index1+pivot)-1;
            int newIndex2 = Math.min(len2, index2+pivot)-1;
            int a = nums1[newIndex1];
            int b = nums2[newIndex2];
            if(a <= b){
                k -= (newIndex1-index1+1);
                index1 = newIndex1+1;
            }else{
                k -= (newIndex2-index2+1);
                index2 = newIndex2+1;
            }
        }
    }
}
