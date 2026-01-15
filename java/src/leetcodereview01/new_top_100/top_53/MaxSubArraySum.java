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

    public int calculate01(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int max = 0;
        int curMax = 0;
        for (int i = 0; i < arr.length; i++) {
            curMax = Math.max(curMax + arr[i], arr[i]);
            max = Math.max(max, curMax);
        }
        return max;
    }

    public int calculate02(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int max = 0;
        int curMax = 0;
        for (int i = 0; i < arr.length; i++) {
            curMax = Math.max(curMax + arr[i], arr[i]);
            max = Math.max(max, curMax);
        }
        return max;
    }

    public int calculate03(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int max = 0;
        int curSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            curSum = Math.max(arr[i], curSum + arr[i]);
            max = Math.max(max, curSum);
        }
        return max;
    }

    public int calculate04(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int curSum = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            curSum = Math.max(arr[i], curSum + arr[i]);
            max = Math.max(max, curSum);
        }
        return max;
    }


    public int calculate05(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int curSum = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            curSum = Math.max(arr[i], curSum + arr[i]);
            max = Math.max(max, curSum);
        }
        return max;
    }

    public int calculate06(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int curSum = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            curSum = Math.max(arr[i], arr[i] + curSum);
            max = Math.max(max, curSum);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        MaxSubArraySum maxSubArraySum = new MaxSubArraySum();
        // 6
        System.out.println(maxSubArraySum.calculate06(arr));
    }
}
