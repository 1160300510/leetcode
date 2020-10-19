package Contest.week211;

import java.util.Arrays;

public class maxLengthBetweenEqualCharacters {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[][] index = new int[26][2];
        for(int i=0; i<26; i++){
            Arrays.fill(index[i], -1);
        }
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(index[c-'a'][0] == -1){
                index[c-'a'][0] = i;
            }else{
                if(i > index[c-'a'][1]){
                    index[c-'a'][1] = i;
                }
            }
        }
        int ans = -1;
        for(int i=0; i<26; i++){
            if(index[i][0]!=-1 && index[i][1]!=-1){
                ans = Math.max(ans, index[i][1]-index[i][0]-1);
            }
        }
        return ans;
    }
}
