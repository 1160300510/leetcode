package 剑指offer;

import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> A;
    PriorityQueue<Integer> B;
    /** initialize your data structure here. */
    public MedianFinder() {
        A = new PriorityQueue<Integer>(); // 小顶堆，保存较大的一部分
        B = new PriorityQueue<Integer>((a,b)->(Integer.compare(b, a))); // 大顶堆，保存较小的一部分
    }

    public void addNum(int num) {
        if(A.size() == B.size()){
            B.offer(num);
            A.offer(B.poll());
        }else{
            A.offer(num);
            B.offer(A.poll());
        }
    }

    public double findMedian() {
        if(A.size()==0 && B.size()==0){
            return 0;
        }
        return A.size()==B.size() ? (A.peek()+B.peek())/2.0 : A.peek();
    }
}
