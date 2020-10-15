package 剑指offer;

public class Find {
    public boolean Find(int target, int [][] array) {
        if(array == null){
            return false;
        }
        int m = array.length;
        int n = array[0].length;
        int row = 0;
        int col = n-1;
        while(row<m && col>=0){
            int num = array[row][col];
            if(num == target){
                return true;
            }else if(num > target){
                col--;
            }else{
                row++;
            }
        }
        return false;
    }
}
