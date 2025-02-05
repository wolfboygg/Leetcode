package leetcodereview01.new_top_100.top_494;

/**
 * 目标和 通过+ -来判断是否可以计算出来目标
 */
public class TargetSum {

    private int count = 0;

    public int count(int[] arr, int target) {
        // 通过回溯的方式进行计算
        if (arr == null || arr.length == 0) {
            return -1;
        }
        backTracking(arr, 0, 0, target);
        return count;
    }

    public void backTracking(int[] num, int index, int sum, int target) {
        if (index == num.length) {
            if (sum == target) {
                count++;
            }
        } else {
            backTracking(num, index + 1, sum + num[index], target);
            backTracking(num, index + 1, sum - num[index], target);
        }
    }

    public static void main(String[] args) {
        int[] value = {1,1,1,1,1};
        int target = 3;
        TargetSum targetSum = new TargetSum();
        System.out.println(targetSum.count(value, target));
    }
}
