package repeatnumber;

/**
 * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * <p>
 * 解法:通过将数字放到对应的下标，如果有数字证明重复
 *
 * 要求时间复杂度 O(N)，空间复杂度 O(1)。因此不能使用排序的方法，也不能使用额外的标记数组。
 *
 */

public class RepeatNumber {

    public static boolean duplicate(int[] number, int length, int[] duplication) {
        for (int i = 0; i < length; i++) {
            while (i != number[i]) {
                if (number[i] == number[number[i]]) {
                    duplication[0] = number[i];
                    return true;
                }
                swap(number, i, number[i]);
            }
        }
        return false;
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] num = {2, 3, 1, 0, 2, 5};
        int[] repeatNum = new int[5];
        boolean isExit = duplicate(num, num.length, repeatNum);
        if (isExit) {
            System.out.println(repeatNum[0]);
        } else {
            System.out.println("不存在");
        }

    }
}
