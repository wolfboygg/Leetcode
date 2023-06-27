package leetcodereview01.jiandan.leetcode11;

public class RotateArray {

    public int rotateArrayFind(int[] arr) {
        int temp = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < temp) {
                temp = arr[i];
            }
        }
        return temp;
    }

    public int rotateArrayFindTX(int[] arr) {
        // 数组就是从左到右递增
        int low = 0;
        int height = arr.length - 1;
        while (low < height) {
            int middle = low + (height - low) / 2;
            if (arr[middle] < arr[height]) { // 递增
                height = middle;
            } else {
                low = middle + 1;
            }
        }
        return arr[low];
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2, 3};
        int[] arr2 = {3, 4, 5, 1, 2};
        RotateArray rotateArray = new RotateArray();
        int i = rotateArray.rotateArrayFindTX(arr);
        System.out.println("最小值为:" + i);
    }
}
