package leetcodereview01.jiandan.leetcode40;


import java.sql.Array;
import java.util.*;

public class MinKNumber {

    // 使用排序的方式进行实现 low
    public int[] findMinKNum(int[] arr, int k) {
        Arrays.sort(arr);
        int[] temp = new int[k];
        for (int i = 0; i < k; i++) {
            temp[i] = arr[i];
        }
        return temp;
    }

    public List<Integer> findMinKNumByDump(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 > o2 ? 1 : -1;
            }
        });
        // 先搞k个数
        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (arr[k] < queue.peek()) {
                queue.poll();
                queue.offer(arr[k]);
            }
        }
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            list.add(queue.poll());
        }
        return list;
    }

    public void findMinKNumberByDump02(int[] arr, int k) { // 使用大头堆实现
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (queue.peek() > arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        while (!queue.isEmpty()) {
            System.out.print(queue.poll());
        }
    }

    public void findMinKNumberByDump03(int[] arr, int k) {
        // 找到最小的k个数
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (queue.peek() > arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }

    public List<Integer> findMinKNumByDump04(int[] arr, int k) {
        // 使用大头堆实现
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o1 - o2);
        for (int i = 0; i < k; i++) {
            // 先放入k个数
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (queue.peek() > arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            list.add(queue.poll());
        }
        return list;
    }

    public List<Integer> findMinKNumByDump05(int[] arr, int k) {
        // 找出最小的k个数，需要使用大头堆来进行处理，如果比大就出
        // 先放入K个数
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o1 - o2);
        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < queue.peek()) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        // 最后输出
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            list.add(queue.poll());
        }
        return list;
    }

    public List<Integer> findMinKNumByDump06(int[] arr, int k) {
        // 找到最小的k个数，使用大头堆进行实现，如果比头元素大就出堆
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o1 - o2);
        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }
        // 然后在遍历最后的元素 PriorityQueue
        for (int i = k; i < arr.length; i++) {
            if (queue.peek() > arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        // 然后输出
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            list.add(queue.poll());
        }
        return list;
    }

    // 找出最小的k个数
    public List<Integer> findMinKNumByDump07(int[] arr, int target) {
        // 最小的k个数，使用大头堆进行实现
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o1 - o2);
        for (int i = 0; i < target; i++) {
            queue.offer(arr[i]);
        }
        for (int i = target; i < arr.length; i++) {
            Integer peek = queue.peek();
            if (peek > arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            list.add(poll);
        }
        return list;
    }

    public List<Integer> findMinKNumByDump08(int[] arr, int k) {
        // 找到最小的K个数，使用大头堆进行解决
        PriorityQueue<Integer> queue = new PriorityQueue<>((Comparator<Integer>) (o1, o2) -> o1 - o2);
        // 先让K个数入栈
        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            Integer peek = queue.peek();
            if (arr[i] < peek) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            list.add(queue.poll());
        }
        return list;
    }

    // 最小的K个数，使用大头堆进行解决
    public List<Integer> findMinKNumByDump09(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        // 使用大头堆进行处理
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o1 - o2);
        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (queue.peek() > arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        List<Integer> ret = new ArrayList<>();
        while (!queue.isEmpty()) {
            ret.add(queue.poll());
        }
        return ret;
    }


    public List<Integer> findMinKNumberByDump10(int[] arr, int k) {
        // 找到最小的K个数
        if (arr == null || arr.length == 0) {
            return null;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((Comparator<Integer>) (o1, o2) -> o1 - o2);
        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < queue.peek()) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        List<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()) {
            list.add(queue.poll());
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 6, 2, 7, 3, 8};
        MinKNumber minKNumber = new MinKNumber();
        int[] num = minKNumber.findMinKNum(arr, 4);
        System.out.println(Arrays.toString(num));
        List<Integer> minKNumByDump = minKNumber.findMinKNumberByDump10(arr, 4);
        System.out.println(minKNumByDump.toString());
//        minKNumber.findMinKNumberByDump03(arr, 4);
    }
}
