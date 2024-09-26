package doublepointer.addnumiss;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * 在有序数组中找出两个数，使得和为给定的数 S。如果有多对数字的和等于 S，输出两个数的乘积最小的。
 * 使用双指针，一个指针指向元素较小的值，一个指针指向元素较大的值。指向较小元素的指针从头向尾遍历，指向较大元素的指针从尾向头遍历。
 * 如果大于target 尾部指针向前移动 小于target 头部指针向后移动
 */

public class AddNumIsS {

    public static ArrayList<Integer> FindNumbersWithSum(int[] nums, int target) {
        int headPointer = 0;
        int tailPointer = nums.length - 1;
        while (headPointer < tailPointer) {
            int tempAdd = nums[headPointer] + nums[tailPointer];
            if (tempAdd == target) {
                return new ArrayList<>(Arrays.asList(nums[headPointer], nums[tailPointer]));
            }
            if (tempAdd > target) {
                tailPointer--;
            } else {
                headPointer++;
            }
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        ArrayList<Integer> integers = FindNumbersWithSum(nums, 15);
        if (integers.size() == 2) {
            System.out.println(integers);
        } else {
            System.out.println("不存在");
        }
    }
}
