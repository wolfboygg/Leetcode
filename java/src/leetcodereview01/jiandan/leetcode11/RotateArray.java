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

    public int getMinValueByCompare(int[] arr) {
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (minValue > arr[i]) {
                minValue = arr[i];
            }
        }
        return minValue;
    }

    public int getMinValueByTX(int[] arr) {
        // 通过二分法进行找到不是递增的一半在进行查找
        int low = 0;
        int height = arr.length - 1;
        while (low < height) {
            int middle = low + (height - low) / 2;
            if (arr[middle] < arr[height]) { // 递增
                height = middle;
            } else { // 不是递增那么middle一定不是最小的
                low = middle + 1;
            }
        }
        return arr[low];
    }

    public int getMinValueByTX02(int[] arr) {
        // 根据特性使用二分查找的方式
        int low = 0;
        int height = arr.length -1;
        while (low < height) {
            int middle = low + (height - low) / 2;
            if (arr[middle] < arr[height]) {
                // 递增
                height = middle;
            } else {
                low = middle + 1;
            }
        }
        return arr[low];
    }

    public int getMinValueByTx03(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        while(left < right) {
            int middle = left + (right - left) / 2;
            if (arr[middle] < arr[right]) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return arr[left];
    }


    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7,  1, 2, 3};
        int[] arr2 = { 4, 5, 0, 1, 2, 3};
        RotateArray rotateArray = new RotateArray();
        int i = rotateArray.getMinValueByTx03(arr);
        System.out.println("最小值为:" + i);
    }
}
