package Medium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class reorganizeString {
    public String reorganizeString(String S) {
        int[][] chars = new int[26][2];
        for(int i=0; i<26; i++){
            chars[i][0] = i;
        }
        for(int i=0; i<S.length(); i++){
            chars[S.charAt(i)-'a'][1]++;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]==o2[1] ? o1[0]-o2[0] : o2[1]-o1[1];
            }
        });
        for(int i=0; i<26; i++){
            if(chars[i][1] > 0){
                pq.offer(chars[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()){
            if(pq.size() == 1){
                int[] first = pq.poll();
                if(first[1] == 1){
                    sb.append((char)(first[0]+'a'));
                    break;
                }else {
                    return "";
                }
            }
            int[] first = pq.poll();
            int[] second = pq.poll();
            if(first[1]>0 && second[1]>0){
                sb.append((char)(first[0]+'a'));
                sb.append((char)(second[0]+'a'));
                first[1]--;
                second[1]--;
                if(first[1] > 0){
                    pq.offer(first);
                }
                if(second[1] > 0){
                    pq.offer(second);
                }
            }else{
                return "";
            }
        }
        return sb.toString();

    }
}
