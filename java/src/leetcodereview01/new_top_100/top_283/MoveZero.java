package leetcodereview01.new_top_100.top_283;

import java.util.Arrays;

/**
 * 移动0，将所有的0移动到数组开头位置
 */
public class MoveZero {

    public void move(int[] arr) {
        // 简单的记录一下位置，然后进行覆盖即可
        if (arr == null || arr.length == 0) {
            return;
        }
        int k = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[k++] = arr[i];
            }
        }
        for (int i = k; i < arr.length; i++) {
            arr[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {0,1,0,3,12};
        MoveZero moveZero = new MoveZero();
        moveZero.move(arr);
        System.out.println(Arrays.toString(arr));
    }

}
