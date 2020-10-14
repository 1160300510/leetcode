package Medium;

public class checkPalindromeFormation {
    public boolean checkPalindromeFormation(String a, String b) {
        return check(a,b) || check(b,a);
    }

    public boolean check(String a, String b){
        int n = a.length();
        for(int i=0,j=n-1; i<j; i++,j--){
            if(a.charAt(i)!=b.charAt(j)){
                return pa(a,i,j)||pa(b,i,j);
            }
        }
        return true;
    }
    public boolean pa(String s, int left, int right){
        for(int i=left,j=right; i<j; i++,j--){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
