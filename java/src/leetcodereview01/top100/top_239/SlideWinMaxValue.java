package leetcodereview01.top100.top_239;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

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

    public static void main(String[] args){
        int[] arr =  {1,3,-1,-3,5,3,6,7};
        SlideWinMaxValue slideWinMaxValue = new SlideWinMaxValue();
        List<Integer> value = slideWinMaxValue.findWinMaxValue01(arr, 3);
        System.out.println(value.toString());
    }

}
