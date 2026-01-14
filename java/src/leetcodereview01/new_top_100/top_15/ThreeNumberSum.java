package leetcodereview01.new_top_100.top_15;

import java.util.ArrayList;
import java.util.List;

/** 三数之和 */
public class ThreeNumberSum {

    private List<List<Integer>> ret = new ArrayList<>();

    // 其中三个数为0
    public boolean getSumIsZeroList01(int[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        // 只要下标不同就ok 那就来一个简单的回溯
        boolean[] mark = new boolean[arr.length];
        backTracking01(arr, mark, 0, 0, new ArrayList<>());
        return !ret.isEmpty();
    }

    // {-1,0,1,2,-1,-4};
    public void backTracking01(int[] arr, boolean[] mark, int index, int sum, List<Integer> list) {
        if (list.size() > 3) {
            return;
        }
        if (sum == 0 && list.size() == 3) {
            ret.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < arr.length; i++) {
            if (sum > 0 && list.size() >= 3) {
                break;
            }
            mark[i] = true;
            sum += arr[i];
            list.add(arr[i]);
            System.out.println(sum);
            System.out.println(list.toString());
            System.out.println("=============");
            backTracking01(arr, mark, i + 1, sum, list);
            sum -= list.get(list.size() - 1);
            list.remove(list.size() - 1);

            mark[i] = false;
        }
    }

    public boolean getSumIsZeroList02(int[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        backTracking02(arr, 0, 0, new ArrayList<>());
        return !ret.isEmpty();
    }

    // 去重复
    public void backTracking02(int[] arr, int index, int curSum, List<Integer> list) {
        if (index == arr.length) {
            return;
        }
        if (list.size() > 3) {
            return;
        }
        if (0 == curSum && list.size() == 3) {
            ret.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < arr.length; i++) {
            if (curSum > 0 && list.size() >= 3) {
                break;
            }
           curSum += arr[index];
           list.add(arr[index]);
           backTracking02(arr, i + 1, curSum, list);
           curSum -= list.get(list.size() - 1);
           list.remove(list.size() - 1);
        }
    }



    public static void main(String[] args) {
        ThreeNumberSum threeNumberSum = new ThreeNumberSum();
        int[] arr = new int[] {-1,0,1,2,-1,-4};
//        int[] arr = new int[] {0,1,1};
        boolean isExit = threeNumberSum.getSumIsZeroList02(arr);
        if (isExit) {
            System.out.println(threeNumberSum.ret.toString());
        }
    }

}
