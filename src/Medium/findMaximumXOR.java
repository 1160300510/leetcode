package Medium;

import java.util.HashMap;

public class findMaximumXOR {
    public int findMaximumXOR(int[] nums) {
        int maxNum = 0;
        int n = nums.length;
        for(int num : nums){
            maxNum = Math.max(maxNum, num);
        }
        int L = (Integer.toBinaryString(maxNum)).length();
        int bitmask = 1<<L;
        String[] strNums = new String[n];
        for(int i=0; i<n; i++){
            strNums[i] = (Integer.toBinaryString(nums[i] | bitmask)).substring(1);
        }
        TrieNode root = new TrieNode();
        int maxXor = 0;
        for(int i=0; i<n; i++){
            TrieNode node = root;
            TrieNode xorNode = root;
            int curXor = 0;
            for(Character c : strNums[i].toCharArray()){
                if(node.children.containsKey(c)){
                    node = node.children.get(c);
                }else{
                    node.children.put(c, new TrieNode());
                    node = node.children.get(c);
                }

                Character target = c=='1' ? '0' : '1';
                if(xorNode.children.containsKey(target)){
                    xorNode = xorNode.children.get(target);
                    curXor = (curXor<<1) | 1;
                }else{
                    curXor = curXor<<1;
                    xorNode = xorNode.children.get(c);
                }
            }
            maxXor = Math.max(maxXor, curXor);
        }
        return maxXor;
    }
}

class TrieNode{
    HashMap<Character, TrieNode> children = new HashMap<>();
    public TrieNode(){}
}
