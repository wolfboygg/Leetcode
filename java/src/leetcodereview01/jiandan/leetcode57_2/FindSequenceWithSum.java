package leetcodereview01.jiandan.leetcode57_2;

import java.util.ArrayList;
import java.util.List;

public class FindSequenceWithSum {

    // 获取和为某个值的序列 可能有多个
    public List<List<Integer>> findSequence01(int sum) {
        // 最大值到sum
        List<List<Integer>> result = new ArrayList<>();
        int start = 1;
        int end = 2;
        int curSum = 3;
        while(end < sum) {
            if (curSum < sum) {
                end++;
                curSum += end;
            } else if (curSum > sum) {
                curSum -= start;
                start++;
            } else {
                List<Integer> list = new ArrayList<>();
                for (int i = start; i <= end; i++) {
                    list.add(i);
                }
                result.add(list);
                // 加完了还需要处理
                curSum-=start;
                start++;
                end++;
                curSum+=end;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        FindSequenceWithSum findSequenceWithSum = new FindSequenceWithSum();
        List<List<Integer>> sequence = findSequenceWithSum.findSequence(100);
        System.out.println(sequence);
    }

    private List<List<Integer>>  findSequence(int sum) {
        List<List<Integer>> numSequence = new ArrayList<>();
        int start = 1;
        int end = 2;
        int curSum = 3;
        while (end < sum) {
            if (curSum < sum) {
                end++;
                curSum += end;
            } else if (curSum > sum) {
                curSum -= start;
                start++;
            } else {
                // 相等
                List<Integer> temp = new ArrayList<>();
                for (int i = start; i <= end; i++) {
                    temp.add(i);
                }
                numSequence.add(temp);
                curSum -= start;
                start++;
                end++;
                curSum += end;
            }
        }
        return numSequence;
    }
}
