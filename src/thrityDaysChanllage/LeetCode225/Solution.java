package thrityDaysChanllage.LeetCode225;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    private Queue<Integer> emptyQ,dataQ;

    public Solution() {
        emptyQ = new LinkedList<Integer>();
        dataQ = new LinkedList<Integer>();
    }

    public void push(int x) {
        dataQ.offer(x);
    }

    public int pop() {
        int tempData = 0;
        while (dataQ.size() > 1){
            tempData = dataQ.poll();
            emptyQ.offer(tempData);
        }
        tempData = dataQ.poll();
        Queue<Integer> tempQ = emptyQ;
        emptyQ = dataQ;
        dataQ = tempQ;
        return tempData;
    }

    public int top() {
        int popData = this.pop();
        dataQ.offer(popData);
        return popData;
    }

    public boolean empty() {
        if(dataQ.peek() == null){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.push(1);
        solution.push(2);
        solution.push(3);
        System.out.println(solution);
        System.out.println(solution.pop());
        System.out.println(solution);
        System.out.println(solution.top());
        solution.push(8);
        System.out.println(solution);

    }

    @Override
    public String toString() {
        return "Solution{" +
                "emptyQ=" + emptyQ +
                ", dataQ=" + dataQ +
                '}';
    }
}
