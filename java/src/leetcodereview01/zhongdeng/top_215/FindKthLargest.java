package leetcodereview01.zhongdeng.top_215;

import java.util.PriorityQueue;

public class FindKthLargest {

    public int find(int[] arr, int k) {
        // 构建一个大头堆
        if (arr == null || arr.length == 0) {
            return -1;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o1 - o2);

        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (arr[i] > queue.peek()) {
                int value = queue.poll();
                queue.offer(arr[i]);
            }
        }
        return queue.poll();
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 6, 4};
        FindKthLargest findKthLargest = new FindKthLargest();
        System.out.println(findKthLargest.find(arr, 3));
    }
}
