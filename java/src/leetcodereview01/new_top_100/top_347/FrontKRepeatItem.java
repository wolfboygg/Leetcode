package leetcodereview01.new_top_100.top_347;

import java.util.*;

/**
 * 前K个高频元素
 */
public class FrontKRepeatItem {

    public List<Integer> findItem(int[] arr, int k) {
        // 先统计频率 在用小头堆处理
        if (arr == null || arr.length == 0) {
            return new ArrayList<>();
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        // 这里要设置好 必须使用频率排序
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            return map.get(o1) - map.get(o2);
        });
        // 这里不能使用普通的for循环了，应该设置为map的key 去重复了
        for (Integer item : map.keySet()) {
            if (queue.size() < k) {
                queue.offer(item);
            } else {
                if (map.get(queue.peek()) < map.get(item)) {
                    queue.poll();
                    queue.offer(item);
                }
            }
        }

        return queue.stream().toList();
    }


    public static void main(String[] args) {
        FrontKRepeatItem repeatItem = new FrontKRepeatItem();
        int[] arr = {1, 1, 1, 2, 2, 3, 3, 3};
        int k = 2;
        List<Integer> result = repeatItem.findItem(arr, k);
        System.out.println(result.toString());
    }
}
