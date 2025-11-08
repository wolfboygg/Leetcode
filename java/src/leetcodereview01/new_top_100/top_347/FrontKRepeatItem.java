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

    // 前K个高频元素
    public List<Integer> findItem01(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                Integer count = map.getOrDefault(arr[i], 1);
                map.put(arr[i], count + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> map.get(o1) - map.get(o2));
        Set<Integer> integers = map.keySet();
        for (Integer integer : integers) {
            if (queue.size() < k) {
                queue.offer(integer);
            } else {
                if (map.get(queue.peek()) < map.get(integer)) {
                    queue.poll();
                    queue.offer(integer);
                }
            }
        }
        return queue.stream().toList();
    }

    public List<Integer> findItem02(int[] arr, int k) {
        // 统计前K个高频元素
        if (arr == null || arr.length == 0) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        Queue<Integer> queue = new PriorityQueue<Integer>((o1, o2) -> map.get(o1) - map.get(o2));
        for (Integer key : map.keySet()) {
            if (queue.size() < k) {
                queue.offer(key);
            } else {
                if (queue.peek() > map.get(key)) {
                    queue.poll();
                    queue.offer(key);
                }
            }
        }
        return queue.stream().toList();
    }

    public List<Integer> findItem03(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return new ArrayList<>();
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        Queue<Integer> queue = new PriorityQueue<>(((o1, o2) -> map.get(o1) - map.get(o2)));
        Set<Integer> integers = map.keySet();
        for (Integer item : integers) {
            if (queue.size() < k) {
                queue.offer(item);
            } else {
                if (map.get(item) > map.get(queue.peek())) {
                    queue.poll();
                    queue.offer(item);
                }
            }
        }
        return queue.stream().toList();
    }

    // 使用大头堆来解决问题  这种方式可以，但是会导致堆内存无限增大，不太行
    public List<Integer> findItem04(int[] arr, int k) {
        // 前K个高频元素
        if (arr == null || arr.length == 0) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        // 开始使用堆排序 一样就替换掉了，所以不能直接全部入
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> map.get(o2) - map.get(o1));
        Set<Integer> integers = map.keySet();
        for (Integer integer : integers) {
            queue.offer(integer);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(queue.poll());
        }
        return list;
    }

    public List<Integer> findItem06(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> map.get(o1) - map.get(o2));
        Set<Integer> integers = map.keySet();
        for (Integer integer : integers) {
            if (queue.size() < k) {
                queue.offer(integer);
            } else {
                if (map.get(integer) > map.get(queue.peek())) {
                    queue.poll();
                    queue.offer(integer);
                }
            }
        }
        return queue.stream().toList();
    }

    public static void main(String[] args) {
        FrontKRepeatItem repeatItem = new FrontKRepeatItem();
        int[] arr = {1, 1, 1, 2, 2, 3, 3, 3};
        int k = 2;
        List<Integer> result = repeatItem.findItem06(arr, k);
        System.out.println(result.toString());
    }
}
