package leetcodereview01.new_top_100.top_31;

import java.util.Arrays;

/**
 * 下一个排列序列
 */
public class NextSequence {

    // 先找到一个小的数，然后在找到第一个比这个数大的数
    // 然后进行交换，最后整体对后续数进行反转
    public void getNextSequence01(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int i = arr.length - 2;
        if (i > 0) {
            while(i > 0 && arr[i] >= arr[i+1]) {
                i--;
            }
        }
        // 在找小的
        if (i > 0) {
            int j = arr.length -1;
            while(j > 0 && arr[i] > arr[j]) {
                j--;
            }
            swap(arr, i, j);
        }
        reverse(arr, i + 1);
    }

    public void reverse(int[] arr, int start) {
        int end = arr.length - 1;
        while(start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }


    public void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }


    // 1, 2, 3
    public void getNextSequence02(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        // 先找到比前一个小的，在找到比大的，然后进行交换
        int dest = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] <= arr[i + 1]) {
                dest = i;
                break;
            }
        }
        if (dest > 0) { // 注意找不到的情况
            int dest2 = -1;
            for (int i = dest + 1; i < arr.length; i++) {
                if (arr[i] > arr[dest]) {
                    dest2 = i;
                }
            }
            swap01(arr, dest, dest2);
        }

        reverse01(arr, dest + 1, arr.length -1);
    }

    public void swap01(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start]= arr[end];
        arr[end] = temp;
    }

    public void reverse01(int[] arr, int start, int end) {
        if (start < end) {
            swap01(arr, start, end);
            start++;
            end--;
        }
    }

    public void getNextSequence03(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int P1 = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] <= arr[i+1]) {
                P1 = i;
                break;
            }
        }
        if (P1 > 0) {
            int P2 = -1;
            for (int i = P1 + 1; i < arr.length; i++) {
                if (arr[i] > arr[P1]) {
                    P2 = i;
                    break;
                }
            }
            swap02(arr, P1, P2);
        }
        reverse02(arr, P1 + 1, arr.length - 1);
    }

    public void swap02(int[] arr, int P1, int P2) {
        int temp = arr[P1];
        arr[P1] = arr[P2];
        arr[P2] = temp;
    }

    public void reverse02(int[] arr, int start, int end) {
        while(start >= 0 && start < arr.length && end >= 0 && end < arr.length) {
            swap02(arr, start, end);
            start++;
            end--;
        }
    }



    public static void main(String[] args) {
        NextSequence nextSequence = new NextSequence();
        int[] arr = new int[]{1, 2, 3};
        nextSequence.getNextSequence03(arr);
        System.out.println(Arrays.toString(arr));
    }
}
