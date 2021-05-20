package Medium;

import java.util.*;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(String word : words){
            map.put(word, map.getOrDefault(word,0)+1);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o1.getValue().equals(o2.getValue())){
                    return o2.getKey().compareTo(o1.getKey());
                }else{
                    return  o1.getValue().compareTo(o2.getValue());
                }
            }
        });
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(pq.size() < k){
                pq.offer(entry);
            }else{
                if(pq.peek().getValue()<entry.getValue() || (pq.peek().getValue().equals(entry.getValue())&&pq.peek().getKey().compareTo(entry.getKey())>0)){
                    pq.poll();
                    pq.offer(entry);
                }
            }
        }
        List<String> ans = new LinkedList<>();
        while (!pq.isEmpty()){
            ans.add(pq.poll().getKey());
        }
        Collections.reverse(ans);
        return ans;
    }
}
