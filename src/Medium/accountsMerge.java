package Medium;

import java.util.*;
import java.util.stream.Collectors;

public class accountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> emailtoIndex = new HashMap<>();
        Map<String, String> emailtoName = new HashMap<>();
        int emailcount = 0;
        for(List<String> l : accounts){
            int len = l.size();
            String name = l.get(0);
            for(int i=1; i<len; i++){
                String email = l.get(i);
                if(!emailtoIndex.containsKey(email)){
                    emailtoIndex.put(email, emailcount++);
                    emailtoName.put(email, name);
                }
            }
        }
        DSU dsu = new DSU(emailcount);
        for(List<String> l : accounts){
            int len = l.size();
            int firstIndex = emailtoIndex.get(l.get(1));
            for(int i=2; i<len; i++){
                int nextIndex = emailtoIndex.get(l.get(i));
                dsu.merge(firstIndex, nextIndex);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        Map<Integer, List<String>> indextoMail = new HashMap<>();
        for(String email : emailtoIndex.keySet()){
            int index = emailtoIndex.get(email);
            int root = dsu.find(index);
            List<String> list = indextoMail.getOrDefault(root, new ArrayList<String>());
            list.add(email);
            indextoMail.put(root, list);
        }
        for(Integer index : indextoMail.keySet()){
            List<String> list = new ArrayList<>();
            String name = emailtoName.get(indextoMail.get(index).get(0));
            list.add(name);
            for(String s : indextoMail.get(index).stream().sorted().collect(Collectors.toList())){
                list.add(s);
            }
            ans.add(list);
        }
        return ans;
    }
}

