package thrityDaysChanllage.Interview59;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;


/***
 * 维护一个单调的双端队列，每次插入一个值时，将前面所有的比它小的元素左侧出队，每次判断
 * 主队列出队是否是最大值出队，如果是，双端队列右侧出队
 * JAVA的双端队列仍可以使用Linkedlist，其中offerFirst表示从队首插入
 * offerLast从队尾插入，peekLast,pollLast
 */
public class MaxQueue {

    private Queue<Integer> normalQ;
    private Deque<Integer> maxvalueQ;

    public MaxQueue() {
        normalQ = new LinkedList<>();
        maxvalueQ = new LinkedList<>();
    }

    public int max_value() {
        if(maxvalueQ.isEmpty()){
            return -1;
        }else {
            return maxvalueQ.peekFirst();
        }
    }

    public void push_back(int value) {
        normalQ.offer(value);
        if(normalQ.isEmpty()){
            maxvalueQ.offerLast(value);
        }
        else{
            while (!maxvalueQ.isEmpty()){
                int temp = maxvalueQ.peekLast();
                System.out.println("temp "+temp + " value: "+value);
                if(temp < value)
                    maxvalueQ.pollLast();
                else
                    break;
            }
            maxvalueQ.offerLast(value);
        }
    }

    public int pop_front() {
        //如果主队列不空
        if(!normalQ.isEmpty()){
            int normalpop = normalQ.poll();
            int maxquepop = maxvalueQ.peekFirst();
            //如果弹出的等于最大值队列的第一个，都弹出
            if(maxquepop == normalpop){
                maxvalueQ.pollFirst();
            }
            return normalpop;
        }
        //若主队列为空，直接返回-1
        else
            return -1;
    }


    public static void main(String[] args) {
        MaxQueue maxQueue = new MaxQueue();
        maxQueue.push_back(1);
        maxQueue.push_back(2);
        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.max_value());
    }
}
