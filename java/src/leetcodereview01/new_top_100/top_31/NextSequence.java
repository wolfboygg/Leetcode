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

    public static void main(String[] args) {
        NextSequence nextSequence = new NextSequence();
        int[] arr = new int[]{1, 2, 3};
        nextSequence.getNextSequence01(arr);
        System.out.println(Arrays.toString(arr));
    }
}
