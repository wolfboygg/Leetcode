package leetreview.arrayfind;

public class DuplicateArrayNotChange02 {

    /**
     * 主要思路就是进行统计个数，从star-END中间的个数，只要超过了应该的count就说明又重复的
     * 二分查找
     *
     * @param nums
     * @return
     */
    public int duplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 1;
        int end = nums.length - 1;
        while (end >= start) {
            int middle = ((end - start) >> 1) + start;
            int count = count(nums, start, middle);
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

    public int count(int[] nums, int start, int end) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= start && nums[i] <= end) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] array = {2, 3, 5, 4, 2, 6, 1};
        DuplicateArrayNotChange02 duplicateArrayNotChange02 = new DuplicateArrayNotChange02();
        int duplicate = duplicateArrayNotChange02.duplicate(array);
        System.out.println(duplicate);
    }

}
