package Hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class subarraysWithKDistinct {
    public int subarraysWithKDistinct(int[] A, int K) {
        //K个不同整数的子数组 = 最多包含K个不同整数的子数组-最多包含K-1个不同整数的子数组
        return subarraysWithKMost(A, K) - subarraysWithKMost(A, K-1);
    }

    public int subarraysWithKMost(int[] A, int k) {
        int n = A.length;
        int left = 0, right = 0;
        int[] freq = new int[n+1];
        int res = 0;
        int cnt = 0;
        while (right < n){
            if(freq[A[right]] == 0){
                cnt++;
            }
            freq[A[right]]++;
            right++;
            while (cnt > k){
                freq[A[left]]--;
                if(freq[A[left]] == 0){
                    cnt--;
                }
                left++;
            }
            res += right-left;
        }
        return res;
    }
}
