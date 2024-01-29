package leetcodereview01.top100.top_01;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 */
public class TwoSum {

    public List<Integer> towSum(int[] num, int target) {
        // 第一眼看到的解决办法，使用双指针的方式进行求解 数组中的元素是递增的
        int P1 = 0;
        int P2 = num.length -1;
        List<Integer> ret = new ArrayList<>();
        while(P1 <= P2) {
            int tempValue = num[P1] + num[P2];
            if (tempValue > target) {
                P2--;
            } else if (tempValue < target) {
                 P1++;
            } else {
                ret.add(P1);
                ret.add(P2);
                return ret;
            }
        }
        return ret;
    }
    public static void main(String[] args){
        int[] num = new int[] {2, 7, 11, 15};
        int targe = 9;
        TwoSum twoSum = new TwoSum();
        List<Integer> integers = twoSum.towSum(num, targe);
        System.out.println(integers.toString());
    }
}