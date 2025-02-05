package leetcodereview01.new_top_100.top_128;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 最长连续递增数组长度
 */
public class MainLengthIncrementArray {

    public int getMaxLength(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        // 解题思路通过HashSet去重之后进行判断是否有
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        int max = 0;
        for (int item : arr) {
            if (!set.contains(item -1)) {
                int cur = item;
                int curLength = 1;
                while(set.contains(cur+1)) {
                    cur++;
                    curLength++;
                }
                max = Math.max(max, curLength);
            }
        }
        return max;
    }


    public int getMaxLength01(int[] arr) {
        // 最长连续递增序列 通过HashSet去重之后判断是否存在
        if (arr == null || arr.length == 0) {
            return -1;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!set.contains(arr[i]-1)) { // 防止重复计算
                int curLength = 1;
                int curValue = arr[i];
                while(set.contains(curValue+1)) {
                    curValue++;
                    curLength++;
                }
                max = Math.max(max, curLength);
            }
        }
        return max;
    }


    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};
        MainLengthIncrementArray mainLengthIncrementArray = new MainLengthIncrementArray();
        System.out.println(mainLengthIncrementArray.getMaxLength01(arr));
    }

}
