package FindSequenceSum;

import java.util.ArrayList;
import java.util.List;

/**
 * 输出所有和为 S 的连续正数序列。例如和为 100 的连续序列有：
 */
public class FindSequenceWithSum {

    /**
     * 找到的可能是多个，所以要使用集合嵌套集合处理
     *
     * @param sum
     * @return
     */
    public static ArrayList<ArrayList<Integer>> findSequenceWithSum(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int start = 1;
        int end = 2;
        int curSum = 3;
        // end 小于sum才能找到连续的序列
        while (end < sum) {
            if (curSum < sum) {
                end++;
                curSum += end;
            } else if (curSum > sum) {
                curSum -= start;
                start++;
            } else {
                ArrayList<Integer> tempResult = new ArrayList<>();
                for (int i = start; i <= end; i++) {
                    tempResult.add(i);
                }
                result.add(tempResult);
                // 接着开始下一轮的查找
                curSum -= start;
                start++;
                end++;
                curSum += end;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> withSum = findSequenceWithSum(100);
        System.out.println(withSum);
    }
}
