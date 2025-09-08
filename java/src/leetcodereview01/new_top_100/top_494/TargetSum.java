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

    public int count01(int[] arr, int target) {
        // 通过+ -算法来达到target的值
        if (arr == null || arr.length == 0) {
            return -1;
        }
        backTracking01(arr, target, 0, 0);
        return count;
    }

    public void backTracking01(int[] arr, int target, int sum, int index) {
        if (index == arr.length) {
            if (target == sum) {
                count++;
            }
        } else {
            backTracking01(arr, target, sum + arr[index], index + 1);
            backTracking01(arr, target, sum - arr[index], index + 1);
        }
    }

    public int count02(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        // 通过回溯的方式进行处理
        backTracking02(arr, target, 0, 0);
        return count;
    }

    public void backTracking02(int[] arr, int target, int sum, int index) {
        if (arr.length == index) {
            if (target == sum) {
                count++;
            }
        } else {
            backTracking01(arr, target, sum+arr[index], index+1);
            backTracking01(arr, target, sum-arr[index], index+1);
        }
    }

    public int count03(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        backTracking03(arr, target, 0, 0);
        return count;
    }

    public void backTracking03(int[] arr, int target, int index, int sum) {
        if (index == arr.length) {
            if (target == sum) {
                count++;
            }
            return;
        }
        backTracking03(arr, target, index + 1, sum + arr[index]);
        backTracking03(arr, target, index + 1, sum - arr[index]);
    }

    public static void main(String[] args) {
        int[] value = {1,1,1,1,1};
        int target = 3;
        TargetSum targetSum = new TargetSum();
        System.out.println(targetSum.count02(value, target));
    }
}
