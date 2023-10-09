package leetcodereview01.jiandan.heapsort;

import java.util.Arrays;

public class BinaryHeap {

    // 下沉

    public void downAdJust(int[] arr, int parentIndex, int length) {
        // 就是找到对应的节点进行处理
        int temp = arr[parentIndex];
        int childIndex = parentIndex * 2 + 1; // 左孩子
        while(childIndex < length) {
          // 如果右孩子比左孩子小，那么需要定位到右孩子
          if (childIndex + 1 < length && arr[childIndex +1] < arr[childIndex]) {
              childIndex++;
          }
          if (temp < arr[childIndex]) {
              break;
          }
          // 下沉只得是大下沉
          arr[parentIndex] = arr[childIndex];
          parentIndex = childIndex; // parent已经改变为孩子节点了
          childIndex = parentIndex * 2 + 1;
        }
        arr[parentIndex] = temp;
    }

    // 上浮 指的是小元素上浮
    public void upAdJust(int[] arr) {
        int childIndex = arr.length - 1;
        int parentIndex = (childIndex -1) / 2;
        int temp = arr[childIndex];
        while(childIndex > 0 && temp < arr[parentIndex]) {
            arr[childIndex] = arr[parentIndex];
            childIndex = parentIndex;
            parentIndex = (childIndex - 1) /2;
        }
        arr[childIndex] = temp;
    }

    public void upAdJust01(int[] arr) {
        // 上浮 要对最后一个元素进行处理
        int childIndex = arr.length - 1;
        int parentIndex = (childIndex - 1) / 2;
        int temp = arr[childIndex];
        while(childIndex > 0 && temp < arr[parentIndex]) {
            arr[childIndex] = arr[parentIndex];
            childIndex = parentIndex;
            parentIndex = (childIndex-1)/2;
        }
        arr[childIndex] = temp;
    }

    public void downAdJust01(int[] arr, int parentIndex, int length) {
        // 非叶子节点进行下沉，那么需要判断是左右
        int childIndex = 2 * parentIndex + 1;// 左
        int temp = arr[parentIndex];
        while(childIndex < length) {
            if (childIndex + 1 < length && arr[childIndex+1] < arr[childIndex]) {
                childIndex++;// 定位到右孩子
            }
            if(temp < arr[childIndex]) {
                break;
            }
            // 进行交换
            arr[parentIndex] = arr[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * parentIndex + 1;
        }
        arr[parentIndex] = temp;
    }


    public void upAdJust02(int[] arr) {
        // 上浮，只需要处理一个节点即可 主要就是通过找到parentIndex
        int childIndex = arr.length - 1;
        int parentIndex = (childIndex -1) / 2;
        int temp = arr[childIndex];
        while(childIndex > 0 &&  temp < arr[parentIndex]) {
            arr[childIndex] = arr[parentIndex];
            childIndex = parentIndex;
            parentIndex = (childIndex - 1) / 2;
        }
        arr[childIndex] = temp;
    }

    public void downAdJust02(int[] arr, int parentIndex, int length) {
        // 下沉就是对每一个非叶子节点进行处理
        int childIndex = 2 * parentIndex + 1;
        int temp = arr[parentIndex];
        while(childIndex < length ) {
            if (childIndex + 1 < length && arr[childIndex + 1] < arr[childIndex]) {
                childIndex++;// 定位到右孩子
            }
            if (temp < arr[childIndex]) {
                break;
            }
            arr[parentIndex] = arr[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * parentIndex + 1;
        }
        arr[parentIndex] = temp;
    }


    public void buildHeap(int[] arr) {
        for(int i = (arr.length -2)/2; i >=0; i--) {
            downAdJust02(arr, i, arr.length);
        }
    }

    public static void main(String[] args){
        BinaryHeap binaryHeap = new BinaryHeap();
        int[] array = new int[] {1,3,2,6,5,7,8,9,10,0};
        binaryHeap.upAdJust02(array);
        System.out.println(Arrays.toString(array));

        array = new int[] {7,1,3,10,5,2,8,9,6};
        binaryHeap.buildHeap(array);
        System.out.println(Arrays.toString(array));
    }
}
