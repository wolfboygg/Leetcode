package leetcodereview01.new_top_100.top_215;

import java.util.DoubleSummaryStatistics;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 数组中第K大的元素
 * 数组没有排序
 */
public class ArrayKMaxElement {

    public int getKMaxElement(int[] arr, int k) {
        // 大头队进行处理
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

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 6, 4};
        ArrayKMaxElement arrayKMaxElement = new ArrayKMaxElement();
        int kMaxElement = arrayKMaxElement.getKMaxElement(arr, 2);
        System.out.println(kMaxElement);

    }
}
