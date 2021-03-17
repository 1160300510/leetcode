package 剑指offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LRUCache {

    class Node{
        Node pre;
        Node next;
        int key;
        int val;
        public Node(){};
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    Map<Integer, Node> map = new HashMap<>();
    Node dummyHead;
    Node dummyTail;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        dummyHead = new Node();
        dummyTail = new Node();
        dummyHead.next = dummyTail;
        dummyTail.pre = dummyHead;
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }else{
            Node node = map.get(key);
            //移动到头部
            moveToHead(node);
            return node.val;
        }
    }

    public void moveToHead(Node node){
        //先删除node
        node.pre.next = node.next;
        node.next.pre = node.pre;
        //再移到头部，dummyHead后面
        node.next = dummyHead.next;
        dummyHead.next = node;
        node.pre = dummyHead;
        node.next.pre = node;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            //更新值
            node.val = value;
            //移到头部
            moveToHead(node);
        }else{
            // 新建一个结点
            Node node = new Node(key, value);
            // 移到头部
            node.next = dummyHead.next;
            node.pre = dummyHead;
            node.next.pre = node;
            dummyHead.next = node;
            map.put(key, node);
            //如果超过容量限制
            if(map.size() > capacity){
                // 删除最后一个结点
                Node removed = dummyTail.pre;
                removed.pre.next = dummyTail;
                dummyTail.pre = removed.pre;
                map.remove(new Integer(removed.key));
            }
        }
    }
}
