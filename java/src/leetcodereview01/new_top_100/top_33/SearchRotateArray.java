package leetcodereview01.new_top_100.top_33;

public class SearchRotateArray {
    // 选中数组中查找 通过特性处理
    public int find(int[] arr, int target) {
        // 也是通过二分查找处理
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int start = 0;
        int end = arr.length - 1;
        int targetIndex = -1;
        while(start <= end) {
            int middle = start + (end - start) / 2;
            if (arr[middle] == target) {
                return middle;
            }
            if (arr[0] <= arr[middle]) {

            }
        }
        return targetIndex;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        SearchRotateArray searchRotateArray = new SearchRotateArray();
        int result = searchRotateArray.find(arr, 0);
        System.out.println(result);
    }
}
