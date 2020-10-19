package Contest.week211;

public class findLexSmallestString{
    //https://leetcode-cn.com/problems/lexicographically-smallest-string-after-applying-operations/
    public String findLexSmallestString(String s, int a, int b) {
        String ans = s;
        int len = s.length();
        for(int i=0; i<len; i++){
            // 轮转
            s = s.substring(b, len) + s.substring(0,b);
            for(int j=0; j<=9; j++){
                char[] chars = s.toCharArray();
                // 修改奇数位置
                for(int k=1; k<len; k+=2){
                    chars[k] += a;
                    if(chars[k] > '9'){
                        chars[k] = (char)('0' + (chars[k]-'9'-1));
                    }
                }
                if(b % 2 == 1){
                    // b为奇数，此时通过轮转，也能修改偶数位置
                    for (int m=0; m<=9; m++){
                        for(int k=0; k<len; k+=2){
                            chars[k] += a;
                            if(chars[k] > '9'){
                                chars[k] = (char)('0' + (chars[k]-'9'-1));
                            }
                        }
                        s = new String(chars);
                        if(s.compareTo(ans)<0){
                            ans = s;
                        }
                    }
                }else{
                    s = new String(chars);
                    if(s.compareTo(ans)<0){
                        ans = s;
                    }
                }
            }
        }
        return ans;
    }
}