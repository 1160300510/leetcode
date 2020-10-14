package Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class commonChars {
    public List<String> commonChars(String[] A) {
        List<String> ans = new ArrayList<>();
        int[] chars = new int[26];
        Arrays.fill(chars, 101);
        for(String a : A){
            int[] tmp = new int[26];
            for(int i=0; i<a.length(); i++){
                char c = a.charAt(i);
                tmp[c-'a']++;
            }
            for(int j=0; j<26; j++){
                chars[j] = Math.min(chars[j], tmp[j]);
            }
        }
        for(int i=0; i<26; i++){
            if(chars[i] == 0){
                continue;
            }else {
                while(chars[i]!=0){
                    char c = (char)('a'+i);
                    ans.add(String.valueOf(c));
                    chars[i]--;
                }
            }
        }
        return ans;
    }
}
