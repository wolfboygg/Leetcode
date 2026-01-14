package leetcodereview01.new_top_100.top_56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 合并区间
 */
public class MergeRange {

    public void merge01(int[][] ints) {
        if (ints.length == 0) {
            return;
        }
        Arrays.sort(ints, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < ints.length; i++) {
            int leftValue = ints[i][0];
            int rightValue = ints[i][1];
            if (list.size() == 0 || list.get(list.size() - 1)[1] < leftValue) {
                list.add(ints[i]);
            } else {
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], rightValue);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println("[" + list.get(i)[0] + "," + list.get(i)[1] + "]");
        }
    }

    public void merge02(int[][] matrix) {
        // 合并区间
        if (matrix == null) {
            return;
        }
        Arrays.sort(matrix, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<Integer[]> list = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            int left = matrix[i][0];
            int right = matrix[i][1];
            if (list.isEmpty() || list.get(list.size() - 1)[1] < left) {
                list.add(new Integer[]{matrix[i][0], matrix[i][1]});
            } else {
                list.get(list.size() - 1)[1] = right;
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println("[" + list.get(i)[0] + "," + list.get(i)[1] + "]");
        }
    }

    public static void main(String[] args) {
        MergeRange mergeRange = new MergeRange();
        int[][] ints = new int[][]{
                {1, 2}, {2, 6}, {8, 10}, {15, 18}
        };
        mergeRange.merge02(ints);
    }

}
