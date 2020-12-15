package Medium;

import java.util.Arrays;

public class monotoneIncreasingDigits {
    public int monotoneIncreasingDigits(int N) {
        String n = String.valueOf(N);
        int len = n.length();
        char[] tmp = new char[len];
        for(int i=0; i<len; i++){
            int l = 0;
            if(i != 0){
                l = n.charAt(i-1) - '0';
            }
            int r = 9;
            while (r >= l){
                char c = (char)('0'+r);
                Arrays.fill(tmp,i,len,c);
                String s = String.valueOf(tmp);
                if(Integer.valueOf(s) > N){
                    r--;
                }else{
                    Arrays.fill(tmp, i, len, (char)('0'+r));
                    break;
                }
            }
        }
        String ans = String.valueOf(tmp);
        return Integer.valueOf(ans);
    }

    public static void main(String[] args) {
        System.out.println(Integer.valueOf("01"));
    }
}
