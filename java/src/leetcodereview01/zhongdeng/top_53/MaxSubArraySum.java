package leetcodereview01.zhongdeng.top_53;

/**
 * 最大子数组的和
 */
public class MaxSubArraySum {

    public int getMaxSubArraySum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        // 使用动态规划进行求解
        int max = 0;
        int subMax = arr[0];
        for (int i = 1; i < arr.length; i++) {
            subMax = Math.max(arr[i], subMax + arr[i]);
            max = Math.max(max, subMax);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums = {5, 4, -1, 7, 8};
        MaxSubArraySum maxSubArraySum = new MaxSubArraySum();
        System.out.println(maxSubArraySum.getMaxSubArraySum(nums));
    }
}
