package Contest.week213;

public class canFormArray {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int arrlen = arr.length;
        int plen = pieces.length;
        int i = 0;
        while (i < arrlen){
            int a = arr[i];
            int flag = i;
            for(int j=0; j<plen; j++){
                if(pieces[j][0] == a){
                    int l = pieces[j].length;
                    for(int k=0; k<l; k++){
                        if(arr[i] != pieces[j][k]){
                            return false;
                        }
                        i++;
                    }
                }
            }
            if(flag == i){
                return false;
            }
        }
        return true;
    }
}
