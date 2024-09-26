package tantan.binary_heap;

import java.util.Arrays;

public class BinaryHeap {

    /**
     * "上浮"调整
     *
     * @param array
     */
    public void upAdjust(int[] array) {
        // 上浮只需要调整最后一个元素即可
        int childIndex = array.length - 1;
        int parentIndex = (childIndex - 1) / 2;
        int temp = array[childIndex];
        while (childIndex > 0 && temp < array[parentIndex]) {
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (childIndex - 1) / 2;
        }
        array[childIndex] = temp;
    }

    /**
     * "下沉"调整
     *
     * @param array
     * @param parentIndex
     * @param length
     */
    public void downAdjust(int[] array, int parentIndex, int length) {
        // 下沉操作，需要对给定的parentIndex进行下沉比较操作
        int childIndex = parentIndex * 2 + 1;// 先找到最小的左节点
        int temp = array[parentIndex];
        while (childIndex < length) {
            // 先定位右孩子
            if (childIndex + 1 < length && array[childIndex + 1] < array[childIndex]) {
                childIndex++;
            }
            if (temp <= array[childIndex]) {
                break;
            }
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = parentIndex * 2 + 1;
        }
        array[parentIndex] = temp;
    }

    public void buildHeap(int[] array) {
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            System.out.println(array[i] + "-->" +i);
            downAdjust(array, i, array.length);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 2, 6, 5, 7, 8, 9, 10, 0};
        BinaryHeap binaryHeap = new BinaryHeap();
        binaryHeap.upAdjust(array);
        System.out.println(Arrays.toString(array));

        array = new int[]{7, 1, 3, 10, 5, 2, 8, 9, 6};
        binaryHeap.buildHeap(array);
        System.out.println(Arrays.toString(array));
    }
}
