package Medium;

public class characterReplacement {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        if(n < 2){
            return n;
        }
        int left = 0, right = 0;
        int maxCount = 0;
        int res = 0;
        int[] cnt = new int[26];
        char[] charArray = s.toCharArray();
        while (right < n){
            cnt[charArray[right]-'A']++;
            maxCount = Math.max(cnt[charArray[right]-'A'], maxCount);
            right++;
            if(right-left > maxCount+k){
                cnt[charArray[left]-'A']--;
                left++;
            }
            res = Math.max(res, right-left);
        }
        return res;
    }
}
