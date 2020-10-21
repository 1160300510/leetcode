package 剑指offer;

import java.util.Stack;

public class StackToQueue {
    Stack<Integer> in = new Stack<>();
    Stack<Integer> out = new Stack<>();
    public void offer(int node){
        in.push(node);
    }
    public int poll() throws Exception {
        if(out.isEmpty()){
            while (!in.isEmpty()){
                out.push(in.pop());
            }
        }
        if(out.isEmpty()){
            throw new Exception("queue is empty");
        }
        return out.pop();
    }
}
