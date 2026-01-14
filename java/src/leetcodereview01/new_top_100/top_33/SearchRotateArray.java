package leetcodereview01.new_top_100.top_33;

public class SearchRotateArray {
    // 选中数组中查找 通过特性处理 左边有序左边等 右边有序右边等
    public int find(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        while(left <= right) {
            int middle = left + (right - left) / 2;
            if (arr[middle] == target) {
                return middle;
            }
            if (arr[0] <= arr[middle]) { // 左边有序
                System.out.println("111");
                if (arr[0] <= target && target < arr[middle]) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            } else { // 右边有序
                System.out.println("222");
                if (arr[middle] < target && target <= arr[arr.length - 1]) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }

        }
        return -1;
    }

    public int find01(int[] arr, int target) {
        // 使用二分法进行查找
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int start = 0;
        int end = arr.length - 1;
        while(start <= end) {
            int middle = start + (end - start) / 2;
            if (arr[middle] == target) {
                return middle;
            }
            // 固定区间 首先是左边，然后是右边
            if (arr[start] <= arr[middle]) {
                if (arr[start] <= target && target < arr[middle]) {
                    end = middle - 1;
                } else {
                    start = middle + 1;

                }
            } else {
                if (arr[middle] < target && target <= arr[end]) {
                    start = middle + 1;
                } else {
                    end = middle - 1;
                }
            }
        }
        return -1;
    }


    // 左右进行搜索
    // {4, 5, 6, 7, 0, 1, 2}; length = 7
    // 0 + (6-0)/2 = 3
    public int find02(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        while(left <= right) {
            int middle = left + (right - left) / 2;
            if (arr[middle] == target) {
                return middle;
            }
            if (arr[left] <= arr[middle]) {// 升序
                // 先卡区间 表示在左边 卡在左边
                if (arr[left] <= target && target < arr[middle]) {
                    right = middle - 1;
                } else {
                    // 在右边
                    left = middle + 1;
                }
            } else {
                if (arr[middle] < target &&  target <= arr[right]) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        }
        return -1;
    }



    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        SearchRotateArray searchRotateArray = new SearchRotateArray();
        int result = searchRotateArray.find02(arr, 0);
        System.out.println(result);
    }
}
