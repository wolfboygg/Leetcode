package leetcodereview01.top100.top_283;

import java.util.Arrays;

/**
 * 移动0 将所有的数组0元素移动到数组末尾
 */
public class MoveZero {

    public void move(int[] arr) {
        // 进行移动，因为是0， 所以只要将非0的移动到前面后面的直接赋值0
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[k++] = arr[i];
            }
        }
        for (int i = k; i < arr.length; i++) {
            arr[i] = 0;
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args){
        int[] arr = {0,1,0,0,12};
        MoveZero moveZero = new MoveZero();
        moveZero.move(arr);
    }
}
