package 剑指offer;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {

    Deque<Integer> s1;
    Deque<Integer> s2;
    /** initialize your data structure here. */
    public MinStack() {
        s1 = new ArrayDeque<>();
        s2 = new ArrayDeque<>();
    }

    public void push(int x) {
        s1.offerLast(x);
        if(!s2.isEmpty()){
            if(s2.peekLast() >= x){
                s2.offerLast(x);
            }
        }else{
            s2.offerLast(x);
        }
    }

    public void pop() {
        if(s1.peekLast().equals(s2.peekLast())){
            s2.pollLast();
        }
        s1.pollLast();
    }

    public int top() {
        return s1.peekLast();
    }

    public int min() {
        return s2.peekLast();
    }
}
