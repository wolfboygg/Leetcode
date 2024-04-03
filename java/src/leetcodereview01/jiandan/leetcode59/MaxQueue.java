package leetcodereview01.jiandan.leetcode59;

import java.util.LinkedList;
import java.util.Queue;

public class MaxQueue {

    public LinkedList<Integer> preQueue = new LinkedList<>();
    public LinkedList<Integer> helpQueue = new LinkedList<>();

    public int maxValue() {
        if (!helpQueue.isEmpty()) {
            return helpQueue.peekFirst();
        }
        return -1;
    }

    public void pushBack(int value) {
        preQueue.push(value);
        while (!helpQueue.isEmpty() && helpQueue.peekFirst() < value) {
            helpQueue.pollLast();
        }
        helpQueue.offerLast(value);
        // 从队尾进行加入
    }

    public int popFront() {
        Integer integer = preQueue.poll();
        if (helpQueue.peekFirst() == integer) {
            helpQueue.pollFirst();
        }
        return integer;
    }


    public static void main(String[] args) {
        MaxQueue maxQueue = new MaxQueue();
        maxQueue.pushBack(1);
        maxQueue.pushBack(2);
        maxQueue.pushBack(3);
        maxQueue.pushBack(2);
        System.out.println(maxQueue.maxValue());
        maxQueue.popFront();
        System.out.println(maxQueue.maxValue());
    }
}
