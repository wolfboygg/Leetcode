package leetreview.arrayfind;

public class LeetcodeDuplicateArrayNotChange {

    /**
     * 在不改变数组的情况下我们要做的就是使用二分法进行统计个数，如果超过了1那说明重复了
     *
     * @param nums
     * @return
     */
    public int duplicate(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        int start = 1;
        int end = nums.length - 1;
        while (end >= start) {
            int middle = ((end - start) >> 1) + start;
            System.out.println(middle);
            // 进行统计
            int count = countRange(nums, start, middle);
            if (start == end) {
                if (count > 1) {
                    return start;
                } else {
                    return -1;
                }
            } else {
                if (count > (middle - start) + 1) {
                    end = middle;
                } else {
                    start = middle + 1;
                }
            }
        }
        return -1;
    }

    private int countRange(int[] nums, int start, int end) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= start && nums[i] <= end) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        LeetcodeDuplicateArrayNotChange leetcodeDuplicateArrayNotChange = new LeetcodeDuplicateArrayNotChange();
        int[] array = {2, 3, 5, 4, 2, 6, 1};
        int duplicate = leetcodeDuplicateArrayNotChange.duplicate(array);
        System.out.println(duplicate);
    }
}
