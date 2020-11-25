package Easy;

import java.util.Arrays;

public class sortString {
    // 模拟
    public String sortString(String s) {
        int len  = s.length();
        char[] ss = s.toCharArray();
        Arrays.sort(ss);
        boolean[] visited = new boolean[len];
        StringBuilder sb = new StringBuilder();
        int left = 0, right = len-1;
        int cnt = len;
        int leftpre = -1, rightpre = 30;
        while (cnt > 0){
            while(left < len){
                if(ss[left]-'a'>leftpre && visited[left]==false){
                    leftpre = ss[left]-'a';
                    sb.append(ss[left]);
                    visited[left] = true;
                    left++;
                    cnt--;
                }else {
                    left++;
                }
            }
            while (right >= 0){
                if(ss[right]-'a'<rightpre && visited[right]==false){
                    rightpre = ss[right]-'a';
                    sb.append(ss[right]);
                    visited[right] = true;
                    right--;
                    cnt--;
                }else {
                    right--;
                }
            }
            left = 0;
            right = len-1;
            leftpre = -1;
            rightpre = 30;
        }
        return sb.toString();
    }
    // 桶计数
    public String sortString2(String s){
        int len = s.length();
        int[] chars = new int[26];
        for(int i=0; i<len; i++){
            chars[s.charAt(i)-'a']++;
        }
        int cnt = len;
        StringBuilder sb = new StringBuilder();
        while (cnt > 0){
            for(int i=0; i<26; i++){
                if(chars[i]>0){
                    sb.append((char)('a'+i));
                    chars[i]--;
                    cnt--;
                }
            }
            for(int i=25; i>=0; i--){
                if(chars[i]>0){
                    sb.append((char)('a'+i));
                    chars[i]--;
                    cnt--;
                }
            }
        }
        return sb.toString();
    }
}
