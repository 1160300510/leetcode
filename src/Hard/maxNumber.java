package Hard;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;

public class maxNumber {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        // 枚举nums1和nums2长度的(i,j)组合，i+j=k，合并两个子串
        // 和之前合并的串进行比较
        int n1 = nums1.length, n2 = nums2.length;
        int start = Math.max(0, k-n2);
        int end = Math.min(k, n1);
        int[] ans = new int[k];
        for(int i = start; i<=end; i++){
            int[] sequence1 = maxSequence(nums1, i);
            int[] sequence2 = maxSequence(nums2, k-i);
            int[] curMaxsequence = merge(sequence1, sequence2, k);
            if(compare(curMaxsequence,0,ans,0)>0){
                System.arraycopy(curMaxsequence,0,ans,0,k);
            }
        }
        return ans;
    }

    public int[] merge(int[] sequence1, int[] sequence2, int k){
        int[] ans = new int[k];
        int m = sequence1.length;
        int n = sequence2.length;
        int p1 = 0, p2 = 0;
        int p = 0;
        while (p1<m || p2<n){
            if(p1 >= m){
                ans[p++] = sequence2[p2++];
            }else if(p2 >= n){
                ans[p++] = sequence1[p1++];
            }else{
                if(compare(sequence1, p1, sequence2, p2)>0){
                    ans[p++] = sequence1[p1++];
                }else {
                    ans[p++] = sequence2[p2++];
                }
            }
        }
        return ans;
    }

    public int compare(int[] sequence1, int index1, int[] sequence2, int index2){
        int x = sequence1.length;
        int y = sequence2.length;
        while (index1<x && index2<y){
            if(sequence1[index1] == sequence2[index2]){
                index1++;
                index2++;
            }else{
                return sequence1[index1]-sequence2[index2];
            }
        }
        return (x-index1)-(y-index2);
    }

    public int[] maxSequence(int[] nums, int k){
        Deque<Integer> stack = new LinkedList<>();
        int[] ans = new int[k];
        stack.push((int)1e6);
        int n = nums.length;
        for(int i=0; i<n; i++){
            while (nums[i]>stack.peek() && (n-i)>(k-stack.size()+1)){
                stack.pop();
            }
            if(stack.size()-1 < k){
                stack.push(nums[i]);
            }
        }
        while (k>0){
            ans[--k] = stack.pop();
        }
        return ans;
    }
}
