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

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        SearchRotateArray searchRotateArray = new SearchRotateArray();
        int result = searchRotateArray.find(arr, 0);
        System.out.println(result);
    }
}
