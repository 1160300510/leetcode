package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class partitionLabels {
    public List<Integer> partitionLabels(String S) {
        List<Integer> ans = new ArrayList<>();
        int[][] index = new int[26][2];
        for(int i=0; i<26; i++){
            Arrays.fill(index[i], -1);
        }
        for(int i=0; i<S.length(); i++){
            char c = S.charAt(i);
            if(index[c-'a'][0] == -1){
                index[c-'a'][0] = i;
            }else{
                index[c-'a'][1] = i;
            }
        }
        int i = 0;
        while (i < S.length()){
            int pos = index[S.charAt(i)-'a'][1];
            if(pos == -1){
                ans.add(1);
                i++;
            }else{
                for(int j=i+1; j<pos; j++){
                    int a = S.charAt(j)-'a';
                    if(index[a][1] > pos){
                        pos = index[a][1];
                    }
                }
                ans.add(pos-i+1);
                i = pos+1;
            }
        }
        return ans;
    }
    public List<Integer> partitionLabels2(String S){
        List<Integer> ans = new ArrayList<>();
        int[] last = new int[26];
        for(int i=0; i<S.length(); i++){
            last[S.charAt(i)-'a'] = i;
        }
        int start = 0, end = 0;
        for(int i=0; i<S.length(); i++){
            end = Math.max(end, last[S.charAt(i)-'a']);
            if(i == end){
                ans.add(end-start+1);
                start = end+1;
            }
        }
        return ans;
    }

}
