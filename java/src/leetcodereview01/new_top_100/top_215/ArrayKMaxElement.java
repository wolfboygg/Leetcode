package leetcodereview01.new_top_100.top_215;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 数组中第K大的元素
 * 数组没有排序
 */
public class ArrayKMaxElement {

    public int getKMaxElement(int[] arr, int k) {
        // 小头队进行处理
        if (arr == null || arr.length == 0) {
            return -1;
        }
        // 小头堆
        Queue<Integer> queue = new PriorityQueue<Integer>(((o1, o2) -> o1 - o2));
        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (queue.peek() < arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        return queue.poll();
    }

    public int getKMaxElement01(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        // 使用堆来处理 小头堆
        Queue<Integer> queue = new PriorityQueue<Integer>((o1, o2) -> o1 - o2);
        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (arr[i] > queue.peek()) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        return queue.poll();
    }

    public int getKMaxElement02(int[] arr, int k) {
        // 数组中第K大的元素
        if (arr == null || arr.length == 0) {
            return -1;
        }
        // 使用优先级队列处理 // 小头堆
        // 小头堆处理，但是都是最大的，然后和堆顶的比较，比它大就放到里面这样肯定对
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o1 - o2);
        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (queue.peek() < arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        return queue.poll();
    }

    // 小头堆处理
    public int getKMaxElement03(int[] arr, int k) {
        // 数组中第K个大的数
        if (arr == null || arr.length == 0) {
            return -1;
        }
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) ->  o1 - o2);
        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (queue.peek() < arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        return queue.poll();
    }

    // 第K大的数
    public int getKMaxElement04(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        Queue<Integer> queue = new PriorityQueue<Integer>((o1, o2) -> o1 - o2);
        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (queue.peek() < arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        return queue.poll();
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 6, 4};
        ArrayKMaxElement arrayKMaxElement = new ArrayKMaxElement();
        int kMaxElement = arrayKMaxElement.getKMaxElement04(arr, 2);
        System.out.println(kMaxElement);

    }
}
