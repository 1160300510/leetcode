package Medium;

import java.util.*;

public class ladderLength {
    //https://leetcode-cn.com/problems/word-ladder/

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int end = wordList.indexOf(endWord);
        if(end == -1){
            return 0;
        }
        wordList.add(beginWord);
        // 双向BFS
        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();
        Set<String> visited1 = new HashSet<>();
        Set<String> visited2 = new HashSet<>();
        queue1.offer(beginWord);
        queue2.offer(endWord);
        visited1.add(beginWord);
        visited2.add(endWord);

        int cnt = 0;
        Set<String> allWords = new HashSet<>(wordList);
        while (!queue1.isEmpty() && !queue2.isEmpty()){
            cnt++;
            // 每次从小的队列开始BFS
            if(queue1.size() > queue2.size()){
                Queue<String> temp = queue1;
                queue1 = queue2;
                queue2 = temp;
                Set<String> t = visited1;
                visited1 = visited2;
                visited2 = t;
            }
            int size1 = queue1.size();
            for(int i=0; i<size1; i++){
                char[] c = queue1.poll().toCharArray();
                for(int j=0; j<c.length; j++){
                    char ori = c[j];
                    for(int k=0; k<26; k++){
                        c[j] = (char)('a'+k);
                        String str = new String(c);
                        // 已经访问过
                        if(visited1.contains(str)){
                            continue;
                        }
                        // 两端遍历相遇，结束遍历，返回 count
                        if(visited2.contains(str)){
                            return cnt+1;
                        }
                        if(allWords.contains(str)){
                            queue1.offer(str);
                            visited1.add(str);
                        }
                    }
                    // 恢复
                    c[j] = ori;
                }
            }
        }
        return 0;
    }
}
