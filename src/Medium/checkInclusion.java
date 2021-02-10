package Medium;

import java.util.HashSet;
import java.util.Set;

public class checkInclusion {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if(n1 > n2){
            return false;
        }
        int[] freq = new int[26];
        int cnt = 0;
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<n1; i++){
            int index = s1.charAt(i)-'a';
            set.add(index);
            if(freq[index] == 0){
                cnt++;
            }
            freq[index]++;
        }
        int left = 0, right = n1-1;
        while (right < n2){
            if(left == 0){
                for(int j=left; j<=right; j++){
                    int idx = s2.charAt(j)-'a';
                    if(set.contains(idx)){
                        if(freq[idx] == 0){
                            continue;
                        }
                        freq[idx]--;
                        if(freq[idx]==0){
                            cnt--;
                        }
                    }
                }
                if(cnt == 0){
                    return true;
                }
            }else{
                int lidx = s2.charAt(left-1)-'a';
                int ridx = s2.charAt(right)-'a';
                if(set.contains(lidx)){
                    if(freq[lidx] == 0){
                        freq[lidx]++;
                        cnt++;
                    }
                }
                if(set.contains(ridx)){
                    if(freq[ridx] == 0){
                        continue;
                    }
                    freq[ridx]--;
                    if(freq[ridx] == 0){
                        cnt--;
                    }
                }
                if(cnt == 0){
                    return true;
                }
            }
            left++;
            right++;
        }
        return false;
    }
}
