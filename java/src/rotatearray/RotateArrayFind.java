package rotatearray;

/**
 * 旋转数组
 */
public class RotateArrayFind {


    /**
     * 通过二分法将旋转分为两半进行处理
     * [3,4,5,1,2]
     *
     * @param array [4,5,6,7,0,1,2,3]
     * @return
     */
    public int findMinNumInRotateArray(int[] array) {
        int low = 0;
        int height = array.length - 1;
        while (low < height) {
            int middle = low + (height - low) / 2;
            if (array[middle] < array[height]) { // 说明是递增序列
                height = middle;
            } else {
                low = middle + 1;
            }
        }
        return array[low];
    }

    /**
     * 重复的数字的查找[1,1,1,0,1]
     * [2,2,2,2,2,0,1,2]
     */
    public int findMinNumInRotateArrayContainerRepeateNumber(int[] array) {
        int low = 0;
        int height = array.length - 1;
        while (low < height) {
            int middle = low + (height - low) / 2;
            if (array[low] == array[middle] && array[middle] == array[height]) {
                // 转换为顺序查找
                return findMinNumByOrder(array, low, height);
            } else if (array[middle] < array[height]) {
                height = middle;
            } else {
                low = middle + 1;
            }
        }
        return array[low];
    }

    public int findMinNumByOrder(int[] array, int l, int h) {
        for (int i = l; i < h; i++) {
            if (array[i] > array[i+1]) {
                return array[i+1];
            }
        }
        return array[l];
    }

    public static void main(String[] args) {
        RotateArrayFind arrayFind = new RotateArrayFind();
        System.out.println(arrayFind.findMinNumInRotateArray(new int[]{4, 5, 6, 7, 0, 1, 2, 3}));
        System.out.println(arrayFind.findMinNumInRotateArray(new int[]{3, 4, 5, 1, 2}));
        System.out.println(arrayFind.findMinNumInRotateArrayContainerRepeateNumber(new int[]{1,1,1,0,1}));
        System.out.println(arrayFind.findMinNumInRotateArrayContainerRepeateNumber(new int[]{2,2,2,2,2,0,1,2}));
    }

}
