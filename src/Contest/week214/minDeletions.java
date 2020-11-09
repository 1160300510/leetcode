package Contest.week214;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class minDeletions {
    public int minDeletions(String s) {
        int[] cnt = new int[26];
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            cnt[c-'a']++;
        }
        Arrays.sort(cnt);
        int ans = 0;
        boolean[] flag = new boolean[(int)1e5+1];
        for(int i=0; i<26; i++){
            flag[cnt[i]] = true;
        }
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<26; i++){
            if(cnt[i] == 0){
                continue;
            }
            if(set.contains(cnt[i])){
                for(int j=cnt[i]-1; j>=0; j--){
                    if(flag[j]==false){
                        ans += cnt[i] - j;
                        cnt[i] = j;
                        set.add(j);
                        if (j != 0){
                            flag[j] = true;
                        }
                        break;
                    }
                }
            }else{
                set.add(cnt[i]);
            }
        }
        return ans;
    }
}
