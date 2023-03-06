package adjustarray;

import java.util.Arrays;

public class AdjustArray {

    /**
     * 调整数组中奇数偶数的顺序，使用统计加数组复制的方式进行处理
     *
     * @param array
     */
    public void adjustArray(int[] array) {
        int oddCount = 0;
        for (int i : array) {
            if ((i & 1) != 0) {
                oddCount++;
            }
        }
        System.out.println(oddCount);
        int[] clone = array.clone();
        int index = 0;
        for (int num : clone) {
            if ((num & 1) == 1) {// 奇数
                array[index++] = num;
            } else {
                array[oddCount++] = num;
            }
        }
        System.out.println(Arrays.toString(array));
    }


    /**
     * 使用双向指针的方式进行处理，但是这种方式可能得到的顺序相对来说没有那么位置不变
     * 这种方式和原来的对比相对位置没有改变
     *
     * @param array
     */
    public void adjustArrayByPointer(int[] array) {
        int left = 0;
        int right = array.length - 1;
        // 左边指针移动直到遇到偶数然后进行交换
        while (left < right) {
            if ((array[left] & 1) == 1) {
                left++;
                continue;
            }
            if ((array[right] & 1) != 1) {
                right--;
                continue;
            }
            swap(array, left, right);// 找到那个左边不是奇数右边不是偶数的位置然后开始交换，直到左右指针重合
            left++;
            right--;
        }
        System.out.println(Arrays.toString(array));
    }

    public void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    public static void main(String[] args) {
        AdjustArray adjustArray = new AdjustArray();
        int[] array = {1, 2, 3, 4, 5};
//        adjustArray.adjustArray(array);
        adjustArray.adjustArrayByPointer(array);
    }
}
