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

    public void group02(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int P1 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                int temp = arr[i];
                arr[i] = arr[P1];
                arr[P1] = temp;
                P1++;
            }
        }

        for (int i = P1; i < arr.length; i++) {
            if (arr[i] == 1) {
                int temp = arr[i];
                arr[i] = arr[P1];
                arr[P1] = temp;
                P1++;
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    public void group03(int[] arr) {
        // 就是简单的分组问题
        int P1 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                int value = arr[i];
                arr[i] = arr[P1];
                arr[P1] = value;
                P1++;
            }
        }
        for (int i = P1; i < arr.length; i++) {
            if (arr[i] == 1) {
                int value = arr[i];
                arr[i] = arr[P1];
                arr[P1] = value;
                P1++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        ColorGroup colorGroup = new ColorGroup();
        int[] color = new int[] {2,0,2,1,1,0};
        colorGroup.group03(color);
    }
}
