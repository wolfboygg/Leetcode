package leetcodereview01.jiandan.leetcode57_2;

import java.sql.Array;
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

    public List<List<Integer>> findSequence02(int target) {
        // 这种解决办法就是双指针移动，找到记录然后在走
        int P1 = 1;
        int P2 = 2;
        int sum = 3;
        List<List<Integer>> result = new ArrayList<>();
        while(P2 <= target) {
            // 进行判断
            if (sum < target) {
                P2++;
                sum += P2;
            } else if (sum > target) { // 比目标数值大就要往后走了，重新再找序列
                sum -= P1;
                P1++;
            } else {
                List<Integer> list = new ArrayList<>();
                for (int i = P1; i <= P2; i++) {
                    list.add(i);
                }
                result.add(list);
                sum -= P1;
                P1++;
                P2++;
                sum += P2;
            }
        }
        return result;
    }

    public List<List<Integer>> findSequence03(int target) {
        // 那么就是从1 到 100 采用前后两个指针进行移动进行处理
        int P1 = 1;
        int P2 = 2;
        List<List<Integer>> list = new ArrayList<>();
        int curSum = P1 + P2;
        while(P2 <= target) {
            if (curSum < target) {
                P2++;
                curSum += P2;
            } else if (curSum > target) {
                curSum-=P1;
                P1++;
            } else {
                // 进行加入
                List<Integer> tempList = new ArrayList<>();
                for(int i = P1; i <= P2; i++) {
                    tempList.add(i);
                }
                list.add(tempList);
                curSum -= P1;
                P1++;
                P2++;
                curSum += P2;
            }
        }
        return list;
    }

    public List<List<Integer>> findSequence04(int sum) {
        int start = 1;
        int end = 2;
        int curSum = start + end;
        List<List<Integer>> ret = new ArrayList<>();
        while(end <= sum) {
            if (curSum < sum) {
                end++;
                curSum += end;
            } else if (curSum > sum) {
                curSum -= start;
                start++;
            } else {
                // 表示等于了那么就搞一下
                List<Integer> temp = new ArrayList<>();
                for(int i = start; i <= end; i++) {
                  temp.add(i);
                }
                ret.add(temp);
                curSum -= start;
                start++;
                end++;
                curSum += end;
            }
        }
        return ret;
    }

    // 和为S的连续正整数序列 同样方式还是使用双指针进行和的叠加
    public List<List<Integer>> findSequence05(int target) {
        // 从1 到 100  和为100
        List<List<Integer>> ret = new ArrayList<>();
        int P1 = 1; int P2 = 2;
        int sum = 3;
        while (P2 <= target) {
            if (sum == target) {
                List<Integer> list = new ArrayList<>();
                for(int j = P1; j <= P2; j++) {
                  list.add(j);
                }
                ret.add(list);
                // 后序还需要往后走
                sum-=P1;
                P1++;
                P2++;
                sum+=P2;
            } else if (sum < target) {
                P2++;
                sum += P2;
            } else {
               // 改变一下sum看看是否与target相等
               sum-=P1;
               P1++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        FindSequenceWithSum findSequenceWithSum = new FindSequenceWithSum();
        List<List<Integer>> sequence = findSequenceWithSum.findSequence05(100);
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
