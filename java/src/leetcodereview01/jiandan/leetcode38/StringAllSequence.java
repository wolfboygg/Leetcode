package leetcodereview01.jiandan.leetcode38;

import java.util.ArrayList;
import java.util.Arrays;

public class StringAllSequence {
    public static void main(String[] args) {
        String str = "abc";
        StringAllSequence stringAllSequence = new StringAllSequence();
        stringAllSequence.getAllSequence(str);
    }

    ArrayList<String> ret = new ArrayList<String>();

    private void getAllSequence(String str) {
        char[] array = str.toCharArray();
        Arrays.sort(array);
        backTracking(array, new boolean[array.length], new StringBuilder());
        System.out.println(ret.toString());
    }

    private void backTracking(char[] array, boolean[] marked, StringBuilder str) {
        if (array.length == str.length()) {
            ret.add(str.toString());
        }
        for (int i = 0; i < array.length; i++) {
            if (marked[i]) {
                continue;
            }
            if (i != 0 && !marked[i - 1] && array[i] == array[i - 1]) {
                continue;
            }
            marked[i] = true;
            str.append(array[i]);
            backTracking(array, marked, str);
            str.deleteCharAt(str.length() - 1);
            marked[i] = false;
        }
    }
}
