package leetcodereview01.new_top_100.top_239;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 滑动窗口的最大值
 * 这种问题可以使用指针进行求解，比较麻烦，但是也可以使用堆排序进行求解
 */
public class SlideWinMaxValue {

    public List<Integer> findWinMaxValue(int[] arr, int win) {
        List<Integer> ret = new ArrayList<>();
        // 这里是大头堆
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < win; i++) {
            queue.offer(arr[i]);
        }
        ret.add(queue.peek());
        for(int i = win; i < arr.length; i++) {
          queue.remove(arr[i-win]);
          queue.offer(arr[i]);
          ret.add(queue.peek());
        }
        return ret;
    }

    // 滑动窗口的最大值
    public List<Integer> findWinMaxValue01(int[] arr, int win) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2- o1);
        for (int i = 0; i < win; i++) {
            queue.offer(arr[i]);
        }
        List<Integer> ret = new ArrayList<>();
        ret.add(queue.peek());
        for (int i = win; i < arr.length; i++) {
            queue.remove(arr[i-win]); // 移除某个位置的
            queue.offer(arr[i]);
            ret.add(queue.peek());
        }
        return ret;
    }

    public List<Integer> findWinMaxValue02(int[] arr, int k) {
        // 解题思路就是通过大头堆的方式去找到
        if (arr == null || arr.length == 0) {
            return null;
        }
        Queue<Integer> queue = new PriorityQueue<>((o1, o2)-> o2 - o1);
        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }
        List<Integer> list = new ArrayList<>();
        list.add(queue.peek());
        for (int i = k; i < arr.length; i++) {
            queue.remove(arr[i-k]);
            queue.offer(arr[i]);
            list.add(queue.peek());
        }
        return list;
    }

    public List<Integer> findWinMaxValue03(int[] arr, int win) {
        if (arr == null || arr.length == 0) {
            return new ArrayList<>();
        }
        Queue<Integer> queue = new PriorityQueue<>((o1, o2)-> o2 - o1);
        for (int i = 0; i < win; i++) {
            queue.offer(arr[i]);
        }
        List<Integer> list = new ArrayList<>();
        list.add(queue.peek());
        for (int i = win; i < arr.length; i++) {
            queue.remove(arr[i- win]);
            queue.offer(arr[i]);
            list.add(queue.peek());
        }
        return list;
    }

    public static void main(String[] args){
        int[] arr =  {1,3,-1,-3,5,3,6,7};
        SlideWinMaxValue slideWinMaxValue = new SlideWinMaxValue();
        List<Integer> value = slideWinMaxValue.findWinMaxValue03(arr, 3);
        System.out.println(value.toString());
    }

}
