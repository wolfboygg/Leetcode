package leetcodereview01.new_top_100.top_33;

public class SearchRotateArray {
    // 选中数组中查找 通过特性处理
    public int find(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        while(left < right) {
            System.out.println(left + "--->" + right);
            int middle = left + (right - left) / 2;
            if (arr[middle] < target) {
                right = middle - 1;
            } else if (arr[middle] > target){
                left = middle + 1;
            } else {
                return left;
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
