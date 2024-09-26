package leet41;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 获取最小的k个数，我们不要使用直接构建k个最小堆，我们使用大顶堆来进行构建，如果当前元素大与了堆顶元素，直接大顶推元素去掉l
 */
public class GetLeastNumbers {

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] array, int k) {
        if (k > array.length || k <= 0) {
            return new ArrayList<>();
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : array) {
            queue.add(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return new ArrayList<>(queue);
    }

    @Override
    public String toString() {
        return "GetLeastNumbers{}";
    }

    public static void main(String[] args) {
        int[] array = {4, 5, 1, 6, 2, 7, 3, 8};
        GetLeastNumbers getLeastNumbers = new GetLeastNumbers();
        System.out.println(getLeastNumbers.GetLeastNumbers_Solution(array, 4).toString());
    }
}
