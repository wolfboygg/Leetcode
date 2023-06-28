package leetcodereview01.jiandan.leetcode21;

import java.util.Arrays;

public class AdjustArray {

    public void adjustByPointer02(int[] arr) {
        int P1 = 0;
        int P2 = arr.length - 1;
        while (P1 < P2) {
            while (arr[P1] % 2 != 0 && P1 < P2) {
                P1++;
            }
            while (arr[P2] % 2 == 0 && P1 < P2) {
                P2--;
            }
            if (P1 < P2) {
                int temp = arr[P2];
                arr[P2] = arr[P1];
                arr[P1] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }


    public static void main(String[] args) {
        AdjustArray adjustArray = new AdjustArray();
        int[] arr = {1, 5, 3, 2, 4, 5};
        adjustArray.adjustByPointer(arr);
    }

    public void adjustByFor(int[] arr) {
        int[] newArr = new int[arr.length];
        int index = 0;
        for (int value : arr) {
            if (value % 2 != 0) {
                newArr[index++] = value;
            }
        }
        for (int value : arr) {
            if (value % 2 == 0) {
                newArr[index++] = value;
            }
        }
        System.out.println(Arrays.toString(newArr));
    }

    public void adjustByPointer(int[] arr) {
        int P1 = 0;
        int P2 = arr.length - 1;
        while (P1 < P2) {
            while (arr[P1] % 2 != 0 && P1 < P2) {
                P1++;
            }
            while (arr[P2] % 2 == 0 && P2 > P1) {
                P2--;
            }
            // 否则就进行交换
            if (P1 < P2) {
                int temp = arr[P1];
                arr[P1] = arr[P2];
                arr[P2] = temp;
                P1++;
                P2--;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
