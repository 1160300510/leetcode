package Medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new Set[9];
        Set<Character>[] cols = new Set[9];
        Set<Character>[] littleboards = new Set[9];
        for(int i=0; i<9; i++){
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            littleboards[i] = new HashSet<>();
        }

        int m = board.length;
        int n = board[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(Character.isDigit(board[i][j])){
                    char c = board[i][j];
                    if(rows[i].contains(c)){
                        return false;
                    }else{
                        rows[i].add(c);
                    }
                    if(cols[j].contains(c)){
                        return false;
                    }else {
                        cols[j].add(c);
                    }
                    int index = (i/3)*3+j/3;
                    if(littleboards[index].contains(c)){
                        return false;
                    }else {
                        littleboards[index].add(c);
                    }
                }
            }
        }
        return true;
    }
}
