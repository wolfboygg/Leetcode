package leetcodereview01.new_top_100.top_283;

import java.util.Arrays;

/**
 * 移动0，将所有的0移动到数组开头位置
 */
public class MoveZero {

    public void moveZeroes(int[] arr) {
        // 通过指针的方式进行移动
        if (arr == null || arr.length == 0) {
            return;
        }
        int slow = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[slow];
                arr[slow] = temp;
                slow++;
            }
        }
    }

    // 还是单向赋值
    public void move01(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int slow = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[slow];
                arr[slow]  = temp;
                slow++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,2,0,0,3,12};
        MoveZero moveZero = new MoveZero();
        moveZero.move01(arr);
        System.out.println(Arrays.toString(arr));
    }

}
