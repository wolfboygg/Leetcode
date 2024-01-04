package leetcodereview01.top100.top_448;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个范围在 1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 *
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 *
 * 您能在不使用额外空间且时间复杂度为*O(n)*的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 *
 */
public class DisappearedNumbers {

    public List<Integer> findDisappearedNumbers(int[] arr) {
        // 找到消失的数字 通过移动对应的数字到对应的位置即可 然后进行遍历
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            while(arr[i] != i + 1 && arr[arr[i] - 1] != arr[i]) { // 主打的就是以一个交换 判断当前位置和下标是否相等，如果不想等看当前内容-1的位置和当前位置的值是否相等，不行等换到对应的位置
                // 相等就不用换了
                swipe(arr, i, arr[i] - 1);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]  != i + 1) {
                list.add(i+1);
            }
        }
        return list;
    }

    private void swipe(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static void main(String[] args){
        int[] arr = {4,3,2,7,8,2,3,1};
        DisappearedNumbers disappearedNumbers = new DisappearedNumbers();
        List<Integer> list = disappearedNumbers.findDisappearedNumbers(arr);
        System.out.println(list.toString());
    }

}
