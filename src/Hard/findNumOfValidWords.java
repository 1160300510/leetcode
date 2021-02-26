package Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class findNumOfValidWords {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for(String word : words){
            int bit = 0;
            for(int i=0; i<word.length(); i++){
                bit |= (1<<(word.charAt(i)-'a'));
            }
            if(Integer.bitCount(bit)<=7){
                frequency.put(bit, frequency.getOrDefault(bit,0)+1);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(String puzzle : puzzles){
            int total = 0;
            int mask = 0;
            for(int i=1; i<7; i++){
                mask |= (1<<(puzzle.charAt(i)-'a'));
            }
            int subset = mask;
//            do {
//                int s = subset | (1<<(puzzle.charAt(0)-'a'));
//                if(frequency.containsKey(s)){
//                    total += frequency.get(s);
//                }
//                subset = (subset-1) & mask;
//            }while (subset != mask);
            while (subset != 0){
                int s = subset | (1<<(puzzle.charAt(0)-'a'));
                if(frequency.containsKey(s)){
                    total += frequency.get(s);
                }
                subset = (subset-1) & mask;
            }
            // subset为0时结束，此时还有种情况
            // 即只包含首字母
            int s = (1 << (puzzle.charAt(0)-'a'));
            if(frequency.containsKey(s)){
                total += frequency.get(s);
            }
            ans.add(total);
        }
        return ans;
    }
}
