package leetcodereview01.new_top_100.top_53;

/**
 * 最大子数组的和
 */
public class MaxSubArraySum {

    public int calculate(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int max = 0;
        int cur = 0;
        for (int i = 0; i < arr.length; i++) {
            cur = Math.max(arr[i], cur + arr[i]);
            max = Math.max(cur, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {-2,1,-3,4,-1,2,1,-5,4};
        MaxSubArraySum maxSubArraySum = new MaxSubArraySum();
        System.out.println(maxSubArraySum.calculate(arr));
    }
}
