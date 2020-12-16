package Easy;

import java.util.HashMap;
import java.util.Map;

public class wordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] str = s.split(" ");
        if(pattern.length() != str.length){
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        for(int i=0; i<pattern.length(); i++){
            char c = pattern.charAt(i);
            if(map.containsKey(c)){
                if(!map.get(c).equals(str[i])){
                    return false;
                }
            }else{
                map.put(c, str[i]);
            }
            if(map2.containsKey(str[i])){
                if(map2.get(str[i]) != c){
                    return false;
                }
            }else{
                map2.put(str[i], c);
            }
        }
        return true;
    }
}
