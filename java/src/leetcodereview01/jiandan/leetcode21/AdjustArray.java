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

    public void adjustByPointer03(int[] arr) {
        // 调整数组的奇偶，双指针遍历交换 奇数位于偶数前面  类似快排序
        int P1 = 0;
        int P2 = arr.length -1;
        while(P1 < P2) {
            while(arr[P1] % 2 != 0 && P1 < P2) {
                P1++;
            }
            while(arr[P2] % 2 == 0 && P1 < P2) {
                P2--;
            }
            if (P1 < P2) {
                int temp = arr[P1];
                arr[P1] = arr[P2];
                arr[P2] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public void adjustByPointer04(int[] arr) {
        // 使用双指针的方式进行处理
        int P1 = 0;
        int P2 = arr.length - 1;
        while(P1 < P2) {
            while (P1 < P2 && arr[P1] % 2 != 0) {
                P1++;
            }
            while (P1 < P2 && arr[P2] % 2 ==0) {
                P2--;
            }
            // 进行交换
            if (P1 < P2) { // 交换之后进行下一轮就会跳过
                int temp = arr[P1];
                arr[P1] = arr[P2];
                arr[P2] = temp;
                P1++;
                P2--;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public void adjustByPointer05(int[] arr) {
        // 交换顺序 奇偶顺序
        int P1 = 0;
        int P2 = arr.length -1;
        while(P1 < P2) {
            while(P1 < P2 && arr[P1] % 2 != 0) {
                P1++;
            }
            while(P1 < P2 && arr[P2] % 2 == 0) {
                P2--;
            }
            if (P1 < P2) {
                int temp = arr[P1];
                arr[P1] = arr[P2];
                arr[P2] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }


    public void adjustByPointer06(int[] arr) {
        // 调整奇偶顺序
        int P1 = 0;
        int P2 = arr.length -1;
        while(P1 < P2) {
            while (P1 < P2 && arr[P1] % 2 != 0) {
                P1++;
            }
            while (P1 < P2 && arr[P2] % 2 == 0) {
                P2--;
            }
            if (P1 < P2) {
                int temp = arr[P1];
                 arr[P1] = arr[P2];
                arr[P2] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public void adjustByPointer07(int[] arr) {
        // 进行奇偶顺序的调整
        int P1 = 0;
        int P2 = arr.length -1;
        while(P1 < P2) {
            // 使用一个while循环处理
            while (P1 < P2 && arr[P1] % 2 != 0) {
                P1++;
            }
            while (P1 < P2 && arr[P2] % 2 == 0) {
                P2--;
            }
            if (P1 != P2) {
                // 进行交换
                int temp = arr[P1];
                arr[P1] = arr[P2];
                arr[P2] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public void adjustByPointer08(int[] arr) {
        // 调整数组的奇偶位置
        int P1 = 0;
        int P2 = arr.length -1;
        while(P1 < P2) {
            // 从右边开始
            while (P1 < P2 && arr[P2] % 2 == 0) {
                P2--;
            }
            while (P1 < P2 && arr[P1] % 2 != 0) {
                P1++;
            }
            // 进行交换
            if (P1 != P2) {
                int temp = arr[P1];
                arr[P1] = arr[P2];
                arr[P2] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        AdjustArray adjustArray = new AdjustArray();
        int[] arr = {1, 5, 8, 3, 2, 4, 5};
        adjustArray.adjustByPointer08(arr);
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
