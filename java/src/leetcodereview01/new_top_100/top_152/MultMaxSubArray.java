package leetcodereview01.new_top_100.top_152;

/**
 * 乘积最大的字数组，注意的是这个数组中存在负数
 */
public class MultMaxSubArray {

    public int calculate(int[] arr) {
        // 使用动态规划的方式进行处理
        if (arr == null && arr.length == 0) {
            return -1;
        }
        int maxValue = arr[0]; // 只是当前最大的
        int minValue = arr[0];
        int result = maxValue;
        for (int i = 1; i < arr.length; i++) {
            // 记得使用临时变量替换一下，否则会使用最新的结果，这样是错误的
            int tempMaxValue = maxValue;
            int tempMinValue = minValue;
            // 只需要关心当前的值就行了， 应为有记忆最小的结果，所以关心的是乘积和当前值的大小
            maxValue = Math.max(Math.max(tempMaxValue * arr[i], arr[i]), tempMinValue * arr[i]);
            minValue = Math.min(Math.min(tempMinValue * arr[i], arr[i]), tempMaxValue * arr[i]);

            System.out.println(maxValue + "--->" + minValue);
            result = Math.max(result, maxValue);
        }
        return result;
    }
    // 由于存在负数 所以要记录最大的值和最小的值，因为可能会反转
    public int calculate02(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int max = 1;
        int min = 1;
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            int tmx = max;
            int tmi = min;
            max = Math.max(Math.max(tmx * arr[i], arr[i]), arr[i] * tmi);
            min = Math.min(Math.min(tmi * arr[i], arr[i]), arr[i] * tmx);
            if (min < (-1 << 31)) {
                min = arr[i];
            }
            result = Math.max(result, max);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 6, -1, 2, -3};
        MultMaxSubArray multMaxSubArray = new MultMaxSubArray();
        System.out.println(multMaxSubArray.calculate02(arr));
    }
}
