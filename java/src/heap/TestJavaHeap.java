package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 使用PriorityQueue实现堆
 */
public class TestJavaHeap {

    public static void main(String[] args) {
        int[] array = {4, 6, 8, 5, 9};
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void heapSort(int[] arr) {
        System.out.println("堆排序:" + Arrays.toString(arr));

        //将无序序列构建成一个大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
//            System.out.println("current index:" + i);
            adjustHeap(arr, i, arr.length);
        }
        System.out.println(Arrays.toString(arr));
        //将堆顶元素和末尾元素进行交换，将最大的数放到数组的末尾
        //再重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行 调整+交换 步骤，直到整个序列有序
        for (int j = arr.length - 1; j >= 0; j--) {
            System.out.println("change header and tail:" + arr[j] + "-->:" + arr[0]);
            //交换
            int temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
//            System.out.println(Arrays.toString(arr));
            // 0, 4
            adjustHeap(arr, 0, j);
            System.out.println(Arrays.toString(arr));
        }
    }

    /**
     * 功能：完成将以 i 对应的非叶子节点的树调整成为大顶堆
     *
     * @param arr    待调整的数组
     * @param i      表示非叶子节点在数组中的索引
     * @param length 表示对多少个元素进行调整，每排序好一趟，length的长度就减1
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        System.out.println(i);
        int temp = arr[i];  //先取出当前元素的值，保存在临时变量中
        //开始调整
        //1.k = i * 2 + 1 是i 节点的左子节点
        // i = 0 , length = 4
        // k= 1;k<4;k=3
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            System.out.print("k:" + k + "-->arr[k]" + arr[k] + "--->arr[k+1]:" + arr[k + 1]+"    ");
            if (k + 1 < length && arr[k] < arr[k + 1]) {  //说明左子节点的值小于右子节点的值，
                k++;  //k指向右子节点，目的是为了找到左右孩子节点中的最大值
            }
            if (arr[k] > temp) {  //如果子节点大于父节点，说明需要调整
                arr[i] = arr[k];  //把较大的值作为当前的树的父节点
                i = k;  // i 指向 k，继续循环比较
            } else {
                break;
            }
        }
        System.out.println("arr[i]:" + arr[i] + "-> temp:" + temp);
        System.out.println();
        //当for循环结束后，已经将以 i 为父节点的树的最大值，放在了顶端（局部）
        arr[i] = temp;  //将temp值放到调整后的位置

    }


    public static void main1(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(5);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(5, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        int[] array = {12, 20, 39, 1, 8, 9, 18, 7, 6, 10};
        // test min heap
        for (int i : array) {
            minHeap.offer(i);
            maxHeap.offer(i);
        }
        // 取出结果
        for (int i = 0; i < 5; i++) {
            if (minHeap.peek() != null) {
                System.out.print(minHeap.poll() + " ");
            }
        }
        System.out.println();
        for (int i = 0; i < 5; i++) {
            if (maxHeap.peek() != null) {
                System.out.print(maxHeap.poll() + " ");
            }
        }
    }


}
