package leetreview.arrayfind;

/**
 * 二维数组中进行查找
 */
public class DuplicateArrayFind02 {

    /**
     * 主要思想就是通过元素的下标和内容要对应起来，如果已经存在就表示存在了
     * @param nums
     * @return
     */
    public int duplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            while(nums[i] != i) {// 不等就进行循环操作
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                swap(nums, i, nums[i]);
            }
        }
        return -1;
    }

    public void swap(int[] nums, int currentPosition, int currentValue) {
        int temp = nums[currentPosition];
        nums[currentPosition] = currentValue;
        nums[currentValue] = temp;
    }

    public static void main(String[] args) {
        int[] array = {2, 3, 1, 0, 2, 5, 3};
        DuplicateArrayFind02 duplicateArrayFind02 = new DuplicateArrayFind02();
        int duplicate = duplicateArrayFind02.duplicate(array);
        System.out.println(duplicate);
    }
}
