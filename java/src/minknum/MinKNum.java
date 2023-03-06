package minknum;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MinKNum {

    public static List<Integer> getMinKNum(int[] nums, int k) {
        if (k > nums.length || k <= 0) {
            return new ArrayList<>();
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < nums.length; i++) {
            maxHeap.add(nums[i]);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        return new ArrayList<>(maxHeap);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 3, 2, 1, 3, 4, 5, 7, 8, 9};
        List<Integer> minKNum = getMinKNum(nums, 5);
        System.out.println(minKNum);
    }
}
