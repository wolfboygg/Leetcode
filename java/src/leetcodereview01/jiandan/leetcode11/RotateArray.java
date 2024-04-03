package leetcodereview01.jiandan.leetcode11;

import javax.xml.bind.annotation.XmlID;

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

    public int getMinValueByTX03(int[] arr) {
        // 旋转数组的特性就是递增，二分查找进行处理
        int low = 0;
        int height = arr.length - 1;
        while(low < height) {
            int middle = low + (height - low) / 2;
            if (arr[middle] < arr[height]) {
                height = middle;
            } else {
                low = middle + 1;
            }
        }
        return arr[low];
    }

    public int getMinValueByTX04(int[] arr) {
        // 旋转数组中最小的值
        int low = 0;
        int height = arr.length - 1;
        while(low < height) {
            int middle = low + (height - low) / 2;
            if (arr[middle] < arr[height]) {
                height = middle;
            } else {
                low = middle + 1;
            }
        }
        return arr[low];
    }

    public int getMinValueByTX05(int[] arr) {
        // 通过二分查找去处理
        int low = 0;
        int height = arr.length -1;
        while(low < height) {
            int middle = low + (height - low) / 2;
            if (arr[middle] < arr[height]) {
                height = middle;
            } else {
                low = middle + 1;
            }
        }
        return arr[low];
    }

    // 旋转的数组中查找最小值
    public int getMinValueByTX06(int[] arr) {
         // 通过二分查找进行处理
         int low = 0;
         int height = arr.length - 1;
         while(low < height) {
             int middle = low + (height - low) / 2;
             if (arr[middle] < arr[height]) {
                 height = middle;
             } else {
                 low = middle + 1;
             }
         }
         return arr[low];
    }

    public int getMinValueByTX07(int [] arr) {
        // [3,4,5,1,2]  这就是一个旋转数组 使用二分查找的方式寻找最小值
        int low = 0;
        int height = arr.length - 1;
        while(low < height) { // 这里不能相等，相等就会进入死循环
            int middle = low + (height - low) / 2;
            if (arr[middle] > arr[height]) {
                // 在右边
                low = middle + 1;
            } else {
                // 在左边
                height = middle;
            }
        }
        return arr[low]; // 最小值落在low上
    }

    // 4, 5, 0, 1, 2, 3
    public int getMinValueByTX08(int[] arr) {
        // 旋转数组找到最小的值 它的特性就是中位置一定是最小的
        int low = 0, height = arr.length -1;
        while(low < height) {
            int middle = low + (height - low) / 2;
            if (arr[middle] < arr[height]) {
                height = middle; // 这里不能减1 只能从这里开始
            } else {
                low = middle + 1;
            }
        }
        return arr[low];
    }

    public int getMinValueByTx09(int[] arr) {
        // 找到旋转数组中的最小值，通过二分查找的方式进行处理
        if (arr == null || arr.length == 0) {
            return -1;
        }
        // 4, 5, 0, 1, 2, 3
        int low = 0;
        int height = arr.length - 1;
        while(low < height) {
            // 这里需要计算middle的值
            int middle = low + (height - low) / 2;
            if (arr[middle] < arr[height]) {
                height = middle;
            } else {
                low = middle + 1;
            }
        }
        return arr[low];
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2, 3};
        int[] arr2 = { 4, 5, 0, 1, 2, 3};
        RotateArray rotateArray = new RotateArray();
        int i = rotateArray.getMinValueByTx09(arr);
        System.out.println("最小值为:" + i);
    }
}
