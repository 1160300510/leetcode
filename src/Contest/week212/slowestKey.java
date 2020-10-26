package Contest.week212;

public class slowestKey {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int[] chars = new int[26];
        int n = releaseTimes.length;
        for(int i=0; i<n; i++){
            if(i!=0){
                int time = releaseTimes[i]-releaseTimes[i-1];
                char c = keysPressed.charAt(i);
                chars[c-'a'] = Math.max(chars[c-'a'],time);
            }else{
                char c = keysPressed.charAt(i);
                chars[c-'a'] = Math.max(chars[c-'a'],releaseTimes[i]);
            }
        }
        int max = 0;
        char ans = 'a';
        for(int i=0; i<26; i++){
            if(chars[i] >= max){
                ans = (char)('a'+i);
                max = chars[i];
            }
        }
        return ans;
    }
}
