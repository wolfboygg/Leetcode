package leetcodereview01.top100.top_33;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 */
public class SearchRotateArray {

    public int find(int[] num, int target) {
        // 通过查找的方式进行处理
        // 就是单纯的二分查找即可
        int left = 0;
        int right = num.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (num[middle] == target) {
                return middle;
            }
            if (target < middle) {
                if (num[middle] < num[right]) {
                    right = middle -1;
                } else {
                    left = middle + 1;
                }
            } else {
                if (num[middle] < num[right]) {
                    left = middle + 1;
                } else {
                    right = middle -1;
                }
            }
        }
        return -1;
    }

    /**
     * 通过二分查找的方式进行处理
     * @param num
     * @param start
     * @param end
     * @param target
     * @return
     */
    public int findByBinary(int[] num, int start, int end, int target) {
       return -1;
    }

    public static void main(String[] args){
        // 使用二分查找的方式进行处理
        int[] num = {5,6,7,0,1,2};
        SearchRotateArray searchRotateArray = new SearchRotateArray();
        int index = searchRotateArray.find(num, 0);
        System.out.println(index);
    }
}
