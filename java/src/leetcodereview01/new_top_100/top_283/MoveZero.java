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

    // 移动0的位置 向后移动，通过指针的方式
    public void move02(int[] arr) {
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

    // 就是指针进行移动
    public void move03(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int low = 0;
        // 只需要动一下就ok了
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[low];
                arr[low] = temp;
                low++;
            }
        }
    }


    public void move04(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int P1 = 0;
        int P2 = arr.length - 1;
        while(P1 < P2) {
            if (arr[P1] != 0) {
                P1++;
            } else {
                arr[P1] = arr[P2];
                arr[P2] = 0;
                P2--;
                P1++;
            }
        }
    }

    // 或者直接一个for循环搞定
    public void move05(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int low = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                int temp = arr[low];
                arr[low] = arr[i];
                arr[i] = temp;
                low++;
            }
        }
    }

    public void moveToStart05(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int limit = arr.length - 1;
        int P1 = limit;
        for (int i = limit; i >=0 ; i--) {
            if (arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[P1];
                arr[P1] = temp;
                P1--;
            }
        }
        System.out.println(Arrays.toString(arr));
    }



    public static void main(String[] args) {
        int[] arr = new int[] {1,2,0,0,3,12};
        MoveZero moveZero = new MoveZero();
        moveZero.moveToStart05(arr);
        System.out.println(Arrays.toString(arr));
    }

}
