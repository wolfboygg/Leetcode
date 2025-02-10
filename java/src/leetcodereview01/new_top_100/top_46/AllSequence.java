package leetcodereview01.new_top_100.top_46;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * 所有的排列
 */
public class AllSequence {

    private List<List<Integer>> ret = new ArrayList<>();

    public List<List<Integer>> findAll(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        boolean[] mark = new boolean[arr.length];
        backTracking(arr, mark, new ArrayList<>());
        return ret;
    }

    public void backTracking(int[] arr, boolean[] mark, List<Integer> list) {
        if (list.size() == arr.length) {
            ret.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (mark[i]) {
                // 这里不能使用return 会结束所有的循环的
                continue;
            }
            mark[i] = true;
            list.add(arr[i]);
            backTracking(arr, mark, list);
            list.removeLast();
            mark[i] = false;
        }
    }

    public List<List<Integer>> allSequence01(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        boolean[] mark = new boolean[arr.length];
        backTracking01(arr, mark,  new ArrayList<>());
        return ret;
    }

    public void backTracking01(int[] arr, boolean[] mark, List<Integer> list) {
        if (list.size() == arr.length) {
            ret.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (mark[i]) {
                continue;
            }
            mark[i] = true;
            list.add(arr[i]);
            backTracking01(arr, mark, list);
            list.removeLast();
            mark[i] = false;
        }
    }


    public static void main(String[] args) {
        AllSequence allSequence = new AllSequence();
        int[] arr = new int[] {1, 2, 3};
        List<List<Integer>> result= allSequence.allSequence01(arr);
        System.out.println(result.toString());
    }
}
