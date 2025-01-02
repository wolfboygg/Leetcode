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

    // 4, 5, 1, 2, 3
    public int getMinValueByTx10(int[] arr) {
        // 旋转数组中找到最小值  通过二分进行查找
        int low = 0;
        int height = arr.length -1;
        while(low < height) { // 这里不能相等 相等会导致多计算一次 导致low多加一次1
            int middle = low + (height - low) / 2;
            if (arr[middle] < arr[height]) {
                height = middle;
            } else {
                low = middle + 1;
            }
        }
        return arr[low];
    }

    public int getMinValueByTx11(int[] arr) {
        // 在旋转数组中查找到最小值
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int left = 0;
        int right = arr.length -1;
        // 4, 5, 0, 1, 2, 3
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
        int i = rotateArray.getMinValueByTx11(arr2);
        System.out.println("最小值为:" + i);
    }
}
