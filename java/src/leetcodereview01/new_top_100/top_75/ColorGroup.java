package leetcodereview01.new_top_100.top_75;

import java.util.Arrays;

/** 颜色分类问题 */
public class ColorGroup {


    // 本质和调整数组的奇偶顺序一致
    public void group01(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int ptr = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                int temp = arr[i];
                arr[i] = arr[ptr];
                arr[ptr] = temp;
                ptr++;
            }
        }
        for (int i = ptr; i < arr.length; i++) {
            if (arr[i] == 1) {
                int temp = arr[i];
                arr[i] = arr[ptr];
                arr[ptr] = temp;
                ptr++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        ColorGroup colorGroup = new ColorGroup();
        int[] color = new int[] {2,0,2,1,1,0};
        colorGroup.group01(color);
    }
}
