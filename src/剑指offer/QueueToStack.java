package 剑指offer;

import java.util.LinkedList;
import java.util.Queue;

public class QueueToStack {
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();
    public void push(int node){
        if(queue2.isEmpty()){
            queue1.offer(node);
        }else {
            queue2.offer(node);
        }
    }

    public int pop() throws Exception{
        if(!queue1.isEmpty()){
            for(int i=0; i<queue1.size()-1; i++){
                queue2.offer(queue1.poll());
            }
            return queue1.poll();
        }else if(!queue2.isEmpty()){
            for(int i=0; i<queue2.size()-1; i++){
                queue1.offer(queue2.poll());
            }
            return queue2.poll();
        }else {
            throw new Exception("stack is empty");
        }
    }
}
